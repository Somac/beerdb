package com.springmvc.Bean;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface User {

    int getId();
    void setId(int id);

    String getUsername();
    void setUsername(String username);

    String getPassword();
    void setPassword(String password);

    boolean isEnabled();
    void setEnabled(boolean enabled);

    String getFirstname();
    void setFirstname(String firstname);

    String getLastname();
    void setLastname(String lastname);

    String getEmail();
    void setEmail(String email);

    Date getCreated();
    void setCreated(Date created);
}
