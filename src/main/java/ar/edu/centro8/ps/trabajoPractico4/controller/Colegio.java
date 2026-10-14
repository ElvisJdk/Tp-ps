package ar.edu.centro8.ps.trabajoPractico4.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.centro8.ps.trabajoPractico4.model.Cursos;
import ar.edu.centro8.ps.trabajoPractico4.model.Docentes;

@RestController
public class Colegio {

  @GetMapping("/cursos")
  @PreAuthorize("hasAuthority('READ_CURSOS')")
  public List<Cursos> listarCursos(@RequestBody Cursos c) {
    List<Cursos> cursos = new ArrayList<>();
    cursos.add(c);
    return cursos;
  }

  @PostMapping("/cursos")
  @PreAuthorize("hasAuthority('WRITE_CURSOS')")
  public Cursos crearCurso(@RequestBody Cursos cursos) {
    return cursos;
  }

  @GetMapping("/docentes")
  @PreAuthorize("hasRole('ADMIN') or hasAuthority('WRITE_DOCENTES')")
  public List<Docentes> listarDocentes(@RequestBody Docentes d) {

    return Arrays.asList(d);
  }

  @PostMapping("/docentes")
  @PreAuthorize("hasRole('ADMIN') and hasAuthority('WRITE_DOCENTES')")
  public Docentes crearDocente2(@RequestBody Docentes d) {

    return d;
  }

  @GetMapping("/public")
  @PreAuthorize("permitAll()")
  public String noSecHelloWorld() {

    return "Hola Mundo sin seguridad";
  }

}
