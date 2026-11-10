package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.ui.theme.LoginService
import com.example.sdgkuandroidtestingch8.ui.theme.UserRepository
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

//
class LoginMockTests {
    @Test
    fun invalidEmail_neverCallsUserRepository(){
        val repo= mock<UserRepository>()
        val service = LoginService(repo)

        service.login("notanemail", "password")
        verify(repo, never()).passwordFor(any())
        verifyNoInteractions(repo)
    }

    @Test
    fun validAttempt_looksUpOnce_withTrimmedEmail(){
        val repo = mock<UserRepository>()
        whenever(repo.passwordFor("daniel@sd.edu")).thenReturn( "validpassword123" )
        val service = LoginService(repo)
        service.login("daniel@sd.edu", "validpassword123")

        verify(repo, times(1)).passwordFor("daniel@sd.edu")
        verifyNoMoreInteractions(repo)

    }
}