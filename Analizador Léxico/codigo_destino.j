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
.limit stack 4
.limit locals 3

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Hello" 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
return
.end method
