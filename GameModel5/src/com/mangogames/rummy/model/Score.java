/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Score</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Score#getDealnum <em>Dealnum</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Score#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getScore()
 * @model extendedMetaData="name='Score' kind='empty'"
 * @generated
 */
public interface Score extends EObject {
	/**
	 * Returns the value of the '<em><b>Dealnum</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dealnum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dealnum</em>' attribute.
	 * @see #isSetDealnum()
	 * @see #unsetDealnum()
	 * @see #setDealnum(long)
	 * @see com.mangogames.rummy.model.ModelPackage#getScore_Dealnum()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='dealnum'"
	 * @generated
	 */
	long getDealnum();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Score#getDealnum <em>Dealnum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dealnum</em>' attribute.
	 * @see #isSetDealnum()
	 * @see #unsetDealnum()
	 * @see #getDealnum()
	 * @generated
	 */
	void setDealnum(long value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Score#getDealnum <em>Dealnum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDealnum()
	 * @see #getDealnum()
	 * @see #setDealnum(long)
	 * @generated
	 */
	void unsetDealnum();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Score#getDealnum <em>Dealnum</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dealnum</em>' attribute is set.
	 * @see #unsetDealnum()
	 * @see #getDealnum()
	 * @see #setDealnum(long)
	 * @generated
	 */
	boolean isSetDealnum();

	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see #isSetScore()
	 * @see #unsetScore()
	 * @see #setScore(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getScore_Score()
	 * @model default="-1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='score'"
	 * @generated
	 */
	int getScore();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Score#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' attribute.
	 * @see #isSetScore()
	 * @see #unsetScore()
	 * @see #getScore()
	 * @generated
	 */
	void setScore(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Score#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScore()
	 * @see #getScore()
	 * @see #setScore(int)
	 * @generated
	 */
	void unsetScore();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Score#getScore <em>Score</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Score</em>' attribute is set.
	 * @see #unsetScore()
	 * @see #getScore()
	 * @see #setScore(int)
	 * @generated
	 */
	boolean isSetScore();

} // Score
