/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.ModelPackage;

import java.util.Collection;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Card Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.CardContainerImpl#getCard <em>Card</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CardContainerImpl extends EObjectImpl implements CardContainer {
	/**
	 * The cached value of the '{@link #getCard() <em>Card</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCard()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> card;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CARD_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getCard() {
		if (card == null) {
			card = new EObjectEList<EObject>(EObject.class, this, ModelPackage.CARD_CONTAINER__CARD);
		}
		return card;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CARD_CONTAINER__CARD:
				return getCard();
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
			case ModelPackage.CARD_CONTAINER__CARD:
				getCard().clear();
				getCard().addAll((Collection<? extends EObject>)newValue);
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
			case ModelPackage.CARD_CONTAINER__CARD:
				getCard().clear();
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
			case ModelPackage.CARD_CONTAINER__CARD:
				return card != null && !card.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	public void shuffle()
	{
		EList listCards = this.getCard();
		
		Random random = new Random();
		for (int i = listCards.size() - 1; i >= 0; i--) 
		{
		    int j = random.nextInt(i + 1);
		    
		    if( i != j )
			{
			    /* swap cards i,j */
			    Object cardi = listCards.get(i);
			    Object cardj = listCards.get(j);
			    listCards.remove(cardi);
			    listCards.remove(cardj);
			   
			   
			    listCards.add(i-1, cardj);
			    listCards.add(j, cardi);
			    
			    
			    //test
			    Object nCardi = listCards.get(i);
			    Object nCardj = listCards.get(j);
			    
			    assert(cardi == nCardj);
			    assert(cardj == nCardi);
			}	
		}
		
	
	}

} //CardContainerImpl
