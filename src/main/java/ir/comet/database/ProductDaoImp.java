package ir.comet.database;


import ir.comet.model.Order;
import ir.comet.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProductDaoImp implements ProductDao {

    private SqlHandler sqlHandler;

    public ProductDaoImp(){
        sqlHandler=SqlHandler.getInstance();
    }

    public void createProduct(Product product) {
        sqlHandler.create(product);
    }

    public Product getProduct(long productId) {
        return (Product) sqlHandler.getObjectsBySpecialColumn(new Product(),"productId",productId).get(0);
    }

    public List<Product> getAllProducts() {
        return sqlHandler.getAllObjects(new Product());
    }

    public List<Product> getProductListBybranchDetailsId(long branchDetailsId){
        return sqlHandler.getObjectsBySpecialColumn(new Product(),"branchDetailsId",branchDetailsId);
    }

    public void updateProduct(Product product) {

        sqlHandler.update(product);
    }

    public void deleteProduct(Product product) {
        sqlHandler.delete(product);
    }
}
