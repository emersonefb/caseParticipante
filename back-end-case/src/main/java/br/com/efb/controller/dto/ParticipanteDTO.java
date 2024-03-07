package br.com.efb.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ParticipanteDTO
 */

public class ParticipanteDTO   {
  @JsonProperty("codigo")
  private Long codigo = null;

  @JsonProperty("codigoExterno")
  private String codigoExterno = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("cpf")
  private String cpf = null;

  @JsonProperty("cpfAplicavel")
  private Boolean cpfAplicavel = null;

  @JsonProperty("sexo")
  private String sexo = null;

  @JsonProperty("estadoCivil")
  private String estadoCivil = null;

  @JsonProperty("conjuge")
  private String conjuge = null;

  @JsonProperty("documentoIdentificacao")
  private String documentoIdentificacao = null;

  @JsonProperty("obsSemImpact")
  private String obsSemImpact = null;

  @JsonProperty("condicaoPessoal")
  private String condicaoPessoal = null;

  @JsonProperty("telefone")
  private String telefone = null;

  @JsonProperty("celular")
  private String celular = null;

  @JsonProperty("validateFichaCadastral")
  private String validateFichaCadastral = null;

  @JsonProperty("dataNascimento")
  private String dataNascimento = null;

  @JsonProperty("habilitaEnvioToken")
  private Boolean habilitaEnvioToken = null;

  @JsonProperty("status")
  private Boolean status = null;

  @JsonProperty("ppe")
  private Boolean ppe = null;

  @JsonProperty("assinaDigital")
  private Boolean assinaDigital = null;

  @JsonProperty("enderecoList")
  @Valid
  private List<EnderecoDTO> enderecoList = null;

  public ParticipanteDTO codigo(Long codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Get codigo
   * @return codigo
   **/
 
  
    public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public ParticipanteDTO codigoExterno(String codigoExterno) {
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

  public ParticipanteDTO nome(String nome) {
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

  public ParticipanteDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
 
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ParticipanteDTO cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
   **/
 
  
    public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public ParticipanteDTO cpfAplicavel(Boolean cpfAplicavel) {
    this.cpfAplicavel = cpfAplicavel;
    return this;
  }

  /**
   * Get cpfAplicavel
   * @return cpfAplicavel
   **/
 
  
    public Boolean isCpfAplicavel() {
    return cpfAplicavel;
  }

  public void setCpfAplicavel(Boolean cpfAplicavel) {
    this.cpfAplicavel = cpfAplicavel;
  }

  public ParticipanteDTO sexo(String sexo) {
    this.sexo = sexo;
    return this;
  }

  /**
   * Get sexo
   * @return sexo
   **/
 
  
    public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public ParticipanteDTO estadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
    return this;
  }

  /**
   * Get estadoCivil
   * @return estadoCivil
   **/
 
  
    public String getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public ParticipanteDTO conjuge(String conjuge) {
    this.conjuge = conjuge;
    return this;
  }

  /**
   * Get conjuge
   * @return conjuge
   **/
 
  
    public String getConjuge() {
    return conjuge;
  }

  public void setConjuge(String conjuge) {
    this.conjuge = conjuge;
  }

  public ParticipanteDTO documentoIdentificacao(String documentoIdentificacao) {
    this.documentoIdentificacao = documentoIdentificacao;
    return this;
  }

  /**
   * Get documentoIdentificacao
   * @return documentoIdentificacao
   **/
 
  
    public String getDocumentoIdentificacao() {
    return documentoIdentificacao;
  }

  public void setDocumentoIdentificacao(String documentoIdentificacao) {
    this.documentoIdentificacao = documentoIdentificacao;
  }

  public ParticipanteDTO obsSemImpact(String obsSemImpact) {
    this.obsSemImpact = obsSemImpact;
    return this;
  }

  /**
   * Get obsSemImpact
   * @return obsSemImpact
   **/
 
  
    public String getObsSemImpact() {
    return obsSemImpact;
  }

  public void setObsSemImpact(String obsSemImpact) {
    this.obsSemImpact = obsSemImpact;
  }

  public ParticipanteDTO condicaoPessoal(String condicaoPessoal) {
    this.condicaoPessoal = condicaoPessoal;
    return this;
  }

  /**
   * Get condicaoPessoal
   * @return condicaoPessoal
   **/
 
  
    public String getCondicaoPessoal() {
    return condicaoPessoal;
  }

  public void setCondicaoPessoal(String condicaoPessoal) {
    this.condicaoPessoal = condicaoPessoal;
  }

  public ParticipanteDTO telefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  /**
   * Get telefone
   * @return telefone
   **/
 
  
    public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public ParticipanteDTO celular(String celular) {
    this.celular = celular;
    return this;
  }

  /**
   * Get celular
   * @return celular
   **/
 
  
    public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public ParticipanteDTO validateFichaCadastral(String validateFichaCadastral) {
    this.validateFichaCadastral = validateFichaCadastral;
    return this;
  }

  /**
   * Get validateFichaCadastral
   * @return validateFichaCadastral
   **/
 
  
    public String getValidateFichaCadastral() {
    return validateFichaCadastral;
  }

  public void setValidateFichaCadastral(String validateFichaCadastral) {
    this.validateFichaCadastral = validateFichaCadastral;
  }

  public ParticipanteDTO dataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Get dataNascimento
   * @return dataNascimento
   **/
 
  
    public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public ParticipanteDTO habilitaEnvioToken(Boolean habilitaEnvioToken) {
    this.habilitaEnvioToken = habilitaEnvioToken;
    return this;
  }

  /**
   * Get habilitaEnvioToken
   * @return habilitaEnvioToken
   **/
 
  
    public Boolean isHabilitaEnvioToken() {
    return habilitaEnvioToken;
  }

  public void setHabilitaEnvioToken(Boolean habilitaEnvioToken) {
    this.habilitaEnvioToken = habilitaEnvioToken;
  }

  public ParticipanteDTO status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
 
  
    public Boolean isStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public ParticipanteDTO ppe(Boolean ppe) {
    this.ppe = ppe;
    return this;
  }

  /**
   * Get ppe
   * @return ppe
   **/
 
  
    public Boolean isPpe() {
    return ppe;
  }

  public void setPpe(Boolean ppe) {
    this.ppe = ppe;
  }

  public ParticipanteDTO assinaDigital(Boolean assinaDigital) {
    this.assinaDigital = assinaDigital;
    return this;
  }

  /**
   * Get assinaDigital
   * @return assinaDigital
   **/
 
  
    public Boolean isAssinaDigital() {
    return assinaDigital;
  }

  public void setAssinaDigital(Boolean assinaDigital) {
    this.assinaDigital = assinaDigital;
  }

  public ParticipanteDTO enderecoList(List<EnderecoDTO> enderecoList) {
    this.enderecoList = enderecoList;
    return this;
  }

  public ParticipanteDTO addEnderecoListItem(EnderecoDTO enderecoListItem) {
    if (this.enderecoList == null) {
      this.enderecoList = new ArrayList<>();
    }
    this.enderecoList.add(enderecoListItem);
    return this;
  }

  /**
   * Get enderecoList
   * @return enderecoList
   **/
 
      @Valid
    public List<EnderecoDTO> getEnderecoList() {
    return enderecoList;
  }

  public void setEnderecoList(List<EnderecoDTO> enderecoList) {
    this.enderecoList = enderecoList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParticipanteDTO participante = (ParticipanteDTO) o;
    return Objects.equals(this.codigo, participante.codigo) &&
        Objects.equals(this.codigoExterno, participante.codigoExterno) &&
        Objects.equals(this.nome, participante.nome) &&
        Objects.equals(this.email, participante.email) &&
        Objects.equals(this.cpf, participante.cpf) &&
        Objects.equals(this.cpfAplicavel, participante.cpfAplicavel) &&
        Objects.equals(this.sexo, participante.sexo) &&
        Objects.equals(this.estadoCivil, participante.estadoCivil) &&
        Objects.equals(this.conjuge, participante.conjuge) &&
        Objects.equals(this.documentoIdentificacao, participante.documentoIdentificacao) &&
        Objects.equals(this.obsSemImpact, participante.obsSemImpact) &&
        Objects.equals(this.condicaoPessoal, participante.condicaoPessoal) &&
        Objects.equals(this.telefone, participante.telefone) &&
        Objects.equals(this.celular, participante.celular) &&
        Objects.equals(this.validateFichaCadastral, participante.validateFichaCadastral) &&
        Objects.equals(this.dataNascimento, participante.dataNascimento) &&
        Objects.equals(this.habilitaEnvioToken, participante.habilitaEnvioToken) &&
        Objects.equals(this.status, participante.status) &&
        Objects.equals(this.ppe, participante.ppe) &&
        Objects.equals(this.assinaDigital, participante.assinaDigital) &&
        Objects.equals(this.enderecoList, participante.enderecoList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, codigoExterno, nome, email, cpf, cpfAplicavel, sexo, estadoCivil, conjuge, documentoIdentificacao, obsSemImpact, condicaoPessoal, telefone, celular, validateFichaCadastral, dataNascimento, habilitaEnvioToken, status, ppe, assinaDigital, enderecoList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParticipanteDTO {\n");
    
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    codigoExterno: ").append(toIndentedString(codigoExterno)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    cpfAplicavel: ").append(toIndentedString(cpfAplicavel)).append("\n");
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    estadoCivil: ").append(toIndentedString(estadoCivil)).append("\n");
    sb.append("    conjuge: ").append(toIndentedString(conjuge)).append("\n");
    sb.append("    documentoIdentificacao: ").append(toIndentedString(documentoIdentificacao)).append("\n");
    sb.append("    obsSemImpact: ").append(toIndentedString(obsSemImpact)).append("\n");
    sb.append("    condicaoPessoal: ").append(toIndentedString(condicaoPessoal)).append("\n");
    sb.append("    telefone: ").append(toIndentedString(telefone)).append("\n");
    sb.append("    celular: ").append(toIndentedString(celular)).append("\n");
    sb.append("    validateFichaCadastral: ").append(toIndentedString(validateFichaCadastral)).append("\n");
    sb.append("    dataNascimento: ").append(toIndentedString(dataNascimento)).append("\n");
    sb.append("    habilitaEnvioToken: ").append(toIndentedString(habilitaEnvioToken)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    ppe: ").append(toIndentedString(ppe)).append("\n");
    sb.append("    assinaDigital: ").append(toIndentedString(assinaDigital)).append("\n");
    sb.append("    enderecoList: ").append(toIndentedString(enderecoList)).append("\n");
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
