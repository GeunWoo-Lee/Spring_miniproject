package kr.kedu.java01.spms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kedu.java01.spms.dao.MemberDAO;
import kr.kedu.java01.spms.dao.MemberFileDAO;
import kr.kedu.java01.spms.vo.MemberFileVO;
import kr.kedu.java01.spms.vo.MemberVO;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService{

	@Autowired
	Map<String, Object> map = new HashMap<String, Object>();
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberFileDAO mfDAO;
	
	@Override
	public void setMember(MemberVO member) {
		System.out.println(memberDAO.insert(member)+"멤버 추가 완료");
		
	}

	@Override
	public void setMemberFile(MemberFileVO mfv) {
		if(mfv.getEmail()!=null){
			System.out.println(mfDAO.insert(mfv)+"의 파일 추가");

		}
	}

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		List<MemberVO> list = memberDAO.selectList();
		System.out.println("멤버 사이즈"+list.size());
				
		return  list;
	}
	
	@Override
	public Map<String, Object> getMemberOne(int no) {
		map.put("member", memberDAO.selectOne(no));
		map.put("memberFiles", mfDAO.selectOne(no));
		
		
		
		return map;
	}

	@Transactional
	public void modifyMember(MemberVO member, MemberFileVO mfv) {
		System.out.println(memberDAO.update(member)+"명의 멤버가 수정되었습니다.");
		//if(mfv!=null) System.out.println(mfDAO.update(mfv)+"개의 첨부파일이 수정되었습니다."); 
	}

	@Transactional
	public void deleteMember(int no) {
		System.out.println(memberDAO.delete(no)+"명의 멤버가 삭제되었습니다."); 
		System.out.println(mfDAO.delete(no)+"개의 첨부파일이 삭제되었습니다."); 
		
	}

	

	
	
	
	
	
}
