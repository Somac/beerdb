package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeerRowMapper implements RowMapper<Beer> {

    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Beer b = new BeerImpl();
        b.setId(rs.getInt("beerID"));
        b.setName(rs.getString("name"));
        b.setProcess(rs.getString("process"));
        b.setBreweryID(rs.getInt("breweryID"));
        b.setStyleID(rs.getInt("styleID"));

        return b;
    }



}
