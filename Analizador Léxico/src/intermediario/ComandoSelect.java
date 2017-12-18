package intermediario;

import intermediario2.PrimitivoListaComandos;
import parser.CompiladorHell;
import semantico.Item;
import semantico.Simbolo;
import semantico.Tipo;

import java.util.LinkedList;

public class ComandoSelect extends Comando {
	
	
	private String variavel;
	private ListaComandos padrao;
	private LinkedList<Item> itens;
	private LinkedList<ListaComandos> listasComando;
	
	public ComandoSelect() {
		this.itens = new LinkedList<Item>();
		this.listasComando = new LinkedList<ListaComandos>();
	}
	
	public ListaComandos getPadrao() {
		return this.padrao;
	}
	public void setPadrao(ListaComandos padrao) {
		this.padrao = padrao;
	}
	public LinkedList<Item> getItens() {
		return this.itens;
	}
	public void addItem(Item item) {
		this.itens.add(item); 
	}
	public LinkedList<ListaComandos> getListasComando() {
		return this.listasComando;
	}
	public void addListaComandos(ListaComandos listaComandos) {
		this.listasComando.add(listaComandos);
	}
	public String getVariavel() {
		return this.variavel;
	}
	public void setVariavel(String variavel) {
		this.variavel = variavel;
	}
	public ListaComandos conversao(Item itemConstante, ListaComandos listaSe, ListaComandos listaSenao ){
		ListaComandos lista = new ListaComandos();
		
		Expressao expComparacao = new Expressao();		
		
		Simbolo simbolo = CompiladorHell.tabela.consultaSimbolo(this.variavel);
		
		Item auxiliar = new Item(simbolo.getTipo(),simbolo.getNome());	
	
		Item comparador = new Item(Tipo.OPERADOR,"==");
		
		expComparacao.getListaInfixo().addFirst(itemConstante);
		expComparacao.getListaInfixo().addFirst(comparador);
		expComparacao.getListaInfixo().addFirst(auxiliar);
		
		expComparacao.addPosfixo(auxiliar);
		expComparacao.addPosfixo(itemConstante);
		expComparacao.addPosfixo(comparador);
		
		
		SeSenao seSenao = new SeSenao(expComparacao,listaSe,listaSenao);
		lista.add(seSenao);
		return lista;
	}
	@Override
	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		ListaComandos command = new ListaComandos();
		command = conversao(this.itens.get(0),this.listasComando.get(0),padrao);
		for (int i = 1 ; i < this.itens.size(); i++) {
			command = conversao(this.itens.get(i),this.listasComando.get(i),command);
		}
		lista = command.geraListaPrimitivoComando();
		return lista;
	}
	
	@Override
	public String toString() {
		String itens = "";
		for (Item item : this.itens) {
			itens+= item.toString()+" | ";
		}
		String comandos = "";
		for (ListaComandos listaComandos : this.listasComando) {
			comandos+= listaComandos.toString()+"\n";
		}
		return "\n\nComando Select: variavel: " + this.variavel + " | options: " + "\nItens -> "+itens+"\nComandos ->"+comandos;
		
	}
}
