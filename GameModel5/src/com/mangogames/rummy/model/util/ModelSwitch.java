/**
 */
package com.mangogames.rummy.model.util;

import com.mangogames.rummy.model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.mangogames.rummy.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.BOT_INFO: {
				BotInfo botInfo = (BotInfo)theEObject;
				T result = caseBotInfo(botInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.BOT_PLAYER: {
				BotPlayer botPlayer = (BotPlayer)theEObject;
				T result = caseBotPlayer(botPlayer);
				if (result == null) result = casePlayer(botPlayer);
				if (result == null) result = caseUser(botPlayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CARD: {
				Card card = (Card)theEObject;
				T result = caseCard(card);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CARD_CONTAINER: {
				CardContainer cardContainer = (CardContainer)theEObject;
				T result = caseCardContainer(cardContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CLOSED_DECK: {
				ClosedDeck closedDeck = (ClosedDeck)theEObject;
				T result = caseClosedDeck(closedDeck);
				if (result == null) result = caseCardContainer(closedDeck);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DEAL: {
				Deal deal = (Deal)theEObject;
				T result = caseDeal(deal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DEAL_PLAYER: {
				DealPlayer dealPlayer = (DealPlayer)theEObject;
				T result = caseDealPlayer(dealPlayer);
				if (result == null) result = casePlayer(dealPlayer);
				if (result == null) result = caseUser(dealPlayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.FIXED_PRIZE_GAME: {
				FixedPrizeGame fixedPrizeGame = (FixedPrizeGame)theEObject;
				T result = caseFixedPrizeGame(fixedPrizeGame);
				if (result == null) result = casePointsGame(fixedPrizeGame);
				if (result == null) result = caseGame(fixedPrizeGame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GAME: {
				Game game = (Game)theEObject;
				T result = caseGame(game);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GROUP_CARDS: {
				GroupCards groupCards = (GroupCards)theEObject;
				T result = caseGroupCards(groupCards);
				if (result == null) result = caseCardContainer(groupCards);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HAND_CARDS: {
				HandCards handCards = (HandCards)theEObject;
				T result = caseHandCards(handCards);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.JOKER: {
				Joker joker = (Joker)theEObject;
				T result = caseJoker(joker);
				if (result == null) result = caseCard(joker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MATCH: {
				Match match = (Match)theEObject;
				T result = caseMatch(match);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MATCH_PLAYER: {
				MatchPlayer matchPlayer = (MatchPlayer)theEObject;
				T result = caseMatchPlayer(matchPlayer);
				if (result == null) result = casePlayer(matchPlayer);
				if (result == null) result = caseUser(matchPlayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MY: {
				My my = (My)theEObject;
				T result = caseMy(my);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OPEN_DECK: {
				OpenDeck openDeck = (OpenDeck)theEObject;
				T result = caseOpenDeck(openDeck);
				if (result == null) result = caseCardContainer(openDeck);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PLAYER: {
				Player player = (Player)theEObject;
				T result = casePlayer(player);
				if (result == null) result = caseUser(player);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.POINTS_GAME: {
				PointsGame pointsGame = (PointsGame)theEObject;
				T result = casePointsGame(pointsGame);
				if (result == null) result = caseGame(pointsGame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.POKER_RUMMY_GAME: {
				PokerRummyGame pokerRummyGame = (PokerRummyGame)theEObject;
				T result = casePokerRummyGame(pokerRummyGame);
				if (result == null) result = casePointsGame(pokerRummyGame);
				if (result == null) result = caseGame(pokerRummyGame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRIZE: {
				Prize prize = (Prize)theEObject;
				T result = casePrize(prize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SCORE: {
				Score score = (Score)theEObject;
				T result = caseScore(score);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SEAT: {
				Seat seat = (Seat)theEObject;
				T result = caseSeat(seat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SETTLEMENT: {
				Settlement settlement = (Settlement)theEObject;
				T result = caseSettlement(settlement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SYNDICATE_GAME: {
				SyndicateGame syndicateGame = (SyndicateGame)theEObject;
				T result = caseSyndicateGame(syndicateGame);
				if (result == null) result = caseGame(syndicateGame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_GAME: {
				TestGame testGame = (TestGame)theEObject;
				T result = caseTestGame(testGame);
				if (result == null) result = caseGame(testGame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.USER: {
				User user = (User)theEObject;
				T result = caseUser(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bot Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bot Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBotInfo(BotInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bot Player</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bot Player</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBotPlayer(BotPlayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Card</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Card</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCard(Card object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Card Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Card Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardContainer(CardContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Closed Deck</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Closed Deck</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClosedDeck(ClosedDeck object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeal(Deal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deal Player</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deal Player</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDealPlayer(DealPlayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Prize Game</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Prize Game</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedPrizeGame(FixedPrizeGame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Game</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Game</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGame(Game object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group Cards</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group Cards</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupCards(GroupCards object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hand Cards</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hand Cards</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHandCards(HandCards object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoker(Joker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatch(Match object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Player</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Player</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchPlayer(MatchPlayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>My</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>My</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMy(My object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Deck</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Deck</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenDeck(OpenDeck object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Player</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlayer(Player object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Points Game</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Points Game</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointsGame(PointsGame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Poker Rummy Game</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Poker Rummy Game</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePokerRummyGame(PokerRummyGame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prize</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prize</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrize(Prize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Score</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Score</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScore(Score object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Seat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Seat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeat(Seat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Settlement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Settlement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSettlement(Settlement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Syndicate Game</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Syndicate Game</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSyndicateGame(SyndicateGame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Game</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Game</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestGame(TestGame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
