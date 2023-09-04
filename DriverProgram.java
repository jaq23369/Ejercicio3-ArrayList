import java.util.Scanner;
import java.util.ArrayList;

/**Estudiante: Joel Antonio Jaquez Lopez
 * Carné: #23369
 * Carrera: Ingeniería en Sistemas
 * Fecha de inicio: 2/9/2023
 * Ultima fecha de actualizacion: 2/9/2023
 * La clase DriverProgram es un programa interactivo para gestionar estudiantes, exámenes
 * y notas dentro de un curso específico.
 */
public class DriverProgram {
    /**
     * Método principal que inicia el programa y muestra un menú interactivo.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Curso curso = new Curso("Programación");
        
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("----- Menú -----");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Agregar examen");
            System.out.println("3. Agregar nota");
            System.out.println("4. Ver estadísticas de un examen por sede");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarEstudiante(scanner, curso);
                    break;
                case 2:
                    agregarExamen(scanner, curso);
                    break;
                case 3:
                    agregarNota(scanner, curso);
                    break;
                case 4:
                    verEstadisticasExamen(scanner, curso);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }

/**
     * Permite al usuario agregar un nuevo estudiante al curso.
     *
     * @param scanner Herramienta para recibir entradas del usuario.
     * @param curso El curso al que se añadirá el estudiante.
     */    
    public static void agregarEstudiante(Scanner scanner, Curso curso) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.next();
        System.out.print("Ingrese el código único del estudiante: ");
        int codigoUnico = scanner.nextInt();
        System.out.println("Ingrese el correo del estudiante: ");
        String correoElectronico = scanner.next();
        
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCodigoUnico(codigoUnico);
        estudiante.setCorreoElectronico(correoElectronico);
        
        curso.agregarEstudiante(estudiante);
        
        System.out.println("Estudiante agregado correctamente.");
    }


/**
     * Permite al usuario agregar un nuevo examen al curso.
     *
     * @param scanner Herramienta para recibir entradas del usuario.
     * @param curso El curso al que se añadirá el examen.
     */
    public static void agregarExamen(Scanner scanner, Curso curso) {
        System.out.print("Ingrese el nombre del examen: ");
        String nombreExamen = scanner.next();
        System.out.print("Ingrese la sede del examen: ");
        String sedeExamen = scanner.next();
        
        Examen examen = new Examen(nombreExamen, sedeExamen);
        
        curso.agregarExamen(examen);
        
        System.out.println("Examen agregado correctamente.");
    }

 /**
     * Permite al usuario agregar una nota para un estudiante en un examen específico.
     *
     * @param scanner Herramienta para recibir entradas del usuario.
     * @param curso El curso donde se añadirá la nota.
     */    
    public static void agregarNota(Scanner scanner, Curso curso) {
        System.out.print("Ingrese el código único del estudiante: ");
        int codigoUnico = scanner.nextInt();
        System.out.print("Ingrese el nombre del examen: ");
        String nombreExamen = scanner.next();
        System.out.print("Ingrese la nota: ");
        double nota = scanner.nextDouble();
        
        curso.agregarNota(codigoUnico, nombreExamen, nota);
        
        System.out.println("Nota agregada correctamente.");
    }

/**
     * Muestra al usuario las estadísticas de un examen específico.
     *
     * @param scanner Herramienta para recibir entradas del usuario.
     * @param curso El curso del que se mostrarán las estadísticas.
     */
    public static void verEstadisticasExamen(Scanner scanner, Curso curso) {
    ArrayList<String> sedesExamenes = curso.getSedesExamenes();
        
        if (sedesExamenes.isEmpty()) {
            System.out.println("No hay exámenes registrados en el curso.");
            return;
        }
         // Imprimimos las sedes disponibles
        System.out.println("Sedes disponibles:");
        
        for (String sede : sedesExamenes) {
            System.out.println("- " + sede);
        }
        // Pedimos al usuario que seleccione una sede
        System.out.print("Ingrese la sede del examen que desea ver: ");
        String sedeSeleccionada = scanner.next();
        // Buscamos los exámenes que se realizaron en la sede seleccionada
        ArrayList<Examen> examenesSedeSeleccionada = buscarExamenesPorSede(sedeSeleccionada, curso.getExamenes());
        // Si no se encontraron exámenes en la sede seleccionada, mostramos un mensaje y salimos de la función
        if (examenesSedeSeleccionada.isEmpty()) {
            System.out.println("No hay exámenes registrados en la sede " + sedeSeleccionada + ".");
            return;
        }
        // Mostramos las estadísticas de cada examen que se realizó en la sede seleccionada
        for (Examen examen : examenesSedeSeleccionada) {
            System.out.println("---------------------------");
            System.out.println("Nombre del examen: " + examen.getNombre());
            System.out.println("Sede del examen: " + examen.getSede());
            System.out.println("Promedio de notas: " + examen.calcularPromedio());
            System.out.println("Mediana de notas: " + examen.calcularMediana());
            System.out.println("Moda de notas: " + examen.calcularModa());
            System.out.println("Desviación estándar de notas: " + examen.calcularDesviacionEstandar());
            System.out.println("---------------------------");
        }
    }
    /**
 * Busca los exámenes que se realizaron en una sede específica.
 *
 * @param sede     La sede a buscar.
 * @param examenes La lista de exámenes en la que buscar.
 * @return Una lista de exámenes que se realizaron en la sede especificada.
 */
    public static ArrayList<Examen> buscarExamenesPorSede(String sede, ArrayList<Examen> examenes) {
        ArrayList<Examen> examenesSede = new ArrayList<>();
        for (Examen examen : examenes) {
            if (examen.getSede().equals(sede)) {
                examenesSede.add(examen);
            }
        }
        return examenesSede;
    }
}

