package fbl.standing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * StandingAppConfig.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 */
@Configuration
public class StandingAppConfig {

    /**
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
