package ir.comet.database;


import ir.comet.model.Product;

import java.util.List;

public class ProductDaoImp implements ProductDao {

    private SQLService SQLService;

    public ProductDaoImp(){
        SQLService =new SQLService();
    }

    public void createProduct(Product product) {
        SQLService.create(product);
    }

    public Product getProduct(long productId) {
        return (Product) SQLService.getObjectsBySpecialColumn(new Product(),"productId",productId).get(0);
    }

    public List<Product> getAllProducts() {
        return SQLService.getAllObjects(new Product());
    }

    public List<Product> getProductListBybranchDetailsId(long branchDetailsId){
        return SQLService.getObjectsBySpecialColumn(new Product(),"branchDetailsId",branchDetailsId);
    }

    public void updateProduct(Product product) {

        SQLService.update(product);
    }

    public void deleteProduct(Product product) {
        SQLService.delete(product);
    }
}
