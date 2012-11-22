/**
 */
package com.mangogames.rummy.model;

import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deal Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.DealPlayer#getHandcards <em>Handcards</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DealPlayer#getScore <em>Score</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DealPlayer#getMissedTurnCount <em>Missed Turn Count</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DealPlayer#getState <em>State</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DealPlayer#getTimeOfJoining <em>Time Of Joining</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.DealPlayer#isWinner <em>Winner</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer()
 * @model extendedMetaData="name='DealPlayer' kind='elementOnly'"
 * @generated
 */
public interface DealPlayer extends Player {
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
	 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer_Handcards()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='handcards' namespace='##targetNamespace'"
	 * @generated
	 */
	HandCards getHandcards();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getHandcards <em>Handcards</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handcards</em>' containment reference.
	 * @see #getHandcards()
	 * @generated
	 */
	void setHandcards(HandCards value);

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
	 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer_Score()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='score' namespace='##targetNamespace'"
	 * @generated
	 */
	Score getScore();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getScore <em>Score</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' containment reference.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(Score value);

	/**
	 * Returns the value of the '<em><b>Missed Turn Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Missed Turn Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Missed Turn Count</em>' attribute.
	 * @see #isSetMissedTurnCount()
	 * @see #unsetMissedTurnCount()
	 * @see #setMissedTurnCount(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer_MissedTurnCount()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='missed_turn_count'"
	 * @generated
	 */
	int getMissedTurnCount();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getMissedTurnCount <em>Missed Turn Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Missed Turn Count</em>' attribute.
	 * @see #isSetMissedTurnCount()
	 * @see #unsetMissedTurnCount()
	 * @see #getMissedTurnCount()
	 * @generated
	 */
	void setMissedTurnCount(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getMissedTurnCount <em>Missed Turn Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMissedTurnCount()
	 * @see #getMissedTurnCount()
	 * @see #setMissedTurnCount(int)
	 * @generated
	 */
	void unsetMissedTurnCount();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.DealPlayer#getMissedTurnCount <em>Missed Turn Count</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Missed Turn Count</em>' attribute is set.
	 * @see #unsetMissedTurnCount()
	 * @see #getMissedTurnCount()
	 * @see #setMissedTurnCount(int)
	 * @generated
	 */
	boolean isSetMissedTurnCount();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer_State()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='state'"
	 * @generated
	 */
	int getState();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(int)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.DealPlayer#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(int)
	 * @generated
	 */
	boolean isSetState();

	/**
	 * Returns the value of the '<em><b>Time Of Joining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Of Joining</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Of Joining</em>' attribute.
	 * @see #setTimeOfJoining(String)
	 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer_TimeOfJoining()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='time_of_joining'"
	 * @generated
	 */
	String getTimeOfJoining();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DealPlayer#getTimeOfJoining <em>Time Of Joining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Of Joining</em>' attribute.
	 * @see #getTimeOfJoining()
	 * @generated
	 */
	void setTimeOfJoining(String value);
	
	/**
	 * Returns the value of the '<em><b>Winner</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Winner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Winner</em>' attribute.
	 * @see #isSetWinner()
	 * @see #unsetWinner()
	 * @see #setWinner(boolean)
	 * @see com.mangogames.rummy.model.ModelPackage#getDealPlayer_Winner()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='winner'"
	 * @generated
	 */
	boolean isWinner();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.DealPlayer#isWinner <em>Winner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Winner</em>' attribute.
	 * @see #isSetWinner()
	 * @see #unsetWinner()
	 * @see #isWinner()
	 * @generated
	 */
	void setWinner(boolean value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.DealPlayer#isWinner <em>Winner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWinner()
	 * @see #isWinner()
	 * @see #setWinner(boolean)
	 * @generated
	 */
	void unsetWinner();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.DealPlayer#isWinner <em>Winner</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Winner</em>' attribute is set.
	 * @see #unsetWinner()
	 * @see #isWinner()
	 * @see #setWinner(boolean)
	 * @generated
	 */
	boolean isSetWinner();

	List<Integer> getHighLights();
	
    void updateState(int state);
    
    /** ACTIVE, DROPPED, DONE_WOTH_SHOW, LOST_GAME, DISCONNECTED are mutually exclusive. Only one can be set
     *  These first 5 values identify the players active state in the game.
     *  The first set is represented in the last two bytes */
    //set 1
   
    public static final int PICKED         = 0x0001;
    public static final int ACTIVE         = 0x0100; /// hex 1
    public static final int DROPPED        = 0x0200; //Active and dropped are mutually exclusive
    public static final int DONE_WITH_SHOW = 0x0400;
    public static final int LOST_GAME      = 0x0800;
    public static final int DISCONNECTED   = 0x1000;
   
    public static final int ACTIVITY_TRACK = 0x00FF;
    public static final int STATE_TRACK    = 0xFF00;
    /* This set represents the actions of the player in a game. Currently only one action is required to be tracked */
    //PLAYING IS ALWAYS TRUE
   
    boolean isPlaying();
    boolean isDoneWithShow();
    boolean isDropped();
    boolean hasLostTheGame();
    boolean hasPickedACard();
    
    /**
	 * Add a card to the players handcards. 
	 * This method will send a notification to the BotPlayerAdapter
	 * @param card
	 */
	public void addCard(Card card);
} // DealPlayer
