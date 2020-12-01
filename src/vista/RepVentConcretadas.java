package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionVentasConcretadas;
import model.VentaConcretada;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class RepVentConcretadas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtCantidadEncontrada;
	private JTextField txtCantidadAVisualizar;
	private JTable tblReporte;
	private JTextField txtGananciaTotal;
	
	private DefaultTableModel model;
	private JTextField txtHistorialVentas;
	private JTextField txtHistorialGanancia;
	private JDateChooser txtDesde;
	private JDateChooser txtHasta;

	public RepVentConcretadas() {
		setLayout(null);
		
		JPanel panelVentasConcretadas = new JPanel();		
		panelVentasConcretadas.setBounds(0, 0, 817, 551);
		add(panelVentasConcretadas);
		panelVentasConcretadas.setLayout(null);
		
		JPanel pBusquedasFecha = new JPanel();
		pBusquedasFecha.setBorder(crearBordeTitulo("Opciones de B\u00fasqueda por Fecha"));
		pBusquedasFecha.setBounds(21, 28, 544, 141);
		panelVentasConcretadas.add(pBusquedasFecha);
		pBusquedasFecha.setLayout(null);
		
		JLabel lblDesde = new JLabel("DESDE");
		lblDesde.setBounds(10, 18, 32, 14);
		pBusquedasFecha.add(lblDesde);
		
		txtDesde = new JDateChooser();
		txtDesde.setBounds(10, 43, 139, 20);
		pBusquedasFecha.add(txtDesde);
		
		JLabel lblHasta = new JLabel("HASTA");
		lblHasta.setBounds(10, 74, 33, 14);
		pBusquedasFecha.add(lblHasta);
		
		txtHasta = new JDateChooser();
		txtHasta.setBounds(10, 99, 139, 20);
		pBusquedasFecha.add(txtHasta);
		
		JLabel lblCantidadEncontrada = new JLabel("CANTIDAD ENCONTRADA");
		lblCantidadEncontrada.setBounds(205, 18, 124, 14);
		pBusquedasFecha.add(lblCantidadEncontrada);
		
		txtCantidadEncontrada = new JTextField();
		txtCantidadEncontrada.setForeground(Color.RED);
		txtCantidadEncontrada.setEditable(false);
		txtCantidadEncontrada.setBounds(205, 43, 162, 20);
		pBusquedasFecha.add(txtCantidadEncontrada);
		txtCantidadEncontrada.setColumns(10);
		
		JButton btnBuscarVentas = new JButton("BUSCAR");		
		btnBuscarVentas.setForeground(Color.WHITE);
		btnBuscarVentas.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscarVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarVentas.setContentAreaFilled(false);
		btnBuscarVentas.setOpaque(true);
		btnBuscarVentas.setBorder(null);
		btnBuscarVentas.setBackground(new Color(9, 168, 136));
		btnBuscarVentas.setBounds(205, 88, 162, 31);
		pBusquedasFecha.add(btnBuscarVentas);
		
		JPanel pFiltroCantidad = new JPanel();
		pFiltroCantidad.setLayout(null);
		pFiltroCantidad.setBorder(crearBordeTitulo("Opciones de B\u00fasqueda por Fecha"));
		pFiltroCantidad.setBounds(21, 191, 544, 82);
		panelVentasConcretadas.add(pFiltroCantidad);
		
		JLabel lblCantidadAVisualizar = new JLabel("VISUALIZAR");
		lblCantidadAVisualizar.setBounds(10, 18, 59, 14);
		pFiltroCantidad.add(lblCantidadAVisualizar);
		
		txtCantidadAVisualizar = new JTextField();
		txtCantidadAVisualizar.setColumns(10);
		txtCantidadAVisualizar.setBounds(10, 44, 162, 20);
		pFiltroCantidad.add(txtCantidadAVisualizar);
		
		JButton btnGenerarReporte = new JButton("GENERAR REPORTE");		
		btnGenerarReporte.setForeground(Color.WHITE);
		btnGenerarReporte.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGenerarReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarReporte.setContentAreaFilled(false);
		btnGenerarReporte.setOpaque(true);
		btnGenerarReporte.setBorder(null);
		btnGenerarReporte.setBackground(new Color(9, 168, 136));
		btnGenerarReporte.setBounds(198, 33, 162, 31);
		pFiltroCantidad.add(btnGenerarReporte);
		
		JButton btnCancelarReporte = new JButton("CANCELAR REPORTE");		
		btnCancelarReporte.setForeground(Color.WHITE);
		btnCancelarReporte.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelarReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelarReporte.setContentAreaFilled(false);
		btnCancelarReporte.setOpaque(true);
		btnCancelarReporte.setBorder(null);
		btnCancelarReporte.setBackground(new Color(241, 71, 38));
		btnCancelarReporte.setBounds(372, 33, 162, 31);
		pFiltroCantidad.add(btnCancelarReporte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 284, 596, 206);
		panelVentasConcretadas.add(scrollPane);
		
		tblReporte = new JTable();
		model = new DefaultTableModel();
		tblReporte.setModel(model);
		model.addColumn("N° Boleta");
		model.addColumn("Cliente");
		model.addColumn("Compras");
		model.addColumn("Total");
		tblReporte.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblReporte.getColumnModel().getColumn(1).setPreferredWidth(366);
		tblReporte.getColumnModel().getColumn(2).setPreferredWidth(85);
		tblReporte.getColumnModel().getColumn(3).setPreferredWidth(85);
		scrollPane.setViewportView(tblReporte);
		
		txtGananciaTotal = new JTextField();
		txtGananciaTotal.setEditable(false);
		txtGananciaTotal.setBounds(531, 501, 86, 26);
		panelVentasConcretadas.add(txtGananciaTotal);
		txtGananciaTotal.setColumns(10);
		
		JLabel lblGananciaTotal = new JLabel("Ganancia Total");
		lblGananciaTotal.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblGananciaTotal.setBounds(436, 507, 87, 18);
		panelVentasConcretadas.add(lblGananciaTotal);
		
		JLabel lblHistorialDeVentas = new JLabel("Historial de ventas totales");
		lblHistorialDeVentas.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblHistorialDeVentas.setBounds(633, 79, 149, 18);
		panelVentasConcretadas.add(lblHistorialDeVentas);
		
		txtHistorialVentas = new JTextField();
		txtHistorialVentas.setEditable(false);
		txtHistorialVentas.setBounds(657, 105, 95, 26);
		panelVentasConcretadas.add(txtHistorialVentas);
		txtHistorialVentas.setColumns(10);
		
		JLabel lblHistorialDeGanancia = new JLabel("Historial de ganancia");
		lblHistorialDeGanancia.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblHistorialDeGanancia.setBounds(644, 176, 121, 18);
		panelVentasConcretadas.add(lblHistorialDeGanancia);
		
		txtHistorialGanancia = new JTextField();
		txtHistorialGanancia.setEditable(false);
		txtHistorialGanancia.setColumns(10);
		txtHistorialGanancia.setBounds(657, 205, 95, 26);
		panelVentasConcretadas.add(txtHistorialGanancia);
		
		JButton btnImprimirReporte = new JButton("IMPRIMIR REPORTE");		
		btnImprimirReporte.setBounds(657, 315, 130, 39);
		panelVentasConcretadas.add(btnImprimirReporte);
		
		cargarHistorialVentas();
		cargarHistorialGanancia();
		
		btnBuscarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarVentas();
			}
		});
		
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarReporte();
			}
		});
		
		btnCancelarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnImprimirReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirPDF();
			}
		});
	}
	
	private void imprimirPDF() {
		
		int filas = tblReporte.getRowCount();
		
		if (filas == 0 || filas == -1) {
			aviso("Oops. Se necesita de registros de reporte para generar el PDF");
			return;
		}	
				
		Date date = new Date();
		int hashCode = date.toString().hashCode();
		
		String nombreArchivo = "reporte_venCont" + hashCode + ".pdf";
		String ruta = "reportes/";
		String file = ruta + nombreArchivo;
		
		try {
			
			Document document = new Document();			
			FileOutputStream fileStream = new FileOutputStream(file);
			
			PdfWriter writer = PdfWriter.getInstance(document, fileStream);
			
			document.open();
			
			com.itextpdf.text.Font iFont = FontFactory.getFont("Sans Serif", 36, com.itextpdf.text.Font.BOLDITALIC, BaseColor.RED);
			Paragraph p = new Paragraph("Reporte de Ventas Concretadas", iFont);
			p.setAlignment(Chunk.ALIGN_CENTER);
			
			document.add(p);

			iFont = FontFactory.getFont("Sans Serif", 14, com.itextpdf.text.Font.NORMAL, BaseColor.DARK_GRAY);
			p = new Paragraph("Reporte desde " + leerFechaInicial() + " hasta el " + leerFechaFinal(), iFont);
			p.setAlignment(Chunk.ALIGN_CENTER);

			document.add(new Paragraph(" "));
			document.add(p);

			iFont = FontFactory.getFont("Sans Serif", 11, com.itextpdf.text.Font.ITALIC, BaseColor.BLACK);

			/*
			if (leerCantidadEncontrada() == 0) {
				p = new Paragraph("No se encontraron ventas concretadas");
				p.setAlignment(Chunk.ALIGN_CENTER);

			} else
			
			*/
			
			if (leerCantidadAVisualizar() == leerCantidadEncontrada()) {
				p = new Paragraph("*Se han seleccionado todos los registros encontrados", iFont);
				p.setAlignment(Chunk.ALIGN_LEFT);

			} else {
				p = new Paragraph("*Se ah seleccionado los primeros " + leerCantidadAVisualizar() + " registros", iFont);
				p.setAlignment(Chunk.ALIGN_LEFT);
			}
			
			document.add(new Paragraph(" "));
			document.add(p);
			document.add(new Paragraph(" "));
			
			ArrayList<VentaConcretada> ventas = new GestionVentasConcretadas().buscarVentasEnFechas(leerFechaInicial(), leerFechaFinal(), leerCantidadAVisualizar());
			
			if (ventas == null || ventas.size() == 0) {
				p = new Paragraph("No se encontraron ventas concretadas");
				p.setAlignment(Chunk.ALIGN_CENTER);
				document.add(p);
			} else {
				PdfPTable table = new PdfPTable(4);
				
				p = new Paragraph("N° Boleta");				
				PdfPCell col1 = new PdfPCell(p);
				col1.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col1);
				
				p = new Paragraph("Cliente");				
				PdfPCell col2 = new PdfPCell(p);
				col2.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col2.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col2);
				
				p = new Paragraph("Compras realizadas");				
				PdfPCell col3 = new PdfPCell(p);
				col3.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col3.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col3);
				
				p = new Paragraph("Monto Total");				
				PdfPCell col4 = new PdfPCell(p);
				col4.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col4.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col4);

				for (VentaConcretada v : ventas) {
					table.addCell(v.getNumBoleta()+"");
					table.addCell(v.getCliente());
					table.addCell(v.getComprasRealizadas()+"");
					table.addCell(v.getTotal()+"");
				}
				document.add(table);
			}

			document.close();
			Desktop.getDesktop().open(new File(file));

		} catch (Exception e) {
			System.out.println("Error al crear archivo PDF : " + e.getMessage());
		}
		
		System.out.println(file);
	}
	
	private void cargarHistorialVentas() {
		int historial = new GestionVentasConcretadas().obtenerHistorialVentas();
		
		txtHistorialVentas.setText(historial+"");
	}
	
	private void cargarHistorialGanancia() {
		double historial = new GestionVentasConcretadas().obtenerHistorialGanancia();
		txtHistorialGanancia.setText(historial + "");
	}
	
	private void generarReporte() {
		String fech1 = leerFechaInicial();		
		if (fech1 == null) return;
		
		String fech2 = leerFechaFinal();
		if (fech2 == null) return;
		
		int cantidadAVisualizar = leerCantidadAVisualizar();
		if (cantidadAVisualizar == -1) return;
		
		ArrayList<VentaConcretada> lista = new GestionVentasConcretadas().buscarVentasEnFechas(fech1, fech2, cantidadAVisualizar);
		
		mostrarRegistrosEnTabla(lista);
		
		double gananciaTotal = calcularGananciaTotal();
		
		if (gananciaTotal != -1) {
			txtGananciaTotal.setText(gananciaTotal+"");
		}
		
	}
	
	private void mostrarRegistrosEnTabla(ArrayList<VentaConcretada> lista) {
		model.setRowCount(0);
		for (VentaConcretada v : lista) {
			insertarRegistroTabla(v);
		}
	}
	
	private void insertarRegistroTabla(VentaConcretada v) {
		Object[] datos = {v.getNumBoleta(), v.getCliente(), v.getComprasRealizadas(), v.getTotal()};
		model.addRow(datos);
	}
	
	private void buscarVentas() {
		
		String fech1 = leerFechaInicial();
		if (fech1 == null) return;
		
		String fech2 = leerFechaFinal();
		if (fech2 == null) return;
		
		int cantidad = new GestionVentasConcretadas().cantidadVentas(fech1, fech2);
		
		if (cantidad == 0) {
			aviso("No se encontraron ventas concretadas");
		} else {
			txtCantidadEncontrada.setText(cantidad + "");
		}

	}
	
	private double calcularGananciaTotal() {
		int cantidadFilas = model.getRowCount();
		double importe = 0;
		double gananciaTotal = 0;
		
		if (cantidadFilas == 0 || cantidadFilas == -1) return -1;
		
		for (int i = 0; i < cantidadFilas; i++) {
			importe = Double.parseDouble(tblReporte.getValueAt(i, 3).toString());
			gananciaTotal += importe;
		}
		
		return gananciaTotal;
	}
	
	private String leerFechaInicial() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			return sdf.format(txtDesde.getDate());
		} catch (Exception e) {
			aviso("Seleccione una Fecha inicial válida");
			return null;
		}
	}
	
	private String leerFechaFinal() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			return sdf.format(txtHasta.getDate());
		} catch (Exception e) {
			aviso("Seleccione una Fecha final válida");
			return null;
		}
	}
	
	private int leerCantidadEncontrada() {
		String cantidad = txtCantidadEncontrada.getText().trim();
		
		if (cantidad.isEmpty()) {
			return -1;
		}
		
		return Integer.parseInt(cantidad);
	}
	
	private int leerCantidadAVisualizar() {
		String cantidad = txtCantidadAVisualizar.getText().trim();
		
		if (cantidad.isEmpty()) {
			aviso("El Campo Cantidad a Visualizar está vacío");
			return -1;
		}
		
		if (!cantidad.matches("[0-9]+")) {
			aviso("Ingrese una Cantidad Válida");
			return -1;
		}
		
		int cantidadVisualizar = Integer.parseInt(cantidad);
		
		if (cantidadVisualizar > leerCantidadEncontrada()) {
			aviso("Ingrese un valor menor o igual a la Cantidad Encontrada");
			return -1;
		}
		
		return cantidadVisualizar;
	}
	
	private double leerGananciaTotal() {
		String ganancia = txtGananciaTotal.getText().trim();
		
		if (ganancia.isEmpty()) {
			return -1;
		}
		
		return Double.parseDouble(ganancia);
	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
}
