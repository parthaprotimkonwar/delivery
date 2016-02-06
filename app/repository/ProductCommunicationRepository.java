package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.ProductCommunication;

@Repository
public interface ProductCommunicationRepository extends JpaRepository<ProductCommunication, Long>{

}
