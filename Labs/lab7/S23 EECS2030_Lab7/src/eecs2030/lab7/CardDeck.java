package eecs2030.lab7;

import java.util.Collection;
import java.util.Iterator;

/** 
 * Implements a deck of 52 cards, e.g., for a poker game
 * @author 
 *
 */
public class CardDeck implements Iterable <Card>{
	/**
	 * Creates a new deck of cards. The deck will contain 52 distinct cards.
	 * the deck may or may not be shuffled
	 */
	public CardDeck ()
	{
		//TODO
	}

	/**
	 * Shuffles the deck
	 */
	public void shuffle(){
		//TODO
	}

	/**
	 * returns a collection of 5 cards taken from the top of deck.
	 * After the operation those 5 cards should be removed from the deck
	 * and its size is decreased by 5.
	 * @return a collection of 5 cards taken from the top of deck
	 */
	public Collection<Card> draw5Cards (){
		//TODO
		return null;
	}

	/**
	 * After the operation this card should be removed from the deck
	 * and its size is decreased by 1.
	 * @return a card from the top of the deck
	 */
	public Card drawCard (){
		//TODO
		return null;
	}

	/**
	 * @return current deck size, a value between 0 and 52 inclusive
	 */
	public int size(){
		//TODO
		return 0;
	}

	@Override
	public String toString (){
		//TODO
		return null;
	}

	@Override
	public Iterator <Card> iterator() {
		//TODO
		return null;
	}

}
