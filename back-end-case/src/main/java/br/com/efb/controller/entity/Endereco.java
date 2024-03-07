package br.com.efb.controller.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="Endereco")
@SequenceGenerator(name="generator", sequenceName="idendereco_seq", allocationSize=1)

public class Endereco {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id_endereco")
    private Long idEndereco;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Participante participante;

    @Column (name = "cep")
    private String cep;
    @Column (name = "logradouro")
    private String logradouro;
    @Column (name = "numero")
    private Integer numero;
    @Column (name = "complemento")
    private String complemento;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;

    public Endereco() {
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
