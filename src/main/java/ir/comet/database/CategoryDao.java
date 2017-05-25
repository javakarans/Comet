package ir.comet.database;

import ir.comet.model.Category;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface CategoryDao {

    public boolean createCategory(Category category);
    public Category getCategory(long categoryId);
    public List<Category> getAllCategories();
    public boolean updateCategory(Category category);
    public boolean deleteCategory(Category category);

}
