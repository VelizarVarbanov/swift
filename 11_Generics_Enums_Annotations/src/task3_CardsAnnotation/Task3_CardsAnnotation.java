package task3_CardsAnnotation;

import task1_Cards.Task1_Cards.*;
import task2_Deck.Card;
import task2_Deck.Card.*;

import java.lang.annotation.Annotation;

public class Task3_CardsAnnotation {
    public static void main(String[] args) {
        /**Class aClass = TheClass.class;
         Annotation[] annotations = aClass.getAnnotations();

         for(Annotation annotation : annotations){
         if(annotation instanceof MyAnnotation){
         MyAnnotation myAnnotation = (MyAnnotation) annotation;
         System.out.println("name: " + myAnnotation.name());
         System.out.println("value: " + myAnnotation.value());
         }
         Card class Represents a card object used to play games with.
         CardRank enum Contains a set of constants for the ranks of a card.
         CardSuit enum Contains a set of constants for the suits of a card.
         **/
        Class card = Card.class;
        Annotation[] annotationsCard = card.getAnnotations();
        for (Annotation annotation : annotationsCard) {
            if (annotation instanceof CardsAnnotation) {
                CardsAnnotation cardsAnnotation = (CardsAnnotation) annotation;
                System.out.println(card.getSimpleName() + cardsAnnotation.type() + cardsAnnotation.description());
            }
        }
        Class rank = CardRank.class;
        Annotation[] annotationsRank = rank.getAnnotations();
        for (Annotation annotation : annotationsRank) {
            if (annotation instanceof CardsAnnotation){
                CardsAnnotation cardsAnnotation = (CardsAnnotation) annotation;
                System.out.println(rank.getSimpleName() + cardsAnnotation.type() + cardsAnnotation.description());
            }
        }
        Class suit = CardSuit.class;
        Annotation[] annotationsSuit = suit.getAnnotations();
        for (Annotation annotation : annotationsSuit) {
            if (annotation instanceof CardsAnnotation) {
                CardsAnnotation cardsAnnotation = (CardsAnnotation) annotation;
                System.out.println(suit.getSimpleName() + cardsAnnotation.type() + cardsAnnotation.description());
            }
        }
    }
}
