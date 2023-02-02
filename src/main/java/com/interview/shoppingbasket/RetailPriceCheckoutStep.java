package com.interview.shoppingbasket;

import java.util.List;



public class RetailPriceCheckoutStep implements CheckoutStep {
    private  PromotionsService promotionsService;
    private PricingService pricingService;

    private PromotionsService promotion;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService, PromotionsService promotionsService) {

        this.pricingService = pricingService;
        this.promotionsService = promotionsService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        basket.consolidateItems();

        for (BasketItem basketItem: basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
            basketItem.setProductRetailPrice(price);


            List<Promotion> promos =  promotionsService.getPromotions(basket);

            for(Promotion promo : promos)
                price = applyPromotion(promo,basketItem,price);

            retailTotal += price;
        }

        checkoutContext.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {

        String typePromo = promotion.getPromoCode();

        if (typePromo.equals(item.getProductCode())) {
            if (promotion.equals("50%")) {
                retailTotal = item.getQuantity() * (price / 0.5);
            } else if (typePromo.equals("10%")) {
                retailTotal = item.getQuantity() * (price / 0.9);
            } else if (typePromo.equals("2x1")) {
                retailTotal = item.getQuantity() % 2 == 0 ? (item.getQuantity() / 2) * price :
                        ((item.getQuantity() / 2) + 1) * price;
            } else
                retailTotal = price;
        }

        return retailTotal;
    }
}
