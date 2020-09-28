package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.BackendDesappApiApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BackendDesappApiApplication.class);
    }

}
