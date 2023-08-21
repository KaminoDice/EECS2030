package eecs2030.lab7;

public class CardDemo {

	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		//System.out.println(deck);
		
		System.out.println("Drawing one card: " + deck.drawCard());
		System.out.println("Deck size before drawing 5: " + deck.size());
		PokerHand hand = new PokerHand(deck.draw5Cards());
		System.out.println("Deck size  after drawing 5: " + deck.size());
		System.out.println(hand);
		
		System.out.println("Has a Flush: " + Poker.hasFlush(hand));
		
		System.out.println();
		
		System.out.println("Searching for Two Pair");
		int threeOfkindFound = 0;
		for (int i = 0; i < 1000; i++){
			deck = new CardDeck();
			deck.shuffle();
			hand = new PokerHand(deck.draw5Cards());
			if (Poker.has2Pairs(hand)){
				threeOfkindFound++;
				System.out.println("Two Pairs found: " + hand);
			}
		}
		System.out.println("Total of two pairs found: " + threeOfkindFound);
	}
}
