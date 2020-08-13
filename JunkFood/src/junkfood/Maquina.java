package junkfood;

public class Maquina {

    private int quantEspiral;
    private int maxProd;
    Espiral esp[] = new Espiral[500];
    private double saldo = 0;

    public void inciarMaquina(int qtesp, int qtprod) {
        this.setQuantEspiral(qtesp);
        this.setMaxProd(qtprod);
    }

    public void iniciarEspiral() {

        for (int i = 0; i < this.getQuantEspiral(); i++) {
            this.esp[i] = new Espiral();
            this.esp[i].setId((i + 1));
            this.esp[i].setNomeProduto("-");
            this.esp[i].setPreco(0.00);
            this.esp[i].setQuantidade(0);
        }
    }

    public void listarEspiral() {
        for (int i = 0; i < this.getQuantEspiral(); i++) {
            System.out.println("Espiral " + this.esp[i].getId() + ":  " + this.esp[i].getNomeProduto() + "  " + this.esp[i].getQuantidade() + "U  R$ " + this.esp[i].getPreco() + " ");
        }
        if(this.getSaldo() != 0){
            System.out.println("SALDO: "+this.getSaldo());
        }
    }
    public void preencherEspiral(int n, String nome, double preco, int quant) {
        n--;
        this.esp[n].setId((n + 1));
        this.esp[n].setNomeProduto(nome);
        this.esp[n].setPreco(preco);
        this.esp[n].setQuantidade(this.esp[n].getQuantidade()+quant);
    }

    public void resetarEspiral(int n) {
        n--;
        this.esp[n].setNomeProduto("-");
        this.esp[n].setPreco(0.00);
        this.esp[n].setQuantidade(0);
    }
    
    public void receberDinheiro(double dinheiro){
        this.setSaldo(dinheiro+this.getSaldo());
    }
    
    public void darTroco(double dinheiro){
        this.setSaldo(0);
    }
    
    public boolean comprarProd(String prod){
        boolean retornar = false;
         for (int i = 0; i < this.getQuantEspiral(); i++) {
            if(prod.equalsIgnoreCase(this.esp[i].getNomeProduto()) && this.getSaldo() > this.esp[i].getPreco() && this.esp[i].getQuantidade() > 0){
                this.setSaldo(this.getSaldo()-esp[i].getPreco());
                this.esp[i].setQuantidade(((this.esp[i].getQuantidade())-1));
                retornar = true;
            }
        }
        return retornar;
    }

    public int getQuantEspiral() {
        return quantEspiral;
    }

    public void setQuantEspiral(int quantEspiral) {
        this.quantEspiral = quantEspiral;
    }

    public int getMaxProd() {
        return maxProd;
    }

    public void setMaxProd(int maxProd) {
        this.maxProd = maxProd;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
