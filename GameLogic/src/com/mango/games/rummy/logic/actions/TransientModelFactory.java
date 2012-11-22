/**
 * This is to be used for creating transient objects. 
 * Currently these transient objects are required to translate SFS params
 * to to appropriate data structures.
 * 
 * This class is designed to be used only from inside DefaultActionHandler.
 */
package com.mango.games.rummy.logic.actions;

import com.mangogames.rummy.model.ModelFactory;
import com.mangogames.rummy.model.ModelPackage;

/**
 * This class is scoped for use from Actions package only to create transient model objects
 * to translate from SFS to native classes.
 * 
 * It should not be used for creating game model objects.
 * @author admin
 *
 */
class TransientModelFactory 
{
	 public static ModelFactory getFactory()
	 {
		 ModelPackage.eINSTANCE.eClass();
		 // Retrieve the default factory singleton
		 return ModelFactory.eINSTANCE;
	 }
}