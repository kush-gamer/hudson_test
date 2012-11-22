/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.mangogames.rummy.model.impl.BotModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getBotinfo <em>Botinfo</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getBotPlayer <em>Bot Player</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getCard <em>Card</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getCloseddeck <em>Closeddeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getDeal <em>Deal</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getDealplayer <em>Dealplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getFixedprizegame <em>Fixedprizegame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getGame <em>Game</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getGroups <em>Groups</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getHandcards <em>Handcards</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getJoker <em>Joker</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getMatch <em>Match</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getMatchplayer <em>Matchplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getOpendeck <em>Opendeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getPlayer <em>Player</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getPointsgame <em>Pointsgame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getPokerrummygame <em>Pokerrummygame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getPrize <em>Prize</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getScore <em>Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getSeat <em>Seat</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getSettlement <em>Settlement</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getSyndicategame <em>Syndicategame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getTestgame <em>Testgame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DocumentRoot#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Botinfo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Botinfo</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Botinfo</em>' containment reference.
	 * @see #setBotinfo(BotInfo)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Botinfo()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='botinfo' namespace='##targetNamespace'"
	 * @generated
	 */
	BotInfo getBotinfo();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getBotinfo <em>Botinfo</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Botinfo</em>' containment reference.
	 * @see #getBotinfo()
	 * @generated
	 */
	void setBotinfo(BotInfo value);

	/**
	 * Returns the value of the '<em><b>Bot Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bot Player</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bot Player</em>' containment reference.
	 * @see #setBotPlayer(BotPlayer)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_BotPlayer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='botPlayer' namespace='##targetNamespace'"
	 * @generated
	 */
	BotPlayer getBotPlayer();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getBotPlayer <em>Bot Player</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bot Player</em>' containment reference.
	 * @see #getBotPlayer()
	 * @generated
	 */
	void setBotPlayer(BotPlayer value);

	/**
	 * Returns the value of the '<em><b>Card</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Card</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Card</em>' containment reference.
	 * @see #setCard(Card)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Card()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='card' namespace='##targetNamespace'"
	 * @generated
	 */
	Card getCard();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getCard <em>Card</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Card</em>' containment reference.
	 * @see #getCard()
	 * @generated
	 */
	void setCard(Card value);

	/**
	 * Returns the value of the '<em><b>Closeddeck</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closeddeck</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closeddeck</em>' containment reference.
	 * @see #setCloseddeck(ClosedDeck)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Closeddeck()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='closeddeck' namespace='##targetNamespace'"
	 * @generated
	 */
	ClosedDeck getCloseddeck();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getCloseddeck <em>Closeddeck</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closeddeck</em>' containment reference.
	 * @see #getCloseddeck()
	 * @generated
	 */
	void setCloseddeck(ClosedDeck value);

	/**
	 * Returns the value of the '<em><b>Deal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deal</em>' containment reference.
	 * @see #setDeal(Deal)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Deal()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='deal' namespace='##targetNamespace'"
	 * @generated
	 */
	Deal getDeal();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getDeal <em>Deal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deal</em>' containment reference.
	 * @see #getDeal()
	 * @generated
	 */
	void setDeal(Deal value);

	/**
	 * Returns the value of the '<em><b>Dealplayer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dealplayer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dealplayer</em>' containment reference.
	 * @see #setDealplayer(DealPlayer)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Dealplayer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='dealplayer' namespace='##targetNamespace'"
	 * @generated
	 */
	DealPlayer getDealplayer();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getDealplayer <em>Dealplayer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dealplayer</em>' containment reference.
	 * @see #getDealplayer()
	 * @generated
	 */
	void setDealplayer(DealPlayer value);

	/**
	 * Returns the value of the '<em><b>Fixedprizegame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixedprizegame</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixedprizegame</em>' containment reference.
	 * @see #setFixedprizegame(FixedPrizeGame)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Fixedprizegame()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fixedprizegame' namespace='##targetNamespace'"
	 * @generated
	 */
	FixedPrizeGame getFixedprizegame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getFixedprizegame <em>Fixedprizegame</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixedprizegame</em>' containment reference.
	 * @see #getFixedprizegame()
	 * @generated
	 */
	void setFixedprizegame(FixedPrizeGame value);

	/**
	 * Returns the value of the '<em><b>Game</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Game</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game</em>' containment reference.
	 * @see #setGame(Game)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Game()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='game' namespace='##targetNamespace'"
	 * @generated
	 */
	Game getGame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getGame <em>Game</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game</em>' containment reference.
	 * @see #getGame()
	 * @generated
	 */
	void setGame(Game value);

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference.
	 * @see #setGroups(GroupCards)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Groups()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='groups' namespace='##targetNamespace'"
	 * @generated
	 */
	GroupCards getGroups();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getGroups <em>Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Groups</em>' containment reference.
	 * @see #getGroups()
	 * @generated
	 */
	void setGroups(GroupCards value);

	/**
	 * Returns the value of the '<em><b>Handcards</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handcards</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handcards</em>' containment reference.
	 * @see #setHandcards(HandCards)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Handcards()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='handcards' namespace='##targetNamespace'"
	 * @generated
	 */
	HandCards getHandcards();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getHandcards <em>Handcards</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handcards</em>' containment reference.
	 * @see #getHandcards()
	 * @generated
	 */
	void setHandcards(HandCards value);

	/**
	 * Returns the value of the '<em><b>Joker</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Joker</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Joker</em>' containment reference.
	 * @see #setJoker(Joker)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Joker()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='joker' namespace='##targetNamespace'"
	 * @generated
	 */
	Joker getJoker();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getJoker <em>Joker</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Joker</em>' containment reference.
	 * @see #getJoker()
	 * @generated
	 */
	void setJoker(Joker value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' containment reference.
	 * @see #setMatch(Match)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Match()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='match' namespace='##targetNamespace'"
	 * @generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getMatch <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' containment reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Matchplayer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matchplayer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matchplayer</em>' containment reference.
	 * @see #setMatchplayer(MatchPlayer)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Matchplayer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='matchplayer' namespace='##targetNamespace'"
	 * @generated
	 */
	MatchPlayer getMatchplayer();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getMatchplayer <em>Matchplayer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matchplayer</em>' containment reference.
	 * @see #getMatchplayer()
	 * @generated
	 */
	void setMatchplayer(MatchPlayer value);

	/**
	 * Returns the value of the '<em><b>Opendeck</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opendeck</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opendeck</em>' containment reference.
	 * @see #setOpendeck(OpenDeck)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Opendeck()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='opendeck' namespace='##targetNamespace'"
	 * @generated
	 */
	OpenDeck getOpendeck();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getOpendeck <em>Opendeck</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opendeck</em>' containment reference.
	 * @see #getOpendeck()
	 * @generated
	 */
	void setOpendeck(OpenDeck value);

	/**
	 * Returns the value of the '<em><b>Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Player</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' containment reference.
	 * @see #setPlayer(Player)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Player()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='player' namespace='##targetNamespace'"
	 * @generated
	 */
	Player getPlayer();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getPlayer <em>Player</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player</em>' containment reference.
	 * @see #getPlayer()
	 * @generated
	 */
	void setPlayer(Player value);

	/**
	 * Returns the value of the '<em><b>Pointsgame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointsgame</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointsgame</em>' containment reference.
	 * @see #setPointsgame(PointsGame)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Pointsgame()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='pointsgame' namespace='##targetNamespace'"
	 * @generated
	 */
	PointsGame getPointsgame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getPointsgame <em>Pointsgame</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pointsgame</em>' containment reference.
	 * @see #getPointsgame()
	 * @generated
	 */
	void setPointsgame(PointsGame value);

	/**
	 * Returns the value of the '<em><b>Pokerrummygame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pokerrummygame</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pokerrummygame</em>' containment reference.
	 * @see #setPokerrummygame(PokerRummyGame)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Pokerrummygame()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='pokerrummygame' namespace='##targetNamespace'"
	 * @generated
	 */
	PokerRummyGame getPokerrummygame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getPokerrummygame <em>Pokerrummygame</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pokerrummygame</em>' containment reference.
	 * @see #getPokerrummygame()
	 * @generated
	 */
	void setPokerrummygame(PokerRummyGame value);

	/**
	 * Returns the value of the '<em><b>Prize</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prize</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prize</em>' containment reference.
	 * @see #setPrize(Prize)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Prize()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='prize' namespace='##targetNamespace'"
	 * @generated
	 */
	Prize getPrize();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getPrize <em>Prize</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prize</em>' containment reference.
	 * @see #getPrize()
	 * @generated
	 */
	void setPrize(Prize value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' containment reference.
	 * @see #setScore(Score)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Score()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='score' namespace='##targetNamespace'"
	 * @generated
	 */
	Score getScore();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getScore <em>Score</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' containment reference.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(Score value);

	/**
	 * Returns the value of the '<em><b>Seat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seat</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seat</em>' containment reference.
	 * @see #setSeat(Seat)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Seat()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='seat' namespace='##targetNamespace'"
	 * @generated
	 */
	Seat getSeat();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getSeat <em>Seat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seat</em>' containment reference.
	 * @see #getSeat()
	 * @generated
	 */
	void setSeat(Seat value);

	/**
	 * Returns the value of the '<em><b>Settlement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settlement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settlement</em>' containment reference.
	 * @see #setSettlement(Settlement)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Settlement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='settlement' namespace='##targetNamespace'"
	 * @generated
	 */
	Settlement getSettlement();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getSettlement <em>Settlement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settlement</em>' containment reference.
	 * @see #getSettlement()
	 * @generated
	 */
	void setSettlement(Settlement value);

	/**
	 * Returns the value of the '<em><b>Syndicategame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syndicategame</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syndicategame</em>' containment reference.
	 * @see #setSyndicategame(SyndicateGame)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Syndicategame()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='syndicategame' namespace='##targetNamespace'"
	 * @generated
	 */
	SyndicateGame getSyndicategame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getSyndicategame <em>Syndicategame</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syndicategame</em>' containment reference.
	 * @see #getSyndicategame()
	 * @generated
	 */
	void setSyndicategame(SyndicateGame value);

	/**
	 * Returns the value of the '<em><b>Testgame</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testgame</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testgame</em>' containment reference.
	 * @see #setTestgame(TestGame)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_Testgame()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='testgame' namespace='##targetNamespace'"
	 * @generated
	 */
	TestGame getTestgame();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getTestgame <em>Testgame</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testgame</em>' containment reference.
	 * @see #getTestgame()
	 * @generated
	 */
	void setTestgame(TestGame value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' containment reference.
	 * @see #setUser(User)
	 * @see com.mangogames.rummy.model.ModelPackage#getDocumentRoot_User()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='user' namespace='##targetNamespace'"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DocumentRoot#getUser <em>User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' containment reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

} // DocumentRoot
