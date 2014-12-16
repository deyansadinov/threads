package shop;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * @author Deyan Sadinov <sadinov88@gmail.com>
 */
public class ProductAddingRestrictionTest {
  
  @Test(expected = NoMoreSpaceException.class)
  public void moreQuantityThanShopCanFit() {
    Shop shop = newShop(new ProductQuantityRestriction("apple",100));

    shop.addProduct("apple",110, 2.34);
  }

  @Test
  public void moreQuantityToProduct() {
    Shop shop = newShop(new ProductQuantityRestriction("apple",100));

    shop.addProduct("apple",40, 2.34);

    assertThat(shop.addQuantity("apple",50),is(90));
  }
  
  @Test(expected = NoMoreSpaceException.class)
  public void moreQuantityToProductThanShopCanFit() {
    Shop shop = newShop(new ProductQuantityRestriction("apple",100));

    shop.addProduct("apple",80, 2.34);
    shop.addQuantity("apple",40);
  }
  
  @Test
  public void sortByPrice() {
    Shop shop = newShop(new ProductQuantityRestriction("apple",100),new ProductQuantityRestriction("mango",120)
            ,new ProductQuantityRestriction("banana",150));

    shop.addProduct("apple",40,2.34);
    shop.addProduct("mango",50,1.34);
    shop.addProduct("banana",60,3.34);

    List<Products> list = shop.sort(new ByPrice());

    assertThat(list.size(),is(3));
    assertThat(list.get(0).getProductName(),is("mango"));
    assertThat(list.get(1).getProductName(),is("apple"));
    assertThat(list.get(2).getProductName(),is("banana"));
  }



  private Shop newShop(ProductQuantityRestriction... restrictions){
    Map<String,ProductQuantityRestriction> productMap = new HashMap<String, ProductQuantityRestriction>();
    for (ProductQuantityRestriction each : restrictions){
      productMap.put(each.getProductName(),new ProductQuantityRestriction(each.getProductName(),each.getMaxQuantity()));
    }
    return new Shop(productMap);
  }
}
