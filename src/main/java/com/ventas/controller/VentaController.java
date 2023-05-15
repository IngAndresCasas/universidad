package com.ventas.controller;

import com.ventas.model.Venta;
import com.ventas.service.VentaService;
import org.aspectj.bridge.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService){
        this.ventaService=ventaService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Venta>> listarventas(){
        return ResponseEntity.ok(ventaService.listarVentas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarVentaPorId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(ventaService.buscarVentaPorId(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        try {
            Venta ventaCreada = ventaService.crearVenta(venta);
            return ResponseEntity.ok(ventaCreada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> editarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        try {
            Venta ventaExistente = ventaService.buscarVentaPorId(id);

            if (venta.getValorVenta() !=  0 )
                ventaExistente.setValorVenta(venta.getValorVenta());

            if (venta.getFecha() !=  null && !venta.getFecha().isEmpty() )
                ventaExistente.setFecha(venta.getFecha());


            if (venta.getObservacion() !=  null && !venta.getObservacion().isEmpty() )
                ventaExistente.setObservacion(venta.getObservacion());

            ventaService.actualizarVenta(ventaExistente);

            return ResponseEntity.ok(ventaExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Venta> eliminarVenta(@PathVariable Long id) {
        try {
            Venta eliminarVenta = ventaService.buscarVentaPorId(id);
            ventaService.eliminarVenta(id);
            return ResponseEntity.ok(eliminarVenta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
