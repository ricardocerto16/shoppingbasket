package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public List<BasketItem> consolidateItems() {
        // Exercise - implement this function
        HashMap<String, BasketItem> consolidateList = new HashMap<String, BasketItem>();

        for (BasketItem singleItem : items){

            if (consolidateList.containsKey(singleItem.getProductCode())){
                BasketItem basket = consolidateList.get(singleItem.getProductCode());
                basket.setQuantity(basket.getQuantity() + singleItem.getQuantity());
                consolidateList.put(singleItem.getProductCode(), basket);
            }
            else {
                consolidateList.put(singleItem.getProductCode(), singleItem);
            }
        }
        return new ArrayList<BasketItem>(consolidateList.values());

    }
}
