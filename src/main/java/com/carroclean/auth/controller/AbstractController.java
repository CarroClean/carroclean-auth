package com.carroclean.auth.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carroclean.auth.model.AbstractModel;
import com.carroclean.auth.service.AbstractService;

public abstract class AbstractController<T extends AbstractModel> {

	protected abstract AbstractService<T> getService();

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list() {
		return getService().list();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public T get(@PathVariable String id) {
		return getService().get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public T post(@RequestBody T entity) {
		return getService().save(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public HttpStatus put(@RequestBody T entity) {
		try {
			getService().save(entity);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable String id) {
		try {
			getService().delete(id);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

}
