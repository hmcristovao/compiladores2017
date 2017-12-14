package semantico;

public class Simbolo {
    private String nome;      // nome da variavel
    private Tipo tipo;
    private int referencia;   // refencia usada na geracao do codigo destino
    private boolean foiUsada;
    
    public Simbolo(String _nome, Tipo _tipo, int _referencia) { 
          this.nome = _nome;
          this.tipo = _tipo;
          this.referencia = _referencia;
          this.foiUsada = false;   //indica que a variavel não foi utilizada;
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
    public boolean foiUsada(){
    	return this.foiUsada;
    }
    public void setFoiUsada(){
    	this.foiUsada = true;
    }

    public String toString() {
          return "Nome:"+this.getNome() + " / " + "Tipo:"+Tipo.toStr(this.tipo)  + " / " + "Referencia:"+this.getReferencia() + "\n";
    }
}
