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


; expressao infixa: "AAAABBBBBCCCCCCCC"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "AAAABBBBBCCCCCCCC"]
ldc "AAAABBBBBCCCCCCCC"

astore 1
return
.end method
