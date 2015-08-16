package com.dw.planisto.application;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanistoConfiguration extends Configuration{

	  @Valid
	  @NotNull
	  @JsonProperty
	  private DataSourceFactory database = new DataSourceFactory();
	  
	  public DataSourceFactory getDataSourceFactory() {
	    return database;
	  }

//	  @Valid
//	  @NotNull
//	  @JsonProperty("flyway")
//	  private FlywayFactory flywayFactory = new FlywayFactory();
//	  
//	  @Override
//	  public FlywayFactory getFlywayFactory(Configuration configuration) {
//	    return flywayFactory;
//	  }
}
