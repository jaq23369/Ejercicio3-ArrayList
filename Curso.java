import java.util.ArrayList;

/**Estudiante: Joel Antonio Jaquez Lopez
 * Carné: #23369
 * Carrera: Ingeniería en Sistemas
 * Fecha de inicio: 2/9/2023
 * Ultima fecha de actualizacion: 2/9/2023
 * La clase Curso representa un curso con una lista de estudiantes inscritos y exámenes administrados.
 */
public class Curso {
    /** Nombre del curso. */
    private String nombre;
    /** Lista de estudiantes inscritos en el curso. */
    private ArrayList<Estudiante> estudiantes;
    /** Lista de exámenes administrados en el curso. */
    private ArrayList<Examen> examenes;

 /**
     * Constructor para inicializar un curso con un nombre específico.
     *
     * @param nombre Nombre del curso.
     */
    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.examenes = new ArrayList<>();
    }

/**
     * Retorna el nombre del curso.
     *
     * @return Nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

 /**
     * Establece o modifica el nombre del curso.
     *
     * @param nombre Nuevo nombre del curso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 /**
     * Retorna la lista de estudiantes inscritos en el curso.
     *
     * @return Lista de estudiantes.
     */
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

 /**
     * Agrega un estudiante a la lista de estudiantes del curso.
     *
     * @param estudiante Estudiante a agregar.
     */
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

/**
     * Elimina un estudiante de la lista de estudiantes del curso.
     *
     * @param estudiante Estudiante a eliminar.
     */
    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

/**
     * Retorna la lista de exámenes administrados en el curso.
     *
     * @return Lista de exámenes.
     */
    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

 /**
     * Agrega un examen a la lista de exámenes del curso.
     *
     * @param examen Examen a agregar.
     */
    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

/**
     * Elimina un examen de la lista de exámenes del curso.
     *
     * @param examen Examen a eliminar.
     */
    public void eliminarExamen(Examen examen) {
        examenes.remove(examen);
    }

/**
     * Agrega una nota a un examen específico para un estudiante identificado por su código único.
     *
     * @param codigoUnico Código único del estudiante.
     * @param nombreExamen Nombre del examen.
     * @param nota Nota a agregar.
     */
     public void agregarNota(int codigoUnico, String nombreExamen, double nota) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigoUnico() == codigoUnico) {
                for (Examen examen : examenes) {
                    if (examen.getNombre().equals(nombreExamen)) {
                        examen.agregarNota(nota);
                        break;
                    }
                }
                break;
            }
        }
    }

/**
     * Retorna el promedio de notas de un estudiante específico en un examen particular.
     *
     * @param codigoUnico Código único del estudiante.
     * @param nombreExamen Nombre del examen.
     * @return Promedio de notas del estudiante en el examen.
     */
    public double verPromedioEstudiante(int codigoUnico, String nombreExamen) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigoUnico() == codigoUnico) {
                for (Examen examen : examenes) {
                    if (examen.getNombre().equals(nombreExamen)) {
                        return examen.calcularPromedio();
                    }
                }
                break;
            }
        }
        return 0.0;
    }

 /**
     * Retorna el promedio de notas de todos los estudiantes en un examen particular.
     *
     * @param nombreExamen Nombre del examen.
     * @return Promedio de notas de todos los estudiantes en el examen.
     */
    public double verPromedioTodosEstudiantes(String nombreExamen) {
        double sumatoria = 0;
        int contador = 0;
        for (Examen examen : examenes) {
            if (examen.getNombre().equals(nombreExamen)) {
                sumatoria += examen.calcularPromedio();
                contador++;
            }
        }
        if (contador > 0) {
            return sumatoria / contador;
        } else {
            return 0.0;
        }
    }

/**
     * Retorna el promedio de notas del examen especificado.
     *
     * @param nombreExamen Nombre del examen.
     * @return Promedio del examen.
     */
    public double verPromedioExamen(String nombreExamen) {
        for (Examen examen : examenes) {
            if (examen.getNombre().equals(nombreExamen)) {
                return examen.calcularPromedio();
            }
        }
        return 0.0;
    }

/**
     * Genera y retorna un resumen de las estadísticas de un examen específico.
     *
     * @param nombreExamen Nombre del examen.
     * @return String representando las estadísticas del examen: promedio, mediana, moda y desviación estándar.
     */
    public String verEstadisticasExamen(String nombreExamen) {
    for (Examen examen : examenes) {
        if (examen.getNombre().equals(nombreExamen)) {
            double promedio = examen.calcularPromedio();
            double mediana = examen.calcularMediana();
            double moda = examen.calcularModa();
            double desviacionEstandar = examen.calcularDesviacionEstandar();

            String estadisticas = "Promedio: " + promedio + ", Mediana: " + mediana + ", Moda: " + moda + ", Desviación Estándar: " + desviacionEstandar;
            return estadisticas;
        }
    }
    return "";
}


 /**
     * Encuentra y retorna el estudiante con la nota más baja en un examen específico.
     *
     * @param nombreExamen Nombre del examen.
     * @return Estudiante con la nota más baja en el examen.
     */
    public Estudiante verEstudianteNotaMasBaja(String nombreExamen) {
        Estudiante estudianteNotaMasBaja = null;
        double notaMasBaja = Double.MAX_VALUE;
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : examenes) {
                if (examen.getNombre().equals(nombreExamen)) {
                    double promedioEstudiante = examen.calcularPromedio();
                    if (promedioEstudiante < notaMasBaja) {
                        notaMasBaja = promedioEstudiante;
                        estudianteNotaMasBaja = estudiante;
                    }
                }
            }
        }
        return estudianteNotaMasBaja;
    }

/**
     * Encuentra y retorna el estudiante con la nota más alta en un examen específico.
     *
     * @param nombreExamen Nombre del examen.
     * @return Estudiante con la nota más alta en el examen.
     */
    public Estudiante verEstudianteNotaMasAlta(String nombreExamen) {
        Estudiante estudianteNotaMasAlta = null;
        double notaMasAlta = Double.MIN_VALUE;
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : examenes) {
                if (examen.getNombre().equals(nombreExamen)) {
                    double promedioEstudiante = examen.calcularPromedio();
                    if (promedioEstudiante > notaMasAlta) {
                        notaMasAlta = promedioEstudiante;
                        estudianteNotaMasAlta = estudiante;
                    }
                }
            }
        }
        return estudianteNotaMasAlta;
    }
}