// classe DeckOfCards representa um baralho.
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho
{
   private List<Carta> deck; // ArrayList usado como uma pilha de objetos
   private final int NUMBER_OF_CARDS = 52; // n�mero constante de Cards
   private Random randomNumbers; // gerador de n�mero aleat�rio

   // construtor preenche baralho de cartas
   public Baralho()
   {
      String faces[] = { "As", "2", "3", "4", "5", "6",
         "7", "8", "9", "10", "Valete", "Dama", "Rei" };    
//      String naipe[] = { "Hearts", "Diamonds", "Clubs", "Spades" };  
      String naipe[] = { "\u2665", "\u2666", "\u2663", "\u2660" };

      deck = new ArrayList<Carta>(); // cria List de objetos Card
      randomNumbers = new Random();  // cria gerador de n�mero aleat�rio

      // preenche baralho com objetos Card
      for ( int count = 0; count < NUMBER_OF_CARDS; count++ )   {
         deck.add(new Carta( faces[ count % 13 ], naipe[ count / 13 ], 0, naipe[ count / 13 ] == "\u2665" || naipe[ count / 13 ] == "\u2666" ? Cor.VERMELHO: Cor.PRETO ));
      }
   } // fim do construtor DeckOfCards

   public boolean hasCard() {
	   return deck.size() > 0;
   }
   
   // embaralha as cartas com um algoritmo de uma passagem
   public void shuffle()
   {
      // depois de embaralhar, a distribui��o deve iniciar em deck[ 0 ] novamente
      // para cada Card, seleciona outro Card aleat�rio e os compara
      for ( int first = 0; first < deck.size(); first++ )
      {
         // seleciona um n�mero aleat�rio entre 0 e 51
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );

         // compara Card atual com Card aleatoriamente selecionado
         Carta temp = deck.remove( second );     
         deck.add(0, temp);
      } // for final
   } // fim do m�todo shuffle

   // retira uma carta, do topo do monte
   public Carta dealCard()
   {
       return deck.remove(deck.size()-1); // retorna Card atual no array
   } // fim do m�todo dealCard
   
   
   public int size() {
	   return deck.size();
   }
   
   public String toString() {
	  String s = "";
	  int column = 0;
	  for (Carta card : deck) {
		  column++;
		  s += card.toString() + "   ";
		  if (column % 4 == 0) {
			  s += "\n";
			  column = 0;
		  }
	  }
      return s;
   }
   
} // fim da classe DeckOfCards


