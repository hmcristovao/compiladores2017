package intermediario2;

import intermediario.*;
import parser.CompiladorHell;

public class PrimitivoLoop  extends PrimitivoComando {
   private PrimitivoLabel label; 
   private String var;
   private int cont=0;
   
   public PrimitivoLoop(PrimitivoLabel label, String var, int cont){
	   this.label = label;
	   this.setVar(var);
	   this.cont = cont;
   }
	
   public String geraCodigoDestino() {
		String codigoFinal = "";
		int referenciaDaVariavel = 0;
		referenciaDaVariavel = CompiladorHell.tabela.consultaReferencia(var);
		if(cont == 0){
			if( referenciaDaVariavel < 4 ){
				codigoFinal += "dload_" + referenciaDaVariavel + "\r\n";
			}
			else {
				codigoFinal += "dload " + referenciaDaVariavel + "\r\n";
			}
			codigoFinal+="ldc2_w 0.0\r\n";
			codigoFinal+="dcmpg \r\n";
			codigoFinal+="ifeq LOOPLABEL\r\n";
			if( referenciaDaVariavel < 4 ){
				codigoFinal += "dload_" + referenciaDaVariavel + "\r\n";
			}
			else {
				codigoFinal += "dload " + referenciaDaVariavel + "\r\n";
			}
			codigoFinal+="ldc2_w 0.0\r\n";
			codigoFinal+="dsub\r\n";
			codigoFinal+="dstore "+CompiladorHell.tabela.getMarcador()+"\r\n";
		}
		
		if(cont == 1){
			codigoFinal += "dload "+CompiladorHell.tabela.getMarcador()+"\r\n";
			codigoFinal += "ldc2_w 1.0\r\n";
			codigoFinal += "dsub\r\n";
			codigoFinal += "dstore "+CompiladorHell.tabela.getMarcador()+"\r\n";
			codigoFinal += "dload "+CompiladorHell.tabela.getMarcador()+"\r\n";
			codigoFinal += "ldc2_w 0.0\r\n";
			codigoFinal += "dcmpg \r\n";
			codigoFinal += "ifeq LOOPLABEL\r\n";
			codigoFinal += "goto "+ label.getLabel() +"\r\n";
			codigoFinal += "LOOPLABEL:\r\n";
		}	
		return codigoFinal;
	}
	
	public String toString() {
		return "Comando primitivo LOOP: label: " + this.label.toString();
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
}