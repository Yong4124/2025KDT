package quiz;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        DeptDao dao = ctx.getBean(DeptDao.class);

        
        Dept dept = new Dept(50, "교육부", "서울");
        dao.insert(dept);
        System.out.println("입력 완료!");

       
        dept.setDname("교육과학기술부");
        dept.setLoc("서울특별시");
        dao.update(dept);
        System.out.println("수정 완료!");

      
        List<Dept> list = dao.selectAll();
        list.forEach(System.out::println);

       
        dao.delete(50);
        System.out.println("삭제 완료!");
    }
}

