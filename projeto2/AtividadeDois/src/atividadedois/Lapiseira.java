package atividadedois;

import java.util.Scanner;

public class Lapiseira {

    private double Calibre;
    private boolean graf = false;
    private int linhas;

    Scanner in = new Scanner(System.in);

    public Lapiseira() {
        System.out.println("Sua lapiseira está vazia!\nQual o calibre da sua lapiseira?");
        this.setCalibre(in.nextDouble());
        InserirGrafite();
    }

    public void InserirGrafite() {
        System.out.println("Deseja inserir um gráfite?\n0 - Não\n1 - Sim");
        if (in.nextInt() == 1) {
            Grafite gra = new Grafite();
            if (this.getCalibre() == gra.getCalibre()) {
                graf = true;
                this.setLinhas(0);
                System.out.println("Deseja escrever uma linha?\n0 - Não, 1 - Sim");
                int q = in.nextInt();
                while (q == 1) {
                    EscreverLinhas();
                    System.out.println("Deseja escrever outra linha?\n0 - Não, 1 - Sim");
                    q = in.nextInt();

                }
            } else {
                System.out.println("Esse grafite não encaixa!");
            }
        } else {
            System.out.println("De boas!");
        }
    }

    public void RemoverGrafite() {
        this.graf = false;
    }

    public void EscreverLinhas() {
        if (this.graf && this.getLinhas() < 20) {
            System.out.println("Linha escrita");
            this.setLinhas(getLinhas() + 1);
        } else {
            System.out.println("Não tem gráfite");
            InserirGrafite();

        }
    }

    public double getCalibre() {
        return Calibre;
    }

    public void setCalibre(double Calibre) {
        this.Calibre = Calibre;
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

}
