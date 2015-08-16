package com.dw.planisto.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.planisto.api.IdName;
import com.dw.planisto.dao.SearchDAO;


/**
 * 
 * @author Manoj
 *
 */

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
  private static final Logger LOG = LoggerFactory.getLogger(SearchResource.class);
  private SearchDAO searchDao;
  public SearchResource(DBI jdbi){
    searchDao = new SearchDAO(jdbi);
  }
  
  @GET
  @Path("/categories")
  public List<IdName> getCategoryList(@QueryParam("term") String term ){
	List<IdName> returnList = new ArrayList<IdName>();
    LOG.info("getCategoryList - Fetching Event categories list for the term {}", term);
    if(StringUtils.isNotBlank(term)) {
    	returnList = searchDao.getCategoriesList("%" + term.toLowerCase() + "%");
    }
    return returnList;
  }

}
