package fr.joul.cie.test.springtechnicaltest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTechnicalTestApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringTechnicalTestApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
}
