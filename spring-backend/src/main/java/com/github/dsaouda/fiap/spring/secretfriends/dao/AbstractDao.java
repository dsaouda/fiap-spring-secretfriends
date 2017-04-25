package com.github.dsaouda.fiap.spring.secretfriends.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class AbstractDao<T, ID> {

	protected EntityManager em;
	private Class<T> persistedClass;

	protected AbstractDao(EntityManager em, Class<T> persistedClass) {
		this.em = em;
		this.persistedClass = persistedClass;
	}

	public T salvar(T entity) {
		em.persist(entity);
		em.flush();

		return entity;
	}
	
	public T merge(T entity) {
		em.merge(entity);
		em.flush();

		return entity;
	}

	public void delete(T entity) {
		em.remove(entity);
		em.flush();
	}

	public List<T> getList() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return em.createQuery(query).getResultList();
	}

	public T buscar(ID id) {
		return em.find(persistedClass, id);
	}

	public T buscarPorUUID(String uuid) {
		TypedQuery<T> query = em.createQuery("from " + persistedClass.getName() + " where uuid = :uuid", persistedClass);
		query.setParameter("uuid", uuid);
		return query.getSingleResult();
	}
}