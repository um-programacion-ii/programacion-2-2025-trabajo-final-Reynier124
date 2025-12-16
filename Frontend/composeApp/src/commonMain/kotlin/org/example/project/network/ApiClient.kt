package org.example.project.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.project.dto.EventoResumidoResponse
import org.example.project.dto.LoginRequest
import org.example.project.dto.LoginResponse
import org.example.project.dto.RegisterRequest

object ApiClient {
    private val client = HttpClient{
        install(ContentNegotiation) {
            json(
                Json {
                ignoreUnknownKeys = true
                    isLenient = true
            })
        }

    }

    suspend fun register(request: RegisterRequest): HttpResponse {
        return client.post("http://localhost:8081/api/register"){
            contentType(ContentType.Application.Json)
            setBody(request)
        }
    }

    suspend fun login(request: LoginRequest): String {
        val response: LoginResponse =
            client.post("http://localhost:8081/api/authenticate") {
                contentType(io.ktor.http.ContentType.Application.Json)
                setBody(request)
            }.body()

        return response.jwt
    }

    suspend fun getEventsResumido(): List<EventoResumidoResponse>{
        return client.get("http://localhost:8081/api/v1/service/eventos-resumidos").body()
    }

    suspend fun getEvents(): List<EventoResumidoResponse>{
        return client.get("http://localhost:8081/api/v1/service/eventos").body()
    }

    suspend fun getEventById(id: Long): EventoResumidoResponse {
        return client.get("http://localhost:8081/api/v1/service/eventos/$id").body()
    }

}