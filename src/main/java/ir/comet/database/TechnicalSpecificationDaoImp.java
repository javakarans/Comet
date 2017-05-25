package ir.comet.database;

import ir.comet.model.TechnicalSpecification;

import java.util.List;

/**
 * Created by amir on 5/25/2017.
 */
public class TechnicalSpecificationDaoImp implements TechnicalSpecificationDao {

    private SQLService sqlService;

    public TechnicalSpecificationDaoImp()
    {
        sqlService = new SQLService();
    }

    @Override
    public boolean createTechnicalSpecification(TechnicalSpecification technicalSpecification) {
        return sqlService.create(technicalSpecification);
    }

    @Override
    public TechnicalSpecification getTechnicalSpecification(long technicalSpecificationId) {
        List result = sqlService.getObjectsBySpecialColumn(new TechnicalSpecification(),"technicalSpecificationId",technicalSpecificationId);
        if (result.isEmpty()) return null;
        else return (TechnicalSpecification) result.get(0);
    }

    @Override
    public List<TechnicalSpecification> getAllTechnicalSpecification() {
        return sqlService.getAllObjects(new TechnicalSpecification());
    }

    @Override
    public boolean updateTechnicalSpecification(TechnicalSpecification technicalSpecification) {
        return sqlService.update(technicalSpecification);
    }

    @Override
    public boolean deleteTechnicalSpecification(TechnicalSpecification technicalSpecification) {
        return sqlService.delete(technicalSpecification);
    }
}
