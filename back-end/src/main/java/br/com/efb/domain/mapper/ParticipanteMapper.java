package br.com.efb.domain.mapper;

import br.com.efb.domain.entity.ParticipanteEntity;
import com.efb.api.model.ParticipanteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    ParticipanteMapper INSTANCE = Mappers.getMapper( ParticipanteMapper.class );

    ParticipanteEntity dtoToEntity(ParticipanteDTO participanteDTO);

    ParticipanteDTO entityToDTO (ParticipanteEntity participanteEntity);

    List<ParticipanteEntity> dtoListToEntityList(List<ParticipanteDTO> participanteDTOS);

    List<ParticipanteDTO> entityListToDTOList(List<ParticipanteEntity> participanteEntities);

}
