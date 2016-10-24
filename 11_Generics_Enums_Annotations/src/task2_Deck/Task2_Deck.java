package task2_Deck;

import task1_Cards.Task1_Cards.*;

public class Task2_Deck {
    public static void main(String[] args) {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                Card newCard = new Card(suit, rank);
                System.out.println(newCard);
            }
        }
    }
}
