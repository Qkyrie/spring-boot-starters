package eu.deswaef.spring.auth0.autoconfigure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Auth0AutoConfiguration.class)
public class Auth0AutoConfigurationTest {

    @Autowired
    private Auth0 auth0;

    @Test
    public void auth0getsAutoConfigured() throws Exception {
        assertNotNull(auth0);
    }
}