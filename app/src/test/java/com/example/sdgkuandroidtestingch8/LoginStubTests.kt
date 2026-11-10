package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.ui.theme.LoginResult
import com.example.sdgkuandroidtestingch8.ui.theme.LoginService
import com.example.sdgkuandroidtestingch8.ui.theme.UserRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class LoginStubTests {
    @Test
    fun loginWithWrongPassword_returnsWronCredentials(){
        val repo = mock<UserRepository>()
        whenever(repo.passwordFor("wronguser@sd.edu")).thenReturn(null)
        val service = LoginService(userStore=repo)
        val result = service.login("wronguser@sd.edu", "wrongpassword")
        assertEquals(LoginResult.WrongCredentials, result)
    }

    @Test
    fun login_withWrongUser_returnsWrongCredentials(){
        val repo = mock<UserRepository>()
        whenever(repo.passwordFor("daniel@sd.edu")).thenReturn("validpasswword123")
        val service = LoginService(userStore=repo)
        val result = service.login("jgjgj@.sksk", "validpasswword123")
        assertEquals(LoginResult.WrongCredentials, result)
    }
}