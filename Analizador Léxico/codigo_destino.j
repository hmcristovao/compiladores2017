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
.limit stack 9
.limit locals 3


; expressao infixa: 2==2  - expressao posfixa: [item, tipo = CTE_BOOLEANO, valor = true]
ldc2_w 1.0 

dconst_1 
dcmpg 
ifeq labelVerdadeiro_1

; expressao infixa: 2==3  - expressao posfixa: [item, tipo = CTE_BOOLEANO, valor = false]
ldc2_w 0.0 

dconst_1 
dcmpg 
ifeq labelVerdadeiro_3
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "sao diferentes"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "sao diferentes"]
ldc "sao diferentes"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFim_4
labelVerdadeiro_3: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "sao iguais"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "sao iguais"]
ldc "sao iguais"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_4: 
goto labelFim_2
labelVerdadeiro_1: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "sao iguais"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "sao iguais"]
ldc "sao iguais"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_2: 
return
.end method
