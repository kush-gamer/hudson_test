/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;

import java.math.BigDecimal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getSeat <em>Seat</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getUser <em>User</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getPrize <em>Prize</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getEntryFee <em>Entry Fee</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getMaxPlayers <em>Max Players</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getMaxScore <em>Max Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getMaxSpectators <em>Max Spectators</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getMinPlayersRequired <em>Min Players Required</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getPotValue <em>Pot Value</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getRake <em>Rake</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.GameImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GameImpl extends EObjectImpl implements Game {
	/**
	 * The cached value of the '{@link #getSeat() <em>Seat</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeat()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> seat;

	/**
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected Match match;

	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> user;

	/**
	 * The cached value of the '{@link #getPrize() <em>Prize</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrize()
	 * @generated
	 * @ordered
	 */
	protected EObject prize;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamic = DYNAMIC_EDEFAULT;

	/**
	 * This is true if the Dynamic attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dynamicESet;

	/**
	 * The default value of the '{@link #getEntryFee() <em>Entry Fee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryFee()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal ENTRY_FEE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryFee() <em>Entry Fee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryFee()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal entryFee = ENTRY_FEE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	/**
	 * This is true if the Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idESet;

	/**
	 * The default value of the '{@link #getMaxPlayers() <em>Max Players</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxPlayers()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_PLAYERS_EDEFAULT = 5;

	/**
	 * The cached value of the '{@link #getMaxPlayers() <em>Max Players</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxPlayers()
	 * @generated
	 * @ordered
	 */
	protected int maxPlayers = MAX_PLAYERS_EDEFAULT;

	/**
	 * This is true if the Max Players attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxPlayersESet;

	/**
	 * The default value of the '{@link #getMaxScore() <em>Max Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxScore()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_SCORE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxScore() <em>Max Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxScore()
	 * @generated
	 * @ordered
	 */
	protected int maxScore = MAX_SCORE_EDEFAULT;

	/**
	 * This is true if the Max Score attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxScoreESet;

	/**
	 * The default value of the '{@link #getMaxSpectators() <em>Max Spectators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSpectators()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_SPECTATORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxSpectators() <em>Max Spectators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSpectators()
	 * @generated
	 * @ordered
	 */
	protected int maxSpectators = MAX_SPECTATORS_EDEFAULT;

	/**
	 * This is true if the Max Spectators attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxSpectatorsESet;

	/**
	 * The default value of the '{@link #getMinPlayersRequired() <em>Min Players Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinPlayersRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_PLAYERS_REQUIRED_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getMinPlayersRequired() <em>Min Players Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinPlayersRequired()
	 * @generated
	 * @ordered
	 */
	protected int minPlayersRequired = MIN_PLAYERS_REQUIRED_EDEFAULT;

	/**
	 * This is true if the Min Players Required attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minPlayersRequiredESet;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPotValue() <em>Pot Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotValue()
	 * @generated
	 * @ordered
	 */
	protected static final int POT_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPotValue() <em>Pot Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotValue()
	 * @generated
	 * @ordered
	 */
	protected int potValue = POT_VALUE_EDEFAULT;

	/**
	 * This is true if the Pot Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean potValueESet;

	/**
	 * The default value of the '{@link #getRake() <em>Rake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRake()
	 * @generated
	 * @ordered
	 */
	protected static final float RAKE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRake() <em>Rake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRake()
	 * @generated
	 * @ordered
	 */
	protected float rake = RAKE_EDEFAULT;

	/**
	 * This is true if the Rake attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean rakeESet;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected int type = TYPE_EDEFAULT;

	/**
	 * This is true if the Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.GAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSeat() {
		if (seat == null) {
			seat = new EObjectEList<EObject>(EObject.class, this, ModelPackage.GAME__SEAT);
		}
		return seat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatch(Match newMatch, NotificationChain msgs) {
		Match oldMatch = match;
		match = newMatch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__MATCH, oldMatch, newMatch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(Match newMatch) {
		if (newMatch != match) {
			NotificationChain msgs = null;
			if (match != null)
				msgs = ((InternalEObject)match).eInverseRemove(this, ModelPackage.MATCH__GAME, Match.class, msgs);
			if (newMatch != null)
				msgs = ((InternalEObject)newMatch).eInverseAdd(this, ModelPackage.MATCH__GAME, Match.class, msgs);
			msgs = basicSetMatch(newMatch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__MATCH, newMatch, newMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getUser() {
		if (user == null) {
			user = new EObjectEList<EObject>(EObject.class, this, ModelPackage.GAME__USER);
		}
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getPrize() {
		return prize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrize(EObject newPrize) {
		EObject oldPrize = prize;
		prize = newPrize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__PRIZE, oldPrize, prize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamic(boolean newDynamic) {
		boolean oldDynamic = dynamic;
		dynamic = newDynamic;
		boolean oldDynamicESet = dynamicESet;
		dynamicESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__DYNAMIC, oldDynamic, dynamic, !oldDynamicESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamic() {
		boolean oldDynamic = dynamic;
		boolean oldDynamicESet = dynamicESet;
		dynamic = DYNAMIC_EDEFAULT;
		dynamicESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__DYNAMIC, oldDynamic, DYNAMIC_EDEFAULT, oldDynamicESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamic() {
		return dynamicESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getEntryFee() {
		return entryFee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryFee(BigDecimal newEntryFee) {
		BigDecimal oldEntryFee = entryFee;
		entryFee = newEntryFee;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__ENTRY_FEE, oldEntryFee, entryFee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		boolean oldIdESet = idESet;
		idESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__ID, oldId, id, !oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId() {
		long oldId = id;
		boolean oldIdESet = idESet;
		id = ID_EDEFAULT;
		idESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__ID, oldId, ID_EDEFAULT, oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId() {
		return idESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxPlayers(int newMaxPlayers) {
		int oldMaxPlayers = maxPlayers;
		maxPlayers = newMaxPlayers;
		boolean oldMaxPlayersESet = maxPlayersESet;
		maxPlayersESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__MAX_PLAYERS, oldMaxPlayers, maxPlayers, !oldMaxPlayersESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxPlayers() {
		int oldMaxPlayers = maxPlayers;
		boolean oldMaxPlayersESet = maxPlayersESet;
		maxPlayers = MAX_PLAYERS_EDEFAULT;
		maxPlayersESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__MAX_PLAYERS, oldMaxPlayers, MAX_PLAYERS_EDEFAULT, oldMaxPlayersESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxPlayers() {
		return maxPlayersESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxScore() {
		return maxScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxScore(int newMaxScore) {
		int oldMaxScore = maxScore;
		maxScore = newMaxScore;
		boolean oldMaxScoreESet = maxScoreESet;
		maxScoreESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__MAX_SCORE, oldMaxScore, maxScore, !oldMaxScoreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxScore() {
		int oldMaxScore = maxScore;
		boolean oldMaxScoreESet = maxScoreESet;
		maxScore = MAX_SCORE_EDEFAULT;
		maxScoreESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__MAX_SCORE, oldMaxScore, MAX_SCORE_EDEFAULT, oldMaxScoreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxScore() {
		return maxScoreESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxSpectators() {
		return maxSpectators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSpectators(int newMaxSpectators) {
		int oldMaxSpectators = maxSpectators;
		maxSpectators = newMaxSpectators;
		boolean oldMaxSpectatorsESet = maxSpectatorsESet;
		maxSpectatorsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__MAX_SPECTATORS, oldMaxSpectators, maxSpectators, !oldMaxSpectatorsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxSpectators() {
		int oldMaxSpectators = maxSpectators;
		boolean oldMaxSpectatorsESet = maxSpectatorsESet;
		maxSpectators = MAX_SPECTATORS_EDEFAULT;
		maxSpectatorsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__MAX_SPECTATORS, oldMaxSpectators, MAX_SPECTATORS_EDEFAULT, oldMaxSpectatorsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxSpectators() {
		return maxSpectatorsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinPlayersRequired() {
		return minPlayersRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinPlayersRequired(int newMinPlayersRequired) {
		int oldMinPlayersRequired = minPlayersRequired;
		minPlayersRequired = newMinPlayersRequired;
		boolean oldMinPlayersRequiredESet = minPlayersRequiredESet;
		minPlayersRequiredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__MIN_PLAYERS_REQUIRED, oldMinPlayersRequired, minPlayersRequired, !oldMinPlayersRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinPlayersRequired() {
		int oldMinPlayersRequired = minPlayersRequired;
		boolean oldMinPlayersRequiredESet = minPlayersRequiredESet;
		minPlayersRequired = MIN_PLAYERS_REQUIRED_EDEFAULT;
		minPlayersRequiredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__MIN_PLAYERS_REQUIRED, oldMinPlayersRequired, MIN_PLAYERS_REQUIRED_EDEFAULT, oldMinPlayersRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinPlayersRequired() {
		return minPlayersRequiredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPotValue() {
		return potValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotValue(int newPotValue) {
		int oldPotValue = potValue;
		potValue = newPotValue;
		boolean oldPotValueESet = potValueESet;
		potValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__POT_VALUE, oldPotValue, potValue, !oldPotValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPotValue() {
		int oldPotValue = potValue;
		boolean oldPotValueESet = potValueESet;
		potValue = POT_VALUE_EDEFAULT;
		potValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__POT_VALUE, oldPotValue, POT_VALUE_EDEFAULT, oldPotValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPotValue() {
		return potValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRake() {
		return rake;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRake(float newRake) {
		float oldRake = rake;
		rake = newRake;
		boolean oldRakeESet = rakeESet;
		rakeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__RAKE, oldRake, rake, !oldRakeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRake() {
		float oldRake = rake;
		boolean oldRakeESet = rakeESet;
		rake = RAKE_EDEFAULT;
		rakeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__RAKE, oldRake, RAKE_EDEFAULT, oldRakeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRake() {
		return rakeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(int newType) {
		int oldType = type;
		type = newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GAME__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		int oldType = type;
		boolean oldTypeESet = typeESet;
		type = TYPE_EDEFAULT;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.GAME__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.GAME__MATCH:
				if (match != null)
					msgs = ((InternalEObject)match).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.GAME__MATCH, null, msgs);
				return basicSetMatch((Match)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.GAME__MATCH:
				return basicSetMatch(null, msgs);
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
			case ModelPackage.GAME__SEAT:
				return getSeat();
			case ModelPackage.GAME__MATCH:
				return getMatch();
			case ModelPackage.GAME__USER:
				return getUser();
			case ModelPackage.GAME__PRIZE:
				return getPrize();
			case ModelPackage.GAME__DYNAMIC:
				return isDynamic();
			case ModelPackage.GAME__ENTRY_FEE:
				return getEntryFee();
			case ModelPackage.GAME__ID:
				return getId();
			case ModelPackage.GAME__MAX_PLAYERS:
				return getMaxPlayers();
			case ModelPackage.GAME__MAX_SCORE:
				return getMaxScore();
			case ModelPackage.GAME__MAX_SPECTATORS:
				return getMaxSpectators();
			case ModelPackage.GAME__MIN_PLAYERS_REQUIRED:
				return getMinPlayersRequired();
			case ModelPackage.GAME__OWNER:
				return getOwner();
			case ModelPackage.GAME__POT_VALUE:
				return getPotValue();
			case ModelPackage.GAME__RAKE:
				return getRake();
			case ModelPackage.GAME__TYPE:
				return getType();
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
			case ModelPackage.GAME__SEAT:
				getSeat().clear();
				getSeat().addAll((Collection<? extends EObject>)newValue);
				return;
			case ModelPackage.GAME__MATCH:
				setMatch((Match)newValue);
				return;
			case ModelPackage.GAME__USER:
				getUser().clear();
				getUser().addAll((Collection<? extends EObject>)newValue);
				return;
			case ModelPackage.GAME__PRIZE:
				setPrize((EObject)newValue);
				return;
			case ModelPackage.GAME__DYNAMIC:
				setDynamic((Boolean)newValue);
				return;
			case ModelPackage.GAME__ENTRY_FEE:
				setEntryFee((BigDecimal)newValue);
				return;
			case ModelPackage.GAME__ID:
				setId((Long)newValue);
				return;
			case ModelPackage.GAME__MAX_PLAYERS:
				setMaxPlayers((Integer)newValue);
				return;
			case ModelPackage.GAME__MAX_SCORE:
				setMaxScore((Integer)newValue);
				return;
			case ModelPackage.GAME__MAX_SPECTATORS:
				setMaxSpectators((Integer)newValue);
				return;
			case ModelPackage.GAME__MIN_PLAYERS_REQUIRED:
				setMinPlayersRequired((Integer)newValue);
				return;
			case ModelPackage.GAME__OWNER:
				setOwner((String)newValue);
				return;
			case ModelPackage.GAME__POT_VALUE:
				setPotValue((Integer)newValue);
				return;
			case ModelPackage.GAME__RAKE:
				setRake((Float)newValue);
				return;
			case ModelPackage.GAME__TYPE:
				setType((Integer)newValue);
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
			case ModelPackage.GAME__SEAT:
				getSeat().clear();
				return;
			case ModelPackage.GAME__MATCH:
				setMatch((Match)null);
				return;
			case ModelPackage.GAME__USER:
				getUser().clear();
				return;
			case ModelPackage.GAME__PRIZE:
				setPrize((EObject)null);
				return;
			case ModelPackage.GAME__DYNAMIC:
				unsetDynamic();
				return;
			case ModelPackage.GAME__ENTRY_FEE:
				setEntryFee(ENTRY_FEE_EDEFAULT);
				return;
			case ModelPackage.GAME__ID:
				unsetId();
				return;
			case ModelPackage.GAME__MAX_PLAYERS:
				unsetMaxPlayers();
				return;
			case ModelPackage.GAME__MAX_SCORE:
				unsetMaxScore();
				return;
			case ModelPackage.GAME__MAX_SPECTATORS:
				unsetMaxSpectators();
				return;
			case ModelPackage.GAME__MIN_PLAYERS_REQUIRED:
				unsetMinPlayersRequired();
				return;
			case ModelPackage.GAME__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case ModelPackage.GAME__POT_VALUE:
				unsetPotValue();
				return;
			case ModelPackage.GAME__RAKE:
				unsetRake();
				return;
			case ModelPackage.GAME__TYPE:
				unsetType();
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
			case ModelPackage.GAME__SEAT:
				return seat != null && !seat.isEmpty();
			case ModelPackage.GAME__MATCH:
				return match != null;
			case ModelPackage.GAME__USER:
				return user != null && !user.isEmpty();
			case ModelPackage.GAME__PRIZE:
				return prize != null;
			case ModelPackage.GAME__DYNAMIC:
				return isSetDynamic();
			case ModelPackage.GAME__ENTRY_FEE:
				return ENTRY_FEE_EDEFAULT == null ? entryFee != null : !ENTRY_FEE_EDEFAULT.equals(entryFee);
			case ModelPackage.GAME__ID:
				return isSetId();
			case ModelPackage.GAME__MAX_PLAYERS:
				return isSetMaxPlayers();
			case ModelPackage.GAME__MAX_SCORE:
				return isSetMaxScore();
			case ModelPackage.GAME__MAX_SPECTATORS:
				return isSetMaxSpectators();
			case ModelPackage.GAME__MIN_PLAYERS_REQUIRED:
				return isSetMinPlayersRequired();
			case ModelPackage.GAME__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case ModelPackage.GAME__POT_VALUE:
				return isSetPotValue();
			case ModelPackage.GAME__RAKE:
				return isSetRake();
			case ModelPackage.GAME__TYPE:
				return isSetType();
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
		result.append(" (dynamic: ");
		if (dynamicESet) result.append(dynamic); else result.append("<unset>");
		result.append(", entryFee: ");
		result.append(entryFee);
		result.append(", id: ");
		if (idESet) result.append(id); else result.append("<unset>");
		result.append(", maxPlayers: ");
		if (maxPlayersESet) result.append(maxPlayers); else result.append("<unset>");
		result.append(", maxScore: ");
		if (maxScoreESet) result.append(maxScore); else result.append("<unset>");
		result.append(", maxSpectators: ");
		if (maxSpectatorsESet) result.append(maxSpectators); else result.append("<unset>");
		result.append(", minPlayersRequired: ");
		if (minPlayersRequiredESet) result.append(minPlayersRequired); else result.append("<unset>");
		result.append(", owner: ");
		result.append(owner);
		result.append(", potValue: ");
		if (potValueESet) result.append(potValue); else result.append("<unset>");
		result.append(", rake: ");
		if (rakeESet) result.append(rake); else result.append("<unset>");
		result.append(", type: ");
		if (typeESet) result.append(type); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

	public int getNumSeatedPlayers()
	{
		int cnt = 0;
		
		for( EObject itm: this.getSeat())
		{
			Seat seat = (Seat)itm;
			
			if( seat.getPlayer() != null )
			{
				cnt++;
			}	
		}
		return cnt;
	}
	
	@Override
	public Seat getFirstOccupiedSeat()
	{
		for( EObject itm: this.getSeat() )
		{
			Seat seat = (Seat)itm;
			
			if( seat.getPlayer() != null )
				return seat;
		}
		
		return null;
	}
	
	public Seat getNextOccupiedSeat(int curSeatId)
	{
		int   nextSeat  = curSeatId;
        EList listSeats = getSeat();
		  /**
		  * Run a circular check starting with the next-seat and reaching it back in circular iteration.
		  */
		 for( int i=0; i < listSeats.size(); i++ )
		  {
			  nextSeat++;
			  if(nextSeat == listSeats.size() - 1)
			  {
				  nextSeat = 0;
			  }
			  
			  Seat seat = (Seat) listSeats.get(nextSeat);
			  
			  if( seat.getPlayer() != null )
			  {
				  return seat;
			  }
		  }
		  
		return null;
		
	}
} //GameImpl
