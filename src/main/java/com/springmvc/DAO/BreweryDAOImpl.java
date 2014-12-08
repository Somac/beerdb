package com.springmvc.DAO;


import com.springmvc.Bean.Brewery;
import com.springmvc.RowMapper.BreweryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BreweryDAOImpl implements BreweryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Brewery> findAllBrewerys(){

        String sql = "SELECT breweryID, brewery_name FROM Brewery ORDER BY brewery_name";

        RowMapper<Brewery> breweryRowMapper = new BreweryRowMapper();
        List<Brewery> breweryList = jdbcTemplate.query(sql, breweryRowMapper);

        return breweryList;
    }


}
