package com.mangogames.rummy.model.impl;

import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.ModelPackage;

import com.mangogames.rummy.model.impl.BotModel;

import org.eclipse.emf.ecore.EClass;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bot Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BotPlayerImpl extends PlayerImpl implements BotPlayer 
{
	/**
	 * Custom code
	 */
	BotModel botModel;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BotPlayerImpl()
	{
		super();
		botModel = new BotModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() 
	{
		return ModelPackage.Literals.BOT_PLAYER;
	}
	
	public BotModel getBotModel()
	{
		return botModel;
	}
} //BotPlayerImpl
