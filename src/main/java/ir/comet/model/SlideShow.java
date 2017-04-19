package ir.comet.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class SlideShow implements Serializable {
    private long slideId;
    private String slideText;
    private int slideNumber;
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

    @Column
    public String getSlideText() {
        return slideText;
    }

    public void setSlideText(String slideText) {
        this.slideText = slideText;
    }

    @Column
    public int getSlideNumber() {
        return slideNumber;
    }

    public void setSlideNumber(int slideNumber) {
        this.slideNumber = slideNumber;
    }

    @Column
    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitile) {
        this.slideTitle = slideTitile;
    }
}
