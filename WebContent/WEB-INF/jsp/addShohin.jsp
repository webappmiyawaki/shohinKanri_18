<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.shohin.ShohinBunrui" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/shohinKanri_18/SerchShohin" method="post">
	<p>
	商品名：<input type="text" name="shohin_mei" value=""><br>
	商品分類：<select name="shouhin_bunrui">
	<% for(Enum bunrui:ShohinBunrui.values()){ %>
		<option value=<%= bunrui.name() %>><%= bunrui.name() %></option>
	<% }%>
	</select>
	</p>
	<input type="submit" value="検索">
</form>
</body>
</html>