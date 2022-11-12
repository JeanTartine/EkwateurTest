package fr.joul.cie.test.springtechnicaltest.jsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.joul.cie.test.springtechnicaltest.dto.DiscountCodeDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class DiscountCodeConverter {

    public static List<DiscountCodeDto> convertJsonToDiscountCode (String filename) throws IOException {

        // We use Jackson's Object Mapper to convert our json file into a list of DiscountCodeDto object
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        List<DiscountCodeDto> listDiscountCode = Arrays.asList(objectMapper.readValue(ResourceUtils.getFile("classpath:" + filename), DiscountCodeDto[].class));
        return listDiscountCode;
    }
}
