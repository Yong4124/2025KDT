package chap8;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao dao = ctx.getBean(MemberDao.class);
//		Member member = new Member(null, "hong2@korea.com", "1234", "홍길준", LocalDateTime.now());
//		dao.insert(member);
//		System.out.println("입력!" + member.getId());
//		System.out.println(dao.count("hong2@korea.com") + "건");
//		
//		Member member = dao.selectByEmail2("hong2@korea.com");
//		System.out.println(member);
		
		System.out.println(dao.selectAll());
		
	}

}
