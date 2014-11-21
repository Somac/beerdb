package com.springmvc.DAO;


import com.springmvc.Bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDAO {

    public void saveUser(User user);
    public List<User> findAllUsers();
    public List<User> findUsersByUsernameOrEmail(String username, String email);

}
