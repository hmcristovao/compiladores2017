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
.limit stack 3
.limit locals 7


; expressao infixa: [item, tipo = CTE_NUMERO, valor = 10] - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 10]
ldc2_w 10.0

dstore 1

; expressao infixa: [item, tipo = CTE_BOOLEANO, valor = true] - expressao posfixa: [item, tipo = CTE_BOOLEANO, valor = true]

dstore 3
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: [item, tipo = VAR_NUMERO, valor = numero] - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero]
dload_1

invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: [item, tipo = VAR_BOOLEANO, valor = logico] - expressao posfixa: [item, tipo = VAR_BOOLEANO, valor = logico]
dload_3

invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: [item, tipo = VAR_NUMERO, valor = numero] - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero]
dload_1

invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: [item, tipo = VAR_BOOLEANO, valor = logico] - expressao posfixa: [item, tipo = VAR_BOOLEANO, valor = logico]
dload_3

invokevirtual java/io/PrintStream/println(D)V 
return
.end method
