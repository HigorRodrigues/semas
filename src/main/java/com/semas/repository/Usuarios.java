package com.semas.repository;

import com.semas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}