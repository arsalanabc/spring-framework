package repositories;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addProduct(Product product){
        String sql = "INSERT into product_table VALUES (NULL, ?)";
        jdbcTemplate.update(sql, product.getName());
    };

}
