package br.com.efb.domain.api.impl;

import br.com.efb.domain.entity.ParticipanteEntity;
import br.com.efb.domain.mapper.ParticipanteMapper;
import br.com.efb.domain.service.ParticipanteService;
import com.efb.api.ParticipanteApi;
import com.efb.api.model.ParticipanteDTO;
import com.efb.api.model.ParticipantePageDTO;
import com.efb.api.model.ParticipanteSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class ParticipanteController implements ParticipanteApi {

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    ParticipanteMapper participanteMapper;

    @Override
    public ResponseEntity<ParticipanteDTO> cadastrar(ParticipanteDTO body) {
        ParticipanteEntity participanteEntity = participanteMapper.dtoToEntity(body);
        return ResponseEntity.ok(participanteService.save(participanteEntity));
    }

    @Override
    public ResponseEntity<ParticipantePageDTO> listar(ParticipanteSearchDTO body) {
        ParticipantePageDTO participantePageDTO = new ParticipantePageDTO();

        int page = 0;
        if (body.getPage() != 0) {
            page = body.getPage();
        }

        int size = body.getSize();
        if (body.getSize() != 0) {
            size = body.getSize();
        }
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "codigo", "nome");

        Page<ParticipanteDTO> search;
        if (body.getCodigoExterno() != null) {
            search = participanteService.search(
                    body.getCodigoExterno().toLowerCase(),
                    pageRequest);
        } else if (body.getNome() != null) {
            search = participanteService.search(
                    body.getNome().toLowerCase(),
                    pageRequest);
        } else {
            search = participanteService.searchAll(
                    pageRequest);
        }
        participantePageDTO.setContent(search.getContent());
        participantePageDTO.setHasNext(search.hasNext());
        participantePageDTO.setHasPrev(search.hasPrevious());
        participantePageDTO.setPage(search.getPageable().getPageNumber());
        participantePageDTO.setPerPage(search.getPageable().getPageSize());
        participantePageDTO.setTotalElements(Math.toIntExact(search.getTotalElements()));
        participantePageDTO.setTotalPages(search.getTotalPages());
        return ResponseEntity.ok(participantePageDTO);
    }

    @Override
    public ResponseEntity<ParticipanteDTO> buscar(Long codigo) {
        ParticipanteDTO participante = participanteService.getParticipante(codigo);
        return ResponseEntity.ok(participante);
    }

    @Override
    public ResponseEntity<Void> deletar(Long codigo) {
        participanteService.deleteById(codigo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ParticipanteDTO> update (ParticipanteDTO body){
        ParticipanteEntity participanteEntity = participanteMapper.dtoToEntity(body);
        return ResponseEntity.ok(participanteService.update(participanteEntity));
    }

    @Override
    public ResponseEntity<Void> deletarLista(List<Long> body) {

        if (Objects.nonNull(body) && !body.isEmpty()){
            body.stream().forEach( id -> {
                participanteService.deleteById(id);
            });
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<String>> listarNomes(String nome) {
        List<String> list = participanteService.findNomeLike(nome);
        return ResponseEntity.ok(list);
    }
}
