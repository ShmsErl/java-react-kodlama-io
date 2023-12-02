package com.example.javareactkamp.service.abstracts;

import com.example.javareactkamp.dto.userdto.request.AddUserRequest;
import com.example.javareactkamp.dto.userdto.request.UpdateUserRequest;
import com.example.javareactkamp.dto.userdto.response.GetAllUserResponse;
import com.example.javareactkamp.dto.userdto.response.GetUserResponse;
import com.example.javareactkamp.model.User;

import java.util.List;

public interface UserService {
    List<GetAllUserResponse> getAll();

    GetUserResponse findByemail(String email);

    String addUser(AddUserRequest request);

    String updateUser(UpdateUserRequest request);

    String deleteUser(int id);
}
