package atividadedois;

import java.util.Scanner;

public class Grafite {

    private double calibre;
    private double tamanho;
    Scanner in = new Scanner(System.in);

    public Grafite() {
        System.out.println("Digite o tamanho do grafite:");
        this.setTamanho(in.nextDouble());
        System.out.println("Digite o calibre da grafite:");
        this.setCalibre(in.nextDouble());

    }

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

}
