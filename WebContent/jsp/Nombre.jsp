<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%--Esto es una directiva para utilizar la clase Date --%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<%--<link href="css/main.css" rel="stylesheet" type="text/css" > --%>

<title>Main Page</title>
</head>

<body>



	<div class="container">
		<%
			int numhojas = (int) request.getAttribute("numHojas");
			out.print(numhojas);
			ArrayList<String> hojasName = (ArrayList<String>) request.getAttribute("arrayhojas");
			out.println(hojasName.size());
			for (int i = 0; i < hojasName.size(); i++) {
				out.println(hojasName.get(i));
			}
		%>
		<nav class="nav">
			  <a class="nav-link active" href="#">Configurar</a>
			  <a class="nav-link" href="#">UF1</a>
			  <a class="nav-link" href="#">PRACTICA 1</a>
			  <a class="nav-link" href="#">PRACTICA 2</a>
			  <a class="nav-link" href="#">PRACTICA 3</a>
			  <a class="nav-link" href="#">EXAMEN 1</a>
			  <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
		</nav>
		<hr></hr>
		<table class="table table-striped">
			<%
 ArrayList<ArrayList<String>> excelTable =  (ArrayList<ArrayList<String>>) request.getAttribute("arraytable");
%>

			<tbody>
				<tr>
					<%
					for (int i = 2; i < excelTable.size(); i++) {
						for (int j = 0; j < excelTable.get(i).size(); j++) {
							out.print("<td>"+excelTable.get(i).get(j)+"</td>");
						}
						out.print("</tr>");
					}
    	
   					 %>
					
			</tbody>
		</table>
	</div>
	Bienvenido!
	<br class="rojo">
	<% 
	    out.print("hola soy isain7 y7 haciendo un ejemplo");
	
	%>
	<br>
	<div class="container-fluid">
		<% 
	
		out.println("");
		ArrayList<String> matriz = (ArrayList<String>) request.getAttribute("array");
		for (int i = 0; i < matriz.size(); i++) {
			out.print(matriz.get(i) + " | ");
		}
	%>
	</div>

	<br>
	<%--Comentarios: Esto es un comentario en JSP --%>

	<%--Esto es un scriptlet JSP --%>
	<%
		out.println();
	%>
	<%
		out.print("Hola mundo desde JSP");
	%>
	<button>esto es un boton</button>
	<br>
	<%--Esto es una expresión en JSP --%>
	<%="Esto es una expresión"%>
	<br>
	<%--Se declara una directiva para utilizar la clase Date <%@ page import="java.util.Date"  %> --%>
	<%
		Date d = new Date();
		out.println("Fecha Actual: " + d);
	%>
	<br>
	<%-- Declaraciones en JSP --%>
	<%!public static int contador = 7;%>
	<%
		out.println("Valor de la variable contador: " + contador);
	%>
	<br>
	<%--Navegador y Versión del Sistema Operativo --%>
	<%
		out.println(request.getHeader("USER-AGENT") + "<br/>");
	%>

	<%--Asi se imprime una Map --%>
	<%="Asi se imprime una Map"%>
	<table>
		<c:forEach items="${themeList}" var="entry">
			<tr>
				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${entry.value}" /></td>
			</tr>
		</c:forEach>
	</table>

	<%--Asi se imprime una matriz con librerias --%>
	<%="Asi se imprime una matriz con librerias"%>
	<table class="rojo">
		<c:forEach items="${matriz}" var="entry">
			<tr>
				<c:forEach items="${entry}" var="entryC">
					<td><c:out value="${entryC}" /></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>


	<%--Asi se imprime una array con java 
	<%="Asi se imprime una array con java"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.Iterator"%> 
	<%
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
	%>

	 <%  
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {    
			out.println(<iterator.next());
		}
	 %>--%>

	<button type="button" onclick="">Click me</button>
</body>
</html>