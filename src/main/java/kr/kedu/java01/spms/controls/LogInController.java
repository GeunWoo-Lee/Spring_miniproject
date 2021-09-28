package kr.kedu.java01.spms.controls;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.kedu.java01.spms.dao.MemberDAO;
import kr.kedu.java01.spms.service.MemberService;

import kr.kedu.java01.spms.vo.MemberVO;

@Controller

public class LogInController implements SpmsController{
	@Autowired
	MemberDAO memberDAO;

	@Override
	public void setService(MemberService service) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@GetMapping("/auth/login.do")
	public ModelAndView execute() {
		ModelAndView mav = new ModelAndView("/auth/LogInForm");
		return mav;
	}
	
	
	@PostMapping("/auth/login.do")
	public ModelAndView execute(MemberVO member, HttpSession req) throws Exception {
			MemberVO login = memberDAO.exist(member.getEmail(), 
					member.getPassword());
			if(login != null) {
				System.out.println(login.getName());
				ModelAndView mav = new ModelAndView("redirect:../member/list.do");
				req.setAttribute("member", login);
				return mav;
			}else {
				ModelAndView mav = new ModelAndView("/auth/LogInFail");
				return mav;
			}
		}
	
	
}
