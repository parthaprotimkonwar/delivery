package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.TransactionCommunication;

@Repository
public interface TransactionCommunicationRepository extends JpaRepository<TransactionCommunication, Long>{

}
