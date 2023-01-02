package it.app2.config;
import it.app2.components.JWTAuthenticationProvider;
import it.app2.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class ProjectConfigSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private JWTAuthenticationProvider jwtAuthentication;
	
	private JwtAuthenticationFilter authenticationFilter() throws Exception{
		return new JwtAuthenticationFilter(getAuthenticationManager());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(jwtAuthentication);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic().disable()
        .csrf().disable()
        .cors();
		http.addFilterBefore(authenticationFilter(), BasicAuthenticationFilter.class).authorizeRequests()
		.antMatchers("/user/create").hasAuthority("Admin")
		.antMatchers("/user/update").hasAuthority("Admin")
		.antMatchers("/user/delete").hasAuthority("Admin")
		.antMatchers("/user/findById/*").hasAnyAuthority("Client","Admin").and().csrf().disable().httpBasic().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}
}
