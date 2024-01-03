package com.example.springapp.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password) {
        boolean inValidUserName = name.equalsIgnoreCase("abc");
        boolean inValidUserPassword = password.equalsIgnoreCase("abc");

        return inValidUserName && inValidUserPassword;
    }


}
