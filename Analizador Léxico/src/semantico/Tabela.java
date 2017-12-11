package semantico;
import java.util.HashMap;

public class Tabela {
      private HashMap<String,Simbolo> tab;
      private int marcador; // armazena a ultima referencia incluida na tabela
      public Tabela() {
            this.tab = new HashMap<String,Simbolo>();
            this.marcador = 1;
      }
      public int getMarcador() {
          return this.marcador;
      }
      public int proximaReferencia() {
    	  int referenciaAtual = this.marcador;
    	  this.marcador += 2;
    	  return referenciaAtual;
      }
      
      public boolean inclui(Simbolo _simb) {
            if(this.tab.containsKey(_simb.getNome()))
                  return false;
            else {
                  this.tab.put(_simb.getNome(),_simb);
                  return true;
            }
      }
      public Simbolo consultaSimbolo(String _chave) {
          return this.tab.get(_chave);
      }
      public int consultaReferencia(String _chave) {
            return ((Simbolo)this.tab.get(_chave)).getReferencia();
      }
      public Tipo consultaTipo(String _chave) {
          return (this.tab.get(_chave).getTipo());
      }
      public boolean isExiste(String _chave) {
            return this.tab.containsKey(_chave);
      }
      public String toString() {
            return this.tab.toString();
      }
      
      public boolean isInicializada(String _var) {
  		return ((Simbolo)this.tab.get(_var)).getInicializada();
  	}
  	
  	public void setInicializada(String _chave){
  		((Simbolo)this.tab.get(_chave)).setInicializada(true);
  	}
  	
  	public void warning(){ 
  		System.out.println("\n");
  		for(String _chave : this.tab.keySet()){
  			if(!this.tab.get(_chave).getInicializada()){ //Verifica se a variavel foi declarada e nao foi inicializada
  				System.out.println("Warning: variavel " + this.tab.get(_chave).getNome() + " foi declarada e nao foi inicializada.");
  			}
  		}
  	}
}