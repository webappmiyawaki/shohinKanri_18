package model.shohin;

public class ShohinFactory {
    public static Shohin create() {
    	java.sql.Date sqlDateObj = new java.sql.Date(System.currentTimeMillis());
        return Shohin.builder()
				.shohin_mei("name")
				.shohin_bunrui("type")
				.hanbai_tanka(0)
				.shiire_tanka(0)
				.torokubi(sqlDateObj)
				.build();
    }
}
