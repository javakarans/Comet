package ir.comet.database;

import ir.comet.model.Product;

import java.util.List;

public interface ProductDao {
    public boolean createProduct(Product product);
    public Product getProduct(long productId);
    public List<Product> getProductByBranchBrandId(long branchBrandId);
    public Product getProductByProductName(String productName);
    public List<Product> getAllProducts();
    public boolean updateProduct(Product product);
    public boolean deleteProduct(Product product);
    public List<Product> getTopProductsByColumn(String column,int count);
}
