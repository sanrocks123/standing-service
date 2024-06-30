package fbl.standing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * StandingServiceSelfHostApp.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 */
@SpringBootApplication
public class StandingServiceSelfHostApp {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final SpringApplication app = new SpringApplication(StandingServiceSelfHostApp.class);
        app.run(args);
    }
}
