package com.morkaragh.dictadmin;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/images/*.png").permitAll()
                        .requestMatchers("/api/**").permitAll());
        http.oauth2Login(Customizer.withDefaults());
        super.configure(http);
//        setLoginView(http, LoginView.class);
    }

//    @Bean
//    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
//        final OidcUserService delegate = new OidcUserService();
//
//        return (userRequest) -> {
//            OidcUser oidcUser = delegate.loadUser(userRequest);
//
//            final Map<String, Object> claims = oidcUser.getClaims();
//            final JSONArray groups = (JSONArray) claims.get("groups");
//
//            final Set<GrantedAuthority> mappedAuthorities = groups.stream()
//                    .map(role -> new SimpleGrantedAuthority(("ROLE_" + role)))
//                    .collect(Collectors.toSet());
//
//            return new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
//        };
//    }

}
