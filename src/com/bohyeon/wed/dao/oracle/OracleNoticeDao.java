package com.bohyeon.wed.dao.oracle;


import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bohyeon.web.dao.NoticeDao;
import com.bohyeon.web.entities.Notice;
import com.boyeon.web.model.NoticeModel;

	/*public class OracleNoticeDao implements NoticeDao
	{
	   @Override
	   public Notice get(String code) throws SQLException, ClassNotFoundException 
	   {
	        String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	        String sql = "SELECT * FROM NOTICE_VIEW WHERE CODE=?";
	        String query="";
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection(url,"c##sist","dclass ");
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, code);

	        ResultSet rs = st.executeQuery();

	        String code="";
	        String title="";
	        String writer="";
	        String content="";
	        Date regdate=null;
	        int hit=0;
	        Notice notice = new Notice();
	        
	        if(rs.next())
	        {
	           notice.setCode(rs.getString("CODE"));
	         notice.setTitle(rs.getString("TITLE"));
	         notice.setWriter(rs.getString("WRITER"));
	         notice.setContent(rs.getString("CONTENT"));
	         notice.setRegDate(rs.getDate("REGDATE"));
	         notice.setHit(rs.getInt("HIT"));
	        }
	        rs.close();
	      st.close();
	      con.close();
	      
	      return notice;
	   }

	@Override
	public List<NoticeModel> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "SELECT * " + 
						"FROM (" +
						"		 SELECT ROWNUM NUM , N.*" +
						"		 FROM (" +
						"				 SELECT *" + 
						"				 FROM" +
						"				 		NOTICE_VIEW " +
						"				 WHERE "+field+" LIKE ? " + 
						"				 ORDER BY REGDATE DESC " +
						"		 )N " +
						" ) " +
						"WHERE ROWNUM  BETWEEN ? AND ?";
		
		query ="%"+query+"%";
		int startNum=1+(page-1)*10; // page: 1 11 21 31 41
		int endNum=page*10; // 10 20 30 40 
		
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url,"c##sist","dclass ");
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, query);
        st.setInt(2, startNum);
        st.setInt(3, endNum);

        ResultSet rs = st.executeQuery();

        List<NoticeModel> list = new ArrayList<>();        
        
        while(rs.next())
        {
        	NoticeModel notice = new NoticeModel();
            notice.setCode(rs.getString("CODE"));
            notice.setTitle(rs.getString("TITLE"));
            notice.setWriter(rs.getString("WRITER"));
            notice.setContent(rs.getString("CONTENT"));
            notice.setRegDate(rs.getDate("REGDATE"));
            notice.setHit(rs.getInt("HIT"));
            notice.setCmtCnt(rs.getInt("CMTCNT"));
            
            list.add(notice);
        }
        rs.close();
        st.close();
        con.close();
        
		return list;
	}

	@Override
	public List<NoticeModel> getList(int page) throws ClassNotFoundException, SQLException {
 
		return getList(page, "TITLE", "");
		
	}

	@Override
	public List<NoticeModel> getList() throws ClassNotFoundException, SQLException {
		
		return getList(1, "TITLE", "");
	}

	@Override
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		
		String sqlCode = " SELECT NVL(MAX (TO_NUMBER(CODE)),0)+1 CODE FROM NOTICE ";
				
		String sql = "INSERT INTO NOTICE("
							+ "CODE, "
							+ "TITLE, "
							+ "WRITER, "
							+ "CONTENT, "
							+ "REGDATE, "
							+ "HIT) "
					 + "VALUES(?,?,?,?,SYSDATE,0)";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url,"c##sist","dclass ");
        
        Statement stCode = con.createStatement();
        ResultSet rs = stCode.executeQuery(sqlCode);
        rs.next();
       		
        String code=rs.getString("CODE");
        
        rs.close();
        stCode.close();
        
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, code);
        st.setString(2, notice.getTitle());
        st.setString(3, notice.getWriter());
        st.setString(4, notice.getContent());
        
        int result = st.executeUpdate();

        st.close();
        con.close();
        
		return result;
	}

	@Override
	public int update(Notice notice) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE NOTICE"
						+ "SET TITLE=?,  "
						+ "WRITER=?,  "
						+ "CONTENT=?,  "
						+ "WHERE CODE=?";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url,"c##sist","dclass ");
        
        PreparedStatement st = con.prepareStatement(sql);
       
        st.setString(1, notice.getTitle());
        st.setString(2, notice.getWriter());
        st.setString(3, notice.getContent());
        st.setString(4, notice.getCode());

        //st.executeQuery();
        int result = st.executeUpdate();
        
        st.close();
        con.close();
        
		return result;
	}

	@Override
	public int delete(String code) throws SQLException, ClassNotFoundException {
		
		String sql = "DELETE NOTICE WHERE CODE=?";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url,"c##sist","dclass ");
                
        PreparedStatement st = con.prepareStatement(sql);
       
        st.setString(1, code);
        
        int result = st.executeUpdate();

        st.close();
        con.close();
       
		return result;
	}
	   
	
	   
}
	


*/