package com.springmvc.DAO;


import com.springmvc.Bean.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDAO {

    public void saveUser(User user);
    public List<User> findAllUsers();

    public User findUserByUsername(String username) throws EmptyResultDataAccessException;
    public User findUserByEmail(String email) throws EmptyResultDataAccessException;

}
