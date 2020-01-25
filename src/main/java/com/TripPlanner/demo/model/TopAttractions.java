package com.TripPlanner.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(name = "Top_Attractions")
@JsonIgnoreProperties(value={"picURL"}, allowGetters= true)
public class TopAttractions extends Auditable{
    @Getter @Setter
    @ManyToOne(cascade=CascadeType.ALL)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JoinColumn(name = "city_id", nullable = false)
    @JsonProperty("city_id")
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
}