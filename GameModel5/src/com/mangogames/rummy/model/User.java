/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.User#getChips <em>Chips</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.User#getId <em>Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.User#getLevel <em>Level</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.User#getName <em>Name</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.User#getSource <em>Source</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.User#getUidSrc <em>Uid Src</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.User#getXp <em>Xp</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getUser()
 * @model extendedMetaData="name='User' kind='empty'"
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Chips</b></em>' attribute.
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
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_Chips()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='chips'"
	 * @generated
	 */
	int getChips();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getChips <em>Chips</em>}' attribute.
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
	 * Unsets the value of the '{@link com.mangogames.rummy.model.User#getChips <em>Chips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetChips()
	 * @see #getChips()
	 * @see #setChips(int)
	 * @generated
	 */
	void unsetChips();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.User#getChips <em>Chips</em>}' attribute is set.
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
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_Id()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getId <em>Id</em>}' attribute.
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
	 * Unsets the value of the '{@link com.mangogames.rummy.model.User#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(long)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.User#getId <em>Id</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
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
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_Level()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='level'"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getLevel <em>Level</em>}' attribute.
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
	 * Unsets the value of the '{@link com.mangogames.rummy.model.User#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.User#getLevel <em>Level</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #isSetSource()
	 * @see #unsetSource()
	 * @see #setSource(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_Source()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='source'"
	 * @generated
	 */
	int getSource();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #isSetSource()
	 * @see #unsetSource()
	 * @see #getSource()
	 * @generated
	 */
	void setSource(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.User#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSource()
	 * @see #getSource()
	 * @see #setSource(int)
	 * @generated
	 */
	void unsetSource();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.User#getSource <em>Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Source</em>' attribute is set.
	 * @see #unsetSource()
	 * @see #getSource()
	 * @see #setSource(int)
	 * @generated
	 */
	boolean isSetSource();

	/**
	 * Returns the value of the '<em><b>Uid Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uid Src</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uid Src</em>' attribute.
	 * @see #setUidSrc(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_UidSrc()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uid_src'"
	 * @generated
	 */
	String getUidSrc();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getUidSrc <em>Uid Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid Src</em>' attribute.
	 * @see #getUidSrc()
	 * @generated
	 */
	void setUidSrc(String value);

	/**
	 * Returns the value of the '<em><b>Xp</b></em>' attribute.
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
	 * @see com.mangogames.rummy.model.ModelPackage#getUser_Xp()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='xp'"
	 * @generated
	 */
	int getXp();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.User#getXp <em>Xp</em>}' attribute.
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
	 * Unsets the value of the '{@link com.mangogames.rummy.model.User#getXp <em>Xp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXp()
	 * @see #getXp()
	 * @see #setXp(int)
	 * @generated
	 */
	void unsetXp();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.User#getXp <em>Xp</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Xp</em>' attribute is set.
	 * @see #unsetXp()
	 * @see #getXp()
	 * @see #setXp(int)
	 * @generated
	 */
	boolean isSetXp();

} // User
