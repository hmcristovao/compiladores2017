package intermediario2;

import intermediario.*;
import parser.CompiladorHell;
import semantico.Item;
import semantico.Tipo;

public class PrimitivoExibicao  extends PrimitivoComando {
   private Expressao expressao;
   
   public PrimitivoExibicao(Expressao expressao){
	   this.expressao = expressao;
   }
   public void setExpressao(Expressao expressao) {
	   this.expressao = expressao;
   }
   
   public String geraCodigoDestino() {
		String codigoFinal = null;
	
		for (Item it : this.expressao.getListaInfixo()) {
			if(it.getTipo() == Tipo.VAR_STRING) {
				System.out.println("PrimitivoExibicao: String: " + it.getValor());
				codigoFinal += "ldc " + it.getValor() + "\r\n";
				codigoFinal += "astore_3 \r\n";
				codigoFinal += "getstatic java/lang/System/out Ljava/io/PrintStream; \r\n";
				codigoFinal += "aload_3 \r\n";
				codigoFinal += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V \r\n";
			}
			else if(it.getTipo() == Tipo.VAR_NUMERO) {
				System.out.println("PrimitivoExibicao: Numero: " + it.getValor());
				codigoFinal += "ldc2_w " + it.getValor() + "/r/n";
				codigoFinal += "dstore_1 \r\n";
				codigoFinal += "getstatic java/lang/System/out Ljava/io/PrintStream; \r\n";
				codigoFinal += "dload_1 \r\n";
				codigoFinal += "invokevirtual java/io/PrintStream/println(D)V \r\n";

			}
		}
		
		return codigoFinal;
	}
	
	public String toString() {
		// retornar a concatenação dos atributos da classe, usando toString() para cada um
		return "";
	}
}

