package shop;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ProductQuantityRestriction {
  private final String productName;
  private final int maxQuantity;

  public ProductQuantityRestriction(String productName, int maxQuantity) {
    this.productName = productName;
    this.maxQuantity = maxQuantity;
  }

  public String getProductName() {
    return productName;
  }

  public int getMaxQuantity() {
    return maxQuantity;
  }
}
