package src.Baralhos;

import src.Cartas.CartaFactory;
import src.Cartas.TipoCarta;
import src.Cartas.CartaTradicional;


public class BaralhoTradicionalBuilder implements BaralhoBuilder {
    private Baralho baralho;
    private String[] faces;
    private String[] naipes;

    public BaralhoTradicionalBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.baralho = new Baralho();
        definirFacesCartas();
        definirNaipesCartas();
    }

    @Override
    public void definirFacesCartas() {
        this.faces = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "As"};
    }

    @Override
    public void definirNaipesCartas() {
        this.naipes = new String[] {"Copas", "Espadas", "Ouros", "Paus"};
    }


    @Override
    public void construirCartasNumericas() {
        for (String naipe : naipes) {
            for (String face : faces) {
                String cor = (naipe.equals("Copas") || naipe.equals("Ouros")) ? "vermelho" : "preto";
                CartaTradicional carta = (CartaTradicional) CartaFactory.criarCarta(TipoCarta.TRADICIONAL, face, new String[]{naipe, cor}, 0);
                baralho.adicionarCarta(carta);
            }
        }
    }

    @Override
    public void construirCartasAcoes() {

    }

    @Override
    public void construirCartasCoringa() {

    }

    @Override
    public void embaralharCartas() {
        baralho.shuffle();
    }

    @Override
    public Baralho getResult() {
        return this.baralho;
    }
}





