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
.limit locals 11


; expressao infixa: 7  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 7]
ldc2_w 7.0

dstore 1

; expressao infixa: false  - expressao posfixa: [item, tipo = CTE_BOOLEANO, valor = false]
ldc2_w 0.0 

dstore 5

; expressao infixa: 1  - expressao posfixa: [item, tipo = CTE_NUMERO, valor = 1]
ldc2_w 1.0

dstore 7
LabelInicio_1: 

; expressao infixa: acertou==false  - expressao posfixa: [item, tipo = VAR_BOOLEANO, valor = acertou, item, tipo = CTE_BOOLEANO, valor = false, item, tipo = OPERADOR, valor = ==]
dload 5
ldc2_w 0.0 
dcmpg 
ifeq LABEL_00
dconst_0 
goto LABEL_01
LABEL_00:
dconst_1 
LABEL_01:

dconst_1 
dcmpg 
ifeq LabelCont_2
goto LabelFim_3
LabelCont_2: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "-------------------------------"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "-------------------------------"]
ldc "-------------------------------"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Tentativa:"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Tentativa:"]
ldc "Tentativa:"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: i  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i]
dload 7

invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Tente advinhar o numero magico (1 a 10)"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Tente advinhar o numero magico (1 a 10)"]
ldc "Tente advinhar o numero magico (1 a 10)"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()D 
dstore 3

; expressao infixa: escolha==numeromagico  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = escolha, item, tipo = VAR_NUMERO, valor = numeromagico, item, tipo = OPERADOR, valor = ==]
dload_3
dload_1
dcmpg 
ifeq LABEL_02
dconst_0 
goto LABEL_03
LABEL_02:
dconst_1 
LABEL_03:

dconst_1 
dcmpg 
ifeq labelVerdadeiro_4

; expressao infixa: escolha<=numeromagico  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = escolha, item, tipo = VAR_NUMERO, valor = numeromagico, item, tipo = OPERADOR, valor = <=]
dload_3
dload_1
dcmpg 
ifgt LABEL_04
dconst_1 
goto LABEL_05
LABEL_04: 
dconst_0 
LABEL_05: 

dconst_1 
dcmpg 
ifeq labelVerdadeiro_6
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Errou! O numero magico eh menor"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Errou! O numero magico eh menor"]
ldc "Errou! O numero magico eh menor"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFim_7
labelVerdadeiro_6: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Errou! O numero magico eh maior"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Errou! O numero magico eh maior"]
ldc "Errou! O numero magico eh maior"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFim_7: 
goto labelFim_5
labelVerdadeiro_4: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Parabens, voce acertou!!!"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Parabens, voce acertou!!!"]
ldc "Parabens, voce acertou!!!"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 

; expressao infixa: true  - expressao posfixa: [item, tipo = CTE_BOOLEANO, valor = true]
ldc2_w 1.0 

dstore 5
labelFim_5: 

; expressao infixa: i+1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = +]
dload 7
ldc2_w 1.0
dadd

dstore 7
goto LabelInicio_1
LabelFim_3: 

; expressao infixa: i-1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = -]
dload 7
ldc2_w 1.0
dsub

dstore 7

; expressao infixa: i==1  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 1, item, tipo = OPERADOR, valor = ==]
dload 7
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
ifeq labelCondicaoVerdadeira_9
goto labelProximoTeste_10
labelCondicaoVerdadeira_9: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Completamente cagado!!!"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Completamente cagado!!!"]
ldc "Completamente cagado!!!"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFimTeste_8
labelProximoTeste_10: 

; expressao infixa: i==2  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 2, item, tipo = OPERADOR, valor = ==]
dload 7
ldc2_w 2.0
dcmpg 
ifeq LABEL_08
dconst_0 
goto LABEL_09
LABEL_08:
dconst_1 
LABEL_09:

dconst_1 
dcmpg 
ifeq labelCondicaoVerdadeira_11
goto labelProximoTeste_12
labelCondicaoVerdadeira_11: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Sortudo!!!"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Sortudo!!!"]
ldc "Sortudo!!!"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFimTeste_8
labelProximoTeste_12: 

; expressao infixa: i<=4  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = i, item, tipo = CTE_NUMERO, valor = 4, item, tipo = OPERADOR, valor = <=]
dload 7
ldc2_w 4.0
dcmpg 
ifgt LABEL_010
dconst_1 
goto LABEL_011
LABEL_010: 
dconst_0 
LABEL_011: 

dconst_1 
dcmpg 
ifeq labelCondicaoVerdadeira_13
goto labelProximoTeste_14
labelCondicaoVerdadeira_13: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "Nada de mais."  - expressao posfixa: [item, tipo = CTE_STRING, valor = "Nada de mais."]
ldc "Nada de mais."

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
goto labelFimTeste_8
labelProximoTeste_14: 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: "ixi ... va estudar busca binaria!"  - expressao posfixa: [item, tipo = CTE_STRING, valor = "ixi ... va estudar busca binaria!"]
ldc "ixi ... va estudar busca binaria!"

invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
labelFimTeste_8: 
return
.end method
