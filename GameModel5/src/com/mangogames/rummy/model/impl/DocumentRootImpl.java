/**
 */
package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.BotInfo;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Card;
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
import com.mangogames.rummy.model.ModelPackage;
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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getBotinfo <em>Botinfo</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getBotPlayer <em>Bot Player</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getCard <em>Card</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getCloseddeck <em>Closeddeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getDeal <em>Deal</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getDealplayer <em>Dealplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getFixedprizegame <em>Fixedprizegame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getGame <em>Game</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getHandcards <em>Handcards</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getJoker <em>Joker</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getMatchplayer <em>Matchplayer</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getOpendeck <em>Opendeck</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getPointsgame <em>Pointsgame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getPokerrummygame <em>Pokerrummygame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getPrize <em>Prize</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getScore <em>Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getSeat <em>Seat</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getSettlement <em>Settlement</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getSyndicategame <em>Syndicategame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getTestgame <em>Testgame</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.impl.DocumentRootImpl#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, ModelPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BotInfo getBotinfo() {
		return (BotInfo)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__BOTINFO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBotinfo(BotInfo newBotinfo, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__BOTINFO, newBotinfo, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBotinfo(BotInfo newBotinfo) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__BOTINFO, newBotinfo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BotPlayer getBotPlayer() {
		return (BotPlayer)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__BOT_PLAYER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBotPlayer(BotPlayer newBotPlayer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__BOT_PLAYER, newBotPlayer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBotPlayer(BotPlayer newBotPlayer) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__BOT_PLAYER, newBotPlayer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Card getCard() {
		return (Card)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__CARD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCard(Card newCard, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__CARD, newCard, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCard(Card newCard) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__CARD, newCard);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClosedDeck getCloseddeck() {
		return (ClosedDeck)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__CLOSEDDECK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCloseddeck(ClosedDeck newCloseddeck, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__CLOSEDDECK, newCloseddeck, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloseddeck(ClosedDeck newCloseddeck) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__CLOSEDDECK, newCloseddeck);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deal getDeal() {
		return (Deal)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__DEAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeal(Deal newDeal, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__DEAL, newDeal, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeal(Deal newDeal) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__DEAL, newDeal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DealPlayer getDealplayer() {
		return (DealPlayer)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__DEALPLAYER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDealplayer(DealPlayer newDealplayer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__DEALPLAYER, newDealplayer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDealplayer(DealPlayer newDealplayer) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__DEALPLAYER, newDealplayer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPrizeGame getFixedprizegame() {
		return (FixedPrizeGame)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__FIXEDPRIZEGAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFixedprizegame(FixedPrizeGame newFixedprizegame, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__FIXEDPRIZEGAME, newFixedprizegame, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedprizegame(FixedPrizeGame newFixedprizegame) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__FIXEDPRIZEGAME, newFixedprizegame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Game getGame() {
		return (Game)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__GAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGame(Game newGame, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__GAME, newGame, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGame(Game newGame) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__GAME, newGame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupCards getGroups() {
		return (GroupCards)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroups(GroupCards newGroups, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__GROUPS, newGroups, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroups(GroupCards newGroups) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__GROUPS, newGroups);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandCards getHandcards() {
		return (HandCards)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__HANDCARDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHandcards(HandCards newHandcards, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__HANDCARDS, newHandcards, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandcards(HandCards newHandcards) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__HANDCARDS, newHandcards);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Joker getJoker() {
		return (Joker)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__JOKER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJoker(Joker newJoker, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__JOKER, newJoker, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoker(Joker newJoker) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__JOKER, newJoker);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getMatch() {
		return (Match)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__MATCH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatch(Match newMatch, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__MATCH, newMatch, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(Match newMatch) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__MATCH, newMatch);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchPlayer getMatchplayer() {
		return (MatchPlayer)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__MATCHPLAYER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatchplayer(MatchPlayer newMatchplayer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__MATCHPLAYER, newMatchplayer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchplayer(MatchPlayer newMatchplayer) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__MATCHPLAYER, newMatchplayer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenDeck getOpendeck() {
		return (OpenDeck)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__OPENDECK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpendeck(OpenDeck newOpendeck, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__OPENDECK, newOpendeck, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpendeck(OpenDeck newOpendeck) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__OPENDECK, newOpendeck);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getPlayer() {
		return (Player)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__PLAYER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayer(Player newPlayer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__PLAYER, newPlayer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayer(Player newPlayer) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__PLAYER, newPlayer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointsGame getPointsgame() {
		return (PointsGame)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__POINTSGAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPointsgame(PointsGame newPointsgame, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__POINTSGAME, newPointsgame, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointsgame(PointsGame newPointsgame) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__POINTSGAME, newPointsgame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PokerRummyGame getPokerrummygame() {
		return (PokerRummyGame)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__POKERRUMMYGAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPokerrummygame(PokerRummyGame newPokerrummygame, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__POKERRUMMYGAME, newPokerrummygame, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPokerrummygame(PokerRummyGame newPokerrummygame) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__POKERRUMMYGAME, newPokerrummygame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prize getPrize() {
		return (Prize)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__PRIZE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrize(Prize newPrize, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__PRIZE, newPrize, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrize(Prize newPrize) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__PRIZE, newPrize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Score getScore() {
		return (Score)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__SCORE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScore(Score newScore, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__SCORE, newScore, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(Score newScore) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__SCORE, newScore);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seat getSeat() {
		return (Seat)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__SEAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeat(Seat newSeat, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__SEAT, newSeat, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeat(Seat newSeat) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__SEAT, newSeat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settlement getSettlement() {
		return (Settlement)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__SETTLEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSettlement(Settlement newSettlement, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__SETTLEMENT, newSettlement, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettlement(Settlement newSettlement) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__SETTLEMENT, newSettlement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyndicateGame getSyndicategame() {
		return (SyndicateGame)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__SYNDICATEGAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSyndicategame(SyndicateGame newSyndicategame, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__SYNDICATEGAME, newSyndicategame, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyndicategame(SyndicateGame newSyndicategame) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__SYNDICATEGAME, newSyndicategame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestGame getTestgame() {
		return (TestGame)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__TESTGAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestgame(TestGame newTestgame, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__TESTGAME, newTestgame, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestgame(TestGame newTestgame) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__TESTGAME, newTestgame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		return (User)getMixed().get(ModelPackage.Literals.DOCUMENT_ROOT__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUser(User newUser, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ModelPackage.Literals.DOCUMENT_ROOT__USER, newUser, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		((FeatureMap.Internal)getMixed()).set(ModelPackage.Literals.DOCUMENT_ROOT__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case ModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case ModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case ModelPackage.DOCUMENT_ROOT__BOTINFO:
				return basicSetBotinfo(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__BOT_PLAYER:
				return basicSetBotPlayer(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__CARD:
				return basicSetCard(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__CLOSEDDECK:
				return basicSetCloseddeck(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__DEAL:
				return basicSetDeal(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__DEALPLAYER:
				return basicSetDealplayer(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__FIXEDPRIZEGAME:
				return basicSetFixedprizegame(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__GAME:
				return basicSetGame(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__GROUPS:
				return basicSetGroups(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__HANDCARDS:
				return basicSetHandcards(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__JOKER:
				return basicSetJoker(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__MATCH:
				return basicSetMatch(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__MATCHPLAYER:
				return basicSetMatchplayer(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__OPENDECK:
				return basicSetOpendeck(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__PLAYER:
				return basicSetPlayer(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__POINTSGAME:
				return basicSetPointsgame(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__POKERRUMMYGAME:
				return basicSetPokerrummygame(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__PRIZE:
				return basicSetPrize(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__SCORE:
				return basicSetScore(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__SEAT:
				return basicSetSeat(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__SETTLEMENT:
				return basicSetSettlement(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__SYNDICATEGAME:
				return basicSetSyndicategame(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__TESTGAME:
				return basicSetTestgame(null, msgs);
			case ModelPackage.DOCUMENT_ROOT__USER:
				return basicSetUser(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case ModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case ModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case ModelPackage.DOCUMENT_ROOT__BOTINFO:
				return getBotinfo();
			case ModelPackage.DOCUMENT_ROOT__BOT_PLAYER:
				return getBotPlayer();
			case ModelPackage.DOCUMENT_ROOT__CARD:
				return getCard();
			case ModelPackage.DOCUMENT_ROOT__CLOSEDDECK:
				return getCloseddeck();
			case ModelPackage.DOCUMENT_ROOT__DEAL:
				return getDeal();
			case ModelPackage.DOCUMENT_ROOT__DEALPLAYER:
				return getDealplayer();
			case ModelPackage.DOCUMENT_ROOT__FIXEDPRIZEGAME:
				return getFixedprizegame();
			case ModelPackage.DOCUMENT_ROOT__GAME:
				return getGame();
			case ModelPackage.DOCUMENT_ROOT__GROUPS:
				return getGroups();
			case ModelPackage.DOCUMENT_ROOT__HANDCARDS:
				return getHandcards();
			case ModelPackage.DOCUMENT_ROOT__JOKER:
				return getJoker();
			case ModelPackage.DOCUMENT_ROOT__MATCH:
				return getMatch();
			case ModelPackage.DOCUMENT_ROOT__MATCHPLAYER:
				return getMatchplayer();
			case ModelPackage.DOCUMENT_ROOT__OPENDECK:
				return getOpendeck();
			case ModelPackage.DOCUMENT_ROOT__PLAYER:
				return getPlayer();
			case ModelPackage.DOCUMENT_ROOT__POINTSGAME:
				return getPointsgame();
			case ModelPackage.DOCUMENT_ROOT__POKERRUMMYGAME:
				return getPokerrummygame();
			case ModelPackage.DOCUMENT_ROOT__PRIZE:
				return getPrize();
			case ModelPackage.DOCUMENT_ROOT__SCORE:
				return getScore();
			case ModelPackage.DOCUMENT_ROOT__SEAT:
				return getSeat();
			case ModelPackage.DOCUMENT_ROOT__SETTLEMENT:
				return getSettlement();
			case ModelPackage.DOCUMENT_ROOT__SYNDICATEGAME:
				return getSyndicategame();
			case ModelPackage.DOCUMENT_ROOT__TESTGAME:
				return getTestgame();
			case ModelPackage.DOCUMENT_ROOT__USER:
				return getUser();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__BOTINFO:
				setBotinfo((BotInfo)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__BOT_PLAYER:
				setBotPlayer((BotPlayer)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__CARD:
				setCard((Card)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__CLOSEDDECK:
				setCloseddeck((ClosedDeck)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__DEAL:
				setDeal((Deal)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__DEALPLAYER:
				setDealplayer((DealPlayer)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__FIXEDPRIZEGAME:
				setFixedprizegame((FixedPrizeGame)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__GAME:
				setGame((Game)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__GROUPS:
				setGroups((GroupCards)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__HANDCARDS:
				setHandcards((HandCards)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__JOKER:
				setJoker((Joker)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__MATCH:
				setMatch((Match)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__MATCHPLAYER:
				setMatchplayer((MatchPlayer)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__OPENDECK:
				setOpendeck((OpenDeck)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__PLAYER:
				setPlayer((Player)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__POINTSGAME:
				setPointsgame((PointsGame)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__POKERRUMMYGAME:
				setPokerrummygame((PokerRummyGame)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__PRIZE:
				setPrize((Prize)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__SCORE:
				setScore((Score)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__SEAT:
				setSeat((Seat)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__SETTLEMENT:
				setSettlement((Settlement)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__SYNDICATEGAME:
				setSyndicategame((SyndicateGame)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__TESTGAME:
				setTestgame((TestGame)newValue);
				return;
			case ModelPackage.DOCUMENT_ROOT__USER:
				setUser((User)newValue);
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
			case ModelPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case ModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case ModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case ModelPackage.DOCUMENT_ROOT__BOTINFO:
				setBotinfo((BotInfo)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__BOT_PLAYER:
				setBotPlayer((BotPlayer)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__CARD:
				setCard((Card)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__CLOSEDDECK:
				setCloseddeck((ClosedDeck)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__DEAL:
				setDeal((Deal)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__DEALPLAYER:
				setDealplayer((DealPlayer)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__FIXEDPRIZEGAME:
				setFixedprizegame((FixedPrizeGame)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__GAME:
				setGame((Game)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__GROUPS:
				setGroups((GroupCards)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__HANDCARDS:
				setHandcards((HandCards)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__JOKER:
				setJoker((Joker)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__MATCH:
				setMatch((Match)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__MATCHPLAYER:
				setMatchplayer((MatchPlayer)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__OPENDECK:
				setOpendeck((OpenDeck)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__PLAYER:
				setPlayer((Player)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__POINTSGAME:
				setPointsgame((PointsGame)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__POKERRUMMYGAME:
				setPokerrummygame((PokerRummyGame)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__PRIZE:
				setPrize((Prize)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__SCORE:
				setScore((Score)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__SEAT:
				setSeat((Seat)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__SETTLEMENT:
				setSettlement((Settlement)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__SYNDICATEGAME:
				setSyndicategame((SyndicateGame)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__TESTGAME:
				setTestgame((TestGame)null);
				return;
			case ModelPackage.DOCUMENT_ROOT__USER:
				setUser((User)null);
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
			case ModelPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case ModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case ModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case ModelPackage.DOCUMENT_ROOT__BOTINFO:
				return getBotinfo() != null;
			case ModelPackage.DOCUMENT_ROOT__BOT_PLAYER:
				return getBotPlayer() != null;
			case ModelPackage.DOCUMENT_ROOT__CARD:
				return getCard() != null;
			case ModelPackage.DOCUMENT_ROOT__CLOSEDDECK:
				return getCloseddeck() != null;
			case ModelPackage.DOCUMENT_ROOT__DEAL:
				return getDeal() != null;
			case ModelPackage.DOCUMENT_ROOT__DEALPLAYER:
				return getDealplayer() != null;
			case ModelPackage.DOCUMENT_ROOT__FIXEDPRIZEGAME:
				return getFixedprizegame() != null;
			case ModelPackage.DOCUMENT_ROOT__GAME:
				return getGame() != null;
			case ModelPackage.DOCUMENT_ROOT__GROUPS:
				return getGroups() != null;
			case ModelPackage.DOCUMENT_ROOT__HANDCARDS:
				return getHandcards() != null;
			case ModelPackage.DOCUMENT_ROOT__JOKER:
				return getJoker() != null;
			case ModelPackage.DOCUMENT_ROOT__MATCH:
				return getMatch() != null;
			case ModelPackage.DOCUMENT_ROOT__MATCHPLAYER:
				return getMatchplayer() != null;
			case ModelPackage.DOCUMENT_ROOT__OPENDECK:
				return getOpendeck() != null;
			case ModelPackage.DOCUMENT_ROOT__PLAYER:
				return getPlayer() != null;
			case ModelPackage.DOCUMENT_ROOT__POINTSGAME:
				return getPointsgame() != null;
			case ModelPackage.DOCUMENT_ROOT__POKERRUMMYGAME:
				return getPokerrummygame() != null;
			case ModelPackage.DOCUMENT_ROOT__PRIZE:
				return getPrize() != null;
			case ModelPackage.DOCUMENT_ROOT__SCORE:
				return getScore() != null;
			case ModelPackage.DOCUMENT_ROOT__SEAT:
				return getSeat() != null;
			case ModelPackage.DOCUMENT_ROOT__SETTLEMENT:
				return getSettlement() != null;
			case ModelPackage.DOCUMENT_ROOT__SYNDICATEGAME:
				return getSyndicategame() != null;
			case ModelPackage.DOCUMENT_ROOT__TESTGAME:
				return getTestgame() != null;
			case ModelPackage.DOCUMENT_ROOT__USER:
				return getUser() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
