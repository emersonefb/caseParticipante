package br.com.efb.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ParticipantePageDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T17:40:38.745788800-03:00[America/Sao_Paulo]")


public class ParticipantePageDTO   {
  @JsonProperty("totalPages")
  private Integer totalPages = null;

  @JsonProperty("total_elements")
  private Integer totalElements = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("per_page")
  private Integer perPage = null;

  @JsonProperty("has_next")
  private Boolean hasNext = null;

  @JsonProperty("has_prev")
  private Boolean hasPrev = null;

  @JsonProperty("content")
  @Valid
  private List<ParticipanteDTO> content = null;

  public ParticipantePageDTO totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
   **/
 
  
    public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public ParticipantePageDTO totalElements(Integer totalElements) {
    this.totalElements = totalElements;
    return this;
  }


  /**
   * Get totalElements
   * @return totalElements
   **/


  public Integer getTotalElements() {
    return totalElements;
  }


  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public ParticipantePageDTO page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
   **/
 
  
    public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ParticipantePageDTO perPage(Integer perPage) {
    this.perPage = perPage;
    return this;
  }

  /**
   * Get perPage
   * @return perPage
   **/
 
  
    public Integer getPerPage() {
    return perPage;
  }

  public void setPerPage(Integer perPage) {
    this.perPage = perPage;
  }

  public ParticipantePageDTO hasNext(Boolean hasNext) {
    this.hasNext = hasNext;
    return this;
  }

  /**
   * Get hasNext
   * @return hasNext
   **/
  
  
    public Boolean isHasNext() {
    return hasNext;
  }

  public void setHasNext(Boolean hasNext) {
    this.hasNext = hasNext;
  }

  public ParticipantePageDTO hasPrev(Boolean hasPrev) {
    this.hasPrev = hasPrev;
    return this;
  }

  /**
   * Get hasPrev
   * @return hasPrev
   **/
  
  
    public Boolean isHasPrev() {
    return hasPrev;
  }

  public void setHasPrev(Boolean hasPrev) {
    this.hasPrev = hasPrev;
  }

  public ParticipantePageDTO content(List<ParticipanteDTO> content) {
    this.content = content;
    return this;
  }

  public ParticipantePageDTO addContentItem(ParticipanteDTO contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
   **/
  
      @Valid
    public List<ParticipanteDTO> getContent() {
    return content;
  }

  public void setContent(List<ParticipanteDTO> content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParticipantePageDTO participantePage = (ParticipantePageDTO) o;
    return Objects.equals(this.totalPages, participantePage.totalPages) &&
        Objects.equals(this.totalElements, participantePage.totalElements) &&
        Objects.equals(this.page, participantePage.page) &&
        Objects.equals(this.perPage, participantePage.perPage) &&
        Objects.equals(this.hasNext, participantePage.hasNext) &&
        Objects.equals(this.hasPrev, participantePage.hasPrev) &&
        Objects.equals(this.content, participantePage.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, totalElements, page, perPage, hasNext, hasPrev, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParticipantePageDTO {\n");
    
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    perPage: ").append(toIndentedString(perPage)).append("\n");
    sb.append("    hasNext: ").append(toIndentedString(hasNext)).append("\n");
    sb.append("    hasPrev: ").append(toIndentedString(hasPrev)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
