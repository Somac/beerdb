package com.springmvc.ControllerTest.Controller;

import com.springmvc.Bean.User;
import com.springmvc.DAO.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class LoginControllerTest {

    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected UserDAO userDAO;

    @Autowired
    @Qualifier("encoder")
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void indexPage_shouldDirectToIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void signUpFormSubmit_shouldSaveUserToDB(){

        User user = new User();
        user.setUsername("JohnUnknown");
        user.setPassword(passwordEncoder.encode("IntegrationTest"));
        user.setFirstname("John");
        user.setLastname("Unknown");
        user.setEmail("john@unknown.com");

        userDAO.saveUser(user);

        user = userDAO.findUserByUsername("JohnUnknown");

        Assert.assertEquals("JohnUnknown", user.getUsername());
        Assert.assertNotEquals("IntegrationTest", user.getPassword());
        Assert.assertEquals("John", user.getFirstname());
        Assert.assertEquals("Unknown", user.getLastname());
        Assert.assertEquals("john@unknown.com", user.getEmail());

    }
}

