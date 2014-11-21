package com.springmvc.RowMapper;

import com.springmvc.Bean.User;
import com.springmvc.Bean.UserImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User u = new UserImpl();
        u.setUsername(rs.getString("username"));
        u.setFirstname(rs.getString("firstname"));
        u.setLastname(rs.getString("lastname"));
        u.setEmail(rs.getString("email"));
        u.setCreated(rs.getDate("created"));

        return u;
    }
}
