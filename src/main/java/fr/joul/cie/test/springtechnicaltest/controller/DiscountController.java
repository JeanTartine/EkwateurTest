package fr.joul.cie.test.springtechnicaltest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/api/discount")
public class DiscountController {

    public static final Logger LOG = LoggerFactory.getLogger(DiscountController.class);

    //This function return all the available discounts for a promotion code, if the code is valid
    @GetMapping("/{codePromo}")
    public void getAllDiscountFromCode(@RequestParam String codePromo) {
        LOG.info("Discount code used : {}", codePromo);
    }
}
