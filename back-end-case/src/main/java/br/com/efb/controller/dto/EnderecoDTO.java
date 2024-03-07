package br.com.efb.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * EnderecoDTO
 */


public class EnderecoDTO   {
  @JsonProperty("idEndereco")
  private Long idEndereco = null;

  @JsonProperty("cep")
  private String cep = null;

  @JsonProperty("logradouro")
  private String logradouro = null;

  @JsonProperty("numero")
  private Integer numero = null;

  @JsonProperty("complemento")
  private String complemento = null;

  @JsonProperty("cidade")
  private String cidade = null;

  @JsonProperty("estado")
  private String estado = null;

  @JsonProperty("pais")
  private String pais = null;

  public EnderecoDTO idEndereco(Long idEndereco) {
    this.idEndereco = idEndereco;
    return this;
  }

  /**
   * Get idEndereco
   * @return idEndereco
   **/
 
  
    public Long getIdEndereco() {
    return idEndereco;
  }

  public void setIdEndereco(Long idEndereco) {
    this.idEndereco = idEndereco;
  }

  public EnderecoDTO cep(String cep) {
    this.cep = cep;
    return this;
  }

  /**
   * Get cep
   * @return cep
   **/
 
  
    public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public EnderecoDTO logradouro(String logradouro) {
    this.logradouro = logradouro;
    return this;
  }

  /**
   * Get logradouro
   * @return logradouro
   **/
 
  
    public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public EnderecoDTO numero(Integer numero) {
    this.numero = numero;
    return this;
  }

  /**
   * Get numero
   * @return numero
   **/
 
  
    public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public EnderecoDTO complemento(String complemento) {
    this.complemento = complemento;
    return this;
  }

  /**
   * Get complemento
   * @return complemento
   **/
 
  
    public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public EnderecoDTO cidade(String cidade) {
    this.cidade = cidade;
    return this;
  }

  /**
   * Get cidade
   * @return cidade
   **/
 
  
    public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public EnderecoDTO estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
   **/
 
  
    public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public EnderecoDTO pais(String pais) {
    this.pais = pais;
    return this;
  }

  /**
   * Get pais
   * @return pais
   **/
 
  
    public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnderecoDTO endereco = (EnderecoDTO) o;
    return Objects.equals(this.idEndereco, endereco.idEndereco) &&
        Objects.equals(this.cep, endereco.cep) &&
        Objects.equals(this.logradouro, endereco.logradouro) &&
        Objects.equals(this.numero, endereco.numero) &&
        Objects.equals(this.complemento, endereco.complemento) &&
        Objects.equals(this.cidade, endereco.cidade) &&
        Objects.equals(this.estado, endereco.estado) &&
        Objects.equals(this.pais, endereco.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEndereco, cep, logradouro, numero, complemento, cidade, estado, pais);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnderecoDTO {\n");
    
    sb.append("    idEndereco: ").append(toIndentedString(idEndereco)).append("\n");
    sb.append("    cep: ").append(toIndentedString(cep)).append("\n");
    sb.append("    logradouro: ").append(toIndentedString(logradouro)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    complemento: ").append(toIndentedString(complemento)).append("\n");
    sb.append("    cidade: ").append(toIndentedString(cidade)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
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
