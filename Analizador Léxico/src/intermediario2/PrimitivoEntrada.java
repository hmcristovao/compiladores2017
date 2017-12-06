package intermediario2;

import parser.CompiladorHell;
import semantico.*;

public class PrimitivoEntrada  extends PrimitivoComando {
   private Simbolo variavel;
   
   public PrimitivoEntrada(Simbolo variavel) {
		super();
		this.variavel = variavel;
		}
   	
	public PrimitivoEntrada() {
	}

	public Simbolo getVariavel() {
		return variavel;
	}

	public void setVariavel(Simbolo variavel) {
		this.variavel = variavel;
	}

	public String geraCodigoDestino() {
		String codigoFinal = "";
		int referencia = CompiladorHell.tabela.consultaReferencia(this.variavel.getNome());
		Tipo tipo = CompiladorHell.tabela.consultaTipo(this.variavel.getNome());

		codigoFinal += "new java/util/Scanner \r\n";
		codigoFinal += "dup \r\n";
		codigoFinal += "getstatic java/lang/System/in Ljava/io/InputStream; \r\n";
		codigoFinal += "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V \r\n";

		if(tipo == Tipo.VAR_STRING){
			System.out.println("PrimitivoEntrada: String: "+referencia);
			codigoFinal += "invokevirtual java/util/Scanner/nextLine()Ljava/lang/String; \r\n";
			codigoFinal += "astore "+referencia+"\r\n";
		}
		
		else {
			System.out.println("PrimitivoEntrada: Numero: "+referencia);
			codigoFinal += "invokevirtual java/util/Scanner/nextDouble()D \r\n";
			codigoFinal += "dstore "+referencia+"\r\n";
		}		
		return codigoFinal;
	}
	
	public String toString() {
		return "\nPrimitivoEntrada:"+" variavel: "+this.variavel.toString();
	}
}