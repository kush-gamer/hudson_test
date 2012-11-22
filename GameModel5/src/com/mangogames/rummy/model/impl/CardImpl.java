/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.CardImpl#getRank <em>Rank</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.CardImpl#getSuit <em>Suit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CardImpl extends EObjectImpl implements Card {
	/**
	 * The default value of the '{@link #getRank() <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRank()
	 * @generated
	 * @ordered
	 */
	protected static final int RANK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRank() <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRank()
	 * @generated
	 * @ordered
	 */
	protected int rank = RANK_EDEFAULT;

	/**
	 * This is true if the Rank attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean rankESet;

	/**
	 * The default value of the '{@link #getSuit() <em>Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuit()
	 * @generated
	 * @ordered
	 */
	protected static final int SUIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSuit() <em>Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuit()
	 * @generated
	 * @ordered
	 */
	protected int suit = SUIT_EDEFAULT;

	/**
	 * This is true if the Suit attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean suitESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRank(int newRank) {
		int oldRank = rank;
		rank = newRank;
		boolean oldRankESet = rankESet;
		rankESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CARD__RANK, oldRank, rank, !oldRankESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRank() {
		int oldRank = rank;
		boolean oldRankESet = rankESet;
		rank = RANK_EDEFAULT;
		rankESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.CARD__RANK, oldRank, RANK_EDEFAULT, oldRankESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRank() {
		return rankESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuit(int newSuit) {
		int oldSuit = suit;
		suit = newSuit;
		boolean oldSuitESet = suitESet;
		suitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CARD__SUIT, oldSuit, suit, !oldSuitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuit() {
		int oldSuit = suit;
		boolean oldSuitESet = suitESet;
		suit = SUIT_EDEFAULT;
		suitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.CARD__SUIT, oldSuit, SUIT_EDEFAULT, oldSuitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuit() {
		return suitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CARD__RANK:
				return getRank();
			case ModelPackage.CARD__SUIT:
				return getSuit();
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
			case ModelPackage.CARD__RANK:
				setRank((Integer)newValue);
				return;
			case ModelPackage.CARD__SUIT:
				setSuit((Integer)newValue);
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
			case ModelPackage.CARD__RANK:
				unsetRank();
				return;
			case ModelPackage.CARD__SUIT:
				unsetSuit();
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
			case ModelPackage.CARD__RANK:
				return isSetRank();
			case ModelPackage.CARD__SUIT:
				return isSetSuit();
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
		result.append(" (rank: ");
		if (rankESet) result.append(rank); else result.append("<unset>");
		result.append(", suit: ");
		if (suitESet) result.append(suit); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isEqual(Card compareCard) 
	{
		if (this == compareCard)
            return true;
        if (compareCard == null)
            return false;
        if (getClass() != compareCard.getClass())
            return false;
        if( this.getSuit() != compareCard.getSuit() )
        	return false;
        if( this.getRank() != compareCard.getRank() )
        	return false;
        	
		return true;
	}

} //CardImpl
