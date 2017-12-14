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
.limit locals 9


; expressao infixa: "AAAABBBBBCCCCCCCC"++aux  - expressao posfixa: [item, tipo = CTE_STRING, valor = "AAAABBBBBCCCCCCCC", item, tipo = OPERADOR, valor = ++, item, tipo = VAR_STRING, valor = aux]
ldc "AAAABBBBBCCCCCCCC"
aload_3

astore 1
return
.end method
