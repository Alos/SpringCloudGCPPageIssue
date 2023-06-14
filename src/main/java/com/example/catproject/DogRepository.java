package com.example.catproject;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository  extends SpannerRepository<Dog, String> {
  List<Dog> findDogsByNameContaining(@NonNull String name);

}
