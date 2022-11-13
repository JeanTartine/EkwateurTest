package fr.joul.cie.test.springtechnicaltest.controller;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountDto;
import fr.joul.cie.test.springtechnicaltest.jsonConverter.DiscountConverter;
import fr.joul.cie.test.springtechnicaltest.service.DiscountCodeService;
import fr.joul.cie.test.springtechnicaltest.service.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/api/discount")
public class DiscountController {

    public static final Logger LOG = LoggerFactory.getLogger(DiscountController.class);

    @Autowired
    private DiscountCodeService discountCodeService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private DiscountConverter discountConverter;

    //This function return all the available discounts for a promotion code, if the code is valid,
    //Result is put in a json file into src/main/folder
    @GetMapping("/{codePromo}")
    public void getAllDiscountFromCode(@RequestParam String codePromo) throws IOException {
        LOG.info("Discount code used : {}", codePromo);

        if (!discountCodeService.discountCodeExists(codePromo)) {
            LOG.error("The discount code does not exist, sorry!");
        } else if (!discountCodeService.discountCodeValid(codePromo)){
            LOG.error("Sorry, the discount has expired...");
        } else {
            LOG.info("Code Found");
            List<DiscountDto> discountDtoList = discountService.findAllDiscountByDiscountCode(codePromo);

            LOG.info("Discounts concerned by code list {}", discountDtoList);
            discountConverter.convertDiscountObjectToJson(discountDtoList);
        }
    }
}
