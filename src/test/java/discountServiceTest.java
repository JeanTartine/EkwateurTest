import fr.joul.cie.test.springtechnicaltest.dto.DiscountDto;
import fr.joul.cie.test.springtechnicaltest.service.impl.DiscountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class discountServiceTest {
    @InjectMocks
    private DiscountServiceImpl discountService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllDiscountByCode() throws Exception{
        List<DiscountDto> result = discountService.findAllDiscountByDiscountCode("EKWA_WELCOME");

        for (DiscountDto discount : result) {
            assertTrue(discount.getValidPromoCodeList().contains("EKWA_WELCOME"));
        }
    }

}
