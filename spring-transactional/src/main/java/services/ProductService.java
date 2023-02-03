package services;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    /*
    @Transactional(propagation = Propagation.REQUIRED) // default. use existing transaction or create new if no existing transaction
    @Transactional(propagation = Propagation.REQUIRES_NEW) // Always create a new transaction
    @Transactional(propagation = Propagation.MANDATORY) // must be called with/from a transactional method
    @Transactional(propagation = Propagation.NEVER) // must be called with/from a NON transactional method
    @Transactional(propagation = Propagation.SUPPORTS) // if transaction exists, use transaction otherwise run as non-transactional
    @Transactional(propagation = Propagation.NOT_SUPPORTED) // Always run as non-transactional even if called with transaction
    @Transactional(propagation = Propagation.NESTED) // create transactions within transaction. Parent transaction can rollback
                                                        nested transactions but not vice versa
    */
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
