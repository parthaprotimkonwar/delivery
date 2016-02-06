package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.TransactionProductInfo;

@Repository
public interface TransactionProductInfoRepository extends JpaRepository<TransactionProductInfo, Long>{

}
