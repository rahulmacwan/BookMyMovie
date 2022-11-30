package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.IUserModel;
import com.Group9.BookMyMovie.Model.UserModel;
import com.Group9.BookMyMovie.Model.UserResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class LoginTests {
    @Mock
    UserModel userModel;
    IUserModel user;

    public LoginTests() {
    }

    @Before
    public void setUp() {

        user = mock(UserModel.class);

    }
    
    @Test
    public void userNull() {
    	UserModel user = null;
    	
    	assertNull(user);
    }

    @Test
    public void userLoginPositive() {

        UserResponse response = new UserResponse();
        response.setResponseStatus(true);
        when(user.userLogin("tushar@world.ca", "azx")).thenReturn(response);
        assertEquals(true, user.userLogin("tushar@world.ca", "azx").isResponseStatus());

    }

    @Test
    public void userLoginNegative() {
        UserResponse response = new UserResponse();
        response.setResponseStatus(false);
        when(user.userLogin("tushar@world.ca", "ayyz")).thenReturn(response);
        user.userLogin("tushar@world.ca", "ayyz").setResponseStatus(false);
        assertEquals(false, user.userLogin("tushar@world.ca", "ayyz").isResponseStatus());

    }
}
    
