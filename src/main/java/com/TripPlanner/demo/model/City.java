package com.TripPlanner.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
@JsonIgnoreProperties(value={"spots"}, allowGetters= true)
public class City extends Auditable{
    @Getter @Setter
    private String name;

    @Getter @Setter
    private Long cityCode;

    @OneToMany(mappedBy = "city")
    @Getter @Setter
    private List<TopAttractions> spots;
}
