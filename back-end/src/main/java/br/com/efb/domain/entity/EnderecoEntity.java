package br.com.efb.domain.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="Endereco")
@SequenceGenerator(name="generator", sequenceName="idendereco_seq", allocationSize=1)
@Audited
@Data
public class EnderecoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id_endereco")
    private Long idEndereco;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private ParticipanteEntity participante;

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


}
