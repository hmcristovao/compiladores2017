package semantica;

public class Simbolo {
    private String nome;      // nome da vari�vel
    private int referencia;   // refer�ncia usada na gera��o do c�digo destino
    private static int marcador = 1; // armazena a �ltima refer�ncia inclu�da na tabela
    private String tipo;
    
    public Simbolo(String _nome, String _tipo) {
          this.nome = _nome;
          this.tipo = _tipo;
          this.referencia = Simbolo.marcador;
          Simbolo.marcador += 2;         
    }
    public String getNome() {
          return this.nome;
    }
    public int getReferencia() {
          return this.referencia;
    }
    public String getTipo() {
		return this.tipo;
	}
    public String toString() {
          return "Tipo:"+this.getTipo() + " / " + "Nome:"+this.getNome() + " / " + "Refer�ncia:"+this.getReferencia() + "\n";
    }
}