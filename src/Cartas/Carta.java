package src.Cartas;

import src.Cor;

public abstract class Carta {
    private String face;
    private String naipe;
    private Cor cor;
    private int valor;

    public Carta(String face, String naipe, int valor, Cor cor) {
        this.face = face;
        this.naipe = naipe;
        this.valor = valor;
        this.cor = cor;
    }

    public String getFace() {
        return face;
    }

    public int getValor() {
        return valor;
    }

    public Cor getCor() {
        return cor;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public abstract int getPontuacao();

    public String toString() {
        String corAnsi = (cor != null) ? cor.ansiCode() : ""; // Lidar com cor nula
        String corNome = (cor != null) ? cor.getValue() : "sem cor"; // Para mostrar a cor na string
        return String.format("%6s", face) + " de " + corAnsi + corNome + Cor.RESET.ansiCode() + ", valor " + valor;
    }
}
