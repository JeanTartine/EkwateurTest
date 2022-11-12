package fr.joul.cie.test.springtechnicaltest.dto;


import java.time.LocalDate;

// This class DiscountCodeDto represents a discount code object
public class DiscountCodeDto {
    public String code;

    public Integer discountValue;

    public LocalDate endDate;

    public DiscountCodeDto() {
    }

    public DiscountCodeDto(String code, Integer discountValue, LocalDate endDate) {
        this.code = code;
        this.discountValue = discountValue;
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DiscountCodeDto{" +
                "code='" + code + '\'' +
                ", discountValue=" + discountValue +
                ", endDate=" + endDate +
                '}';
    }
}
