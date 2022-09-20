package com.nphase.entity;

import java.math.BigDecimal;

public class DiscountModel {
  public static final DiscountModel DEFAULT_DISCOUNT = new DiscountModel(Integer.MAX_VALUE, BigDecimal.ONE);

  private final int count;
  private final BigDecimal discount;

  public DiscountModel(int count, BigDecimal discount) {
    this.count = count;
    this.discount = discount;
  }

  public int getCount() {
    return count;
  }

  public BigDecimal getDiscount() {
    return discount;
  }
}
