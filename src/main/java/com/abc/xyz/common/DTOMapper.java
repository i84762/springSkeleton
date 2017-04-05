package com.abc.xyz.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author amrit
 * 
 */
public interface DTOMapper<E extends CoreEntity, V extends CoreDTOView> 
{
	E getMappedEntity(V view);
	E mapEntity(E entity, V view);
	
	V getMappedView(E entity);
	V mapView(V view, E entity);
	
	default List<V> getMappedViews(List<E> entities)
	{
		List<V> views = new ArrayList(); 
		entities.forEach(entity -> views.add(getMappedView(entity)));
		return views;
	}
	
	default List<E> getMappedEntities(List<V> views)
	{
		List<E> entities = new ArrayList(); 
		views.forEach(view -> entities.add(getMappedEntity(view)));
		return entities;
	}
}
