package fr.joul.cie.test.springtechnicaltest.service;

public interface DiscountCodeService {

    boolean discountCodeExists(String discountCode);

    boolean discountCodeValid(String discountCode);

}
