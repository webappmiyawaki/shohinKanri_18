<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.shohin.Shohin" %>
<%@ page import = "model.shohin.ShohinBunrui" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.lang.*" %>
<%@ page import ="model.shohin.VerifyModel" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>商品検索</title>
</head>
<body>

<h1>商品検索</h1>
<%
request.setCharacterEncoding("UTF-8");
%>
<form action="/shohinKanri_18/SelectProcess" method="get">
	<table>
	<tbody>
	<tr>
	<%
	Shohin shohin = (Shohin)session.getAttribute("shohin");
	String name="";
	String sBunrui="";
	if(shohin!=null){
		name=shohin.getShohin_mei();
		sBunrui=shohin.getShohin_bunrui();
	}
	%>
		<td>商品名：<input type="text" name="shohin_mei" value="<%= name %>"></td>
		<td>商品分類：
		<select name="shohin_bunrui" >
		<%
		for(ShohinBunrui bunrui :ShohinBunrui.values()){
		%>
				<option value="<%= bunrui.getBunrui() %>"
				 <%if(shohin.getShohin_bunrui().equals(bunrui.getBunrui())){ %>
				 selected
				 <% } %>>

				 <%= bunrui.getBunrui() %>
				 </option>
		<% } %>
		</select>
		</td>
	</tr>
	</tbody>
	</table>
	<input type="submit" value="検索" name="baseProcessName">
</form>
<%
VerifyModel verifyModel = (VerifyModel)request.getAttribute("verifyModel");
%>
	<%List<Shohin> sList = (List<Shohin>)session.getAttribute("shohinList");%>
	<%if(verifyModel!=null){
	if(verifyModel.isSearched()&&sList==null){ %>
		検索結果はありませんでした。
	<% } %>
	<% if(verifyModel.isDeleted()){ %>
				削除が完了しました。
	<% }} %>

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
for(Shohin s:sList){
%>
<tr>
<td><input type="radio" name="shohin" value=<%= s %>>
</td>
<td><%= s.getStringShohin_id() %></td>
<td><%= s.getShohin_mei() %></td>
<td><%= s.getShohin_bunrui() %></td>
<td><%= s.getHanbai_tanka() %></td>
<td><%= s.getShiire_tanka() %></td>
</tr>

<%}} %>

    </tbody>
</table>

<a href="/shohinKanri_18/AddShohin">追加</a>
<% if(sList!=null){ %>
<input type="submit" value="更新" name="baseProcessName">
<input type="submit" value="削除" name="baseProcessName">
<% } %>
</form>

<form action=/shohinKanri_18/SelectProcess method="get">
<input type="submit" value="csv全件出力" name="baseProcessName">
</form>


<!-- 初期化は使わない
<form action=/shohinKanri_18/SelectProcess method="get">
<input  type="submit" value="テーブル初期化" name="baseProcessName">
</form>
-->
</body>
</html>