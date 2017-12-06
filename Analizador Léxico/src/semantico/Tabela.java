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
}