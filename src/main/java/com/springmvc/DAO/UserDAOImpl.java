package com.springmvc.DAO;

import com.springmvc.Bean.User;
import com.springmvc.RowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false)
    public void saveUser(User user){
        String sql = "INSERT INTO User(username, password, firstname, lastname, email) VALUES (?,?,?,?,?)";
        String sql2 = "INSERT INTO User_authority(userID) VALUES (LAST_INSERT_ID())";

        Object[] parameters = new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        };


        jdbcTemplate.update(sql, parameters);
        jdbcTemplate.update(sql2);
    }


    public List<User> findAllUsers(){

        String sql = "SELECT userID, username, firstname, lastname, email, created FROM User";

        RowMapper<User> userRowMapper = new UserRowMapper();

        List<User> users = jdbcTemplate.query(sql, userRowMapper);

        return users;
    }

    public User findUserByUsername(String username) throws EmptyResultDataAccessException{

        String sql = "SELECT userID, username, firstname, lastname, email, created FROM User WHERE username=?";

        Object[] parameters = new Object[]{username};
        RowMapper<User> userRowMapper = new UserRowMapper();

        User u = jdbcTemplate.queryForObject(sql, parameters, userRowMapper);

        return u;
    }

    public User findUserByEmail(String email) throws EmptyResultDataAccessException{

        String sql = "SELECT username, firstname, lastname, email, created FROM User WHERE email=?";

        Object[] parameters = new Object[]{email};
        RowMapper<User> userRowMapper = new UserRowMapper();

        User u  = jdbcTemplate.queryForObject(sql, parameters, userRowMapper);

        return u;
    }
}
