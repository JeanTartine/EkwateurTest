package fr.joul.cie.test.springtechnicaltest.jsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import fr.joul.cie.test.springtechnicaltest.dto.DiscountCodeDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component
public class DiscountCodeConverter {

    public static List<DiscountCodeDto> convertJsonToDiscountCode (String filename) throws IOException {

        // We use Jackson Object Mapper to convert our json file into a list of DiscountCodeDto object
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        List<DiscountCodeDto> listDiscountCode = Arrays.asList(objectMapper.readValue(ResourceUtils.getFile("classpath:" + filename), DiscountCodeDto[].class));
        return listDiscountCode;
    }
}
