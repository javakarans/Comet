package ir.comet.bean;

import ir.comet.database.ArticleDaoImp;
import ir.comet.model.Article;
import org.jsoup.Jsoup;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Mohammad on 5/23/2017.
 */
@ManagedBean
@ViewScoped
public class ProductArticleBean {

    private Article article;

    @PostConstruct
    public void init(){
        loadArticle();
    }

    public long getArticleId(){
        String articleId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleId");
        return Long.parseLong(articleId);
    }

    public void loadArticle(){
        ArticleDaoImp articleDaoImp=new ArticleDaoImp();
        article = articleDaoImp.getArticle(getArticleId());
    }

    public String showArticleContent(){
        return Jsoup.parse(article.getContent()).text();
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
