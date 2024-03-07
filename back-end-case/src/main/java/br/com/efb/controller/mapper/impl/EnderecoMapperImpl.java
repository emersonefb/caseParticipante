package br.com.efb.controller.mapper.impl;


import br.com.efb.controller.dto.EnderecoDTO;
import br.com.efb.controller.entity.Endereco;
import br.com.efb.controller.mapper.EnderecoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public Endereco dtoToEntity(EnderecoDTO enderecoDTO) {
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

    @Override
    public EnderecoDTO entityToDTO(Endereco endereco) {
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

    @Override
    public List<Endereco> dtoListToEntityList(List<EnderecoDTO> enderecoDTOS) {
        if ( enderecoDTOS == null ) {
            return null;
        }

        List<Endereco> list = new ArrayList<Endereco>( enderecoDTOS.size() );
        for ( EnderecoDTO enderecoDTO : enderecoDTOS ) {
            list.add( dtoToEntity( enderecoDTO ) );
        }

        return list;
    }

    @Override
    public List<EnderecoDTO> entityListToDTOList(List<Endereco> enderecoEntities) {
        if ( enderecoEntities == null ) {
            return null;
        }

        List<EnderecoDTO> list = new ArrayList<EnderecoDTO>( enderecoEntities.size() );
        for ( Endereco endereco : enderecoEntities ) {
            list.add( entityToDTO( endereco ) );
        }

        return list;
    }
}
