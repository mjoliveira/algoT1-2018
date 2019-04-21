//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
//------------------------------------------------------

public class IO {

	public static List<String[]> carregarArquivo(String arquivo) throws IOException{ //Lê os dados dos retângulos
		
		List<String[]> lista = new LinkedList<String[]>();
		
		FileReader arq = new FileReader(arquivo);
	    BufferedReader lerArq = new BufferedReader(arq);
		
	    int quantidade = Integer.parseInt(lerArq.readLine()); // Lê a primeira linha.
		int aux = 0;
		
		String linha = null;
		while (aux != quantidade) {   
			linha = lerArq.readLine();
			lista.add(linha.split(" ", 5));
			aux++;
			// Cada linha tera um vetor de cinco posições: Ex:
			//		linha = "2 1 3 5 azul-claro"
			//	 	linha.split(" ", 5) -> vet[0] = "2", vet[1] = "1", vet[2] = "3", vet[3] = "5" e vet[4] = "azul-claro"	
		}
		
		return lista;
		
	}

}
