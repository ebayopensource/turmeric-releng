/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.utils.cassandra.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ebayopensource.turmeric.utils.cassandra.model.SuperModel;

/**
 * The Interface SuperModelDao.
 * @author jamuguerza
 */
public interface SuperModelDao<SK, K> {
	
	/**
	 * Save.
	 *
	 * @param testSuperModel the test model
	 */
	void save(SuperModel<?, ?> testSuperModel);


	/**
	 * Find.
	 *
	 * @param fromSCNmame the from sc nmame
	 * @param toSCNmame the to sc nmame
	 * @return the super model
	 */
	 List<?> findByRange(K fromSCNmame, K toSCNmame);

	
	/**
	 * Find.
	 *
	 * @param key the key
	 * @param columnNames the column names
	 * @return the model
	 */
	SuperModel<?, ?>  find(SK key, K [] columnNames );

	/**
	 * Delete.
	 *
	 * @param testSuperModel the test super model
	 */
	void delete(SuperModel<?, ?> testSuperModel);
	
	/**
	 * Contains key.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	boolean containsKey(SK key);
	

	/**
	 * Gets the all keys.
	 *
	 * @return the all keys
	 */
	Set<SK> getAllKeys();
	
	/**
	 * Find items.
	 *
	 * @param superKeys the super keys
	 * @param columnNames the column names
	 * @return the sets the
	 */
	 Map<SK, SuperModel> findItems(final List<SK> superKeys, final K [] columnNames );
}