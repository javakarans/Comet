package ir.comet.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class SlideShow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long slideId;
    @Type(type = "text")
    private String slideText;
    @Type(type = "text")
    private String slideTitle;
    @Type(type = "text")
    private String imageLocation;

    public long getSlideId() {
        return slideId;
    }

    public void setSlideId(long slideId) {
        this.slideId = slideId;
    }

    public String getSlideText() {
        return slideText;
    }

    public void setSlideText(String slideText) {
        this.slideText = slideText;
    }

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
