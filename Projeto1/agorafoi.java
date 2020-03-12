package taxi2;

import java.util.Scanner;

public class Taxi {

    int n_pessoas = 1;
    int m_pessoas = 4;
    int gasolina = 0;
    int distancia = 0;
    int carteira = 0;

    int preco = 0;

    Scanner in = new Scanner(System.in);

    public void embarcarPessoa() {
        km();
        while ((this.distancia > this.gasolina) && !(this.carteira < this.preco)) {
            encherTanque();
        }
        if (!(this.carteira < this.preco)) {

            System.out.println("Corrida começou!");
            if (this.n_pessoas < this.m_pessoas) {
                this.n_pessoas++;

                System.out.println("Você embarcou " + n_pessoas + " no veiculo");

            } else {
                System.out.println("Veiculo lotada");
            }
        }

    }

    public void desembarcarPessoa() {
        if (this.n_pessoas > 1) {
            this.n_pessoas--;
            System.out.println("Você desembarcou " + n_pessoas + " no veiculo");
        } else {
            System.out.println("Veiculo vago");
        }
    }

    public void encherTanque() {
        if (this.distancia > this.gasolina) {
            System.out.println("Precisa abastercer " + (this.distancia - this.gasolina) + " litros");

        }
        System.out.println(this.gasolina + " LITROS de gasolina \nDigite a quantidade de litros desejada?");
        this.gasolina += in.nextInt();
    }

    public void km() {
        System.out.println("Digite a distancia que deseja percorrer?");
        this.distancia = in.nextInt();
        this.preco = this.distancia * 2;
        System.out.println("A corrida vai custar: " + this.preco + "!");

        System.out.println("Digite quanto dinheiro voce tem?");
        this.carteira = in.nextInt();
        if (this.distancia <= this.gasolina && this.carteira >= this.preco) {
            System.out.println("Pode fazer a corrida");
        } else if (this.carteira < this.preco) {
            System.out.println("Você é lascado, vá á pé!");
        }

    }

    public static void main(String[] args) {
        Taxi taxi1 = new Taxi();

        taxi1.embarcarPessoa();
        taxi1.desembarcarPessoa();

    }
}
