package com.springmvc.RowMapper;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeerRowMapper implements RowMapper<Beer> {

    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Beer beer = new BeerImpl();

        beer.setId(rs.getInt("beerID"));
        beer.setName(rs.getString("name"));
        beer.setProcess(rs.getString("process"));


        return beer;
    }



}
