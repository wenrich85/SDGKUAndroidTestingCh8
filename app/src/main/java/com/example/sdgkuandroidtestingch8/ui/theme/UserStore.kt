package com.example.sdgkuandroidtestingch8.ui.theme

interface UserRepository {
    fun passwordFor(email: String): String?
}
class UserStore : UserRepository {
    private val users = mapOf(
        "daniel.moreno@sdgku.edu" to "validpassword123"
    )

    override fun passwordFor(email: String): String? {
        return users[email]
    }
}