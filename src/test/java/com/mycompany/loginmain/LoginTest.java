package com.mycompany.loginmain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testCheckUserName_CorrectFormat() {       
        assertTrue(login.checkUserName("kyl_1"), "Username should be valid (contains _ and <= 5 chars)");
    }

    @Test
    public void testCheckUserName_IncorrectFormat() {       
        assertFalse(login.checkUserName("kyline"), "Should fail: No underscore");
        assertFalse(login.checkUserName("kyl_longname"), "Should fail: Too long");
    }

    @Test
    public void testCheckPasswordComplexity_Success() {       
        assertTrue(login.checkPasswordComplexity("Ch@tt3rbox"), "Password should meet complexity requirements");
    }

    @Test
    public void testCheckPasswordComplexity_Failure() {        
        assertFalse(login.checkPasswordComplexity("password123!"), "Should fail: No uppercase letter");      
        assertFalse(login.checkPasswordComplexity("Password123"), "Should fail: No special character");       
        assertFalse(login.checkPasswordComplexity("P1@ss"), "Should fail: Too short");
    }

    @Test
    public void testRegisterUser_Success() {
        String result = login.registerUser("kyl_1", "Ch@tt3rbox", "+27838968976", "John", "Doe");
        assertEquals("Successfully captured Username and Password.", result);
    }

    @Test
    public void testLoginUser_Success() {        
        login.registerUser("kyl_1", "Ch@tt3rbox", "+27838968976", "John", "Doe");       
        boolean status = login.loginUser("kyl_1", "Ch@tt3rbox");
        assertTrue(status, "Login should succeed with correct credentials");
    }

    @Test
    public void testLoginUser_Failure() {      
        login.registerUser("kyl_1", "Ch@tt3rbox", "+27838968976", "John", "Doe");      
        boolean status = login.loginUser("kyl_1", "WrongPass!");
        assertFalse(status, "Login should fail with incorrect password");
    }

    @Test
    public void testReturnLoginStatus_Success() {       
        login.registerUser("kyl_1", "Ch@tt3rbox", "+27838968976", "John", "Doe");        
        String expected = "Welcome John, Doe it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus(true));
    }
}