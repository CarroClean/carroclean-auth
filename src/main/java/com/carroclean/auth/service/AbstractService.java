package com.carroclean.auth.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.carroclean.auth.model.AbstractModel;

public abstract class AbstractService<T extends AbstractModel> {

	protected abstract MongoRepository<T, String> getRepository();

	public List<T> list() {
		return getRepository().findAll();
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}

	public T save(T entity) {
		return getRepository().save(entity);
	}

	public T get(String id) {
		T entity = getRepository().findOne(id);
		return entity;
	}

	public void delete(String id) {
		try {
			getRepository().delete(id);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	public void put(T entity) {
		T getEntity = getRepository().findOne(entity.getId());
		getRepository().save(entity);
	}

}