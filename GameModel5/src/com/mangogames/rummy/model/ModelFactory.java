/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EFactory;

import com.mangogames.rummy.model.impl.BotModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.mangogames.rummy.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = com.mangogames.rummy.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bot Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bot Info</em>'.
	 * @generated
	 */
	BotInfo createBotInfo();

	/**
	 * Returns a new object of class '<em>Bot Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bot Player</em>'.
	 * @generated
	 */
	BotPlayer createBotPlayer();

	/**
	 * Returns a new object of class '<em>Card</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Card</em>'.
	 * @generated
	 */
	Card createCard();

	/**
	 * Returns a new object of class '<em>Closed Deck</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Closed Deck</em>'.
	 * @generated
	 */
	ClosedDeck createClosedDeck();

	/**
	 * Returns a new object of class '<em>Deal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deal</em>'.
	 * @generated
	 */
	Deal createDeal();

	/**
	 * Returns a new object of class '<em>Deal Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deal Player</em>'.
	 * @generated
	 */
	DealPlayer createDealPlayer();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Fixed Prize Game</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Prize Game</em>'.
	 * @generated
	 */
	FixedPrizeGame createFixedPrizeGame();

	/**
	 * Returns a new object of class '<em>Group Cards</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Cards</em>'.
	 * @generated
	 */
	GroupCards createGroupCards();

	/**
	 * Returns a new object of class '<em>Hand Cards</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hand Cards</em>'.
	 * @generated
	 */
	HandCards createHandCards();

	/**
	 * Returns a new object of class '<em>Joker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Joker</em>'.
	 * @generated
	 */
	Joker createJoker();

	/**
	 * Returns a new object of class '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match</em>'.
	 * @generated
	 */
	Match createMatch();

	/**
	 * Returns a new object of class '<em>Match Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Player</em>'.
	 * @generated
	 */
	MatchPlayer createMatchPlayer();

	/**
	 * Returns a new object of class '<em>Open Deck</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Deck</em>'.
	 * @generated
	 */
	OpenDeck createOpenDeck();

	/**
	 * Returns a new object of class '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Player</em>'.
	 * @generated
	 */
	Player createPlayer();

	/**
	 * Returns a new object of class '<em>Points Game</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Points Game</em>'.
	 * @generated
	 */
	PointsGame createPointsGame();

	/**
	 * Returns a new object of class '<em>Poker Rummy Game</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Poker Rummy Game</em>'.
	 * @generated
	 */
	PokerRummyGame createPokerRummyGame();

	/**
	 * Returns a new object of class '<em>Prize</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prize</em>'.
	 * @generated
	 */
	Prize createPrize();

	/**
	 * Returns a new object of class '<em>Score</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Score</em>'.
	 * @generated
	 */
	Score createScore();

	/**
	 * Returns a new object of class '<em>Seat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seat</em>'.
	 * @generated
	 */
	Seat createSeat();

	/**
	 * Returns a new object of class '<em>Settlement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Settlement</em>'.
	 * @generated
	 */
	Settlement createSettlement();

	/**
	 * Returns a new object of class '<em>Syndicate Game</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Syndicate Game</em>'.
	 * @generated
	 */
	SyndicateGame createSyndicateGame();

	/**
	 * Returns a new object of class '<em>Test Game</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Game</em>'.
	 * @generated
	 */
	TestGame createTestGame();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
