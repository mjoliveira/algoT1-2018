package aplicacao;

public class Quadtree {
	private Nodo raiz;

    public Quadtree() {
    }

    public void add(Retangulo ret){

        if (raiz == null) {
            raiz = new Nodo(ret);
        } else {
            addFilho(raiz, ret);
        }

    }
	
    private void addFilho(Nodo pai, Retangulo retFilho){
        if(pai.ret.cor != null) return;

        if(pai.pontoDivisor == null){
            pai.inserir(retFilho.ponto1);
            Nodo quadrante = pai.possuiPonto(retFilho.ponto2);
            
            if(quadrante != null){
                quadrante.inserir(retFilho.ponto2);
                Nodo quadranteRet = quadrante.localizarRetangulo(retFilho);
                
                if (quadranteRet != null) {
                    quadranteRet.ret.cor = retFilho.cor;
                    Controle.dicionario.put(retFilho.cor, Controle.dicionario.get(retFilho.cor) + retFilho.calculaArea());
                } 
                
            }
            
        }else{

            Retangulo ret1 = retFilho.getFilho1(pai.pontoDivisor);
            if(ret1 != null) addFilho(pai.filho1, ret1);

            Retangulo ret2 = retFilho.getFilho2(pai.pontoDivisor);
            if(ret2 != null) addFilho(pai.filho2, ret2);

            Retangulo ret3 = retFilho.getFilho3(pai.pontoDivisor);
            if(ret3 != null) addFilho(pai.filho3, ret3);

            Retangulo ret4 = retFilho.getFilho4(pai.pontoDivisor);
            if(ret4 != null) addFilho(pai.filho4, ret4);			

        }
    }
	 
	class Nodo {
		Retangulo ret;  
	    Ponto pontoDivisor;
	    Nodo filho1;
	    Nodo filho2;
	    Nodo filho3;
	    Nodo filho4;

	    public Nodo(Retangulo retangulo) {
	    	this.ret = retangulo;
	    }
	    
	    public void inserir(Ponto ponto){
            pontoDivisor = ponto;
            
            Retangulo ret1 = new Retangulo(ret.ponto1.x, pontoDivisor.y, pontoDivisor.x, ret.ponto2.y, null);
            Retangulo ret2 = new Retangulo(pontoDivisor.x, pontoDivisor.y, ret.ponto2.x, ret.ponto2.y, null);
            Retangulo ret3 = new Retangulo(ret.ponto1.x, ret.ponto1.y, pontoDivisor.x, pontoDivisor.y, null);
            Retangulo ret4 = new Retangulo(pontoDivisor.x, ret.ponto1.y, ret.ponto2.x, pontoDivisor.y, null);

            if(ret1.valida()) filho1 = new Nodo(ret1);
            if(ret2.valida()) filho2 = new Nodo(ret2);
            if(ret3.valida()) filho3 = new Nodo(ret3);
            if(ret4.valida()) filho4 = new Nodo(ret4);

        }
	    
	    public Nodo possuiPonto(Ponto ponto2){
            if(filho1 != null && filho1.ret.possui(ponto2)) return filho1;
            if(filho2 != null && filho2.ret.possui(ponto2)) return filho2;
            if(filho3 != null && filho3.ret.possui(ponto2)) return filho3;
            if(filho4 != null && filho4.ret.possui(ponto2)) return filho4;

            return null;
        }
	    
	    public Nodo localizarRetangulo(Retangulo retFilho){

            if(filho1 != null && filho1.ret.iguais(retFilho)) return filho1;
            if(filho2 != null && filho2.ret.iguais(retFilho)) return filho2;
            if(filho3 != null && filho3.ret.iguais(retFilho)) return filho3;
            if(filho4 != null && filho4.ret.iguais(retFilho)) return filho4;

            return null;

        }
	    
	 }
}
