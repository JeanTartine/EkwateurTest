package fr.joul.cie.test.springtechnicaltest.service;

import fr.joul.cie.test.springtechnicaltest.dto.DiscountCodeDto;

import java.io.IOException;

public interface DiscountCodeService {

    boolean discountCodeExists(String discountCode) throws IOException;

    boolean discountCodeValid(String discountCode) throws IOException;

    DiscountCodeDto getDiscountCode(String discountCode) throws IOException;
}
