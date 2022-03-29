<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.shohin.Shohin" %>
<%@ page import = "model.shohin.ShohinBunrui" %>
<%@ page import ="java.util.*" %>
<%@ page import="model.shohin.ConfirmErrorCheck" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>商品更新</title>
</head>
<body>

<h1>商品更新</h1>
<%
ConfirmErrorCheck message = (ConfirmErrorCheck)request.getAttribute("message");
if(message!=null){
%>
<%= message %>
<%
}
%>

<form action="/shohinKanri_18/ConfirmedUpdateShohin" method="get">
商品ID：<input type="text" name="shohin_id" value=""><br>
商品名：<input type="text" name="shohin_mei" value=""><br>
商品分類：
	<% for(ShohinBunrui bunrui :ShohinBunrui.values()){ %>
		<% if(!bunrui.getBunrui().isBlank()){ %>
		<input type="radio" name="shohin_bunrui" value=<%= bunrui.getBunrui() %>>
		<%= bunrui.getBunrui() %>
		<% } %>
	<% }%>

	<br>
販売単価：<input type="text" name="hanbai_tanka" value=""><br>
仕入単価：<input type="text" name="shiire_tanka" value=""><br>

<input type="submit" value="更新">
<a href="/shohinKanri_18/Main">戻る</a>
</form>
</body>
</html>