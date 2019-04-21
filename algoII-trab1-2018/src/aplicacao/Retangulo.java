//------------------------------------------------------
package aplicacao;
//------------------------------------------------------

public class Retangulo {
	 public String cor; 
	 public Ponto ponto1;
	 public Ponto ponto2;

	 public Retangulo(int x1, int y1, int x2, int y2) {
		 this(x1,y1,x2,y2,null);
	  }

	 public Retangulo(int x1, int y1, int x2, int y2, String cor) {
		 ponto1 = new Ponto(x1, y1);
	     ponto2 = new Ponto(x2, y2);
	     this.cor = cor;
	 }
	
	public int calculaArea(){
		return (ponto1.x - ponto2.x)*(ponto1.y - ponto2.y); //base*altura
	}
	
	public boolean valida(){	
		return (ponto2.x > ponto1.x) && (ponto2.y > ponto1.y);	
	}
	
	public boolean possui(Ponto p){
		return ((ponto1.x <= p.x) && (ponto1.y <= p.y)) && ((ponto2.x >= p.x) && (ponto2.y >= p.y));
	}

	public boolean iguais(Retangulo ret) {
        return (ponto1.equals(ret.ponto1) && ponto2.equals(ret.ponto2));
    }	
	
	public void setCor(String cor) {
		this.cor = cor;
	}	
	
	public Retangulo getFilho1(Ponto pontoD) {
		int x1 = ponto1.x;
		int y1 = (ponto1.y > pontoD.y)? ponto1.y : pontoD.y;
		
		int x2 = (ponto2.x < pontoD.x)? ponto2.x : pontoD.x;
		int y2 = ponto2.y;
			
		Retangulo ret = new Retangulo(x1, y1, x2, y2, cor);
		
		if(ret.valida()) return ret;
		
		return null;
    }
    
    public Retangulo getFilho2(Ponto pontoD) {
		int x1 = (ponto1.x > pontoD.x)? ponto1.x : pontoD.x;
		int y1 = (ponto1.y > pontoD.y)? ponto1.y : pontoD.y;
		
		int x2 = ponto2.x;
		int y2 = ponto2.y;
			
		Retangulo ret = new Retangulo(x1, y1, x2, y2, cor);
		
		if(ret.valida()) return ret;
		
		return null;
    }
    
    public Retangulo getFilho3(Ponto pontoD) {
		int x1 = ponto1.x;
		int y1 = ponto1.y;
		
		int x2 = (ponto2.x < pontoD.x)? ponto2.x : pontoD.x;
		int y2 = (ponto2.y < pontoD.y)? ponto2.y : pontoD.y;
			
		Retangulo ret = new Retangulo(x1, y1, x2, y2, cor);
		
		if(ret.valida()) return ret;
		
		return null;
    }
    
    public Retangulo getFilho4(Ponto pontoD) {
		int x1 = (ponto1.x > pontoD.x)? ponto1.x : pontoD.x;
		int y1 = ponto1.y;
		
		int x2 = ponto2.x;
		int y2 = (ponto2.y < pontoD.y)? ponto2.y : pontoD.y;
			
		Retangulo ret = new Retangulo(x1, y1, x2, y2, cor);
		
		if(ret.valida()) return ret;
		
		return null;
    }
	
	public String toString() {
		return ponto1.x + " " + ponto1.y + " " + ponto2.x + " " + ponto2.y + " Cor:" + this.cor;
	}
}
