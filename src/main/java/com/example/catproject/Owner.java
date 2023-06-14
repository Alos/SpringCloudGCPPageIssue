package com.example.catproject;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.spanner.v1.TypeCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Owner {
  private String name;
  @Column(spannerType = TypeCode.JSON)
  private Address address;
}
