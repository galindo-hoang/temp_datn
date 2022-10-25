package com.example.productservice.model.entity;

import com.example.productservice.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Drug")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DrugName")
    private String drugName;
    @Column(name = "Image")
    private byte[] image;
    @Column(name = "DosageForm")
    private String dosageForm;
    @Column(name = "Indication")
    private String indication;
    @Column(name = "Contraindication")
    private String contraIndication;
    @Column(name = "Interaction")
    private String interaction;
    @Column(name = "SideEffect")
    private String sideEffect;
    @Column(name = "ExpiredDate")
    private String expiredDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "drug_category",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryEntity> categories = new HashSet<>();
//    @ManyToOne(fetch = FetchType.LAZY)
    private String manufacture;
    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredientDrugEntity> ingredients = new ArrayList<>();

    public void addIngredient(IngredientEntity ingredient, String unit, Integer numberUnit) {
        IngredientDrugEntity ingredientDrugEntity = new IngredientDrugEntity(
                new IngredientDrugId(this.id,ingredient.getId()), this, ingredient, unit, numberUnit
        );
        ingredients.add(ingredientDrugEntity);
        ingredient.getDrugs().add(ingredientDrugEntity);
    }
}
