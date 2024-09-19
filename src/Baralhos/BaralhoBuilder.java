package src.Baralhos;

public interface BaralhoBuilder {
        void reset();

        void definirFacesCartas();

        void definirNaipesCartas();

        void construirCartasNumericas();

        void construirCartasAcoes();

        void construirCartasCoringa();

        void embaralharCartas();

        Baralho getResult();


}

