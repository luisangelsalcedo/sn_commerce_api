package com.cibertec.commerceapi.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

public class Cliente {
    @Column(name="id_cliente", nullable = false)
    private Long idCliente;

    @Column(name="fec_nacimiento", nullable = false)
    private Date fecNacimiento;

    @Column(name="num_doc_identidad", length = 50, nullable = false)
    private String numDocIdentidad;

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Long idUsuario;

//    @OneToOne
//    @JoinColumn(name="id_tipo_doc_identidad")
//    private TipoDocIdentidad idTipoDocIdentidad;
}
