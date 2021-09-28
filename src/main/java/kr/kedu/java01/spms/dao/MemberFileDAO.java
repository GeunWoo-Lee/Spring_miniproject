package kr.kedu.java01.spms.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import kr.kedu.java01.spms.vo.MemberFileVO;



@Repository("memberFileDAO")
public class MemberFileDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
		
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	public List<MemberFileVO> selectList() throws Exception {
			
		return sqlSession.selectList("spms.dao.MemberFileDAO.selectList");
		
	}
	
	public int insert(MemberFileVO member) {
		
		int count = sqlSession.insert("spms.dao.MemberFileDAO.insert", member );
		return count;
			
	}
	
	public int delete(int no) {
		
		int count = sqlSession.delete("spms.dao.MemberFileDAO.delete", no );
		return count;
		
	}
	
	public List<MemberFileVO> selectOne(int no) {
		return sqlSession.selectList("spms.dao.MemberFileDAO.selectOneMember",no);		
	}
	
	public int update(MemberFileVO member) {
		int count = sqlSession.update
					("spms.dao.MemberFileDAO.update", member);
		return count;
		
	}
	
		
		
		
}
	
	
	

