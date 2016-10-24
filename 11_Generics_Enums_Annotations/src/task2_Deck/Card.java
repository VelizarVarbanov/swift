package task2_Deck;

import task1_Cards.Task1_Cards.*;
import task3_CardsAnnotation.CardsAnnotation;

@CardsAnnotation(type = " class", category = "CardGames", description = " Represents a card object used to play games with.")

public class Card implements Comparable {
    public CardSuit suit;
    public CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.setRank(rank);
        this.setSuit(suit);
    }

    @Override
    public String toString() {
        return this.suit + " of " + this.rank;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Card otherCard) {
        int result = 0;
        if (this.getRank().getCardRank() > otherCard.rank.getCardRank())
            result = 1;
        else if (this.getRank().getCardRank() < otherCard.rank.getCardRank())
            result = -1;
        return result;
    }

}
