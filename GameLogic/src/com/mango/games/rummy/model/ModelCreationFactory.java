package com.mango.games.rummy.model;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.inject.Inject;
import com.mango.games.rummy.logic.common.LogicAdapterFactory;
import com.mango.games.rummy.utils.Log;
import com.mangogames.rummy.model.BotInfo;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.ClosedDeck;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.DocumentRoot;
import com.mangogames.rummy.model.FixedPrizeGame;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.Joker;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.ModelFactory;
import com.mangogames.rummy.model.ModelPackage;
import com.mangogames.rummy.model.OpenDeck;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.PointsGame;
import com.mangogames.rummy.model.PokerRummyGame;
import com.mangogames.rummy.model.Score;
import com.mangogames.rummy.model.Seat;
import com.mangogames.rummy.model.SyndicateGame;
import com.mangogames.rummy.model.User;
import com.mangogames.rummy.model.impl.ModelFactoryImpl;
import com.mangogames.rummy.model.impl.ModelPackageImpl;
import com.mangogames.rummy.model.util.ModelResourceFactoryImpl;

public class ModelCreationFactory implements IModelCreationFactory
{
	 private ResourceSet          resourceSet    = null;
             Resource             resource       = null;
	 private ModelFactory         factory        = null;
	 
	 private LogicAdapterFactory  adptrFactry;
	 
	 @Inject
	 public ModelCreationFactory(LogicAdapterFactory afctry )
	 {
		 this.adptrFactry = afctry;
		 
		 this.createResource();
	 }
	 
	 /**
		 * Returns the resource set.
		 * @param 
		 * @return
	*/
	private ResourceSet getResourceSet() 
	{
		if(resourceSet == null)
	    {
			ModelPackageImpl.init();
			// Register the XMI resource factory for the .ufrm extension
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map m = reg.getExtensionToFactoryMap();
			m.put("*", new ModelResourceFactoryImpl());
			
			// Obtain a new resource set
			resourceSet = new ResourceSetImpl();
			
		 
		  /* This is a wrong pattern, where the LogicAdapterFactory is hardcoded into the model extensions.
		  * Ideally a dependency injection or other detached pattern should be used.
		  * But I'm doing it for quick turnaround, and will revisit later.
		  * TODO - check the notes above.
		  * */
			resourceSet.getAdapterFactories().add(this.adptrFactry);
		}
		
		return  resourceSet;
	}
	
	/**
	 * Creates a resource to contain the form. The resource file does not exist yet.
	 * @param path
	 * @return
	 */
	private Resource createResource()
	{
		System.out.println("*************************************");
		
		if (resource == null) 
		{
			System.out.println("Resource Set " + getResourceSet());
			resource = getResourceSet().createResource(URI.createURI( ModelPackage.eNS_URI )); 
		}
		
		return resource;
	}
	
	public DocumentRoot getDocumentRoot()
	{
		DocumentRoot root = null;
		if( resource != null )
		{
			EList<?> list = resource.getContents();
		
			if( list.size()> 0)
			{
				if( list.get(0) instanceof DocumentRoot )
			        root = (DocumentRoot)list.get(0);
				else
				{
					//TODO - Log error here
				}
			}
			
			if( root == null )
			{
				root = getFactory().createDocumentRoot();
				resource.getContents().add(root);
			}
		}
		return root;
	}
		
	 
	 public ModelFactory getFactory()
	 {
		 if( factory == null )
		  {
			 Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("game", new ModelFactoryImpl());
			  
			 ModelPackage.eINSTANCE.eClass();
			  
		     Map<?, ?> registry = EPackage.Registry.INSTANCE;
			 String formURI = ModelPackage.eNS_URI;
			 ModelPackage nPackage = (ModelPackage) registry.get(formURI);
			 factory = nPackage.getModelFactory();
		  }
 		  
		 return factory;
	 }
	 
	 public Object createObject(Class<?> targetClass) 
	 {
			ModelFactory factory = getFactory();
				
			Object	result = null;
			
			if(targetClass.equals(Card.class))
			{
				result = factory.createCard();
			}
			else if(targetClass.equals(ClosedDeck.class))
			{
				result = factory.createClosedDeck();
			}
			else if(targetClass.equals(Deal.class))
			{
				result = factory.createDeal();
			}
			else if(targetClass.equals(DealPlayer.class))
			{
				result = factory.createDealPlayer();
			}
			else if(targetClass.equals(FixedPrizeGame.class))
			{
				result = factory.createFixedPrizeGame();
			}
			else if(targetClass.equals(GroupCards.class))
			{
				result = factory.createGroupCards();
			}
			else if(targetClass.equals(HandCards.class))
			{
				result = factory.createHandCards();
			}
			else if(targetClass.equals(Joker.class))
			{
				result = factory.createJoker();
			}
			else if(targetClass.equals(Match.class))
			{
				result = factory.createMatch();
			}
			else if(targetClass.equals(MatchPlayer.class))
			{
				result = factory.createMatchPlayer();
			}
			else if(targetClass.equals(OpenDeck.class))
			{
				result = factory.createOpenDeck();
			}
			else if(targetClass.equals(Player.class))
			{
				result = factory.createPlayer();
			}
			else if(targetClass.equals(PointsGame.class))
			{
				result = factory.createPointsGame();
			}
			else if(targetClass.equals(PokerRummyGame.class))
			{
				result = factory.createPokerRummyGame();
			}
			else if(targetClass.equals(Score.class))
			{
				result = factory.createScore();
			}
			else if(targetClass.equals(Seat.class))
			{
				result = factory.createSeat();
			}
			else if(targetClass.equals(SyndicateGame.class))
			{
				result = factory.createSyndicateGame();
			}
			else if(targetClass.equals(User.class))
			{
				result = factory.createUser();
			}
			else if(targetClass.equals(BotInfo.class))
			{
				result = factory.createBotInfo();
			}
			else if(targetClass.equals(BotPlayer.class))
			{
				result = factory.createBotPlayer();
			}
			
			return result;
		}
	}