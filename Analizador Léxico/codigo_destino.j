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

getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Digite um numero de 1 a 10"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Digite um numero de 1 a 10"]
ldc "Digite um numero de 1 a 10"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()D 
dstore 1

; expressao infixa: numero==10  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 10, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 10.0
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

; expressao infixa: numero==9  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 9, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 9.0
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

; expressao infixa: numero==8  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 8, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 8.0
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

; expressao infixa: numero==7  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 7, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 7.0
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

; expressao infixa: numero==6  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 6, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 6.0
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

; expressao infixa: numero==5  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 5, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 5.0
dcmpg 
ifeq LABEL_010
dconst_0 
goto LABEL_011
LABEL_010:
dconst_1 
LABEL_011:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_11

; expressao infixa: numero==4  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 4, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 4.0
dcmpg 
ifeq LABEL_012
dconst_0 
goto LABEL_013
LABEL_012:
dconst_1 
LABEL_013:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_13

; expressao infixa: numero==3  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 3, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 3.0
dcmpg 
ifeq LABEL_014
dconst_0 
goto LABEL_015
LABEL_014:
dconst_1 
LABEL_015:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_15

; expressao infixa: numero==2  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 2.0
dcmpg 
ifeq LABEL_016
dconst_0 
goto LABEL_017
LABEL_016:
dconst_1 
LABEL_017:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_17

; expressao infixa: numero==1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = ==]
dload_1
ldc2_w 1.0
dcmpg 
ifeq LABEL_018
dconst_0 
goto LABEL_019
LABEL_018:
dconst_1 
LABEL_019:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_19
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Calma lá, eu pedi pra você digitar um numero entre 1 e 10, e vc digita: "  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Calma lá, eu pedi pra você digitar um numero entre 1 e 10, e vc digita: "]
ldc "Calma lá, eu pedi pra você digitar um numero entre 1 e 10, e vc digita: "

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: numero  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = numero]
dload_1

invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Ta de sacanagem, né??"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Ta de sacanagem, né??"]
ldc "Ta de sacanagem, né??"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFim_20
labelVerdadeiro_19: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 1"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 1"]
ldc "Você digitou 1"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_20: 
goto labelFim_18
labelVerdadeiro_17: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 2"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 2"]
ldc "Você digitou 2"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_18: 
goto labelFim_16
labelVerdadeiro_15: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 3"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 3"]
ldc "Você digitou 3"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_16: 
goto labelFim_14
labelVerdadeiro_13: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 4"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 4"]
ldc "Você digitou 4"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_14: 
goto labelFim_12
labelVerdadeiro_11: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 5"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 5"]
ldc "Você digitou 5"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_12: 
goto labelFim_10
labelVerdadeiro_9: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 6"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 6"]
ldc "Você digitou 6"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_10: 
goto labelFim_8
labelVerdadeiro_7: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 7"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 7"]
ldc "Você digitou 7"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_8: 
goto labelFim_6
labelVerdadeiro_5: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 8"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 8"]
ldc "Você digitou 8"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_6: 
goto labelFim_4
labelVerdadeiro_3: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 9"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 9"]
ldc "Você digitou 9"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_4: 
goto labelFim_2
labelVerdadeiro_1: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Você digitou 10"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Você digitou 10"]
ldc "Você digitou 10"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_2: 
return
.end method
