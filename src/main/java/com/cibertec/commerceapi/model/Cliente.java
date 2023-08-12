package com.cibertec.commerceapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente", nullable = false)
    private Long idCliente;

    @Column(name="fec_nacimiento", nullable = false)
    private LocalDate fecNacimiento;

    @Column(name="num_doc_identidad", length = 50, nullable = false)
    private String numDocIdentidad;

    @Column(name="id_usuario")
    private Long idUsuario; // dato de microservicio externo

    @OneToOne
    @JoinColumn(name="id_tipo_doc_identidad")
    private TipoDocIdentidad tipoDocIdentidad;
}
