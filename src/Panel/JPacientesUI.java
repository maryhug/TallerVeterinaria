package Panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Principal.Inicio;

public class JPacientesUI extends JPanel {
	public JPacientesUI() {
	}

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
	private JPanel panelContenido;
	private JPanel panelForm;
	private CardLayout cardLayout;
	private Logica.PacienteManager pacienteManager;

//	public JPacientesUI(String doctorID, JPanel panelContenido, JPanel panelForm, CardLayout cardLayout) {
//		this.pacienteManager = new Logica.PacienteManager(doctorID);
//		this.panelContenido = panelContenido;
//		this.panelForm = panelForm;
//		this.cardLayout = cardLayout;
//
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//		JLabel lblNewLabel = new JLabel("Sistema de Gestión de Pacientes");
//		lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
//		add(lblNewLabel);
//
//		JPanel panelBotones = new JPanel();
//		add(panelBotones);
//
//		JButton btnRegistrarPaciente = new JButton("Registrar Paciente");
//		btnRegistrarPaciente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				registrarPaciente();
//			}
//		});
//		panelBotones.add(btnRegistrarPaciente);
//
//		JButton btnBuscarPaciente = new JButton("Buscar Paciente");
//		btnBuscarPaciente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				buscarPaciente();
//			}
//		});
//		panelBotones.add(btnBuscarPaciente);
//
//		JButton btnModificarPaciente = new JButton("Modificar Paciente");
//		btnModificarPaciente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				modificarPaciente();
//			}
//		});
//		panelBotones.add(btnModificarPaciente);
//
//		JButton btnEliminarPaciente = new JButton("Eliminar Paciente");
//		btnEliminarPaciente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				eliminarPaciente();
//			}
//		});
//		panelBotones.add(btnEliminarPaciente);
//
//		JButton btnVerHistoriales = new JButton("Ver Historiales");
//		btnVerHistoriales.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				verHistoriales();
//			}
//		});
//		panelBotones.add(btnVerHistoriales);
//		
//				JButton btnAgregarChequeo = new JButton("Agregar Chequeo Clínico");
//				btnAgregarChequeo.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						agregarChequeo();
//					}
//				});
//				panelBotones.add(btnAgregarChequeo);
//				
//						JButton btnAtras = new JButton("Atrás");
//						btnAtras.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent e) {
//								cardLayout.show(panelContenido, "menuPrincipal");
//							}
//						});
//						panelBotones.add(btnAtras);
//	}

//	public JPacientesUI(String doctorID, JPanel panelContenido, JPanel panelForm, CardLayout cardLayout) {
//	    this.pacienteManager = new Logica.PacienteManager(doctorID);
//	    this.panelContenido = panelContenido;
//	    this.panelForm = panelForm;
//	    this.cardLayout = cardLayout;
//
//	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//	    JLabel lblNewLabel = new JLabel("Sistema de Gestión de Pacientes");
//	    lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
//	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
//	    add(lblNewLabel);
//
//	    JPanel panelBotones = new JPanel(new GridLayout(0, 1)); // GridLayout con una columna variable
//	    add(panelBotones);
//
//	    JButton btnRegistrarPaciente = new JButton("Registrar Paciente");
//	    btnRegistrarPaciente.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            registrarPaciente();
//	        }
//	    });
//	    panelBotones.add(btnRegistrarPaciente);
//
//	    JButton btnBuscarPaciente = new JButton("Buscar Paciente");
//	    btnBuscarPaciente.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            buscarPaciente();
//	        }
//	    });
//	    panelBotones.add(btnBuscarPaciente);
//
//	    JButton btnModificarPaciente = new JButton("Modificar Paciente");
//	    btnModificarPaciente.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            modificarPaciente();
//	        }
//	    });
//	    panelBotones.add(btnModificarPaciente);
//
//	    JButton btnEliminarPaciente = new JButton("Eliminar Paciente");
//	    btnEliminarPaciente.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            eliminarPaciente();
//	        }
//	    });
//	    panelBotones.add(btnEliminarPaciente);
//
//	    JButton btnVerHistoriales = new JButton("Ver Historiales");
//	    btnVerHistoriales.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            verHistoriales();
//	        }
//	    });
//	    panelBotones.add(btnVerHistoriales);
//
//	    JButton btnAgregarChequeo = new JButton("Agregar Chequeo Clínico");
//	    btnAgregarChequeo.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            agregarChequeo();
//	        }
//	    });
//	    panelBotones.add(btnAgregarChequeo);
//
//	    JButton btnAtras = new JButton("Atrás");
//	    btnAtras.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            cardLayout.show(panelContenido, "menuPrincipal");
//	        }
//	    });
//	    panelBotones.add(btnAtras);
//	}
//	

	public JPacientesUI(String doctorID, JPanel panelContenido, JPanel panelForm, CardLayout cardLayout) {
		this.pacienteManager = new Logica.PacienteManager(doctorID);
		this.panelContenido = panelContenido;
		this.panelForm = panelForm;
		this.cardLayout = cardLayout;

		setLayout(new BorderLayout());

		JLabel lblNewLabel = new JLabel("Sistema de Gestión de Pacientes");
		lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panelBotones = new JPanel(new GridLayout(0, 1)); // GridLayout con una columna variable
		panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega relleno alrededor del panel
																					// de botones
		add(panelBotones, BorderLayout.CENTER); // Agrega el panel de botones al centro del BorderLayout

		JButton btnRegistrarPaciente = new JButton("Registrar Paciente");
		btnRegistrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPaciente();
			}
		});
		panelBotones.add(btnRegistrarPaciente);

		JButton btnBuscarPaciente = new JButton("Buscar Paciente");
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPaciente();
			}
		});
		panelBotones.add(btnBuscarPaciente);

		JButton btnModificarPaciente = new JButton("Modificar Paciente");
		btnModificarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPaciente();
			}
		});
		panelBotones.add(btnModificarPaciente);

		JButton btnEliminarPaciente = new JButton("Eliminar Paciente");
		btnEliminarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPaciente();
			}
		});
		panelBotones.add(btnEliminarPaciente);

		JButton btnVerHistoriales = new JButton("Ver Historiales");
		btnVerHistoriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verHistoriales();
			}
		});
		panelBotones.add(btnVerHistoriales);

		JButton btnAgregarChequeo = new JButton("Agregar Chequeo Clínico");
		btnAgregarChequeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarChequeo();
			}
		});
		panelBotones.add(btnAgregarChequeo);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio frame = (Inicio) SwingUtilities.getWindowAncestor(JPacientesUI.this);
				frame.mostrarJIngresoDoc();
			}
		});
		panelBotones.add(btnAtras);
	}

	private void registrarPaciente() {
		limpiarFormulario();
		int result = JOptionPane.showConfirmDialog(null, getFormularioPanel(), "Registrar Paciente",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			String nuevoRegistro = obtenerDatosFormulario();
			pacienteManager.guardarDatos(nuevoRegistro);
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
				llenarFormulario(datosPaciente);
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
		formularioPanel.setLayout(new GridLayout(10, 2));

		formularioPanel.add(new JLabel("Nombre Dueño:"));
		textFieldNombreDueño = new JTextField();
		formularioPanel.add(textFieldNombreDueño);

		formularioPanel.add(new JLabel("Dirección:"));
		textFieldDireccion = new JTextField();
		formularioPanel.add(textFieldDireccion);

		formularioPanel.add(new JLabel("Teléfono:"));
		textFieldTelefono = new JTextField();
		formularioPanel.add(textFieldTelefono);

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

		return formularioPanel;
	}

	private void limpiarFormulario() {
		if (textFieldNombreDueño != null) {
			textFieldNombreDueño.setText("");
			textFieldDireccion.setText("");
			textFieldTelefono.setText("");
			textFieldNombrePaciente.setText("");
			textFieldEspecie.setText("");
			textFieldRaza.setText("");
			textFieldEdad.setText("");
			textFieldSexo.setText("");
			textFieldColor.setText("");
			comboBoxVacunacion.setSelectedIndex(0);
		}
	}

	private String obtenerDatosFormulario() {
		StringBuilder datos = new StringBuilder();
		datos.append("Nombre Dueño: ").append(textFieldNombreDueño.getText()).append("\n");
		datos.append("Dirección: ").append(textFieldDireccion.getText()).append("\n");
		datos.append("Teléfono: ").append(textFieldTelefono.getText()).append("\n");
		datos.append("Nombre Paciente: ").append(textFieldNombrePaciente.getText()).append("\n");
		datos.append("Especie: ").append(textFieldEspecie.getText()).append("\n");
		datos.append("Raza: ").append(textFieldRaza.getText()).append("\n");
		datos.append("Edad: ").append(textFieldEdad.getText()).append("\n");
		datos.append("Sexo: ").append(textFieldSexo.getText()).append("\n");
		datos.append("Color: ").append(textFieldColor.getText()).append("\n");
		datos.append("Vacunación: ").append(comboBoxVacunacion.getSelectedItem().toString()).append("\n");
		datos.append("-----------------------------------------\n\n");
		return datos.toString();
	}

	private void llenarFormulario(String datosPaciente) {
		String[] datos = datosPaciente.split("\n");
		textFieldNombreDueño.setText(datos[0].substring(14));
		textFieldDireccion.setText(datos[1].substring(11));
		textFieldTelefono.setText(datos[2].substring(10));
		textFieldNombrePaciente.setText(datos[3].substring(17));
		textFieldEspecie.setText(datos[4].substring(8));
		textFieldRaza.setText(datos[5].substring(6));
		textFieldEdad.setText(datos[6].substring(6));
		textFieldSexo.setText(datos[7].substring(6));
		textFieldColor.setText(datos[8].substring(7));
		comboBoxVacunacion.setSelectedItem(datos[9].substring(12));
	}

	private void mostrarResultados(String resultados, String titulo) {
		JTextArea textArea = new JTextArea(resultados);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(500, 400));

		JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
	}
}
