package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//This RowMapper is only used by BeerDAO.findAllBeerStyles for gathering data to menu's column one.
public class BeerStyleRowMapper implements RowMapper<BeerStyle>{

    public BeerStyle mapRow(ResultSet rs, int rowNum) throws SQLException {

        BeerStyle bs = new BeerStyle();
        bs.setId(rs.getInt("styleID"));
        bs.setName(rs.getString("beer_style"));
        return bs;
    }

}
