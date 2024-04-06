package ma.enset.uni;

import ma.enset.uni.entities.Product;
import ma.enset.uni.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(UniApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      productRepository.save(new Product(null,"Mouse",500,310));
        productRepository.save(new Product(null,"Wallet",70,400));
        productRepository.save(new Product(null,"BackBag",200,200));
        List<Product> products = productRepository.findAll();
        products.forEach(p ->{
            System.out.println(p.toString());
        } );
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println(product.getId());
        System.out.println(product.getNom());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        List<Product> productList = productRepository.findByNomContains("W");
        productList.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("*****************");
        List<Product> productRepositoryByPriceBetween = productRepository.findByPriceBetween(100,400);
        productRepositoryByPriceBetween.forEach(pr -> {
            System.out.println(pr);
        });

    }
}
