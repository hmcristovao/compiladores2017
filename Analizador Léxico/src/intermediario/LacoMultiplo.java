package intermediario;


import java.util.Iterator;

import intermediario2.PrimitivoAtribuicao;
import intermediario2.PrimitivoGoto;
import intermediario2.PrimitivoLabel;
import intermediario2.PrimitivoListaComandos;
import intermediario2.PrimitivoSeGoto;

import java.util.LinkedList;

import parser.CompiladorHell;
import semantico.*;

// erro: nao esta armazenando a lista de comandos aqui e nem na classe BlocoLacoMultiplo

public class LacoMultiplo extends Comando{
	private LinkedList<BlocoLacoMultiplo> listaBloco;
	private int contador;
	private ListaComandos listaComandos;
	
	public LacoMultiplo(){
		this.listaBloco = new LinkedList<BlocoLacoMultiplo>();
		this.contador  = 0;
		this.listaComandos = new ListaComandos();
	}
	public void incluiBloco(BlocoLacoMultiplo novoBloco){
		this.listaBloco.addLast(novoBloco);
	}
	public void addFaixa (Expressao _expFrom,Expressao _expTo,Expressao _expStep){
		this.listaBloco.get(contador).addFaixa(_expFrom, _expTo, _expStep);
		this.contador++;
	}
	public ListaComandos getListaComandos() {
		return this.listaComandos;
	}
	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}
	public String toString() {
		return "\n\nComando Laco Multiplo: lista de blocos = " + this.listaBloco + 
				"- contador = " + this.contador + this.listaComandos;
	}


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		Iterator<BlocoLacoMultiplo> it = listaBloco.descendingIterator();
		ListaComandos command = new ListaComandos();
		command = conversao(it.next(),this.listaComandos);
		while(it.hasNext()){
			command = conversao(it.next(),command);
		}
		lista = command.geraListaPrimitivoComando();
		return lista;
	}
	public ListaComandos conversao(BlocoLacoMultiplo block,ListaComandos com){
		ListaComandos lista = new ListaComandos();
		
		String varControle = block.getVar();
		Expressao expInicial = block.getExpFrom();
		Expressao expComp = block.getExpTo();
		Expressao expItr = block.getExpStep();
		
		
		Simbolo simbolo = CompiladorHell.tabela.consultaSimbolo(block.getVar());
		
		Item auxiliar = new Item(simbolo.getTipo(),simbolo.getNome());	
	
		Item comparador = new Item(Tipo.OPERADOR,"<=");	
		
		expComp.getListaInfixo().addFirst(comparador);
		expComp.getListaInfixo().addFirst(auxiliar);
		expComp.getListaPosfixo().addFirst(auxiliar);
		expComp.addPosfixo(comparador);
		
		Item operador = new Item(Tipo.OPERADOR,"+");
		
		expItr.getListaInfixo().addFirst(operador);
		expItr.getListaInfixo().addFirst(auxiliar);
		expItr.addPosfixo(auxiliar);
		expItr.addPosfixo(operador);
		
		
		Laco laco = new Laco(varControle,expInicial,expComp,expItr,com);
		lista.add(laco);
		return lista;
	}
}