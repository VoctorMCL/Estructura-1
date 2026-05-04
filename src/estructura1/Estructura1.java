package estructura1;
import javax.swing.JOptionPane;

public class Estructura1 {
    
    public static void main(String[] args) {
        String op;
        int i= 0;
        String[] nombre = new String[100];
        String[] codigo = new String[100];
        double[] nota = new double[100];
        String[] estado = new String[100];
          
        JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema de Gestion de Calificaciones!");
        do {
            String menu = "¿Qué operación desea realizar? \n\n"
                        + "Seccion ESTUDIANTES:\n"
                        + "1 = Registrar Estudiante \n"
                        + "2 = Editar Estudiante existente\n"
                        + "3 = Eliminar Estudiante del sistema\n\n"
                        + "Seccion FUNCIONES:\n"
                        + "4 = Mostrar todos los estudiantes registrados\n"
                        + "5 = Calcular promedio de calificaciones del grupo\n"
                        + "6 = Contar cuantos estudiantes aprobaron\n"
                        + "7 = Identificar la nota mas alta\n"
                        + "8 = Buscar Estudiante por codigo institucional\n\n"
                        + "Escriba 'SALIR' para terminar";
            op = JOptionPane.showInputDialog(null, menu);
            if (op== null || op.equalsIgnoreCase("SALIR")) {
                break;
            }
             
            try {
                switch (op) {
                    case "1":
                        nombre[i]= JOptionPane.showInputDialog(null,"Digite el nombre del Estudiante:");           
                        if (nombre[i] == null || nombre[i].trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio","Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        codigo[i]= JOptionPane.showInputDialog(null,"Digite el codigo del Estudiante:");           
                        if (codigo[i] == null || codigo[i].trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El codigo no puede estar vacio","Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        codigo[i] = codigo[i].trim().toUpperCase();
                        boolean duplicado = false;
                        for (int j = 0; j < i; j++) {
                            if (codigo[j].equals(codigo[i])) {
                                JOptionPane.showMessageDialog(null, "Ya existe un estudiante con el codigo: " + codigo[i], "Intenta de nuevo", JOptionPane.WARNING_MESSAGE);
                                duplicado = true;
                                break;
                            }
                        }
                        if (duplicado) break;
                               
                        nota[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la nota del Estudiante (0.0 - 5.0):"));
                        if (nota[i] < 0.0 || nota[i] > 5.0) {
                            JOptionPane.showMessageDialog(null, "La nota debe estar entre 0.0 y 5.0", "Intenta de nuevo", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    
                        if (nota[i] >= 3.0) {
                            estado[i] = "APROBADO";
                        } else {
                            estado[i] = "REPROBADO";
                        }
                        JOptionPane.showMessageDialog(null, "Estudiante registrado\n\n" 
                                + "Nombre: " + nombre[i] + "\n"
                                + "Codigo: " + codigo[i] + "\n"
                                + "Nota: " + nota[i] + "\n"
                                + "Estado: " + estado[i]);
                        i++;
                        break; 
                        
                    case "2":
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        String editar = JOptionPane.showInputDialog(null, "Digite el codigo del Estudiante a editar:");
                        if (editar == null || editar.trim().isEmpty()) break;
                        editar = editar.trim().toUpperCase();

                        boolean editado = false;
                        for (int j = 0; j < i; j++) {
                            if (codigo[j].equals(editar)) {
                                nombre[j] = JOptionPane.showInputDialog(null, "Nuevo nombre:");
                                nota[j] = Double.parseDouble(JOptionPane.showInputDialog(null, "Nueva nota (0.0 - 5.0):"));
                                if (nota[j] < 0.0 || nota[j] > 5.0) {
                                    JOptionPane.showMessageDialog(null, "La nota debe estar entre 0.0 y 5.0", "Error", JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
                                if (nota[j] >= 3.0) {
                                    estado[j] = "APROBADO";
                                } else {
                                    estado[j] = "REPROBADO";
                                }
                                JOptionPane.showMessageDialog(null, "Estudiante editado\n\n"
                                        + "Nombre: " + nombre[j] + "\n"
                                        + "Codigo: " + codigo[j] + "\n"
                                        + "Nota: " + nota[j] + "\n"
                                        + "Estado: " + estado[j]);
                                editado = true;
                                break;
                            }
                        }
                        if (!editado) {
                            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con ese codigo.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                        
                    case "3":
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        String borrar = JOptionPane.showInputDialog(null, "Digite el codigo del Estudiante a eliminar:");
                        if (borrar == null || borrar.trim().isEmpty()) break;
                        borrar = borrar.trim().toUpperCase();

                        boolean borrado = false;
                        for (int j = 0; j < i; j++) {
                            if (codigo[j].equals(borrar)) {
                                for (int n = j; n < i - 1; n++) {
                                    nombre[n] = nombre[n + 1];
                                    codigo[n] = codigo[n + 1];
                                    nota[n]   = nota[n + 1];
                                    estado[n] = estado[n + 1];
                                }
                                i--;
                                borrado = true;
                                JOptionPane.showMessageDialog(null, "El Estudiante fue eliminado");
                                break;
                            }
                        }
                        if (!borrado) {
                            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con ese codigo", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                        
                    case "4":
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        String estudiantes = "Estudiantes registrados:\n\n";
                        for (int j = 0; j < i; j++) {
                            estudiantes += "Nombre: " + nombre[j] + "\n"
                                         + "Codigo: " + codigo[j] + "\n"
                                         + "Nota: " + nota[j] + "\n"
                                         + "Estado: " + estado[j] + "\n"
                                         + "===================\n";
                        }
                        JOptionPane.showMessageDialog(null, estudiantes);
                        break;
                        
                    case "5": 
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        double sum = 0;
                        for (int j = 0; j < i; j++) {
                            sum += nota[j];
                        }
                        JOptionPane.showMessageDialog(null, "El Promedio notas del grupo es de " + (sum / i));
                        break;

                    case "6":
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        int aprobados = 0;
                        String listaAprobados = "Estudiantes aprobados:\n\n";
                        for (int j = 0; j < i; j++) {
                            if (nota[j] >= 3.0) {
                                aprobados++;
                                listaAprobados += "Nombre: " + nombre[j] + "\n"
                                                + "Codigo: " + codigo[j] + "\n"
                                                + "Nota: " + nota[j] + "\n"
                                                + "===================\n";
                            }
                        }
                        listaAprobados += "Total aprobados: " + aprobados + " de " + i;
                        JOptionPane.showMessageDialog(null, listaAprobados);
                        break;
                        
                    case "7":
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        double mayor = nota[0];
                        for (int j = 1; j < i; j++) {
                            if (nota[j] > mayor) {
                                mayor = nota[j];
                            }
                        }
                        String mejores = "Estudiantes con la nota mas alta (" + mayor + "):\n\n";
                        for (int j = 0; j < i; j++) {
                            if (nota[j] == mayor) {
                                mejores += "Nombre: " + nombre[j] + "\n"
                                         + "Codigo: " + codigo[j] + "\n"
                                         + "Nota: " + nota[j] + "\n"
                                         + "Estado: " + estado[j] + "\n"
                                         + "===================\n";
                            }
                        }
                        JOptionPane.showMessageDialog(null, mejores);
                        break;
                        
                    case "8": 
                        if (i == 0) {
                            JOptionPane.showMessageDialog(null, "Aun no hay estudiantes registrados", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        String buscar = JOptionPane.showInputDialog(null, "Digite el codigo del Estudiante a buscar:");
                        if (buscar == null || buscar.trim().isEmpty()) break;
                        buscar = buscar.trim().toUpperCase();

                        boolean encontrado = false;
                        for (int j = 0; j < i; j++) {
                            if (codigo[j].equals(buscar)) {
                                JOptionPane.showMessageDialog(null, "Estudiante encontrado\n\n"
                                    + "Nombre: " + nombre[j] + "\n" 
                                    + "Codigo: " + codigo[j] + "\n" 
                                    + "Nota: " + nota[j] + "\n" 
                                    + "Estado: " + estado[j]);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con ese codigo", "Intenta de nuevo", JOptionPane.WARNING_MESSAGE);
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida. Intenta de nuevo");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada invalida. Ingrese numeros validos");
            }
            
        } while (true); 
        JOptionPane.showMessageDialog(null, "Programa finalizado ¡Gracias!");
    }    
}