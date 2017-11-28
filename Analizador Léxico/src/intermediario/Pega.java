package intermediario;

import java.util.LinkedList;

public class Pega extends Comando {

	LinkedList<String> listaVariaveis;
	
	public Pega(){
		this.listaVariaveis = new LinkedList<String>();		
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
