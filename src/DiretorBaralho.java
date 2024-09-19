package src;

import src.Baralhos.*;
public class DiretorBaralho {
    private BaralhoBuilder builder;

    public void setBuilder(BaralhoBuilder builder) {
        this.builder = builder;
    }

    public void make(TipoBaralho tipo) {
        builder.reset();

        switch (tipo) {
            case TRADICIONAL:
                builder.construirCartasNumericas();
                break;

            case UNO:
                builder.construirCartasNumericas();
                builder.construirCartasAcoes();
                builder.construirCartasCoringa();
                break;

            default:
                throw new IllegalArgumentException("Tipo de baralho desconhecido.");
        }

        builder.embaralharCartas();
    }

    public Baralho getBaralho() {
        return builder.getResult();
    }
}
