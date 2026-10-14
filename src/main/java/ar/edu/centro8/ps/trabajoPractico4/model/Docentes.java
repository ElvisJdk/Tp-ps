package ar.edu.centro8.ps.trabajoPractico4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class Docentes {

    private Long id;
    private String nombre;
    private String materia;

}
