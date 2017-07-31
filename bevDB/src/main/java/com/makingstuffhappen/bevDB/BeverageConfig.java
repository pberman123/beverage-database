package com.makingstuffhappen.bevDB;

/**
 * Created by philip on 7/28/17.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.makingstuffhappen.bevDB.repository.BeverageRepository;
import com.makingstuffhappen.bevDB.entity.Beverage;



@Configuration
public class BeverageConfig {

    Logger logger = LoggerFactory.getLogger(BeverageConfig.class);

    // Loads the database on startup
    @Bean
    CommandLineRunner loadDatabase(BeverageRepository br) {
        return commandLineRunner -> {
            logger.debug("loading database..");
            br.save(new Beverage("Wine","La Crema","2014", "Sonoma"));
            br.save(new Beverage("Wine","Bench","2015", "Sonoma"));
            br.save(new Beverage("Beer","Budweiser","","St. Louis"));
            logger.debug("record count: {}", br.count());
                br.findAll().forEach(x -> logger.debug(x.toString()));
        };
    }
}

