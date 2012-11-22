/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hand Cards</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.HandCards#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getHandCards()
 * @model extendedMetaData="name='HandCards' kind='elementOnly'"
 * @generated
 */
public interface HandCards extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getHandCards_Groups()
	 * @model resolveProxies="false" required="true" upper="7"
	 *        extendedMetaData="kind='element' name='groups' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EObject> getGroups();
	
	/**
	 * Returns a given group, from the list of groups in Handcards.
	 * To get the first group, which is typically the snapshot of cards on server side,
	 * call getGroupsByIndex(0)
	 * @param index
	 * @return
	 */
	GroupCards getGroupByIndex(int index);

	

} // HandCards
