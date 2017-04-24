package ir.comet.wrapper;

import ir.comet.model.Product;
import ir.comet.model.ProductCart;

/**
 * Created by Mohammad on 4/24/2017.
 */
public class UserProductCart {

    private Product product;
    private ProductCart productCart;

    public UserProductCart(Product product){
        this.product=product;
        productCart=new ProductCart();
        fillProductCart();
        totalPrice();
        calTotalPriceAfterDiscount();

    }

    public void calTotalPriceAfterDiscount(){
        System.out.println(productCart.getQuantity());
        long price = product.getPrice();
        long discount = product.getDiscount();
        long totalPrice=(price-discount)*productCart.getQuantity();
        productCart.setTotalPriceAfterDiscountAndTax(totalPrice);
    }

    public void totalPrice(){
        long price = product.getPrice();
        int quantity = productCart.getQuantity();
        productCart.setTotalPrice(price*quantity);
    }

    public long calPriceByDiscount(){
        long price = product.getPrice();
        long discount = product.getDiscount();
        return (price-discount);
    }

    private void fillProductCart(){
        productCart.setProductId(product.getProductId());
        productCart.setTotalPriceAfterDiscountAndTax(product.getPrice());
        productCart.setTotalPrice(product.getPrice());
        productCart.setQuantity(1);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductCart getProductCart() {
        return productCart;
    }

    public void setProductCart(ProductCart productCart) {
        this.productCart = productCart;
    }
}
