package ir.comet.database;



import ir.comet.model.SlideShow;

import java.util.List;

public interface SlideShowDao {
    public int createSlideShow(SlideShow slideShow);
    public SlideShow getSlideShow(long slideShowId);
    public List<SlideShow> getAllSlideShow();
    public int updateSlideShow(SlideShow slideShow);
    public int deleteSlideShow(SlideShow slideShow);
}
