package junkfood;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int resposta;

        do {
            System.out.println("INICIANDO MÁQUINA");
            Maquina m1 = new Maquina();

            System.out.print("Digite a quantidade de espirais: ");
            m1.setQuantEspiral(e.nextInt());
            System.out.print("Digite a quantidade de produtos por espiral: ");
            m1.setMaxProd(e.nextInt());
            System.out.println("\nLISTA DE ESPIRAIS");
            m1.iniciarEspiral();
            m1.listarEspiral();

            do {
                System.out.print("\nENTRAR COMO\n1 - PROGRAMADOR\n2 - USUÁRIO\nReposta: ");
                resposta = e.nextInt();
                if (resposta == 1) {
                    do {
                        System.out.print("\nMENU PROGRAMADOR\n1 - PREENCHER UMA ESPIRAL\n2 - RESETAR UMA ESPIRAL\nRespota: ");
                        resposta = e.nextInt();
                        if (resposta == 1) {
                            int n;
                            int quant;
                            String nome;
                            double preco;

                            do {
                                System.out.print("\nDigite o número da espiral: ");
                                n = e.nextInt();
                                if (n < 0 && n > m1.getQuantEspiral()) {
                                    System.out.println("Espiral inexistente. Tente novamente.");
                                }
                            } while (n < 0 && n > m1.getQuantEspiral());

                            System.out.print("Digite o nome do produto: ");
                            nome = e.next();

                            do {
                                System.out.print("Digite a quantidade de produtos: ");
                                quant = e.nextInt();
                                if (quant > m1.getMaxProd()) {
                                    System.out.println("Quantidade de produtos muito alta. Tente novamente.");
                                }
                            } while (quant > m1.getMaxProd());

                            System.out.print("Digite o preço dos produtos: ");
                            preco = e.nextDouble();

                            m1.preencherEspiral(n, nome, preco, quant);
                        } else {
                            int n;
                            do {
                                System.out.print("\nDigite o número da espiral: ");
                                n = e.nextInt();
                                m1.resetarEspiral(n);
                                if (n < 0 && n > m1.getQuantEspiral()) {
                                    System.out.println("Espiral inexistente. Tente novamente.");
                                }
                            } while (n < 0 && n > m1.getQuantEspiral());
                        }

                        System.out.println("\nLISTA DE ESPIRAIS");
                        m1.listarEspiral();
                        System.out.print("\nCONTINUAR COMO PROGRAMADOR?\n1 - SIM\n2 - NÃO\nReposta: ");
                        resposta = e.nextInt();
                    } while (resposta == 1);

                } else {
                    do {
                        System.out.print("\nInserir dinheiro: ");
                        m1.receberDinheiro(e.nextDouble());

                        System.out.println("\nLISTA DE ESPIRAIS");
                        m1.listarEspiral();

                        System.out.print("\nMENU USUÁRIO\n1- COMPRAR PRODUTO\n2 - NÃO COMPRAR NADA\nResposta: ");
                        resposta = e.nextInt();

                        String nome;
                        if (resposta == 1) {
                            do {
                                System.out.print("\nDigite o nome do produto: ");
                                nome = e.next();
                                if (!(m1.comprarProd(nome))) {
                                    System.out.println("Error. Verifique o saldo, o nome do produto e a quantidade de produtos.");
                                    System.out.println("\nLISTA DE ESPIRAIS");
                                    m1.listarEspiral();
                                } else {
                                    System.out.println("PRODUTO COMPRADO: " + nome);
                                    System.out.println("\nLISTA DE ESPIRAIS");
                                    m1.listarEspiral();
                                }
                                System.out.print("\nCONTINUAR COMPRANDO?\n1 - SIM\n2 - NÃO\nReposta: ");
                                resposta = e.nextInt();
                            } while (resposta == 1);
                        }

                        System.out.print("\nCONTINUAR COMO USUÁRIO?\n1 - SIM\n2 - NÃO\nReposta: ");
                        resposta = e.nextInt();
                    } while (resposta == 1);
                    System.out.println("SEU TROCO: " + m1.getSaldo());
                    m1.darTroco(resposta);
                }

                System.out.print("\nCONTINUAR A MEXER NA MÁQUINA?\n1 - SIM\n2 - NÃO\nReposta: ");
                resposta = e.nextInt();

            } while (resposta == 1);

            System.out.print("\nINICIAR UMA NOVA MÁQUINA?\n1 - SIM\n2 - NÃO\nReposta: ");
            resposta = e.nextInt();

        } while (resposta == 1);

    }
}
