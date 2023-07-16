package com.codeusingjava.InfoManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ventas")
//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Ventas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;

    @Column(name="idplato", nullable = false)
    private String idplato;

    @Column(name="cedcliente", nullable = false)
    private String cedcliente;

    @Column(name="cedusuario", nullable = false)
    private String cedusuario;

    @Column(name="discapacidad", nullable = false)
    private String discapacidad;

    @Column(name="fecha", nullable = false)
    private String fecha;

    @Column(name="cantidad", nullable = false)
    private String cantidad;

    @Column(name="tipopago", nullable = false)
    private String tipopago;

    @Column(name="descuento", nullable = false)
    private String descuento;

    @Column(name="subtotal", nullable = false)
    private String subtotal;

    @Column(name="total", nullable = false)
    private String total;
}
