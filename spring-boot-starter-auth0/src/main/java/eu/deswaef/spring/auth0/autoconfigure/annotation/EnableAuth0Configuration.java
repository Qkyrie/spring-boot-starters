package eu.deswaef.spring.auth0.autoconfigure.annotation;

import eu.deswaef.spring.auth0.autoconfigure.Auth0AutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(Auth0AutoConfiguration.class)
public @interface EnableAuth0Configuration {
}
