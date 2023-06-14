package com.example.catproject;


import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Table(name = "dogs")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Dog extends Animal {
  private int numberOfFleas;
  public AnimalType getType() {
    return AnimalType.DOG;
  }
}
