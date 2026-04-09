/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginmain;

/**
 *
 * @author lab_services_student
 */
 import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class LoginClass {
   

public class Login {
    
   //store users details
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    
    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

  
    public boolean checkCellPhoneNumber(String cellNumber) {
       
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, cellNumber);
    }

    
    public String registerUser(String username, String password, String cell, String fName, String lName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } 
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
       
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.firstName = fName;
        this.lastName = lName;
        
        return "Username and Password successfully captured.";
    }

    
    public boolean loginUser(String enteredUser, String enteredPass) {
        return enteredUser.equals(this.registeredUsername) && enteredPass.equals(this.registeredPassword);
    }

    
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
    
}
