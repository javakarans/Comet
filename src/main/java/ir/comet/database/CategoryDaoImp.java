package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Category;
import ir.comet.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CategoryDaoImp implements CategoryDao {

    private SqlHandler sqlHandler;

    public CategoryDaoImp(){
        sqlHandler=new SqlHandler();
    }

    public void createCategory(Category category) {
        sqlHandler.create(category);
    }

    public Category getCategory(long categoryId) {
        return (Category) sqlHandler.getObjectsBySpecialColumn(new Category(),"categoryId",categoryId).get(0);
    }

    public List<Category> getAllCategories() {
        Category category = new Category();
        return sqlHandler.getAllObjects(category) ;
    }

    public void updateCategory(Category category) {
        sqlHandler.update(category);
    }

    public void deleteCategory(Category category) {
        sqlHandler.delete(category);
    }
}
