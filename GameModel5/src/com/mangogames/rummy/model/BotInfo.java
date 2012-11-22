/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getNewElement <em>New Element</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getBotId <em>Bot Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getDob <em>Dob</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getEmail <em>Email</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#isEngaged <em>Engaged</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getGender <em>Gender</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getLocation <em>Location</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getName <em>Name</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getRoomId <em>Room Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.BotInfo#getSourceId <em>Source Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo()
 * @model extendedMetaData="name='BotInfo' kind='elementOnly'"
 * @generated
 */
public interface BotInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>New Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Element</em>' attribute.
	 * @see #setNewElement(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_NewElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='NewElement'"
	 * @generated
	 */
	String getNewElement();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getNewElement <em>New Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Element</em>' attribute.
	 * @see #getNewElement()
	 * @generated
	 */
	void setNewElement(String value);

	/**
	 * Returns the value of the '<em><b>Bot Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bot Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bot Id</em>' attribute.
	 * @see #isSetBotId()
	 * @see #unsetBotId()
	 * @see #setBotId(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_BotId()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='bot_id'"
	 * @generated
	 */
	int getBotId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getBotId <em>Bot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bot Id</em>' attribute.
	 * @see #isSetBotId()
	 * @see #unsetBotId()
	 * @see #getBotId()
	 * @generated
	 */
	void setBotId(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.BotInfo#getBotId <em>Bot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBotId()
	 * @see #getBotId()
	 * @see #setBotId(int)
	 * @generated
	 */
	void unsetBotId();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.BotInfo#getBotId <em>Bot Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bot Id</em>' attribute is set.
	 * @see #unsetBotId()
	 * @see #getBotId()
	 * @see #setBotId(int)
	 * @generated
	 */
	boolean isSetBotId();

	/**
	 * Returns the value of the '<em><b>Dob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dob</em>' attribute.
	 * @see #setDob(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_Dob()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dob'"
	 * @generated
	 */
	String getDob();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getDob <em>Dob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dob</em>' attribute.
	 * @see #getDob()
	 * @generated
	 */
	void setDob(String value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_Email()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='email'"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Engaged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engaged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engaged</em>' attribute.
	 * @see #isSetEngaged()
	 * @see #unsetEngaged()
	 * @see #setEngaged(boolean)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_Engaged()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='engaged'"
	 * @generated
	 */
	boolean isEngaged();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#isEngaged <em>Engaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engaged</em>' attribute.
	 * @see #isSetEngaged()
	 * @see #unsetEngaged()
	 * @see #isEngaged()
	 * @generated
	 */
	void setEngaged(boolean value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.BotInfo#isEngaged <em>Engaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEngaged()
	 * @see #isEngaged()
	 * @see #setEngaged(boolean)
	 * @generated
	 */
	void unsetEngaged();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.BotInfo#isEngaged <em>Engaged</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Engaged</em>' attribute is set.
	 * @see #unsetEngaged()
	 * @see #isEngaged()
	 * @see #setEngaged(boolean)
	 * @generated
	 */
	boolean isSetEngaged();

	/**
	 * Returns the value of the '<em><b>Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Id</em>' attribute.
	 * @see #setSourceId(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_SourceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='source_id'"
	 * @generated
	 */
	String getSourceId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getSourceId <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Id</em>' attribute.
	 * @see #getSourceId()
	 * @generated
	 */
	void setSourceId(String value);

	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see #setGender(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_Gender()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='gender'"
	 * @generated
	 */
	String getGender();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see #getGender()
	 * @generated
	 */
	void setGender(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_Location()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

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
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Room Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Room Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Room Id</em>' attribute.
	 * @see #setRoomId(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getBotInfo_RoomId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='room_id'"
	 * @generated
	 */
	String getRoomId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.BotInfo#getRoomId <em>Room Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Room Id</em>' attribute.
	 * @see #getRoomId()
	 * @generated
	 */
	void setRoomId(String value);

} // Bot
