package ir.comet.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class SlideShow implements Serializable {
    private long slideId;
    private String slideText;
    private String slideTitle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getSlideId() {
        return slideId;
    }

    public void setSlideId(long slideId) {
        this.slideId = slideId;
    }

    @Type(type = "text")
    public String getSlideText() {
        return slideText;
    }

    public void setSlideText(String slideText) {
        this.slideText = slideText;
    }

    @Column
    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitile) {
        this.slideTitle = slideTitile;
    }
}
