package kr.kedu.java01.spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kedu.java01.spms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberListController implements SpmsController{
	@Autowired
	MemberService service;
	
	@Override
	public void setService(MemberService service) throws Exception {
		this.service = service;
	}
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView execute() throws Exception {
		System.out.println("멤버 로딩 성공");
		ModelAndView mav = new ModelAndView("/member/MemberList");
		mav.addObject("members", service.getMemberList());
				
		return mav;
	}
	
	

	
}
