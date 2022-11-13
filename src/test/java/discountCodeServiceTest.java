import fr.joul.cie.test.springtechnicaltest.dto.DiscountCodeDto;
import fr.joul.cie.test.springtechnicaltest.service.impl.DiscountCodeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class discountCodeServiceTest {

    @InjectMocks
    private DiscountCodeServiceImpl discountCodeService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void discountCodeIsValid() throws Exception {

        Boolean result = discountCodeService.discountCodeValid("EKWA_WELCOME");
        assertEquals(true, result);
    }

    @Test
    public void discountCodeHasExpired() throws Exception {

        Boolean result = discountCodeService.discountCodeValid("BUZZ");
        assertEquals(false, result);
    }

    @Test
    public void discountCodeExists() throws Exception {

        Boolean result = discountCodeService.discountCodeValid("EKWA_WELCOME");
        assertEquals(true, result);
    }

    @Test
    public void discountCodeDoesNotExists() throws Exception {

        Boolean result = discountCodeService.discountCodeValid("TRUC");
        assertEquals(false, result);
    }

    @Test
    public void getDiscountCode() throws Exception {
        DiscountCodeDto code = new DiscountCodeDto("EKWA_WELCOME", 2, LocalDate.of(2023,10,04));

        DiscountCodeDto result = discountCodeService.getDiscountCode("EKWA_WELCOME");
        assertNotNull(result);
        assertEquals(code.getCode(), result.getCode());
    }

}
