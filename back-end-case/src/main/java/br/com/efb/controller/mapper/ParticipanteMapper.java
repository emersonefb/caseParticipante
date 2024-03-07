package br.com.efb.controller.mapper;


import br.com.efb.controller.dto.ParticipanteDTO;
import br.com.efb.controller.entity.Participante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    ParticipanteMapper INSTANCE = Mappers.getMapper( ParticipanteMapper.class );

    Participante dtoToEntity(ParticipanteDTO participanteDTO);

    ParticipanteDTO entityToDTO(Participante participanteEntity);

    List<Participante> dtoListToEntityList(List<ParticipanteDTO> participanteDTOS);

    List<ParticipanteDTO> entityListToDTOList(List<Participante> participanteEntities);

}
