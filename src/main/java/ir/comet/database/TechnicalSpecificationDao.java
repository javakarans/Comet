package ir.comet.database;

import ir.comet.model.Category;
import ir.comet.model.TechnicalSpecification;

import java.util.List;

/**
 * Created by amir on 5/25/2017.
 */
public interface TechnicalSpecificationDao {

    public boolean createTechnicalSpecification(TechnicalSpecification technicalSpecification);
    public TechnicalSpecification getTechnicalSpecification(long technicalSpecificationId);
    public List<TechnicalSpecification> getAllTechnicalSpecification();
    public boolean updateTechnicalSpecification(TechnicalSpecification technicalSpecification);
    public boolean deleteTechnicalSpecification(TechnicalSpecification technicalSpecification);

}
