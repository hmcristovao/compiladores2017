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
.limit stack 0
.limit locals 1


; expressao: [item, tipo = CTE_STRING, valor = "Hello world!"]
ldc "Hello world!"

getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
invokevirtual java/io/PrintStream/println(D)V 
return
.end method
