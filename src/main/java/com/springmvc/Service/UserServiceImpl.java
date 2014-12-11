package com.springmvc.Service;


import com.springmvc.Bean.User;
import com.springmvc.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private User user;

    public boolean checkIfUsernameAlreadyExists(String username){

        try{
            user = userDAO.findUserByUsername(username);
                return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }

    public boolean checkIfEmailAlreadyExists(String email){

        try{
            user = userDAO.findUserByEmail(email);
               return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }


}
