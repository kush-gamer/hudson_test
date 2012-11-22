/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Prize;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prize</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.PrizeImpl#getCurrency <em>Currency</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.PrizeImpl#getGoodie <em>Goodie</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.PrizeImpl#getPrizeName <em>Prize Name</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.PrizeImpl#getXP <em>XP</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrizeImpl extends EObjectImpl implements Prize {
	/**
	 * The default value of the '{@link #getCurrency() <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrency()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrency() <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrency()
	 * @generated
	 * @ordered
	 */
	protected String currency = CURRENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoodie() <em>Goodie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoodie()
	 * @generated
	 * @ordered
	 */
	protected static final String GOODIE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoodie() <em>Goodie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoodie()
	 * @generated
	 * @ordered
	 */
	protected String goodie = GOODIE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrizeName() <em>Prize Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrizeName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIZE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrizeName() <em>Prize Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrizeName()
	 * @generated
	 * @ordered
	 */
	protected String prizeName = PRIZE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getXP() <em>XP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXP()
	 * @generated
	 * @ordered
	 */
	protected static final String XP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXP() <em>XP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXP()
	 * @generated
	 * @ordered
	 */
	protected String xP = XP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrizeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PRIZE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrency(String newCurrency) {
		String oldCurrency = currency;
		currency = newCurrency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIZE__CURRENCY, oldCurrency, currency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoodie() {
		return goodie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoodie(String newGoodie) {
		String oldGoodie = goodie;
		goodie = newGoodie;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIZE__GOODIE, oldGoodie, goodie));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrizeName() {
		return prizeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrizeName(String newPrizeName) {
		String oldPrizeName = prizeName;
		prizeName = newPrizeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIZE__PRIZE_NAME, oldPrizeName, prizeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXP() {
		return xP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXP(String newXP) {
		String oldXP = xP;
		xP = newXP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIZE__XP, oldXP, xP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PRIZE__CURRENCY:
				return getCurrency();
			case ModelPackage.PRIZE__GOODIE:
				return getGoodie();
			case ModelPackage.PRIZE__PRIZE_NAME:
				return getPrizeName();
			case ModelPackage.PRIZE__XP:
				return getXP();
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
			case ModelPackage.PRIZE__CURRENCY:
				setCurrency((String)newValue);
				return;
			case ModelPackage.PRIZE__GOODIE:
				setGoodie((String)newValue);
				return;
			case ModelPackage.PRIZE__PRIZE_NAME:
				setPrizeName((String)newValue);
				return;
			case ModelPackage.PRIZE__XP:
				setXP((String)newValue);
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
			case ModelPackage.PRIZE__CURRENCY:
				setCurrency(CURRENCY_EDEFAULT);
				return;
			case ModelPackage.PRIZE__GOODIE:
				setGoodie(GOODIE_EDEFAULT);
				return;
			case ModelPackage.PRIZE__PRIZE_NAME:
				setPrizeName(PRIZE_NAME_EDEFAULT);
				return;
			case ModelPackage.PRIZE__XP:
				setXP(XP_EDEFAULT);
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
			case ModelPackage.PRIZE__CURRENCY:
				return CURRENCY_EDEFAULT == null ? currency != null : !CURRENCY_EDEFAULT.equals(currency);
			case ModelPackage.PRIZE__GOODIE:
				return GOODIE_EDEFAULT == null ? goodie != null : !GOODIE_EDEFAULT.equals(goodie);
			case ModelPackage.PRIZE__PRIZE_NAME:
				return PRIZE_NAME_EDEFAULT == null ? prizeName != null : !PRIZE_NAME_EDEFAULT.equals(prizeName);
			case ModelPackage.PRIZE__XP:
				return XP_EDEFAULT == null ? xP != null : !XP_EDEFAULT.equals(xP);
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
		result.append(" (currency: ");
		result.append(currency);
		result.append(", goodie: ");
		result.append(goodie);
		result.append(", prizeName: ");
		result.append(prizeName);
		result.append(", xP: ");
		result.append(xP);
		result.append(')');
		return result.toString();
	}

} //PrizeImpl
