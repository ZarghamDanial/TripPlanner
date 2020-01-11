package com.TripPlanner.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Getter @Setter
    private String name;

    @Getter @Setter
    private Long cityCode;

    //@Getter @Setter
    //private List<TopAttractions> spots;
}
