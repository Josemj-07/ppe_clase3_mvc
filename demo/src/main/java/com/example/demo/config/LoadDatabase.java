package com.example.demo.config;

import com.example.demo.model.Estudiante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.RepositorioEstudiante;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RepositorioEstudiante repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Estudiante((long)551857,"Jose Muñoz", "Ingeniería en sistemas")));
        };
    }
}