package com.springmvc.Service;


import com.springmvc.Bean.User;
import com.springmvc.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean checkIfUsernameOrEmailAlreadyExists(String username, String email){

       List<User> users = userDAO.findUsersByUsernameOrEmail(username, email);

        if(!users.isEmpty()){
            return true;
        }
       return false;
    }


}
