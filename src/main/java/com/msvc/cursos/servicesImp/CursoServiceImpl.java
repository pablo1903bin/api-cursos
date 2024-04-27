package com.msvc.cursos.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msvc.cursos.entity.Curso;
import com.msvc.cursos.repositories.CursoRepository;
import com.msvc.cursos.services.CursoService;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> listar() {
		return (List<Curso>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> porId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Curso guardar(Curso curso) {
		String nombreCurso = curso.getNombre();
		Curso objCurso = new Curso();
		objCurso.setNombre(nombreCurso);
		Curso cursoSave = repository.save(objCurso);
		return cursoSave;
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		repository.deleteById(id);
	}
}
