//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//------------------------------------------------------

public class Controle {
	private Quadtree arvore;
	public Retangulo retanguloGeral;
	private Pilha pilha;
	private int minX, minY, maxX, maxY;
	
	private List<String[]> arquivo;
	public static Map<String,Integer> dicionario;
    
	public Controle() { // Construtor do Controle.
        dicionario = new HashMap<String,Integer>();
        pilha = new Pilha();
		minX=500000;
		minY=500000;
		maxX=0;
		maxY=0;
    }

	
	public boolean carregarArquivo(String nome) {
				
        try{
        	arquivo = IO.carregarArquivo(nome);
			
		}catch (IOException e){
			return false;
		}
  
		return true;
	}
	
	public void empilhar(){
		
		try{
			
			int x1=0, y1=0, x2=0, y2=0;
						
			for(String[] vet : arquivo){
				
				x1 = Integer.parseInt(vet[0]);
				y1 = Integer.parseInt(vet[1]);
				x2 = Integer.parseInt(vet[2]);
				y2 = Integer.parseInt(vet[3]);
				
				
				if(x1 < minX) minX = x1;
				if(y1 < minY) minY = y1;
				if(x2 > maxX) maxX = x2;
				if(y2 > maxY) maxY = y2;
				
				retanguloGeral = new Retangulo(x1, y1, x2, y2, vet[4]); 
				
				dicionario.put(vet[4], 0);
				
				pilha.push(retanguloGeral);
						
			}
			
			retanguloGeral = new Retangulo(minX, minY, maxX, maxY, null);
			
		}catch (NullPointerException  e){
			return;
		}
		
		return;
	}
	
	public void processar() {
        arvore = new Quadtree();
        arvore.add(retanguloGeral);

        while(!pilha.isEmpty()) {
            arvore.add(((Retangulo)pilha.pop()));
        }

    }
	
	// Imprime o valor a partir da chave.
    public void imprimir() {
        for (String key : dicionario.keySet()) {
            
            Integer value = dicionario.get(key);
            System.out.println(key + " = " + value);
        }

    }
	
}