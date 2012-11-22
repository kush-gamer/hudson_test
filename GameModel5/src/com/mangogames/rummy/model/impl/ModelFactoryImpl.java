/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://"); 
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.BOT_INFO: return createBotInfo();
			case ModelPackage.BOT_PLAYER: return createBotPlayer();
			case ModelPackage.CARD: return createCard();
			case ModelPackage.CLOSED_DECK: return createClosedDeck();
			case ModelPackage.DEAL: return createDeal();
			case ModelPackage.DEAL_PLAYER: return createDealPlayer();
			case ModelPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case ModelPackage.FIXED_PRIZE_GAME: return createFixedPrizeGame();
			case ModelPackage.GROUP_CARDS: return createGroupCards();
			case ModelPackage.HAND_CARDS: return createHandCards();
			case ModelPackage.JOKER: return createJoker();
			case ModelPackage.MATCH: return createMatch();
			case ModelPackage.MATCH_PLAYER: return createMatchPlayer();
			case ModelPackage.OPEN_DECK: return createOpenDeck();
			case ModelPackage.PLAYER: return createPlayer();
			case ModelPackage.POINTS_GAME: return createPointsGame();
			case ModelPackage.POKER_RUMMY_GAME: return createPokerRummyGame();
			case ModelPackage.PRIZE: return createPrize();
			case ModelPackage.SCORE: return createScore();
			case ModelPackage.SEAT: return createSeat();
			case ModelPackage.SETTLEMENT: return createSettlement();
			case ModelPackage.SYNDICATE_GAME: return createSyndicateGame();
			case ModelPackage.TEST_GAME: return createTestGame();
			case ModelPackage.USER: return createUser();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BotInfo createBotInfo() {
		BotInfoImpl botInfo = new BotInfoImpl();
		return botInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BotPlayer createBotPlayer() {
		BotPlayerImpl botPlayer = new BotPlayerImpl();
		return botPlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Card createCard() {
		CardImpl card = new CardImpl();
		return card;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClosedDeck createClosedDeck() {
		ClosedDeckImpl closedDeck = new ClosedDeckImpl();
		return closedDeck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deal createDeal() {
		DealImpl deal = new DealImpl();
		return deal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DealPlayer createDealPlayer() {
		DealPlayerImpl dealPlayer = new DealPlayerImpl();
		return dealPlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPrizeGame createFixedPrizeGame() {
		FixedPrizeGameImpl fixedPrizeGame = new FixedPrizeGameImpl();
		return fixedPrizeGame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupCards createGroupCards() {
		GroupCardsImpl groupCards = new GroupCardsImpl();
		return groupCards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandCards createHandCards() {
		HandCardsImpl handCards = new HandCardsImpl();
		return handCards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Joker createJoker() {
		JokerImpl joker = new JokerImpl();
		return joker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match createMatch() {
		MatchImpl match = new MatchImpl();
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchPlayer createMatchPlayer() {
		MatchPlayerImpl matchPlayer = new MatchPlayerImpl();
		return matchPlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenDeck createOpenDeck() {
		OpenDeckImpl openDeck = new OpenDeckImpl();
		return openDeck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player createPlayer() {
		PlayerImpl player = new PlayerImpl();
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointsGame createPointsGame() {
		PointsGameImpl pointsGame = new PointsGameImpl();
		return pointsGame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PokerRummyGame createPokerRummyGame() {
		PokerRummyGameImpl pokerRummyGame = new PokerRummyGameImpl();
		return pokerRummyGame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prize createPrize() {
		PrizeImpl prize = new PrizeImpl();
		return prize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Score createScore() {
		ScoreImpl score = new ScoreImpl();
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seat createSeat() {
		SeatImpl seat = new SeatImpl();
		return seat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settlement createSettlement() {
		SettlementImpl settlement = new SettlementImpl();
		return settlement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyndicateGame createSyndicateGame() {
		SyndicateGameImpl syndicateGame = new SyndicateGameImpl();
		return syndicateGame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestGame createTestGame() {
		TestGameImpl testGame = new TestGameImpl();
		return testGame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
