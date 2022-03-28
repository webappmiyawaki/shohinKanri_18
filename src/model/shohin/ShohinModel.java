package model.shohin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ShohinUtils;

/**
 * TABLE shohin(
 *   shohin_id INTEGER,
 *   shohin_mei VARCHAR(100),
 *   shohin_bunrui VARCHAR(100),
 *   hanbai_tanka INTEGER,
 *   shiire_tanka INTEGER,
 *   torokubi DATE,
 *   primary key (shohin_id)
 */

public class ShohinModel implements ShohinModelInterface {
	@Override
	public boolean insert(Shohin shohin) {
		String sql = "INSERT INTO shohin VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ShohinUtils.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, shohin.getShohin_id());
			pstm.setString(2, shohin.getShohin_mei());
			pstm.setString(3, shohin.getShohin_bunrui());
			pstm.setInt(4, shohin.getHanbai_tanka());
			pstm.setInt(5, shohin.getShiire_tanka());
			pstm.setString(6, shohin.getTorokubi());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Shohin> selectAll() {
		String sql = "SELECT * FROM shohin ORDER BY shohin_id";
		try (Connection conn = ShohinUtils.getConnection();
			ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
			List<Shohin> shohinList = new ArrayList<>();
			while (rs.next()) {
				shohinList.add(Shohin.builder()
								.shohin_id(rs.getInt("shohin_id"))
								.shohin_mei(rs.getString("shohin_mei"))
								.shohin_bunrui(rs.getString("shohin_bunrui"))
								.hanbai_tanka(rs.getInt("hanbai_tanka"))
								.shiire_tanka(rs.getInt("shiire_tanka"))
								.torokubi(rs.getString("torokubi"))
								.build());
			}
			if(shohinList.size()>0) {
				return shohinList;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Shohin selectUnit(int shohin_id) {
		String sql = "SELECT * FROM shohin WHERE shohin_id = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ShohinUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, shohin_id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return Shohin.builder()
						.shohin_id(rs.getInt(shohin_id))
						.shohin_mei(rs.getString("shohin_mei"))
						.shohin_bunrui(rs.getString("shohin_bunrui"))
						.hanbai_tanka(rs.getInt("hanbai_tanka"))
						.shiire_tanka(rs.getInt("shiire_tanka"))
						.torokubi(rs.getString("torokubi"))
						.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ShohinUtils.close(pstm, conn, rs);
		}
		return null;
	}

	@Override
	public Shohin selectUnit(String shohin_mei,String shohin_bunrui) {
		String sql = "SELECT * FROM shohin WHERE shohin_mei LIKE ? AND shohin_bunrui LIKE ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ShohinUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+shohin_mei);
			pstm.setString(2, "%"+shohin_bunrui);

			rs = pstm.executeQuery();
			if (rs.next()) {
				return Shohin.builder()
						.shohin_id(rs.getInt("shohin_id"))
						.shohin_mei(rs.getString("shohin_mei"))
						.shohin_bunrui(rs.getString("shohin_bunrui"))
						.hanbai_tanka(rs.getInt("hanbai_tanka"))
						.shiire_tanka(rs.getInt("shiire_tanka"))
						.torokubi(rs.getString("torokubi"))
						.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ShohinUtils.close(pstm, conn, rs);
		}
		return null;
	}

	@Override
	public boolean update(int shohin_num) {
		String sql = "UPDATE shohin SET shohin_mei='rename' where shohin_id = ?";
		try (Connection conn = ShohinUtils.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, shohin_num);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteAll() {
		String sql = "TRUNCATE shohin";
		try (Connection conn = ShohinUtils.getConnection()) {
			conn.prepareStatement(sql).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUnit(String shohin_num) {
		String sql = "DELETE FROM shohin WHERE shohin_id = ?";
		try (Connection conn = ShohinUtils.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, Integer.parseInt(shohin_num));
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean tableInitialize() {
		List<String[]> shohinList = new ArrayList<>();
		String[] shohin0001 = {"0001", "Tシャツ", "衣服", "1000", "500", "2009-09-20"};
		String[] shohin0002 = {"0002", "穴あけパンチ", "事務用品", "500", "320", "2009-09-11"};
		String[] shohin0003 = {"0003", "カッターシャツ", "衣服", "4000", "2800", "NULL"};
		String[] shohin0004 = {"0004", "包丁", "キッチン用品", "3000", "2800", "2009-09-20"};
		String[] shohin0005 = {"0005", "圧力鍋", "キッチン用品", "6800", "5000", "2009-01-15"};
		String[] shohin0006 = {"0006", "フォーク", "キッチン用品", "500", "0", "2009-09-20"};
		String[] shohin0007 = {"0007", "おろしがね", "キッチン用品", "880", "790", "2008-04-28"};
		String[] shohin0008 = {"0008", "ボールペン", "事務用品", "100", "0", "2009-11-11"};
		shohinList.add(shohin0001);
		shohinList.add(shohin0002);
		shohinList.add(shohin0003);
		shohinList.add(shohin0004);
		shohinList.add(shohin0005);
		shohinList.add(shohin0006);
		shohinList.add(shohin0007);
		shohinList.add(shohin0008);

		String sqlInsert = "INSERT INTO shohin(" +
                "shohin_id," +
                "shohin_mei," +
                "shohin_bunrui," +
                "hanbai_tanka," +
                "shiire_tanka," +
                "torokubi) " +
                "VALUES(?,?,?,?,?,?)";

		try (Connection conn = ShohinUtils.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sqlInsert)){
			conn.setAutoCommit(false);
			for(String[] ary:shohinList) {
                pstm.setInt(1, Integer.parseInt(ary[0]));
                pstm.setString(2, ary[1]);
                pstm.setString(3, ary[2]);
                if(ary[3]==null) {
                	pstm.setInt(4,0);
                }else {
                	pstm.setInt(4, Integer.parseInt(ary[3]));
                }

                if(ary[4]==null) {
                	pstm.setInt(5,0);
                }else {
                pstm.setInt(5, Integer.parseInt(ary[4]));
                }
                if(ary[5]==null) {
                	pstm.setString(6,null);
                }else {
                	pstm.setString(6, ary[5]);
                }
                pstm.addBatch();
                //setNull
			}
            pstm.executeBatch();
            conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Shohin> selectAny(String shohin_mei, String shohin_bunrui) {
		if(shohin_mei.equals("")&&shohin_bunrui.equals(""))return null;
		String sql = "SELECT * FROM shohin WHERE shohin_mei LIKE ? AND shohin_bunrui LIKE ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ShohinUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+shohin_mei);
			pstm.setString(2, "%"+shohin_bunrui);
			rs = pstm.executeQuery();
			List<Shohin> shohinList = new ArrayList<>();

			while (rs.next()) {
				shohinList.add(Shohin.builder()
								.shohin_id(rs.getInt("shohin_id"))
								.shohin_mei(rs.getString("shohin_mei"))
								.shohin_bunrui(rs.getString("shohin_bunrui"))
								.hanbai_tanka(rs.getInt("hanbai_tanka"))
								.shiire_tanka(rs.getInt("shiire_tanka"))
								.torokubi(rs.getString("torokubi"))
								.build());
			}
			if(shohinList.size()>0) {
				return shohinList;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ShohinUtils.close(pstm, conn, rs);
		}
		return null;
	}

}
