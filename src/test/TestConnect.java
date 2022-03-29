package test;

import java.util.ArrayList;
import java.util.List;

import model.shohin.Shohin;
import model.shohin.ShohinModel;

public class TestConnect {
	public static void main(String[] args) {
		ShohinModel sm = new ShohinModel();
	List<Shohin> shohinList = sm.selectAny("","");
//		shohinList.stream().forEach(System.out::println);
		shohinList.stream().forEach(s->System.out.println(s));
		List<Shohin> s2= new ArrayList<>();
		shohinList.forEach(s->s2.add(s));
		s2.forEach(System.out::println);

	}
}
