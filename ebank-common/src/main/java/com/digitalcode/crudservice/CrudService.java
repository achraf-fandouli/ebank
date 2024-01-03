package com.digitalcode.crudservice;

import java.util.List;

public interface CrudService<T,ID> {
	T getById(ID id);
	List<T> getAll();
	T save(T entity);
	T update(ID id,T entity);
	void delete(ID id);
}
