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
.limit locals 5


; expressao infixa: i<10  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 10, item, tipo = OPERADOR, valor = <]
dload_1
ldc2_w 10.0

dconst_1 
dcmpg 
ifeq LabelInicio_1
goto LabelFim_2
LabelInicio_1: 

; expressao infixa: i+1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = +]
dload_1
ldc2_w 1.0
dadd

dstore 1
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: i  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i]
dload_1

invokevirtual java/io/PrintStream/println(D)V 

; expressao infixa: i<10  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 10, item, tipo = OPERADOR, valor = <]
dload_1
ldc2_w 10.0

dconst_1 
dcmpg 
ifeq LabelInicio_1
LabelFim_2: 
return
.end method
