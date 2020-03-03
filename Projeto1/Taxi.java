package taxi2;
import java.util.Scanner;

public class Taxi{
    int n_pessoas = 1;
    int m_pessoas = 2;
    int gasolina = 0;
    float distancia = 0; 
    
    Scanner in = new Scanner(System.in);
    
    public void embarcar(){
        System.out.println("Mototaxi chegou");
        if(this.n_pessoas < this.m_pessoas){
            this.n_pessoas +=1;
            System.out.println("Você embarcou");
        }
        else System.out.println("Veiculo lotada");
            
}
    public void encherTanque(){
        System.out.println("Quantos litros?");
        gasolina = in.nextInt();
        
        
    }
    
    public void km(){
        System.out.println("Qual a distancia?");
        distancia = in.nextFloat();
        if(distancia <= gasolina){
            System.out.println("Pode fazer a corrida");
        }
        else System.out.println("Precisa abastercer");
      
    }
    
    public void dinheiroPagar(){
        km();
        double dinheiro = 0;
        double carteira = 70;
        double distancia_atual = 0;
        while(distancia_atual < distancia){
            dinheiro += 2;
            distancia_atual ++;
        }
        System.out.println("Preço da corrida "+ dinheiro);
        if(dinheiro <= carteira){
            embarcar();
            
        
        } else {
            System.out.println("Dinheiro insuficiente você tem: "+ carteira);
        }
             
    }
    
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Taxi taxi2 = taxi;
        taxi.encherTanque();
        taxi.dinheiroPagar();
        
        taxi2.embarcar();
                
    }
}

