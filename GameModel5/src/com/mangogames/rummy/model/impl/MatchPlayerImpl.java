/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Score;

import com.mangogames.rummy.model.Settlement;
import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchPlayerImpl#getScore <em>Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchPlayerImpl#getSettlement <em>Settlement</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchPlayerImpl#getState <em>State</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchPlayerImpl#getTimeOfJoining <em>Time Of Joining</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchPlayerImpl#getTossRank <em>Toss Rank</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchPlayerImpl extends PlayerImpl implements MatchPlayer {
	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected EList<Score> score;

	/**
	 * The cached value of the '{@link #getSettlement() <em>Settlement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettlement()
	 * @generated
	 * @ordered
	 */
	protected Settlement settlement;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final int STATE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected int state = STATE_EDEFAULT;

	/**
	 * This is true if the State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stateESet;

	/**
	 * The default value of the '{@link #getTimeOfJoining() <em>Time Of Joining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOfJoining()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar TIME_OF_JOINING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeOfJoining() <em>Time Of Joining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOfJoining()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar timeOfJoining = TIME_OF_JOINING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTossRank() <em>Toss Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTossRank()
	 * @generated
	 * @ordered
	 */
	protected static final int TOSS_RANK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTossRank() <em>Toss Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTossRank()
	 * @generated
	 * @ordered
	 */
	protected int tossRank = TOSS_RANK_EDEFAULT;

	/**
	 * This is true if the Toss Rank attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean tossRankESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchPlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MATCH_PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Score> getScore() {
		if (score == null) {
			score = new EObjectContainmentEList<Score>(Score.class, this, ModelPackage.MATCH_PLAYER__SCORE);
		}
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settlement getSettlement() {
		return settlement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSettlement(Settlement newSettlement, NotificationChain msgs) {
		Settlement oldSettlement = settlement;
		settlement = newSettlement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH_PLAYER__SETTLEMENT, oldSettlement, newSettlement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettlement(Settlement newSettlement) {
		if (newSettlement != settlement) {
			NotificationChain msgs = null;
			if (settlement != null)
				msgs = ((InternalEObject)settlement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MATCH_PLAYER__SETTLEMENT, null, msgs);
			if (newSettlement != null)
				msgs = ((InternalEObject)newSettlement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MATCH_PLAYER__SETTLEMENT, null, msgs);
			msgs = basicSetSettlement(newSettlement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH_PLAYER__SETTLEMENT, newSettlement, newSettlement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(int newState) {
		int oldState = state;
		state = newState;
		boolean oldStateESet = stateESet;
		stateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH_PLAYER__STATE, oldState, state, !oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		int oldState = state;
		boolean oldStateESet = stateESet;
		state = STATE_EDEFAULT;
		stateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.MATCH_PLAYER__STATE, oldState, STATE_EDEFAULT, oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return stateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getTimeOfJoining() {
		return timeOfJoining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeOfJoining(XMLGregorianCalendar newTimeOfJoining) {
		XMLGregorianCalendar oldTimeOfJoining = timeOfJoining;
		timeOfJoining = newTimeOfJoining;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH_PLAYER__TIME_OF_JOINING, oldTimeOfJoining, timeOfJoining));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTossRank() {
		return tossRank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTossRank(int newTossRank) {
		int oldTossRank = tossRank;
		tossRank = newTossRank;
		boolean oldTossRankESet = tossRankESet;
		tossRankESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH_PLAYER__TOSS_RANK, oldTossRank, tossRank, !oldTossRankESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTossRank() {
		int oldTossRank = tossRank;
		boolean oldTossRankESet = tossRankESet;
		tossRank = TOSS_RANK_EDEFAULT;
		tossRankESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.MATCH_PLAYER__TOSS_RANK, oldTossRank, TOSS_RANK_EDEFAULT, oldTossRankESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTossRank() {
		return tossRankESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MATCH_PLAYER__SCORE:
				return ((InternalEList<?>)getScore()).basicRemove(otherEnd, msgs);
			case ModelPackage.MATCH_PLAYER__SETTLEMENT:
				return basicSetSettlement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.MATCH_PLAYER__SCORE:
				return getScore();
			case ModelPackage.MATCH_PLAYER__SETTLEMENT:
				return getSettlement();
			case ModelPackage.MATCH_PLAYER__STATE:
				return getState();
			case ModelPackage.MATCH_PLAYER__TIME_OF_JOINING:
				return getTimeOfJoining();
			case ModelPackage.MATCH_PLAYER__TOSS_RANK:
				return getTossRank();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.MATCH_PLAYER__SCORE:
				getScore().clear();
				getScore().addAll((Collection<? extends Score>)newValue);
				return;
			case ModelPackage.MATCH_PLAYER__SETTLEMENT:
				setSettlement((Settlement)newValue);
				return;
			case ModelPackage.MATCH_PLAYER__STATE:
				setState((Integer)newValue);
				return;
			case ModelPackage.MATCH_PLAYER__TIME_OF_JOINING:
				setTimeOfJoining((XMLGregorianCalendar)newValue);
				return;
			case ModelPackage.MATCH_PLAYER__TOSS_RANK:
				setTossRank((Integer)newValue);
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
			case ModelPackage.MATCH_PLAYER__SCORE:
				getScore().clear();
				return;
			case ModelPackage.MATCH_PLAYER__SETTLEMENT:
				setSettlement((Settlement)null);
				return;
			case ModelPackage.MATCH_PLAYER__STATE:
				unsetState();
				return;
			case ModelPackage.MATCH_PLAYER__TIME_OF_JOINING:
				setTimeOfJoining(TIME_OF_JOINING_EDEFAULT);
				return;
			case ModelPackage.MATCH_PLAYER__TOSS_RANK:
				unsetTossRank();
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
			case ModelPackage.MATCH_PLAYER__SCORE:
				return score != null && !score.isEmpty();
			case ModelPackage.MATCH_PLAYER__SETTLEMENT:
				return settlement != null;
			case ModelPackage.MATCH_PLAYER__STATE:
				return isSetState();
			case ModelPackage.MATCH_PLAYER__TIME_OF_JOINING:
				return TIME_OF_JOINING_EDEFAULT == null ? timeOfJoining != null : !TIME_OF_JOINING_EDEFAULT.equals(timeOfJoining);
			case ModelPackage.MATCH_PLAYER__TOSS_RANK:
				return isSetTossRank();
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
		result.append(" (state: ");
		if (stateESet) result.append(state); else result.append("<unset>");
		result.append(", timeOfJoining: ");
		result.append(timeOfJoining);
		result.append(", tossRank: ");
		if (tossRankESet) result.append(tossRank); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

	@Override
	public int getTotalScore() 
	{
		int totalScore = 0;
		
	    for(Score score: this.getScore())	
	    {
	       totalScore += score.getScore();
	    }
	    
		return totalScore;
	}
	
	public int getMatchAverageScore(int dealNumber)
	{
		return (getTotalScore() / dealNumber);
	}
	
} //MatchPlayerImpl
