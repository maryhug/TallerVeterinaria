package Panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Logica.PacienteManager;
import Principal.Inicio;

public class JPacientesUI extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textFieldNombreDueño;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldNombrePaciente;
	private JTextField textFieldEspecie;
	private JTextField textFieldRaza;
	private JTextField textFieldEdad;
	private JTextField textFieldSexo;
	private JTextField textFieldColor;
	private JComboBox<String> comboBoxVacunacion;
	private JTextArea textAreaCorreoElectronico;
	private JTextArea textAreaVacunacion;
	private JTextArea textAreaDesparasitaciones;
	private JTextArea textAreaEnfermedadesPrevias;
	private JTextArea textAreaCirugiasAnteriores;
	private JTextArea textAreaAlergias;
	private JTextArea textAreaMedicamentosActuales;
	private Logica.PacienteManager pacienteManager;

	PacienteManager huh = new PacienteManager(getName());

	public JPacientesUI(String doctorID) {
		this.pacienteManager = new Logica.PacienteManager(doctorID);

		setLayout(new BorderLayout(0, 0));

		JPanel Derecha = new JPanel();
		add(Derecha, BorderLayout.EAST);
		Derecha.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblEspacio_1 = new JLabel("");
		Derecha.add(lblEspacio_1);

		JLabel lblEspacio_2 = new JLabel("");
		Derecha.add(lblEspacio_2);

		JLabel lblEspacio_3 = new JLabel("");
		Derecha.add(lblEspacio_3);

		JButton btnMenuPrincipal = new JButton("Menu Principal");
		Derecha.add(btnMenuPrincipal);

		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientesUI.this);
				if (frame != null) {
					frame.mostrarJIngresoDoc();
				}
			}
		});

		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		Derecha.add(btnCerrarSesion);

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientesUI.this);
				if (frame != null) {
					frame.mostrarPanelInicioSesion();
				}
			}
		});

		JPanel Superior = new JPanel();
		add(Superior, BorderLayout.NORTH);

		JLabel TituloPrincipal = new JLabel("Pacientes");
		TituloPrincipal.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		Superior.add(TituloPrincipal);

		JPanel Izquierda = new JPanel();
		add(Izquierda, BorderLayout.WEST);

		JPanel Inferior = new JPanel();
		add(Inferior, BorderLayout.SOUTH);

		JPanel Centro = new JPanel();
		add(Centro, BorderLayout.CENTER);

		Centro.setLayout(new GridLayout(0, 1, 0, 0)); // Cambio a GridLayout

		JButton btnNewButton_2 = new JButton("Modifcar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPaciente();
			}
		});

		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPaciente();
			}
		});

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPaciente();
				llenarFormulario(doctorID);
			}
		});

		JButton btnNewButton_5 = new JButton("Agg chequeo");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarChequeo();
			}
		});

		JButton btnNewButton_3 = new JButton("Listar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verHistoriales();
			}
		});

		JButton btnNewButton_4 = new JButton("Buscar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPaciente();
			}
		});

		Centro.add(btnNewButton);
		Centro.add(btnNewButton_1);
		Centro.add(btnNewButton_2);
		Centro.add(btnNewButton_3);
		Centro.add(btnNewButton_4);
		Centro.add(btnNewButton_5);
	}

	private void registrarPaciente() {
		limpiarFormulario();

		int result = JOptionPane.showConfirmDialog(null, getFormularioPanel(), "Registrar Paciente",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if (textFieldNombreDueño.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del dueño.", "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showConfirmDialog(null, getFormularioPanel(), "Registrar Paciente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			} else {
				String nuevoRegistro = obtenerDatosFormulario();
				pacienteManager.guardarDatos(nuevoRegistro);
				llenarFormulario(nuevoRegistro);
			}
		}
	}

	private void buscarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:", "Buscar Paciente",
				JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			String resultados = pacienteManager.buscarPaciente(nombreDueño);
			mostrarResultados(resultados, "Buscar Paciente");
		}
	}

	private void modificarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:", "Modificar Paciente",
				JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			String datosPaciente = pacienteManager.modificarPaciente(nombreDueño);
			if (datosPaciente != null) {
				int result = JOptionPane.showConfirmDialog(null, getFormularioPanel(), "Modificar Paciente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					String nuevoRegistro = obtenerDatosFormulario();
					pacienteManager.guardarDatos(nuevoRegistro);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el paciente.", "Modificar Paciente",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void eliminarPaciente() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:", "Eliminar Paciente",
				JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			pacienteManager.eliminarPaciente(nombreDueño);
		}
	}

	private void verHistoriales() {
		String historiales = pacienteManager.verHistoriales();
		mostrarResultados(historiales, "Historiales de Pacientes");
	}

	private void agregarChequeo() {
		String nombreDueño = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño:",
				"Agregar Chequeo Clínico", JOptionPane.PLAIN_MESSAGE);
		if (nombreDueño != null) {
			String pacienteChequeo = pacienteManager.agregarChequeoClinico(nombreDueño);
			if (pacienteChequeo != null) {
				String chequeoClinico = JOptionPane.showInputDialog(null, "Ingrese el chequeo clínico:",
						"Agregar Chequeo Clínico", JOptionPane.PLAIN_MESSAGE);
				if (chequeoClinico != null && !chequeoClinico.trim().isEmpty()) {
					pacienteManager.guardarChequeoClinico(pacienteChequeo, chequeoClinico);
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar el chequeo clínico.", "Agregar Chequeo Clínico",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el paciente.", "Agregar Chequeo Clínico",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private JPanel getFormularioPanel() {
		JPanel formularioPanel = new JPanel();
		formularioPanel.setLayout(new GridLayout(0, 2, 5, 5));

		formularioPanel.add(new JLabel("Nombre Dueño:"));
		textFieldNombreDueño = new JTextField();
		formularioPanel.add(textFieldNombreDueño);

		formularioPanel.add(new JLabel("Dirección:"));
		textFieldDireccion = new JTextField();
		formularioPanel.add(textFieldDireccion);

		formularioPanel.add(new JLabel("Teléfono:"));
		textFieldTelefono = new JTextField();
		formularioPanel.add(textFieldTelefono);

		formularioPanel.add(new JLabel("Correo Electrónico:"));
		textAreaCorreoElectronico = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaCorreoElectronico));

		formularioPanel.add(new JLabel("Nombre Paciente:"));
		textFieldNombrePaciente = new JTextField();
		formularioPanel.add(textFieldNombrePaciente);

		formularioPanel.add(new JLabel("Especie:"));
		textFieldEspecie = new JTextField();
		formularioPanel.add(textFieldEspecie);

		formularioPanel.add(new JLabel("Raza:"));
		textFieldRaza = new JTextField();
		formularioPanel.add(textFieldRaza);

		formularioPanel.add(new JLabel("Edad:"));
		textFieldEdad = new JTextField();
		formularioPanel.add(textFieldEdad);

		formularioPanel.add(new JLabel("Sexo:"));
		textFieldSexo = new JTextField();
		formularioPanel.add(textFieldSexo);

		formularioPanel.add(new JLabel("Color:"));
		textFieldColor = new JTextField();
		formularioPanel.add(textFieldColor);

		formularioPanel.add(new JLabel("Vacunación:"));
		comboBoxVacunacion = new JComboBox<>(new String[] { "Sí", "No" });
		formularioPanel.add(comboBoxVacunacion);

		formularioPanel.add(new JLabel("Vacunación (Lista de vacunas con fechas):"));
		textAreaVacunacion = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaVacunacion));

		formularioPanel.add(new JLabel("Desparasitaciones (Fechas y productos usados):"));
		textAreaDesparasitaciones = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaDesparasitaciones));

		formularioPanel.add(new JLabel("Enfermedades Previas:"));
		textAreaEnfermedadesPrevias = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaEnfermedadesPrevias));

		formularioPanel.add(new JLabel("Cirugías Anteriores:"));
		textAreaCirugiasAnteriores = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaCirugiasAnteriores));

		formularioPanel.add(new JLabel("Alergias (alimentos, medicamentos, etc.):"));
		textAreaAlergias = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaAlergias));

		formularioPanel.add(new JLabel("Medicamentos Actuales:"));
		textAreaMedicamentosActuales = new JTextArea();
		formularioPanel.add(new JScrollPane(textAreaMedicamentosActuales));

		return formularioPanel;
	}

	private void limpiarFormulario() {
		if (textFieldNombreDueño != null) {
			textFieldNombreDueño.setText("");
			textFieldDireccion.setText("");
			textFieldTelefono.setText("");
			textAreaCorreoElectronico.setText("");
			textFieldNombrePaciente.setText("");
			textFieldEspecie.setText("");
			textFieldRaza.setText("");
			textFieldEdad.setText("");
			textFieldSexo.setText("");
			textFieldColor.setText("");
			comboBoxVacunacion.setSelectedIndex(0);
			textAreaVacunacion.setText("");
			textAreaDesparasitaciones.setText("");
			textAreaEnfermedadesPrevias.setText("");
			textAreaCirugiasAnteriores.setText("");
			textAreaAlergias.setText("");
			textAreaMedicamentosActuales.setText("");
		}
	}

	private String obtenerDatosFormulario() {
		StringBuilder datos = new StringBuilder();
		datos.append("Nombre Dueño: ").append(textFieldNombreDueño.getText()).append("\n");
		datos.append("Dirección: ").append(textFieldDireccion.getText()).append("\n");
		datos.append("Teléfono: ").append(textFieldTelefono.getText()).append("\n");
		datos.append("Correo Electrónico: ").append(textAreaCorreoElectronico.getText()).append("\n");
		datos.append("Nombre Paciente: ").append(textFieldNombrePaciente.getText()).append("\n");
		datos.append("Especie: ").append(textFieldEspecie.getText()).append("\n");
		datos.append("Raza: ").append(textFieldRaza.getText()).append("\n");
		datos.append("Edad: ").append(textFieldEdad.getText()).append("\n");
		datos.append("Sexo: ").append(textFieldSexo.getText()).append("\n");
		datos.append("Color: ").append(textFieldColor.getText()).append("\n");
		datos.append("Vacunación: ").append(comboBoxVacunacion.getSelectedItem().toString()).append("\n");
		datos.append("Vacunación (Lista de vacunas con fechas): ").append(textAreaVacunacion.getText()).append("\n");
		datos.append("Desparasitaciones (Fechas y productos usados): ").append(textAreaDesparasitaciones.getText())
				.append("\n");
		datos.append("Enfermedades Previas: ").append(textAreaEnfermedadesPrevias.getText()).append("\n");
		datos.append("Cirugías Anteriores: ").append(textAreaCirugiasAnteriores.getText()).append("\n");
		datos.append("Alergias (alimentos, medicamentos, etc.): ").append(textAreaAlergias.getText()).append("\n");
		datos.append("Medicamentos Actuales: ").append(textAreaMedicamentosActuales.getText()).append("\n");
		datos.append("-----------------------------------------\n\n");
		return datos.toString();
	}

	private void llenarFormulario(String datosPaciente) {
		String[] datos = datosPaciente.split("\n");
		if (datos.length >= 17) {
			if (textFieldNombreDueño != null) {
				textFieldNombreDueño.setText(datos[0].substring(14));
			}
			if (textFieldDireccion != null) {
				textFieldDireccion.setText(datos[1].substring(11));
			}
			if (textFieldTelefono != null) {
				textFieldTelefono.setText(datos[2].substring(10));
			}
			if (textAreaCorreoElectronico != null) {
				textAreaCorreoElectronico.setText(datos[3].substring(20));
			}
			if (textFieldNombrePaciente != null) {
				textFieldNombrePaciente.setText(datos[4].substring(17));
			}
			if (textFieldEspecie != null) {
				textFieldEspecie.setText(datos[5].substring(8));
			}
			if (textFieldRaza != null) {
				textFieldRaza.setText(datos[6].substring(6));
			}
			if (textFieldEdad != null) {
				textFieldEdad.setText(datos[7].substring(6));
			}
			if (textFieldSexo != null) {
				textFieldSexo.setText(datos[8].substring(6));
			}
			if (textFieldColor != null) {
				textFieldColor.setText(datos[9].substring(7));
			}
			if (comboBoxVacunacion != null) {
				comboBoxVacunacion.setSelectedItem(datos[10].substring(12));
			}
			if (textAreaVacunacion != null) {
				textAreaVacunacion.setText(datos[11].substring(37));
			}
			if (textAreaDesparasitaciones != null) {
				textAreaDesparasitaciones.setText(datos[12].substring(43));
			}
			if (textAreaEnfermedadesPrevias != null) {
				textAreaEnfermedadesPrevias.setText(datos[13].substring(21));
			}
			if (textAreaCirugiasAnteriores != null) {
				textAreaCirugiasAnteriores.setText(datos[14].substring(20));
			}
			if (textAreaAlergias != null) {
				textAreaAlergias.setText(datos[15].substring(31));
			}
			if (textAreaMedicamentosActuales != null) {
				textAreaMedicamentosActuales.setText(datos[16].substring(22));
			}
		} else {
			JOptionPane.showMessageDialog(null, "Los datos del paciente son incompletos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void mostrarResultados(String resultados, String titulo) {
		JTextArea textArea = new JTextArea(resultados);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(500, 400));

		JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
	}

}