package ir.comet.bean;

import ir.comet.controller.ProductController;
import ir.comet.model.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Mohammad on 3/31/2017.
 */
@ManagedBean
@ViewScoped
public class ProductBean {

   private List<Product> productList;

   @PostConstruct
   public void init(){

       ProductController productController=new ProductController();
       setProductList(productController.loadProductList());
   }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
