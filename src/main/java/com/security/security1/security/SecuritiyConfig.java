package com.security.security1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuritiyConfig {

	// @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	// Exception {
	// http.authorizeHttpRequests()
	// .requestMatchers("/").permitAll()
	// .requestMatchers("/api/posts/**").hasRole("ADMIN")
	// .anyRequest().authenticated()
	// .and()
	// .csrf().disable()
	// .httpBasic();
	// return http.build();
	// }

	// /** Lambda modszer, ugyan az mint a fenti
	// // *
	// public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws
	// Exception {
	// http.authorizeHttpRequests(authorize -> authorize
	// .requestMatchers("/").permitAll()
	// .requestMatchers("/api/posts/**").hasRole("ADMIN")
	// .anyRequest().authenticated()
	// )
	// .csrf().disable()
	// .httpBasic();
	// return http.build();
	// }
	// * @throws Exception
	// */

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/").permitAll();
					auth.requestMatchers("/api/posts/**").hasRole("ADMIN");
					auth.requestMatchers(HttpMethod.GET, "/login").permitAll();
					auth.anyRequest().authenticated();
				}

				)
				.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(Customizer.withDefaults())
				.build();
	}
}