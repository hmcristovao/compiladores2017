package destino;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import intermediario2.*;

public class CodigoDestino {
    
	private String codigoDestino = new String();
	
	public void geraCodigoAssembler(PrimitivoListaComandos lista) {
            // ...
		BufferedWriter arqSaida;
		try{
			arqSaida = new BufferedWriter(new FileWriter(nomeArquivoFonte + ".j"));
			arqSaida.write(".source "+nomeArquivoFonte+".java\r\n");
            arqSaida.write(".class public "+nomeArquivoFonte+"\r\n");
            arqSaida.write(".super java/lang/Object\r\n");
            arqSaida.write(".method public <init>()V\r\n");
            arqSaida.write(".limit stack 1\r\n");
            arqSaida.write(".limit locals 1\r\n");
            arqSaida.write("aload_0\r\n");
            arqSaida.write("invokespecial java/lang/Object/<init>()V\r\n");
            arqSaida.write("return\r\n");
            arqSaida.write(".end method\r\n\r\n");
            arqSaida.write(".method public static main([Ljava/lang/String;)V\r\n");
            //arqSaida.write(".limit stack "+(Expressao.getMaxPilha()+4)+"\r\n");  // +4 é devido ao comando de leitura que não usa expressao
            //arqSaida.write(".limit locals "+(Simbolo.getMarcador()+1)+"\r\n\r\n"); //o +1 se deve ao fato de ter de adicionar o this, todo programa deve possui-lo
            arqSaida.write(lista.geraCodigoDestino());
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
	
	
    public String toString() {
    	return codigoDestino.toString();
    }

}