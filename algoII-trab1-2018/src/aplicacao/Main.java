//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.IOException;
import java.util.Scanner;
//------------------------------------------------------

public class Main {
    public static void main(String[] args) throws IOException{
    	
    	String aux;
    	Scanner in = new Scanner(System.in);
    	 
        System.out.printf("Informe o nome de caso de teste: ");
        String nome = in.nextLine();
        System.out.printf("\n");
        
        long tempoInicial = System.currentTimeMillis(); // Tempo inicial do sistema.
              
        Controle controle = new Controle();
        controle.carregarArquivo(nome);
         
        //aux = (controle.carregarArquivo(nome))?"Concluído!" :"Falha no carregamento.";
		//System.out.println("Carregamento do arquivo " + nome + "... " + aux);
		
		controle.empilhar();
		controle.processar();
		controle.imprimir();
		
        // calculo do tempo final do sistema.
        long tempoFinal = System.currentTimeMillis();
    	System.out.println("\nTempo de execução: " + (tempoFinal - tempoInicial) + " milissegundos");
    }
}