package ar.edu.unq.desapp.grupoo022020.backenddesappapi.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	//Heroku
    http.requiresChannel()
      .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
      .requiresSecure();
    
    //h2-console
    http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/h2-console/**").permitAll();
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }
  
  @Override
  public void addCorsMappings(CorsRegistry registry) {
      //Permission for frontend
	  registry.addMapping("/**");
  }
}

