package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Promotion {
    // Not yet implemented

    String promotionType;
    String productCode;

    public Promotion(String typePromotion, String productCode) {
        this.promotionType = typePromotion;
        this.productCode = productCode;
    }


    public String getPromoCode() {
        return this.productCode;
    }

    public String getTypePromotion() {
        return this.promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
