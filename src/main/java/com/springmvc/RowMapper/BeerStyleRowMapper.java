package com.springmvc.RowMapper;

import com.springmvc.Bean.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BeerStyleRowMapper implements RowMapper<BeerStyle>{

    public BeerStyle mapRow(ResultSet rs, int rowNum) throws SQLException {

        BeerStyle bs = new BeerStyleImpl();
        bs.setId(rs.getInt("styleID"));
        bs.setBeerStyle(rs.getString("beer_style"));
        return bs;
    }

}
