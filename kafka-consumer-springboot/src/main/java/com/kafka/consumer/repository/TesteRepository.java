package com.kafka.consumer.repository;

import com.kafka.consumer.model.TesteKen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends JpaRepository<TesteKen, String> {

}
