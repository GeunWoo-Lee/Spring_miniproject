package kr.kedu.java01.spms.controls;


import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


import kr.kedu.java01.spms.service.MemberService;


@Controller
public class LogOutController implements SpmsController{
	
	@Override
	public void setService(MemberService service) throws Exception {
				
	}
	@GetMapping("/auth/logout.do")
	public ModelAndView execute(HttpSession req) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:login.do");
		req.invalidate();
		return mav;
	}


	


}
