package chap09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class HelloController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("list", memberDao.selectAll());
		return "main";
	}
	
	@GetMapping("/search")
	public String main(String email, Model model) {
		Member member = memberDao.selectByEmail(email);
		System.out.println(member);
		model.addAttribute("mem", member);
		return "result";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "insertForm";
	}
	
	@GetMapping("/insert")
	public String insert(String name, String email, String password, String regdate) {
		System.out.println(name + ", " + email + ", " + password + ", " + regdate);
		return "insertOk";
	}
}
