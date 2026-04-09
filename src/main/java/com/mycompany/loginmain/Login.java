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

 public class Login {
  
    
   //stoe users details
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    //make sure that the user name has an underscore and does not have more than 5 characters
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Boolean: checkPasswordComplexity()
    // Rules: At least 8 chars, a capital letter, a number, and a special character.
    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // 3. Boolean: checkCellPhoneNumber()
    // Ensures correct length and international country code (+27 for South Africa).
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Regex: Starts with +27 followed by exactly 9 digits
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, cellNumber);
    }

    // 4. String registerUser()
    // Returns the status message based on the validation logic.
    public String registerUser(String username, String password, String cell, String fName, String lName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } 
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // If validation passes, "capture" the user info
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.firstName = fName;
        this.lastName = lName;
        
        return "Username and Password successfully captured.";
    }

    // 5. Boolean loginUser()
    // Verifies that entered details match the registered details.
    public boolean loginUser(String enteredUser, String enteredPass) {
        return enteredUser.equals(this.registeredUsername) && enteredPass.equals(this.registeredPassword);
    }

    // 6. String returnLoginStatus()
    // Returns the success or failure message for the login attempt.
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
    
}
