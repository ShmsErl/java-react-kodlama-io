package com.example.javareactkamp.dto.userdto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

    private String email;
    private String password;
}
