package kr.kedu.java01.spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.kedu.java01.spms.service.MemberService;

@Controller
public class MemberDeleteController implements SpmsController{
	@Autowired
	MemberService service;

	@Override
	public void setService(MemberService service) throws Exception {
		this.service = service;
	}
	
	@RequestMapping("/member/delete")
	public ModelAndView execute(@RequestParam("no") int no) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:list.do");
		service.deleteMember(no);
		
		return mav;
	}




	

}
