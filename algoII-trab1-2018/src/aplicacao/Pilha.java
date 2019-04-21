//------------------------------------------------------
package aplicacao;
//------------------------------------------------------

public class Pilha { // Criei uma pilha genérica de objetos.
	public Object[] pilha;
    public int ponteiro;
    
	
    public Pilha() {
        this.ponteiro = -1; // A pilha esta vazia.
        this.pilha = new Object[1000000]; // criando uma pilha com 1000000 posições
    }
    
    
    //Retorna o objeto que esta no topo da pilha.
    public Object top() {
        
        if (this.isEmpty()) {
            return null;
        }
        
        return this.pilha[this.ponteiro]; 
    }
    
    
    // Insere um elemento na pilha.
	public void push(Object objeto) { 
		
		if (this.ponteiro < this.pilha.length - 1) {
            ponteiro++;
			this.pilha[ponteiro] = objeto;
		}
	}

	
	// Remove um elemento da pilha.
	public Object pop() {
		
		if (isEmpty()) return null;
        		
		this.ponteiro--;
		
        return this.pilha[this.ponteiro+1]; //Modifiquei com um +1 para teste.
	}

	
	// Verifica se a pilha esta vazia.
	public boolean isEmpty() {
	    
		if (this.ponteiro == -1) {
            return true;
        }
        return false;
	}
	
	
	// Retorna o tamanho da pilha.
	public int size() {
		
		if(this.isEmpty()) {
			return 0;
		}
		
		return this.ponteiro+1;	
	}
	
}
