package ir.comet.database;



import ir.comet.model.SlideShow;

import java.util.List;

public interface SlideShowDao {
    public boolean createSlideShow(SlideShow slideShow);
    public SlideShow getSlideShow(long slideShowId);
    public List<SlideShow> getAllSlideShow();
    public boolean updateSlideShow(SlideShow slideShow);
    public boolean deleteSlideShow(SlideShow slideShow);
}
