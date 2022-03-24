package model.shohin;

public enum ShohinBunrui {
	BLANK(""),
	CLOTHES("衣服"),
	KITCHEN("キッチン用品"),
	OFFICE_SUPPLIES("事務用品");

	private final String bunrui;

	private ShohinBunrui(String bunrui) {
		this.bunrui = bunrui;
	}

	public String getBunrui() {
		return bunrui;
	}
}
