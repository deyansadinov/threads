package shop;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class SellProduct {

  @Test
  public void singleProduct() {

    Shop shop = newShop(new ProductQuantityRestriction("apple",100));

    int quantity = 10;
    shop.addProduct("apple", quantity, 2.34);
    assertThat(shop.sellProduct("apple", 3),is(7));
  }

  @Test
  public void sellAnotherProduct() {
    Shop shop = newShop(new ProductQuantityRestriction("apple",100));
    int quantity = 10;
    shop.addProduct("apple", quantity, 2.34);
    assertThat(shop.sellProduct("apple", 4),is(6));

  }

  @Test
  public void sellMultipleProducts() {

    Shop shop = newShop(new ProductQuantityRestriction("apple",100),new ProductQuantityRestriction("mango",100));

    shop.addProduct("apple",12, 2.34);
    shop.addProduct("mango",15, 2.34);

    assertThat(shop.sellProduct("apple",6),is(6));
    assertThat(shop.sellProduct("mango",3),is(12));

  }

  @Test(expected = EmptyShopException.class)
  public void sellFromEmptyShop() {
    Shop shop =  newShop(new ProductQuantityRestriction("apple",100));

    shop.sellProduct("mango",10);
  }

  @Test(expected = NoExistingProductException.class)
  public void noExistingProduct() {
    Shop shop = newShop(new ProductQuantityRestriction("apple",100));

    shop.addProduct("apple",10, 2.34);

    shop.sellProduct("mango",12);
  }

  @Test(expected = NotEnoughtQuantityException.class)
  public void moreQuantityThanExist() {

    Shop shop = newShop(new ProductQuantityRestriction("apple",100));
    shop.addProduct("apple",40, 2.34);
    shop.sellProduct("apple",50);

  }

  private Shop newShop(ProductQuantityRestriction... restrictions){
    Map<String,ProductQuantityRestriction> productMap = new HashMap<String, ProductQuantityRestriction>();
    for (ProductQuantityRestriction each : restrictions){
      productMap.put(each.getProductName(),new ProductQuantityRestriction(each.getProductName(),each.getMaxQuantity()));
    }
    return new Shop(productMap);
  }
}
