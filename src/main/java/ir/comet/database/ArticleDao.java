package ir.comet.database;


import ir.comet.model.Article;

import java.util.List;

public interface ArticleDao {
    public void createArticle(Article article);
    public ArticleDao getArticle(long articleId);
    public List<Article> getAllArticles();
    public void updateArticle(Article article);
    public void deleteArticle(Article article);
}
