package dlince;
import java_cup.runtime.*;
%%
%{
/*-*
* funciones y variables
*/
public String textoImpreso = "";
private void imprimir(String descripcion, String lexema) {
System.out.println(lexema + " - " + descripcion);
textoImpreso = textoImpreso + lexema + " - " + descripcion + "\n";
}
%}
/*-*
* Información sobre la clase generada
*/
%public
%class AnalizadorLexico
%type void
/*-*
* Ajustes regulares
*/
BLANCO = [\n| |\t]
ID = [_|a-z|A-Z][a-z|A-Z|0-9|_]*
ENTERO = 0|[1-9][0-9]*
PUNTO_FLOTANTE = [0-9][0-9]*"."[0-9]+
SIMBOLO = (","|"¡"|"?"|"'")
OPERADORES_MATEMATICOS = ("+" | "-" | "*" | "/")
OPERADORES_LOGICOS = ("==" | "!=" | " =" | "%" | "and" | "or" | "!")
OPERADORES_RELACIONALES = ("<" | "<=" | ">" | ">=")
PARAMETRO = ("(" [_|a-z|A-Z][a-z|A-Z|0-9|_]* ")")
PARAMETRO_LOGICO = ("(" {ENTERO} ")")
FUNCION = ( [_|a-z|A-Z][a-z|A-Z|0-9|_]* "()")
PALABRAS_RESERVADAS = ("new"|"this"|"console.log"|"try"|"catch"|"finally"|"throw"|"class"|"interface"|"extends"|"implements"|"public"|"private"|"protected")
SENTENCIAS_CONDICIONALES = ("if"|"else"|"switch")
SENTENCIAS_CICLO = ("for"|"foreach"|"do"|"while")
SENTENCIAS = ("break"|"default"|"case"|"continue")

%%
"var" { imprimir("Declaracion variable universal", yytext()); }
"let" { imprimir("Declaracion variable", yytext()); }
"const" { imprimir("Declaracion constante", yytext()); }
"function" { imprimir("Declaracion funcion", yytext()); }
{BLANCO} { imprimir("Blanco", yytext()); }
{SENTENCIAS} { imprimir("Sentencia", yytext()); }
{SENTENCIAS_CONDICIONALES} { imprimir("Sentencia Condicional", yytext()); }
{SENTENCIAS_CICLO} { imprimir("Sentencia Ciclo", yytext()); }
{OPERADORES_MATEMATICOS} { imprimir("Operador matemático", yytext()); }
{OPERADORES_LOGICOS} { imprimir("Operador logico", yytext()); }
{OPERADORES_RELACIONALES} { imprimir("Operador relacional", yytext()); }
{FUNCION} { imprimir("Funcion", yytext()); }
{PARAMETRO} { imprimir("Parametro", yytext()); }
{PARAMETRO_LOGICO} { imprimir("Parametro logico", yytext()); }
{PALABRAS_RESERVADAS} { imprimir("Palabra Reservada", yytext()); }
{ID} { imprimir("caracteres", yytext()); }
{ENTERO} { imprimir("Numero entero", yytext()); }
{PUNTO_FLOTANTE} { imprimir("Punto flotante", yytext()); }
{SIMBOLO} { imprimir("simbolo", yytext()); }
"{" { imprimir("Abrir instrucion", yytext()); }
"}" { imprimir("Cerrar instruccion", yytext()); }
";" { imprimir("Fin de Instruccion", yytext()); }
. { throw new RuntimeException("Caracter inválido \""+yytext() +
"\" en la línea "+yyline+", columna "+yycolumn); }