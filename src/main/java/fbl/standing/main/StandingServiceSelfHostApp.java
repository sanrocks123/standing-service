package fbl.standing.main;

import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * StandingServiceSelfHostApp.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "fbl")
public class StandingServiceSelfHostApp {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		if (Objects.isNull(System.getProperty("spring.profiles.active"))) {
			System.setProperty("spring.profiles.active", "dev");
		}

		final SpringApplication app = new SpringApplication(StandingServiceSelfHostApp.class);
		app.run(args);
	}
}
