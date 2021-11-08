package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService ms;
	public MemberController() {
		System.out.println("controller 생성자 실행");
	}
	@RequestMapping("test")
	public void test() {
		System.out.println("ms : " + ms);
		ms.test();
	}
	@GetMapping("/index")  //url경로
	public String memberIndex() {
		return "member/index";   //패키지 경로
	}
	@GetMapping("/register_view")
	public String registerView() {
		return "member/register_view";
	}
	@GetMapping("/member_list") //db으로부터 저장되있는 데이터 가져와서 jsp한테 보내주면 jsp에서 펼쳐서 보여줘야한다
	public String memberList(Model model) {//jsp로 전달하기 위해선 model필요
		ms.memberList(model);
		return "member/member_list";
	}
	
	//1번째 방법 :requestparam으로 받기
	@PostMapping("register") 
	public String register(@RequestParam("id") String id,   
							@RequestParam String pwd,  
							@RequestParam String name) {
			System.out.println(id);
			System.out.println(pwd);
			System.out.println(name);
			ms.register(id,pwd,name);
			return "redirect:index";
		}
/*
	//2번째 방법:request로 받기
	@PostMapping("register1")
	public String register(HttpServletRequest req) { //request로 받기
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pwd"));
		System.out.println(req.getParameter("name"));
		
		ms.register(req.getParameter("id"),req.getParameter("pwd"),req.getParameter("name"));
		
		return "redirect : index";
	}
	
	//3번째 방법 :dto로 받기
		@PostMapping("register2")
		public String register2(MemberDTO dto) { //dto로 받기
			System.out.println("dto.id : "+dto.getId());
			System.out.println("dto.pwd : "+dto.getPwd());
			System.out.println("dto.name : "+dto.getName());
			
			return "redirect : index";
		}
*/
	
	@RequestMapping("check") //저장된 아이디, 비번 비교
	public String check(Model model, RedirectAttributes re,  //redirect로 넘기려고 만듦
				@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		ms.check(id, pwd, model); //check쪽으로 model에 저장해서 넘기겠다
		re.addFlashAttribute("reMap", model);
		return "redirect:/member/index";
	}

	@RequestMapping("memberInfo")
	public String memberInfo(@RequestParam String id, Model model) {
		ms.memberInfo(id, model);
		return "member/member_info";
	}
}

