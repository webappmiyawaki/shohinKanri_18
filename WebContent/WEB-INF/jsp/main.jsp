<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.shohin.Shohin" %>
<%@ page import = "model.shohin.ShohinBunrui" %>
<%@ page import ="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>商品検索</title>
</head>
<body>

<h1>商品検索</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<form action="/shohinKanri_18/SerchShohin" method="post">
	<table>
	<tbody>
	<tr>
	<td>商品名：<input type="text" name="shohin_mei" value=""></td>
	<td>商品分類：<select name="shohin_bunrui">
	<% for(ShohinBunrui bunrui :ShohinBunrui.values()){ %>
		<option value=<%= bunrui.getBunrui() %>>
		<%= bunrui.getBunrui() %>
		</option>
	<% }%>
	</select>
	</td>
	</tr>
	</tbody>
	</table>
	<input type="submit" value="検索">
</form>

****検索結果を出力する場所****<br>
<%String isSearched = request.getParameter("isSearch");%>
	<%Shohin searchedShohin = (Shohin)request.getAttribute("shohin");%>
	<%if(searchedShohin==null){%>
		検索結果はありませんでした。
	<% }else{ %>
		<%= searchedShohin %>
	<%}%>

<br>
<br>
<form action="/shohinKanri_18/DeleteShohin" method="get" action="delete">
	<table>
    <thead>
        <tr>
            <th class="title" colspan="6">商品一覧</th>
        </tr>
        <tr class="midashi">
            <th>select</th><th>shohin_id</th>
                        <th>shohin_mei</th>
                        <th>shohin_bunrui</th>
                        <th>hanbai_tanka</th>
                        <th>shiire_tanka</th>


        </tr>
    </thead>
    <tbody>


<%
List<Shohin> shohinList = (List<Shohin>)session.getAttribute("shohinList");
for(Shohin shohin:shohinList){
%>
<tr>
<td><input type="radio" name="shohin_id" value=<%= shohin.getStringShohin_id() %>>
</td>
<td><%= shohin.getStringShohin_id() %></td>
<td><%= shohin.getShohin_mei() %></td>
<td><%= shohin.getShohin_bunrui() %></td>
<td><%= shohin.getHanbai_tanka() %></td>
<td><%= shohin.getShiire_tanka() %></td>

</tr>
<%} %>

    </tbody>
</table>
<a href="/shohinKanri_18/AddShohin">追加</a>
<input action=/shohinKanri_18/DeleteShohin type="submit" value="削除" method="post">
</form>

<form>
<input action=/shohinKanri_18/TableInitialize type="submit" value="テーブル初期化" method="post">
</form>

</body>
</html>