package com.eileen.logic;

import com.eileen.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("Test")
public class ApplicationTest {

    @Autowired
    Application application;

    @Test
    public void contextLoads() throws Exception{
        assertThat(application).isNotNull();
    }
}
