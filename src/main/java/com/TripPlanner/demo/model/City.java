package com.TripPlanner.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
//@JsonIgnoreProperties(value={"spots"}, allowGetters= true)
public class City extends Auditable{
    @Getter @Setter
    private String name;

    //@Getter @Setter
    //private Long cityId;

    //@OneToMany(mappedBy = "city")
    //@Getter @Setter
    //private List<TopAttractions> spots;
}
