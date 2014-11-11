package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//This RowMapper is only used by BeerDAO.findAllBeerStyles for gathering data to menu's column two.
public class BeerRowMapper implements RowMapper<Beer> {

    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Beer b = new BeerImpl();
        b.setId(rs.getInt("beerID"));
        b.setName(rs.getString("name"));
        b.setProcess(rs.getString("process"));

        Brewery brewery = new BreweryImpl();
        brewery.setId(rs.getInt("breweryID"));

        BeerStyle beerStyle = new BeerStyleImpl();
        beerStyle.setId(rs.getInt("styleID"));

        b.setBrewery(brewery);
        b.setBeerStyle(beerStyle);

        return b;
    }



}
