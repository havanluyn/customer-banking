package com.codegym.repository;
import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByFullnameLikeOrEmailLikeOrPhoneLike(String fullName, String email, String phone);

//    List<Customer> findAllByDeletedIsFalseAndIdNot(Long id);
    @Query(value = "SELECT u FROM Customer u WHERE u.id <> ?1")
    List<Customer> findAllAndIdNotExists(Long id);
}