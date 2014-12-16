package shop;

import java.util.Comparator;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ByPrice implements Comparator<Products> {

  @Override
  public int compare(Products products, Products products2) {
    return products.getPrice().compareTo(products2.getPrice());
  }
}
