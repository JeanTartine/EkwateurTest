package fr.joul.cie.test.springtechnicaltest.service.impl;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountCodeDto;
import fr.joul.cie.test.springtechnicaltest.jsonConverter.DiscountCodeConverter;
import fr.joul.cie.test.springtechnicaltest.service.DiscountCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    public static final Logger LOG = LoggerFactory.getLogger(DiscountCodeServiceImpl.class);

    @Autowired
    private DiscountCodeConverter discountCodeConverter;

    @Override
    public boolean discountCodeExists(String discountCode) throws IOException {

        //Retrieve all the discount codes from json file
        List<DiscountCodeDto> discountCodeDtoList = discountCodeConverter.convertJsonToDiscountCode("promoCodelist.json");

        // Check if the code is in the list
         return discountCodeDtoList.stream()
                .anyMatch(code -> discountCode.equals(code.getCode()));
    }

    @Override
    public boolean discountCodeValid(String discountCode) throws IOException {
        //Retrieve all the discount codes from ou json file
        List<DiscountCodeDto> discountCodeDtoList = discountCodeConverter.convertJsonToDiscountCode("promoCodelist.json");

        //Retrieve the discount code from the list
        DiscountCodeDto discountCodeDto = discountCodeDtoList.stream()
                .filter(code -> discountCode.equals(code.getCode()))
                .findFirst()
                .orElse(null);

        //Check if the code is still available
        if (discountCodeDto != null) {
            return discountCodeDto.getEndDate().isAfter(LocalDate.now());
        } else {
            return false;
        }
    }

    @Override
    public DiscountCodeDto getDiscountCode(String discountCode) throws IOException {
        //First we retrieve all the discount codes from ou json file
        List<DiscountCodeDto> discountCodeDtoList = discountCodeConverter.convertJsonToDiscountCode("promoCodelist.json");

        //Retrieve the discount code from the list
        return discountCodeDtoList.stream()
                .filter(code -> discountCode.equals(code.getCode()))
                .findFirst()
                .orElse(null);
    }
}
