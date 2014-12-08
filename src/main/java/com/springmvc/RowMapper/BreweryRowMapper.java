package com.springmvc.RowMapper;


import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BreweryRowMapper implements RowMapper<Brewery> {
    public Brewery mapRow(ResultSet rs, int rowNum) throws SQLException {

        Brewery b = new Brewery();
        b.setId(rs.getInt("breweryID"));
        b.setName(rs.getString("brewery_name"));

        return b;
    }
}
