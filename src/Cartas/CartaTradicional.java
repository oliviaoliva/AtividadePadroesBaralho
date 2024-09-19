package src.Cartas;


import src.Cor;

public class CartaTradicional extends Carta {
    public CartaTradicional(String face, String naipe, int valor, Cor cor) {
        super(face, naipe, valor, cor);
    }

    @Override
    public int getPontuacao() {
        return getValor();
    }

    @Override
    public String toString() {
        String corAnsi = getCor() != null ? getCor().ansiCode() : "";
        return corAnsi + super.getFace() + " de " + getNaipe() + " " + getCor().getValue() + Cor.RESET.ansiCode() + ", valor " + getValor();
    }
}



