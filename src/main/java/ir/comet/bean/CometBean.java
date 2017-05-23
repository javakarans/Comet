package ir.comet.bean;

import ir.comet.database.ArticleDaoImp;
import ir.comet.database.SlideShowDaoImp;
import ir.comet.model.Article;
import ir.comet.model.SlideShow;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
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
    private List<SlideShow> allSlideShow;

    @PostConstruct
    public void init(){
        loadSlideShow();
        loadArticle();
    }

    public void loadArticle(){
        ArticleDaoImp articleDaoImp=new ArticleDaoImp();
        List<Article> allArticles = articleDaoImp.getAllArticles();
        int count=0;
        articleList=new ArrayList<>();
        Collections.reverse(allArticles);
        for (Article article:allArticles){
            articleList.add(article);
            count++;
            if (count==6){
                break;
            }
        }
    }

    public void loadSlideShow(){
        SlideShowDaoImp slideShowDaoImp=new SlideShowDaoImp();
        allSlideShow = slideShowDaoImp.getAllSlideShow();
    }

    public String redirectToArticlePage(Article article){
        return "/user/productArticle.xhtml?faces-redirect=true&articleId="+article.getArticleId();
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<SlideShow> getAllSlideShow() {
        return allSlideShow;
    }

    public void setAllSlideShow(List<SlideShow> allSlideShow) {
        this.allSlideShow = allSlideShow;
    }
}
