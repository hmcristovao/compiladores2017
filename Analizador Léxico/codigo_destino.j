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
.limit stack 10
.limit locals 7


; expressao infixa: 2*0*n+3*1+(0*x)/x  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 0, item, tipo = CTE_NUMERO, valor = 3, item, tipo = OPERADOR, valor = +, item, tipo = CTE_NUMERO, valor = 0, item, tipo = OPERADOR, valor = +]
ldc2_w 0.0
ldc2_w 3.0
dadd
ldc2_w 0.0
dadd

dstore 1
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: n  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = n]
dload_1

invokevirtual java/io/PrintStream/println(D)V 
return
.end method
