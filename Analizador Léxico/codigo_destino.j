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


; expressao infixa: 1+2+(2*5)*7  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = +, item, tipo = CTE_NUMERO, valor = 2, item, tipo = CTE_NUMERO, valor = 5, item, tipo = OPERADOR, valor = *, item, tipo = CTE_NUMERO, valor = 7, item, tipo = OPERADOR, valor = *, item, tipo = OPERADOR, valor = +]
ldc2_w 1.0
ldc2_w 2.0
dadd
ldc2_w 2.0
ldc2_w 5.0
dmul
ldc2_w 7.0
dmul
dadd

dstore 1
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: numeroum  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numeroum]
dload_1

invokevirtual java/io/PrintStream/println(D)V 

; expressao infixa: ((numeroum+50*100)/2)*3  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numeroum, item, tipo = CTE_NUMERO, valor = 50, item, tipo = CTE_NUMERO, valor = 100, item, tipo = OPERADOR, valor = *, item, tipo = OPERADOR, valor = +, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = /, item, tipo = CTE_NUMERO, valor = 3, item, tipo = OPERADOR, valor = *]
dload_1
ldc2_w 50.0
ldc2_w 100.0
dmul
dadd
ldc2_w 2.0
ddiv
ldc2_w 3.0
dmul

dstore 3
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: numerodois  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numerodois]
dload_3

invokevirtual java/io/PrintStream/println(D)V 
return
.end method
