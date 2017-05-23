package ir.comet.database;



import ir.comet.model.SlideShow;

import java.util.List;

public class SlideShowDaoImp implements SlideShowDao {

    private SQLService SQLService;

    public SlideShowDaoImp()
    {
        SQLService = new SQLService();
    }

    public boolean createSlideShow(SlideShow slideShow){
        return SQLService.create(slideShow);
    }

    public SlideShow getSlideShow(long slideShowId) {
        List result = SQLService.getObjectsBySpecialColumn(new SlideShow(),"slideId",slideShowId);
        if (result.isEmpty())
            return null;
        else return (SlideShow) result.get(0);
    }

    public List<SlideShow> getAllSlideShow() {

        return SQLService.getAllObjects(new SlideShow());
    }

    public boolean updateSlideShow(SlideShow slideShow) {

        return SQLService.delete(slideShow);
    }

    public boolean deleteSlideShow(SlideShow slideShow) {

        return SQLService.delete(slideShow);
    }


}
