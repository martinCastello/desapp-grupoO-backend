package ar.edu.unq.desapp.grupoo022020.backenddesappapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.JwtAuthorizationFilter;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.MyUserDetailService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

	@Configuration
	@Order(2)
	public class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		
		@Value("${auth0.audience}")
		private String audience;
			
		@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
		private String issuer;

		@Bean
		JwtDecoder jwtDecoder() {
			NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
              JwtDecoders.fromOidcIssuerLocation(issuer);

	      OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
	      OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
	      OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

	      jwtDecoder.setJwtValidator(withAudience);

	      return jwtDecoder;
		}  
	
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests() 
              .mvcMatchers("/login").permitAll()
              .anyRequest().authenticated()
              .and().cors()
              .and().oauth2ResourceServer().jwt();
		}
	}
	
	
	@Configuration
	@Order(1)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		private MyUserDetailService myUserDetailService;
		
		@Autowired
	    private JwtAuthorizationFilter jwtAuthorizationFilter;
		
		@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(myUserDetailService);
	    }
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
//		Heroku
			http.requiresChannel()
			  .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
			  .requiresSecure();
			  
			//h2-console
			http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security", "/swagger-ui/**","/swagger-ui/index.html", "/webjars/**").permitAll();
			http.csrf().disable()
			  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			  .and()
			  .authorizeRequests()
			  .antMatchers("/login").permitAll()
			  .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			  .antMatchers(HttpMethod.POST, "/**").permitAll()
			  .anyRequest().authenticated()
			  .and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
			 http.headers().frameOptions().disable();
		}
		
		@Bean
		public PasswordEncoder getPasswordEncoder() {
	      return NoOpPasswordEncoder.getInstance();
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
	      return super.authenticationManagerBean();
		}
	}
	
  
  @Override
  public void addCorsMappings(CorsRegistry registry) {
      //Permission for frontend
	  registry.addMapping("/**");
  }
  
  
}

