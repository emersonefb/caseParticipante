package br.com.efb.domain.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Participante")
@SequenceGenerator(name="generator", sequenceName="participante_seq", allocationSize=1)
@Audited
@Data
public class ParticipanteEntity {

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

    @Column(name = "cpfAplicavel")
    private Boolean cpfAplicavel;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @Column(name = "conjuge")
    private String conjuge;

    @Column(name = "documentoIdentificacao")
    private String documentoIdentificacao;

    @Column(name = "obsSemImpact")
    private String obsSemImpact;

    @Column(name = "condicaoPessoal")
    private String condicaoPessoal;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "celular")
    private String celular;

    @Column(name = "validateFichaCadastral")
    private LocalDate validateFichaCadastral;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "habilitaEnvioToken")
    private Boolean habilitaEnvioToken;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "PPE")
    private Boolean ppe;

    @Column(name = "assinaDigital")
    private Boolean assinaDigital;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "participante",fetch = FetchType.EAGER)
    private List<EnderecoEntity> enderecoList;

}
