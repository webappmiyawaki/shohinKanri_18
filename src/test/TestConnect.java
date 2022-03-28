package test;

import java.util.List;

import model.shohin.Shohin;
import model.shohin.ShohinModel;

public class TestConnect {
	public static void main(String[] args) {
		ShohinModel sm = new ShohinModel();
		List<Shohin> shohinList = sm.selectAny("","");
		shohinList.stream().forEach(System.out::println);
	}
}
