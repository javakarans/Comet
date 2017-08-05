package ir.comet.model;

import org.hibernate.annotations.Type;

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
    private String key;
    private String value;
    @ManyToOne
    @JoinColumn(name = "technicalSpecificationId")
    private TechnicalSpecification technicalSpecification;

    public long getTechnicalSpecificationDetailsId() {
        return technicalSpecificationDetailsId;
    }

    public void setTechnicalSpecificationDetailsId(long technicalSpecificationDetailsId) {
        this.technicalSpecificationDetailsId = technicalSpecificationDetailsId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TechnicalSpecification getTechnicalSpecification() {
        return technicalSpecification;
    }

    public void setTechnicalSpecification(TechnicalSpecification technicalSpecification) {
        this.technicalSpecification = technicalSpecification;
    }
}
