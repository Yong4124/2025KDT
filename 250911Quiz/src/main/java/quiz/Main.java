package quiz;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductDao productDao;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // AppCtx에서 DataSource 가져와서 ProductDao 생성
        productDao = new ProductDao(AppCtx.dataSource());

        while(true) {
            System.out.println("\n1. Insert  2. Update  3. Delete  4. Select All  5. Select By ID  0. Exit");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 버퍼 비우기

            switch(choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    selectAll();
                    break;
                case 5:
                    selectById();
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void insert() {
        System.out.print("상품명: ");
        String name = scanner.nextLine();
        System.out.print("가격: ");
        double price = scanner.nextDouble();
        System.out.print("재고: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Product p = new Product(0, name, price, stock);
        int result = productDao.insert(p);
        System.out.println(result > 0 ? "삽입 성공" : "삽입 실패");
    }

    private static void update() {
        System.out.print("수정할 상품 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Product p = productDao.selectById(id);

            System.out.print("상품명 (" + p.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) p.setName(name);

            System.out.print("가격 (" + p.getPrice() + "): ");
            String priceStr = scanner.nextLine();
            if (!priceStr.isEmpty()) p.setPrice(Double.parseDouble(priceStr));

            System.out.print("재고 (" + p.getStock() + "): ");
            String stockStr = scanner.nextLine();
            if (!stockStr.isEmpty()) p.setStock(Integer.parseInt(stockStr));

            int result = productDao.update(p);
            System.out.println(result > 0 ? "수정 성공" : "수정 실패");
        } catch (Exception e) {
            System.out.println("해당 ID의 상품이 없습니다.");
        }
    }

    private static void delete() {
        System.out.print("삭제할 상품 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int result = productDao.delete(id);
        System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
    }

    private static void selectAll() {
        List<Product> products = productDao.selectAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void selectById() {
        System.out.print("조회할 상품 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Product p = productDao.selectById(id);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println("해당 ID의 상품이 없습니다.");
        }
    }
}
