package task1_Cards;


import task3_CardsAnnotation.CardsAnnotation;

import java.util.EnumSet;

public class Task1_Cards {
    public static void main(String[] args) {
        getCardSuit();
        getCardRank();

    }
    @CardsAnnotation(type = " enum", category = "CardGames", description = " Contains a set of constants for the suits of a card.")
    public enum CardSuit {
        Clubs, Diamonds, Hearts, Spades
    }
    @CardsAnnotation(type = " enum", category = "CardGames", description = " Contains a set of constants for the ranks of a card.")
    public enum CardRank {
        Two(2), Three(3), Four(4), Five(5),
        Six(6), Seven(7), Eight(8), Nine(9), Ten(10),
        Jack(11), Queen(12), King(13), Ace(14);

        public int cardRank;

        CardRank(int value) {
            this.cardRank = value;
        }

        public int getCardRank(){
            return this.cardRank;
        }
    }
    public static void getCardSuit () {
        for (CardSuit cards : EnumSet.allOf(CardSuit.class)) {
            if (!cards.equals(CardSuit.Spades)) {
                System.out.print(cards + ", ");
            } else System.out.println(CardSuit.Spades);
        }
    }
    public static void getCardRank () {
        for (CardRank ranks : EnumSet.allOf(CardRank.class)) {
            if (!ranks.equals(CardRank.Ace)) {
                System.out.print(ranks + ", ");
            } else System.out.println(CardRank.Ace);
        }
    }
}
