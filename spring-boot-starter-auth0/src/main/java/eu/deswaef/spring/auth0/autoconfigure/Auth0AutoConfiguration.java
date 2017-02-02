package eu.deswaef.spring.auth0.autoconfigure;

import com.auth0.web.Auth0Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Auth0Config.class)
@ConditionalOnProperty(name = "auth0.enabled", matchIfMissing = true)
public class Auth0AutoConfiguration {

    @ConditionalOnMissingBean(Auth0.class)
    @Bean
    public Auth0 provideAuth0(Auth0Config auth0Config) {
        return new Auth0(auth0Config);
    }

}
