package br.com.efb.domain.service;

import br.com.efb.domain.entity.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EnderecoService {

    List<EnderecoEntity> findAll();

    EnderecoEntity save(EnderecoEntity a);

    void delete(EnderecoEntity a);

    EnderecoEntity findByidGenericJson(Integer idGenericJson);

    public Page<EnderecoEntity> search(Long toLowerCase, PageRequest pageRequest);
    public Page<EnderecoEntity> searchAll(PageRequest pageRequest);

}
