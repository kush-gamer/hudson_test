/**
 */
package com.mangogames.rummy.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Score;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deal Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.DealPlayerImpl#getHandcards <em>Handcards</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealPlayerImpl#getScore <em>Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealPlayerImpl#getMissedTurnCount <em>Missed Turn Count</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealPlayerImpl#getState <em>State</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealPlayerImpl#getTimeOfJoining <em>Time Of Joining</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealPlayerImpl#isWinner <em>Winner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DealPlayerImpl extends PlayerImpl implements DealPlayer {
	/**
	 * The cached value of the '{@link #getHandcards() <em>Handcards</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandcards()
	 * @generated
	 * @ordered
	 */
	protected HandCards handcards;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected Score score;

	/**
	 * The default value of the '{@link #getMissedTurnCount() <em>Missed Turn Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissedTurnCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MISSED_TURN_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMissedTurnCount() <em>Missed Turn Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissedTurnCount()
	 * @generated
	 * @ordered
	 */
	protected int missedTurnCount = MISSED_TURN_COUNT_EDEFAULT;

	/**
	 * This is true if the Missed Turn Count attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean missedTurnCountESet;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * modified
	 * @ordered
	 */
	protected static final int STATE_EDEFAULT = DealPlayer.ACTIVE;

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
	protected static final String TIME_OF_JOINING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeOfJoining() <em>Time Of Joining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOfJoining()
	 * @generated
	 * @ordered
	 */
	protected String timeOfJoining = TIME_OF_JOINING_EDEFAULT;
	
	
	/**
	 * The default value of the '{@link #isWinner() <em>Winner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWinner()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WINNER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWinner() <em>Winner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWinner()
	 * @generated
	 * @ordered
	 */
	protected boolean winner = WINNER_EDEFAULT;

	/**
	 * This is true if the Winner attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean winnerESet;

	protected List<Integer> highlights = new ArrayList<Integer>();
	
	  /**
     * activityState is to track if the player has picked a card or not. Other similar
      * activities can be tracked  can
     */
     private int activityState = 0x0000;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DealPlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DEAL_PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandCards getHandcards() {
		return handcards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHandcards(HandCards newHandcards, NotificationChain msgs) {
		HandCards oldHandcards = handcards;
		handcards = newHandcards;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__HANDCARDS, oldHandcards, newHandcards);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandcards(HandCards newHandcards) {
		if (newHandcards != handcards) {
			NotificationChain msgs = null;
			if (handcards != null)
				msgs = ((InternalEObject)handcards).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DEAL_PLAYER__HANDCARDS, null, msgs);
			if (newHandcards != null)
				msgs = ((InternalEObject)newHandcards).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DEAL_PLAYER__HANDCARDS, null, msgs);
			msgs = basicSetHandcards(newHandcards, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__HANDCARDS, newHandcards, newHandcards));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScore(Score newScore, NotificationChain msgs) {
		Score oldScore = score;
		score = newScore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__SCORE, oldScore, newScore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(Score newScore) {
		if (newScore != score) {
			NotificationChain msgs = null;
			if (score != null)
				msgs = ((InternalEObject)score).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DEAL_PLAYER__SCORE, null, msgs);
			if (newScore != null)
				msgs = ((InternalEObject)newScore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DEAL_PLAYER__SCORE, null, msgs);
			msgs = basicSetScore(newScore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__SCORE, newScore, newScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMissedTurnCount() {
		return missedTurnCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMissedTurnCount(int newMissedTurnCount) {
		int oldMissedTurnCount = missedTurnCount;
		missedTurnCount = newMissedTurnCount;
		boolean oldMissedTurnCountESet = missedTurnCountESet;
		missedTurnCountESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__MISSED_TURN_COUNT, oldMissedTurnCount, missedTurnCount, !oldMissedTurnCountESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMissedTurnCount() {
		int oldMissedTurnCount = missedTurnCount;
		boolean oldMissedTurnCountESet = missedTurnCountESet;
		missedTurnCount = MISSED_TURN_COUNT_EDEFAULT;
		missedTurnCountESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DEAL_PLAYER__MISSED_TURN_COUNT, oldMissedTurnCount, MISSED_TURN_COUNT_EDEFAULT, oldMissedTurnCountESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMissedTurnCount() {
		return missedTurnCountESet;
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
	public void setState(int newState) 
	{
		int oldState = state;
		state = newState;
		boolean oldStateESet = stateESet;
		stateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__STATE, oldState, state, !oldStateESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DEAL_PLAYER__STATE, oldState, STATE_EDEFAULT, oldStateESet));
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
	public String getTimeOfJoining() {
		return timeOfJoining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeOfJoining(String newTimeOfJoining) {
		String oldTimeOfJoining = timeOfJoining;
		timeOfJoining = newTimeOfJoining;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__TIME_OF_JOINING, oldTimeOfJoining, timeOfJoining));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWinner() {
		return winner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWinner(boolean newWinner) {
		boolean oldWinner = winner;
		winner = newWinner;
		boolean oldWinnerESet = winnerESet;
		winnerESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL_PLAYER__WINNER, oldWinner, winner, !oldWinnerESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWinner() {
		boolean oldWinner = winner;
		boolean oldWinnerESet = winnerESet;
		winner = WINNER_EDEFAULT;
		winnerESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DEAL_PLAYER__WINNER, oldWinner, WINNER_EDEFAULT, oldWinnerESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWinner() {
		return winnerESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DEAL_PLAYER__HANDCARDS:
				return basicSetHandcards(null, msgs);
			case ModelPackage.DEAL_PLAYER__SCORE:
				return basicSetScore(null, msgs);
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
			case ModelPackage.DEAL_PLAYER__HANDCARDS:
				return getHandcards();
			case ModelPackage.DEAL_PLAYER__SCORE:
				return getScore();
			case ModelPackage.DEAL_PLAYER__MISSED_TURN_COUNT:
				return getMissedTurnCount();
			case ModelPackage.DEAL_PLAYER__STATE:
				return getState();
			case ModelPackage.DEAL_PLAYER__TIME_OF_JOINING:
				return getTimeOfJoining();
			case ModelPackage.DEAL_PLAYER__WINNER:
				return isWinner();
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
			case ModelPackage.DEAL_PLAYER__HANDCARDS:
				setHandcards((HandCards)newValue);
				return;
			case ModelPackage.DEAL_PLAYER__SCORE:
				setScore((Score)newValue);
				return;
			case ModelPackage.DEAL_PLAYER__MISSED_TURN_COUNT:
				setMissedTurnCount((Integer)newValue);
				return;
			case ModelPackage.DEAL_PLAYER__STATE:
				setState((Integer)newValue);
				return;
			case ModelPackage.DEAL_PLAYER__TIME_OF_JOINING:
				setTimeOfJoining((String)newValue);
				return;
			case ModelPackage.DEAL_PLAYER__WINNER:
				setWinner((Boolean)newValue);
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
			case ModelPackage.DEAL_PLAYER__HANDCARDS:
				setHandcards((HandCards)null);
				return;
			case ModelPackage.DEAL_PLAYER__SCORE:
				setScore((Score)null);
				return;
			case ModelPackage.DEAL_PLAYER__MISSED_TURN_COUNT:
				unsetMissedTurnCount();
				return;
			case ModelPackage.DEAL_PLAYER__STATE:
				unsetState();
				return;
			case ModelPackage.DEAL_PLAYER__TIME_OF_JOINING:
				setTimeOfJoining(TIME_OF_JOINING_EDEFAULT);
				return;
			case ModelPackage.DEAL_PLAYER__WINNER:
				unsetWinner();
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
			case ModelPackage.DEAL_PLAYER__HANDCARDS:
				return handcards != null;
			case ModelPackage.DEAL_PLAYER__SCORE:
				return score != null;
			case ModelPackage.DEAL_PLAYER__MISSED_TURN_COUNT:
				return isSetMissedTurnCount();
			case ModelPackage.DEAL_PLAYER__STATE:
				return isSetState();
			case ModelPackage.DEAL_PLAYER__TIME_OF_JOINING:
				return TIME_OF_JOINING_EDEFAULT == null ? timeOfJoining != null : !TIME_OF_JOINING_EDEFAULT.equals(timeOfJoining);
			case ModelPackage.DEAL_PLAYER__WINNER:
				return isSetWinner();
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
		result.append(" (missedTurnCount: ");
		if (missedTurnCountESet) result.append(missedTurnCount); else result.append("<unset>");
		result.append(", state: ");
		if (stateESet) result.append(state); else result.append("<unset>");
		result.append(", timeOfJoining: ");
		result.append(timeOfJoining);
		result.append(", winner: ");
		if (winnerESet) result.append(winner); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

	@Override
	public List<Integer> getHighLights() 
	{
		return highlights;
	}

	@Override
	public void updateState(int bitState) 
	{
		// Check if the bitState passed is an activity state. The first two bytes in the bitstate
        // are meant for activity tracking.
		if(state != bitState)
        {
        	if((bitState & DealPlayer.ACTIVITY_TRACK) > 0)
        	{
        		activityState = bitState & (~activityState);
        	}
        	else
        	{
        		state = bitState & (~state);
        	}
        	
        	//state is a combination of both
        	state = state | activityState;
        }
	}

	@Override
	public boolean isPlaying() 
	{
		return (DealPlayer.ACTIVE == (state & DealPlayer.ACTIVE));
	}

	@Override
	public boolean isDoneWithShow() 
	{
        return (DealPlayer.DONE_WITH_SHOW == (state & DealPlayer.DONE_WITH_SHOW));
	}

	@Override
	public boolean isDropped() 
	{
        return (DealPlayer.DROPPED == (state & DealPlayer.DROPPED));
	}

	@Override
	public boolean hasLostTheGame() 
	{
		return (DealPlayer.LOST_GAME == (state & DealPlayer.LOST_GAME));
	}

	@Override
	public boolean hasPickedACard() 
	{
		return (DealPlayer.PICKED == (state & DealPlayer.PICKED));
	}
	

	@Override
	public void addCard(Card card) 
	{
		/**
		 * Get the handcard, then the first group and add the card to the list of cards in the first group.
		 * Then send a notification that a card has been added. BotAdapter will pick that notification and act upon it.
		 */
       HandCards playerHand = this.getHandcards();
       GroupCards grp = (GroupCards) playerHand.getGroups().get(0);
	   grp.getCard().add(card);
	}
} //DealPlayerImpl
