package com.ventas.controller;

import com.ventas.model.Vendedor;
import com.ventas.service.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/vendedor")
public class VendedorController {

    private final VendedorService vendedorService;
    public VendedorController(VendedorService vendedorService){
        this.vendedorService = vendedorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Vendedor>> listarvendedores(){
        return ResponseEntity.ok(vendedorService.listarVendedor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarVendedorPorId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(vendedorService.buscarVendedorPorId(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Vendedor> crearVendedor(@RequestBody Vendedor vendedor) {
        try {
            Vendedor vendedorCreado = vendedorService.crearVendedor(vendedor);
            return ResponseEntity.ok(vendedorCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> editarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        try {
            Vendedor vendedorExistente = vendedorService.buscarVendedorPorId(id);

            if (vendedor.getSalarioBase() !=  0 && vendedorExistente.getSalarioBase() != vendedor.getSalarioBase())
                vendedorExistente.setSalarioBase(vendedor.getSalarioBase());

            if (vendedor.getNombreCompleto() !=  null && !vendedor.getNombreCompleto().isEmpty())
                vendedorExistente.setNombreCompleto(vendedor.getNombreCompleto());


            if (vendedor.getCodigo() !=  null && !vendedor.getCodigo().isEmpty())
                vendedorExistente.setCodigo(vendedor.getCodigo());


            if (vendedor.getZona() !=  null && !vendedor.getZona().isEmpty())
                vendedorExistente.setZona(vendedor.getZona());

            if (vendedor.getFechaDeIngreso() !=  null && !vendedor.getFechaDeIngreso().isEmpty())
                vendedorExistente.setFechaDeIngreso(vendedor.getFechaDeIngreso());


            if (vendedor.getPorcentajeComision() !=  0 && vendedorExistente.getPorcentajeComision() != vendedor.getPorcentajeComision())
                vendedorExistente.setPorcentajeComision(vendedor.getPorcentajeComision());

            if (vendedor.getActivo() !=  null )
                vendedorExistente.setActivo(vendedor.getActivo());


            vendedorService.actualizarVendedor(vendedorExistente);

            return ResponseEntity.ok(vendedorExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vendedor> eliminarVendedor(@PathVariable Long id) {
        try {
            Vendedor eliminarVendedor = vendedorService.buscarVendedorPorId(id);
            vendedorService.eliminarVendedor(id);
            return ResponseEntity.ok(eliminarVendedor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
