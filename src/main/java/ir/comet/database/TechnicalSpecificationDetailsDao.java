package ir.comet.database;

import ir.comet.model.TechnicalSpecification;
import ir.comet.model.TechnicalSpecificationDetails;

import java.util.List;

/**
 * Created by amir on 5/25/2017.
 */
public interface TechnicalSpecificationDetailsDao {
    public boolean createTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails);
    public TechnicalSpecificationDetails getTechnicalSpecificationDetails(long technicalSpecificationDetailsId);
    public List<TechnicalSpecificationDetails> getAllTechnicalSpecificationDetails();
    public boolean updateTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails);
    public boolean deleteTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails);
}
