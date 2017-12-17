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
.limit locals 5


; expressao infixa: 5  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 5]
ldc2_w 5.0

dstore 1

; expressao infixa: numero==4  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 4, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 4.0
dcmpg 
ifeq LABEL_00
dconst_0 
goto LABEL_01
LABEL_00:
dconst_1 
LABEL_01:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_1

; expressao infixa: numero==3  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 3, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 3.0
dcmpg 
ifeq LABEL_02
dconst_0 
goto LABEL_03
LABEL_02:
dconst_1 
LABEL_03:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_3

; expressao infixa: numero==2  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 2.0
dcmpg 
ifeq LABEL_04
dconst_0 
goto LABEL_05
LABEL_04:
dconst_1 
LABEL_05:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_5

; expressao infixa: numero==1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 1.0
dcmpg 
ifeq LABEL_06
dconst_0 
goto LABEL_07
LABEL_06:
dconst_1 
LABEL_07:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_7

; expressao infixa: numero==1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 1.0
dcmpg 
ifeq LABEL_08
dconst_0 
goto LABEL_09
LABEL_08:
dconst_1 
LABEL_09:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_9
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "OPTION Default"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "OPTION Default"]
ldc "OPTION Default"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFim_10
labelVerdadeiro_9: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "OPTION 1"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "OPTION 1"]
ldc "OPTION 1"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_10: 
goto labelFim_8
labelVerdadeiro_7: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "OPTION 1"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "OPTION 1"]
ldc "OPTION 1"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_8: 
goto labelFim_6
labelVerdadeiro_5: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "OPTION 2"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "OPTION 2"]
ldc "OPTION 2"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_6: 
goto labelFim_4
labelVerdadeiro_3: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "OPTION 3"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "OPTION 3"]
ldc "OPTION 3"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_4: 
goto labelFim_2
labelVerdadeiro_1: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "OPTION 4"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "OPTION 4"]
ldc "OPTION 4"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_2: 
return
.end method
