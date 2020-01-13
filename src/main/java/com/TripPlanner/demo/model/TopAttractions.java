package com.TripPlanner.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(name = "Top_Attractions")
@JsonIgnoreProperties(value={"picURL"}, allowGetters= true)
public class TopAttractions extends Auditable{
    @Getter @Setter
    @ManyToOne()
    private City city;

    //@Getter @Setter
    //private String typeOfAttraction;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int timeToCover;

    //@Getter @Setter
    //private Double latitude;

    //@Getter @Setter
    //private Double longitude;

    //@Getter @Setter @ElementCollection
    //private Map<TopAttractions, Long> distanceToOtherAttractions;

    @Getter @Setter @URL
    private String picURL;

    /*public TopAttractions(String name, String typeOfAttraction, Double latitude, Double longitude, int timeToCover, City city) {
        this.name = name;
        this.typeOfAttraction=typeOfAttraction;
        this.latitude=latitude;
        this.longitude=longitude;
        this.timeToCover=timeToCover;
        this.city=city;
    }

    public TopAttractions() {
    }*/
}