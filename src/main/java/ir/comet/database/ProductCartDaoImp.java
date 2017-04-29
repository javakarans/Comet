package ir.comet.database;


import ir.comet.model.ProductCart;

import java.util.List;

public class ProductCartDaoImp implements ProductCartDao {

    private SQLService sqlService;

    public ProductCartDaoImp(){
            sqlService=new SQLService();
    }

    public boolean createProductCart(ProductCart productCart) {
            return sqlService.create(productCart);
    }

    public ProductCart getProductCart(long sellingListId) {
        return null;
    }

    public List<ProductCart> getAllProductCarts() {
        return sqlService.getAllObjects(new ProductCart());
    }

    public boolean updateProductCart(ProductCart productCart) {
        return sqlService.update(productCart);
    }

    public boolean deleteProductCart(ProductCart productCart) {
        return sqlService.delete(productCart);
    }
}
