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

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Testando msg escrota: " 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()D 
dstore 1
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()D 
dstore 3
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: n  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = n]
dload_1

invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 

; expressao infixa: a  - expressao posfixa: [item, tipo = VAR_NUMERO, valor = a]
dload_3

invokevirtual java/io/PrintStream/println(D)V 
return
.end method
