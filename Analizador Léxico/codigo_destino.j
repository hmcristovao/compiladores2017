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
.limit locals 7


; expressao infixa: 10  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 10]
ldc2_w 10.0

dstore 1
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: numero  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero]
dload_1

invokevirtual java/io/PrintStream/println(D)V 

; expressao infixa: teste  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = teste]
dload_3

dstore 1
return
.end method
