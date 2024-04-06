package ma.enset.uni.repository;

import ma.enset.uni.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNomContains(String mc);

    @Query ("select p from Product p where p.nom like :x")
    List<Product> search(@Param("x") String mc);

    @Query("select p from Product p where p.price between :x and :y")
    List<Product> findByPriceBetween(@Param("x") double x, @Param("y") double y);
 }
