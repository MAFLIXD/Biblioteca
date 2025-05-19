import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Registrar libro = new Registrar();
        int opcion = 0;

        String menu = """
                \n***Bienvendo a la biblioteca ucompensar***
                
                1- Registrar nuevo libro
                2- Actualizar libro
                3- Eliminar libro
                4- Buscar libro
                5- Ordenar libros por nombre
                6- Mostrar todos los libros
                7- Salir
                """;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    libro.registrarLibro();
                    break;
                case 2:
                    libro.actualizarLibro();
                    break;
                case 3:
                    libro.eliminarLibro();
                    break;
                case 4:
                    libro.buscarLibro();
                    break;
                case 5:
                    libro.ordenarLibrosPorNombre();
                    break;
                case 6:
                    libro.mostrarLibros();
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
        input.close();
    }
}