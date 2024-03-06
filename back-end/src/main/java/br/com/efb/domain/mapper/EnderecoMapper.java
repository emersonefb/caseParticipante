package br.com.efb.domain.mapper;

import br.com.efb.domain.entity.EnderecoEntity;
import com.efb.api.model.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper( EnderecoMapper.class );

    EnderecoEntity dtoToEntity(EnderecoDTO enderecoDTO);

    EnderecoDTO entityToDTO (EnderecoEntity enderecoEntity);

    List<EnderecoEntity> dtoListToEntityList(List<EnderecoDTO> enderecoDTOS);

    List<EnderecoDTO> entityListToDTOList(List<EnderecoEntity> enderecoEntities);

}
