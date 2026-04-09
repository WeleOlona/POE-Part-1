/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.loginmain.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */

public class loginUnitTest {
   

    Login login = new Login();

    @Test
    public void testUsernameFormat() {
        //  "kyl_1" should be true
        assertTrue(login.checkUserName("kyl_1"));
        
        // "kyle!!!!!!" should be false
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordComplexity() {
        // Test Data: "Ch&&sec@ke99!" should be true
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
}

