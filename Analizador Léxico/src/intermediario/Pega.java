package intermediario;

import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

public class Pega extends Comando {

	LinkedList<String> listaVariaveis;
	
	public Pega(){
		this.listaVariaveis = new LinkedList<String>();		
	}
	
	public void adicionaVariavel(String s){
		this.listaVariaveis.add(s);
	}
	
	public LinkedList<String> listarVariaveis(){
		return this.listaVariaveis;
	}
	
	public String toString() {
		return "\n\nComando Pega, lista de variaveis: " + this.listaVariaveis;
	}	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		/* falta implementar ... */  
		return null;
	}

	

}
