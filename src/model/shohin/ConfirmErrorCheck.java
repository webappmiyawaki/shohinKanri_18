package model.shohin;

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
	public StringBuilder shohinCheck(Shohin shohin) {
		StringBuilder errorSb = new StringBuilder("");
		if(shohin.getShohin_id()==0) {
			errorSb.append("商品IDは必須項目です。<br>");
		}else if(shohin.getShohin_id()>10000){
			errorSb.append("商品IDは４文字以下で入力してください。<br>");
		}
		if(shohin.getShohin_mei()==null||shohin.getShohin_mei().isBlank()) {
			errorSb.append("商品名は必須項目です。<br>");
		}

		if(shohin.getShohin_bunrui()==null||shohin.getShohin_bunrui().isBlank()) {
			errorSb.append("商品分類は必須項目です。<br>");
		}


		if(shohin.getHanbai_tanka()==0) {
		}else {
			if(!shohin.isInteger_hanbai_tanka()) {
			errorSb.append("販売単価には整数を入力してください。<br>");
	        }
		}

		if(shohin.getShiire_tanka()==0) {
		}else {
	        if(!shohin.isInteger_shiire_tanka()) {
			errorSb.append("仕入単価には整数を入力してください。<br>");
	        }
		}

		this.errorMessage = errorSb.toString();
		return errorSb;
	}

	@Override
	public
	String toString() {
		return this.errorMessage;
	}
}
