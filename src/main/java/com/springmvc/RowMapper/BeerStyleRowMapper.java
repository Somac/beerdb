package com.springmvc.RowMapper;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.Bean.BeerStyleImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BeerStyleRowMapper implements RowMapper<BeerStyle>{

    public BeerStyle mapRow(ResultSet rs, int rowNum) throws SQLException {
        BeerStyle beerStyle = new BeerStyleImpl();

        beerStyle.setId(rs.getInt("styleID"));
        beerStyle.setBeerStyle(rs.getString("beer_style"));

        return beerStyle;
    }

}
