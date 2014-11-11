package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
This RowMapper is only used by BeerDAO.findBeerBreweryUploaderByID for gathering data to menu's column three
where all the information about chosen beer is shown.
*/
public class BeerUploaderBreweryRowMapper implements RowMapper<Beer>{

        public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {

            Beer beer = new BeerImpl();
            beer.setId(rs.getInt("beerID"));
            beer.setName(rs.getString("name"));
            beer.setProcess(rs.getString("process"));

            //Brewery of the beer
            Brewery brewery = new BreweryImpl();
            brewery.setId(rs.getInt("breweryID"));
            brewery.setName(rs.getString("brewery_name"));

            //Home country of brewery
            Country country = new CountryImpl();
            country.setId(rs.getInt("countryID"));
            country.setCountry(rs.getString("country"));

            //User is a uploader of the beer
            User uploader = new UserImpl();
            uploader.setUserID(rs.getInt("userID"));
            uploader.setUsername(rs.getString("username"));
            uploader.setFirstname(rs.getString("firstname"));
            uploader.setLastname(rs.getString("lastname"));
            uploader.setEmail(rs.getString("email"));
            uploader.setCreated(rs.getDate("created"));

            //Sub-objects to Beer object
            brewery.setCountry(country);

            beer.setBrewery(brewery);
            beer.setUser(uploader);

            return beer;
        }
    }