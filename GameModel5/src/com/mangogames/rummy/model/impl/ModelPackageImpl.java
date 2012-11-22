/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.BotInfo;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.ClosedDeck;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.DocumentRoot;
import com.mangogames.rummy.model.FixedPrizeGame;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.Joker;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.ModelFactory;
import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.My;
import com.mangogames.rummy.model.OpenDeck;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.PointsGame;
import com.mangogames.rummy.model.PokerRummyGame;
import com.mangogames.rummy.model.Prize;
import com.mangogames.rummy.model.Score;
import com.mangogames.rummy.model.Seat;
import com.mangogames.rummy.model.Settlement;
import com.mangogames.rummy.model.SyndicateGame;
import com.mangogames.rummy.model.TestGame;
import com.mangogames.rummy.model.User;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass botInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass botPlayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closedDeckEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dealEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dealPlayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedPrizeGameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupCardsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass handCardsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jokerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchPlayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openDeckEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointsGameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pokerRummyGameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settlementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syndicateGameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.mangogames.rummy.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBotInfo() {
		return botInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_NewElement() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_BotId() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_Dob() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_Email() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_Engaged() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_Gender() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_Location() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_Name() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_RoomId() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBotInfo_SourceId() {
		return (EAttribute)botInfoEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBotPlayer() {
		return botPlayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCard() {
		return cardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCard_Rank() {
		return (EAttribute)cardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCard_Suit() {
		return (EAttribute)cardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardContainer() {
		return cardContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardContainer_Card() {
		return (EReference)cardContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClosedDeck() {
		return closedDeckEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeal() {
		return dealEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeal_Dealplayer() {
		return (EReference)dealEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeal_Opendeck() {
		return (EReference)dealEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeal_Closeddeck() {
		return (EReference)dealEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeal_Joker() {
		return (EReference)dealEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeal_CurrentTurn() {
		return (EAttribute)dealEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeal_DealNumber() {
		return (EAttribute)dealEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeal_ShowInitiator() {
		return (EAttribute)dealEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeal_Match() {
		return (EReference)dealEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDealPlayer() {
		return dealPlayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDealPlayer_Handcards() {
		return (EReference)dealPlayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDealPlayer_Score() {
		return (EReference)dealPlayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDealPlayer_MissedTurnCount() {
		return (EAttribute)dealPlayerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDealPlayer_State() {
		return (EAttribute)dealPlayerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDealPlayer_TimeOfJoining() {
		return (EAttribute)dealPlayerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDealPlayer_Winner() {
		return (EAttribute)dealPlayerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Botinfo() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BotPlayer() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Card() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Closeddeck() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Deal() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Dealplayer() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Fixedprizegame() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Game() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Groups() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Handcards() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Joker() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Match() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Matchplayer() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Opendeck() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Player() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Pointsgame() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Pokerrummygame() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Prize() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Score() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Seat() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Settlement() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Syndicategame() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Testgame() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_User() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedPrizeGame() {
		return fixedPrizeGameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGame() {
		return gameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGame_Seat() {
		return (EReference)gameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGame_Match() {
		return (EReference)gameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGame_User() {
		return (EReference)gameEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGame_Prize() {
		return (EReference)gameEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_Dynamic() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_EntryFee() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_Id() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_MaxPlayers() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_MaxScore() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_MaxSpectators() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_MinPlayersRequired() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_Owner() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_PotValue() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_Rake() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGame_Type() {
		return (EAttribute)gameEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupCards() {
		return groupCardsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHandCards() {
		return handCardsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHandCards_Groups() {
		return (EReference)handCardsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoker() {
		return jokerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatch() {
		return matchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Matchplayer() {
		return (EReference)matchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Deal() {
		return (EReference)matchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_DealCount() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_Id() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_LastStartTurn() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Game() {
		return (EReference)matchEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchPlayer() {
		return matchPlayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchPlayer_Score() {
		return (EReference)matchPlayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchPlayer_Settlement() {
		return (EReference)matchPlayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchPlayer_State() {
		return (EAttribute)matchPlayerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchPlayer_TimeOfJoining() {
		return (EAttribute)matchPlayerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchPlayer_TossRank() {
		return (EAttribute)matchPlayerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMy() {
		return myEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenDeck() {
		return openDeckEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlayer() {
		return playerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Type() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPointsGame() {
		return pointsGameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPokerRummyGame() {
		return pokerRummyGameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrize() {
		return prizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrize_Currency() {
		return (EAttribute)prizeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrize_Goodie() {
		return (EAttribute)prizeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrize_PrizeName() {
		return (EAttribute)prizeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrize_XP() {
		return (EAttribute)prizeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScore() {
		return scoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScore_Dealnum() {
		return (EAttribute)scoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScore_Score() {
		return (EAttribute)scoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeat() {
		return seatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeat_Player() {
		return (EReference)seatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeat_SeatId() {
		return (EAttribute)seatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettlement() {
		return settlementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettlement_Chips() {
		return (EAttribute)settlementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettlement_Level() {
		return (EAttribute)settlementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettlement_TotalScore() {
		return (EAttribute)settlementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettlement_Xp() {
		return (EAttribute)settlementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyndicateGame() {
		return syndicateGameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestGame() {
		return testGameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Chips() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Id() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Level() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Name() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Source() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UidSrc() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Xp() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		botInfoEClass = createEClass(BOT_INFO);
		createEAttribute(botInfoEClass, BOT_INFO__NEW_ELEMENT);
		createEAttribute(botInfoEClass, BOT_INFO__BOT_ID);
		createEAttribute(botInfoEClass, BOT_INFO__DOB);
		createEAttribute(botInfoEClass, BOT_INFO__EMAIL);
		createEAttribute(botInfoEClass, BOT_INFO__ENGAGED);
		createEAttribute(botInfoEClass, BOT_INFO__GENDER);
		createEAttribute(botInfoEClass, BOT_INFO__LOCATION);
		createEAttribute(botInfoEClass, BOT_INFO__NAME);
		createEAttribute(botInfoEClass, BOT_INFO__ROOM_ID);
		createEAttribute(botInfoEClass, BOT_INFO__SOURCE_ID);

		botPlayerEClass = createEClass(BOT_PLAYER);

		cardEClass = createEClass(CARD);
		createEAttribute(cardEClass, CARD__RANK);
		createEAttribute(cardEClass, CARD__SUIT);

		cardContainerEClass = createEClass(CARD_CONTAINER);
		createEReference(cardContainerEClass, CARD_CONTAINER__CARD);

		closedDeckEClass = createEClass(CLOSED_DECK);

		dealEClass = createEClass(DEAL);
		createEReference(dealEClass, DEAL__DEALPLAYER);
		createEReference(dealEClass, DEAL__OPENDECK);
		createEReference(dealEClass, DEAL__CLOSEDDECK);
		createEReference(dealEClass, DEAL__JOKER);
		createEAttribute(dealEClass, DEAL__CURRENT_TURN);
		createEAttribute(dealEClass, DEAL__DEAL_NUMBER);
		createEAttribute(dealEClass, DEAL__SHOW_INITIATOR);
		createEReference(dealEClass, DEAL__MATCH);

		dealPlayerEClass = createEClass(DEAL_PLAYER);
		createEReference(dealPlayerEClass, DEAL_PLAYER__HANDCARDS);
		createEReference(dealPlayerEClass, DEAL_PLAYER__SCORE);
		createEAttribute(dealPlayerEClass, DEAL_PLAYER__MISSED_TURN_COUNT);
		createEAttribute(dealPlayerEClass, DEAL_PLAYER__STATE);
		createEAttribute(dealPlayerEClass, DEAL_PLAYER__TIME_OF_JOINING);
		createEAttribute(dealPlayerEClass, DEAL_PLAYER__WINNER);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BOTINFO);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BOT_PLAYER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CARD);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CLOSEDDECK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEAL);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEALPLAYER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FIXEDPRIZEGAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GROUPS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HANDCARDS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__JOKER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MATCH);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MATCHPLAYER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OPENDECK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PLAYER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__POINTSGAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__POKERRUMMYGAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PRIZE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SCORE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SEAT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SETTLEMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SYNDICATEGAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TESTGAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__USER);

		fixedPrizeGameEClass = createEClass(FIXED_PRIZE_GAME);

		gameEClass = createEClass(GAME);
		createEReference(gameEClass, GAME__SEAT);
		createEReference(gameEClass, GAME__MATCH);
		createEReference(gameEClass, GAME__USER);
		createEReference(gameEClass, GAME__PRIZE);
		createEAttribute(gameEClass, GAME__DYNAMIC);
		createEAttribute(gameEClass, GAME__ENTRY_FEE);
		createEAttribute(gameEClass, GAME__ID);
		createEAttribute(gameEClass, GAME__MAX_PLAYERS);
		createEAttribute(gameEClass, GAME__MAX_SCORE);
		createEAttribute(gameEClass, GAME__MAX_SPECTATORS);
		createEAttribute(gameEClass, GAME__MIN_PLAYERS_REQUIRED);
		createEAttribute(gameEClass, GAME__OWNER);
		createEAttribute(gameEClass, GAME__POT_VALUE);
		createEAttribute(gameEClass, GAME__RAKE);
		createEAttribute(gameEClass, GAME__TYPE);

		groupCardsEClass = createEClass(GROUP_CARDS);

		handCardsEClass = createEClass(HAND_CARDS);
		createEReference(handCardsEClass, HAND_CARDS__GROUPS);

		jokerEClass = createEClass(JOKER);

		matchEClass = createEClass(MATCH);
		createEReference(matchEClass, MATCH__MATCHPLAYER);
		createEReference(matchEClass, MATCH__DEAL);
		createEAttribute(matchEClass, MATCH__DEAL_COUNT);
		createEAttribute(matchEClass, MATCH__ID);
		createEAttribute(matchEClass, MATCH__LAST_START_TURN);
		createEReference(matchEClass, MATCH__GAME);

		matchPlayerEClass = createEClass(MATCH_PLAYER);
		createEReference(matchPlayerEClass, MATCH_PLAYER__SCORE);
		createEReference(matchPlayerEClass, MATCH_PLAYER__SETTLEMENT);
		createEAttribute(matchPlayerEClass, MATCH_PLAYER__STATE);
		createEAttribute(matchPlayerEClass, MATCH_PLAYER__TIME_OF_JOINING);
		createEAttribute(matchPlayerEClass, MATCH_PLAYER__TOSS_RANK);

		myEClass = createEClass(MY);

		openDeckEClass = createEClass(OPEN_DECK);

		playerEClass = createEClass(PLAYER);
		createEAttribute(playerEClass, PLAYER__TYPE);

		pointsGameEClass = createEClass(POINTS_GAME);

		pokerRummyGameEClass = createEClass(POKER_RUMMY_GAME);

		prizeEClass = createEClass(PRIZE);
		createEAttribute(prizeEClass, PRIZE__CURRENCY);
		createEAttribute(prizeEClass, PRIZE__GOODIE);
		createEAttribute(prizeEClass, PRIZE__PRIZE_NAME);
		createEAttribute(prizeEClass, PRIZE__XP);

		scoreEClass = createEClass(SCORE);
		createEAttribute(scoreEClass, SCORE__DEALNUM);
		createEAttribute(scoreEClass, SCORE__SCORE);

		seatEClass = createEClass(SEAT);
		createEReference(seatEClass, SEAT__PLAYER);
		createEAttribute(seatEClass, SEAT__SEAT_ID);

		settlementEClass = createEClass(SETTLEMENT);
		createEAttribute(settlementEClass, SETTLEMENT__CHIPS);
		createEAttribute(settlementEClass, SETTLEMENT__LEVEL);
		createEAttribute(settlementEClass, SETTLEMENT__TOTAL_SCORE);
		createEAttribute(settlementEClass, SETTLEMENT__XP);

		syndicateGameEClass = createEClass(SYNDICATE_GAME);

		testGameEClass = createEClass(TEST_GAME);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__CHIPS);
		createEAttribute(userEClass, USER__ID);
		createEAttribute(userEClass, USER__LEVEL);
		createEAttribute(userEClass, USER__NAME);
		createEAttribute(userEClass, USER__SOURCE);
		createEAttribute(userEClass, USER__UID_SRC);
		createEAttribute(userEClass, USER__XP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		botPlayerEClass.getESuperTypes().add(this.getPlayer());
		closedDeckEClass.getESuperTypes().add(this.getCardContainer());
		dealPlayerEClass.getESuperTypes().add(this.getPlayer());
		fixedPrizeGameEClass.getESuperTypes().add(this.getPointsGame());
		groupCardsEClass.getESuperTypes().add(this.getCardContainer());
		jokerEClass.getESuperTypes().add(this.getCard());
		matchPlayerEClass.getESuperTypes().add(this.getPlayer());
		openDeckEClass.getESuperTypes().add(this.getCardContainer());
		playerEClass.getESuperTypes().add(this.getUser());
		pointsGameEClass.getESuperTypes().add(this.getGame());
		pokerRummyGameEClass.getESuperTypes().add(this.getPointsGame());
		syndicateGameEClass.getESuperTypes().add(this.getGame());
		testGameEClass.getESuperTypes().add(this.getGame());

		// Initialize classes and features; add operations and parameters
		initEClass(botInfoEClass, BotInfo.class, "BotInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBotInfo_NewElement(), theXMLTypePackage.getString(), "newElement", null, 1, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_BotId(), theXMLTypePackage.getInt(), "botId", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_Dob(), theXMLTypePackage.getString(), "dob", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_Email(), theXMLTypePackage.getString(), "email", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_Engaged(), theXMLTypePackage.getBoolean(), "engaged", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_Gender(), theXMLTypePackage.getString(), "gender", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_Location(), theXMLTypePackage.getString(), "location", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_RoomId(), theXMLTypePackage.getString(), "roomId", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBotInfo_SourceId(), theXMLTypePackage.getString(), "sourceId", null, 0, 1, BotInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(botPlayerEClass, BotPlayer.class, "BotPlayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardEClass, Card.class, "Card", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCard_Rank(), theXMLTypePackage.getInt(), "rank", null, 0, 1, Card.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCard_Suit(), theXMLTypePackage.getInt(), "suit", null, 0, 1, Card.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cardContainerEClass, CardContainer.class, "CardContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCardContainer_Card(), ecorePackage.getEObject(), null, "card", null, 0, -1, CardContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closedDeckEClass, ClosedDeck.class, "ClosedDeck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dealEClass, Deal.class, "Deal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeal_Dealplayer(), ecorePackage.getEObject(), null, "dealplayer", null, 2, 5, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeal_Opendeck(), ecorePackage.getEObject(), null, "opendeck", null, 1, 1, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeal_Closeddeck(), ecorePackage.getEObject(), null, "closeddeck", null, 1, 1, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeal_Joker(), ecorePackage.getEObject(), null, "joker", null, 1, 1, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeal_CurrentTurn(), theXMLTypePackage.getInt(), "currentTurn", null, 0, 1, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeal_DealNumber(), theXMLTypePackage.getInt(), "dealNumber", null, 0, 1, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeal_ShowInitiator(), theXMLTypePackage.getLong(), "showInitiator", null, 0, 1, Deal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeal_Match(), this.getMatch(), this.getMatch_Deal(), "Match", null, 0, 1, Deal.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dealPlayerEClass, DealPlayer.class, "DealPlayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDealPlayer_Handcards(), this.getHandCards(), null, "handcards", null, 0, 1, DealPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDealPlayer_Score(), this.getScore(), null, "score", null, 0, 1, DealPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDealPlayer_MissedTurnCount(), theXMLTypePackage.getInt(), "missedTurnCount", null, 0, 1, DealPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDealPlayer_State(), theXMLTypePackage.getInt(), "state", "1", 0, 1, DealPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDealPlayer_TimeOfJoining(), theXMLTypePackage.getString(), "timeOfJoining", null, 0, 1, DealPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDealPlayer_Winner(), theXMLTypePackage.getBoolean(), "winner", "false", 0, 1, DealPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Botinfo(), this.getBotInfo(), null, "botinfo", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BotPlayer(), this.getBotPlayer(), null, "botPlayer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Card(), this.getCard(), null, "card", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Closeddeck(), this.getClosedDeck(), null, "closeddeck", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Deal(), this.getDeal(), null, "deal", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Dealplayer(), this.getDealPlayer(), null, "dealplayer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Fixedprizegame(), this.getFixedPrizeGame(), null, "fixedprizegame", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Game(), this.getGame(), null, "game", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Groups(), this.getGroupCards(), null, "groups", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Handcards(), this.getHandCards(), null, "handcards", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Joker(), this.getJoker(), null, "joker", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Match(), this.getMatch(), null, "match", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Matchplayer(), this.getMatchPlayer(), null, "matchplayer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Opendeck(), this.getOpenDeck(), null, "opendeck", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Player(), this.getPlayer(), null, "player", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Pointsgame(), this.getPointsGame(), null, "pointsgame", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Pokerrummygame(), this.getPokerRummyGame(), null, "pokerrummygame", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Prize(), this.getPrize(), null, "prize", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Score(), this.getScore(), null, "score", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Seat(), this.getSeat(), null, "seat", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Settlement(), this.getSettlement(), null, "settlement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Syndicategame(), this.getSyndicateGame(), null, "syndicategame", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Testgame(), this.getTestGame(), null, "testgame", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_User(), this.getUser(), null, "user", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(fixedPrizeGameEClass, FixedPrizeGame.class, "FixedPrizeGame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gameEClass, Game.class, "Game", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGame_Seat(), ecorePackage.getEObject(), null, "seat", null, 2, 5, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGame_Match(), this.getMatch(), this.getMatch_Game(), "match", null, 1, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGame_User(), ecorePackage.getEObject(), null, "user", null, 0, -1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGame_Prize(), ecorePackage.getEObject(), null, "prize", null, 1, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_Dynamic(), theXMLTypePackage.getBoolean(), "dynamic", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_EntryFee(), theXMLTypePackage.getDecimal(), "entryFee", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_Id(), theXMLTypePackage.getLong(), "id", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_MaxPlayers(), theXMLTypePackage.getInt(), "maxPlayers", "5", 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_MaxScore(), theXMLTypePackage.getInt(), "maxScore", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_MaxSpectators(), theXMLTypePackage.getInt(), "maxSpectators", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_MinPlayersRequired(), theXMLTypePackage.getInt(), "minPlayersRequired", "2", 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_Owner(), theXMLTypePackage.getString(), "owner", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_PotValue(), theXMLTypePackage.getInt(), "potValue", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_Rake(), theXMLTypePackage.getFloat(), "rake", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGame_Type(), theXMLTypePackage.getInt(), "type", null, 0, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupCardsEClass, GroupCards.class, "GroupCards", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(handCardsEClass, HandCards.class, "HandCards", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHandCards_Groups(), ecorePackage.getEObject(), null, "groups", null, 1, 7, HandCards.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jokerEClass, Joker.class, "Joker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matchEClass, Match.class, "Match", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatch_Matchplayer(), ecorePackage.getEObject(), null, "matchplayer", null, 2, 5, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Deal(), this.getDeal(), this.getDeal_Match(), "deal", null, 1, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatch_DealCount(), theXMLTypePackage.getInt(), "dealCount", "0", 0, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatch_Id(), theXMLTypePackage.getLong(), "id", null, 0, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatch_LastStartTurn(), theXMLTypePackage.getInt(), "lastStartTurn", "-1", 0, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Game(), this.getGame(), this.getGame_Match(), "Game", null, 0, 1, Match.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchPlayerEClass, MatchPlayer.class, "MatchPlayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatchPlayer_Score(), this.getScore(), null, "score", null, 1, 5, MatchPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchPlayer_Settlement(), this.getSettlement(), null, "settlement", null, 1, 1, MatchPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchPlayer_State(), theXMLTypePackage.getInt(), "state", "1", 0, 1, MatchPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchPlayer_TimeOfJoining(), theXMLTypePackage.getDateTime(), "timeOfJoining", null, 0, 1, MatchPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchPlayer_TossRank(), theXMLTypePackage.getInt(), "tossRank", null, 0, 1, MatchPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myEClass, My.class, "My", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openDeckEClass, OpenDeck.class, "OpenDeck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(playerEClass, Player.class, "Player", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlayer_Type(), theXMLTypePackage.getInt(), "type", "0", 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointsGameEClass, PointsGame.class, "PointsGame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pokerRummyGameEClass, PokerRummyGame.class, "PokerRummyGame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(prizeEClass, Prize.class, "Prize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrize_Currency(), theXMLTypePackage.getString(), "currency", null, 0, 1, Prize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrize_Goodie(), theXMLTypePackage.getString(), "goodie", null, 0, 1, Prize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrize_PrizeName(), theXMLTypePackage.getString(), "prizeName", null, 0, 1, Prize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrize_XP(), theXMLTypePackage.getString(), "xP", null, 0, 1, Prize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scoreEClass, Score.class, "Score", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScore_Dealnum(), theXMLTypePackage.getLong(), "dealnum", "1", 0, 1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScore_Score(), theXMLTypePackage.getInt(), "score", "-1", 0, 1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seatEClass, Seat.class, "Seat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeat_Player(), ecorePackage.getEObject(), null, "player", null, 0, 1, Seat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeat_SeatId(), theXMLTypePackage.getInt(), "seatId", null, 1, 1, Seat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settlementEClass, Settlement.class, "Settlement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSettlement_Chips(), theXMLTypePackage.getInt(), "chips", "0", 0, 1, Settlement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettlement_Level(), theXMLTypePackage.getInt(), "level", "0", 0, 1, Settlement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettlement_TotalScore(), theXMLTypePackage.getInt(), "totalScore", "0", 0, 1, Settlement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettlement_Xp(), theXMLTypePackage.getInt(), "xp", "0", 0, 1, Settlement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syndicateGameEClass, SyndicateGame.class, "SyndicateGame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(testGameEClass, TestGame.class, "TestGame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_Chips(), theXMLTypePackage.getInt(), "chips", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Id(), theXMLTypePackage.getLong(), "id", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Level(), theXMLTypePackage.getInt(), "level", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Source(), theXMLTypePackage.getInt(), "source", "1", 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_UidSrc(), theXMLTypePackage.getString(), "uidSrc", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Xp(), theXMLTypePackage.getInt(), "xp", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (botInfoEClass, 
		   source, 
		   new String[] {
			 "name", "BotInfo",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBotInfo_NewElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NewElement"
		   });		
		addAnnotation
		  (getBotInfo_BotId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "bot_id"
		   });		
		addAnnotation
		  (getBotInfo_Dob(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dob"
		   });		
		addAnnotation
		  (getBotInfo_Email(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "email"
		   });		
		addAnnotation
		  (getBotInfo_Engaged(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "engaged"
		   });		
		addAnnotation
		  (getBotInfo_Gender(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "gender"
		   });		
		addAnnotation
		  (getBotInfo_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (getBotInfo_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getBotInfo_RoomId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "room_id"
		   });		
		addAnnotation
		  (getBotInfo_SourceId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "source_id"
		   });		
		addAnnotation
		  (botPlayerEClass, 
		   source, 
		   new String[] {
			 "name", "BotPlayer",
			 "kind", "empty"
		   });		
		addAnnotation
		  (cardEClass, 
		   source, 
		   new String[] {
			 "name", "Card",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getCard_Rank(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rank"
		   });		
		addAnnotation
		  (getCard_Suit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "suit"
		   });		
		addAnnotation
		  (cardContainerEClass, 
		   source, 
		   new String[] {
			 "name", "CardContainer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCardContainer_Card(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "card",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (closedDeckEClass, 
		   source, 
		   new String[] {
			 "name", "ClosedDeck",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (dealEClass, 
		   source, 
		   new String[] {
			 "name", "Deal",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDeal_Dealplayer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dealplayer",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeal_Opendeck(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "opendeck",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeal_Closeddeck(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "closeddeck",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeal_Joker(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "joker",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeal_CurrentTurn(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "current_turn"
		   });		
		addAnnotation
		  (getDeal_DealNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "deal_number"
		   });		
		addAnnotation
		  (getDeal_ShowInitiator(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "show_initiator"
		   });		
		addAnnotation
		  (dealPlayerEClass, 
		   source, 
		   new String[] {
			 "name", "DealPlayer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDealPlayer_Handcards(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "handcards",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDealPlayer_Score(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "score",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDealPlayer_MissedTurnCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "missed_turn_count"
		   });		
		addAnnotation
		  (getDealPlayer_State(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "state"
		   });		
		addAnnotation
		  (getDealPlayer_TimeOfJoining(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "time_of_joining"
		   });		
		addAnnotation
		  (getDealPlayer_Winner(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "winner"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Botinfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "botinfo",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_BotPlayer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "botPlayer",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Card(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "card",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Closeddeck(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "closeddeck",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Deal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "deal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Dealplayer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dealplayer",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Fixedprizegame(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fixedprizegame",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Game(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "game",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Groups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "groups",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Handcards(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "handcards",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Joker(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "joker",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Match(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "match",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Matchplayer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "matchplayer",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Opendeck(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "opendeck",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Player(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "player",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Pointsgame(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pointsgame",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Pokerrummygame(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pokerrummygame",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Prize(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "prize",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Score(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "score",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Seat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "seat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Settlement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "settlement",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Syndicategame(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "syndicategame",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Testgame(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "testgame",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_User(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "user",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (fixedPrizeGameEClass, 
		   source, 
		   new String[] {
			 "name", "FixedPrizeGame",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (gameEClass, 
		   source, 
		   new String[] {
			 "name", "Game",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGame_Seat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "seat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getGame_Match(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "match",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getGame_User(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "user",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getGame_Prize(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "prize",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getGame_Dynamic(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dynamic"
		   });		
		addAnnotation
		  (getGame_EntryFee(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "entry_fee"
		   });		
		addAnnotation
		  (getGame_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getGame_MaxPlayers(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "max_players"
		   });		
		addAnnotation
		  (getGame_MaxScore(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "max_score"
		   });		
		addAnnotation
		  (getGame_MaxSpectators(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "max_spectators"
		   });		
		addAnnotation
		  (getGame_MinPlayersRequired(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "min_players_required"
		   });		
		addAnnotation
		  (getGame_Owner(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "owner"
		   });		
		addAnnotation
		  (getGame_PotValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pot_value"
		   });		
		addAnnotation
		  (getGame_Rake(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rake"
		   });		
		addAnnotation
		  (getGame_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (groupCardsEClass, 
		   source, 
		   new String[] {
			 "name", "GroupCards",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (handCardsEClass, 
		   source, 
		   new String[] {
			 "name", "HandCards",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHandCards_Groups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "groups",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (jokerEClass, 
		   source, 
		   new String[] {
			 "name", "Joker",
			 "kind", "empty"
		   });		
		addAnnotation
		  (matchEClass, 
		   source, 
		   new String[] {
			 "name", "Match",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMatch_Matchplayer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "matchplayer",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMatch_Deal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "deal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMatch_DealCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "deal_count"
		   });		
		addAnnotation
		  (getMatch_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getMatch_LastStartTurn(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "last_start_turn"
		   });		
		addAnnotation
		  (matchPlayerEClass, 
		   source, 
		   new String[] {
			 "name", "MatchPlayer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMatchPlayer_Score(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "score",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMatchPlayer_Settlement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "settlement",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMatchPlayer_State(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "state"
		   });		
		addAnnotation
		  (getMatchPlayer_TimeOfJoining(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "time_of_joining"
		   });		
		addAnnotation
		  (getMatchPlayer_TossRank(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "toss_rank"
		   });		
		addAnnotation
		  (myEClass, 
		   source, 
		   new String[] {
			 "name", "My",
			 "kind", "empty"
		   });		
		addAnnotation
		  (openDeckEClass, 
		   source, 
		   new String[] {
			 "name", "OpenDeck",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (playerEClass, 
		   source, 
		   new String[] {
			 "name", "Player",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getPlayer_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (pointsGameEClass, 
		   source, 
		   new String[] {
			 "name", "PointsGame",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pokerRummyGameEClass, 
		   source, 
		   new String[] {
			 "name", "PokerRummyGame",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (prizeEClass, 
		   source, 
		   new String[] {
			 "name", "Prize",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getPrize_Currency(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Currency"
		   });		
		addAnnotation
		  (getPrize_Goodie(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Goodie"
		   });		
		addAnnotation
		  (getPrize_PrizeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "PrizeName"
		   });		
		addAnnotation
		  (getPrize_XP(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "XP"
		   });		
		addAnnotation
		  (scoreEClass, 
		   source, 
		   new String[] {
			 "name", "Score",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getScore_Dealnum(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dealnum"
		   });		
		addAnnotation
		  (getScore_Score(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "score"
		   });		
		addAnnotation
		  (seatEClass, 
		   source, 
		   new String[] {
			 "name", "Seat",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSeat_Player(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "player",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSeat_SeatId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seat_id"
		   });		
		addAnnotation
		  (settlementEClass, 
		   source, 
		   new String[] {
			 "name", "Settlement",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getSettlement_Chips(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "chips"
		   });		
		addAnnotation
		  (getSettlement_Level(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "level"
		   });		
		addAnnotation
		  (getSettlement_TotalScore(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "totalScore"
		   });		
		addAnnotation
		  (getSettlement_Xp(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xp"
		   });		
		addAnnotation
		  (syndicateGameEClass, 
		   source, 
		   new String[] {
			 "name", "SyndicateGame",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (testGameEClass, 
		   source, 
		   new String[] {
			 "name", "TestGame",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (userEClass, 
		   source, 
		   new String[] {
			 "name", "User",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getUser_Chips(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "chips"
		   });		
		addAnnotation
		  (getUser_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getUser_Level(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "level"
		   });		
		addAnnotation
		  (getUser_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getUser_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "source"
		   });		
		addAnnotation
		  (getUser_UidSrc(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uid_src"
		   });		
		addAnnotation
		  (getUser_Xp(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xp"
		   });
	}

} //ModelPackageImpl
