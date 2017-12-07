package intermediario2;

import intermediario.*;

public class PrimitivoSeGoto  extends PrimitivoComando {
   private Expressao condicional;
   private PrimitivoLabel label; 
	
	
   public PrimitivoSeGoto(Expressao condicional, PrimitivoLabel label){
	   this.condicional = condicional;
	   this.label = label;
   }
	
   public String geraCodigoDestino() {
		String codigoFinal = "";
		codigoFinal = condicional.geraCodigoDestino(); // GERAR CODIGO DESTINO DA EXPRESSAO
		codigoFinal = codigoFinal + "dconst_1 \n"; // EMPILHAR 0
		codigoFinal = codigoFinal + "dcmpg \n"; // EMPILHAR 0
		codigoFinal = codigoFinal + "ifeq " + this.label.getLabel() + "\n";
		return codigoFinal;
	}
	
	public String toString() {
		return "Comando primitivo SEGOTO: condicional: " + this.condicional.toString() + " - label: " + this.label.toString();
	}
}
