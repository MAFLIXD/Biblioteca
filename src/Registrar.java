import java.util.Scanner;

public class Registrar {

    private String[][] libros = new String[1000][5];
    private int totalLibros = 0;
    Scanner input = new Scanner(System.in);

    public void registrarLibro() {
        if (totalLibros >= 1000) {
            System.out.println("!ERROR! No se pueden registrar más libros");
            return;
        }

        System.out.println("*** Registro de nuevo libro ***");
        System.out.print("Ingresa el nombre del libro: ");
        libros[totalLibros][0] = input.nextLine();
        System.out.print("Ingresa el nombre del autor: ");
        libros[totalLibros][1] = input.nextLine();
        System.out.print("Ingresa el tema del libro: ");
        libros[totalLibros][2] = input.nextLine();
        System.out.print("Ingresa el código del libro: ");
        libros[totalLibros][3] = input.nextLine();
        System.out.print("Ingresa el número de páginas del libro: ");
        libros[totalLibros][4] = input.nextLine();
        totalLibros++;
        System.out.println("Libro correctamente registrado");
    }

    public void actualizarLibro() {
        System.out.print("Ingrese el código del libro que quiere actualizar: ");
        String codigo = input.nextLine();

        int index = buscarPorCodigo(codigo);
        if (index == -1) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.println("*** Actualización de libro ***");
        System.out.print("Nuevo nombre del libro: ");
        libros[index][0] = input.nextLine();
        System.out.print("Nuevo autor: ");
        libros[index][1] = input.nextLine();
        System.out.print("Nueva materia: ");
        libros[index][2] = input.nextLine();
        System.out.print("Nuevo código: ");
        libros[index][3] = input.nextLine();
        System.out.print("Nuevo número de páginas: ");
        libros[index][4] = input.nextLine();

        System.out.println("Libro actualizado correctamente.");
    }

    public void eliminarLibro() {
        System.out.print("Ingrese el código del libro que desea eliminar: ");
        String codigo = input.nextLine();

        int index = buscarPorCodigo(codigo);
        if (index == -1) {
            System.out.println("Libro no encontrado.");
            return;
        }

        for (int i = index; i < totalLibros - 1; i++) {
            libros[i] = libros[i + 1];
        }

        libros[totalLibros - 1] = new String[5];
        totalLibros--;

        System.out.println("Libro eliminado correctamente.");
    }

    public void buscarLibro() {
        System.out.print("Ingrese el código del libro que quiere buscar: ");
        String codigo = input.nextLine();

        int index = buscarPorCodigo(codigo);
        if (index == -1) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.println("*** Libro encontrado ***");
        System.out.println("Nombre: " + libros[index][0]);
        System.out.println("Autor: " + libros[index][1]);
        System.out.println("Tema: " + libros[index][2]);
        System.out.println("Código: " + libros[index][3]);
        System.out.println("Páginas: " + libros[index][4]);
    }

    private int buscarPorCodigo(String codigo) {
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i][3].equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public void ordenarLibrosPorNombre() {
        for (int i = 0; i < totalLibros - 1; i++) {
            for (int j = i + 1; j < totalLibros; j++) {
                if (libros[i][0].compareToIgnoreCase(libros[j][0]) > 0) {
                    String[] temp = libros[i];
                    libros[i] = libros[j];
                    libros[j] = temp;
                }
            }
        }
        System.out.println("Libros ordenados por nombre.");
    }

    public void mostrarLibros() {
        if (totalLibros == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("*** Lista de libros registrados ***");
        for (int i = 0; i < totalLibros; i++) {
            System.out.println("Libro #" + (i + 1));
            System.out.println("Nombre: " + libros[i][0]);
            System.out.println("Autor: " + libros[i][1]);
            System.out.println("Tema: " + libros[i][2]);
            System.out.println("Código: " + libros[i][3]);
            System.out.println("Páginas: " + libros[i][4]);
            System.out.println("**************************");
        }
    }
}
