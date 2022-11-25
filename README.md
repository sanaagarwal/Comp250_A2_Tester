# Comp250_A2_Tester
This a tester created for the various methods on Assignment 2 - Solitaire Cipher for COMP 250 - Fall 22. I used the same format as in the prof's minitester. This contains testers for methods and edge cases not included in the minitester. 

So far it has testers for:

#### Deck class
  1. `Deck(int numOfCardsPerSuit, int numOfSuits)`
  2. `Deck (Deck d)`
  3. `moveCard(Card c, int p)`
  4. `tripleCut(Card firstCard, Card secondCard)`
  5. `countCut()`
  6. `locateJoker(String color)` 
  7. `generateNextKeystreamValue()` 
  

#### SolitaireCipher class
  1. `getKeystream(int size)`
  2. `encode(String msg) and decode(String msg)`
  
  ## How to use:
  You can either download the `A2_Tester2.java` file and add it in your main package, or copy the code and create your own class. If you create your own class, make sure to rename the class that has the main method in it as well. 
