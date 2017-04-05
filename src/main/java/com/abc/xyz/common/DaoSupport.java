package com.abc.xyz.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author amrit
 * 
 */
public abstract class DaoSupport<E extends CoreEntity> implements CoreDao<E>
{
	@Autowired
	protected SessionFactory sessionFactory;

	public String getEntityName()
	{
		return getEntity().getCanonicalName();
	}
	
	public E findByID(long id)
	{
		return findByParam("Id", id);
	}	

	public List<E> getALLEntities()
	{
		List<E> entites = new ArrayList();
		entites = getSession()
					.createQuery("from "+ getEntityName())
					.list();
		return entites;
	}	
	
	public long save(E entity)
	{
		getSession().save(entity);		
		return entity.getId();
	}
	
	public void update(E entity)
	{
		getSession().saveOrUpdate(entity);	
	}
	
	protected Query getNamedQuery(String namedQuery)
	{
		Query query = getSession().getNamedQuery(namedQuery);
		return query;
	}	
	
	protected E findByParam(String column, Object param)
	{
		List<E> entites = new ArrayList();
		entites = getSession()
				.createQuery("from "+ getEntityName() + " where "+column+"=:"+column)
				.setParameter(column, param)
				.list();
		return entites.isEmpty() ? null : entites.get(0);
	}	
	
	protected Session getSession()
	{		
		return sessionFactory.getCurrentSession();
	}	
}
