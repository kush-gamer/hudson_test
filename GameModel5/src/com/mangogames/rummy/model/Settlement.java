/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settlement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Settlement#getChips <em>Chips</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Settlement#getLevel <em>Level</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Settlement#getTotalScore <em>Total Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Settlement#getXp <em>Xp</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getSettlement()
 * @model extendedMetaData="name='Settlement' kind='empty'"
 * @generated
 */
public interface Settlement extends EObject {
	/**
	 * Returns the value of the '<em><b>Chips</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chips</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chips</em>' attribute.
	 * @see #isSetChips()
	 * @see #unsetChips()
	 * @see #setChips(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getSettlement_Chips()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='chips'"
	 * @generated
	 */
	int getChips();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Settlement#getChips <em>Chips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chips</em>' attribute.
	 * @see #isSetChips()
	 * @see #unsetChips()
	 * @see #getChips()
	 * @generated
	 */
	void setChips(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Settlement#getChips <em>Chips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetChips()
	 * @see #getChips()
	 * @see #setChips(int)
	 * @generated
	 */
	void unsetChips();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Settlement#getChips <em>Chips</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Chips</em>' attribute is set.
	 * @see #unsetChips()
	 * @see #getChips()
	 * @see #setChips(int)
	 * @generated
	 */
	boolean isSetChips();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #setLevel(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getSettlement_Level()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='level'"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Settlement#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Settlement#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Settlement#getLevel <em>Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Level</em>' attribute is set.
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	boolean isSetLevel();

	/**
	 * Returns the value of the '<em><b>Total Score</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Score</em>' attribute.
	 * @see #isSetTotalScore()
	 * @see #unsetTotalScore()
	 * @see #setTotalScore(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getSettlement_TotalScore()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='totalScore'"
	 * @generated
	 */
	int getTotalScore();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Settlement#getTotalScore <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Score</em>' attribute.
	 * @see #isSetTotalScore()
	 * @see #unsetTotalScore()
	 * @see #getTotalScore()
	 * @generated
	 */
	void setTotalScore(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Settlement#getTotalScore <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalScore()
	 * @see #getTotalScore()
	 * @see #setTotalScore(int)
	 * @generated
	 */
	void unsetTotalScore();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Settlement#getTotalScore <em>Total Score</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Score</em>' attribute is set.
	 * @see #unsetTotalScore()
	 * @see #getTotalScore()
	 * @see #setTotalScore(int)
	 * @generated
	 */
	boolean isSetTotalScore();

	/**
	 * Returns the value of the '<em><b>Xp</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xp</em>' attribute.
	 * @see #isSetXp()
	 * @see #unsetXp()
	 * @see #setXp(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getSettlement_Xp()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='xp'"
	 * @generated
	 */
	int getXp();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Settlement#getXp <em>Xp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xp</em>' attribute.
	 * @see #isSetXp()
	 * @see #unsetXp()
	 * @see #getXp()
	 * @generated
	 */
	void setXp(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Settlement#getXp <em>Xp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXp()
	 * @see #getXp()
	 * @see #setXp(int)
	 * @generated
	 */
	void unsetXp();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Settlement#getXp <em>Xp</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Xp</em>' attribute is set.
	 * @see #unsetXp()
	 * @see #getXp()
	 * @see #setXp(int)
	 * @generated
	 */
	boolean isSetXp();

} // Settlement
