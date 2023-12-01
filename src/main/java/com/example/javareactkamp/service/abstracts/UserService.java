package com.example.javareactkamp.service.abstracts;

import com.example.javareactkamp.model.User;

public interface UserService {
    User findByemail(String email);

    String addUser()
}
