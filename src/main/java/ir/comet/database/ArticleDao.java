package ir.comet.database;


import ir.comet.model.Article;

import java.util.List;

public interface ArticleDao {
    public boolean createArticle(Article article);
    public Article getArticle(long articleId);
    public List<Article> getAllArticles();
    public boolean updateArticle(Article article);
    public boolean deleteArticle(Article article);
}
