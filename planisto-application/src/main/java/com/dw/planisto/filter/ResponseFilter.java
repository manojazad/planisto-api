package com.dw.planisto.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * 
 * @author manoj
 *
 */
public class ResponseFilter implements ContainerResponseFilter {

	  @Override
	  public ContainerResponse filter(ContainerRequest request,
	                                  ContainerResponse response) {

	    response.getResponse().getMetadata().add("Access-Control-Allow-Credentials", "*");
	    response.getResponse().getMetadata().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, accessToken,If-Modified-Since");
	    response.getResponse().getMetadata().add("Access-Control-Allow-Origin", "*");
	    response.getResponse().getMetadata().add("Access-Control-Allow-Methods",
	        "GET, POST, PUT, DELETE, OPTIONS");
	    return response;
	  }

	}
