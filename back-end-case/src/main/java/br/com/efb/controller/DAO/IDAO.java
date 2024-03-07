package br.com.efb.controller.DAO;


public interface IDAO<T> {
	void insert(T t);
	void delete(T t);
	void update(T t);
	T find(Long id);
	T find(String id);
}
