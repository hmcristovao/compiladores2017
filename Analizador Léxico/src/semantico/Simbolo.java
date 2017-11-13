package semantico;

public class Simbolo {
    private String nome;      // nome da vari�vel
    private Tipo tipo;
    private int referencia;   // refer�ncia usada na gera��o do c�digo destino
    private static int marcador = 1; // armazena a �ltima refer�ncia inclu�da na tabela
    
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
