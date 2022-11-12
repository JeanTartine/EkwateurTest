package fr.joul.cie.test.springtechnicaltest.controller;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountCodeDto;
import fr.joul.cie.test.springtechnicaltest.service.impl.DiscountCodeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping(value = "/api/discount")
public class DiscountController {

    public static final Logger LOG = LoggerFactory.getLogger(DiscountController.class);

    @Autowired
    private DiscountCodeServiceImpl discountCodeService;

    //This function return all the available discounts for a promotion code, if the code is valid
    @GetMapping("/{codePromo}")
    public void getAllDiscountFromCode(@RequestParam String codePromo) throws IOException {
        LOG.info("Discount code used : {}", codePromo);

        if (!discountCodeService.discountCodeExists(codePromo)) {
            LOG.info("The discount code does not exist, sorry!");
        } else if (!discountCodeService.discountCodeValid(codePromo)){
            LOG.info("Sorry, the discount has expired...");
        } else {
            DiscountCodeDto discountCode = discountCodeService.getDiscountCode(codePromo);
            LOG.info("Code Found {}", discountCode);
        }
    }
}
