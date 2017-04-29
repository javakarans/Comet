package ir.comet.database;

import ir.comet.model.ProductCart;

import java.util.List;

public interface ProductCartDao {
    public boolean createProductCart(ProductCart productCart);
    public ProductCart getProductCart(long sellingListId);
    public List<ProductCart> getAllProductCarts();
    public boolean updateProductCart(ProductCart productCart);
    public boolean deleteProductCart(ProductCart productCart);
}
