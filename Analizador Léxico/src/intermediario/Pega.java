package intermediario;

import intermediario2.PrimitivoComando;
import intermediario2.PrimitivoEntrada;
import intermediario2.PrimitivoListaComandos;
import intermediario2.PrimitivoPega;

import java.util.LinkedList;

import parser.CompiladorHell;
import semantico.Simbolo;
import semantico.Tabela;


public class Pega extends Comando {
	private String menssagem;
	private LinkedList<String> listaVariaveis;
	
	public Pega(){
		this.menssagem = null;
		this.listaVariaveis = new LinkedList<String>();		
	}
	
	public void adicionaVariavel(String s){
		this.listaVariaveis.add(s);
	}
	
	public LinkedList<String> listarVariaveis(){
		return this.listaVariaveis;
	}
	
	public String toString() {
		return "\n\nComando Pega: "
				+ "\nMenssagem: " + this.menssagem
				+ "\nlista de variaveis: " + this.listaVariaveis;
	}	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		Simbolo simbolo;
		if(menssagem != null)
			lista.add(new PrimitivoPega(this.menssagem));
		for(String var : listaVariaveis){
			simbolo = CompiladorHell.tabela.consultaSimbolo(var);
			lista.add(new PrimitivoEntrada(simbolo));
		}
		return lista;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
}
