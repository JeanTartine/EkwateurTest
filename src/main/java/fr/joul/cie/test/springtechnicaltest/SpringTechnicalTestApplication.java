package fr.joul.cie.test.springtechnicaltest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;

@SpringBootApplication
public class SpringTechnicalTestApplication implements CommandLineRunner {

	public static final Logger LOG = LoggerFactory.getLogger(SpringTechnicalTestApplication.class);

	public static void main(String[] args) {
		LOG.info("Starting application");
		SpringApplication.run(SpringTechnicalTestApplication.class, args);
		LOG.info("Ending application");
	}

	@Override
	public void run(final String... args) throws Exception {

		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
}
