/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.BotInfo;
import com.mangogames.rummy.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getNewElement <em>New Element</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getBotId <em>Bot Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getDob <em>Dob</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#isEngaged <em>Engaged</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getRoomId <em>Room Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.BotInfoImpl#getSourceId <em>Source Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BotInfoImpl extends EObjectImpl implements BotInfo 
{
	/**
	 * The default value of the '{@link #getNewElement() <em>New Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewElement()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewElement() <em>New Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewElement()
	 * @generated
	 * @ordered
	 */
	protected String newElement = NEW_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBotId() <em>Bot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBotId()
	 * @generated
	 * @ordered
	 */
	protected static final int BOT_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBotId() <em>Bot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBotId()
	 * @generated
	 * @ordered
	 */
	protected int botId = BOT_ID_EDEFAULT;

	/**
	 * This is true if the Bot Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean botIdESet;

	/**
	 * The default value of the '{@link #getDob() <em>Dob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDob()
	 * @generated
	 * @ordered
	 */
	protected static final String DOB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDob() <em>Dob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDob()
	 * @generated
	 * @ordered
	 */
	protected String dob = DOB_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #isEngaged() <em>Engaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEngaged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENGAGED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEngaged() <em>Engaged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEngaged()
	 * @generated
	 * @ordered
	 */
	protected boolean engaged = ENGAGED_EDEFAULT;

	/**
	 * This is true if the Engaged attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean engagedESet;

	/**
	 * The default value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected static final String GENDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected String gender = GENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoomId() <em>Room Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoomId()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoomId() <em>Room Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoomId()
	 * @generated
	 * @ordered
	 */
	protected String roomId = ROOM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceId() <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceId() <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceId()
	 * @generated
	 * @ordered
	 */
	protected String sourceId = SOURCE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BotInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BOT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewElement() {
		return newElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewElement(String newNewElement) {
		String oldNewElement = newElement;
		newElement = newNewElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__NEW_ELEMENT, oldNewElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBotId() {
		return botId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBotId(int newBotId) {
		int oldBotId = botId;
		botId = newBotId;
		boolean oldBotIdESet = botIdESet;
		botIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__BOT_ID, oldBotId, botId, !oldBotIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBotId() {
		int oldBotId = botId;
		boolean oldBotIdESet = botIdESet;
		botId = BOT_ID_EDEFAULT;
		botIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.BOT_INFO__BOT_ID, oldBotId, BOT_ID_EDEFAULT, oldBotIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBotId() {
		return botIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDob(String newDob) {
		String oldDob = dob;
		dob = newDob;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__DOB, oldDob, dob));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEngaged() {
		return engaged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngaged(boolean newEngaged) {
		boolean oldEngaged = engaged;
		engaged = newEngaged;
		boolean oldEngagedESet = engagedESet;
		engagedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__ENGAGED, oldEngaged, engaged, !oldEngagedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEngaged() {
		boolean oldEngaged = engaged;
		boolean oldEngagedESet = engagedESet;
		engaged = ENGAGED_EDEFAULT;
		engagedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.BOT_INFO__ENGAGED, oldEngaged, ENGAGED_EDEFAULT, oldEngagedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEngaged() {
		return engagedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceId(String newSourceId) {
		String oldSourceId = sourceId;
		sourceId = newSourceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__SOURCE_ID, oldSourceId, sourceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGender(String newGender) {
		String oldGender = gender;
		gender = newGender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__GENDER, oldGender, gender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoomId(String newRoomId) {
		String oldRoomId = roomId;
		roomId = newRoomId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOT_INFO__ROOM_ID, oldRoomId, roomId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BOT_INFO__NEW_ELEMENT:
				return getNewElement();
			case ModelPackage.BOT_INFO__BOT_ID:
				return getBotId();
			case ModelPackage.BOT_INFO__DOB:
				return getDob();
			case ModelPackage.BOT_INFO__EMAIL:
				return getEmail();
			case ModelPackage.BOT_INFO__ENGAGED:
				return isEngaged();
			case ModelPackage.BOT_INFO__GENDER:
				return getGender();
			case ModelPackage.BOT_INFO__LOCATION:
				return getLocation();
			case ModelPackage.BOT_INFO__NAME:
				return getName();
			case ModelPackage.BOT_INFO__ROOM_ID:
				return getRoomId();
			case ModelPackage.BOT_INFO__SOURCE_ID:
				return getSourceId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.BOT_INFO__NEW_ELEMENT:
				setNewElement((String)newValue);
				return;
			case ModelPackage.BOT_INFO__BOT_ID:
				setBotId((Integer)newValue);
				return;
			case ModelPackage.BOT_INFO__DOB:
				setDob((String)newValue);
				return;
			case ModelPackage.BOT_INFO__EMAIL:
				setEmail((String)newValue);
				return;
			case ModelPackage.BOT_INFO__ENGAGED:
				setEngaged((Boolean)newValue);
				return;
			case ModelPackage.BOT_INFO__GENDER:
				setGender((String)newValue);
				return;
			case ModelPackage.BOT_INFO__LOCATION:
				setLocation((String)newValue);
				return;
			case ModelPackage.BOT_INFO__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.BOT_INFO__ROOM_ID:
				setRoomId((String)newValue);
				return;
			case ModelPackage.BOT_INFO__SOURCE_ID:
				setSourceId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.BOT_INFO__NEW_ELEMENT:
				setNewElement(NEW_ELEMENT_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__BOT_ID:
				unsetBotId();
				return;
			case ModelPackage.BOT_INFO__DOB:
				setDob(DOB_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__ENGAGED:
				unsetEngaged();
				return;
			case ModelPackage.BOT_INFO__GENDER:
				setGender(GENDER_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__ROOM_ID:
				setRoomId(ROOM_ID_EDEFAULT);
				return;
			case ModelPackage.BOT_INFO__SOURCE_ID:
				setSourceId(SOURCE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.BOT_INFO__NEW_ELEMENT:
				return NEW_ELEMENT_EDEFAULT == null ? newElement != null : !NEW_ELEMENT_EDEFAULT.equals(newElement);
			case ModelPackage.BOT_INFO__BOT_ID:
				return isSetBotId();
			case ModelPackage.BOT_INFO__DOB:
				return DOB_EDEFAULT == null ? dob != null : !DOB_EDEFAULT.equals(dob);
			case ModelPackage.BOT_INFO__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case ModelPackage.BOT_INFO__ENGAGED:
				return isSetEngaged();
			case ModelPackage.BOT_INFO__GENDER:
				return GENDER_EDEFAULT == null ? gender != null : !GENDER_EDEFAULT.equals(gender);
			case ModelPackage.BOT_INFO__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case ModelPackage.BOT_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.BOT_INFO__ROOM_ID:
				return ROOM_ID_EDEFAULT == null ? roomId != null : !ROOM_ID_EDEFAULT.equals(roomId);
			case ModelPackage.BOT_INFO__SOURCE_ID:
				return SOURCE_ID_EDEFAULT == null ? sourceId != null : !SOURCE_ID_EDEFAULT.equals(sourceId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() 
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (newElement: ");
		result.append(newElement);
		result.append(", botId: ");
		if (botIdESet) result.append(botId); else result.append("<unset>");
		result.append(", dob: ");
		result.append(dob);
		result.append(", email: ");
		result.append(email);
		result.append(", engaged: ");
		if (engagedESet) result.append(engaged); else result.append("<unset>");
		result.append(", gender: ");
		result.append(gender);
		result.append(", location: ");
		result.append(location);
		result.append(", name: ");
		result.append(name);
		result.append(", roomId: ");
		result.append(roomId);
		result.append(", sourceId: ");
		result.append(sourceId);
		result.append(')');
		return result.toString();
	}

} //BotImpl
