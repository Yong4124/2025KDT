package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deptDAO;
import dao.empDAO;
import dao.joinDAO;
import dto.deptDTO;
import dto.empDTO;
import dto.joinDTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/joinlist") || com.equals("/")) {
			joinDAO dao = new joinDAO();
			List<joinDTO> list = dao.selectList();
			request.setAttribute("joinlist", list);
			view = "joinlist.jsp";
		} else if (com.equals("/deptlist")) {
			deptDAO dao = new deptDAO();
			List<deptDTO> list = dao.selectList();
			request.setAttribute("deptlist", list);
			view = "deptlist.jsp";
		} else if (com.equals("/emplist")) {
			empDAO dao = new empDAO();
			List<empDTO> list = dao.selectList();
			request.setAttribute("emplist", list);
			view = "emplist.jsp";
		} else if (com.equals("/deptinsertForm")) {
			view = "redirect:deptinsertForm.jsp";
		} else if (com.equals("/deptinsert")) {
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			deptDAO dao = new deptDAO();
			dao.insertOne(new deptDTO(deptno, dname, loc));
			view = "redirect:deptlist";
		} else if (com.equals("/empinsertForm")) {
			view = "redirect:empinsertForm.jsp";
		} else if (com.equals("/empinsert")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			String hiredate = request.getParameter("hiredate");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			empDAO dao = new empDAO();
			dao.insertOne(new empDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			view = "redirect:emplist";
		} else if (com.equals("/deptdelete")) {
			String deptno = request.getParameter("deptno");
			deptDAO dao = new deptDAO();
			dao.deleteOne(deptno);
			view = "redirect:deptlist";
		}else if (com.equals("/empdelete")) {
			String empno = request.getParameter("empno");
			System.out.println(empno);
			empDAO dao = new empDAO();
			dao.deleteOne(empno);
			view = "redirect:emplist";
		} else if (com.equals("/deptupdateForm")) {
			String deptno = request.getParameter("deptno");
			deptDAO dao = new deptDAO();
			deptDTO dto = dao.selectOne(deptno);
			request.setAttribute("dto", dto);
			view = "deptupdateForm.jsp";
		} else if (com.equals("/deptupdate")) {
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			deptDAO dao = new deptDAO();
			dao.updateOne(new deptDTO(deptno, dname, loc));
			view = "redirect:deptlist";
		} else if (com.equals("/empupdateForm")) {
			String empno = request.getParameter("empno");
			empDAO dao = new empDAO();
			empDTO dto = dao.selectOne(empno);
			request.setAttribute("dto", dto);
			view = "empupdateForm.jsp";
		} else if (com.equals("/empupdate")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			String hiredate = request.getParameter("hiredate");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			empDAO dao = new empDAO();
			dao.updateOne(new empDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			view = "redirect:emplist";
		}
		
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
