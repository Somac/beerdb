package com.springmvc.DAO;

import com.springmvc.Bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveUser(User user){
        String sql = "INSERT INTO User(username, firstname, lastname, email, password, salt) VALUES (?,?,?,?,?,?)";

        Object[] parameters = new Object[]{
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getSalt()
        };


        jdbcTemplate.update(sql, parameters);
    }

}
