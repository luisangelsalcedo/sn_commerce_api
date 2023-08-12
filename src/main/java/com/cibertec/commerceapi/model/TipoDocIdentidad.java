package com.cibertec.commerceapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_doc_identidad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocIdentidad {
    @Column(name="id_tipo_doc_identidad", nullable = false)
    private Long idTipoDocIdentidad;

    @Column(name="tipo_doc_identidad", length = 50, nullable = false)
    private String tipoDocIdentidad;
}
