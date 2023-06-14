package com.example.catproject;

import com.google.cloud.spring.data.spanner.core.admin.SpannerDatabaseAdminTemplate;
import com.google.cloud.spring.data.spanner.core.admin.SpannerSchemaUtils;
import com.google.cloud.spring.data.spanner.repository.config.EnableSpannerRepositories;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableSpannerRepositories
@RequiredArgsConstructor
@Slf4j
public class CatProjectApplication {


  private final SpannerSchemaUtils spannerSchemaUtils;

  private final SpannerDatabaseAdminTemplate spannerDatabaseAdminTemplate;

  @EventListener(ApplicationReadyEvent.class)
  public void setUpDatabase() {
    createTablesIfNotExists();
  }

  public static void main(String[] args) {
    SpringApplication.run(CatProjectApplication.class, args);
  }

  void createTablesIfNotExists() {
    if (!this.spannerDatabaseAdminTemplate.tableExists("cats")) {
      log.info("Cat table did not exist. Will create it...");
      this.spannerDatabaseAdminTemplate.executeDdlStrings(
          List.of(this.spannerSchemaUtils.getCreateTableDdlString(Cat.class)), true);
    }
    if (!this.spannerDatabaseAdminTemplate.tableExists("dogs")) {
      log.info("Dog table did not exist. Will create it...");
      this.spannerDatabaseAdminTemplate.executeDdlStrings(
          List.of(this.spannerSchemaUtils.getCreateTableDdlString(Dog.class)), true);
    }
    log.info("Done.");
  }
}
