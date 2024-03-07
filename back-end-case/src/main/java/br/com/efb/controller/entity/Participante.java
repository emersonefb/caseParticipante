package br.com.efb.controller.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Participante"
//        ,
//        uniqueConstraints = {
//                @UniqueConstraint(
//                        columnNames = {"ccNomUsuario"},
//                        name="uk_ccNomUsuario"
//                )}
)
@SequenceGenerator(name="generator", sequenceName="participante_seq", allocationSize=1)

public class Participante {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "Codigo")
    private Long codigo;

    @Column(name = "Codigo_Externo")
    private String codigoExterno;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cpf_aplicavel")
    private Boolean cpfAplicavel;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "conjuge")
    private String conjuge;

    @Column(name = "documento_identificacao")
    private String documentoIdentificacao;

    @Column(name = "obs_sem_impact")
    private String obsSemImpact;

    @Column(name = "condicao_pessoal")
    private String condicaoPessoal;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "celular")
    private String celular;

    @Column(name = "validate_ficha_cadastral")
    private LocalDate validateFichaCadastral;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "habilita_envioToken")
    private Boolean habilitaEnvioToken;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "PPE")
    private Boolean ppe;

    @Column(name = "assina_digital")
    private Boolean assinaDigital;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "participante",fetch = FetchType.EAGER)
    private List<Endereco> enderecoList;

    public Participante() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoExterno() {
        return codigoExterno;
    }

    public void setCodigoExterno(String codigoExterno) {
        this.codigoExterno = codigoExterno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getCpfAplicavel() {
        return cpfAplicavel;
    }

    public void setCpfAplicavel(Boolean cpfAplicavel) {
        this.cpfAplicavel = cpfAplicavel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public String getObsSemImpact() {
        return obsSemImpact;
    }

    public void setObsSemImpact(String obsSemImpact) {
        this.obsSemImpact = obsSemImpact;
    }

    public String getCondicaoPessoal() {
        return condicaoPessoal;
    }

    public void setCondicaoPessoal(String condicaoPessoal) {
        this.condicaoPessoal = condicaoPessoal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getValidateFichaCadastral() {
        return validateFichaCadastral;
    }

    public void setValidateFichaCadastral(LocalDate validateFichaCadastral) {
        this.validateFichaCadastral = validateFichaCadastral;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getHabilitaEnvioToken() {
        return habilitaEnvioToken;
    }

    public void setHabilitaEnvioToken(Boolean habilitaEnvioToken) {
        this.habilitaEnvioToken = habilitaEnvioToken;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getPpe() {
        return ppe;
    }

    public void setPpe(Boolean ppe) {
        this.ppe = ppe;
    }

    public Boolean getAssinaDigital() {
        return assinaDigital;
    }

    public void setAssinaDigital(Boolean assinaDigital) {
        this.assinaDigital = assinaDigital;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }
}
