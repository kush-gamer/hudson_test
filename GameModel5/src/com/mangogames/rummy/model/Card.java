/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Card</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Card#getRank <em>Rank</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Card#getSuit <em>Suit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getCard()
 * @model extendedMetaData="name='Card' kind='empty'"
 * @generated
 */
public interface Card extends EObject {
	/**
	 * Returns the value of the '<em><b>Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rank</em>' attribute.
	 * @see #isSetRank()
	 * @see #unsetRank()
	 * @see #setRank(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getCard_Rank()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='rank'"
	 * @generated
	 */
	int getRank();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Card#getRank <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rank</em>' attribute.
	 * @see #isSetRank()
	 * @see #unsetRank()
	 * @see #getRank()
	 * @generated
	 */
	void setRank(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Card#getRank <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRank()
	 * @see #getRank()
	 * @see #setRank(int)
	 * @generated
	 */
	void unsetRank();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Card#getRank <em>Rank</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rank</em>' attribute is set.
	 * @see #unsetRank()
	 * @see #getRank()
	 * @see #setRank(int)
	 * @generated
	 */
	boolean isSetRank();

	/**
	 * Returns the value of the '<em><b>Suit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suit</em>' attribute.
	 * @see #isSetSuit()
	 * @see #unsetSuit()
	 * @see #setSuit(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getCard_Suit()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='suit'"
	 * @generated
	 */
	int getSuit();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Card#getSuit <em>Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suit</em>' attribute.
	 * @see #isSetSuit()
	 * @see #unsetSuit()
	 * @see #getSuit()
	 * @generated
	 */
	void setSuit(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Card#getSuit <em>Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSuit()
	 * @see #getSuit()
	 * @see #setSuit(int)
	 * @generated
	 */
	void unsetSuit();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Card#getSuit <em>Suit</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Suit</em>' attribute is set.
	 * @see #unsetSuit()
	 * @see #getSuit()
	 * @see #setSuit(int)
	 * @generated
	 */
	boolean isSetSuit();
	
	/**
	 * Check if the card rank and suit are same for this card and compare card.
	 * @param compareCard
	 * @return
	 */
	boolean isEqual(Card compareCard);

} // Card
