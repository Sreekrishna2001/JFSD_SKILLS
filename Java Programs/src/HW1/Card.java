package HW1;

public class Card {
	private char suit;
	private char rank;
	public Card(char suit,char rank) {
		if(isSuitValid(suit)) {
			this.suit = suit;
		}
		else throw new IllegalArgumentException();
		if(isRankValid(rank)) {
			this.rank = rank;
		}
		else throw new IllegalArgumentException();
		
	}
	private boolean isSuitValid(char suit) {
		if(suit=='C' || suit == 'D' || suit == 'H' || suit == 'S')return true;
		return false;
	}
	private boolean isRankValid(char rank) {
		if(rank == 'A'||rank== 'K'|| rank== 'Q'||rank=='J'|| (rank>='1' && rank<='9'))return true;
		return false;
	}
	public char getSuit() {
		return this.suit;
	}
	public char getRank() {
		return this.rank;
	}
}
