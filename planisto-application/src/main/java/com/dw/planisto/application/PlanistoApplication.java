package com.dw.planisto.application;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.planisto.filter.ResponseFilter;
import com.dw.planisto.resources.SearchResource;
import com.dw.planisto.resources.WelcomeResource;

public class PlanistoApplication extends Application<PlanistoConfiguration>{

	  private static final Logger LOG = LoggerFactory.getLogger(PlanistoApplication.class);

	  public static void main(String[] args) {
	    try {
	      new PlanistoApplication().run(args);
	    } catch (Exception e) {
	      LOG.error("main - Exception :: {}, {} ", e, e.getMessage());
	    }
	  }

	  @Override
	  public void initialize(Bootstrap<PlanistoConfiguration> bootstrap) {
//	    bootstrap.addBundle(new FlywayBundle<KfitConfiguration>() {
//	      @Override
//	      public DataSourceFactory getDataSourceFactory(KfitConfiguration configuration) {
//	        return  configuration.getDataSourceFactory();
//	      }
//
//	      @Override
//	      public FlywayFactory getFlywayFactory(KfitConfiguration configuration) {
//	        return configuration.getFlywayFactory(configuration);
//	      }
//	    });
	  }

	  @SuppressWarnings("unchecked")
	  @Override
	  public void run(PlanistoConfiguration configuration, Environment environment) throws Exception {

	    // JDBI Configuration
	    final DBIFactory factory = new DBIFactory();
	    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
	    
	    environment.jersey().register(new WelcomeResource());
	    environment.jersey().register(new SearchResource(jdbi));
//	    
//	    environment.jersey().getResourceConfig().getContainerRequestFilters().add(new RequestFilter(jdbi));
	    environment.jersey().getResourceConfig().getContainerResponseFilters().add(new ResponseFilter());

	  }
}
