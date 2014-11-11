package com.springmvc.Bean;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface User {

    public int getUserID();
    public void setUserID(int userID);

    public String getUsername();
    public void setUsername(String username);

    public String getFirstname();
    public void setFirstname(String firstname);

    public String getLastname();
    public void setLastname(String lastname);

    public String getEmail();
    public void setEmail(String email);

    public String getPassword();
    public void setPassword(String password);

    public String getSalt();
    public void setSalt(String salt);

    public Date getCreated();
    public void setCreated(Date created);

}
