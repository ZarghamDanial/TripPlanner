package com.TripPlanner.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
public class City extends Auditable{
    @Getter @Setter
    private String name;

    @Getter @Setter
    private Long cityCode;

    @OneToMany(mappedBy = "city")
    @Getter @Setter
    private List<TopAttractions> spots;
}
