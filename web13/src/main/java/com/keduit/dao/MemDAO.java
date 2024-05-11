package com.keduit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keduit.dto.MemVO;
import com.keduit.utill.DBManager;

public class MemDAO {
	private MemDAO() {
	}

	private static MemDAO instance = new MemDAO();

	public static MemDAO getInstance() {
		return instance;
	}

	public MemVO idCheck(String id) {
		String sql = "select * from mem where id =?";
		MemVO mVO = new MemVO();

		Connection conn = DBManager.getConnection();
		// 와일드 카드가 있으니 pstmt사용.
		PreparedStatement pstmt = null;
		// 화면에 뿌려줘야 하니 rs 요소들을 저장할.
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mVO.setId(rs.getString("id"));
				mVO.setPwd(rs.getString("pwd"));
				mVO.setName(rs.getString("name"));
				mVO.setLev(rs.getString("lev"));
				mVO.setGender(rs.getString("gender"));
				mVO.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return mVO;
	}

	public int update(MemVO mVO) {
		int result = -1;
		String sql = "update mem set name=?, pwd=?, lev=?, gender=?, phone=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("다오에서 값 잘 가져왓니" + mVO);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getPwd());
			pstmt.setString(3, mVO.getLev());
			pstmt.setString(4, mVO.getGender());
			pstmt.setString(5, mVO.getPhone());
			pstmt.setString(6, mVO.getId());

			result = pstmt.executeUpdate();
			System.out.println("업데이트 여부" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int checkId(String id) {
		int result = -1;
		String sql = "SELECT COUNT(*) FROM mem WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			// 결과 가져오기
			if (rs.next()) {
				int count = rs.getInt(1); // 첫 번째 열의 값을 정수로 가져옴
				if (count > 0) {
					result = 0;
				} else {
					result = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public int insertAction(MemVO mVO) {
String sql = "insert into mem (id, pwd, name, phone, lev, gender) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = DBManager.getConnection();
		// 와일드 카드가 있으니 pstmt사용.
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPwd());
			pstmt.setString(3, mVO.getName());
			pstmt.setString(4, mVO.getPhone());
			pstmt.setString(5, mVO.getLev());
			pstmt.setString(6, mVO.getGender());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();	
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
}
