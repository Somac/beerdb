package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * This RowMapper is used by BeerDAO.findAllBeerStyles() for gathering data to menu's column two and
 * BeerDAO.findBeerByName for checking if posted beer already exists in the db.
 */

public class BeerRowMapper implements RowMapper<Beer> {

    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Beer b = new Beer();
        b.setId(rs.getInt("beerID"));
        b.setName(rs.getString("name"));
        b.setDescription(rs.getString("description"));
        b.setAlcohol(rs.getDouble("alcohol"));
        b.setCreated(rs.getDate("created"));

        Brewery brewery = new Brewery();
        brewery.setId(rs.getInt("breweryID"));

        BeerStyle beerStyle = new BeerStyle();
        beerStyle.setId(rs.getInt("styleID"));

        b.setBrewery(brewery);
        b.setBeerStyle(beerStyle);

        return b;
    }
}
