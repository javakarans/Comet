package ir.comet.bean;

import ir.comet.model.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@ViewScoped
public class CartBean {

    private List<Product> addedToCart;

    @PostConstruct
    public void init(){
        setAddedToCart(new ArrayList<Product>());
        loadCartList();
    }

    public void loadCartList(){
        Product product=new Product();
        product.setName("لامپ سوله ای 150 ولت");
        product.setImageUrl("../resources/images/sample2.jpg");
        product.setPrice(120000);
        addedToCart.add(product);
    }

    public List<Product> getAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(List<Product> addedToCart) {
        this.addedToCart = addedToCart;
    }
}
