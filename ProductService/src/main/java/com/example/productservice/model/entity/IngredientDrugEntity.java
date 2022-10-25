package com.example.productservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "IngredientDrug")
@Table(name = "ingredient_drug")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDrugEntity {
    @EmbeddedId
    private IngredientDrugId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("drugId")
    private DrugEntity drug;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredientId")
    private IngredientEntity ingredient;

    @Column
    private String unit;
    @Column(name = "number_unit")
    private Integer numberUnit;
}
