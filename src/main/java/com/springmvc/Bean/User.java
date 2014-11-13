package com.springmvc.Bean;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface User {

    int getUserID();
    void setUserID(int userID);

    String getUsername();
    void setUsername(String username);

    String getFirstname();
    void setFirstname(String firstname);

    String getLastname();
    void setLastname(String lastname);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    String getSalt();
    void setSalt(String salt);

    Date getCreated();
    void setCreated(Date created);

}
