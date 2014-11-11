package com.springmvc.DAO;

import com.springmvc.Bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false)
    public void saveUser(User user){
        String sql = "INSERT INTO User(username, firstname, lastname, email, password, salt) VALUES (?,?,?,?,?,?)";
        String sql2 = "INSERT INTO User_authority(userID) VALUES (LAST_INSERT_ID())";

        Object[] parameters = new Object[]{
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getSalt()
        };


        jdbcTemplate.update(sql, parameters);
        jdbcTemplate.update(sql2);
    }

}
