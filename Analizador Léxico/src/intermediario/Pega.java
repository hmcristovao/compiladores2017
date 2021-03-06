package intermediario;

import intermediario2.PrimitivoComando;
import intermediario2.PrimitivoEntrada;
import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

import parser.CompiladorHell;
import semantico.Simbolo;
import semantico.Tabela;


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
		return "\n\nComando Pega: lista de variaveis: " + this.listaVariaveis;
	}	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		Simbolo simbolo;
		for(String var : listaVariaveis){
			simbolo = CompiladorHell.tabela.consultaSimbolo(var);
			lista.add(new PrimitivoEntrada(simbolo));
		}
		return lista;
	}
}
