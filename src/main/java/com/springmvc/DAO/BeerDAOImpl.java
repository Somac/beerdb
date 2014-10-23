package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.RowMapper.BeerRowMapper;
import com.springmvc.RowMapper.BeerStyleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BeerDAOImpl implements BeerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<BeerStyle> findAllBeerStyles(){
        String sql = "SELECT styleID, beer_style FROM Beer_style";

        RowMapper<BeerStyle> beerStyleRowMapper = new BeerStyleRowMapper();
        List<BeerStyle> beerStyles = jdbcTemplate.query(sql, beerStyleRowMapper);

        return beerStyles;
    }

    public List<Beer> findAllBeersByStyle(int styleID){
        String sql = "SELECT beerID, name, styleID FROM Beer WHERE styleID = ?";
        Object[] parameters = new Object[]{styleID};

        RowMapper<Beer> beerRowMapper = new BeerRowMapper();

        List<Beer> beers = jdbcTemplate.query(sql, parameters, beerRowMapper);

        return beers;
    }

}
