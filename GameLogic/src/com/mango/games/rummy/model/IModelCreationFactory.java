/**
 * This is to enable model creation to be invoked from GameLogic. The factory is in ModelExtensions. To avoid circular references
 * this interface is used.
 */
package com.mango.games.rummy.model;

/**
 * @author Mango6
 *
 */
public interface IModelCreationFactory 
{

	public Object createObject(Class<?> targetClass) ;
}
