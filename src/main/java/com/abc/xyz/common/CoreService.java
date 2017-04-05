package com.abc.xyz.common;

import java.util.List;


/**
 * 
 * @author amrit
 * 
 */
public interface CoreService<V extends CoreDTOView,
							E extends CoreEntity,
							D extends CoreDao<E>,
							M extends DTOMapper<E, V>>
{
	
	D getDao();
	M getMapper();
	
	default V findByID(long id)
	{
		return getMapper().getMappedView(getDao().findByID(id));
	}
	
	default List<V> getAllViews() 
	{		
		return getMapper().getMappedViews(getDao().getALLEntities());
	}
		
	default long save(V view) 
	{
		return getDao().save(getMapper().getMappedEntity(view));
	}
	
	default void update(V view)
	{
		getDao().update(getMapper().getMappedEntity(view));
	}	
}