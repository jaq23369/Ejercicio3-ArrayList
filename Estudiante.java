/**Estudiante: Joel Antonio Jaquez Lopez
 * Carné: #23369
 * Carrera: Ingeniería en Sistemas
 * Fecha de inicio: 2/9/2023
 * Ultima fecha de actualizacion: 2/9/2023
 * La clase Estudiante representa a un estudiante con su informacion basica.
 */
public class Estudiante{
    /** Nombre del estudiante. */
    private String nombre;
     /** Apellido del estudiante. */
    private String apellido;
       /** Código único identificatorio del estudiante. */
    private int codigoUnico;
    /** Fecha de nacimiento del estudiante. */
    private String fechaNacimiento;
    /** Correo electrónico del estudiante. */
    private String correoElectronico;
    /** Sede a la que pertenece el estudiante. */
    private String sede;

/**
     * Obtiene el nombre del estudiante.
     * 
     * @return nombre del estudiante.
     */
    public String getNombre(){
        return nombre;
    }

/**
     * Establece el nombre del estudiante.
     * 
     * @param nombre nombre a establecer.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

/**
     * Obtiene el apellido del estudiante.
     * 
     * @return apellido del estudiante.
     */
    public String getApellido(){
        return apellido;
    }

/**
     * Establece el apellido del estudiante.
     * 
     * @param apellido apellido a establecer.
     */
    public void setApellido(String Apellido){
        this.apellido= apellido;
    }

 /**
     * Obtiene el código único del estudiante.
     * 
     * @return código único del estudiante.
     */
    public int getCodigoUnico(){
        return codigoUnico;
    }

/**
     * Establece el código único del estudiante.
     * 
     * @param codigoUnico código a establecer.
     */
    public void setCodigoUnico(int codigoUnico){
        this.codigoUnico = codigoUnico;
    }

/**
     * Obtiene la fecha de nacimiento del estudiante.
     * 
     * @return fecha de nacimiento.
     */
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del estudiante.
     * 
     * @param fechaNacimiento fecha a establecer.
     */

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

/**
     * Obtiene el correo electrónico del estudiante.
     * 
     * @return correo electrónico.
     */
    public String getCorreoElectronico(){
        return correoElectronico;
    }

/**
     * Establece el correo electrónico del estudiante.
     * 
     * @param correoElectronico correo a establecer.
     */
    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }

/**
     * Obtiene la sede a la que pertenece el estudiante.
     * 
     * @return sede del estudiante.
     */
     public String getSede() {
        return sede;
    }
    
    /**
     * Establece la sede del estudiante.
     * 
     * @param sede sede a establecer.
     */
    public void setSede(String sede) {
        this.sede = sede;
    }
}