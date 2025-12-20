package org.example.project.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.project.config.ApiConfig
import org.example.project.dto.EventoResponse
import org.example.project.dto.EventoResumidoResponse
import org.example.project.dto.LoginRequest
import org.example.project.dto.LoginResponse
import org.example.project.dto.RegisterRequest

object ApiClient {
    // Configura la URL base según la plataforma
    private val BASE_URL = ApiConfig.baseUrl

    // Variable para almacenar el token JWT
    private var jwtToken: String? = null

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                prettyPrint = true
            })
        }

        // Timeout para evitar peticiones infinitas
        install(HttpTimeout) {
            requestTimeoutMillis = 30000 // 30 segundos
            connectTimeoutMillis = 15000 // 15 segundos
            socketTimeoutMillis = 15000
        }

        // Configuración por defecto de requests
        defaultRequest {
            url(BASE_URL)
            contentType(ContentType.Application.Json)

            // Agregar JWT automáticamente si existe
            jwtToken?.let { token ->
                header("Authorization", "Bearer $token")
            }
        }
    }

    // Guardar el token después del login
    fun setToken(token: String) {
        jwtToken = token
    }

    // Limpiar token al hacer logout
    fun clearToken() {
        jwtToken = null
    }

    // Obtener token actual (útil para debugging)
    fun getToken(): String? = jwtToken

    // REGISTRO
    suspend fun register(request: RegisterRequest): Result<HttpResponse> {
        return try {
            val response = client.post("/register") {
                setBody(request)
            }
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // LOGIN
    suspend fun login(request: LoginRequest): Result<String> {
        return try {
            println("🚀 Intentando login a: http://10.0.2.2:8081/api/authenticate")
            println("📦 Request body: ${Json.encodeToString(request)}")

            val response: HttpResponse = client.post {
                url("http://10.0.2.2:8081/api/authenticate")
                contentType(ContentType.Application.Json)
                setBody(request)
            }

            println("📡 Status code: ${response.status.value}")

            if (response.status.value in 200..299) {
                // ✅ Deja que Ktor deserialice automáticamente
                val loginResponse: LoginResponse = response.body()

                setToken(loginResponse.jwt)
                println("✅ Login exitoso!")
                println("📝 JWT guardado: ${loginResponse.jwt.take(30)}...")

                Result.success(loginResponse.jwt)
            } else {
                val errorBody = response.bodyAsText()
                println("❌ Error: ${response.status} - $errorBody")
                Result.failure(Exception("Error ${response.status.value}: $errorBody"))
            }
        } catch (e: Exception) {
            println("💥 Excepción: ${e::class.simpleName} - ${e.message}")
            e.printStackTrace()
            Result.failure(e)
        }
    }

    // OBTENER EVENTOS RESUMIDOS
    suspend fun getEventsResumido(): Result<List<EventoResumidoResponse>> {
        return try {
            val events: List<EventoResumidoResponse> =
                client.get("/v1/service/eventos-resumidos").body()
            Result.success(events)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // OBTENER EVENTOS COMPLETOS
    suspend fun getEvents(): Result<List<EventoResponse>> {
        return try {
            val events: List<EventoResponse> =
                client.get("/v1/service/eventos").body()
            Result.success(events)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // OBTENER EVENTO POR ID
    suspend fun getEventById(id: Long): Result<EventoResponse> {
        return try {
            val event: EventoResponse =
                client.get("/v1/service/eventos/$id").body()
            Result.success(event)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Cerrar cliente (llamar cuando la app se cierre)
    fun close() {
        client.close()
    }
}