package shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class Shop {


  private final Map<String, ProductQuantityRestriction> productMap;
  Map<String,ProductSlot> productHolder = new HashMap<String, ProductSlot>();

  public Shop(Map<String, ProductQuantityRestriction> productMap) {

    this.productMap = productMap;
  }

  public void addProduct(String productName, int quantity, double price) {
    if (quantity > productMap.get(productName).getMaxQuantity()){
      throw new NoMoreSpaceException();
    }
    productHolder.put(productName,new ProductSlot(new Products(productName,price),quantity));

  }

  public int sellProduct(String productName, int quantity) {
    if (productHolder.isEmpty()){
      throw new EmptyShopException();
    }
    if (!(productHolder.containsKey(productName))){
      throw new NoExistingProductException();
    }
    ProductSlot product = productHolder.get(productName);
    return product.sell(quantity);
  }

  public int addQuantity(String productName, int quantity) {
    ProductSlot productSlot = productHolder.get(productName);
    if (productSlot.getCurrentQuantity() + quantity > productMap.get(productName).getMaxQuantity()){
      throw new NoMoreSpaceException();
    }
    return productSlot.add(quantity);
  }

  public List<Products> sort(Comparator<Products> ordering) {
    List<Products> sort = new ArrayList<Products>();
    List<ProductSlot> list = new ArrayList<ProductSlot>(productHolder.values());
    for (ProductSlot productSlot : list){
      sort.add(productSlot.getProducts());
    }
    Collections.sort(sort,ordering);
    return sort;
  }


  public class ProductSlot{
    private final Products products;
    private int currentQuantity;

    public ProductSlot(Products products,int currentQuantity) {
      this.products = products;
      this.currentQuantity = currentQuantity;

    }

    public Products getProducts() {
      return products;
    }

    public int getCurrentQuantity() {
      return currentQuantity;
    }

    public int sell(int quantity) {
      if (currentQuantity - quantity < 0){
        throw new NotEnoughtQuantityException();
      }
      return currentQuantity -= quantity;
    }

    public int add(int quantity) {
      return currentQuantity += quantity;
    }
  }
}
