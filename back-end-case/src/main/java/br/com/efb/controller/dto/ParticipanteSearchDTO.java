package br.com.efb.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ParticipanteSearchDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T17:40:38.745788800-03:00[America/Sao_Paulo]")


public class ParticipanteSearchDTO   {
  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("codigoExterno")
  private String codigoExterno = null;

  @JsonProperty("nome")
  private String nome = null;

  public ParticipanteSearchDTO size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
   **/
  
  
    public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public ParticipanteSearchDTO page(Integer page) {
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

  public ParticipanteSearchDTO codigoExterno(String codigoExterno) {
    this.codigoExterno = codigoExterno;
    return this;
  }

  /**
   * Get codigoExterno
   * @return codigoExterno
   **/
  
  
    public String getCodigoExterno() {
    return codigoExterno;
  }

  public void setCodigoExterno(String codigoExterno) {
    this.codigoExterno = codigoExterno;
  }

  public ParticipanteSearchDTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   **/
  
  
    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParticipanteSearchDTO participanteSearch = (ParticipanteSearchDTO) o;
    return Objects.equals(this.size, participanteSearch.size) &&
        Objects.equals(this.page, participanteSearch.page) &&
        Objects.equals(this.codigoExterno, participanteSearch.codigoExterno) &&
        Objects.equals(this.nome, participanteSearch.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, page, codigoExterno, nome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParticipanteSearchDTO {\n");
    
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    codigoExterno: ").append(toIndentedString(codigoExterno)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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
