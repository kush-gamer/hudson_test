/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.ModelPackage;

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
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchImpl#getMatchplayer <em>Matchplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchImpl#getDeal <em>Deal</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchImpl#getDealCount <em>Deal Count</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchImpl#getLastStartTurn <em>Last Start Turn</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.MatchImpl#getGame <em>Game</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchImpl extends EObjectImpl implements Match {
	/**
	 * The cached value of the '{@link #getMatchplayer() <em>Matchplayer</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchplayer()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> matchplayer;

	/**
	 * The cached value of the '{@link #getDeal() <em>Deal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeal()
	 * @generated
	 * @ordered
	 */
	protected Deal deal;

	/**
	 * The default value of the '{@link #getDealCount() <em>Deal Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DEAL_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDealCount() <em>Deal Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealCount()
	 * @generated
	 * @ordered
	 */
	protected int dealCount = DEAL_COUNT_EDEFAULT;

	/**
	 * This is true if the Deal Count attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dealCountESet;

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
	 * The default value of the '{@link #getLastStartTurn() <em>Last Start Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastStartTurn()
	 * @generated
	 * @ordered
	 */
	protected static final int LAST_START_TURN_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getLastStartTurn() <em>Last Start Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastStartTurn()
	 * @generated
	 * @ordered
	 */
	protected int lastStartTurn = LAST_START_TURN_EDEFAULT;

	/**
	 * This is true if the Last Start Turn attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean lastStartTurnESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getMatchplayer() {
		if (matchplayer == null) {
			matchplayer = new EObjectEList<EObject>(EObject.class, this, ModelPackage.MATCH__MATCHPLAYER);
		}
		return matchplayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deal getDeal() {
		return deal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeal(Deal newDeal, NotificationChain msgs) {
		Deal oldDeal = deal;
		deal = newDeal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH__DEAL, oldDeal, newDeal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeal(Deal newDeal) {
		if (newDeal != deal) {
			NotificationChain msgs = null;
			if (deal != null)
				msgs = ((InternalEObject)deal).eInverseRemove(this, ModelPackage.DEAL__MATCH, Deal.class, msgs);
			if (newDeal != null)
				msgs = ((InternalEObject)newDeal).eInverseAdd(this, ModelPackage.DEAL__MATCH, Deal.class, msgs);
			msgs = basicSetDeal(newDeal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH__DEAL, newDeal, newDeal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDealCount() {
		return dealCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDealCount(int newDealCount) {
		int oldDealCount = dealCount;
		dealCount = newDealCount;
		boolean oldDealCountESet = dealCountESet;
		dealCountESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH__DEAL_COUNT, oldDealCount, dealCount, !oldDealCountESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDealCount() {
		int oldDealCount = dealCount;
		boolean oldDealCountESet = dealCountESet;
		dealCount = DEAL_COUNT_EDEFAULT;
		dealCountESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.MATCH__DEAL_COUNT, oldDealCount, DEAL_COUNT_EDEFAULT, oldDealCountESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDealCount() {
		return dealCountESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH__ID, oldId, id, !oldIdESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.MATCH__ID, oldId, ID_EDEFAULT, oldIdESet));
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
	public int getLastStartTurn() {
		return lastStartTurn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastStartTurn(int newLastStartTurn) {
		int oldLastStartTurn = lastStartTurn;
		lastStartTurn = newLastStartTurn;
		boolean oldLastStartTurnESet = lastStartTurnESet;
		lastStartTurnESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH__LAST_START_TURN, oldLastStartTurn, lastStartTurn, !oldLastStartTurnESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastStartTurn() {
		int oldLastStartTurn = lastStartTurn;
		boolean oldLastStartTurnESet = lastStartTurnESet;
		lastStartTurn = LAST_START_TURN_EDEFAULT;
		lastStartTurnESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.MATCH__LAST_START_TURN, oldLastStartTurn, LAST_START_TURN_EDEFAULT, oldLastStartTurnESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastStartTurn() {
		return lastStartTurnESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Game getGame() {
		if (eContainerFeatureID() != ModelPackage.MATCH__GAME) return null;
		return (Game)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGame(Game newGame, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGame, ModelPackage.MATCH__GAME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGame(Game newGame) {
		if (newGame != eInternalContainer() || (eContainerFeatureID() != ModelPackage.MATCH__GAME && newGame != null)) {
			if (EcoreUtil.isAncestor(this, newGame))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGame != null)
				msgs = ((InternalEObject)newGame).eInverseAdd(this, ModelPackage.GAME__MATCH, Game.class, msgs);
			msgs = basicSetGame(newGame, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MATCH__GAME, newGame, newGame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MATCH__DEAL:
				if (deal != null)
					msgs = ((InternalEObject)deal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MATCH__DEAL, null, msgs);
				return basicSetDeal((Deal)otherEnd, msgs);
			case ModelPackage.MATCH__GAME:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGame((Game)otherEnd, msgs);
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
			case ModelPackage.MATCH__DEAL:
				return basicSetDeal(null, msgs);
			case ModelPackage.MATCH__GAME:
				return basicSetGame(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.MATCH__GAME:
				return eInternalContainer().eInverseRemove(this, ModelPackage.GAME__MATCH, Game.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.MATCH__MATCHPLAYER:
				return getMatchplayer();
			case ModelPackage.MATCH__DEAL:
				return getDeal();
			case ModelPackage.MATCH__DEAL_COUNT:
				return getDealCount();
			case ModelPackage.MATCH__ID:
				return getId();
			case ModelPackage.MATCH__LAST_START_TURN:
				return getLastStartTurn();
			case ModelPackage.MATCH__GAME:
				return getGame();
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
			case ModelPackage.MATCH__MATCHPLAYER:
				getMatchplayer().clear();
				getMatchplayer().addAll((Collection<? extends EObject>)newValue);
				return;
			case ModelPackage.MATCH__DEAL:
				setDeal((Deal)newValue);
				return;
			case ModelPackage.MATCH__DEAL_COUNT:
				setDealCount((Integer)newValue);
				return;
			case ModelPackage.MATCH__ID:
				setId((Long)newValue);
				return;
			case ModelPackage.MATCH__LAST_START_TURN:
				setLastStartTurn((Integer)newValue);
				return;
			case ModelPackage.MATCH__GAME:
				setGame((Game)newValue);
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
			case ModelPackage.MATCH__MATCHPLAYER:
				getMatchplayer().clear();
				return;
			case ModelPackage.MATCH__DEAL:
				setDeal((Deal)null);
				return;
			case ModelPackage.MATCH__DEAL_COUNT:
				unsetDealCount();
				return;
			case ModelPackage.MATCH__ID:
				unsetId();
				return;
			case ModelPackage.MATCH__LAST_START_TURN:
				unsetLastStartTurn();
				return;
			case ModelPackage.MATCH__GAME:
				setGame((Game)null);
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
			case ModelPackage.MATCH__MATCHPLAYER:
				return matchplayer != null && !matchplayer.isEmpty();
			case ModelPackage.MATCH__DEAL:
				return deal != null;
			case ModelPackage.MATCH__DEAL_COUNT:
				return isSetDealCount();
			case ModelPackage.MATCH__ID:
				return isSetId();
			case ModelPackage.MATCH__LAST_START_TURN:
				return isSetLastStartTurn();
			case ModelPackage.MATCH__GAME:
				return getGame() != null;
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
		result.append(" (dealCount: ");
		if (dealCountESet) result.append(dealCount); else result.append("<unset>");
		result.append(", id: ");
		if (idESet) result.append(id); else result.append("<unset>");
		result.append(", lastStartTurn: ");
		if (lastStartTurnESet) result.append(lastStartTurn); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

	public MatchPlayer getMatchPlayerById(long id)
	{
		for( EObject item: getMatchplayer() )
		{
			MatchPlayer playr = (MatchPlayer)item;
			if( playr.getId() == id )
			{
				return playr;
			}
		}
		
		return null;
		
	}
} //MatchImpl
