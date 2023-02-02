package com.interview.shoppingbasket;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class RetailPriceCheckoutStepTest {

    PricingService pricingService;
    CheckoutContext checkoutContext;
    Basket basket;
    PromotionsService promotionsService;

    @BeforeEach
    void setup() {
        pricingService = Mockito.mock(PricingService.class);
        checkoutContext = Mockito.mock(CheckoutContext.class);
        basket = new Basket();

        when(checkoutContext.getBasket()).thenReturn(basket);
    }

    @Test
    void setPriceZeroForEmptyBasket() {

        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService,promotionsService);

        retailPriceCheckoutStep.execute(checkoutContext);

        Mockito.verify(checkoutContext).setRetailPriceTotal(0.0);
    }

    /*@Test
    void setPriceOfProductToBasketItem() {

        basket.add("product1", "myproduct1", 10);
        basket.add("product2", "myproduct2", 10);

        when(pricingService.getPrice("product1")).thenReturn(3.99);
        when(pricingService.getPrice("product2")).thenReturn(2.0);

        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new Promotion("10%", "product1"));
        promotions.add(new Promotion("50%", "product2"));

        when(promotionsService.getPromotions(basket)).thenReturn(promotions);

        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService,promotionsService);

        retailPriceCheckoutStep.execute(checkoutContext);
        Mockito.verify(checkoutContext).setRetailPriceTotal(3.99*10+2*10);

    }
*/
}
