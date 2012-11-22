/**
 */
package com.mangogames.rummy.model;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.MatchPlayer#getScore <em>Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.MatchPlayer#getSettlement <em>Settlement</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.MatchPlayer#getState <em>State</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.MatchPlayer#getTimeOfJoining <em>Time Of Joining</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.MatchPlayer#getTossRank <em>Toss Rank</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getMatchPlayer()
 * @model extendedMetaData="name='MatchPlayer' kind='elementOnly'"
 * @generated
 */
public interface MatchPlayer extends Player {
	/**
	 * Returns the value of the '<em><b>Score</b></em>' containment reference list.
	 * The list contents are of type {@link com.mangogames.rummy.model.Score}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' containment reference list.
	 * @see com.mangogames.rummy.model.ModelPackage#getMatchPlayer_Score()
	 * @model containment="true" required="true" upper="5"
	 *        extendedMetaData="kind='element' name='score' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Score> getScore();

	/**
	 * Returns the value of the '<em><b>Settlement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settlement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settlement</em>' containment reference.
	 * @see #setSettlement(Settlement)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatchPlayer_Settlement()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='settlement' namespace='##targetNamespace'"
	 * @generated
	 */
	Settlement getSettlement();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getSettlement <em>Settlement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settlement</em>' containment reference.
	 * @see #getSettlement()
	 * @generated
	 */
	void setSettlement(Settlement value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatchPlayer_State()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='state'"
	 * @generated
	 */
	int getState();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(int)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(int)
	 * @generated
	 */
	boolean isSetState();

	/**
	 * Returns the value of the '<em><b>Time Of Joining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Of Joining</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Of Joining</em>' attribute.
	 * @see #setTimeOfJoining(XMLGregorianCalendar)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatchPlayer_TimeOfJoining()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='time_of_joining'"
	 * @generated
	 */
	XMLGregorianCalendar getTimeOfJoining();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getTimeOfJoining <em>Time Of Joining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Of Joining</em>' attribute.
	 * @see #getTimeOfJoining()
	 * @generated
	 */
	void setTimeOfJoining(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Toss Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toss Rank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Toss Rank</em>' attribute.
	 * @see #isSetTossRank()
	 * @see #unsetTossRank()
	 * @see #setTossRank(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getMatchPlayer_TossRank()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='toss_rank'"
	 * @generated
	 */
	int getTossRank();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getTossRank <em>Toss Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Toss Rank</em>' attribute.
	 * @see #isSetTossRank()
	 * @see #unsetTossRank()
	 * @see #getTossRank()
	 * @generated
	 */
	void setTossRank(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getTossRank <em>Toss Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTossRank()
	 * @see #getTossRank()
	 * @see #setTossRank(int)
	 * @generated
	 */
	void unsetTossRank();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.MatchPlayer#getTossRank <em>Toss Rank</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Toss Rank</em>' attribute is set.
	 * @see #unsetTossRank()
	 * @see #getTossRank()
	 * @see #setTossRank(int)
	 * @generated
	 */
	boolean isSetTossRank();
	
	int getTotalScore();
	
	int getMatchAverageScore(int dealNumber);
	

} // MatchPlayer
