package model.shohin;

public class ShohinFactory {
    public static Shohin create() {
        return Shohin.builder()
				.shohin_mei("name")
				.shohin_bunrui("type")
				.hanbai_tanka(0)
				.shiire_tanka(0)
				.torokubi(null)
				.build();
    }
}
