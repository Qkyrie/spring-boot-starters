package eu.deswaef.spring.auth0.autoconfigure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Auth0AutoConfiguration.class)
@EnableAutoConfiguration
public class Auth0AutoConfigurationTest {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private Auth0 auth0;

    @Test
    public void auth0getsAutoConfigured() throws Exception {
        assertNotNull(auth0);
    }
}