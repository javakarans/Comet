package ir.comet.database;

import ir.comet.model.TechnicalSpecification;
import ir.comet.model.TechnicalSpecificationDetails;

import java.util.List;

/**
 * Created by amir on 5/25/2017.
 */
public class TechnicalSpecificationDetailsDaoImp implements TechnicalSpecificationDetailsDao {

    private SQLService sqlService;

    public  TechnicalSpecificationDetailsDaoImp()
    {
        sqlService = new SQLService();
    }

    @Override
    public boolean createTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails) {
        return sqlService.create(technicalSpecificationDetails);
    }

    @Override
    public TechnicalSpecificationDetails getTechnicalSpecificationDetails(long technicalSpecificationDetailsId) {
        List result = sqlService.getObjectsBySpecialColumn(new TechnicalSpecificationDetails(),"technicalSpecificationDetailsId",technicalSpecificationDetailsId);
        if (result.isEmpty()) return null;
        else return (TechnicalSpecificationDetails) result.get(0);
    }

    @Override
    public List<TechnicalSpecificationDetails> getAllTechnicalSpecificationDetails() {
        return sqlService.getAllObjects(new TechnicalSpecificationDetails());
    }

    @Override
    public boolean updateTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails) {
        return sqlService.update(technicalSpecificationDetails);
    }

    @Override
    public boolean deleteTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails) {
        return sqlService.delete(technicalSpecificationDetails);
    }
}
