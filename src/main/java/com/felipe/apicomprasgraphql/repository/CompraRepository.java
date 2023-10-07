package com.felipe.apicomprasgraphql.repository;

import com.felipe.apicomprasgraphql.domain.Cliente;
import com.felipe.apicomprasgraphql.domain.Compra;
import com.felipe.apicomprasgraphql.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);

    @Query("select new com.felipe.apicomprasgraphql.dto.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p")
    List<CompraResumo> findAllComprasRelatorio();
}
