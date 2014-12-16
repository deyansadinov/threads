package shop;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Products {

  private final String productName;
  private final Double price;

  public Products(String productName, double price) {
    this.productName = productName;
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Products products = (Products) o;

    if (price != null ? !price.equals(products.price) : products.price != null) return false;
    if (productName != null ? !productName.equals(products.productName) : products.productName != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = productName != null ? productName.hashCode() : 0;
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }

  public String getProductName() {
    return productName;
  }
}
