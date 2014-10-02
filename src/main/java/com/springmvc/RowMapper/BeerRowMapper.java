package com.springmvc.RowMapper;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeerRowMapper implements RowMapper<Beer> {

    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Beer beer = new BeerImpl();

        beer.setBeerID(rs.getInt("beerID"));
        beer.setProcess(rs.getString("process"));
        beer.setName(rs.getString("name"));

        return beer;
    }



}
