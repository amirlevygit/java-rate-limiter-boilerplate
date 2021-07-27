package com.fireblocks.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TransactionRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new TransactionEntity("BTC", 1L, "xyzaddress", "user1")));
            log.info("Preloading " + repository.save(new TransactionEntity("ETH", 30L, "abcadd", "user2")));
        };
    }
}