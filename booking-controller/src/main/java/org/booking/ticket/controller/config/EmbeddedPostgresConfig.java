package org.booking.ticket.controller.config;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class EmbeddedPostgresConfig {

    private static final Logger logger = LoggerFactory.getLogger(EmbeddedPostgresConfig.class);


    @Bean
    @Primary
    public DataSource dataSource() throws IOException {
        logger.info("Starting Embedded PostgreSQL...");
        EmbeddedPostgres postgres = null;
        try {
            Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "embedded-pg");
            postgres = EmbeddedPostgres.builder()
                    .setDataDirectory(tempDir)
                    .setCleanDataDirectory(true)
                    .setPort(5432)
                    .start();
        } catch (IOException e) {
            logger.error("Failed to start Embedded PostgreSQL: ", e);
            throw e;
        }
        logger.info("Embedded PostgreSQL started.");
        return postgres.getPostgresDatabase();
    }
}
