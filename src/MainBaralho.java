package src;

import src.Baralhos.*;

public class MainBaralho {
   public static void main(String[] args) {
      DiretorBaralho diretor = new DiretorBaralho();

      BaralhoTradicionalBuilder builderTradicional = new BaralhoTradicionalBuilder();
      diretor.setBuilder(builderTradicional);

      diretor.make(TipoBaralho.TRADICIONAL);
      Baralho baralhoTradicional = diretor.getBaralho();
      System.out.println("Baralho Tradicional - Tamanho: " + baralhoTradicional.size() + " cartas.");
      System.out.println(baralhoTradicional);

      BaralhoUnoBuilder builderUno = new BaralhoUnoBuilder();
      diretor.setBuilder(builderUno);

      diretor.make(TipoBaralho.UNO);
      Baralho baralhoUno = diretor.getBaralho();
      System.out.println("Baralho Uno - Tamanho: " + baralhoUno.size() + " cartas.");
      System.out.println(baralhoUno);
   }
}


