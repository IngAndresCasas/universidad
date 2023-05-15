package com.ventas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String codigo;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "salario_base")
    private int salarioBase;
    @Column(name = "porcentaje_de_comision")
    private double porcentajeComision;
    @Column
    private String zona;
    @Column(name = "fecha_de_ingreso")
    private String fechaDeIngreso;
    @Column
    private Boolean activo;
    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private List <Venta> venta;




}
