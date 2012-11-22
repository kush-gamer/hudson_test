/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.mangogames.rummy.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = com.mangogames.rummy.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.BotInfoImpl <em>Bot Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.BotInfoImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getBotInfo()
	 * @generated
	 */
	int BOT_INFO = 0;

	/**
	 * The feature id for the '<em><b>New Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__NEW_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Bot Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__BOT_ID = 1;

	/**
	 * The feature id for the '<em><b>Dob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__DOB = 2;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__EMAIL = 3;

	/**
	 * The feature id for the '<em><b>Engaged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__ENGAGED = 4;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__GENDER = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__LOCATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__NAME = 7;

	/**
	 * The feature id for the '<em><b>Room Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__ROOM_ID = 8;

	/**
	 * The feature id for the '<em><b>Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO__SOURCE_ID = 9;

	/**
	 * The number of structural features of the '<em>Bot Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INFO_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.BotPlayerImpl <em>Bot Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.BotPlayerImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getBotPlayer()
	 * @generated
	 */
	int BOT_PLAYER = 1;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.CardImpl <em>Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.CardImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getCard()
	 * @generated
	 */
	int CARD = 2;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.CardContainerImpl <em>Card Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.CardContainerImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getCardContainer()
	 * @generated
	 */
	int CARD_CONTAINER = 3;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.ClosedDeckImpl <em>Closed Deck</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.ClosedDeckImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getClosedDeck()
	 * @generated
	 */
	int CLOSED_DECK = 4;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.DealImpl <em>Deal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.DealImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getDeal()
	 * @generated
	 */
	int DEAL = 5;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.UserImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getUser()
	 * @generated
	 */
	int USER = 26;

	/**
	 * The feature id for the '<em><b>Chips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__CHIPS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ID = 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LEVEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Uid Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__UID_SRC = 5;

	/**
	 * The feature id for the '<em><b>Xp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__XP = 6;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.PlayerImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 17;

	/**
	 * The feature id for the '<em><b>Chips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__CHIPS = USER__CHIPS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__ID = USER__ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__LEVEL = USER__LEVEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__NAME = USER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__SOURCE = USER__SOURCE;

	/**
	 * The feature id for the '<em><b>Uid Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__UID_SRC = USER__UID_SRC;

	/**
	 * The feature id for the '<em><b>Xp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__XP = USER__XP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__TYPE = USER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = USER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.DealPlayerImpl <em>Deal Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.DealPlayerImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getDealPlayer()
	 * @generated
	 */
	int DEAL_PLAYER = 6;

	/**
	 * The feature id for the '<em><b>Chips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__CHIPS = PLAYER__CHIPS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__ID = PLAYER__ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__LEVEL = PLAYER__LEVEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__NAME = PLAYER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__SOURCE = PLAYER__SOURCE;

	/**
	 * The feature id for the '<em><b>Uid Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__UID_SRC = PLAYER__UID_SRC;

	/**
	 * The feature id for the '<em><b>Xp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__XP = PLAYER__XP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER__TYPE = PLAYER__TYPE;

	/**
	 * The number of structural features of the '<em>Bot Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_PLAYER_FEATURE_COUNT = PLAYER_FEATURE_COUNT + 0;
	
	/**
	 * We want to track a bot player getting a card added as response to pick action.
	 * This feature is given an id, one more than the total features in BOTPLAYER
	 */
	int BOT_PLAYER_CARD_ADDED = BOT_PLAYER_FEATURE_COUNT + 100;

	/**
	 * The feature id for the '<em><b>Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__RANK = 0;

	/**
	 * The feature id for the '<em><b>Suit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__SUIT = 1;

	/**
	 * The number of structural features of the '<em>Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Card</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_CONTAINER__CARD = 0;

	/**
	 * The number of structural features of the '<em>Card Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Card</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_DECK__CARD = CARD_CONTAINER__CARD;

	/**
	 * The number of structural features of the '<em>Closed Deck</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_DECK_FEATURE_COUNT = CARD_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dealplayer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__DEALPLAYER = 0;

	/**
	 * The feature id for the '<em><b>Opendeck</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__OPENDECK = 1;

	/**
	 * The feature id for the '<em><b>Closeddeck</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__CLOSEDDECK = 2;

	/**
	 * The feature id for the '<em><b>Joker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__JOKER = 3;

	/**
	 * The feature id for the '<em><b>Current Turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__CURRENT_TURN = 4;

	/**
	 * The feature id for the '<em><b>Deal Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__DEAL_NUMBER = 5;

	/**
	 * The feature id for the '<em><b>Show Initiator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__SHOW_INITIATOR = 6;

	/**
	 * The feature id for the '<em><b>Match</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL__MATCH = 7;

	/**
	 * The number of structural features of the '<em>Deal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_FEATURE_COUNT = 8;

	/**
	 * The feature id for the '<em><b>Chips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__CHIPS = PLAYER__CHIPS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__ID = PLAYER__ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__LEVEL = PLAYER__LEVEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__NAME = PLAYER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__SOURCE = PLAYER__SOURCE;

	/**
	 * The feature id for the '<em><b>Uid Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__UID_SRC = PLAYER__UID_SRC;

	/**
	 * The feature id for the '<em><b>Xp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__XP = PLAYER__XP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__TYPE = PLAYER__TYPE;

	/**
	 * The feature id for the '<em><b>Handcards</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__HANDCARDS = PLAYER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__SCORE = PLAYER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Missed Turn Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__MISSED_TURN_COUNT = PLAYER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__STATE = PLAYER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Time Of Joining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__TIME_OF_JOINING = PLAYER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Winner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER__WINNER = PLAYER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Deal Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEAL_PLAYER_FEATURE_COUNT = PLAYER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.DocumentRootImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 7;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Botinfo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BOTINFO = 3;

	/**
	 * The feature id for the '<em><b>Bot Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BOT_PLAYER = 4;

	/**
	 * The feature id for the '<em><b>Card</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CARD = 5;

	/**
	 * The feature id for the '<em><b>Closeddeck</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CLOSEDDECK = 6;

	/**
	 * The feature id for the '<em><b>Deal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEAL = 7;

	/**
	 * The feature id for the '<em><b>Dealplayer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEALPLAYER = 8;

	/**
	 * The feature id for the '<em><b>Fixedprizegame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FIXEDPRIZEGAME = 9;

	/**
	 * The feature id for the '<em><b>Game</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__GAME = 10;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__GROUPS = 11;

	/**
	 * The feature id for the '<em><b>Handcards</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HANDCARDS = 12;

	/**
	 * The feature id for the '<em><b>Joker</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__JOKER = 13;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MATCH = 14;

	/**
	 * The feature id for the '<em><b>Matchplayer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MATCHPLAYER = 15;

	/**
	 * The feature id for the '<em><b>Opendeck</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OPENDECK = 16;

	/**
	 * The feature id for the '<em><b>Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PLAYER = 17;

	/**
	 * The feature id for the '<em><b>Pointsgame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POINTSGAME = 18;

	/**
	 * The feature id for the '<em><b>Pokerrummygame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POKERRUMMYGAME = 19;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PRIZE = 20;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SCORE = 21;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SEAT = 22;

	/**
	 * The feature id for the '<em><b>Settlement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SETTLEMENT = 23;

	/**
	 * The feature id for the '<em><b>Syndicategame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SYNDICATEGAME = 24;

	/**
	 * The feature id for the '<em><b>Testgame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TESTGAME = 25;

	/**
	 * The feature id for the '<em><b>User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__USER = 26;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 27;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.GameImpl <em>Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.GameImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getGame()
	 * @generated
	 */
	int GAME = 9;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__SEAT = 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__MATCH = 1;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__USER = 2;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__PRIZE = 3;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__DYNAMIC = 4;

	/**
	 * The feature id for the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__ENTRY_FEE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__ID = 6;

	/**
	 * The feature id for the '<em><b>Max Players</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__MAX_PLAYERS = 7;

	/**
	 * The feature id for the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__MAX_SCORE = 8;

	/**
	 * The feature id for the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__MAX_SPECTATORS = 9;

	/**
	 * The feature id for the '<em><b>Min Players Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__MIN_PLAYERS_REQUIRED = 10;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__OWNER = 11;

	/**
	 * The feature id for the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__POT_VALUE = 12;

	/**
	 * The feature id for the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__RAKE = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__TYPE = 14;

	/**
	 * The number of structural features of the '<em>Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.PointsGameImpl <em>Points Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.PointsGameImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPointsGame()
	 * @generated
	 */
	int POINTS_GAME = 18;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__SEAT = GAME__SEAT;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__MATCH = GAME__MATCH;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__USER = GAME__USER;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__PRIZE = GAME__PRIZE;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__DYNAMIC = GAME__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__ENTRY_FEE = GAME__ENTRY_FEE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__ID = GAME__ID;

	/**
	 * The feature id for the '<em><b>Max Players</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__MAX_PLAYERS = GAME__MAX_PLAYERS;

	/**
	 * The feature id for the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__MAX_SCORE = GAME__MAX_SCORE;

	/**
	 * The feature id for the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__MAX_SPECTATORS = GAME__MAX_SPECTATORS;

	/**
	 * The feature id for the '<em><b>Min Players Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__MIN_PLAYERS_REQUIRED = GAME__MIN_PLAYERS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__OWNER = GAME__OWNER;

	/**
	 * The feature id for the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__POT_VALUE = GAME__POT_VALUE;

	/**
	 * The feature id for the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__RAKE = GAME__RAKE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME__TYPE = GAME__TYPE;

	/**
	 * The number of structural features of the '<em>Points Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_GAME_FEATURE_COUNT = GAME_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.FixedPrizeGameImpl <em>Fixed Prize Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.FixedPrizeGameImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getFixedPrizeGame()
	 * @generated
	 */
	int FIXED_PRIZE_GAME = 8;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__SEAT = POINTS_GAME__SEAT;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__MATCH = POINTS_GAME__MATCH;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__USER = POINTS_GAME__USER;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__PRIZE = POINTS_GAME__PRIZE;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__DYNAMIC = POINTS_GAME__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__ENTRY_FEE = POINTS_GAME__ENTRY_FEE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__ID = POINTS_GAME__ID;

	/**
	 * The feature id for the '<em><b>Max Players</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__MAX_PLAYERS = POINTS_GAME__MAX_PLAYERS;

	/**
	 * The feature id for the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__MAX_SCORE = POINTS_GAME__MAX_SCORE;

	/**
	 * The feature id for the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__MAX_SPECTATORS = POINTS_GAME__MAX_SPECTATORS;

	/**
	 * The feature id for the '<em><b>Min Players Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__MIN_PLAYERS_REQUIRED = POINTS_GAME__MIN_PLAYERS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__OWNER = POINTS_GAME__OWNER;

	/**
	 * The feature id for the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__POT_VALUE = POINTS_GAME__POT_VALUE;

	/**
	 * The feature id for the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__RAKE = POINTS_GAME__RAKE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME__TYPE = POINTS_GAME__TYPE;

	/**
	 * The number of structural features of the '<em>Fixed Prize Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PRIZE_GAME_FEATURE_COUNT = POINTS_GAME_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.GroupCardsImpl <em>Group Cards</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.GroupCardsImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getGroupCards()
	 * @generated
	 */
	int GROUP_CARDS = 10;

	/**
	 * The feature id for the '<em><b>Card</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDS__CARD = CARD_CONTAINER__CARD;

	/**
	 * The number of structural features of the '<em>Group Cards</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDS_FEATURE_COUNT = CARD_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.HandCardsImpl <em>Hand Cards</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.HandCardsImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getHandCards()
	 * @generated
	 */
	int HAND_CARDS = 11;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAND_CARDS__GROUPS = 0;

	/**
	 * The number of structural features of the '<em>Hand Cards</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAND_CARDS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.JokerImpl <em>Joker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.JokerImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getJoker()
	 * @generated
	 */
	int JOKER = 12;

	/**
	 * The feature id for the '<em><b>Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOKER__RANK = CARD__RANK;

	/**
	 * The feature id for the '<em><b>Suit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOKER__SUIT = CARD__SUIT;

	/**
	 * The number of structural features of the '<em>Joker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOKER_FEATURE_COUNT = CARD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.MatchImpl <em>Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.MatchImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getMatch()
	 * @generated
	 */
	int MATCH = 13;

	/**
	 * The feature id for the '<em><b>Matchplayer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__MATCHPLAYER = 0;

	/**
	 * The feature id for the '<em><b>Deal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__DEAL = 1;

	/**
	 * The feature id for the '<em><b>Deal Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__DEAL_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__ID = 3;

	/**
	 * The feature id for the '<em><b>Last Start Turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__LAST_START_TURN = 4;

	/**
	 * The feature id for the '<em><b>Game</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__GAME = 5;

	/**
	 * The number of structural features of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.MatchPlayerImpl <em>Match Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.MatchPlayerImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getMatchPlayer()
	 * @generated
	 */
	int MATCH_PLAYER = 14;

	/**
	 * The feature id for the '<em><b>Chips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__CHIPS = PLAYER__CHIPS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__ID = PLAYER__ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__LEVEL = PLAYER__LEVEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__NAME = PLAYER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__SOURCE = PLAYER__SOURCE;

	/**
	 * The feature id for the '<em><b>Uid Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__UID_SRC = PLAYER__UID_SRC;

	/**
	 * The feature id for the '<em><b>Xp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__XP = PLAYER__XP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__TYPE = PLAYER__TYPE;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__SCORE = PLAYER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Settlement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__SETTLEMENT = PLAYER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__STATE = PLAYER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Time Of Joining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__TIME_OF_JOINING = PLAYER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Toss Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER__TOSS_RANK = PLAYER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Match Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PLAYER_FEATURE_COUNT = PLAYER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.MyImpl <em>My</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.MyImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getMy()
	 * @generated
	 */
	int MY = 15;

	/**
	 * The number of structural features of the '<em>My</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.OpenDeckImpl <em>Open Deck</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.OpenDeckImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getOpenDeck()
	 * @generated
	 */
	int OPEN_DECK = 16;

	/**
	 * The feature id for the '<em><b>Card</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECK__CARD = CARD_CONTAINER__CARD;

	/**
	 * The number of structural features of the '<em>Open Deck</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECK_FEATURE_COUNT = CARD_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.PokerRummyGameImpl <em>Poker Rummy Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.PokerRummyGameImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPokerRummyGame()
	 * @generated
	 */
	int POKER_RUMMY_GAME = 19;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__SEAT = POINTS_GAME__SEAT;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__MATCH = POINTS_GAME__MATCH;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__USER = POINTS_GAME__USER;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__PRIZE = POINTS_GAME__PRIZE;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__DYNAMIC = POINTS_GAME__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__ENTRY_FEE = POINTS_GAME__ENTRY_FEE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__ID = POINTS_GAME__ID;

	/**
	 * The feature id for the '<em><b>Max Players</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__MAX_PLAYERS = POINTS_GAME__MAX_PLAYERS;

	/**
	 * The feature id for the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__MAX_SCORE = POINTS_GAME__MAX_SCORE;

	/**
	 * The feature id for the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__MAX_SPECTATORS = POINTS_GAME__MAX_SPECTATORS;

	/**
	 * The feature id for the '<em><b>Min Players Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__MIN_PLAYERS_REQUIRED = POINTS_GAME__MIN_PLAYERS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__OWNER = POINTS_GAME__OWNER;

	/**
	 * The feature id for the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__POT_VALUE = POINTS_GAME__POT_VALUE;

	/**
	 * The feature id for the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__RAKE = POINTS_GAME__RAKE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME__TYPE = POINTS_GAME__TYPE;

	/**
	 * The number of structural features of the '<em>Poker Rummy Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POKER_RUMMY_GAME_FEATURE_COUNT = POINTS_GAME_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.PrizeImpl <em>Prize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.PrizeImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPrize()
	 * @generated
	 */
	int PRIZE = 20;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIZE__CURRENCY = 0;

	/**
	 * The feature id for the '<em><b>Goodie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIZE__GOODIE = 1;

	/**
	 * The feature id for the '<em><b>Prize Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIZE__PRIZE_NAME = 2;

	/**
	 * The feature id for the '<em><b>XP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIZE__XP = 3;

	/**
	 * The number of structural features of the '<em>Prize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIZE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.ScoreImpl <em>Score</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.ScoreImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getScore()
	 * @generated
	 */
	int SCORE = 21;

	/**
	 * The feature id for the '<em><b>Dealnum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__DEALNUM = 0;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__SCORE = 1;

	/**
	 * The number of structural features of the '<em>Score</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.SeatImpl <em>Seat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.SeatImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getSeat()
	 * @generated
	 */
	int SEAT = 22;

	/**
	 * The feature id for the '<em><b>Player</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT__PLAYER = 0;

	/**
	 * The feature id for the '<em><b>Seat Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT__SEAT_ID = 1;

	/**
	 * The number of structural features of the '<em>Seat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEAT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.SettlementImpl <em>Settlement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.SettlementImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getSettlement()
	 * @generated
	 */
	int SETTLEMENT = 23;

	/**
	 * The feature id for the '<em><b>Chips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTLEMENT__CHIPS = 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTLEMENT__LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Total Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTLEMENT__TOTAL_SCORE = 2;

	/**
	 * The feature id for the '<em><b>Xp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTLEMENT__XP = 3;

	/**
	 * The number of structural features of the '<em>Settlement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTLEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.SyndicateGameImpl <em>Syndicate Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.SyndicateGameImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getSyndicateGame()
	 * @generated
	 */
	int SYNDICATE_GAME = 24;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__SEAT = GAME__SEAT;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__MATCH = GAME__MATCH;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__USER = GAME__USER;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__PRIZE = GAME__PRIZE;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__DYNAMIC = GAME__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__ENTRY_FEE = GAME__ENTRY_FEE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__ID = GAME__ID;

	/**
	 * The feature id for the '<em><b>Max Players</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__MAX_PLAYERS = GAME__MAX_PLAYERS;

	/**
	 * The feature id for the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__MAX_SCORE = GAME__MAX_SCORE;

	/**
	 * The feature id for the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__MAX_SPECTATORS = GAME__MAX_SPECTATORS;

	/**
	 * The feature id for the '<em><b>Min Players Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__MIN_PLAYERS_REQUIRED = GAME__MIN_PLAYERS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__OWNER = GAME__OWNER;

	/**
	 * The feature id for the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__POT_VALUE = GAME__POT_VALUE;

	/**
	 * The feature id for the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__RAKE = GAME__RAKE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME__TYPE = GAME__TYPE;

	/**
	 * The number of structural features of the '<em>Syndicate Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNDICATE_GAME_FEATURE_COUNT = GAME_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.mangogames.rummy.model.impl.TestGameImpl <em>Test Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mangogames.rummy.model.impl.TestGameImpl
	 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getTestGame()
	 * @generated
	 */
	int TEST_GAME = 25;

	/**
	 * The feature id for the '<em><b>Seat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__SEAT = GAME__SEAT;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__MATCH = GAME__MATCH;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__USER = GAME__USER;

	/**
	 * The feature id for the '<em><b>Prize</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__PRIZE = GAME__PRIZE;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__DYNAMIC = GAME__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Entry Fee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__ENTRY_FEE = GAME__ENTRY_FEE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__ID = GAME__ID;

	/**
	 * The feature id for the '<em><b>Max Players</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__MAX_PLAYERS = GAME__MAX_PLAYERS;

	/**
	 * The feature id for the '<em><b>Max Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__MAX_SCORE = GAME__MAX_SCORE;

	/**
	 * The feature id for the '<em><b>Max Spectators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__MAX_SPECTATORS = GAME__MAX_SPECTATORS;

	/**
	 * The feature id for the '<em><b>Min Players Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__MIN_PLAYERS_REQUIRED = GAME__MIN_PLAYERS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__OWNER = GAME__OWNER;

	/**
	 * The feature id for the '<em><b>Pot Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__POT_VALUE = GAME__POT_VALUE;

	/**
	 * The feature id for the '<em><b>Rake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__RAKE = GAME__RAKE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME__TYPE = GAME__TYPE;

	/**
	 * The number of structural features of the '<em>Test Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GAME_FEATURE_COUNT = GAME_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.BotInfo <em>Bot Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bot Info</em>'.
	 * @see com.mangogames.rummy.model.BotInfo
	 * @generated
	 */
	EClass getBotInfo();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getNewElement <em>New Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Element</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getNewElement()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_NewElement();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getBotId <em>Bot Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bot Id</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getBotId()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_BotId();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getDob <em>Dob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dob</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getDob()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_Dob();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getEmail()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_Email();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#isEngaged <em>Engaged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engaged</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#isEngaged()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_Engaged();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getGender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gender</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getGender()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_Gender();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getLocation()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getName()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getRoomId <em>Room Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Room Id</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getRoomId()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_RoomId();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.BotInfo#getSourceId <em>Source Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Id</em>'.
	 * @see com.mangogames.rummy.model.BotInfo#getSourceId()
	 * @see #getBotInfo()
	 * @generated
	 */
	EAttribute getBotInfo_SourceId();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.BotPlayer <em>Bot Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bot Player</em>'.
	 * @see com.mangogames.rummy.model.BotPlayer
	 * @generated
	 */
	EClass getBotPlayer();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Card <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Card</em>'.
	 * @see com.mangogames.rummy.model.Card
	 * @generated
	 */
	EClass getCard();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Card#getRank <em>Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rank</em>'.
	 * @see com.mangogames.rummy.model.Card#getRank()
	 * @see #getCard()
	 * @generated
	 */
	EAttribute getCard_Rank();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Card#getSuit <em>Suit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suit</em>'.
	 * @see com.mangogames.rummy.model.Card#getSuit()
	 * @see #getCard()
	 * @generated
	 */
	EAttribute getCard_Suit();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.CardContainer <em>Card Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Card Container</em>'.
	 * @see com.mangogames.rummy.model.CardContainer
	 * @generated
	 */
	EClass getCardContainer();

	/**
	 * Returns the meta object for the reference list '{@link com.mangogames.rummy.model.CardContainer#getCard <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Card</em>'.
	 * @see com.mangogames.rummy.model.CardContainer#getCard()
	 * @see #getCardContainer()
	 * @generated
	 */
	EReference getCardContainer_Card();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.ClosedDeck <em>Closed Deck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closed Deck</em>'.
	 * @see com.mangogames.rummy.model.ClosedDeck
	 * @generated
	 */
	EClass getClosedDeck();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Deal <em>Deal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deal</em>'.
	 * @see com.mangogames.rummy.model.Deal
	 * @generated
	 */
	EClass getDeal();

	/**
	 * Returns the meta object for the reference list '{@link com.mangogames.rummy.model.Deal#getDealplayer <em>Dealplayer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dealplayer</em>'.
	 * @see com.mangogames.rummy.model.Deal#getDealplayer()
	 * @see #getDeal()
	 * @generated
	 */
	EReference getDeal_Dealplayer();

	/**
	 * Returns the meta object for the reference '{@link com.mangogames.rummy.model.Deal#getOpendeck <em>Opendeck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opendeck</em>'.
	 * @see com.mangogames.rummy.model.Deal#getOpendeck()
	 * @see #getDeal()
	 * @generated
	 */
	EReference getDeal_Opendeck();

	/**
	 * Returns the meta object for the reference '{@link com.mangogames.rummy.model.Deal#getCloseddeck <em>Closeddeck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Closeddeck</em>'.
	 * @see com.mangogames.rummy.model.Deal#getCloseddeck()
	 * @see #getDeal()
	 * @generated
	 */
	EReference getDeal_Closeddeck();

	/**
	 * Returns the meta object for the reference '{@link com.mangogames.rummy.model.Deal#getJoker <em>Joker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Joker</em>'.
	 * @see com.mangogames.rummy.model.Deal#getJoker()
	 * @see #getDeal()
	 * @generated
	 */
	EReference getDeal_Joker();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Deal#getCurrentTurn <em>Current Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Turn</em>'.
	 * @see com.mangogames.rummy.model.Deal#getCurrentTurn()
	 * @see #getDeal()
	 * @generated
	 */
	EAttribute getDeal_CurrentTurn();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Deal#getDealNumber <em>Deal Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deal Number</em>'.
	 * @see com.mangogames.rummy.model.Deal#getDealNumber()
	 * @see #getDeal()
	 * @generated
	 */
	EAttribute getDeal_DealNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Deal#getShowInitiator <em>Show Initiator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Initiator</em>'.
	 * @see com.mangogames.rummy.model.Deal#getShowInitiator()
	 * @see #getDeal()
	 * @generated
	 */
	EAttribute getDeal_ShowInitiator();

	/**
	 * Returns the meta object for the container reference '{@link com.mangogames.rummy.model.Deal#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Match</em>'.
	 * @see com.mangogames.rummy.model.Deal#getMatch()
	 * @see #getDeal()
	 * @generated
	 */
	EReference getDeal_Match();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.DealPlayer <em>Deal Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deal Player</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer
	 * @generated
	 */
	EClass getDealPlayer();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DealPlayer#getHandcards <em>Handcards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Handcards</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer#getHandcards()
	 * @see #getDealPlayer()
	 * @generated
	 */
	EReference getDealPlayer_Handcards();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DealPlayer#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Score</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer#getScore()
	 * @see #getDealPlayer()
	 * @generated
	 */
	EReference getDealPlayer_Score();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.DealPlayer#getMissedTurnCount <em>Missed Turn Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Missed Turn Count</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer#getMissedTurnCount()
	 * @see #getDealPlayer()
	 * @generated
	 */
	EAttribute getDealPlayer_MissedTurnCount();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.DealPlayer#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer#getState()
	 * @see #getDealPlayer()
	 * @generated
	 */
	EAttribute getDealPlayer_State();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.DealPlayer#getTimeOfJoining <em>Time Of Joining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Of Joining</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer#getTimeOfJoining()
	 * @see #getDealPlayer()
	 * @generated
	 */
	EAttribute getDealPlayer_TimeOfJoining();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.DealPlayer#isWinner <em>Winner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Winner</em>'.
	 * @see com.mangogames.rummy.model.DealPlayer#isWinner()
	 * @see #getDealPlayer()
	 * @generated
	 */
	EAttribute getDealPlayer_Winner();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.mangogames.rummy.model.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.mangogames.rummy.model.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.mangogames.rummy.model.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getBotinfo <em>Botinfo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Botinfo</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getBotinfo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Botinfo();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getBotPlayer <em>Bot Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bot Player</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getBotPlayer()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BotPlayer();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getCard <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Card</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getCard()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Card();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getCloseddeck <em>Closeddeck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Closeddeck</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getCloseddeck()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Closeddeck();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getDeal <em>Deal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deal</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getDeal()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Deal();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getDealplayer <em>Dealplayer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dealplayer</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getDealplayer()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Dealplayer();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getFixedprizegame <em>Fixedprizegame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fixedprizegame</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getFixedprizegame()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Fixedprizegame();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getGame <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Game</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getGame()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Game();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Groups</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getGroups()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Groups();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getHandcards <em>Handcards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Handcards</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getHandcards()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Handcards();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getJoker <em>Joker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Joker</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getJoker()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Joker();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Match</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getMatch()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Match();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getMatchplayer <em>Matchplayer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matchplayer</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getMatchplayer()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Matchplayer();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getOpendeck <em>Opendeck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Opendeck</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getOpendeck()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Opendeck();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Player</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getPlayer()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Player();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getPointsgame <em>Pointsgame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pointsgame</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getPointsgame()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Pointsgame();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getPokerrummygame <em>Pokerrummygame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pokerrummygame</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getPokerrummygame()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Pokerrummygame();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getPrize <em>Prize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prize</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getPrize()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Prize();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Score</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getScore()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Score();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getSeat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Seat</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getSeat()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Seat();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getSettlement <em>Settlement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Settlement</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getSettlement()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Settlement();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getSyndicategame <em>Syndicategame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Syndicategame</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getSyndicategame()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Syndicategame();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getTestgame <em>Testgame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Testgame</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getTestgame()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Testgame();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.DocumentRoot#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>User</em>'.
	 * @see com.mangogames.rummy.model.DocumentRoot#getUser()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_User();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.FixedPrizeGame <em>Fixed Prize Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Prize Game</em>'.
	 * @see com.mangogames.rummy.model.FixedPrizeGame
	 * @generated
	 */
	EClass getFixedPrizeGame();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Game <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game</em>'.
	 * @see com.mangogames.rummy.model.Game
	 * @generated
	 */
	EClass getGame();

	/**
	 * Returns the meta object for the reference list '{@link com.mangogames.rummy.model.Game#getSeat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Seat</em>'.
	 * @see com.mangogames.rummy.model.Game#getSeat()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Seat();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.Game#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Match</em>'.
	 * @see com.mangogames.rummy.model.Game#getMatch()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Match();

	/**
	 * Returns the meta object for the reference list '{@link com.mangogames.rummy.model.Game#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>User</em>'.
	 * @see com.mangogames.rummy.model.Game#getUser()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_User();

	/**
	 * Returns the meta object for the reference '{@link com.mangogames.rummy.model.Game#getPrize <em>Prize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prize</em>'.
	 * @see com.mangogames.rummy.model.Game#getPrize()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Prize();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#isDynamic <em>Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see com.mangogames.rummy.model.Game#isDynamic()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Dynamic();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getEntryFee <em>Entry Fee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Fee</em>'.
	 * @see com.mangogames.rummy.model.Game#getEntryFee()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_EntryFee();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.mangogames.rummy.model.Game#getId()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getMaxPlayers <em>Max Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Players</em>'.
	 * @see com.mangogames.rummy.model.Game#getMaxPlayers()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_MaxPlayers();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getMaxScore <em>Max Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Score</em>'.
	 * @see com.mangogames.rummy.model.Game#getMaxScore()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_MaxScore();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getMaxSpectators <em>Max Spectators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Spectators</em>'.
	 * @see com.mangogames.rummy.model.Game#getMaxSpectators()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_MaxSpectators();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getMinPlayersRequired <em>Min Players Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Players Required</em>'.
	 * @see com.mangogames.rummy.model.Game#getMinPlayersRequired()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_MinPlayersRequired();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.mangogames.rummy.model.Game#getOwner()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getPotValue <em>Pot Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pot Value</em>'.
	 * @see com.mangogames.rummy.model.Game#getPotValue()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_PotValue();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getRake <em>Rake</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rake</em>'.
	 * @see com.mangogames.rummy.model.Game#getRake()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Rake();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Game#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.mangogames.rummy.model.Game#getType()
	 * @see #getGame()
	 * @generated
	 */
	EAttribute getGame_Type();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.GroupCards <em>Group Cards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Cards</em>'.
	 * @see com.mangogames.rummy.model.GroupCards
	 * @generated
	 */
	EClass getGroupCards();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.HandCards <em>Hand Cards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hand Cards</em>'.
	 * @see com.mangogames.rummy.model.HandCards
	 * @generated
	 */
	EClass getHandCards();

	/**
	 * Returns the meta object for the reference list '{@link com.mangogames.rummy.model.HandCards#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Groups</em>'.
	 * @see com.mangogames.rummy.model.HandCards#getGroups()
	 * @see #getHandCards()
	 * @generated
	 */
	EReference getHandCards_Groups();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Joker <em>Joker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joker</em>'.
	 * @see com.mangogames.rummy.model.Joker
	 * @generated
	 */
	EClass getJoker();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match</em>'.
	 * @see com.mangogames.rummy.model.Match
	 * @generated
	 */
	EClass getMatch();

	/**
	 * Returns the meta object for the reference list '{@link com.mangogames.rummy.model.Match#getMatchplayer <em>Matchplayer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Matchplayer</em>'.
	 * @see com.mangogames.rummy.model.Match#getMatchplayer()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Matchplayer();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.Match#getDeal <em>Deal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deal</em>'.
	 * @see com.mangogames.rummy.model.Match#getDeal()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Deal();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Match#getDealCount <em>Deal Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deal Count</em>'.
	 * @see com.mangogames.rummy.model.Match#getDealCount()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_DealCount();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Match#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.mangogames.rummy.model.Match#getId()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Match#getLastStartTurn <em>Last Start Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Start Turn</em>'.
	 * @see com.mangogames.rummy.model.Match#getLastStartTurn()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_LastStartTurn();

	/**
	 * Returns the meta object for the container reference '{@link com.mangogames.rummy.model.Match#getGame <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Game</em>'.
	 * @see com.mangogames.rummy.model.Match#getGame()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Game();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.MatchPlayer <em>Match Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Player</em>'.
	 * @see com.mangogames.rummy.model.MatchPlayer
	 * @generated
	 */
	EClass getMatchPlayer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mangogames.rummy.model.MatchPlayer#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Score</em>'.
	 * @see com.mangogames.rummy.model.MatchPlayer#getScore()
	 * @see #getMatchPlayer()
	 * @generated
	 */
	EReference getMatchPlayer_Score();

	/**
	 * Returns the meta object for the containment reference '{@link com.mangogames.rummy.model.MatchPlayer#getSettlement <em>Settlement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Settlement</em>'.
	 * @see com.mangogames.rummy.model.MatchPlayer#getSettlement()
	 * @see #getMatchPlayer()
	 * @generated
	 */
	EReference getMatchPlayer_Settlement();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.MatchPlayer#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.mangogames.rummy.model.MatchPlayer#getState()
	 * @see #getMatchPlayer()
	 * @generated
	 */
	EAttribute getMatchPlayer_State();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.MatchPlayer#getTimeOfJoining <em>Time Of Joining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Of Joining</em>'.
	 * @see com.mangogames.rummy.model.MatchPlayer#getTimeOfJoining()
	 * @see #getMatchPlayer()
	 * @generated
	 */
	EAttribute getMatchPlayer_TimeOfJoining();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.MatchPlayer#getTossRank <em>Toss Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Toss Rank</em>'.
	 * @see com.mangogames.rummy.model.MatchPlayer#getTossRank()
	 * @see #getMatchPlayer()
	 * @generated
	 */
	EAttribute getMatchPlayer_TossRank();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.My <em>My</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My</em>'.
	 * @see com.mangogames.rummy.model.My
	 * @generated
	 */
	EClass getMy();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.OpenDeck <em>Open Deck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Deck</em>'.
	 * @see com.mangogames.rummy.model.OpenDeck
	 * @generated
	 */
	EClass getOpenDeck();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see com.mangogames.rummy.model.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Player#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.mangogames.rummy.model.Player#getType()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Type();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.PointsGame <em>Points Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Points Game</em>'.
	 * @see com.mangogames.rummy.model.PointsGame
	 * @generated
	 */
	EClass getPointsGame();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.PokerRummyGame <em>Poker Rummy Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Poker Rummy Game</em>'.
	 * @see com.mangogames.rummy.model.PokerRummyGame
	 * @generated
	 */
	EClass getPokerRummyGame();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Prize <em>Prize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prize</em>'.
	 * @see com.mangogames.rummy.model.Prize
	 * @generated
	 */
	EClass getPrize();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Prize#getCurrency <em>Currency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Currency</em>'.
	 * @see com.mangogames.rummy.model.Prize#getCurrency()
	 * @see #getPrize()
	 * @generated
	 */
	EAttribute getPrize_Currency();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Prize#getGoodie <em>Goodie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goodie</em>'.
	 * @see com.mangogames.rummy.model.Prize#getGoodie()
	 * @see #getPrize()
	 * @generated
	 */
	EAttribute getPrize_Goodie();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Prize#getPrizeName <em>Prize Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prize Name</em>'.
	 * @see com.mangogames.rummy.model.Prize#getPrizeName()
	 * @see #getPrize()
	 * @generated
	 */
	EAttribute getPrize_PrizeName();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Prize#getXP <em>XP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XP</em>'.
	 * @see com.mangogames.rummy.model.Prize#getXP()
	 * @see #getPrize()
	 * @generated
	 */
	EAttribute getPrize_XP();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Score <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Score</em>'.
	 * @see com.mangogames.rummy.model.Score
	 * @generated
	 */
	EClass getScore();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Score#getDealnum <em>Dealnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dealnum</em>'.
	 * @see com.mangogames.rummy.model.Score#getDealnum()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_Dealnum();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Score#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see com.mangogames.rummy.model.Score#getScore()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_Score();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Seat <em>Seat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seat</em>'.
	 * @see com.mangogames.rummy.model.Seat
	 * @generated
	 */
	EClass getSeat();

	/**
	 * Returns the meta object for the reference '{@link com.mangogames.rummy.model.Seat#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Player</em>'.
	 * @see com.mangogames.rummy.model.Seat#getPlayer()
	 * @see #getSeat()
	 * @generated
	 */
	EReference getSeat_Player();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Seat#getSeatId <em>Seat Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seat Id</em>'.
	 * @see com.mangogames.rummy.model.Seat#getSeatId()
	 * @see #getSeat()
	 * @generated
	 */
	EAttribute getSeat_SeatId();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.Settlement <em>Settlement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settlement</em>'.
	 * @see com.mangogames.rummy.model.Settlement
	 * @generated
	 */
	EClass getSettlement();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Settlement#getChips <em>Chips</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chips</em>'.
	 * @see com.mangogames.rummy.model.Settlement#getChips()
	 * @see #getSettlement()
	 * @generated
	 */
	EAttribute getSettlement_Chips();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Settlement#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see com.mangogames.rummy.model.Settlement#getLevel()
	 * @see #getSettlement()
	 * @generated
	 */
	EAttribute getSettlement_Level();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Settlement#getTotalScore <em>Total Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Score</em>'.
	 * @see com.mangogames.rummy.model.Settlement#getTotalScore()
	 * @see #getSettlement()
	 * @generated
	 */
	EAttribute getSettlement_TotalScore();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.Settlement#getXp <em>Xp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xp</em>'.
	 * @see com.mangogames.rummy.model.Settlement#getXp()
	 * @see #getSettlement()
	 * @generated
	 */
	EAttribute getSettlement_Xp();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.SyndicateGame <em>Syndicate Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syndicate Game</em>'.
	 * @see com.mangogames.rummy.model.SyndicateGame
	 * @generated
	 */
	EClass getSyndicateGame();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.TestGame <em>Test Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Game</em>'.
	 * @see com.mangogames.rummy.model.TestGame
	 * @generated
	 */
	EClass getTestGame();

	/**
	 * Returns the meta object for class '{@link com.mangogames.rummy.model.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see com.mangogames.rummy.model.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getChips <em>Chips</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chips</em>'.
	 * @see com.mangogames.rummy.model.User#getChips()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Chips();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.mangogames.rummy.model.User#getId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see com.mangogames.rummy.model.User#getLevel()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Level();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.mangogames.rummy.model.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.mangogames.rummy.model.User#getSource()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Source();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getUidSrc <em>Uid Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid Src</em>'.
	 * @see com.mangogames.rummy.model.User#getUidSrc()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UidSrc();

	/**
	 * Returns the meta object for the attribute '{@link com.mangogames.rummy.model.User#getXp <em>Xp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xp</em>'.
	 * @see com.mangogames.rummy.model.User#getXp()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Xp();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.BotInfoImpl <em>Bot Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.BotInfoImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getBotInfo()
		 * @generated
		 */
		EClass BOT_INFO = eINSTANCE.getBotInfo();

		/**
		 * The meta object literal for the '<em><b>New Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__NEW_ELEMENT = eINSTANCE.getBotInfo_NewElement();

		/**
		 * The meta object literal for the '<em><b>Bot Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__BOT_ID = eINSTANCE.getBotInfo_BotId();

		/**
		 * The meta object literal for the '<em><b>Dob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__DOB = eINSTANCE.getBotInfo_Dob();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__EMAIL = eINSTANCE.getBotInfo_Email();

		/**
		 * The meta object literal for the '<em><b>Engaged</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__ENGAGED = eINSTANCE.getBotInfo_Engaged();

		/**
		 * The meta object literal for the '<em><b>Gender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__GENDER = eINSTANCE.getBotInfo_Gender();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__LOCATION = eINSTANCE.getBotInfo_Location();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__NAME = eINSTANCE.getBotInfo_Name();

		/**
		 * The meta object literal for the '<em><b>Room Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__ROOM_ID = eINSTANCE.getBotInfo_RoomId();

		/**
		 * The meta object literal for the '<em><b>Source Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INFO__SOURCE_ID = eINSTANCE.getBotInfo_SourceId();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.BotPlayerImpl <em>Bot Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.BotPlayerImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getBotPlayer()
		 * @generated
		 */
		EClass BOT_PLAYER = eINSTANCE.getBotPlayer();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.CardImpl <em>Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.CardImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getCard()
		 * @generated
		 */
		EClass CARD = eINSTANCE.getCard();

		/**
		 * The meta object literal for the '<em><b>Rank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARD__RANK = eINSTANCE.getCard_Rank();

		/**
		 * The meta object literal for the '<em><b>Suit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARD__SUIT = eINSTANCE.getCard_Suit();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.CardContainerImpl <em>Card Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.CardContainerImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getCardContainer()
		 * @generated
		 */
		EClass CARD_CONTAINER = eINSTANCE.getCardContainer();

		/**
		 * The meta object literal for the '<em><b>Card</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD_CONTAINER__CARD = eINSTANCE.getCardContainer_Card();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.ClosedDeckImpl <em>Closed Deck</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.ClosedDeckImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getClosedDeck()
		 * @generated
		 */
		EClass CLOSED_DECK = eINSTANCE.getClosedDeck();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.DealImpl <em>Deal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.DealImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getDeal()
		 * @generated
		 */
		EClass DEAL = eINSTANCE.getDeal();

		/**
		 * The meta object literal for the '<em><b>Dealplayer</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL__DEALPLAYER = eINSTANCE.getDeal_Dealplayer();

		/**
		 * The meta object literal for the '<em><b>Opendeck</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL__OPENDECK = eINSTANCE.getDeal_Opendeck();

		/**
		 * The meta object literal for the '<em><b>Closeddeck</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL__CLOSEDDECK = eINSTANCE.getDeal_Closeddeck();

		/**
		 * The meta object literal for the '<em><b>Joker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL__JOKER = eINSTANCE.getDeal_Joker();

		/**
		 * The meta object literal for the '<em><b>Current Turn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL__CURRENT_TURN = eINSTANCE.getDeal_CurrentTurn();

		/**
		 * The meta object literal for the '<em><b>Deal Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL__DEAL_NUMBER = eINSTANCE.getDeal_DealNumber();

		/**
		 * The meta object literal for the '<em><b>Show Initiator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL__SHOW_INITIATOR = eINSTANCE.getDeal_ShowInitiator();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL__MATCH = eINSTANCE.getDeal_Match();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.DealPlayerImpl <em>Deal Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.DealPlayerImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getDealPlayer()
		 * @generated
		 */
		EClass DEAL_PLAYER = eINSTANCE.getDealPlayer();

		/**
		 * The meta object literal for the '<em><b>Handcards</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL_PLAYER__HANDCARDS = eINSTANCE.getDealPlayer_Handcards();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEAL_PLAYER__SCORE = eINSTANCE.getDealPlayer_Score();

		/**
		 * The meta object literal for the '<em><b>Missed Turn Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL_PLAYER__MISSED_TURN_COUNT = eINSTANCE.getDealPlayer_MissedTurnCount();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL_PLAYER__STATE = eINSTANCE.getDealPlayer_State();

		/**
		 * The meta object literal for the '<em><b>Time Of Joining</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL_PLAYER__TIME_OF_JOINING = eINSTANCE.getDealPlayer_TimeOfJoining();

		/**
		 * The meta object literal for the '<em><b>Winner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEAL_PLAYER__WINNER = eINSTANCE.getDealPlayer_Winner();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.DocumentRootImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Botinfo</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BOTINFO = eINSTANCE.getDocumentRoot_Botinfo();

		/**
		 * The meta object literal for the '<em><b>Bot Player</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BOT_PLAYER = eINSTANCE.getDocumentRoot_BotPlayer();

		/**
		 * The meta object literal for the '<em><b>Card</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CARD = eINSTANCE.getDocumentRoot_Card();

		/**
		 * The meta object literal for the '<em><b>Closeddeck</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CLOSEDDECK = eINSTANCE.getDocumentRoot_Closeddeck();

		/**
		 * The meta object literal for the '<em><b>Deal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DEAL = eINSTANCE.getDocumentRoot_Deal();

		/**
		 * The meta object literal for the '<em><b>Dealplayer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DEALPLAYER = eINSTANCE.getDocumentRoot_Dealplayer();

		/**
		 * The meta object literal for the '<em><b>Fixedprizegame</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FIXEDPRIZEGAME = eINSTANCE.getDocumentRoot_Fixedprizegame();

		/**
		 * The meta object literal for the '<em><b>Game</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__GAME = eINSTANCE.getDocumentRoot_Game();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__GROUPS = eINSTANCE.getDocumentRoot_Groups();

		/**
		 * The meta object literal for the '<em><b>Handcards</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HANDCARDS = eINSTANCE.getDocumentRoot_Handcards();

		/**
		 * The meta object literal for the '<em><b>Joker</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__JOKER = eINSTANCE.getDocumentRoot_Joker();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MATCH = eINSTANCE.getDocumentRoot_Match();

		/**
		 * The meta object literal for the '<em><b>Matchplayer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MATCHPLAYER = eINSTANCE.getDocumentRoot_Matchplayer();

		/**
		 * The meta object literal for the '<em><b>Opendeck</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OPENDECK = eINSTANCE.getDocumentRoot_Opendeck();

		/**
		 * The meta object literal for the '<em><b>Player</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PLAYER = eINSTANCE.getDocumentRoot_Player();

		/**
		 * The meta object literal for the '<em><b>Pointsgame</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__POINTSGAME = eINSTANCE.getDocumentRoot_Pointsgame();

		/**
		 * The meta object literal for the '<em><b>Pokerrummygame</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__POKERRUMMYGAME = eINSTANCE.getDocumentRoot_Pokerrummygame();

		/**
		 * The meta object literal for the '<em><b>Prize</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PRIZE = eINSTANCE.getDocumentRoot_Prize();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SCORE = eINSTANCE.getDocumentRoot_Score();

		/**
		 * The meta object literal for the '<em><b>Seat</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SEAT = eINSTANCE.getDocumentRoot_Seat();

		/**
		 * The meta object literal for the '<em><b>Settlement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SETTLEMENT = eINSTANCE.getDocumentRoot_Settlement();

		/**
		 * The meta object literal for the '<em><b>Syndicategame</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SYNDICATEGAME = eINSTANCE.getDocumentRoot_Syndicategame();

		/**
		 * The meta object literal for the '<em><b>Testgame</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TESTGAME = eINSTANCE.getDocumentRoot_Testgame();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__USER = eINSTANCE.getDocumentRoot_User();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.FixedPrizeGameImpl <em>Fixed Prize Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.FixedPrizeGameImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getFixedPrizeGame()
		 * @generated
		 */
		EClass FIXED_PRIZE_GAME = eINSTANCE.getFixedPrizeGame();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.GameImpl <em>Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.GameImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getGame()
		 * @generated
		 */
		EClass GAME = eINSTANCE.getGame();

		/**
		 * The meta object literal for the '<em><b>Seat</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__SEAT = eINSTANCE.getGame_Seat();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__MATCH = eINSTANCE.getGame_Match();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__USER = eINSTANCE.getGame_User();

		/**
		 * The meta object literal for the '<em><b>Prize</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__PRIZE = eINSTANCE.getGame_Prize();

		/**
		 * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__DYNAMIC = eINSTANCE.getGame_Dynamic();

		/**
		 * The meta object literal for the '<em><b>Entry Fee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__ENTRY_FEE = eINSTANCE.getGame_EntryFee();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__ID = eINSTANCE.getGame_Id();

		/**
		 * The meta object literal for the '<em><b>Max Players</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__MAX_PLAYERS = eINSTANCE.getGame_MaxPlayers();

		/**
		 * The meta object literal for the '<em><b>Max Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__MAX_SCORE = eINSTANCE.getGame_MaxScore();

		/**
		 * The meta object literal for the '<em><b>Max Spectators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__MAX_SPECTATORS = eINSTANCE.getGame_MaxSpectators();

		/**
		 * The meta object literal for the '<em><b>Min Players Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__MIN_PLAYERS_REQUIRED = eINSTANCE.getGame_MinPlayersRequired();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__OWNER = eINSTANCE.getGame_Owner();

		/**
		 * The meta object literal for the '<em><b>Pot Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__POT_VALUE = eINSTANCE.getGame_PotValue();

		/**
		 * The meta object literal for the '<em><b>Rake</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__RAKE = eINSTANCE.getGame_Rake();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME__TYPE = eINSTANCE.getGame_Type();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.GroupCardsImpl <em>Group Cards</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.GroupCardsImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getGroupCards()
		 * @generated
		 */
		EClass GROUP_CARDS = eINSTANCE.getGroupCards();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.HandCardsImpl <em>Hand Cards</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.HandCardsImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getHandCards()
		 * @generated
		 */
		EClass HAND_CARDS = eINSTANCE.getHandCards();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAND_CARDS__GROUPS = eINSTANCE.getHandCards_Groups();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.JokerImpl <em>Joker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.JokerImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getJoker()
		 * @generated
		 */
		EClass JOKER = eINSTANCE.getJoker();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.MatchImpl <em>Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.MatchImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getMatch()
		 * @generated
		 */
		EClass MATCH = eINSTANCE.getMatch();

		/**
		 * The meta object literal for the '<em><b>Matchplayer</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__MATCHPLAYER = eINSTANCE.getMatch_Matchplayer();

		/**
		 * The meta object literal for the '<em><b>Deal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__DEAL = eINSTANCE.getMatch_Deal();

		/**
		 * The meta object literal for the '<em><b>Deal Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__DEAL_COUNT = eINSTANCE.getMatch_DealCount();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__ID = eINSTANCE.getMatch_Id();

		/**
		 * The meta object literal for the '<em><b>Last Start Turn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__LAST_START_TURN = eINSTANCE.getMatch_LastStartTurn();

		/**
		 * The meta object literal for the '<em><b>Game</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__GAME = eINSTANCE.getMatch_Game();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.MatchPlayerImpl <em>Match Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.MatchPlayerImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getMatchPlayer()
		 * @generated
		 */
		EClass MATCH_PLAYER = eINSTANCE.getMatchPlayer();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_PLAYER__SCORE = eINSTANCE.getMatchPlayer_Score();

		/**
		 * The meta object literal for the '<em><b>Settlement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_PLAYER__SETTLEMENT = eINSTANCE.getMatchPlayer_Settlement();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_PLAYER__STATE = eINSTANCE.getMatchPlayer_State();

		/**
		 * The meta object literal for the '<em><b>Time Of Joining</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_PLAYER__TIME_OF_JOINING = eINSTANCE.getMatchPlayer_TimeOfJoining();

		/**
		 * The meta object literal for the '<em><b>Toss Rank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_PLAYER__TOSS_RANK = eINSTANCE.getMatchPlayer_TossRank();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.MyImpl <em>My</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.MyImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getMy()
		 * @generated
		 */
		EClass MY = eINSTANCE.getMy();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.OpenDeckImpl <em>Open Deck</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.OpenDeckImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getOpenDeck()
		 * @generated
		 */
		EClass OPEN_DECK = eINSTANCE.getOpenDeck();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.PlayerImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__TYPE = eINSTANCE.getPlayer_Type();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.PointsGameImpl <em>Points Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.PointsGameImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPointsGame()
		 * @generated
		 */
		EClass POINTS_GAME = eINSTANCE.getPointsGame();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.PokerRummyGameImpl <em>Poker Rummy Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.PokerRummyGameImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPokerRummyGame()
		 * @generated
		 */
		EClass POKER_RUMMY_GAME = eINSTANCE.getPokerRummyGame();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.PrizeImpl <em>Prize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.PrizeImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getPrize()
		 * @generated
		 */
		EClass PRIZE = eINSTANCE.getPrize();

		/**
		 * The meta object literal for the '<em><b>Currency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIZE__CURRENCY = eINSTANCE.getPrize_Currency();

		/**
		 * The meta object literal for the '<em><b>Goodie</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIZE__GOODIE = eINSTANCE.getPrize_Goodie();

		/**
		 * The meta object literal for the '<em><b>Prize Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIZE__PRIZE_NAME = eINSTANCE.getPrize_PrizeName();

		/**
		 * The meta object literal for the '<em><b>XP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIZE__XP = eINSTANCE.getPrize_XP();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.ScoreImpl <em>Score</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.ScoreImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getScore()
		 * @generated
		 */
		EClass SCORE = eINSTANCE.getScore();

		/**
		 * The meta object literal for the '<em><b>Dealnum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__DEALNUM = eINSTANCE.getScore_Dealnum();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__SCORE = eINSTANCE.getScore_Score();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.SeatImpl <em>Seat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.SeatImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getSeat()
		 * @generated
		 */
		EClass SEAT = eINSTANCE.getSeat();

		/**
		 * The meta object literal for the '<em><b>Player</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEAT__PLAYER = eINSTANCE.getSeat_Player();

		/**
		 * The meta object literal for the '<em><b>Seat Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEAT__SEAT_ID = eINSTANCE.getSeat_SeatId();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.SettlementImpl <em>Settlement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.SettlementImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getSettlement()
		 * @generated
		 */
		EClass SETTLEMENT = eINSTANCE.getSettlement();

		/**
		 * The meta object literal for the '<em><b>Chips</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTLEMENT__CHIPS = eINSTANCE.getSettlement_Chips();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTLEMENT__LEVEL = eINSTANCE.getSettlement_Level();

		/**
		 * The meta object literal for the '<em><b>Total Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTLEMENT__TOTAL_SCORE = eINSTANCE.getSettlement_TotalScore();

		/**
		 * The meta object literal for the '<em><b>Xp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTLEMENT__XP = eINSTANCE.getSettlement_Xp();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.SyndicateGameImpl <em>Syndicate Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.SyndicateGameImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getSyndicateGame()
		 * @generated
		 */
		EClass SYNDICATE_GAME = eINSTANCE.getSyndicateGame();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.TestGameImpl <em>Test Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.TestGameImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getTestGame()
		 * @generated
		 */
		EClass TEST_GAME = eINSTANCE.getTestGame();

		/**
		 * The meta object literal for the '{@link com.mangogames.rummy.model.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mangogames.rummy.model.impl.UserImpl
		 * @see com.mangogames.rummy.model.impl.ModelPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Chips</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__CHIPS = eINSTANCE.getUser_Chips();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__ID = eINSTANCE.getUser_Id();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LEVEL = eINSTANCE.getUser_Level();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__SOURCE = eINSTANCE.getUser_Source();

		/**
		 * The meta object literal for the '<em><b>Uid Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__UID_SRC = eINSTANCE.getUser_UidSrc();

		/**
		 * The meta object literal for the '<em><b>Xp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__XP = eINSTANCE.getUser_Xp();

	}

} //ModelPackage
