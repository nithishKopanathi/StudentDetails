package com.studentdetails.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class StudentSecurityConfig {
	
	//Authentication  the user
	
	/*@Bean
	public InMemoryUserDetailsManager userDetails() {
		UserDetails ram = User.builder()
				               .username("ram")
				               .password("{noop}ram")
				               .roles("student")
				               .build();
		UserDetails ramesh = User.builder()
				                 .username("ramesh")
				                 .password("{noop}ramesh")
				                 .roles("Teacher")
			                 .build();
		UserDetails suresh = User.builder()
				                 .username("suresh")
				                 .password("{noop}suresh")
				                 .roles("Principle","Teacher")
				                 .build();
		return new InMemoryUserDetailsManager(ram,ramesh,suresh);
		
}*/
	
	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }
	
	
	//Authorization the user
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer->
		configurer
		          .requestMatchers(HttpMethod.GET ,"student/get/**").hasRole("STUDENT")
		          .requestMatchers(HttpMethod.GET ,"student/get/**").hasRole("TEACHER")
		          .requestMatchers(HttpMethod.POST,"student/post").hasRole("TEACHER")
		          .requestMatchers(HttpMethod.PUT ,"student/put").hasRole("PRINCIPLE")
		          .requestMatchers(HttpMethod.DELETE ,"student/delete/**").hasRole("PRINCIPLE")
				);
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf->csrf.disable());
		return http.build();
		
	}

}
