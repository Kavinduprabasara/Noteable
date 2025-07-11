package com.example.stm.Routes

import androidx.compose.ui.graphics.vector.ImageVector

object Routes :List<Route>{
    var Login = "Login"
    var SignUp = "SignUp"
    var Home = "Home"

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun get(index: Int): Route {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Route> {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<Route> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<Route> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Route> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: Route): Int {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: Route): Int {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Route>): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: Route): Boolean {
        TODO("Not yet implemented")
    }
}

enum class Route(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String = ""
)