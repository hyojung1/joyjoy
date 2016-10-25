package com.bohyeon.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.bohyeon.web.entities.Notice;
import com.boyeon.web.model.NoticeModel;

public interface NoticeDao {

	 Notice get(String code) ;
	 
	 List<NoticeModel> getList(int page, String field,String query)  ;	 
	 List<NoticeModel> getList(int page) ;
	 List<NoticeModel> getList()  ;	
	 
	 int insert(Notice notice) ;
	 int update(Notice notice) ;
	 int delete(String code) ;

	 int getCount(String field, String query);
}
