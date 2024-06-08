package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Panel.JPacientesUI;

public class PacienteManager {
    private String doctorID;
    private String registroOriginal;
    private boolean pacienteEncontrado;

    public PacienteManager(String doctorID) {
        this.doctorID = doctorID;
    }

    public void guardarDatos(String nuevoRegistro) {
        try (FileWriter fw = new FileWriter("Archivos/datos_pacientes_" + doctorID + ".txt", true)) {
            if (registroOriginal != null) {
                eliminarRegistroOriginal();
                registroOriginal = null;
            }

            fw.write(nuevoRegistro);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
        }
    }

    public String buscarPaciente(String nombreDueño) {
        StringBuilder resultados = new StringBuilder();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Archivos/datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("Nombre Dueño: " + nombreDueño)) {
                    resultados.append(linea).append("\n");
                    while ((linea = br.readLine()) != null
                            && !linea.equals("-----------------------------------------")) {
                        resultados.append(linea).append("\n");
                    }
                    resultados.append("-----------------------------------------\n\n");
                    encontrado = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer los datos.");
        }

        if (encontrado) {
            return resultados.toString();
        } else {
            return "No se encontraron pacientes con el nombre del dueño proporcionado.";
        }
    }
    
    public String modificarPaciente(String nombreDueño) {
        boolean encontrado = false;
        StringBuilder datosPaciente = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos/datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("Nombre Dueño: " + nombreDueño)) {
                    encontrado = true;
                    datosPaciente.append(linea).append("\n");
                    for (int i = 0; i < 17; i++) {
                        datosPaciente.append(br.readLine()).append("\n");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer los datos.");
        }
        if (encontrado) {
            String registroOriginal = datosPaciente.toString();
            JOptionPane.showMessageDialog(null, "Datos del paciente para modificar:\n\n" + datosPaciente, "Datos del Paciente", JOptionPane.INFORMATION_MESSAGE);
            
            return registroOriginal;
        } else {
            return null;
        }
    }

    
    public void eliminarRegistroOriginal() {
        List<String> lineas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos/datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (registroOriginal != null) {
            String[] registroLineas = registroOriginal.split("\n");
            int inicio = lineas.indexOf(registroLineas[0]);
            for (int i = 0; i <= 11; i++) {
                lineas.remove(inicio);
            }

            try (FileWriter fw = new FileWriter("Archivos/datos_pacientes_" + doctorID + ".txt")) {
                for (String linea : lineas) {
                    fw.write(linea + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarPaciente(String nombreDueño) {
        boolean encontrado = false;
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Archivos/datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer los datos.");
            return;
        }

        StringBuilder registro = new StringBuilder();
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).contains("Nombre Dueño: " + nombreDueño)) {
                encontrado = true;
                for (int j = 0; j <= 11; j++) {
                    registro.append(lineas.remove(i)).append("\n");
                }
                break;
            }
        }

        if (encontrado) {
            try (FileWriter fw = new FileWriter("Archivos/datos_pacientes_" + doctorID + ".txt")) {
                for (String linea : lineas) {
                    fw.write(linea + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos.");
                return;
            }
            JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron pacientes con el nombre del dueño proporcionado.");
        }
    }

    public String verHistoriales() {
        StringBuilder historialCompleto = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Archivos/datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Nombre Dueño: ")) {
                    if (historialCompleto.length() > 0) {
                        historialCompleto.append("\n-----------------------------------------\n\n");
                    }
                }
                historialCompleto.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer los datos.";
        }

        return historialCompleto.toString();
    }

    public String agregarChequeoClinico(String nombreDueño) {
        StringBuilder pacienteBuilder = new StringBuilder();
        pacienteEncontrado = false;

        try (BufferedReader reader = new BufferedReader(
                new FileReader("Archivos/datos_pacientes_" + doctorID + ".txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                pacienteBuilder.append(linea).append("\n");
                if (linea.contains("Nombre Dueño: " + nombreDueño)) {
                    for (int i = 0; i < 9; i++) {
                        pacienteBuilder.append(reader.readLine()).append("\n");
                    }
                    return pacienteBuilder.toString();
                } else {
                    pacienteBuilder.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer los datos.";
        }

        return "No se encontró el paciente especificado.";
    }

    public void guardarChequeoClinico(String datosPaciente, String chequeoClinico) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formatter);

        try (FileWriter fw = new FileWriter("Archivos/datos_pacientes_" + doctorID + ".txt", true)) {
            if (!pacienteEncontrado) {
                fw.write(datosPaciente);
            }
            fw.write("Último Chequeo: " + fechaHora + "\n" + chequeoClinico + "\n");
            JOptionPane.showMessageDialog(null, "Chequeo clínico guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el chequeo clínico.");
        }
    }
}
