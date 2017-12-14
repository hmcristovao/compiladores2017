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
.limit locals 7


; expressao infixa: 1+2  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = +]
ldc2_w 1.0
ldc2_w 2.0
dadd

dstore 1

; expressao infixa: numeroum  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numeroum]
dload_1

dstore 3
return
.end method
