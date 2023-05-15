package com.ventas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fecha;
    @Column(name = "valor_venta")
    private int valorVenta;
    @Column
    private String observacion;
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

}
