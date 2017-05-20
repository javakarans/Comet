package ir.comet.database;


import ir.comet.model.ProductOrderDetail;

import java.util.List;

public class ProductCartDaoImp implements ProductCartDao {

    private SQLService sqlService;

    public ProductCartDaoImp(){
            sqlService=new SQLService();
    }

    public boolean createProductCart(ProductOrderDetail productOrderDetail) {
            return sqlService.create(productOrderDetail);
    }

    public ProductOrderDetail getProductCart(long sellingListId) {
        return null;
    }

    public List<ProductOrderDetail> getAllProductCarts() {
        return sqlService.getAllObjects(new ProductOrderDetail());
    }

    public boolean updateProductCart(ProductOrderDetail productOrderDetail) {
        return sqlService.update(productOrderDetail);
    }

    public boolean deleteProductCart(ProductOrderDetail productOrderDetail) {
        return sqlService.delete(productOrderDetail);
    }
}
