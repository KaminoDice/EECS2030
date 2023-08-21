package eecs2030.lab7;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Implements a poker hand containing exactly 5 distinct cards 
 * @author 
 *
 */
public class PokerHand implements Iterable <Card>{
	/**
	 * Creates a new hand from a collection of 5 cards
	 * the hand must contain exactly 5 cards, and they must be distinct
	 * @param hand
	 * @throws IllegalArgumentException if the conditions above a violated
	 */
	public PokerHand(Collection<Card> hand) {
		//TODO
	}

	/**
	 * Creates a new hand from 5 separate card objects
	 * there should be exactly 5 parameters, and they must be distinct
	 * @param hand 5 card objects
	 * @throws IllegalArgumentException if the conditions above a violated
	 */
	public PokerHand(Card... hand) {
		//TODO
	}

	/**
	 * @return a list of cards currently held
	 */
	public List <Card> getHand (){
		//TODO
		return null;
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
