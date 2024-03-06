package br.com.efb.domain.service;

import br.com.efb.domain.entity.ParticipanteEntity;
import com.efb.api.model.ParticipanteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ParticipanteService {

    ParticipanteDTO getParticipante(Long codigo);

    List<ParticipanteDTO> findAll();

    ParticipanteDTO save(ParticipanteEntity participanteEntity);

    ParticipanteDTO update(ParticipanteEntity participanteEntity);

    void deleteById(Long codigo);

    public Page<ParticipanteDTO> search(String nome, PageRequest pageRequest);
    public Page<ParticipanteDTO> searchAll(PageRequest pageRequest);

    List<String> findNomeLike(String nome);
}
