package model.shohin;

import java.util.List;

interface ShohinModelInterface {
    boolean insert(Shohin shohin);
    List<Shohin> selectAll();
    List<Shohin> selectAny(String shohin_mei,String shohin_bunrui);
    Shohin selectUnit(int shohin_id);
    Shohin selectUnit(String shohin_mei,String shohin_bunrui);
    boolean update(Shohin shohin);
    boolean deleteAll();
    boolean deleteUnit(String shohin_id);
    boolean tableInitialize();
}
