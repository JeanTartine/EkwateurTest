package fr.joul.cie.test.springtechnicaltest;

import fr.joul.cie.test.springtechnicaltest.controller.DiscountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;

@SpringBootApplication
public class SpringTechnicalTestApplication implements CommandLineRunner {

	public static final Logger LOG = LoggerFactory.getLogger(SpringTechnicalTestApplication.class);

	@Autowired
	private DiscountController discountController;

	public static void main(String[] args) {
		LOG.info("Starting application");
		SpringApplication.run(SpringTechnicalTestApplication.class, args);
		LOG.info("Ending application");
	}

	@Override
	public void run(final String... args) throws Exception {

		//Verifying that the discount code is given has an argument at application start
		LOG.info("EXECUTING : command line runner");
		if (args.length > 0) {
			LOG.info("PROMOTION CODE FOUND");
			String codePromo = args[0];
			discountController.getAllDiscountFromCode(codePromo);
		} else {
			LOG.info("No promotion code found, please specify one");
		}
	}
}
