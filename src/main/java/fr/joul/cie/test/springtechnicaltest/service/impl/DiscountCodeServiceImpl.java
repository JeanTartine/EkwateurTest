package fr.joul.cie.test.springtechnicaltest.service.impl;

import fr.joul.cie.test.springtechnicaltest.service.DiscountCodeService;
import org.springframework.stereotype.Service;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Override
    public boolean discountCodeExists(String discountCode) {
        return false;
    }

    @Override
    public boolean discountCodeValid(String discountCode) {
        return false;
    }
}
