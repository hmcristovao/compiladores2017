package semantico;

public class Simbolo {
    private String nome;      // nome da variavel
    private Tipo tipo;
    private int referencia;   // refencia usada na geracao do codigo destino
    private static int marcador = 1; // armazena a ultima referencia incluida na tabela
    
    public Simbolo(String _nome, Tipo _tipo) { 
          this.nome = _nome;
          this.tipo = _tipo;
          this.referencia = Simbolo.marcador;
          Simbolo.marcador += 2; 
          
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
