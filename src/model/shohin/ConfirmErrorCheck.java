package model.shohin;

import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * 未入力チェック	項目が未入力かのチェック。未入力であればエラーメッセージを表示。
 * 文字数チェック	項目へ入力された文字がX文字以下であるかのチェック。X文字より大きければエラーメッセージを表示。
 * 未選択チェック	項目が未選択かのチェック。未選択であればエラーメッセージを表示。
 * 整数値チェック	項目へ入力された値が整数かどうかのチェック。整数でなければエラーメッセージを表示。
 *
 */

@Setter
@Getter
public class ConfirmErrorCheck {
	private String errorMessage;
	public ConfirmErrorCheck(){
		this.errorMessage = "";
	}
	public void shohinCheck(String shohin_id,String shohin_mei,String shohin_bunrui,String hanbai_tanka,String shiire_tanka) {
		StringBuilder errorSb = new StringBuilder("");
		if(shohin_id==null||shohin_id.isBlank()) {
			errorSb.append("商品IDは必須項目です。<br>");
		}else {

		}
		if(shohin_mei==null||shohin_mei.isBlank()) {
			errorSb.append("商品名は必須項目です。<br>");
		}

		if(shohin_bunrui==null||shohin_bunrui.isBlank()) {
			errorSb.append("商品分類は必須項目です。<br>");
		}else {
		}


		if(hanbai_tanka==null||hanbai_tanka.isBlank()) {
			//0に変換するので処理なし
		}else {
			Pattern pattern = Pattern.compile("^-?(0|[1-9]\\d*)(\\.\\d+|)$");
	        if(pattern.matcher(hanbai_tanka).matches()) {
			errorSb.append("販売単価には整数を入力してください。<br>");
	        }
		}

		if(shiire_tanka==null||shiire_tanka.isBlank()) {
			//0に変換するので処理なし
		}else {
			Pattern pattern = Pattern.compile("^-?(0|[1-9]\\d*)(\\.\\d+|)$");
	        if(pattern.matcher(shiire_tanka).matches()) {
			errorSb.append("仕入単価には整数を入力してください。<br>");
	        }
		}

		this.errorMessage = errorSb.toString();
	}

	@Override
	public
	String toString() {
		return this.errorMessage;
	}
}
