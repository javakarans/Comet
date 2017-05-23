package ir.comet.database;

import ir.comet.model.Article;

import java.util.List;

public class ArticleDaoImp implements ArticleDao {

    private SQLService SQLService;

    public ArticleDaoImp(){
         SQLService =new SQLService();
    }

    public boolean createArticle(Article article) {
        return SQLService.create(article);
    }

    public Article getArticle(long articleId) {
        List<Article> result =  SQLService.getObjectsBySpecialColumn(new Article(),"articleId",articleId);
        if (result.isEmpty())
            return null;
        else
            return (Article) result.get(0);
    }

    public List<Article> getAllArticles() {

       return   SQLService.getAllObjects(new Article());
    }

    public boolean updateArticle(Article article) {
        return SQLService.update(article);
    }

    public boolean deleteArticle(Article article) {
        return SQLService.delete(article);
    }
}
