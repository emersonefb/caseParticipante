package br.com.efb.domain.service.impl;

import br.com.efb.domain.entity.EnderecoEntity;
import br.com.efb.domain.entity.ParticipanteEntity;
import br.com.efb.domain.mapper.ParticipanteMapper;
import br.com.efb.domain.repository.EnderecoRepository;
import br.com.efb.domain.repository.ParticipanteRepository;
import br.com.efb.domain.service.ParticipanteService;
import com.efb.api.model.ParticipanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    ParticipanteMapper participanteMapper;

    @Override
    public ParticipanteDTO getParticipante(Long codigo) {

        ParticipanteDTO participanteDTO = new ParticipanteDTO();

        Optional<ParticipanteEntity> byId = participanteRepository.findById(codigo);
        if (byId.isPresent()){
            participanteDTO = participanteMapper.entityToDTO(byId.get());
        }

        return participanteDTO;
    }

    @Override
    public List<ParticipanteDTO> findAll() {
        return participanteMapper.entityListToDTOList(participanteRepository.findAll());
    }

    @Transactional
    @Override
    public ParticipanteDTO save(ParticipanteEntity participanteEntity) {
        ParticipanteEntity participante = participanteRepository.save(participanteEntity);
        if (Objects.nonNull(participante.getEnderecoList()) && !participante.getEnderecoList().isEmpty()){
            List<EnderecoEntity> enderecoList = participante.getEnderecoList().stream().map(dt -> {
                dt.setParticipante(participante);
                return dt;
            }).collect(Collectors.toList());
        }
        return participanteMapper.entityToDTO(participante);
    }

    @Transactional
    @Override
    public ParticipanteDTO update(ParticipanteEntity participanteEntity) {
        ParticipanteEntity participante = participanteRepository.save(participanteEntity);
        if (Objects.nonNull(participante.getEnderecoList())){
            List<EnderecoEntity> enderecoList = participante.getEnderecoList().stream().map(dt -> {
                dt.setParticipante(participante);
                return dt;
            }).collect(Collectors.toList());
        }
        return participanteMapper.entityToDTO(participante);
    }


    @Override
    public void deleteById(Long codigo) {
        try {
            participanteRepository.deleteById(codigo);
        } catch (EmptyResultDataAccessException e){
            return;
        }
    }

    @Override
    public Page<ParticipanteDTO> search(String nome, PageRequest pageRequest) {
        Page<ParticipanteEntity> search = participanteRepository.search(nome, pageRequest);
        Page<ParticipanteDTO> participanteDTOS = search.map(entity -> {
            ParticipanteDTO dto = participanteMapper.entityToDTO(entity);
            return dto;
        });
        return participanteDTOS;
    }

    @Override
    public Page<ParticipanteDTO> searchAll(PageRequest pageRequest) {
        Page<ParticipanteEntity> participanteEntities = participanteRepository.searchAll(pageRequest);

        Page<ParticipanteDTO> participanteDTOS = participanteEntities.map(entity -> {
            ParticipanteDTO dto = participanteMapper.entityToDTO(entity);
            return dto;
        });

        return participanteDTOS;
    }

    @Override
    public List<String> findNomeLike(String nome) {
        List<String> nomeLike = new ArrayList<>();
        List<ParticipanteEntity> list = participanteRepository.findNomeLike(nome);
        if (Objects.nonNull(list) && !list.isEmpty()){
            list.stream().forEach( participanteEntity -> {
                nomeLike.add(participanteEntity.getNome());
            });
        }
        return nomeLike;
    }
}
