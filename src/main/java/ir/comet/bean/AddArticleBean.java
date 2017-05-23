package ir.comet.bean;

import ir.comet.Utilities.SolarCalendar;
import ir.comet.database.ArticleDaoImp;
import ir.comet.database.SQLService;
import ir.comet.model.Article;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by amir on 5/23/2017.
 */

@ManagedBean
@ViewScoped
public class AddArticleBean{
    private Article article;
    private ArticleDaoImp articleDaoImp;
    private List<Article> articleList;
    private String uniqueID;
    private UploadedFile uploadedFile;
    private static String image_location = StaticSettings.imageUrl;
    private String filename;
    private SolarCalendar solarCalendar;

    @PostConstruct
    public void init()
    {
        uniqueID = UUID.randomUUID().toString();
        articleDaoImp = new ArticleDaoImp();
        article = new Article();
        solarCalendar=new SolarCalendar();
        articleList = articleDaoImp.getAllArticles();
    }


    public void processFileUploadEdit(FileUploadEvent event) throws IOException {
        uniqueID = UUID.randomUUID().toString();
        this.uploadedFile = event.getFile();
        String[] tokens = uploadedFile.getFileName().split("\\.(?=[^\\.]+$)");
        String fileExtention = tokens[1];
        try {
            InputStream inputStream = event.getFile().getInputstream();
            filename = image_location+uniqueID+"."+fileExtention;
            Path des = Paths.get(filename);
            Files.copy(inputStream,des);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public void saveArticle()
    {
        article.setImageUrl(filename);
        article.setDate(solarCalendar.getCurrentShamsidate());
        boolean result = articleDaoImp.createArticle(article);
        if (result) {

            article = new Article();
            articleList = articleDaoImp.getAllArticles();
            uploadedFile = null;
            //show message
        }
        else
        {
            //show error
        }

    }

    public void editArticle()
    {
        article.setImageUrl(filename);
        article.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()).toString());
        boolean result = articleDaoImp.updateArticle(article);


        article = new Article();
        articleList = articleDaoImp.getAllArticles();
        uploadedFile = null;


    }

    public void removeArticle(Article article)
    {
        boolean result = articleDaoImp.deleteArticle(article);
        if (result)
        {
            articleList = articleDaoImp.getAllArticles();
        }
        else
        {

        }
    }

    public void showArticleEditModal(Article article)
    {
        this.article = article;
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("$('#updateArticle').modal()");
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
