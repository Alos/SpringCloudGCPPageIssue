package com.example.catproject;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.spanner.v1.TypeCode;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Animal {
  @PrimaryKey
  private String name;
  private int age;
  @Column(spannerType = TypeCode.JSON)
  private Owner owner;
  private AnimalType type;
}
