package com.bohyeon.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bohyeon.web.dao.NoticeDao;
import com.bohyeon.web.entities.Notice;

public class Program {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		String src ="com/bohyeon/web/dao/mybatis/config.xml";
		InputStream is = Resources.getResourceAsStream(src);

		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session =ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		Notice n = noticeDao.get("1105");
		
		System.out.println(n.getTitle());


		
	}

}
