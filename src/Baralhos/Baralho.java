package src.Baralhos;

import src.Cartas.Carta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
    private List<Carta> deck;
    private Random randomNumbers;
    public Baralho() {
        deck = new ArrayList<>();
        randomNumbers = new Random();
    }

    public void adicionarCarta(Carta carta) {
        deck.add(carta);
    }

    public void shuffle() {
        for (int first = 0; first < deck.size(); first++) {
            int second = randomNumbers.nextInt(deck.size());
            Carta temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }
    public int size() {
        return deck.size();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int column = 0;
        for (Carta card : deck) {
            column++;
            s.append(card.toString()).append("   ");
            if (column % 3 == 0) {
                s.append("\n");
                column = 0;
            }
        }
        return s.toString();
    }
}



