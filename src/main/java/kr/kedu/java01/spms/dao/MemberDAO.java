package kr.kedu.java01.spms.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.kedu.java01.spms.vo.MemberVO;

/*
 * MyBatis�� �����ϱ� ���� �ٽ� ������Ʈ
 * 
 * SqlSession - ���� SQL�� �����ϱ� ���� ��ü. �� ��ü�� SQL�� ó���ϱ� ����
 * 				JDBC ����̹��� ����մϴ�. 
 * SqlSessionFactory - SqlSession��ü�� ������ 
 * SqlSessionFactoryBuilder - mysql ���� ������ ������ ���� 
 * 							SqlSessionFactory�� ����
 * mybatis ���� ���� - �����ͺ��̽� ��������, Ʈ����� ����, mybatis��������
 * 				���� ���� ������ ����. SqlSessionFactory�� ���� �� ���.
 * SQL ���� ���� - SQL���� ��� �ִ� ����, SqlSession ��ü�� ������.
 * 
 * ContextLoaderListener(������)���� �ʱ� ������ ���ؼ� mybatis-config
 * .xml�� ��ϵ� SqlSessionFactory�� �����, ���������� ���� ����Ѵ�.
 */

/*	@Component ������ �ϴ� �������� ������̼��� �ֽ��ϴ�.
 * 	@Repository - > DAO�� ���� ������ �����ϴ� Ŭ�������� ����.
 * 	@Service - > ���� ������ �����ϴ� Ŭ���� 
 * 	@Controller -> MVC �������� Controller ����� �����ϴ�
 * 					Ŭ������ ���Դϴ�. 
 * 
 */


@Repository("memberDAO")
public class MemberDAO {
	/*
	 * myBatis�� ����ϱ� ���ؼ��� SqlSessionFactory�� �ʿ��մϴ�.
	 * ������ �ν��Ͻ� ������ ���� �޼ҵ� ���� 
	 */
	
	SqlSession sqlSession;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	//SqlSessionFactory sqlSessionFactory;
	
	//@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	public List<MemberVO> selectList() throws Exception {
		
		try {
			return sqlSession.selectList("spms.dao.MemberDAO.selectList");
		}finally {
			//sqlSession.close();
		}
	}
	@Transactional
	public int insert(MemberVO member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert
					("spms.dao.MemberDAO.insert", member );
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
		
	}
	
	public int delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("spms.dao.MemberDAO.delete", no );
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}
	
	public MemberVO selectOne(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne
					("spms.dao.MemberDAO.selectOne",no);
		}finally {
			sqlSession.close();
		}
	}
	
	public int update(MemberVO member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update
					("spms.dao.MemberDAO.update", member );
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}
	
	public MemberVO exist(String email, String password) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne
				("spms.dao.MemberDAO.exist",new MemberVO().setEmail(email).setPassword(password));
		}finally {
			sqlSession.close();
		}	
		
		
	}
	
	
	
}
