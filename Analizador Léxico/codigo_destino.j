.source codigo_destino.java
.class public codigo_destino
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 5


; expressao infixa: 5  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 5]
ldc2_w 5.0

dstore 1
LabelInicio_1: 
LabelCont_2: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "teste de repita"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "teste de repita"]
ldc "teste de repita"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto LabelInicio_1
LabelFim_3: 
return
.end method
