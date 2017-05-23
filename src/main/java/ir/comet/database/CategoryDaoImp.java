package ir.comet.database;

import ir.comet.model.Category;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CategoryDaoImp implements CategoryDao {

    private SQLService SQLService;

    public CategoryDaoImp(){
        SQLService =new SQLService();
    }

    public boolean createCategory(Category category) {
        return SQLService.create(category);
    }

    public Category getCategory(long categoryId) {
        return (Category) SQLService.getObjectsBySpecialColumn(new Category(),"categoryId",categoryId).get(0);
    }

    public List<Category> getAllCategories() {
        return SQLService.getAllObjects(new Category()) ;
    }

    public void updateCategory(Category category) {
        SQLService.update(category);
    }

    public void deleteCategory(Category category) {
        SQLService.delete(category);
    }
}
