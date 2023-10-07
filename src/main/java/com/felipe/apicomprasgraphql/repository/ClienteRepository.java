package com.felipe.apicomprasgraphql.repository;

import com.felipe.apicomprasgraphql.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
