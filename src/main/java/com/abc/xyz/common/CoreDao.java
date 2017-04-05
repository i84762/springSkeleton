package com.abc.xyz.common;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author amrit
 * 
 */

@Transactional
public interface CoreDao<E extends CoreEntity>
{
	Class<E> getEntity();
	
 	E findByID(long id);	 
 	List<E> getALLEntities();
 	
	long save(E entity);
	void update(E entity);;
}
