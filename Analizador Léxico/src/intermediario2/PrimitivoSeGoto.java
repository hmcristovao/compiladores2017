package intermediario2;

import intermediario.*;

public class PrimitivoSeGoto  extends PrimitivoComando {
   private Expressao condicional;
   private PrimitivoLabel label; 
	
	// ...
   
   public PrimitivoSeGoto(Expressao condicional, PrimitivoLabel label){
	   this.condicional = condicional;
	   this.label = label;
   }
	
	public String geraCodigoDestino() {
		// gerar o c�digo destino em assembler (JVM do Java - ver material no AVA)
		String codigoFinal = null;
		// ...
		return codigoFinal;
	}
	
	public String toString() {
		// retornar a concatena��o dos atributos da classe, usando toString() para cada um
		return "";
	}
}
