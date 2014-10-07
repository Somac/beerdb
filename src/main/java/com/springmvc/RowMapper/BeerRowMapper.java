package com.springmvc.RowMapper;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.RawMaterial;
import com.springmvc.Bean.RawMaterialImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeerRowMapper implements RowMapper<Beer> {

    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Beer b = null;

        while(rs.next()){
            if(b==null){

              b = new BeerImpl();

              b.setId(rs.getInt("beerID"));
              b.setName(rs.getString("name"));
              b.setProcess(rs.getString("process"));

            }
            RawMaterial rm = new RawMaterialImpl();
            rm.setId(rs.getInt("raw_materialID"));
            rm.setRawMaterial(rs.getString("raw_material"));

            b.addRawMaterial(rm);
            System.out.println("DAO: " + rs.getString("raw_material"));

        }
        return b;
    }



}
