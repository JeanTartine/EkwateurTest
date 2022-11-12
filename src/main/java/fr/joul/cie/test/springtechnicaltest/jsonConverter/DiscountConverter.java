package fr.joul.cie.test.springtechnicaltest.jsonConverter;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.joul.cie.test.springtechnicaltest.dto.DiscountDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class DiscountConverter {

    public static List<DiscountDto> convertJsonToDiscount(String filename) throws IOException {
        // We use Jackson's Object Mapper to convert our json file into a list of DiscountDto object
        ObjectMapper objectMapper = new ObjectMapper();


        List<DiscountDto> listDiscount = Arrays.asList(objectMapper.readValue(ResourceUtils.getFile("classpath:" + filename), DiscountDto[].class));
        return listDiscount;
    }

    public static void convertDiscountObjectToJson(List<DiscountDto> discountDtos) throws IOException {

        // We use Jackson's Object Converter to convert our list of discounts into a json file
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

        // Creation date and time of our file
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String formattedDate = dateTimeFormatter.format(LocalDateTime.now());
        
        objectWriter.writeValue(ResourceUtils.getFile(Paths.get("src/main/resources/result_" + formattedDate + ".json").toUri()), discountDtos);
    }
}
