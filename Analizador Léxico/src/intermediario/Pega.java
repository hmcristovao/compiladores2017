package intermediario;

import java.util.LinkedList;
import parser.Token;

//OBS: na versão anterior continha a classe Token no package intermediario
public class Pega extends Comando {

	LinkedList<String> listaVariaveis;
	
	public Pega(){
		this.listaVariaveis = new LinkedList<Token>();		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return listaVariaveis.toString();
	}

	public void adicionaVariavel(String s){
		this.listaVariaveis.add(s);
	}
	
	public LinkedList<String> listarVariaveis(){
		return this.listaVariaveis;
	}
}
