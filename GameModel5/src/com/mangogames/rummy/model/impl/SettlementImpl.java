/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Settlement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Settlement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.SettlementImpl#getChips <em>Chips</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.SettlementImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.SettlementImpl#getTotalScore <em>Total Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.SettlementImpl#getXp <em>Xp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SettlementImpl extends EObjectImpl implements Settlement {
	/**
	 * The default value of the '{@link #getChips() <em>Chips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChips()
	 * @generated
	 * @ordered
	 */
	protected static final int CHIPS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getChips() <em>Chips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChips()
	 * @generated
	 * @ordered
	 */
	protected int chips = CHIPS_EDEFAULT;

	/**
	 * This is true if the Chips attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean chipsESet;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected int level = LEVEL_EDEFAULT;

	/**
	 * This is true if the Level attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean levelESet;

	/**
	 * The default value of the '{@link #getTotalScore() <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalScore()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_SCORE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalScore() <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalScore()
	 * @generated
	 * @ordered
	 */
	protected int totalScore = TOTAL_SCORE_EDEFAULT;

	/**
	 * This is true if the Total Score attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean totalScoreESet;

	/**
	 * The default value of the '{@link #getXp() <em>Xp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXp()
	 * @generated
	 * @ordered
	 */
	protected static final int XP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getXp() <em>Xp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXp()
	 * @generated
	 * @ordered
	 */
	protected int xp = XP_EDEFAULT;

	/**
	 * This is true if the Xp attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean xpESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SettlementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SETTLEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChips() {
		return chips;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChips(int newChips) {
		int oldChips = chips;
		chips = newChips;
		boolean oldChipsESet = chipsESet;
		chipsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SETTLEMENT__CHIPS, oldChips, chips, !oldChipsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetChips() {
		int oldChips = chips;
		boolean oldChipsESet = chipsESet;
		chips = CHIPS_EDEFAULT;
		chipsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SETTLEMENT__CHIPS, oldChips, CHIPS_EDEFAULT, oldChipsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetChips() {
		return chipsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		boolean oldLevelESet = levelESet;
		levelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SETTLEMENT__LEVEL, oldLevel, level, !oldLevelESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLevel() {
		int oldLevel = level;
		boolean oldLevelESet = levelESet;
		level = LEVEL_EDEFAULT;
		levelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SETTLEMENT__LEVEL, oldLevel, LEVEL_EDEFAULT, oldLevelESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLevel() {
		return levelESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalScore(int newTotalScore) {
		int oldTotalScore = totalScore;
		totalScore = newTotalScore;
		boolean oldTotalScoreESet = totalScoreESet;
		totalScoreESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SETTLEMENT__TOTAL_SCORE, oldTotalScore, totalScore, !oldTotalScoreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalScore() {
		int oldTotalScore = totalScore;
		boolean oldTotalScoreESet = totalScoreESet;
		totalScore = TOTAL_SCORE_EDEFAULT;
		totalScoreESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SETTLEMENT__TOTAL_SCORE, oldTotalScore, TOTAL_SCORE_EDEFAULT, oldTotalScoreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalScore() {
		return totalScoreESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXp(int newXp) {
		int oldXp = xp;
		xp = newXp;
		boolean oldXpESet = xpESet;
		xpESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SETTLEMENT__XP, oldXp, xp, !oldXpESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetXp() {
		int oldXp = xp;
		boolean oldXpESet = xpESet;
		xp = XP_EDEFAULT;
		xpESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SETTLEMENT__XP, oldXp, XP_EDEFAULT, oldXpESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetXp() {
		return xpESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.SETTLEMENT__CHIPS:
				return getChips();
			case ModelPackage.SETTLEMENT__LEVEL:
				return getLevel();
			case ModelPackage.SETTLEMENT__TOTAL_SCORE:
				return getTotalScore();
			case ModelPackage.SETTLEMENT__XP:
				return getXp();
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
			case ModelPackage.SETTLEMENT__CHIPS:
				setChips((Integer)newValue);
				return;
			case ModelPackage.SETTLEMENT__LEVEL:
				setLevel((Integer)newValue);
				return;
			case ModelPackage.SETTLEMENT__TOTAL_SCORE:
				setTotalScore((Integer)newValue);
				return;
			case ModelPackage.SETTLEMENT__XP:
				setXp((Integer)newValue);
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
			case ModelPackage.SETTLEMENT__CHIPS:
				unsetChips();
				return;
			case ModelPackage.SETTLEMENT__LEVEL:
				unsetLevel();
				return;
			case ModelPackage.SETTLEMENT__TOTAL_SCORE:
				unsetTotalScore();
				return;
			case ModelPackage.SETTLEMENT__XP:
				unsetXp();
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
			case ModelPackage.SETTLEMENT__CHIPS:
				return isSetChips();
			case ModelPackage.SETTLEMENT__LEVEL:
				return isSetLevel();
			case ModelPackage.SETTLEMENT__TOTAL_SCORE:
				return isSetTotalScore();
			case ModelPackage.SETTLEMENT__XP:
				return isSetXp();
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
		result.append(" (chips: ");
		if (chipsESet) result.append(chips); else result.append("<unset>");
		result.append(", level: ");
		if (levelESet) result.append(level); else result.append("<unset>");
		result.append(", totalScore: ");
		if (totalScoreESet) result.append(totalScore); else result.append("<unset>");
		result.append(", xp: ");
		if (xpESet) result.append(xp); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SettlementImpl
