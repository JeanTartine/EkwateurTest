package fr.joul.cie.test.springtechnicaltest.dto;

import java.util.List;

// This class DiscountDto represents a discount
public class DiscountDto {

    public String offerType;

    public String offerName;

    public String offerDescription;

    public List<DiscountCodeDto> validPromoCodeList;

    public DiscountDto(String offerType, String offerName, String offerDescription) {
        this.offerType = offerType;
        this.offerName = offerName;
        this.offerDescription = offerDescription;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public List<DiscountCodeDto> getValidPromoCodeList() {
        return validPromoCodeList;
    }

    public void setValidPromoCodeList(List<DiscountCodeDto> validPromoCodeList) {
        this.validPromoCodeList = validPromoCodeList;
    }

    @Override
    public String toString() {
        return "DiscountDto{" +
                "offerType='" + offerType + '\'' +
                ", offerName='" + offerName + '\'' +
                ", offerDescription='" + offerDescription + '\'' +
                ", validPromoCodeList=" + validPromoCodeList +
                '}';
    }
}
