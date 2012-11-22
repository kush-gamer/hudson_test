/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Match#getMatchplayer <em>Matchplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Match#getDeal <em>Deal</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Match#getDealCount <em>Deal Count</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Match#getId <em>Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Match#getLastStartTurn <em>Last Start Turn</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Match#getGame <em>Game</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getMatch()
 * @model extendedMetaData="name='Match' kind='elementOnly'"
 * @generated
 */
public interface Match extends EObject {
	/**
	 * Returns the value of the '<em><b>Matchplayer</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matchplayer</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matchplayer</em>' reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getMatch_Matchplayer()
	 * @model resolveProxies="false" lower="2" upper="5"
	 *        extendedMetaData="kind='element' name='matchplayer' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EObject> getMatchplayer();

	/**
	 * Returns the value of the '<em><b>Deal</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.mangogames.rummy.model.Deal#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deal</em>' containment reference.
	 * @see #setDeal(Deal)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatch_Deal()
	 * @see com.mangogames.rummy.model.Deal#getMatch
	 * @model opposite="Match" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='deal' namespace='##targetNamespace'"
	 * @generated
	 */
	Deal getDeal();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Match#getDeal <em>Deal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deal</em>' containment reference.
	 * @see #getDeal()
	 * @generated
	 */
	void setDeal(Deal value);

	/**
	 * Returns the value of the '<em><b>Deal Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deal Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deal Count</em>' attribute.
	 * @see #isSetDealCount()
	 * @see #unsetDealCount()
	 * @see #setDealCount(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatch_DealCount()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='deal_count'"
	 * @generated
	 */
	int getDealCount();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Match#getDealCount <em>Deal Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deal Count</em>' attribute.
	 * @see #isSetDealCount()
	 * @see #unsetDealCount()
	 * @see #getDealCount()
	 * @generated
	 */
	void setDealCount(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Match#getDealCount <em>Deal Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDealCount()
	 * @see #getDealCount()
	 * @see #setDealCount(int)
	 * @generated
	 */
	void unsetDealCount();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Match#getDealCount <em>Deal Count</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Deal Count</em>' attribute is set.
	 * @see #unsetDealCount()
	 * @see #getDealCount()
	 * @see #setDealCount(int)
	 * @generated
	 */
	boolean isSetDealCount();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #setId(long)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatch_Id()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Match#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Match#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(long)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Match#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(long)
	 * @generated
	 */
	boolean isSetId();

	/**
	 * Returns the value of the '<em><b>Last Start Turn</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Start Turn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Start Turn</em>' attribute.
	 * @see #isSetLastStartTurn()
	 * @see #unsetLastStartTurn()
	 * @see #setLastStartTurn(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatch_LastStartTurn()
	 * @model default="-1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='last_start_turn'"
	 * @generated
	 */
	int getLastStartTurn();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Match#getLastStartTurn <em>Last Start Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Start Turn</em>' attribute.
	 * @see #isSetLastStartTurn()
	 * @see #unsetLastStartTurn()
	 * @see #getLastStartTurn()
	 * @generated
	 */
	void setLastStartTurn(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Match#getLastStartTurn <em>Last Start Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastStartTurn()
	 * @see #getLastStartTurn()
	 * @see #setLastStartTurn(int)
	 * @generated
	 */
	void unsetLastStartTurn();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Match#getLastStartTurn <em>Last Start Turn</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Start Turn</em>' attribute is set.
	 * @see #unsetLastStartTurn()
	 * @see #getLastStartTurn()
	 * @see #setLastStartTurn(int)
	 * @generated
	 */
	boolean isSetLastStartTurn();

	/**
	 * Returns the value of the '<em><b>Game</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.mangogames.rummy.model.Game#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Game</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game</em>' container reference.
	 * @see #setGame(Game)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatch_Game()
	 * @see com.mangogames.rummy.model.Game#getMatch
	 * @model opposite="match"
	 * @generated
	 */
	Game getGame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Match#getGame <em>Game</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game</em>' container reference.
	 * @see #getGame()
	 * @generated
	 */
	void setGame(Game value);
	
	/**
	 * Gets the match player from the list of players in the match.
	 * @param ID
	 * @return
	 */
	MatchPlayer getMatchPlayerById(long ID);

} // Match
