package com.cibertec.commerceapi.repository;

import com.cibertec.commerceapi.model.TipoDocIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocIdentidadRepository extends JpaRepository<TipoDocIdentidad, Long> {
}
