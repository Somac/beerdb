package com.springmvc.DAO;

/*
 Enum for dynamically made SQL querys.
 */

public enum SQLQuery {

    USER_NAME("username"),
    EMAIL("email");

    private String clause;

    private SQLQuery(String clause){
        this.clause = clause;
    }

    public String getClause(){
        return this.clause;
    }

}
