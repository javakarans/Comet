package ir.comet.controller;

import ir.comet.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/15/2017.
 */
public class ProductController {

    public List<Product> loadProductList(){

        List<Product> products=new ArrayList<Product>();
        Product product=new Product();
        product.setName("چراغ سوله ای 150 ولت");
        product.setColor("red");
        product.setImageUrl("../resources/images/sample2.jpg");
        product.setPrice(56000);
        product.setScore(3);

        Product product2=new Product();
        product2.setName("چراغ سوله ای 150 ولت");
        product2.setColor("red");
        product2.setImageUrl("../resources/images/sample2.jpg");
        product2.setPrice(56000);
        product2.setScore(3);

        products.add(product);
        products.add(product2);

        return products;
    }
}
