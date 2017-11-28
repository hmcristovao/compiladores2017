package intermediario;

import java.util.*;

import semantico.*;

public class Expressao 
{
	// atributos tais como: lista de itens, linha, expressao infixa etc
	LinkedList <Item> listaInfixo;
	LinkedList <Item> listaPosfixo;
	LinkedList <Item> pilha = new LinkedList <Item>();
	int linha;
	
	//construtor da classe inicializando duas listas
	public Expressao() {
		listaInfixo = new LinkedList<Item>();
		listaPosfixo = new LinkedList<Item>();
		pilha = new LinkedList <Item>();
	}

	public LinkedList<Item> getListaInfixo() {
		return listaInfixo;
	}

	public LinkedList<Item> getListaPosfixo() {
		return listaPosfixo;
	}
	
	public void addItem(Item _item){
		listaInfixo.add(_item);
		gerarPosfixo(_item);
	}
	
	//o método gerar posfixo vai avaliando a entrada e colocando no formato pósfixo.
	public void gerarPosfixo(Item _item){
		
		if(_item.getTipo() == Tipo.VAR_NUMERO || _item.getTipo() == Tipo.CTE_NUMERO || _item.getTipo() == Tipo.VAR_STRING || _item.getTipo() == Tipo.CTE_STRING)
			listaPosfixo.add(_item);
		
		if(_item.getValor() == "(")
			pilha.add(_item);
		
		if(_item.getValor() == ")"){
			while (!pilha.isEmpty() && pilha.getLast().getValor() != "("){
				listaPosfixo.add(pilha.getLast());
				pilha.removeLast();
				}
			
			if (pilha.getLast().getValor() == "(")
				pilha.removeLast();
		}
		
		
		if(_item.getTipo() == Tipo.OPERADOR){
			if(pilha.isEmpty())
				pilha.add(_item);
			else{
				if (pilha.getLast().getValor() == "(")
					pilha.add(_item);
				if (pilha.getLast().getTipo() == Tipo.OPERADOR){
					if(verificarPrioridade(_item.getValor(),pilha.getLast().getValor()))
						pilha.add(_item);
					else{
						listaPosfixo.add(pilha.getLast());
						pilha.removeLast();
						pilha.add(_item);
					}		
				}
			}
		}
	}
	
	public void gerarPosfixo(){
		while (!pilha.isEmpty()){
			if (pilha.getLast().getTipo() == Tipo.OPERADOR)
				listaPosfixo.add(pilha.getLast());
			pilha.removeLast();
		}
	}
	
	public boolean verificarPrioridade(String c, String t){
		
		int pc=0, pt=0;
				if ( c == "**")
			pc = 10;
		else if (c == "*" || c == "/")
			pc = 8;
		else if (c == ">" || c == "<" || c == ">=" || c == "<=" || c == "!=" || c == "==")
			pc = 6;
		else if (c == "+" || c == "-")
			pc = 7;
		else if (c == "N")
			pc = 5;
		else if (c == "EE")
			pc = 4;
		else if (c == "E")
			pc = 3;
		else if (c == "O")
			pc = 2;
		else if (c == "++")
			pc = 1;
				
				
		if ( t == "**")
			pt = 9;
		else if (t == "*" || t == "/")
			pt = 8;
		else if (t == ">" || t == "<" || t == ">=" || t == "<=" || t == "!=" || t == "==")
			pt = 6;
		else if (t == "+" || t == "-")
			pt = 7;
		else if (t == "N")
			pt = 5;
		else if (t == "EE")
			pt = 4;
		else if (t == "E")
			pt = 3;
		else if (t == "O")
			pt = 2;
		else if (t == "++")
			pt = 1;
		
		return (pc > pt);
	}
	
}