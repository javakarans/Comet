package ir.comet.database;

import ir.comet.model.ProductCart;

import java.util.List;

public interface ProductCartDao {
    public void createSellingList(ProductCart productCart);
    public ProductCart getSellingList(long sellingListId);
    public List<ProductCart> getAllSellingLists();
    public void updateSellingList(ProductCart productCart);
    public void deleteSellingList(ProductCart productCart);
}
