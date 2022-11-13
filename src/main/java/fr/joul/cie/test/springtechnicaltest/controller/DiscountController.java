package fr.joul.cie.test.springtechnicaltest.controller;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountDto;
import fr.joul.cie.test.springtechnicaltest.jsonConverter.DiscountConverter;
import fr.joul.cie.test.springtechnicaltest.service.DiscountCodeService;
import fr.joul.cie.test.springtechnicaltest.service.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<DiscountDto>> getAllDiscountFromCode(@RequestParam String codePromo) throws IOException {
        LOG.info("Discount code used : {}", codePromo);

        if (!discountCodeService.discountCodeExists(codePromo)) {
            LOG.error("The discount code does not exist, sorry!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        } else if (!discountCodeService.discountCodeValid(codePromo)){
            LOG.error("Sorry, the discount has expired...");
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            LOG.info("Code Found");
            List<DiscountDto> discountDtoList = discountService.findAllDiscountByDiscountCode(codePromo);

            if (discountDtoList != null) {
                LOG.info("Discounts Found");
                discountConverter.convertDiscountObjectToJson(discountDtoList);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(discountDtoList);
            } else {
                LOG.error("Sorry, no discounts are available for your code...");
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .build();
            }
        }
    }
}
