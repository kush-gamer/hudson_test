/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Match;
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
 * An implementation of the model object '<em><b>Deal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getDealplayer <em>Dealplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getOpendeck <em>Opendeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getCloseddeck <em>Closeddeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getJoker <em>Joker</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getCurrentTurn <em>Current Turn</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getDealNumber <em>Deal Number</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getShowInitiator <em>Show Initiator</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DealImpl#getMatch <em>Match</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DealImpl extends EObjectImpl implements Deal {
	/**
	 * The cached value of the '{@link #getDealplayer() <em>Dealplayer</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealplayer()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> dealplayer;

	/**
	 * The cached value of the '{@link #getOpendeck() <em>Opendeck</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpendeck()
	 * @generated
	 * @ordered
	 */
	protected EObject opendeck;

	/**
	 * The cached value of the '{@link #getCloseddeck() <em>Closeddeck</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloseddeck()
	 * @generated
	 * @ordered
	 */
	protected EObject closeddeck;

	/**
	 * The cached value of the '{@link #getJoker() <em>Joker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoker()
	 * @generated
	 * @ordered
	 */
	protected EObject joker;

	/**
	 * The default value of the '{@link #getCurrentTurn() <em>Current Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTurn()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_TURN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentTurn() <em>Current Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTurn()
	 * @generated
	 * @ordered
	 */
	protected int currentTurn = CURRENT_TURN_EDEFAULT;

	/**
	 * This is true if the Current Turn attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean currentTurnESet;

	/**
	 * The default value of the '{@link #getDealNumber() <em>Deal Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int DEAL_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDealNumber() <em>Deal Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDealNumber()
	 * @generated
	 * @ordered
	 */
	protected int dealNumber = DEAL_NUMBER_EDEFAULT;

	/**
	 * This is true if the Deal Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dealNumberESet;

	/**
	 * The default value of the '{@link #getShowInitiator() <em>Show Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowInitiator()
	 * @generated
	 * @ordered
	 */
	protected static final long SHOW_INITIATOR_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getShowInitiator() <em>Show Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowInitiator()
	 * @generated
	 * @ordered
	 */
	protected long showInitiator = SHOW_INITIATOR_EDEFAULT;

	/**
	 * This is true if the Show Initiator attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean showInitiatorESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DealImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DEAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getDealplayer() {
		if (dealplayer == null) {
			dealplayer = new EObjectEList<EObject>(EObject.class, this, ModelPackage.DEAL__DEALPLAYER);
		}
		return dealplayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOpendeck() {
		return opendeck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpendeck(EObject newOpendeck) {
		EObject oldOpendeck = opendeck;
		opendeck = newOpendeck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__OPENDECK, oldOpendeck, opendeck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getCloseddeck() {
		return closeddeck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloseddeck(EObject newCloseddeck) {
		EObject oldCloseddeck = closeddeck;
		closeddeck = newCloseddeck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__CLOSEDDECK, oldCloseddeck, closeddeck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getJoker() {
		return joker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoker(EObject newJoker) {
		EObject oldJoker = joker;
		joker = newJoker;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__JOKER, oldJoker, joker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTurn(int newCurrentTurn) {
		int oldCurrentTurn = currentTurn;
		currentTurn = newCurrentTurn;
		boolean oldCurrentTurnESet = currentTurnESet;
		currentTurnESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__CURRENT_TURN, oldCurrentTurn, currentTurn, !oldCurrentTurnESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurrentTurn() {
		int oldCurrentTurn = currentTurn;
		boolean oldCurrentTurnESet = currentTurnESet;
		currentTurn = CURRENT_TURN_EDEFAULT;
		currentTurnESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DEAL__CURRENT_TURN, oldCurrentTurn, CURRENT_TURN_EDEFAULT, oldCurrentTurnESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurrentTurn() {
		return currentTurnESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDealNumber() {
		return dealNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDealNumber(int newDealNumber) {
		int oldDealNumber = dealNumber;
		dealNumber = newDealNumber;
		boolean oldDealNumberESet = dealNumberESet;
		dealNumberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__DEAL_NUMBER, oldDealNumber, dealNumber, !oldDealNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDealNumber() {
		int oldDealNumber = dealNumber;
		boolean oldDealNumberESet = dealNumberESet;
		dealNumber = DEAL_NUMBER_EDEFAULT;
		dealNumberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DEAL__DEAL_NUMBER, oldDealNumber, DEAL_NUMBER_EDEFAULT, oldDealNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDealNumber() {
		return dealNumberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getShowInitiator() {
		return showInitiator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowInitiator(long newShowInitiator) {
		long oldShowInitiator = showInitiator;
		showInitiator = newShowInitiator;
		boolean oldShowInitiatorESet = showInitiatorESet;
		showInitiatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__SHOW_INITIATOR, oldShowInitiator, showInitiator, !oldShowInitiatorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShowInitiator() {
		long oldShowInitiator = showInitiator;
		boolean oldShowInitiatorESet = showInitiatorESet;
		showInitiator = SHOW_INITIATOR_EDEFAULT;
		showInitiatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DEAL__SHOW_INITIATOR, oldShowInitiator, SHOW_INITIATOR_EDEFAULT, oldShowInitiatorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShowInitiator() {
		return showInitiatorESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getMatch() {
		if (eContainerFeatureID() != ModelPackage.DEAL__MATCH) return null;
		return (Match)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatch(Match newMatch, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMatch, ModelPackage.DEAL__MATCH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(Match newMatch) {
		if (newMatch != eInternalContainer() || (eContainerFeatureID() != ModelPackage.DEAL__MATCH && newMatch != null)) {
			if (EcoreUtil.isAncestor(this, newMatch))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMatch != null)
				msgs = ((InternalEObject)newMatch).eInverseAdd(this, ModelPackage.MATCH__DEAL, Match.class, msgs);
			msgs = basicSetMatch(newMatch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DEAL__MATCH, newMatch, newMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DEAL__MATCH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
			case ModelPackage.DEAL__MATCH:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.DEAL__MATCH:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MATCH__DEAL, Match.class, msgs);
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
			case ModelPackage.DEAL__DEALPLAYER:
				return getDealplayer();
			case ModelPackage.DEAL__OPENDECK:
				return getOpendeck();
			case ModelPackage.DEAL__CLOSEDDECK:
				return getCloseddeck();
			case ModelPackage.DEAL__JOKER:
				return getJoker();
			case ModelPackage.DEAL__CURRENT_TURN:
				return getCurrentTurn();
			case ModelPackage.DEAL__DEAL_NUMBER:
				return getDealNumber();
			case ModelPackage.DEAL__SHOW_INITIATOR:
				return getShowInitiator();
			case ModelPackage.DEAL__MATCH:
				return getMatch();
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
			case ModelPackage.DEAL__DEALPLAYER:
				getDealplayer().clear();
				getDealplayer().addAll((Collection<? extends EObject>)newValue);
				return;
			case ModelPackage.DEAL__OPENDECK:
				setOpendeck((EObject)newValue);
				return;
			case ModelPackage.DEAL__CLOSEDDECK:
				setCloseddeck((EObject)newValue);
				return;
			case ModelPackage.DEAL__JOKER:
				setJoker((EObject)newValue);
				return;
			case ModelPackage.DEAL__CURRENT_TURN:
				setCurrentTurn((Integer)newValue);
				return;
			case ModelPackage.DEAL__DEAL_NUMBER:
				setDealNumber((Integer)newValue);
				return;
			case ModelPackage.DEAL__SHOW_INITIATOR:
				setShowInitiator((Long)newValue);
				return;
			case ModelPackage.DEAL__MATCH:
				setMatch((Match)newValue);
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
			case ModelPackage.DEAL__DEALPLAYER:
				getDealplayer().clear();
				return;
			case ModelPackage.DEAL__OPENDECK:
				setOpendeck((EObject)null);
				return;
			case ModelPackage.DEAL__CLOSEDDECK:
				setCloseddeck((EObject)null);
				return;
			case ModelPackage.DEAL__JOKER:
				setJoker((EObject)null);
				return;
			case ModelPackage.DEAL__CURRENT_TURN:
				unsetCurrentTurn();
				return;
			case ModelPackage.DEAL__DEAL_NUMBER:
				unsetDealNumber();
				return;
			case ModelPackage.DEAL__SHOW_INITIATOR:
				unsetShowInitiator();
				return;
			case ModelPackage.DEAL__MATCH:
				setMatch((Match)null);
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
			case ModelPackage.DEAL__DEALPLAYER:
				return dealplayer != null && !dealplayer.isEmpty();
			case ModelPackage.DEAL__OPENDECK:
				return opendeck != null;
			case ModelPackage.DEAL__CLOSEDDECK:
				return closeddeck != null;
			case ModelPackage.DEAL__JOKER:
				return joker != null;
			case ModelPackage.DEAL__CURRENT_TURN:
				return isSetCurrentTurn();
			case ModelPackage.DEAL__DEAL_NUMBER:
				return isSetDealNumber();
			case ModelPackage.DEAL__SHOW_INITIATOR:
				return isSetShowInitiator();
			case ModelPackage.DEAL__MATCH:
				return getMatch() != null;
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
		result.append(" (currentTurn: ");
		if (currentTurnESet) result.append(currentTurn); else result.append("<unset>");
		result.append(", dealNumber: ");
		if (dealNumberESet) result.append(dealNumber); else result.append("<unset>");
		result.append(", showInitiator: ");
		if (showInitiatorESet) result.append(showInitiator); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}
	
	public DealPlayer getPlayerById(long id)
	{
		for(EObject item: getDealplayer())
		{
			DealPlayer dealPlayer = (DealPlayer)item;
			if(dealPlayer.getId() == id)
			{
				return dealPlayer;
			}
		}
		return null;
	}

} //DealImpl
