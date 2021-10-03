package HW1;
import java.util.Random;
public class Deck_of_Cards {
	private Card deck[];
	private int position;
	
	public Deck_of_Cards() {
		this.deck = new Card[52];
		this.refresh();
	}
	public void refresh() {
		char suitsarr[] = {'C','D','H','S'};
		char ranksarr[] = {'A','1','2','3','4','5','6','7','8','9','J','Q','K'};
		int posofdeck = 0;
		for(char s:suitsarr) {
			for(char r:ranksarr) {
				this.deck[posofdeck] = new Card(s,r);
				posofdeck++;
			}
		}
		this.shuffle();
	}
	public void shuffle() {
		Random random = new Random(); 
		for(int i = 0;i<this.deck.length;i++) {
			int randnum = random.nextInt(52);
			Card temp = this.deck[randnum];
			this.deck[randnum] = this.deck[i];
			this.deck[i] = temp;
		}
		this.position = 0;
	}
	public Card drawCard() {
		if(this.position>51)this.shuffle();
		Card out = this.deck[this.position];
		this.position++;
		return out;
	}
	public static void main(String[] args) {
		Deck_of_Cards t = new Deck_of_Cards();
//		int c = 1;
//		for(Card i:t.deck) {
//			System.out.println(i.getSuit()+" "+i.getRank()+" "+c);
//			c++;
//		}
		Card r = t.drawCard();
		System.out.println(r.getSuit()+" "+r.getRank());
	}
}
