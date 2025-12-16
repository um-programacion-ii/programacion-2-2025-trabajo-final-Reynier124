package org.example.project.navigation

import org.example.project.ui.EventListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.EVENTS
    ) {

        composable(Routes.EVENTS) {
            EventListScreen(
                onEventClick = { eventId ->
                    navController.navigate("${Routes.EVENT_DETAIL}/$eventId")
                }
            )
        }

        composable(
            route = "${Routes.EVENT_DETAIL}/{eventId}",
            arguments = listOf(navArgument("eventId") {
                type = NavType.LongType
            })
        ) { backStackEntry ->

            val eventId =
                backStackEntry.arguments?.getLong("eventId") ?: return@composable

            EventDetailScreen(
                eventId = eventId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}