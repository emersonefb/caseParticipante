package br.com.efb.domain.repository;

import br.com.efb.domain.entity.ParticipanteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<ParticipanteEntity,Long> {

    @Query("FROM ParticipanteEntity c " +
            "WHERE c.nome like %:nome% ")
    Page<ParticipanteEntity> search(
            @Param("nome") String nome,
            Pageable pageable);

    @Query("FROM ParticipanteEntity c " +
            "WHERE c.nome like %:nome% ")
    List<ParticipanteEntity> findNomeLike(
            @Param("nome") String nome);

    @Query("FROM ParticipanteEntity c ")
    Page<ParticipanteEntity> searchAll(
            Pageable pageable);


}
