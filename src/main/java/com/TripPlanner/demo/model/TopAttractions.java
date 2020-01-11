package com.TripPlanner.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Map;

@Entity
public class TopAttractions extends Auditable{
    @ManyToOne
    @Getter @Setter
    private City city;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int timeToCover;

    @Getter @Setter @ElementCollection
    private Map<TopAttractions, Double> distanceToOtherAttractions;

    @Getter @Setter @URL
    private String picURL;
}
