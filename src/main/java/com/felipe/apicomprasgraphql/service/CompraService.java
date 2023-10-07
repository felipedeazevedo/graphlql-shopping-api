package com.felipe.apicomprasgraphql.service;

import com.felipe.apicomprasgraphql.domain.Cliente;
import com.felipe.apicomprasgraphql.domain.Compra;
import com.felipe.apicomprasgraphql.dto.CompraResumo;
import com.felipe.apicomprasgraphql.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;

    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Transactional
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    @Transactional
    public boolean deleteById(Long id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return compraRepository.findAllComprasRelatorio();
    }
}
