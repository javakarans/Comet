package ir.comet.database;

import ir.comet.model.Category;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface CategoryDao {

    public void createCategory(Category category);
    public Category getCategory(long categoryId);
    public List<Category> getAllCategories();
    public void updateCategory(Category category);
    public void deleteCategory(Category category);

}
