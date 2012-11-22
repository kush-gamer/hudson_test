/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Score;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Score</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.ScoreImpl#getDealnum <em>Dealnum</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.ScoreImpl#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScoreImpl extends EObjectImpl implements Score {
	/**
	 * The default value of the '{@link #getDealnum() <em>Dealnum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealnum()
	 * @generated
	 * @ordered
	 */
	protected static final long DEALNUM_EDEFAULT = 1L;

	/**
	 * The cached value of the '{@link #getDealnum() <em>Dealnum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealnum()
	 * @generated
	 * @ordered
	 */
	protected long dealnum = DEALNUM_EDEFAULT;

	/**
	 * This is true if the Dealnum attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dealnumESet;

	/**
	 * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected static final int SCORE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected int score = SCORE_EDEFAULT;

	/**
	 * This is true if the Score attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean scoreESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SCORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDealnum() {
		return dealnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDealnum(long newDealnum) {
		long oldDealnum = dealnum;
		dealnum = newDealnum;
		boolean oldDealnumESet = dealnumESet;
		dealnumESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SCORE__DEALNUM, oldDealnum, dealnum, !oldDealnumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDealnum() {
		long oldDealnum = dealnum;
		boolean oldDealnumESet = dealnumESet;
		dealnum = DEALNUM_EDEFAULT;
		dealnumESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SCORE__DEALNUM, oldDealnum, DEALNUM_EDEFAULT, oldDealnumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDealnum() {
		return dealnumESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScore() {
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(int newScore) {
		int oldScore = score;
		score = newScore;
		boolean oldScoreESet = scoreESet;
		scoreESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SCORE__SCORE, oldScore, score, !oldScoreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScore() {
		int oldScore = score;
		boolean oldScoreESet = scoreESet;
		score = SCORE_EDEFAULT;
		scoreESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.SCORE__SCORE, oldScore, SCORE_EDEFAULT, oldScoreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScore() {
		return scoreESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.SCORE__DEALNUM:
				return getDealnum();
			case ModelPackage.SCORE__SCORE:
				return getScore();
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
			case ModelPackage.SCORE__DEALNUM:
				setDealnum((Long)newValue);
				return;
			case ModelPackage.SCORE__SCORE:
				setScore((Integer)newValue);
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
			case ModelPackage.SCORE__DEALNUM:
				unsetDealnum();
				return;
			case ModelPackage.SCORE__SCORE:
				unsetScore();
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
			case ModelPackage.SCORE__DEALNUM:
				return isSetDealnum();
			case ModelPackage.SCORE__SCORE:
				return isSetScore();
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
		result.append(" (dealnum: ");
		if (dealnumESet) result.append(dealnum); else result.append("<unset>");
		result.append(", score: ");
		if (scoreESet) result.append(score); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ScoreImpl
