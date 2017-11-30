package intermediario;

import java.util.*;

import semantico.*;

public class Expressao 
{
	// atributos tais como: lista de itens, linha, expressao infixa etc
	private LinkedList <Item> listaInfixo;
	private LinkedList <Item> listaPosfixo;
	private int linha;
	
	//construtor da classe inicializando duas listas
	public Expressao() {
		listaInfixo = new LinkedList<Item>();
		listaPosfixo = new LinkedList<Item>();
	}

	public LinkedList<Item> getListaInfixo() {
		return listaInfixo;
	}

	public LinkedList<Item> getListaPosfixo() {
		return listaPosfixo;
	}
	
	public void addItemInfixo(Item _item){
		listaInfixo.add(_item);
	}	
	public void addItemPosfixo(Item _item){
		listaPosfixo.add(_item);
	}	
}