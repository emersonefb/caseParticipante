package br.com.efb.controller.DAO;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class DAO<T> implements IDAO<T>,Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

//	@Inject
//	protected EntityManager em;
	
	@PersistenceContext
	EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insert(T t) {
		em.persist(t);		
	}

	public void delete(T t) {
		em.remove(em.merge(t));
	}

	public void update(T t) {
		em.merge(t);		
	}

	public T find(Long id) {
		if (id==null)
			return null;
		T t = em.find(classe, id);
		return t;
	}

	public T find(int id) {
		if (id==0)
			return null;
		T t = em.find(classe, id);
		return t;
	}

	public T find(String id) {
		T t = em.find(classe, id);
		return t;
	}
	
	public List<T> list () {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listQuery(String strSql, List<Object[]> param){
		Query query = em.createQuery(strSql);

		for (Object[] where : param) {
			query.setParameter((String)where[0], where[1]);
		}
		
		List<T> lista = query.getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listTopQuery(String strSql, List<Object[]> param, Integer top){
		Query query = em.createQuery(strSql); 

		for (Object[] where : param) {
			query.setParameter((String)where[0], where[1]);
		}
		
		query.setMaxResults(top);
		List<T> lista = query.getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listNamedQuery(String namedQuery, List<Object[]> param){
		Query query = em.createNamedQuery(namedQuery);
		for (Object[] where : param) {
			query.setParameter((String)where[0], where[1]);
		}
		
		List<T> lista = query.getResultList();
		return lista;
	}
	
	public T merge(Object obj){
		@SuppressWarnings("unchecked")
		T t = (T) em.merge(obj);
		return t;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> list(List<Object[]> where, List<String> orderBy) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		Root<T> t = query.from(classe);
		
		List<Order> listOrd = new ArrayList<Order>();
		List<Predicate> listPred = new ArrayList<Predicate>();
		List<Predicate> listPredOr = new ArrayList<Predicate>();
		Predicate predicate=null;
		
		Integer first = null;
		Integer top = null;
		
		for (Object[] obj : where) {
			predicate=null;
			String[] param = ((String)obj[0]).split(";");
			Boolean or = false;
			Boolean campo = false;
			
			if("first".equals(param[0])){
				first = (Integer) obj[1];
			}
			if("top".equals(param[0])){
				top = (Integer) obj[1];
			}
			
			if(new String(param[param.length-1]).equals("or")){
				or = true;
				String strAux = (String) obj[0];
				strAux = strAux.replace(";or", "");
				param = strAux.split(";");
			}
			
			if(new String(param[param.length-1]).equals("campo")){
				campo = true;
				String strAux = (String) obj[0];
				strAux = strAux.replace(";campo", "");
				param = strAux.split(";");
			}
			
			if("equal".equals(param[0])){
				if(param.length>2){
					predicate = em.getCriteriaBuilder().equal(t.get(param[1]).get(param[2]), obj[1]);					
				}else{
					if(param[1].contains(".")){
						String[] subParam = ((String)param[1]).split("\\.");
						predicate = em.getCriteriaBuilder().equal(t.get(subParam[0]).get(subParam[1]), obj[1]);
					}else{
						predicate = em.getCriteriaBuilder().equal(t.get(param[1]), obj[1]);
					}

				}
			}
			
			if("notEqual".equals(param[0])){
				if(campo){
					predicate = em.getCriteriaBuilder().notEqual(t.get(param[1]), t.get(param[2]));
				}else{
					if(param.length>2){
						predicate = em.getCriteriaBuilder().notEqual(t.get(param[1]).get(param[2]), obj[1]);
					}else{
						predicate = em.getCriteriaBuilder().notEqual(t.get(param[1]), obj[1]);					
					}					
				}
			}
			
			if("like".equals(param[0])){
				if(param.length>2){
					predicate = em.getCriteriaBuilder().like(em.getCriteriaBuilder().upper((Expression) t.get(param[1]).get(param[2])), obj[1].toString().toUpperCase()+"%");
				}else{
					predicate = em.getCriteriaBuilder().like(em.getCriteriaBuilder().upper((Expression) t.get(param[1])), obj[1].toString().toUpperCase()+"%");
				}
        	}
        	
			if("in".equals(param[0])){
        		Long[] cod = (Long[]) obj[1];
        		if(cod.length==0){
        			cod = new Long[1];
        			cod[0]=new Long(-1);
        		}
        		predicate = em.getCriteriaBuilder().and(t.get(param[1]).in(cod));
        	}
			
			if("notIn".equals(param[0])){
        		Long[] cod = (Long[]) obj[1];
        		if(cod.length==0){
        			cod = new Long[1];
        			cod[0]=new Long(-1);
        		}
        		predicate = em.getCriteriaBuilder().not(t.get(param[1]).in(cod));
        	}
			
			if("inS".equals(param[0])){
        		String[] cod = (String[]) obj[1];
        		if(cod.length==0){
        			cod = new String[1];
        			cod[0]=new String("-1");
        		}
        		predicate = em.getCriteriaBuilder().and(t.get(param[1]).in(cod));
        	}
			
			if("notInS".equals(param[0])){
				String[] cod = (String[]) obj[1];
        		if(cod.length==0){
        			cod = new String[1];
        			cod[0]=new String("-1");
        		}
        		predicate = em.getCriteriaBuilder().not(t.get(param[1]).in(cod));
        	}
			
			if("isNull".equals(param[0])){
				if(param.length>2){
					predicate = em.getCriteriaBuilder().isNull(t.get(param[1]).get(param[2]));
				}else{
					predicate = em.getCriteriaBuilder().isNull(t.get(param[1]));
				}
			}
			
			if("isNotNull".equals(param[0])){
				if(param.length>2){
					predicate = em.getCriteriaBuilder().isNotNull(t.get(param[1]).get(param[2]));
				}else{
					predicate = em.getCriteriaBuilder().isNotNull(t.get(param[1]));
				}
			}
			
			if("gt".equals(param[0])){//maior que
				predicate = em.getCriteriaBuilder().gt((Expression) t.get(param[1]), (Long) obj[1]);
        	}
			
			if("gtDate".equals(param[0])){//maior que (Data)
				if(param.length>2){
					predicate = em.getCriteriaBuilder().greaterThan((Expression)t.get(param[1]).get(param[2]), (Date) obj[1]);
				}else{
					predicate = em.getCriteriaBuilder().greaterThan((Expression)t.get(param[1]), (Date) obj[1]);
				}
			}
			
			if("ge".equals(param[0])){//maior ou igual que
				predicate = em.getCriteriaBuilder().ge((Expression) t.get(param[1]), (Long) obj[1]);
        	}
			
			if("geDate".equals(param[0])){//maior igual que (Data)
				predicate = em.getCriteriaBuilder().greaterThanOrEqualTo((Expression)t.get(param[1]), (Date) obj[1]);
			}
        	
			if("lt".equals(param[0])){//menor que
				predicate = em.getCriteriaBuilder().lt((Expression) t.get(param[1]), (Long) obj[1]);
        	}
			
			if("ltDate".equals(param[0])){//menor que (Data)
				if(param.length>2){
					predicate = em.getCriteriaBuilder().lessThan((Expression)t.get(param[1]).get(param[2]), (Date) obj[1]);
				}else{
					predicate = em.getCriteriaBuilder().lessThan((Expression)t.get(param[1]), (Date) obj[1]);
				}
        	}
        	
			if("le".equals(param[0])){//menor ou igual que
				predicate = em.getCriteriaBuilder().le((Expression) t.get(param[1]), (Long) obj[1]);
        	}
			
			if("leDate".equals(param[0])){//menor igual que (Data)
				predicate = em.getCriteriaBuilder().lessThanOrEqualTo((Expression)t.get(param[1]), (Date) obj[1]);
        	}
			
			if("between".equals(param[0])){
				predicate = em.getCriteriaBuilder().between((Expression)t.get(param[1]), (Date) obj[1], (Date) obj[2]);
			}
			
			if("datePart".equals(param[0])){
				predicate = em.getCriteriaBuilder().equal(em.getCriteriaBuilder().function(param[1], Integer.class, t.get(param[2])), obj[1]);
			}
			
			if("len".equals(param[0])){
				predicate = em.getCriteriaBuilder().equal(em.getCriteriaBuilder().length(t.<String>get(param[1])), obj[1]);
			}
			
//			if("infCpl".equals(param[0])){
//				Subquery<ProcInfCpl> subquery = query.subquery(ProcInfCpl.class);
//				Root fromProject = subquery.from(ProcInfCpl.class);
//				subquery.select(fromProject.get("cnteInfCpl"));
//				subquery.where(em.getCriteriaBuilder().equal(fromProject.get("cod"),t.get("cvCodProc")), em.getCriteriaBuilder().equal(fromProject.get("infCpl"),270));
//
//				predicate = em.getCriteriaBuilder().equal(subquery, "1");
//			}
			
			if("predicate".equals(param[0])){
				listPred.add((Predicate)obj[1]);
			}
			
			if(predicate!=null){
				if(or){
					listPredOr.add(predicate);
				}else{
					listPred.add(predicate);				
				}				
			}
		}
		
		for (String order : orderBy) {
			String[] param = order.split(";");
			if(param.length==2){
				if("asc".equals(param[1])){
					listOrd.add(em.getCriteriaBuilder().asc(t.get(param[0])));
				}
				
				if("desc".equals(param[1])){
					listOrd.add(em.getCriteriaBuilder().desc(t.get(param[0])));
				}				
			}
			
			if(param.length==3){
				if("asc".equals(param[2])){
					listOrd.add(em.getCriteriaBuilder().asc(t.get(param[0]).get(param[1])));
				}
				
				if("desc".equals(param[2])){
					listOrd.add(em.getCriteriaBuilder().desc(t.get(param[0]).get(param[1])));
				}				
			}
		}
	
		if(listPredOr.size()>0){
			query.where(em.getCriteriaBuilder().and(listPred.toArray(new Predicate[]{})), em.getCriteriaBuilder().or(listPredOr.toArray(new Predicate[]{})));			
		}else{
			query.where(em.getCriteriaBuilder().and(listPred.toArray(new Predicate[]{})));
		}
		query.orderBy(listOrd);
		
		TypedQuery<T> typedQuery = em.createQuery(query.select(t));
		if(first!=null){
			typedQuery.setFirstResult(first);
		}
		if(top!=null){
			typedQuery.setMaxResults(top);
		}
		List<T> lista = typedQuery.getResultList();
		return lista;
	}
	
	public List<T> list(String[] ordem) {
		List<String> orderBy=new ArrayList<String>();
		
		for (int i = 0; i < ordem.length; i++) {
			orderBy.add(ordem[i]);
		}
		
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		Root<T> t = query.from(classe);

		List<Order> listOrd = new ArrayList<Order>();
		
		for (String order : orderBy) {
			listOrd.add(em.getCriteriaBuilder().asc(t.get(order)));
		}

		CriteriaQuery<T> select = query.select(t).orderBy(listOrd);
		TypedQuery<T> typedQuery = em.createQuery(select);
		List<T> lista = typedQuery.getResultList();
		return lista;
	}
	

}
