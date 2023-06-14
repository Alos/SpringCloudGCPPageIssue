package com.example.catproject;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CatController {

  private final CatRepository catRepository;

  private final DogRepository dogRepository;

  @GetMapping("/api/v1/cats")
  public Page<Cat> getCatsByName(
      @RequestParam(value = "name", required = false) String name,
      @PageableDefault(size = 20) Pageable pageable) {
    return catRepository.findCatsByNameContaining(name, pageable);
  }

  @GetMapping("/api/v1/owner")
  public List<Cat> getCatsByOwnerName(
      @RequestParam(value = "name", required = false) String name) {
    return catRepository.findCatsByOwnerName(name);
  }

  @GetMapping("/api/v1/populate")
  public String populateDB() {
    Owner owner = new Owner().setName("Jon").setAddress(new Address().setStreetName("Some street").setCountry("USA"));
    Cat cat = new Cat();
    cat.setNumberOfLives(9).setName("Garfield").setAge(3).setOwner(owner);
    Dog dog = new Dog();
    dog.setNumberOfFleas(10).setName("Oddie").setAge(3).setOwner(owner);

    catRepository.save(cat);
    dogRepository.save(dog);

    Owner owner2 = new Owner().setName("Bob").setAddress(new Address().setStreetName("Another street").setCountry("COL"));
    Cat cat2 = new Cat();
    cat2.setNumberOfLives(9).setName("fluffy").setAge(6).setOwner(owner2);
    Cat cat3 = new Cat();
    cat3.setNumberOfLives(9).setName("albert").setAge(4).setOwner(owner2);

    catRepository.save(cat2);
    catRepository.save(cat3);
    //use the new cat
    return "Done.";
  }

}
