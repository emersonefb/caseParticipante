package br.com.efb.controller.mapper;

import br.com.efb.controller.dto.EnderecoDTO;
import br.com.efb.controller.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper( EnderecoMapper.class );

    Endereco dtoToEntity(EnderecoDTO enderecoDTO);

    EnderecoDTO entityToDTO(Endereco enderecoEntity);

    List<Endereco> dtoListToEntityList(List<EnderecoDTO> enderecoDTOS);

    List<EnderecoDTO> entityListToDTOList(List<Endereco> enderecoEntities);

}
