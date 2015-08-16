package com.dw.planisto.dao;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.planisto.api.IdName;

public class SearchDAO {
   private static final Logger LOG = LoggerFactory.getLogger(SearchDAO.class);
    private DBI jdbi;
    
    /**
     * Parameterized constructor
     * @param jdbi
     */
    public SearchDAO(DBI jdbi) {
      this.jdbi = jdbi;
    }
    
    public List<IdName>getCategoriesList(String term) {
      StringBuilder queryBuilder = new StringBuilder()
      .append("Select id, name from plan.type where lower(name) like :term");
      LOG.debug("getCategoriesList - query :<{}>", queryBuilder.toString());
      try(Handle handle = jdbi.open()) {
          return handle.createQuery(queryBuilder.toString()).bind("term", term)
        		  .map(IdName.class).list();
      }
    }

}
