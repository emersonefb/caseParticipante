package br.com.efb.controller.DAO;

import br.com.efb.controller.entity.Participante;
import br.com.efb.controller.entity.Participante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class ParticipanteDAO extends DAO<Participante> implements Serializable {

	public ParticipanteDAO() {
		super(Participante.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Participante salvar(Participante newParticipante) {

		Participante participante = super.merge(newParticipante);

		return participante;
	}

	@Override
	public void delete(Participante estabelecimento) {
		super.delete(estabelecimento);
	}

	@Override
	public Participante find(Long id) {
		return super.find(id);
	}


	public List<Participante> list () {
		CriteriaQuery<Participante> query = em.getCriteriaBuilder().createQuery(Participante.class);
		query.select(query.from(Participante.class));
		List<Participante> lista = em.createQuery(query).getResultList();
		return lista;
	}

}
