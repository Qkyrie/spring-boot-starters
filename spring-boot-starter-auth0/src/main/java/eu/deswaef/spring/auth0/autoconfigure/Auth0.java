package eu.deswaef.spring.auth0.autoconfigure;

import com.auth0.Auth0User;
import com.auth0.Tokens;
import com.auth0.authentication.AuthenticationAPIClient;
import com.auth0.authentication.result.Credentials;
import com.auth0.authentication.result.UserProfile;
import com.auth0.web.Auth0Config;
import org.apache.commons.lang3.Validate;

import javax.annotation.PostConstruct;

public class Auth0 {

    private AuthenticationAPIClient authenticationAPIClient;

    private Auth0Config auth0Config;

    public Auth0(final Auth0Config auth0Config) {
        this.auth0Config = auth0Config;

    }

    @PostConstruct
    public void init() {
        Validate.notNull(this.auth0Config.getClientId(), "auth0.clientId should not be empty");
        Validate.notNull(this.auth0Config.getClientSecret(), "auth0.clientSecret should not be empty");
        Validate.notNull(this.auth0Config.getDomain(), "auth0.domain should not be empty");
        final com.auth0.Auth0 auth0 = new com.auth0.Auth0(this.auth0Config.getClientId(), this.auth0Config.getClientSecret(), this.auth0Config.getClientId());
        this.authenticationAPIClient = new AuthenticationAPIClient(auth0);
    }

    public Tokens getTokens(final String authorizationCode, final String redirectUri) {
        Validate.notNull(authorizationCode);
        Validate.notNull(redirectUri);
        final Credentials creds = authenticationAPIClient
                .token(authorizationCode, redirectUri)
                .setClientSecret(auth0Config.getClientSecret()).execute();
        return new Tokens(creds.getIdToken(), creds.getAccessToken(), creds.getType(), creds.getRefreshToken());
    }

    public Auth0User getUserProfile(final Tokens tokens) {
        Validate.notNull(tokens);
        final String idToken = tokens.getIdToken();
        final UserProfile userProfile = authenticationAPIClient.tokenInfo(idToken).execute();
        return new Auth0User(userProfile);
    }


}
