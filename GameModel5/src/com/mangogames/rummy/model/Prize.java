/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prize</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Prize#getCurrency <em>Currency</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Prize#getGoodie <em>Goodie</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Prize#getPrizeName <em>Prize Name</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Prize#getXP <em>XP</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getPrize()
 * @model extendedMetaData="name='Prize' kind='empty'"
 * @generated
 */
public interface Prize extends EObject {
	/**
	 * Returns the value of the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Currency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Currency</em>' attribute.
	 * @see #setCurrency(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getPrize_Currency()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Currency'"
	 * @generated
	 */
	String getCurrency();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Prize#getCurrency <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Currency</em>' attribute.
	 * @see #getCurrency()
	 * @generated
	 */
	void setCurrency(String value);

	/**
	 * Returns the value of the '<em><b>Goodie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goodie</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goodie</em>' attribute.
	 * @see #setGoodie(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getPrize_Goodie()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Goodie'"
	 * @generated
	 */
	String getGoodie();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Prize#getGoodie <em>Goodie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goodie</em>' attribute.
	 * @see #getGoodie()
	 * @generated
	 */
	void setGoodie(String value);

	/**
	 * Returns the value of the '<em><b>Prize Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prize Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prize Name</em>' attribute.
	 * @see #setPrizeName(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getPrize_PrizeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PrizeName'"
	 * @generated
	 */
	String getPrizeName();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Prize#getPrizeName <em>Prize Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prize Name</em>' attribute.
	 * @see #getPrizeName()
	 * @generated
	 */
	void setPrizeName(String value);

	/**
	 * Returns the value of the '<em><b>XP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XP</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XP</em>' attribute.
	 * @see #setXP(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getPrize_XP()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='XP'"
	 * @generated
	 */
	String getXP();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Prize#getXP <em>XP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XP</em>' attribute.
	 * @see #getXP()
	 * @generated
	 */
	void setXP(String value);

} // Prize
