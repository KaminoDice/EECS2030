package eecs2030.lab7;

/**
 * This class implements poker game-related methods
 * @author 
 *
 */
public class Poker {
	private Poker(){};

	/**
	 * Checks if a hand contains two pairs: https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair
	 * @param hand
	 * @return true if the hand contains exactly two pairs of cards with the same value (rank)
	 * NOTE: Full house https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house hands  
	 * is to be excluded
	 */
	public static boolean has2Pairs(PokerHand hand){
		//TODO
		return false;
	}

	/**
	 * Checks if a hand contains a Flush: https://en.wikipedia.org/wiki/List_of_poker_hands#Flush
	 * @param hand
	 * @return true if the hand contains five cards all of the same suit, not all of sequential rank
	 * NOTE: Straight flush https://en.wikipedia.org/wiki/List_of_poker_hands#Straight_flush  
	 * are to be excluded
	 */
	public static boolean hasFlush(PokerHand hand){
		//TODO
		return false;
	}

}
