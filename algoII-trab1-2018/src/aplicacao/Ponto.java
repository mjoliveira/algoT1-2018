package aplicacao;

public class Ponto {
	public int x; 
	public int y;

	public Ponto(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Ponto p) {
        return (x==p.x) && (y==p.y);
    }

	public String toString() {
		return "Ponto x : " + this.x + "\nPonto y: " + this.y;
	}

}
