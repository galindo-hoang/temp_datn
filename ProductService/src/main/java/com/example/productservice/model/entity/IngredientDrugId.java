package com.example.productservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDrugId implements Serializable {
    @Column(name = "drug_id")
    private Long drugId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientDrugId that = (IngredientDrugId) o;

        if (!Objects.equals(drugId, that.drugId)) return false;
        return Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugId,ingredientId);
    }
}
