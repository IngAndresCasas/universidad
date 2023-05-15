package com.ventas.service;

import com.ventas.model.Vendedor;
import com.ventas.model.Venta;
import com.ventas.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorService (VendedorRepository vendedorRepository){
        this.vendedorRepository = vendedorRepository;
    }


    public List<Vendedor> listarVendedor(){
        return vendedorRepository.findAll();
    }

    public Vendedor buscarVendedorPorId(Long id) {
        return vendedorRepository.findById(id).get();
    }

    public Vendedor crearVendedor(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public Vendedor actualizarVendedor(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }
    public void eliminarVendedor(Long id){
        vendedorRepository.deleteById(id);
    }
}
