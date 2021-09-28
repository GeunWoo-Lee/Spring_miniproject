package kr.kedu.java01.spms.controls;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.kedu.java01.spms.service.MemberService;
import kr.kedu.java01.spms.service.MemberServiceImpl;
import kr.kedu.java01.spms.vo.MemberFileVO;
import kr.kedu.java01.spms.vo.MemberVO;


@Controller
public class MemberAddController implements SpmsController{
	@Autowired
	MemberService service;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public void setService(MemberService service) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public MemberAddController setMemberDAO
						(MemberServiceImpl service) {
		this.service = service;
		return this;
	}
	@GetMapping("/member/add.do")
	public ModelAndView doGet() throws Exception {
		return new ModelAndView("/member/MemberForm");
	}
	@PostMapping("/member/add.do")
	public ModelAndView doPost(MemberVO member, MultipartHttpServletRequest req) throws Exception {
		
		System.out.println(member);
		ModelAndView mav = new ModelAndView("redirect:/member/list.do");
		
		String realPath = servletContext.getRealPath("/photo");
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()){
			System.out.println(file.mkdirs());
		}else {
			System.out.println("디렉토리 존재함");
		}
		
		service.setMember(member);
		
		
		Iterator<String> iter = req.getFileNames();
		while(iter.hasNext()){
			String formFileName = iter.next();
			MultipartFile mult = req.getFile(formFileName);
			System.out.println(formFileName);
			
			String oriName = mult.getOriginalFilename();
			
			if (oriName !=null && !oriName.equals("")){
				MemberFileVO mfv = new MemberFileVO();
				String ext = "";
				int index = oriName.lastIndexOf(".");
				if(index != -1){
					ext = oriName.substring(index);
				}
				
				long fileSize = mult.getSize();
				String saveFileName = "member-" +UUID.randomUUID().toString()+ ext;
				
				mult.transferTo(new File(realPath+"/"+saveFileName));
				mfv.setEmail(member.getEmail());
				mfv.setRealFile(saveFileName);
				mfv.setFileSize(fileSize);
				mfv.setOriFile(oriName);
				mfv.setFilePath("/photo");
				service.setMemberFile(mfv);
			}
		}
		return mav;
	}
}
	

	

