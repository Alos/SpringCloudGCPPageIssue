package com.example.catproject;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends SpannerRepository<Cat, String> {
  @Query("select * from cats where JSON_VALUE(cats.owner.name) = @name")
  List<Cat> findCatsByOwnerName(@NonNull String name);

  Page<Cat> findCatsByNameContaining(@NonNull String name, @NonNull Pageable pageable);
}
