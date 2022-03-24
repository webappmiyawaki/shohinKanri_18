package servlet;

import java.util.List;
import java.util.Scanner;

import model.shohin.Shohin;
import model.shohin.ShohinFactory;
import model.shohin.ShohinModel;
public class testConnect {
    public static void main(String[] args) {
        ShohinModel jm = new ShohinModel();
        var flg = true;
        String select;
        while (flg) {
            System.out.println("0:quit 1:insert 2:selectAll 3:selectUnit 4:update 5:deleteAll 6:deleteUnit");
            select = new Scanner(System.in).nextLine();
            switch (select) {
                case "0":
                    System.out.println("quit");
                    flg = false;
                    break;
                case "1":
                    System.out.println("insert");
                    boolean isInsert = jm.insert(ShohinFactory.create());
                    System.out.println("isInsert:" + isInsert);
                    break;
                case "2":
                    System.out.println("select all");
                    List<Shohin> shohinList = jm.selectAll();
                    shohinList.forEach(System.out::println);
                    break;
                case "3":
                    System.out.println("select unit");
                    System.out.println("表示する対象のIDを入力してください。");
                    select = new Scanner(System.in).nextLine();
                    System.out.println(jm.selectUnit(Integer.parseInt(select)));
                    break;
                case "4":
                    System.out.println("select update");
                    System.out.println("updateする対象のIDを入力してください。");
                    select = new Scanner(System.in).nextLine();
                    jm.update(Integer.parseInt(select));
                    break;
                case "5":
                    System.out.println("table initialize");
                    jm.deleteAll();
                    break;
                case "6":
                    System.out.println("select delete");
                    System.out.println("updateする対象のIDを入力してください。");
                    select = new Scanner(System.in).nextLine();
                    jm.deleteUnit(select);
                    break;
            }
        }
    }
}
