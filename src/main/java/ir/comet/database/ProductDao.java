package ir.comet.database;

import ir.comet.model.Product;

import java.util.List;

public interface ProductDao {
    public void createProduct(Product product);
    public Product getProduct(long productId);
    public List<Product> getProductByBranchBrandId(long branchBrandId);
    public Product getProductByProductName(String productName);
    public List<Product> getAllProducts();
    public void updateProduct(Product product);
    public void deleteProduct(Product product);
}
