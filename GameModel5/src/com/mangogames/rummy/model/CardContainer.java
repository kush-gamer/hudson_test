/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Card Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.CardContainer#getCard <em>Card</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getCardContainer()
 * @model abstract="true"
 *        extendedMetaData="name='CardContainer' kind='elementOnly'"
 * @generated
 */
public interface CardContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Card</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Card</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Card</em>' reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getCardContainer_Card()
	 * @model resolveProxies="false"
	 *        extendedMetaData="kind='element' name='card' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EObject> getCard();
	
	void shuffle();

} // CardContainer
