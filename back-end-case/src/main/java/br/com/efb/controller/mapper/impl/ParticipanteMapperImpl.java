package br.com.efb.controller.mapper.impl;


import br.com.efb.controller.dto.EnderecoDTO;
import br.com.efb.controller.dto.ParticipanteDTO;
import br.com.efb.controller.entity.Endereco;
import br.com.efb.controller.entity.Participante;
import br.com.efb.controller.mapper.ParticipanteMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParticipanteMapperImpl implements ParticipanteMapper {

    @Override
    public Participante dtoToEntity(ParticipanteDTO participanteDTO) {
        if ( participanteDTO == null ) {
            return null;
        }

        Participante participante = new Participante();

        participante.setCodigo( participanteDTO.getCodigo() );
        participante.setCodigoExterno( participanteDTO.getCodigoExterno() );
        participante.setNome( participanteDTO.getNome() );
        participante.setEmail( participanteDTO.getEmail() );
        participante.setCpf( participanteDTO.getCpf() );
        participante.setCpfAplicavel( participanteDTO.isCpfAplicavel() );
        participante.setSexo( participanteDTO.getSexo() );
        participante.setEstadoCivil( participanteDTO.getEstadoCivil() );
        participante.setConjuge( participanteDTO.getConjuge() );
        participante.setDocumentoIdentificacao( participanteDTO.getDocumentoIdentificacao() );
        participante.setObsSemImpact( participanteDTO.getObsSemImpact() );
        participante.setCondicaoPessoal( participanteDTO.getCondicaoPessoal() );
        participante.setTelefone( participanteDTO.getTelefone() );
        participante.setCelular( participanteDTO.getCelular() );
        if ( participanteDTO.getValidateFichaCadastral() != null ) {
            participante.setValidateFichaCadastral( LocalDate.parse( participanteDTO.getValidateFichaCadastral() ) );
        }
        if ( participanteDTO.getDataNascimento() != null ) {
            participante.setDataNascimento( LocalDate.parse( participanteDTO.getDataNascimento() ) );
        }
        participante.setHabilitaEnvioToken( participanteDTO.isHabilitaEnvioToken() );
        participante.setStatus( participanteDTO.isStatus() );
        participante.setPpe( participanteDTO.isPpe() );
        participante.setAssinaDigital( participanteDTO.isAssinaDigital() );
        participante.setEnderecoList( enderecoDTOListToEnderecoList( participanteDTO.getEnderecoList() ) );

        return participante;
    }

    @Override
    public ParticipanteDTO entityToDTO(Participante participante) {
        if ( participante == null ) {
            return null;
        }

        ParticipanteDTO participanteDTO = new ParticipanteDTO();

        participanteDTO.setCodigo( participante.getCodigo() );
        participanteDTO.setCodigoExterno( participante.getCodigoExterno() );
        participanteDTO.setNome( participante.getNome() );
        participanteDTO.setEmail( participante.getEmail() );
        participanteDTO.setCpf( participante.getCpf() );
        participanteDTO.setCpfAplicavel( participante.getCpfAplicavel() );
        participanteDTO.setSexo( participante.getSexo() );
        participanteDTO.setEstadoCivil( participante.getEstadoCivil() );
        participanteDTO.setConjuge( participante.getConjuge() );
        participanteDTO.setDocumentoIdentificacao( participante.getDocumentoIdentificacao() );
        participanteDTO.setObsSemImpact( participante.getObsSemImpact() );
        participanteDTO.setCondicaoPessoal( participante.getCondicaoPessoal() );
        participanteDTO.setTelefone( participante.getTelefone() );
        participanteDTO.setCelular( participante.getCelular() );
        if ( participante.getValidateFichaCadastral() != null ) {
            participanteDTO.setValidateFichaCadastral( DateTimeFormatter.ISO_LOCAL_DATE.format( participante.getValidateFichaCadastral() ) );
        }
        if ( participante.getDataNascimento() != null ) {
            participanteDTO.setDataNascimento( DateTimeFormatter.ISO_LOCAL_DATE.format( participante.getDataNascimento() ) );
        }
        participanteDTO.setHabilitaEnvioToken( participante.getHabilitaEnvioToken() );
        participanteDTO.setStatus( participante.getStatus() );
        participanteDTO.setPpe( participante.getPpe() );
        participanteDTO.setAssinaDigital( participante.getAssinaDigital() );
        participanteDTO.setEnderecoList( enderecoListToEnderecoDTOList( participante.getEnderecoList() ) );

        return participanteDTO;
    }

    @Override
    public List<Participante> dtoListToEntityList(List<ParticipanteDTO> participanteDTOS) {
        if ( participanteDTOS == null ) {
            return null;
        }

        List<Participante> list = new ArrayList<Participante>( participanteDTOS.size() );
        for ( ParticipanteDTO participanteDTO : participanteDTOS ) {
            list.add( dtoToEntity( participanteDTO ) );
        }

        return list;
    }

    @Override
    public List<ParticipanteDTO> entityListToDTOList(List<Participante> participanteEntities) {
        if ( participanteEntities == null ) {
            return null;
        }

        List<ParticipanteDTO> list = new ArrayList<ParticipanteDTO>( participanteEntities.size() );
        for ( Participante participante : participanteEntities ) {
            list.add( entityToDTO( participante ) );
        }

        return list;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setIdEndereco( enderecoDTO.getIdEndereco() );
        endereco.setCep( enderecoDTO.getCep() );
        endereco.setLogradouro( enderecoDTO.getLogradouro() );
        endereco.setNumero( enderecoDTO.getNumero() );
        endereco.setComplemento( enderecoDTO.getComplemento() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setEstado( enderecoDTO.getEstado() );
        endereco.setPais( enderecoDTO.getPais() );

        return endereco;
    }

    protected List<Endereco> enderecoDTOListToEnderecoList(List<EnderecoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Endereco> list1 = new ArrayList<Endereco>( list.size() );
        for ( EnderecoDTO enderecoDTO : list ) {
            list1.add( enderecoDTOToEndereco( enderecoDTO ) );
        }

        return list1;
    }

    protected EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setIdEndereco( endereco.getIdEndereco() );
        enderecoDTO.setCep( endereco.getCep() );
        enderecoDTO.setLogradouro( endereco.getLogradouro() );
        enderecoDTO.setNumero( endereco.getNumero() );
        enderecoDTO.setComplemento( endereco.getComplemento() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setEstado( endereco.getEstado() );
        enderecoDTO.setPais( endereco.getPais() );

        return enderecoDTO;
    }

    protected List<EnderecoDTO> enderecoListToEnderecoDTOList(List<Endereco> list) {
        if ( list == null ) {
            return null;
        }

        List<EnderecoDTO> list1 = new ArrayList<EnderecoDTO>( list.size() );
        for ( Endereco endereco : list ) {
            list1.add( enderecoToEnderecoDTO( endereco ) );
        }

        return list1;
    }
}
