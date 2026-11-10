package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.ui.theme.LoginError
import com.example.sdgkuandroidtestingch8.ui.theme.LoginResult
import com.example.sdgkuandroidtestingch8.ui.theme.LoginService
import com.example.sdgkuandroidtestingch8.ui.theme.UserRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class LoginServiceTests  {
    private lateinit var service: LoginService

    @Before
    fun setup(){
        val fakeUserStore = FakeUserStore()
        service = LoginService(userStore = fakeUserStore)
    }

    @Test
    fun knownUserWithCorrectPassword_returnsSuccess(){
        val result = service.login("paola@sdgku.edu", "validpassword123")
        assert(result is LoginResult.Success)
    }

    @Test
    fun knownUserWithIncorrectPassword_returnsWrongPassword(){
        val result = service.login("paola@sdgku.edu", "wrongpassword123")
        assert(result is LoginResult.WrongCredentials)
    }

    @Test
    fun emptyEmail_returnsInvalidEmailError(){
        val result = service.login("", "validord123")
        assert(result is LoginResult.Invalid)
        assert((result as LoginResult.Invalid).error == LoginError.EMPTY_EMAIL)
    }

    @Test
    fun invalidEmail_returnsInvalidEmailError(){
        val result = service.login("paolau.edu", "validord123")
        assert(result is LoginResult.Invalid)
        assert((result as LoginResult.Invalid).error == LoginError.INVALID_EMAIL)
    }

    // Tests using Mockito


}

class FakeUserStore : UserRepository {
    private val users =  mapOf(
        "paola@sdgku.edu" to "validpassword123"
    )

    override fun passwordFor(email: String ): String?{
        return users[email]
    }
}