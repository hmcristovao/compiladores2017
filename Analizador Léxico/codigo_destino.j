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
.limit stack 12
.limit locals 9


; expressao infixa: 1  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1]
ldc2_w 1.0

dstore 1

; expressao infixa: a+2*8*(a*5+4/2)*2+(2*5)*7  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = a, item, tipo = CTE_NUMERO, valor = 16.0, item, tipo = VAR_NUMERO, valor = a, item, tipo = CTE_NUMERO, valor = 5, item, tipo = OPERADOR, valor = *, item, tipo = CTE_NUMERO, valor = 2.0, item, tipo = OPERADOR, valor = +, item, tipo = OPERADOR, valor = *, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = *, item, tipo = OPERADOR, valor = +, item, tipo = CTE_NUMERO, valor = 70.0, item, tipo = OPERADOR, valor = +]
dload_1
ldc2_w 16.0
dload_1
ldc2_w 5.0
dmul
ldc2_w 2.0
dadd
dmul
ldc2_w 2.0
dmul
dadd
ldc2_w 70.0
dadd

dstore 3
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: numeroum  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numeroum]
dload_3

invokevirtual java/io/PrintStream/println(D)V 

; expressao infixa: 1+2-3  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = +, item, tipo = CTE_NUMERO, valor = 3, item, tipo = OPERADOR, valor = -]
ldc2_w 1.0
ldc2_w 2.0
dadd
ldc2_w 3.0
dsub

dstore 5
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: numerodois  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numerodois]
dload 5

invokevirtual java/io/PrintStream/println(D)V 
return
.end method
