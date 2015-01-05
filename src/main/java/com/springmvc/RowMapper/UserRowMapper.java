package com.springmvc.RowMapper;

import com.springmvc.Bean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User u = new User();
        u.setId(rs.getInt("userID"));
        u.setPassword(rs.getString("password"));
        u.setUsername(rs.getString("username"));
        u.setFirstname(rs.getString("firstname"));
        u.setLastname(rs.getString("lastname"));
        u.setEmail(rs.getString("email"));
        u.setCreated(rs.getDate("created"));

        return u;
    }
}
