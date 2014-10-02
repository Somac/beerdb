package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.RowMapper.BeerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeerDAOImpl implements BeerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Beer> findAllBeers(){

        String sql = "SELECT beerID, process, name FROM Beer";
        RowMapper<Beer> beerRowMapper = new BeerRowMapper();
        List<Beer> beers = jdbcTemplate.query(sql, beerRowMapper);

        return beers;
    }




}
