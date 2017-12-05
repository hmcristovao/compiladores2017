package destino;


import java.io.BufferedWriter;

import semantico.*;

import java.io.FileWriter;
import java.io.IOException;

import apoio.Config;
import intermediario.Expressao;
import intermediario2.*;

public class CodigoDestino {
    
	private String codigoDestino = new String();
	
	public void geraCodigoAssembler(PrimitivoListaComandos lista) {
            // ...
		BufferedWriter arqSaida;
		try{
			arqSaida = new BufferedWriter(new FileWriter(Config.nomeCodigoDestino + ".j"));
			arqSaida.write(".source "+Config.nomeCodigoDestino+".java\r\n");
            arqSaida.write(".class public "+Config.nomeCodigoDestino+"\r\n");
            arqSaida.write(".super java/lang/Object\r\n");
            arqSaida.write(".method public <init>()V\r\n");
            arqSaida.write(".limit stack 1\r\n");
            arqSaida.write(".limit locals 1\r\n");
            arqSaida.write("aload_0\r\n");
            arqSaida.write("invokespecial java/lang/Object/<init>()V\r\n");
            arqSaida.write("return\r\n");
            arqSaida.write(".end method\r\n\r\n");
            arqSaida.write(".method public static main([Ljava/lang/String;)V\r\n");
            arqSaida.write(".limit stack "+(Expressao.getMaxPilha())+"\r\n");  
            arqSaida.write(".limit locals "+(Simbolo.getMarcador())+"\r\n\r\n"); 
            arqSaida.write(processaListaComandos(lista));
            arqSaida.write("return\r\n");
            arqSaida.write(".end method\r\n");
            arqSaida.close();
		}catch(IOException e){
			System.out.println("Problemas na geracao do codigo destino");
			System.exit(1);
		}catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
	
	static String processaListaComandos(PrimitivoListaComandos lista){
		String saida="";
		for(PrimitivoComando com: lista.comandos){
			saida+=com.geraCodigoDestino();
		}
		return saida;
	}
	
	
    public String toString() {
    	return codigoDestino.toString();
    }

}