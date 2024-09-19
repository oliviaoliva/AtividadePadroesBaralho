package src;

public enum Cor {
	VERMELHO("\u001B[31m", "vermelho"),
	PRETO("\u001B[30m", "preto"),
	RESET("\u001B[0m", "reset"),
	AZUL("\u001B[34m", "azul"),
	VERDE("\u001B[32m", "verde"),
	AMARELO("\u001B[33m", "amarelo");

	private final String ansiCode;
	private final String value;

	Cor(String ansiCode, String cor) {
		this.ansiCode = ansiCode;
		this.value = cor;
	}

	public String ansiCode() {
		return this.ansiCode;
	}

	public String getValue() {
		return this.value;
	}

	public static Cor fromString(String cor) {
		for (Cor c : Cor.values()) {
			if (c.getValue().equalsIgnoreCase(cor)) {
				return c;
			}
		}
		throw new IllegalArgumentException("Cor desconhecida: " + cor);
	}
}
