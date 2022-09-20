package com.nphase.service;

import com.nphase.entity.CategoryType;
import com.nphase.entity.DiscountModel;
import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {

    private final Map<CategoryType, DiscountModel> discount;

    public ShoppingCartService() {
        discount = new HashMap<>();
        discount.put(CategoryType.DRINKS, new DiscountModel(4, new BigDecimal("0.9")));
    }

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        BigDecimal sum = new BigDecimal(0L);
        Map<CategoryType, BigDecimal> discountByCategory = new HashMap<>();
        for (CategoryType category : CategoryType.values()) {
            Integer countOfCategory = shoppingCart.getProducts().stream().filter(p -> p.getCategory() == category).map(Product::getQuantity).reduce(0, Integer::sum);
            DiscountModel discountModel = this.discount.getOrDefault(category, DiscountModel.DEFAULT_DISCOUNT);
            discountByCategory.put(category, (countOfCategory >= discountModel.getCount()) ? discountModel.getDiscount() : BigDecimal.ONE);
        }

        for (Product p : shoppingCart.getProducts()) {
            BigDecimal amount = p.getPricePerUnit().multiply(new BigDecimal(p.getQuantity()));
            // discountByCategory.getOrDefault можно не использовать, т.к. выше map проиинициализировался всеми значениями
            BigDecimal discount = discountByCategory.getOrDefault(p.getCategory(), BigDecimal.ONE);
            sum = sum.add(
                    amount.multiply(discount)
            );
        }
        return sum;
    }
}
