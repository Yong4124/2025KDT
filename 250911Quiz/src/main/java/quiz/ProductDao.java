package quiz;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    // DataSource를 생성자에서 받아서 JdbcTemplate 생성
    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int insert(Product product) {
        String sql = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getStock());
    }

    public int update(Product product) {
        String sql = "UPDATE product SET name=?, price=?, stock=? WHERE id=?";
        return jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getStock(), product.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public Product selectById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    public List<Product> selectAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
