/**
 */
package com.mangogames.rummy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.mangogames.rummy.model.Seat#getPlayer <em>Player</em>}</li>
 *   <li>{@link com.mangogames.rummy.model.Seat#getSeatId <em>Seat Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.mangogames.rummy.model.ModelPackage#getSeat()
 * @model extendedMetaData="name='Seat' kind='elementOnly'"
 * @generated
 */
public interface Seat extends EObject {
	/**
	 * Returns the value of the '<em><b>Player</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Player</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' reference.
	 * @see #setPlayer(EObject)
	 * @see com.mangogames.rummy.model.ModelPackage#getSeat_Player()
	 * @model resolveProxies="false"
	 *        extendedMetaData="kind='element' name='player' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getPlayer();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Seat#getPlayer <em>Player</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player</em>' reference.
	 * @see #getPlayer()
	 * @generated
	 */
	void setPlayer(EObject value);

	/**
	 * Returns the value of the '<em><b>Seat Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seat Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seat Id</em>' attribute.
	 * @see #isSetSeatId()
	 * @see #unsetSeatId()
	 * @see #setSeatId(int)
	 * @see com.mangogames.rummy.model.ModelPackage#getSeat_SeatId()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='seat_id'"
	 * @generated
	 */
	int getSeatId();

	/**
	 * Sets the value of the '{@link com.mangogames.rummy.model.Seat#getSeatId <em>Seat Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seat Id</em>' attribute.
	 * @see #isSetSeatId()
	 * @see #unsetSeatId()
	 * @see #getSeatId()
	 * @generated
	 */
	void setSeatId(int value);

	/**
	 * Unsets the value of the '{@link com.mangogames.rummy.model.Seat#getSeatId <em>Seat Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSeatId()
	 * @see #getSeatId()
	 * @see #setSeatId(int)
	 * @generated
	 */
	void unsetSeatId();

	/**
	 * Returns whether the value of the '{@link com.mangogames.rummy.model.Seat#getSeatId <em>Seat Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Seat Id</em>' attribute is set.
	 * @see #unsetSeatId()
	 * @see #getSeatId()
	 * @see #setSeatId(int)
	 * @generated
	 */
	boolean isSetSeatId();

} // Seat
