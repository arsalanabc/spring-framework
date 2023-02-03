package org.example;

import config.ProjectConfig;
import domain.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main {
    public static void main(String[] args) throws Exception{
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            ProductService productService = c.getBean(ProductService.class);
            Product product = new Product();
            product.setName("test");

            productService.addOneProduct(product); // this will be carried through
            productService.addOneProductNotCompleted(product); // this will NOT be completed due to RT expection
            productService.addOneProduct2(product); // this will complete because checked exceptions arenot handled by transactional manager
            productService.addOneProduct3(product); // this will NOT be completed because on rollbackPolicy
            productService.addOneProduct4(product); // this transaction will be completed since exception is not propagated


        }
    }
}