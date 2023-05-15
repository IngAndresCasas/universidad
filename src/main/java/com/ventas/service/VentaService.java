package com.ventas.service;

import com.ventas.model.Venta;
import com.ventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService( VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> listarVentas(){
        return ventaRepository.findAll();
    }

    public Venta buscarVentaPorId(Long id) {
        return ventaRepository.findById(id).get();
    }

    public Venta crearVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public Venta actualizarVenta(Venta venta){
        return ventaRepository.save(venta);
    }
     public void eliminarVenta(Long id){
        ventaRepository.deleteById(id);
     }
}
