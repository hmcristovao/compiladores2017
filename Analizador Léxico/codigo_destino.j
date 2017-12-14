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


; expressao infixa: 3  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 3]
ldc2_w 3.0

dstore 1
LabelInicioRepita_1: 
LabelInicioRepita_1: 
dload 1 
dconst_1 
dsub 
dstore 1
dload 1 
dconst_0 
dcmpg 
iflt LabelFim_3 
goto LabelCont_2 
LabelCont_2: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Teste do Comando Repita"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Teste do Comando Repita"]
ldc "Teste do Comando Repita"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto LabelInicioRepita_1
LabelFim_3: 
return
.end method
