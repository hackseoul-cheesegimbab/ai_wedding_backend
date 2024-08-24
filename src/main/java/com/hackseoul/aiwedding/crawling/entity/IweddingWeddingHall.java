package com.hackseoul.aiwedding.crawling.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IweddingWeddingHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String enterpriseCode;

    @Column
    private String thumbnail;

    @Column
    private String weddinghallCode;

    @Column
    private String name;

    @Column
    private String local;

    @Column
    private String style;

    @Column
    private String shape;

    @Column
    private String time;

    @Column
    private Integer minPerson;

    @Column
    private Integer seatPerson;

    @Column
    private Integer maxPerson;

    @Column
    private String food;

    @Column
    private Double minFoodFee;

    @Column
    private Double maxFoodFee;

    @Column
    private String flower;

    @Column
    private Double minArtificialFee;

    @Column
    private Double maxArtificialFee;

    @Column
    private Double minRealFee;

    @Column
    private Double maxRealFee;

    @Column
    private Double minExternalFee;

    @Column
    private Double maxExternalFee;

    @Column
    private String useStatus;

    @Column
    private Double minUseFee;

    @Column
    private Double maxUseFee;

    @Column
    private String directing;

    @Column
    private Double minDirectFee;

    @Column
    private Double maxDirectFee;

    @Column
    private String drink;

    @Column
    private Double drinkFee;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String roadAddress;

    @Column
    private String contact;

    @Column
    private String description;
}
