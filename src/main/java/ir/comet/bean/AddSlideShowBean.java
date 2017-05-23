package ir.comet.bean;


import ir.comet.database.SlideShowDaoImp;
import ir.comet.model.Article;
import ir.comet.model.SlideShow;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@ManagedBean
@javax.faces.bean.ViewScoped
public class AddSlideShowBean implements Serializable {

    private SlideShow slideShow;
    private SlideShowDaoImp slideShowDaoImp;
    private List<SlideShow> slideShowList;
    private UploadedFile uploadedFile;
    private static String image_location = StaticSettings.imageUrl;
    private String filename;
    private String uniqueID;

    @PostConstruct
    public void init()
    {
        slideShow = new SlideShow();
        slideShowDaoImp = new SlideShowDaoImp();
        slideShowList = slideShowDaoImp.getAllSlideShow();
    }

    public void addSlide(){
        FacesMessage msg;
        System.out.println(filename);
        slideShow.setImageLocation(filename);
        boolean result = slideShowDaoImp.createSlideShow(slideShow);
        if (result)
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "ذخیره شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            slideShow = new SlideShow();
            slideShowList = slideShowDaoImp.getAllSlideShow();
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void removeSlide(SlideShow slideShow)
    {
        FacesMessage msg;
        boolean result = slideShowDaoImp.deleteSlideShow(slideShow);
        if (result)
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "حذف شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            slideShowList = slideShowDaoImp.getAllSlideShow();
        }
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void editSlide()
    {
        FacesMessage msg;
        slideShow.setImageLocation(filename);
        boolean result = slideShowDaoImp.updateSlideShow(slideShow);
        if (result)
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "به روز رسانی شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            slideShowList = slideShowDaoImp.getAllSlideShow();
        }
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        slideShow = new SlideShow();
    }

    public void showArticleEditModal(SlideShow slideShow)
    {
        this.slideShow = slideShow;
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("$('#updateSlide').modal()");
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

    public SlideShow getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(SlideShow slideShow) {
        this.slideShow = slideShow;
    }

    public List<SlideShow> getSlideShowList() {
        return slideShowList;
    }

    public void setSlideShowList(List<SlideShow> slideShowList) {
        this.slideShowList = slideShowList;
    }
}
