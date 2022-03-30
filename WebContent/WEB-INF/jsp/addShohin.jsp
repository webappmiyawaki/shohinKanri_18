<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.shohin.Shohin" %>
<%@ page import = "model.shohin.ShohinBunrui" %>
<%@ page import ="java.util.*" %>
<%@ page import="model.shohin.ConfirmErrorCheck" %>
<%@ page import ="model.shohin.VerifyModel" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>商品追加</title>
</head>
<body>

<h1>商品追加</h1>
<%
Shohin shohin= (Shohin)session.getAttribute("shohin");
%>
<%
ConfirmErrorCheck errorMsg = (ConfirmErrorCheck)request.getAttribute("message");

if(errorMsg!=null){
if(errorMsg.getErrorMessage()!=""){
%>
<%=errorMsg.getErrorMessage() %>
<%
}}
%>
<%
VerifyModel verifyModel = (VerifyModel)request.getAttribute("verifyModel");
%>
<%if(verifyModel!=null){
if(verifyModel.isAdded()){ %>
	登録が完了しました。
<%	}else{ %>
	登録処理時に問題が発生しました。
<% }} %>

<form action="/shohinKanri_18/SelectProcess" method="get">
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

<input type="submit" value="追加" name="addProcessUpdate">
<a href="/shohinKanri_18/Main">戻る</a>
</form>
</body>
</html>