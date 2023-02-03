package services;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void addOneProduct(Product product){
        productRepository.addProduct(product);
    }

    @Transactional
    public void addOneProductNotCompleted(Product product){
        productRepository.addProduct(product);
        throw new RuntimeException("This transaction will not complete");
    }

    @Transactional
    public void addOneProduct2(Product product) throws Exception {
        productRepository.addProduct(product);
        throw new Exception("This transaction will not complete");
    }

    @Transactional(rollbackFor = Exception.class)
    public void addOneProduct3(Product product) throws Exception {
        productRepository.addProduct(product);
        throw new Exception("This transaction will not complete");
    }

    @Transactional
    public void addOneProduct4(Product product) {
        productRepository.addProduct(product);
        try {
            throw new RuntimeException("this transaction will be completed since exception is not propagated");
        } catch (RuntimeException runtimeException){runtimeException.printStackTrace();}
    }

}
