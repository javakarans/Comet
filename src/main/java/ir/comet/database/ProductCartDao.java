package ir.comet.database;

import ir.comet.model.ProductCart;

import java.util.List;

public interface ProductCartDao {
    public void createProductCart(ProductCart productCart);
    public ProductCart getProductCart(long sellingListId);
    public List<ProductCart> getAllProductCarts();
    public void updateProductCart(ProductCart productCart);
    public void deleteProductCart(ProductCart productCart);
}
