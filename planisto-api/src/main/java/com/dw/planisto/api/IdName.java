package com.dw.planisto.api;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author manoj
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IdName {
  private Integer id;
  private String name;
  
  
  /**    Getter Setter **/
    
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
