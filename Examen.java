import java.util.ArrayList;
import java.util.Collections;

/**Estudiante: Joel Antonio Jaquez Lopez
 * Carné: #23369
 * Carrera: Ingeniería en Sistemas
 * Fecha de inicio: 2/9/2023
 * Ultima fecha de actualizacion: 2/9/2023
 * La clase Examen representa un examen.
 */

/**La clase Examen representa un examen que puede contener múltiples notas y provee 
 * métodos para calcular estadísticas relacionadas.
*/
public class Examen{
    /** Nombre del examen. */
    private String nombre;
    /** Lista de notas registradas en el examen. */
    private ArrayList<Double> notas;
    /** Sede donde se realizó el examen. */
    private String sede;

/**
     * Constructor de la clase Examen.
     * @param nombre El nombre del examen.
     * @param sede La sede del examen.
     */
    public Examen(String nombre, String sede){
        this.nombre = nombre;
        this.notas = new ArrayList<>();
        this.sede = sede;
    }

 /**
     * Obtiene el nombre del examen.
     * @return El nombre del examen.
     */
    public String getNombre(){
        return nombre;
    }

/**
     * Establece el nombre del examen.
     * @param nombre El nombre del examen.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

/**
     * Agrega una nueva nota a la lista de notas.
     *
     * @param nota La nota a agregar.
     */
    public void agregarNota(double nota){
        notas.add(nota);
    }

 /**
     * Calcula el promedio de las notas.
     *
     * @return El promedio de las notas.
     */
    public double calcularPromedio(){
        double suma = 0;
        for (double nota : notas){
            suma += nota;
        }
        return suma / notas.size();
    }

  /**
     * Calcula la mediana de las notas.
     *
     * @return La mediana de las notas.
     */
    public double calcularMediana(){
        Collections.sort(notas);
        int n = notas.size();
        if(n % 2 == 0){
            return (notas.get(n/2 - 1) + notas.get(n/2)) / 2.0;
        }else{
            return notas.get(n/2);
        }
    }

/**
     * Calcula la moda de las notas.
     *
     * @return La moda de las notas.
     */
    public double calcularModa(){
        int maxCount = 0;
        double moda = 0;
        for(double nota : notas){
            int count = 0;
            for(double nota2 : notas){
                if(nota == nota2){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                moda = nota;
            }
        }
        return moda;
    }

 /**
     * Calcula la desviación estándar de las notas.
     *
     * @return La desviación estándar de las notas.
     */
    public double calcularDesviacionEstandar(){
        double promedio = calcularPromedio();
        double sumatoria = 0;
        for(double nota : notas){
            sumatoria += Math.pow(nota - promedio, 2);
        }
        double varianza = sumatoria / notas.size();
        return Math.sqrt(varianza);
    }

/**
     * Obtiene la sede donde se realizó el examen.
     *
     * @return La sede del examen.
     */
    public String getSede() {
        return sede;
    }
    
/**
     * Establece la sede del examen.
     *
     * @param sede La sede a establecer.
     */
    public void setSede(String sede) {
        this.sede = sede;
    }
}