/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Seat;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.SeatImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.SeatImpl#getSeatId <em>Seat Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeatImpl extends EObjectImpl implements Seat {
	/**
	 * The cached value of the '{@link #getPlayer() <em>Player</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayer()
	 * @generated
	 * @ordered
	 */
	protected EObject player;

	/**
	 * The default value of the '{@link #getSeatId() <em>Seat Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeatId()
	 * @generated
	 * @ordered
	 */
	protected static final int SEAT_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeatId() <em>Seat Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeatId()
	 * @generated
	 * @ordered
	 */
	protected int seatId = SEAT_ID_EDEFAULT;

	/**
	 * This is true if the Seat Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean seatIdESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SEAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getPlayer() {
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayer(EObject newPlayer) {
		EObject oldPlayer = player;
		player = newPlayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SEAT__PLAYER, oldPlayer, player));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeatId() {
		return seatId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeatId(int newSeatId) {
		int oldSeatId = seatId;
		seatId = newSeatId;
		boolean oldSeatIdESet = seatIdESet;
		seatIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SEAT__SEAT_ID, oldSeatId, seatId, !oldSeatIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSeatId() {
		int oldSeatId = seatId;
		boolean oldSeatIdESet = seatIdESet;
		seatId = SEAT_ID_EDEFAULT;
		seatIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SEAT__SEAT_ID, oldSeatId, SEAT_ID_EDEFAULT, oldSeatIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSeatId() {
		return seatIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.SEAT__PLAYER:
				return getPlayer();
			case ModelPackage.SEAT__SEAT_ID:
				return getSeatId();
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
			case ModelPackage.SEAT__PLAYER:
				setPlayer((EObject)newValue);
				return;
			case ModelPackage.SEAT__SEAT_ID:
				setSeatId((Integer)newValue);
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
			case ModelPackage.SEAT__PLAYER:
				setPlayer((EObject)null);
				return;
			case ModelPackage.SEAT__SEAT_ID:
				unsetSeatId();
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
			case ModelPackage.SEAT__PLAYER:
				return player != null;
			case ModelPackage.SEAT__SEAT_ID:
				return isSetSeatId();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (seatId: ");
		if (seatIdESet) result.append(seatId); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SeatImpl
