package assignment2;

class TripleCut1 implements Runnable {
    @Override
    public void run() {
        // For the edge case of tripleCut() when there are no cards before the 1st card
        // firstCard is the head of the deck

        Deck deck = new Deck();
        Deck.Card c1 = deck.new PlayingCard(Deck.suitsInOrder[0], 1); //AC
        Deck.Card c2 = deck.new PlayingCard(Deck.suitsInOrder[0], 2); //2C
        Deck.Card c3 = deck.new PlayingCard(Deck.suitsInOrder[2], 1); //AH
        Deck.Card c4 = deck.new PlayingCard(Deck.suitsInOrder[2], 2); //2H

        deck.addCard(c1);
        deck.addCard(c2);
        deck.addCard(c3);
        deck.addCard(c4);

        deck.tripleCut(c1, c3);

        boolean head = deck.head == c4;
        boolean tail = deck.head.prev == c3;

        if (!(head && tail)) {
            throw new AssertionError("Incorrect head and tail after tripleCut()");
        }
        System.out.println("assignment2.Test passed.");

    }
}

class TripleCut2 implements Runnable {
    @Override
    public void run() {
        // For the edge case of tripleCut() when there are no cards after the 2nd card
        // secondCard is the tail of the deck

        Deck deck = new Deck();
        Deck.Card c1 = deck.new PlayingCard(Deck.suitsInOrder[0], 1); //AC
        Deck.Card c2 = deck.new PlayingCard(Deck.suitsInOrder[0], 2); //2C
        Deck.Card c3 = deck.new PlayingCard(Deck.suitsInOrder[2], 1); //AH
        Deck.Card c4 = deck.new PlayingCard(Deck.suitsInOrder[2], 2); //2H

        deck.addCard(c1);
        deck.addCard(c2);
        deck.addCard(c3);
        deck.addCard(c4);

        deck.tripleCut(c2, c4);

        boolean head = deck.head == c2;
        boolean tail = deck.head.prev == c1;

        if (!(head && tail)) {
            throw new AssertionError("Incorrect head and tail after tripleCut()");
        }
        System.out.println("assignment2.Test passed.");

    }
}

class TripleCut3 implements Runnable {
    @Override
    public void run() {
        // regular case of tripleCut()

        Deck deck = new Deck();
        Deck.Card c1 = deck.new PlayingCard(Deck.suitsInOrder[0], 1); //AC
        Deck.Card c2 = deck.new PlayingCard(Deck.suitsInOrder[0], 2); //2C
        Deck.Card c3 = deck.new PlayingCard(Deck.suitsInOrder[2], 1); //AH
        Deck.Card c4 = deck.new PlayingCard(Deck.suitsInOrder[2], 2); //2H
        Deck.Card c5 = deck.new PlayingCard(Deck.suitsInOrder[3], 1); //AS
        Deck.Card c6 = deck.new PlayingCard(Deck.suitsInOrder[3], 2); //2S

        deck.addCard(c1);
        deck.addCard(c2);
        deck.addCard(c3);
        deck.addCard(c4);
        deck.addCard(c5);
        deck.addCard(c6);

        deck.tripleCut(c3, c5);

        boolean head = deck.head == c6;
        boolean tail = deck.head.prev == c2;
        boolean c3Prev = c3.prev == c6;
        boolean c5Next = c5.next == c1;

        if (!(head && tail && c3Prev && c5Next)) {
            throw new AssertionError("Incorrect head and tail after tripleCut()");
        }

        System.out.println("assignment2.Test passed.");
    }
}

public class Tester2 {
    // To skip running some tests, just comment them out below.
    static String[] tests = {
            "assignment2.TripleCut1",
            "assignment2.TripleCut2",
            "assignment2.TripleCut3",
    };

    public static void main(String[] args) {
        int numPassed = 0;
        for(String className: tests)    {
            System.out.printf("%n======= %s =======%n", className);
            System.out.flush();
            try {
                Runnable testCase = (Runnable) Class.forName(className).getDeclaredConstructor().newInstance();
                testCase.run();
                numPassed++;
            } catch (AssertionError e) {
                System.out.println(e);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        System.out.printf("%n%n%d of %d tests passed.%n", numPassed, tests.length);
    }
}
