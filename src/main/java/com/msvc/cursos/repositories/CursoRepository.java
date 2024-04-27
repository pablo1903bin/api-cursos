package com.msvc.cursos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.msvc.cursos.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
