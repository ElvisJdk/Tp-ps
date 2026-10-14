package ar.edu.centro8.ps.trabajoPractico4.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
public class SecurityConfig {

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults()) // se usa cuando solo vas a logear con usuarios y contraseñas
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    		@Bean
		public UserDetailsService userDetailsService() {
			List<UserDetails> userDetailsList = new ArrayList<>();

			userDetailsList.add(User.withUsername("ADMIN")
					.password("1234") // esto si no está codificado, sino, tiene que seguir el algoritmo de
									  // codificación
					.roles("ADMIN")
					.authorities("READ_CURSOS", "WRITE_CURSOS", "READ_DOCENTES", "WRITE_DOCENTES")
					.build());

			userDetailsList.add(User.withUsername("DOCENTE")
					.password("1234") // esto si no está codificado, sino, tiene que seguir el algoritmo de
									  // codificación
					.roles("DOCENTE")
					.authorities("READ_CURSOS,READ_DOCENTES")
					.build());

			userDetailsList.add(User.withUsername("ESTUDIANTE")
					.password("1234") // esto si no está codificado, sino, tiene que seguir el algoritmo de
									  // codificación
					.roles("ESTUDIANTE")
					.authorities("READ_CURSOS")
					.build());

			return new InMemoryUserDetailsManager(userDetailsList);
		}


}
