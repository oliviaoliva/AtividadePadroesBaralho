package src.Baralhos;

import src.Cartas.CartaFactory;
import src.Cartas.CartaUno;
import src.Cartas.TipoCarta;

public class BaralhoUnoBuilder implements BaralhoBuilder {
    private Baralho baralho;
    private String[] cores;
    private String[] faces;
    private String[] acoes;

    private int[] valores;
    private int[] valoresEspeciais;

    public BaralhoUnoBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.baralho = new Baralho();
        definirPropriedades();
    }

    @Override
    public void definirFacesCartas() {

    }

    @Override
    public void definirNaipesCartas() {

    }

    private void definirPropriedades() {
        this.cores = new String[]{"Vermelho", "Azul", "Verde", "Amarelo"};
        this.faces = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.valores = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.acoes = new String[]{"Pular", "Reverter", "+2"};
        String[] coringas = new String[]{"Curinga", "+4", "Trocar as mãos"};
        this.valoresEspeciais = new int[]{20, 50};
    }

    @Override
    public void construirCartasNumericas() {
        for (String cor : cores) {
            for (int i = 0; i < faces.length; i++) {
                CartaUno carta1 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, faces[i], new String[]{cor}, valores[i]);
                CartaUno carta2 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, faces[i], new String[]{cor}, valores[i]);
                baralho.adicionarCarta(carta1);
                baralho.adicionarCarta(carta2);
            }
        }
    }

    @Override
    public void construirCartasAcoes() {
        for (String cor : cores) {
            for (String acao : acoes) {
                CartaUno carta1 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, acao, new String[]{cor}, valoresEspeciais[0]);
                CartaUno carta2 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, acao, new String[]{cor}, valoresEspeciais[0]);
                baralho.adicionarCarta(carta1);
                baralho.adicionarCarta(carta2);
            }
        }
    }

    @Override
    public void construirCartasCoringa() {
        for (int i = 0; i < 4; i++) {
            CartaUno cartaCuringa = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, "Curinga", null, valoresEspeciais[1]);
            baralho.adicionarCarta(cartaCuringa);
        }

        for (int i = 0; i < 4; i++) {
            CartaUno cartaMaisQuatro = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, "+4", null, valoresEspeciais[1]);
            baralho.adicionarCarta(cartaMaisQuatro);
        }

        CartaUno cartaTrocaMao = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, "Trocar as mãos", null, valoresEspeciais[1]);
        baralho.adicionarCarta(cartaTrocaMao);
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
