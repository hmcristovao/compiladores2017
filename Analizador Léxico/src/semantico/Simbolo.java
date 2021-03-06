package semantico;

public class Simbolo {
    private String nome;      // nome da variavel
    private Tipo tipo;
    private int referencia;   // refencia usada na geracao do codigo destino
    
    public Simbolo(String _nome, Tipo _tipo, int _referencia) { 
          this.nome = _nome;
          this.tipo = _tipo;
          this.referencia = _referencia;
    }
    public String getNome() {
          return this.nome;
    }
    public Tipo getTipo() {
          return this.tipo;
    }
    public int getReferencia() {
          return this.referencia;
    }

    public String toString() {
          return "Nome:"+this.getNome() + " / " + "Tipo:"+Tipo.toStr(this.tipo)  + " / " + "Referencia:"+this.getReferencia() + "\n";
    }
}
