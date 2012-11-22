/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Deal#getDealplayer <em>Dealplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getOpendeck <em>Opendeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getCloseddeck <em>Closeddeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getJoker <em>Joker</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getCurrentTurn <em>Current Turn</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getDealNumber <em>Deal Number</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getShowInitiator <em>Show Initiator</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Deal#getMatch <em>Match</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getDeal()
 * @model extendedMetaData="name='Deal' kind='elementOnly'"
 * @generated
 */
public interface Deal extends EObject {
	/**
	 * Returns the value of the '<em><b>Dealplayer</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dealplayer</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dealplayer</em>' reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_Dealplayer()
	 * @model resolveProxies="false" lower="2" upper="5"
	 *        extendedMetaData="kind='element' name='dealplayer' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EObject> getDealplayer();

	/**
	 * Returns the value of the '<em><b>Opendeck</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opendeck</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opendeck</em>' reference.
	 * @see #setOpendeck(EObject)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_Opendeck()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='element' name='opendeck' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getOpendeck();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getOpendeck <em>Opendeck</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opendeck</em>' reference.
	 * @see #getOpendeck()
	 * @generated
	 */
	void setOpendeck(EObject value);

	/**
	 * Returns the value of the '<em><b>Closeddeck</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closeddeck</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closeddeck</em>' reference.
	 * @see #setCloseddeck(EObject)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_Closeddeck()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='element' name='closeddeck' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getCloseddeck();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getCloseddeck <em>Closeddeck</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closeddeck</em>' reference.
	 * @see #getCloseddeck()
	 * @generated
	 */
	void setCloseddeck(EObject value);

	/**
	 * Returns the value of the '<em><b>Joker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Joker</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Joker</em>' reference.
	 * @see #setJoker(EObject)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_Joker()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='element' name='joker' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getJoker();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getJoker <em>Joker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Joker</em>' reference.
	 * @see #getJoker()
	 * @generated
	 */
	void setJoker(EObject value);

	/**
	 * Returns the value of the '<em><b>Current Turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Turn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Turn</em>' attribute.
	 * @see #isSetCurrentTurn()
	 * @see #unsetCurrentTurn()
	 * @see #setCurrentTurn(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_CurrentTurn()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='current_turn'"
	 * @generated
	 */
	int getCurrentTurn();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getCurrentTurn <em>Current Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Turn</em>' attribute.
	 * @see #isSetCurrentTurn()
	 * @see #unsetCurrentTurn()
	 * @see #getCurrentTurn()
	 * @generated
	 */
	void setCurrentTurn(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Deal#getCurrentTurn <em>Current Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurrentTurn()
	 * @see #getCurrentTurn()
	 * @see #setCurrentTurn(int)
	 * @generated
	 */
	void unsetCurrentTurn();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Deal#getCurrentTurn <em>Current Turn</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Current Turn</em>' attribute is set.
	 * @see #unsetCurrentTurn()
	 * @see #getCurrentTurn()
	 * @see #setCurrentTurn(int)
	 * @generated
	 */
	boolean isSetCurrentTurn();

	/**
	 * Returns the value of the '<em><b>Deal Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deal Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deal Number</em>' attribute.
	 * @see #isSetDealNumber()
	 * @see #unsetDealNumber()
	 * @see #setDealNumber(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_DealNumber()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='deal_number'"
	 * @generated
	 */
	int getDealNumber();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getDealNumber <em>Deal Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deal Number</em>' attribute.
	 * @see #isSetDealNumber()
	 * @see #unsetDealNumber()
	 * @see #getDealNumber()
	 * @generated
	 */
	void setDealNumber(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Deal#getDealNumber <em>Deal Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDealNumber()
	 * @see #getDealNumber()
	 * @see #setDealNumber(int)
	 * @generated
	 */
	void unsetDealNumber();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Deal#getDealNumber <em>Deal Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Deal Number</em>' attribute is set.
	 * @see #unsetDealNumber()
	 * @see #getDealNumber()
	 * @see #setDealNumber(int)
	 * @generated
	 */
	boolean isSetDealNumber();

	/**
	 * Returns the value of the '<em><b>Show Initiator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Initiator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Initiator</em>' attribute.
	 * @see #isSetShowInitiator()
	 * @see #unsetShowInitiator()
	 * @see #setShowInitiator(long)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_ShowInitiator()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='show_initiator'"
	 * @generated
	 */
	long getShowInitiator();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getShowInitiator <em>Show Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Initiator</em>' attribute.
	 * @see #isSetShowInitiator()
	 * @see #unsetShowInitiator()
	 * @see #getShowInitiator()
	 * @generated
	 */
	void setShowInitiator(long value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Deal#getShowInitiator <em>Show Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShowInitiator()
	 * @see #getShowInitiator()
	 * @see #setShowInitiator(long)
	 * @generated
	 */
	void unsetShowInitiator();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Deal#getShowInitiator <em>Show Initiator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Show Initiator</em>' attribute is set.
	 * @see #unsetShowInitiator()
	 * @see #getShowInitiator()
	 * @see #setShowInitiator(long)
	 * @generated
	 */
	boolean isSetShowInitiator();

	/**
	 * Returns the value of the '<em><b>Match</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.mangogames.rummy.model.Match#getDeal <em>Deal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' container reference.
	 * @see #setMatch(Match)
	 * @see com.mangogames.rummy.model.ModelPackage#getDeal_Match()
	 * @see com.mangogames.rummy.model.Match#getDeal
	 * @model opposite="deal"
	 * @generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Deal#getMatch <em>Match</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' container reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Match value);
	
	/**
	 * Get deal player by id
	 * @param id
	 * @return
	 */
	DealPlayer getPlayerById(long id);

} // Deal
