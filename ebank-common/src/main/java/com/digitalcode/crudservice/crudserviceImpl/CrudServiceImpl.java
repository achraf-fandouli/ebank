package com.digitalcode.crudservice.crudserviceImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalcode.crudservice.CrudService;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

	protected final JpaRepository<T, ID> repository;

	public CrudServiceImpl(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}

	@Override
	public T getById(ID id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public T update(ID id, T entity) {
		if (entity != null) {
			if (repository.existsById(id)) {
				entity = repository.save(entity);
				return entity;
			}
		}
		return null;
	}

	@Override
	public void delete(ID id) {
		repository.deleteById(id);
	}

}
