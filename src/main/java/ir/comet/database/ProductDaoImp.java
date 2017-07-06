package ir.comet.database;


import ir.comet.model.Product;

import java.util.List;

public class ProductDaoImp implements ProductDao {

    private SQLService SQLService;

    public ProductDaoImp(){
        SQLService =new SQLService();
    }

    public boolean createProduct(Product product) {
        return SQLService.create(product);
    }

    public Product getProduct(long productId) {
        return (Product) SQLService.getObjectsBySpecialColumn(new Product(),"productId",productId).get(0);
    }

    public List<Product> getProductByBranchBrandId(long branchBrandId) {
        return SQLService.getObjectsBySpecialColumn(new Product(),"branchBrandId",branchBrandId);
    }

    public Product getProductByProductName(String productName) {
        return (Product) SQLService.getObjectsBySpecialColumn(new Product(),"name",productName).get(0);
    }

    public List<Product> getAllProducts() {
        return SQLService.getAllObjects(new Product());
    }

    public boolean updateProduct(Product product) {

       return SQLService.update(product);
    }

    public boolean deleteProduct(Product product) {
        return SQLService.delete(product);
    }

    public List<Product> getTopProductsByColumn(String column,int count) {
        return SQLService.getTopObjectsByColumn(new Product(), column, count);
    }

    public List<Product> getProductsByContainValue(String containValue){
        return SQLService.getObjectsByContainValue(new Product(), "name", containValue);
    }
}
