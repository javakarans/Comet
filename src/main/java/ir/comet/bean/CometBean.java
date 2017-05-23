package ir.comet.bean;

import ir.comet.database.ArticleDaoImp;
import ir.comet.model.Article;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohammad on 5/23/2017.
 */
@ManagedBean
@ViewScoped
public class CometBean {


    private List<Article> articleList;

    @PostConstruct
    public void init(){
        loadArticle();
    }

    public void loadArticle(){
        ArticleDaoImp articleDaoImp=new ArticleDaoImp();
        articleList = articleDaoImp.getAllArticles();
        Collections.reverse(articleList);
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
