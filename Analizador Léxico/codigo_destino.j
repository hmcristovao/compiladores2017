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
.limit locals 9


; expressao infixa: 1  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1]
ldc2_w 1.0

dstore 1
LabelInicio_1: 

; expressao infixa: i<=10  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 10, item, tipo = OPERADOR, valor = <=]
dload_1
ldc2_w 10.0
dcmpg 
ifgt LABEL_00
dconst_1 
goto LABEL_01
LABEL_00: 
dconst_0 
LABEL_01: 

dconst_1 
dcmpg 
ifeq LabelCont_2
goto LabelFim_3
LabelCont_2: 

; expressao infixa: 1  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1]
ldc2_w 1.0

dstore 3
LabelInicio_4: 

; expressao infixa: j<=5  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = j, item, tipo = CTE_NUMERO, valor = 5, item, tipo = OPERADOR, valor = <=]
dload_3
ldc2_w 5.0
dcmpg 
ifgt LABEL_02
dconst_1 
goto LABEL_03
LABEL_02: 
dconst_0 
LABEL_03: 

dconst_1 
dcmpg 
ifeq LabelCont_5
goto LabelFim_6
LabelCont_5: 

; expressao infixa: 10  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 10]
ldc2_w 10.0

dstore 5
LabelInicio_7: 

; expressao infixa: k<=100  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = k, item, tipo = CTE_NUMERO, valor = 100, item, tipo = OPERADOR, valor = <=]
dload 5
ldc2_w 100.0
dcmpg 
ifgt LABEL_04
dconst_1 
goto LABEL_05
LABEL_04: 
dconst_0 
LABEL_05: 

dconst_1 
dcmpg 
ifeq LabelCont_8
goto LabelFim_9
LabelCont_8: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: i  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i]
dload_1

invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: " "  - expressao posfixa: [item, tipo = CTE_STRING, valor = " "]
ldc " "

invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: j  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = j]
dload_3

invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: " "  - expressao posfixa: [item, tipo = CTE_STRING, valor = " "]
ldc " "

invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: k  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = k]
dload 5

invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "\n"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "\n"]
ldc "\n"

invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 

; expressao infixa: k+(1/2)  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = /, item, tipo = VAR_NUMERO, valor = k, item, tipo = OPERADOR, valor = +]
ldc2_w 1.0
ldc2_w 2.0
ddiv
dload 5
dadd

dstore 5
goto LabelInicio_7
LabelFim_9: 

; expressao infixa: j+1  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1, item, tipo = VAR_NUMERO, valor = j, item, tipo = OPERADOR, valor = +]
ldc2_w 1.0
dload_3
dadd

dstore 3
goto LabelInicio_4
LabelFim_6: 

; expressao infixa: i+1  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1, item, tipo = VAR_NUMERO, valor = i, item, tipo = OPERADOR, valor = +]
ldc2_w 1.0
dload_1
dadd

dstore 1
goto LabelInicio_1
LabelFim_3: 
return
.end method
