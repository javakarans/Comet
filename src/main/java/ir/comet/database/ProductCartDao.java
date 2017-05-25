package ir.comet.database;

import ir.comet.model.Product;
import ir.comet.model.ProductOrderDetail;

import java.util.List;

public interface ProductCartDao {
    public boolean createProductCart(ProductOrderDetail productOrderDetail);
    public ProductOrderDetail getProductCart(long sellingListId);
    public List<ProductOrderDetail> getAllProductCarts();
    public boolean updateProductCart(ProductOrderDetail productOrderDetail);
    public boolean deleteProductCart(ProductOrderDetail productOrderDetail);
}
