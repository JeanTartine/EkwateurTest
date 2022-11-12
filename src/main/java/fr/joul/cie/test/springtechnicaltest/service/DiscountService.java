package fr.joul.cie.test.springtechnicaltest.service;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountDto;

import java.io.IOException;
import java.util.List;

public interface DiscountService {
    public List<DiscountDto> findAllDiscountByDiscountCode(String discountCode) throws IOException;
}
