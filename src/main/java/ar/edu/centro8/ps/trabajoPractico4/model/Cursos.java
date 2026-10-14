package ar.edu.centro8.ps.trabajoPractico4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {
    private int id;
    private String nombre;
    private String descripcion;
}
