package kr.kedu.java01.spms.controls;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.kedu.java01.spms.dao.MemberDAO;
import kr.kedu.java01.spms.service.MemberService;
import kr.kedu.java01.spms.vo.MemberFileVO;
import kr.kedu.java01.spms.vo.MemberVO;

@Controller
public class MemberUpdateController implements SpmsController{
	
	@Autowired
	MemberService service;

	
	@Override
	public void setService(MemberService service) throws Exception {
		this.service = service;
		
	}
	
	@GetMapping("/member/update.do")
	public ModelAndView doGet(@RequestParam("no") int no) throws Exception {
		ModelAndView mav = new ModelAndView("/member/MemberUpdateForm");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = service.getMemberOne(no);
		
		mav.addObject("member", map.get("member"));
		mav.addObject("memberFiles", map.get("memberFiles"));
		
		return mav;
						
	}
	
	@PostMapping("/member/update.do")
	public ModelAndView doPost(MemberVO member, MultipartHttpServletRequest mul) throws Exception {
		MemberFileVO mfv = new MemberFileVO();		
		service.modifyMember(member, mfv);
		
		
				
		ModelAndView mav = new ModelAndView("redirect:list.do");
		return mav;
		}


	

	

}
