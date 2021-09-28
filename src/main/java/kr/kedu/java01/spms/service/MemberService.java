package kr.kedu.java01.spms.service;

import java.util.List;
import java.util.Map;

import kr.kedu.java01.spms.vo.MemberFileVO;
import kr.kedu.java01.spms.vo.MemberVO;


public interface MemberService {
	
	public void setMember(MemberVO member);
	public void setMemberFile(MemberFileVO mfv);
	public List<MemberVO> getMemberList() throws Exception;
	public Map<String, Object> getMemberOne(int no);
	public void modifyMember(MemberVO member, MemberFileVO mfv);
	
	public void deleteMember(int no);
	
}
