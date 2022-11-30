package com.Group9.BookMyMovie.Configuration;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class DBConfiguration implements EnvironmentAware {

    private static String url;

    private static String username;

    private static String password;

    public DBConfiguration() {

    }

    public static String getUrl() {
        return url;
    }

    private static void setUrl(String url) {
        DBConfiguration.url = url;
    }

    public static String getUsername() {
        return username;
    }

    private static void setUsername(String username) {
        DBConfiguration.username = username;
    }

    public static String getPassword() {
        return password;
    }

    private static void setPassword(String password) {
        DBConfiguration.password = password;
    }


    @Override
    public void setEnvironment(Environment environment) {

        String url = environment.getProperty("spring.datasource.url");
        setUrl(url);
        String username = environment.getProperty("spring.datasource.username");
        setUsername(username);
        String password = environment.getProperty("spring.datasource.password");
        setPassword(password);

    }


}
