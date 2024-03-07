package br.com.efb.controller.service;

import br.com.efb.controller.dto.ParticipantePageDTO;
import br.com.efb.controller.dto.ParticipanteSearchDTO;
import br.com.efb.controller.entity.Participante;

import java.util.List;

public interface IParticipanteService {
    Participante salvar(Participante participante);

    void update(Participante participante);

    Participante delete(Participante participante);

    List<Participante> listarParticipantes();

    Participante FindParticipantes(Participante participante);

    Participante FindParticipantesById(Participante participante);
    Participante FindParticipantesById(Long codigo);

    List<Participante> FindParticipantesFilter(Participante... participantes);
    ParticipantePageDTO FindParticipantesFiltersearch(ParticipanteSearchDTO searchDTO);

    List<Participante> FindParticipantesLikeNome(String nome);
}
