package com.springmvc.Service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean checkIfUsernameAlreadyExists(String username);
    boolean checkIfEmailAlreadyExists(String email);

}
