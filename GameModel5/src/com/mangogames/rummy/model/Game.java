/**
 */
package com.mangogames.rummy.model;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Game#getSeat <em>Seat</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getMatch <em>Match</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getUser <em>User</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getPrize <em>Prize</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getEntryFee <em>Entry Fee</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getId <em>Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getMaxPlayers <em>Max Players</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getMaxScore <em>Max Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getMaxSpectators <em>Max Spectators</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getMinPlayersRequired <em>Min Players Required</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getPotValue <em>Pot Value</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getRake <em>Rake</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Game#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getGame()
 * @model abstract="true"
 *        extendedMetaData="name='Game' kind='elementOnly'"
 * @generated
 */
public interface Game extends EObject {
	/**
	 * Returns the value of the '<em><b>Seat</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seat</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seat</em>' reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Seat()
	 * @model resolveProxies="false" lower="2" upper="5"
	 *        extendedMetaData="kind='element' name='seat' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EObject> getSeat();

	/**
	 * Returns the value of the '<em><b>Match</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.mangogames.rummy.model.Match#getGame <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' containment reference.
	 * @see #setMatch(Match)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Match()
	 * @see com.mangogames.rummy.model.Match#getGame
	 * @model opposite="Game" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='match' namespace='##targetNamespace'"
	 * @generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getMatch <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' containment reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Match value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_User()
	 * @model resolveProxies="false"
	 *        extendedMetaData="kind='element' name='user' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EObject> getUser();

	/**
	 * Returns the value of the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prize</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prize</em>' reference.
	 * @see #setPrize(EObject)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Prize()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='element' name='prize' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getPrize();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getPrize <em>Prize</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prize</em>' reference.
	 * @see #getPrize()
	 * @generated
	 */
	void setPrize(EObject value);

	/**
	 * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic</em>' attribute.
	 * @see #isSetDynamic()
	 * @see #unsetDynamic()
	 * @see #setDynamic(boolean)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Dynamic()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='dynamic'"
	 * @generated
	 */
	boolean isDynamic();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#isDynamic <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic</em>' attribute.
	 * @see #isSetDynamic()
	 * @see #unsetDynamic()
	 * @see #isDynamic()
	 * @generated
	 */
	void setDynamic(boolean value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#isDynamic <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDynamic()
	 * @see #isDynamic()
	 * @see #setDynamic(boolean)
	 * @generated
	 */
	void unsetDynamic();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#isDynamic <em>Dynamic</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dynamic</em>' attribute is set.
	 * @see #unsetDynamic()
	 * @see #isDynamic()
	 * @see #setDynamic(boolean)
	 * @generated
	 */
	boolean isSetDynamic();

	/**
	 * Returns the value of the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Fee</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Fee</em>' attribute.
	 * @see #setEntryFee(BigDecimal)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_EntryFee()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Decimal"
	 *        extendedMetaData="kind='attribute' name='entry_fee'"
	 * @generated
	 */
	BigDecimal getEntryFee();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getEntryFee <em>Entry Fee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Fee</em>' attribute.
	 * @see #getEntryFee()
	 * @generated
	 */
	void setEntryFee(BigDecimal value);

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
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Id()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getId <em>Id</em>}' attribute.
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
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(long)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getId <em>Id</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Max Players</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Players</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Players</em>' attribute.
	 * @see #isSetMaxPlayers()
	 * @see #unsetMaxPlayers()
	 * @see #setMaxPlayers(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_MaxPlayers()
	 * @model default="5" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='max_players'"
	 * @generated
	 */
	int getMaxPlayers();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getMaxPlayers <em>Max Players</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Players</em>' attribute.
	 * @see #isSetMaxPlayers()
	 * @see #unsetMaxPlayers()
	 * @see #getMaxPlayers()
	 * @generated
	 */
	void setMaxPlayers(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getMaxPlayers <em>Max Players</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxPlayers()
	 * @see #getMaxPlayers()
	 * @see #setMaxPlayers(int)
	 * @generated
	 */
	void unsetMaxPlayers();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getMaxPlayers <em>Max Players</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Players</em>' attribute is set.
	 * @see #unsetMaxPlayers()
	 * @see #getMaxPlayers()
	 * @see #setMaxPlayers(int)
	 * @generated
	 */
	boolean isSetMaxPlayers();

	/**
	 * Returns the value of the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Score</em>' attribute.
	 * @see #isSetMaxScore()
	 * @see #unsetMaxScore()
	 * @see #setMaxScore(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_MaxScore()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='max_score'"
	 * @generated
	 */
	int getMaxScore();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getMaxScore <em>Max Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Score</em>' attribute.
	 * @see #isSetMaxScore()
	 * @see #unsetMaxScore()
	 * @see #getMaxScore()
	 * @generated
	 */
	void setMaxScore(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getMaxScore <em>Max Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxScore()
	 * @see #getMaxScore()
	 * @see #setMaxScore(int)
	 * @generated
	 */
	void unsetMaxScore();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getMaxScore <em>Max Score</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Score</em>' attribute is set.
	 * @see #unsetMaxScore()
	 * @see #getMaxScore()
	 * @see #setMaxScore(int)
	 * @generated
	 */
	boolean isSetMaxScore();

	/**
	 * Returns the value of the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Spectators</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Spectators</em>' attribute.
	 * @see #isSetMaxSpectators()
	 * @see #unsetMaxSpectators()
	 * @see #setMaxSpectators(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_MaxSpectators()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='max_spectators'"
	 * @generated
	 */
	int getMaxSpectators();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getMaxSpectators <em>Max Spectators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Spectators</em>' attribute.
	 * @see #isSetMaxSpectators()
	 * @see #unsetMaxSpectators()
	 * @see #getMaxSpectators()
	 * @generated
	 */
	void setMaxSpectators(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getMaxSpectators <em>Max Spectators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxSpectators()
	 * @see #getMaxSpectators()
	 * @see #setMaxSpectators(int)
	 * @generated
	 */
	void unsetMaxSpectators();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getMaxSpectators <em>Max Spectators</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Spectators</em>' attribute is set.
	 * @see #unsetMaxSpectators()
	 * @see #getMaxSpectators()
	 * @see #setMaxSpectators(int)
	 * @generated
	 */
	boolean isSetMaxSpectators();

	/**
	 * Returns the value of the '<em><b>Min Players Required</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Players Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Players Required</em>' attribute.
	 * @see #isSetMinPlayersRequired()
	 * @see #unsetMinPlayersRequired()
	 * @see #setMinPlayersRequired(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_MinPlayersRequired()
	 * @model default="2" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='min_players_required'"
	 * @generated
	 */
	int getMinPlayersRequired();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getMinPlayersRequired <em>Min Players Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Players Required</em>' attribute.
	 * @see #isSetMinPlayersRequired()
	 * @see #unsetMinPlayersRequired()
	 * @see #getMinPlayersRequired()
	 * @generated
	 */
	void setMinPlayersRequired(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getMinPlayersRequired <em>Min Players Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinPlayersRequired()
	 * @see #getMinPlayersRequired()
	 * @see #setMinPlayersRequired(int)
	 * @generated
	 */
	void unsetMinPlayersRequired();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getMinPlayersRequired <em>Min Players Required</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Players Required</em>' attribute is set.
	 * @see #unsetMinPlayersRequired()
	 * @see #getMinPlayersRequired()
	 * @see #setMinPlayersRequired(int)
	 * @generated
	 */
	boolean isSetMinPlayersRequired();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Owner()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='owner'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pot Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pot Value</em>' attribute.
	 * @see #isSetPotValue()
	 * @see #unsetPotValue()
	 * @see #setPotValue(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_PotValue()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='pot_value'"
	 * @generated
	 */
	int getPotValue();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getPotValue <em>Pot Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pot Value</em>' attribute.
	 * @see #isSetPotValue()
	 * @see #unsetPotValue()
	 * @see #getPotValue()
	 * @generated
	 */
	void setPotValue(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getPotValue <em>Pot Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPotValue()
	 * @see #getPotValue()
	 * @see #setPotValue(int)
	 * @generated
	 */
	void unsetPotValue();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getPotValue <em>Pot Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pot Value</em>' attribute is set.
	 * @see #unsetPotValue()
	 * @see #getPotValue()
	 * @see #setPotValue(int)
	 * @generated
	 */
	boolean isSetPotValue();

	/**
	 * Returns the value of the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rake</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rake</em>' attribute.
	 * @see #isSetRake()
	 * @see #unsetRake()
	 * @see #setRake(float)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Rake()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float"
	 *        extendedMetaData="kind='attribute' name='rake'"
	 * @generated
	 */
	float getRake();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getRake <em>Rake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rake</em>' attribute.
	 * @see #isSetRake()
	 * @see #unsetRake()
	 * @see #getRake()
	 * @generated
	 */
	void setRake(float value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getRake <em>Rake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRake()
	 * @see #getRake()
	 * @see #setRake(float)
	 * @generated
	 */
	void unsetRake();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getRake <em>Rake</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rake</em>' attribute is set.
	 * @see #unsetRake()
	 * @see #getRake()
	 * @see #setRake(float)
	 * @generated
	 */
	boolean isSetRake();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getGame_Type()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	int getType();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Game#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Game#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(int)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Game#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(int)
	 * @generated
	 */
	boolean isSetType();
	
	int     getNumSeatedPlayers();
	
	/**
	 * Gets the first occupied seat in the order 0..5
	 * @return
	 */
	Seat     getFirstOccupiedSeat();
	
	/**
	 * Given the current seatid, this method returns the next occupied seat.
	 * @param curSeatId
	 * @return
	 */
	Seat     getNextOccupiedSeat(int curSeatId);

} // Game
