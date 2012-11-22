/**
 */
package com.mangogames.rummy.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Player#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getPlayer()
 * @model extendedMetaData="name='Player' kind='empty'"
 * @generated
 */
public interface Player extends User {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"0"</code>.
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
	 * @see com.mangogames.rummy.model.ModelPackage#getPlayer_Type()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	int getType();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Player#getType <em>Type</em>}' attribute.
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
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Player#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(int)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Player#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(int)
	 * @generated
	 */
	boolean isSetType();
} // Player
