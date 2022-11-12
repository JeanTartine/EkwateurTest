package fr.joul.cie.test.springtechnicaltest.service.impl;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountDto;
import fr.joul.cie.test.springtechnicaltest.jsonConverter.DiscountConverter;
import fr.joul.cie.test.springtechnicaltest.service.DiscountCodeService;
import fr.joul.cie.test.springtechnicaltest.service.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    public static final Logger LOG = LoggerFactory.getLogger(DiscountServiceImpl.class);

    @Autowired
    private DiscountConverter discountConverter;

    @Override
    public List<DiscountDto> findAllDiscountByDiscountCode(String discountCode) throws IOException {

        //Get all the discount from json file
        List<DiscountDto> discountDtoList = discountConverter.convertJsonToDiscount("offerList.json");

        //Filter the list to only keep discount changed by the code

        List<DiscountDto> discountFiltered = discountDtoList.stream()
                .filter(discountDto -> discountDto.validPromoCodeList.contains(discountCode))
                .collect(Collectors.toList());

        return discountFiltered;
    }
}
