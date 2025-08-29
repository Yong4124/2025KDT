package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	// 기본 객체(request, response) 를 받아서 구현 객체를 만들려고
	String process(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	
}
