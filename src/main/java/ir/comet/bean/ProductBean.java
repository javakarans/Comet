package ir.comet.bean;

import ir.comet.model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 3/31/2017.
 */
@ManagedBean
@SessionScoped
public class ProductBean {

    private List<Product> productList;

    public ProductBean(){
        setProductList(new ArrayList<Product>());
        Product product=new Product();
        product.setName("Iphone 6");
        product.setBranchId(1);
        product.setColor("red");
        product.setDescription("This is a good phone");
        product.setImageUrl("url");
        product.setPrice(2400000);
        product.setProductId(1);
        product.setScore(5);
        product.setStock(10);
        product.setWareHouseId(1);
        product.setWarranty("Apple center");

        Product product2=new Product();
        product2.setName("iphone 7");
        getProductList().add(product);
        getProductList().add(product2);
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
