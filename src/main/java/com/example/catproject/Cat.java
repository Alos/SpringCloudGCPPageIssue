package com.example.catproject;

import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

;

@Table(name = "cats")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Cat extends Animal {
  private int numberOfLives;
  public AnimalType getType() {
    return AnimalType.CAT;
  }
}
