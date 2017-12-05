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
		String codigoFinal = null;
		PrimitivoExibicao exp = new PrimitivoExibicao(condicional);
		codigoFinal = exp.geraCodigoDestino(); // GERAR CODIGO DESTINO DA EXPRESSAO
		codigoFinal = codigoFinal + "\n iconst_0"; // EMPILHAR 0
		codigoFinal = codigoFinal + "\n ifeq " + label.geraCodigoDestino();
		return codigoFinal;
	}
	
	public String toString() {
		return "Se " + condicional.toString() + "vai para " + label.toString();
	}
}
