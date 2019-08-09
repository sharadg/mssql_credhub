package io.pivotal.playground;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaygroundApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CityRepository cityRepository) {

        return (args -> {
            cityRepository.save(new City("columbus", "franklin", "43219", "OH"));
            cityRepository.save(new City("dallas", "dallas", "75244 ", "TX"));

            cityRepository.findAll().forEach(city -> {System.out.println(city);});
        });
    }

}
