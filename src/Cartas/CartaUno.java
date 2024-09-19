package src.Cartas;

import src.Cor;
public class CartaUno extends Carta {
    private String tipo; // tipo da carta Uno ("Comprar duas", "Inverter", etc.)

    // Construtor para cartas com cor
    public CartaUno(String face, String cor, int valor, String tipo) {
        super(face, null, valor, cor != null ? Cor.fromString(cor) : null); // Usando Cor.fromString(cor) se cor não for nula
        this.tipo = tipo;
    }

    // Construtor para cartas sem cor (ex. "Curinga")
    public CartaUno(String face, int valor, String tipo) {
        super(face, null, valor, null); // Passa null para a cor explicitamente
        this.tipo = tipo;
    }

    @Override
    public int getPontuacao() {
        switch (tipo) {
            case "Comprar duas":
            case "Reverter":
            case "Pular":
                return 20;
            case "Curinga":
            case "Comprar quatro":
            case "Trocar as mãos":
                return 50;
            default:
                return getValor();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [" + tipo + "]";
    }
}

