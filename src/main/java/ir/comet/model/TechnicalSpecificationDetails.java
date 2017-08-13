package ir.comet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amir on 5/25/2017.
 */
@Entity
public class TechnicalSpecificationDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long technicalSpecificationDetailsId;
    private String name;
    private String valence;
    @ManyToOne
    @JoinColumn(name = "technicalSpecificationId")
    private TechnicalSpecification technicalSpecification;

    public long getTechnicalSpecificationDetailsId() {
        return technicalSpecificationDetailsId;
    }

    public void setTechnicalSpecificationDetailsId(long technicalSpecificationDetailsId) {
        this.technicalSpecificationDetailsId = technicalSpecificationDetailsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String key) {
        this.name = key;
    }

    public String getValence() {
        return valence;
    }

    public void setValence(String value) {
        this.valence = value;
    }

    public TechnicalSpecification getTechnicalSpecification() {
        return technicalSpecification;
    }

    public void setTechnicalSpecification(TechnicalSpecification technicalSpecification) {
        this.technicalSpecification = technicalSpecification;
    }
}
