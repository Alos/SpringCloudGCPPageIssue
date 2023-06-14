package com.example.catproject;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
  private String streetName;
  private String country;
}
