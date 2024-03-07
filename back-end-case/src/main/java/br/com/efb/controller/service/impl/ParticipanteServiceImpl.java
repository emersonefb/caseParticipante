package br.com.efb.controller.service.impl;

import br.com.efb.controller.DAO.ParticipanteDAO;
import br.com.efb.controller.dto.ParticipanteDTO;
import br.com.efb.controller.dto.ParticipantePageDTO;
import br.com.efb.controller.dto.ParticipanteSearchDTO;
import br.com.efb.controller.entity.Participante;
import br.com.efb.controller.mapper.impl.ParticipanteMapperImpl;
import br.com.efb.controller.service.IParticipanteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipanteServiceImpl implements IParticipanteService {

	private static final Logger logger =
			Logger.getLogger(ParticipanteServiceImpl.class);


	@Autowired
	ParticipanteDAO participanteDao;

	@Autowired
	ParticipanteMapperImpl participanteMapper;

	@Override
	public Participante salvar(Participante participante) {

		logger.info(" Salvando Participante ");
		return participanteDao.salvar(participante);
	}

	@Override
	public void update(Participante participante) {

		logger.info(" update Participante ");
		 participanteDao.update(participante);
	}

	@Override
	public Participante delete(Participante participante) {

		try{
			participante = participanteDao.find(participante.getCodigo());
			participanteDao.delete(participante);

		}catch (Exception e){
			e.printStackTrace();
			logger.info(" Error ");
		}
		return participanteDao.find(participante.getCodigo());
	}

	@Override
	public List<Participante> listarParticipantes() {
		return participanteDao.list();
	}

	@Override
	public Participante FindParticipantes(Participante participante) {
		Participante ret = new Participante();
		try{
			ret = participanteDao.find(participante.getCodigo());
		}catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Participante FindParticipantesById(Participante participante) {
		Participante ret = new Participante();
		try{
			ret = participanteDao.find(participante.getCodigo());
		}catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Participante FindParticipantesById(Long codigo) {
		Participante ret = new Participante();
		try{
			ret = participanteDao.find(codigo);
		}catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Participante> FindParticipantesFilter(Participante... participantes) {
		List<Participante> result = new ArrayList<Participante>();
		List<Object[]> where = new ArrayList<Object[]>();
		if (participantes != null && participantes.length > 0){

			for (Participante participante:participantes) {
				if (participante.getNome() != null){

					String[] cods = new String[participantes.length];
					for(int i = 0; i < participantes.length; i++){
						cods[i] = participantes[i].getNome();
					}
					where.add(new Object[]{"inS;nome", cods});
				}
				if (participante.getEmail() != null) {
					where.add(new Object[]{"equal;email", participante.getEmail()});
				}

				List<String> order = new ArrayList<String>();
				order.add("nome;asc");

				 result.addAll(this.participanteDao.list(where, order));
			}
		}
		return result;
	}

	@Override
	public ParticipantePageDTO FindParticipantesFiltersearch(ParticipanteSearchDTO searchDTO) {
		List<Participante> result = new ArrayList<Participante>();
		ParticipantePageDTO pageDTO = new ParticipantePageDTO();
		List<Object[]> where = new ArrayList<Object[]>();
		if (searchDTO != null){

			if (searchDTO.getCodigoExterno() != null) {
				where.add(new Object[]{"equal;codigoExterno", searchDTO.getCodigoExterno()});
			}
			if (searchDTO.getNome() != null) {
				where.add(new Object[]{"equal;nome", searchDTO.getNome()});
			}
			List<String> order = new ArrayList<String>();
			order.add("nome;asc");
			result.addAll(this.participanteDao.list(where, order));

			int primerioItemPagina = 0;
			if (searchDTO.getPage()>0){
				primerioItemPagina = searchDTO.getSize()* searchDTO.getPage();
			}
			int ultimoItemPagina = primerioItemPagina + searchDTO.getSize();

			List<ParticipanteDTO> list = new ArrayList<>();
			for (int i = 0; i < result.size(); i++) {

				if (i>primerioItemPagina && i< ultimoItemPagina){
					ParticipanteDTO pat = new ParticipanteDTO();
					Participante participante = result.get(i);
					pat = participanteMapper.entityToDTO(participante);
					list.add(pat);
				}
			}
			pageDTO.content(list);
			Integer totalPage = result.size()/searchDTO.getSize();
			pageDTO.setTotalPages(totalPage);
			pageDTO.setTotalElements(result.size());
			pageDTO.setPage(searchDTO.getPage());
			pageDTO.setPerPage(searchDTO.getSize());
			pageDTO.hasNext(totalPage.equals(searchDTO.getPage()));
			pageDTO.hasNext(0 == searchDTO.getPage());

		}
		return pageDTO;
	}

	@Override
	public List<Participante> FindParticipantesLikeNome(String nome) {
		List<Participante> result = new ArrayList<Participante>();
		List<Object[]> where = new ArrayList<Object[]>();
			if (nome != null) {
				where.add(new Object[]{"equal;nome", nome});
			}
			List<String> order = new ArrayList<String>();
			order.add("nome;asc");
			result.addAll(this.participanteDao.list(where, order));
		return result;
	}

}
