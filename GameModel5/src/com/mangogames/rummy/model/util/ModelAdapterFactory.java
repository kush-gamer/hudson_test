/**
 */
package com.mangogames.rummy.model.util;

import com.mangogames.rummy.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.mangogames.rummy.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseBotInfo(BotInfo object) {
				return createBotInfoAdapter();
			}
			@Override
			public Adapter caseBotPlayer(BotPlayer object) {
				return createBotPlayerAdapter();
			}
			@Override
			public Adapter caseCard(Card object) {
				return createCardAdapter();
			}
			@Override
			public Adapter caseCardContainer(CardContainer object) {
				return createCardContainerAdapter();
			}
			@Override
			public Adapter caseClosedDeck(ClosedDeck object) {
				return createClosedDeckAdapter();
			}
			@Override
			public Adapter caseDeal(Deal object) {
				return createDealAdapter();
			}
			@Override
			public Adapter caseDealPlayer(DealPlayer object) {
				return createDealPlayerAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseFixedPrizeGame(FixedPrizeGame object) {
				return createFixedPrizeGameAdapter();
			}
			@Override
			public Adapter caseGame(Game object) {
				return createGameAdapter();
			}
			@Override
			public Adapter caseGroupCards(GroupCards object) {
				return createGroupCardsAdapter();
			}
			@Override
			public Adapter caseHandCards(HandCards object) {
				return createHandCardsAdapter();
			}
			@Override
			public Adapter caseJoker(Joker object) {
				return createJokerAdapter();
			}
			@Override
			public Adapter caseMatch(Match object) {
				return createMatchAdapter();
			}
			@Override
			public Adapter caseMatchPlayer(MatchPlayer object) {
				return createMatchPlayerAdapter();
			}
			@Override
			public Adapter caseMy(My object) {
				return createMyAdapter();
			}
			@Override
			public Adapter caseOpenDeck(OpenDeck object) {
				return createOpenDeckAdapter();
			}
			@Override
			public Adapter casePlayer(Player object) {
				return createPlayerAdapter();
			}
			@Override
			public Adapter casePointsGame(PointsGame object) {
				return createPointsGameAdapter();
			}
			@Override
			public Adapter casePokerRummyGame(PokerRummyGame object) {
				return createPokerRummyGameAdapter();
			}
			@Override
			public Adapter casePrize(Prize object) {
				return createPrizeAdapter();
			}
			@Override
			public Adapter caseScore(Score object) {
				return createScoreAdapter();
			}
			@Override
			public Adapter caseSeat(Seat object) {
				return createSeatAdapter();
			}
			@Override
			public Adapter caseSettlement(Settlement object) {
				return createSettlementAdapter();
			}
			@Override
			public Adapter caseSyndicateGame(SyndicateGame object) {
				return createSyndicateGameAdapter();
			}
			@Override
			public Adapter caseTestGame(TestGame object) {
				return createTestGameAdapter();
			}
			@Override
			public Adapter caseUser(User object) {
				return createUserAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.BotInfo <em>Bot Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.BotInfo
	 * @generated
	 */
	public Adapter createBotInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.BotPlayer <em>Bot Player</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.BotPlayer
	 * @generated
	 */
	public Adapter createBotPlayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Card <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Card
	 * @generated
	 */
	public Adapter createCardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.CardContainer <em>Card Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.CardContainer
	 * @generated
	 */
	public Adapter createCardContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.ClosedDeck <em>Closed Deck</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.ClosedDeck
	 * @generated
	 */
	public Adapter createClosedDeckAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Deal <em>Deal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Deal
	 * @generated
	 */
	public Adapter createDealAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.DealPlayer <em>Deal Player</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.DealPlayer
	 * @generated
	 */
	public Adapter createDealPlayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.FixedPrizeGame <em>Fixed Prize Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.FixedPrizeGame
	 * @generated
	 */
	public Adapter createFixedPrizeGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Game <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Game
	 * @generated
	 */
	public Adapter createGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.GroupCards <em>Group Cards</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.GroupCards
	 * @generated
	 */
	public Adapter createGroupCardsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.HandCards <em>Hand Cards</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.HandCards
	 * @generated
	 */
	public Adapter createHandCardsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Joker <em>Joker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Joker
	 * @generated
	 */
	public Adapter createJokerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Match
	 * @generated
	 */
	public Adapter createMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.MatchPlayer <em>Match Player</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.MatchPlayer
	 * @generated
	 */
	public Adapter createMatchPlayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.My <em>My</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.My
	 * @generated
	 */
	public Adapter createMyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.OpenDeck <em>Open Deck</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.OpenDeck
	 * @generated
	 */
	public Adapter createOpenDeckAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Player
	 * @generated
	 */
	public Adapter createPlayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.PointsGame <em>Points Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.PointsGame
	 * @generated
	 */
	public Adapter createPointsGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.PokerRummyGame <em>Poker Rummy Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.PokerRummyGame
	 * @generated
	 */
	public Adapter createPokerRummyGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Prize <em>Prize</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Prize
	 * @generated
	 */
	public Adapter createPrizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Score <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Score
	 * @generated
	 */
	public Adapter createScoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Seat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Seat
	 * @generated
	 */
	public Adapter createSeatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.Settlement <em>Settlement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.Settlement
	 * @generated
	 */
	public Adapter createSettlementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.SyndicateGame <em>Syndicate Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.SyndicateGame
	 * @generated
	 */
	public Adapter createSyndicateGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.TestGame <em>Test Game</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.TestGame
	 * @generated
	 */
	public Adapter createTestGameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mangogames.rummy.model.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mangogames.rummy.model.User
	 * @generated
	 */
	public Adapter createUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
