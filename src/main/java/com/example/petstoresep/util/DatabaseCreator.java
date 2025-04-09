package com.example.petstoresep.util;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class DatabaseCreator implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("USE myfirstpetstore");
//
        String createView= """
                CREATE OR REPLACE VIEW itemP AS
                SELECT
                    item.itemid,
                    item.productid,
                    item.listprice,
                    item.unitcost,
                    item.supplier,
                    item.status,
                    item.attr1,
                    item.attr2,
                    item.attr3,
                    item.attr4,
                    item.attr5,
                    product.name
                    
                FROM
                    item
                JOIN
                    product
                ON
                    item.productid=product.productid
                """;
        jdbcTemplate.execute(createView);
    }
}
