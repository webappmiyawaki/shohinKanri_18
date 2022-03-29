<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.shohin.Shohin" %>
<%@ page import = "model.shohin.ShohinBunrui" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.lang.*" %>
<%@ page import ="model.shohin.IsModel" %>

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
<form action="/shohinKanri_18/SelectProcess" method="get">
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
	<input type="submit" value="検索" name="processName">
</form>

****検索結果を出力する場所****<br>
<% IsModel isModel = (IsModel)request.getAttribute("isModel");%>
	<%List<Shohin> sList = (List<Shohin>)request.getAttribute("shohinList");%>
	<% if(isModel!=null&&sList==null){ %>
		検索結果はありませんでした。
	<% } %>
	<% if(isModel!=null){ %>
	<% if(isModel.isDelete()==true){ %>
				削除が完了しました。
	<% } %>
	<% } %>

<br>
<br>
<form action="/shohinKanri_18/SelectProcess" method="get" action="">
	<table>
    <thead>
        <tr>
            <th class="title" colspan="6">商品一覧</th>
        </tr>
        <tr class="midashi">
            <th>選択</th>
            <th>商品ID</th>
            <th>商品名</th>
            <th>商品分類</th>
            <th>販売単価</th>
            <th>仕入単価</th>
       	</tr>
    </thead>
    <tbody>


<%
if(sList==null){
}else{
for(Shohin shohin:sList){
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
<%}} %>

    </tbody>
</table>
<a href="/shohinKanri_18/AddShohin">追加</a>
<input type="submit" value="更新" name="processName">
<input type="submit" value="削除" name="processName">
</form>

<form action=/shohinKanri_18/TableInitialize method="post" name="processName">
<input  type="submit" value="テーブル初期化" >
</form>

</body>
</html>