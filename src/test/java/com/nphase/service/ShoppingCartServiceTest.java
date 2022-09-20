package com.nphase.service;


import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCartServiceTest {
    private final ShoppingCartService service = new ShoppingCartService();

    @Test
    public void calculatesPrice()  {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                Product.createDrink("Tea", BigDecimal.valueOf(5.0), 2),
                Product.createDrink("Coffee", BigDecimal.valueOf(6.5), 1)
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(16.5));
    }

    @Test
    public void calculatesPriceWithDiscountWithCategory()  {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                Product.createDrink("Tea", BigDecimal.valueOf(5.3), 2),
                Product.createDrink("Coffee", BigDecimal.valueOf(3.5), 2),
                Product.createFood("cheese", BigDecimal.valueOf(8), 2)
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result.stripTrailingZeros(), BigDecimal.valueOf(31.84).stripTrailingZeros());
    }

}
