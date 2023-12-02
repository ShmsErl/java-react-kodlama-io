package com.example.javareactkamp.service.concretes;

import com.example.javareactkamp.dto.userdto.request.AddUserRequest;
import com.example.javareactkamp.dto.userdto.request.UpdateUserRequest;
import com.example.javareactkamp.dto.userdto.response.GetAllUserResponse;
import com.example.javareactkamp.dto.userdto.response.GetUserResponse;
import com.example.javareactkamp.exception.ProductNotFoundException;
import com.example.javareactkamp.mapper.MapperService;
import com.example.javareactkamp.model.User;
import com.example.javareactkamp.repository.UserRepository;
import com.example.javareactkamp.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final MapperService mapperService;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetAllUserResponse> responses = new ArrayList<>();
        for (User user : users) {

            GetAllUserResponse response = this.mapperService
                    .forResponse()
                    .map(user, GetAllUserResponse.class);

            responses.add(response);
        }


        return responses;
    }

    @Override
    public GetUserResponse findByemail(String email) {

        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new ProductNotFoundException("User not found: " + email));


        return this.mapperService.forResponse().map(user, GetUserResponse.class);
    }

    @Override
    public String addUser(AddUserRequest request) {

        User user = this.mapperService.forRequest().map(request, User.class);

        this.userRepository.save(user);

        return "Transaction Successfull";
    }

    @Override
    public String updateUser(UpdateUserRequest request) {
        User user = this.userRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException("User Not Found"));
        user = this.mapperService.forRequest().map(request, User.class);
        this.userRepository.save(user);

        return "Transaction Successfull";
    }

    @Override
    public String deleteUser(int id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User Not Found"));
        this.userRepository.deleteById(id);
        return "Transaction Successfull";
    }
}
