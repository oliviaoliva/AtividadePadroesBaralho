package src.Cartas;

import src.Cor;

public class CartaFactory {
    public static Carta criarCarta(TipoCarta tipo, String face, String[] naipesECores, int valor) {
        switch (tipo) {
            case TRADICIONAL:
                Cor cor = Cor.fromString(naipesECores[1]); // Assume-se que a cor esteja na segunda posição do array
                return new CartaTradicional(face, naipesECores[0], valor, cor); // Passa o naipe e a cor
            case UNO:
                if (naipesECores == null || naipesECores.length == 0) {
                    return new CartaUno(face, valor, face);
                } else {
                    return new CartaUno(face, naipesECores[0], valor, face);
                }
            default:
                throw new IllegalArgumentException("Tipo de carta desconhecido.");
        }
    }
}




