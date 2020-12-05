package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.UIManager;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionBoletaDNIClientes;
import model.BoletaDNICliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ItemEvent;

public class RepBoleta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblBoleta;
	private JTextField txtNumBoleta;
	private JTextField txtDNI;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser txtFechInicial;
	private JDateChooser txtFechFinal;
	private DefaultTableModel model;
	private JRadioButton rdbtnBoleta;
	private JRadioButton rdbtnDocumento;
	private JRadioButton rdbtnRango;
	
	private int tipoBusqueda = 0; // 0-> Boleta; 1-> DNI; 2 -> Fechas
	private ArrayList<BoletaDNICliente> gListadoBoletas = new ArrayList<BoletaDNICliente>();

	public RepBoleta() {
		setLayout(null);
		
		JPanel pBoleta = new JPanel();
		pBoleta.setBounds(0, 0, 827, 570);
		add(pBoleta);
		pBoleta.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 215, 616, 310);
		pBoleta.add(scrollPane);
		
		tblBoleta = new JTable();
		model = new DefaultTableModel();
		tblBoleta.setModel(model);
		model.addColumn("N° Boleta");
		model.addColumn("DNI Cliente");
		model.addColumn("Fecha");
		model.addColumn("SubTotal");
		model.addColumn("Descuento");
		model.addColumn("Total");
		scrollPane.setViewportView(tblBoleta);
		
		JButton btnBuscar = new JButton("BUSCAR");		
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.GRAY);
		btnBuscar.setBounds(665, 225, 117, 43);
		pBoleta.add(btnBuscar);
		
		JButton btnCancelar = new JButton("CANCELAR");		
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setBounds(665, 294, 117, 43);
		pBoleta.add(btnCancelar);
		
		JButton btnImprimir = new JButton("IMPRIMIR");		
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setOpaque(true);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.GRAY);
		btnImprimir.setBounds(665, 370, 117, 43);
		pBoleta.add(btnImprimir);
		
		JPanel pTipoBusqueda = new JPanel();
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda por Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pTipoBusqueda.setBorder(titled);
		pTipoBusqueda.setBounds(14, 29, 620, 149);
		pBoleta.add(pTipoBusqueda);
		pTipoBusqueda.setLayout(null);
		
		JLabel lblBuscarBoleta = new JLabel("Buscar por N\u00B0 Boleta");
		lblBuscarBoleta.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarBoleta.setBounds(62, 18, 132, 19);
		pTipoBusqueda.add(lblBuscarBoleta);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setColumns(10);
		txtNumBoleta.setBounds(316, 18, 265, 20);
		pTipoBusqueda.add(txtNumBoleta);
		
		JLabel lblBuscarDocumento = new JLabel("Buscar por N\u00B0 Documento DNI");
		lblBuscarDocumento.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarDocumento.setBounds(62, 56, 206, 19);
		pTipoBusqueda.add(lblBuscarDocumento);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setColumns(10);
		txtDNI.setBounds(316, 56, 265, 20);
		pTipoBusqueda.add(txtDNI);
		
		JLabel lblBuscarRango = new JLabel("Buscar por Rango de Fechas");
		lblBuscarRango.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblBuscarRango.setBounds(62, 102, 186, 19);
		pTipoBusqueda.add(lblBuscarRango);
		
		txtFechInicial = new JDateChooser();
		txtFechInicial.setBounds(294, 102, 107, 20);
		txtFechInicial.setEnabled(false);
		pTipoBusqueda.add(txtFechInicial);
		
		txtFechFinal = new JDateChooser();
		txtFechFinal.setBounds(474, 102, 107, 20);
		txtFechFinal.setEnabled(false);
		pTipoBusqueda.add(txtFechFinal);
		
		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblHasta.setBounds(422, 103, 35, 19);
		pTipoBusqueda.add(lblHasta);
		
		rdbtnBoleta = new JRadioButton("");		
		buttonGroup.add(rdbtnBoleta);
		rdbtnBoleta.setSelected(true);
		rdbtnBoleta.setBounds(28, 17, 28, 23);
		pTipoBusqueda.add(rdbtnBoleta);
		
		rdbtnDocumento = new JRadioButton("");		
		buttonGroup.add(rdbtnDocumento);
		rdbtnDocumento.setBounds(28, 54, 28, 23);
		pTipoBusqueda.add(rdbtnDocumento);
		
		rdbtnRango = new JRadioButton("");		
		buttonGroup.add(rdbtnRango);
		rdbtnRango.setBounds(28, 98, 28, 23);
		pTipoBusqueda.add(rdbtnRango);
		
		rdbtnBoleta.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if (arg0.getStateChange() == ItemEvent.DESELECTED) {
					txtNumBoleta.setEnabled(false);
				} else {
					txtNumBoleta.setEnabled(true);
					tipoBusqueda = 0;
				}
				
			}
		});
		
		rdbtnDocumento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					txtDNI.setEnabled(false);
				} else {
					txtDNI.setEnabled(true);
					tipoBusqueda = 1;
				}
			}
		});
		
		rdbtnRango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					txtFechInicial.setEnabled(false);
					txtFechFinal.setEnabled(false);
				} else {
					txtFechInicial.setEnabled(true);
					txtFechFinal.setEnabled(true);
					tipoBusqueda = 2;
				}
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoBoletasEnTabla();
				limpiar();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				model.setRowCount(0);
				gListadoBoletas = null;
			}
		});
		
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarReportePDF();
			}
		});

	}
	
	private void generarReportePDF() {
		
		int filas = tblBoleta.getRowCount();
		
		if (filas == 0 || filas == -1) {
			aviso("Oops. Se necesita de registros para generar el PDF");
			return;
		}
		
		Date date = new Date();
		int hashCode = date.toString().hashCode();
		
		String nombreArchivo = "reporte_Boleta" + hashCode + ".pdf";
		String ruta = "reportes/";
		String file = ruta + nombreArchivo;
		
		try {
			Document document = new Document();			
			FileOutputStream fileStream = new FileOutputStream(file);
			
			PdfWriter.getInstance(document, fileStream);
			
			document.open();
			
			Image logo = Image.getInstance("src/img/fenix_icon.png");
			logo.scaleToFit(75, 75);
			document.add(logo);
			
			com.itextpdf.text.Font iFont = FontFactory.getFont("Sans Serif", 36, com.itextpdf.text.Font.BOLDITALIC, BaseColor.RED);
			Paragraph p = new Paragraph("Reporte de Boletas Realizadas", iFont);
			p.setAlignment(Chunk.ALIGN_CENTER);
			
			document.add(p);			
			document.add(new Paragraph(" "));
			
			ArrayList<BoletaDNICliente> lista = gListadoBoletas;
			
			if (lista == null || lista.size() == 0) {
				p = new Paragraph("No se encontraron boletas realizadas");
				p.setAlignment(Chunk.ALIGN_CENTER);
				document.add(p);
			} else {
				PdfPTable table = new PdfPTable(6);
				p = new Paragraph("N° Boleta");
				PdfPCell col1 = new PdfPCell(p);
				col1.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col1);
				
				p = new Paragraph("DNI Cliente");				
				PdfPCell col2 = new PdfPCell(p);
				col2.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col2.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col2);
				
				p = new Paragraph("Fecha");				
				PdfPCell col3 = new PdfPCell(p);
				col3.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col3.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col3);
				
				p = new Paragraph("SubTotal");				
				PdfPCell col4 = new PdfPCell(p);
				col4.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col4.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col4);
				
				p = new Paragraph("Descuento");				
				PdfPCell col5 = new PdfPCell(p);
				col5.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col5.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col5);
				
				p = new Paragraph("Total");				
				PdfPCell col6 = new PdfPCell(p);
				col6.setHorizontalAlignment(Chunk.ALIGN_CENTER);
				col6.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(col6);
				
				for (BoletaDNICliente b : lista) {
					table.addCell(b.getNumeroBoleta()+"");
					table.addCell(b.getDniCliente());
					table.addCell(b.getFecha());
					table.addCell(b.getSubtotal()+"");
					table.addCell(b.getDescuento()+"");
					table.addCell(b.getTotal()+"");
				}
				
				document.add(table);
				document.add(new Paragraph(" "));
				
				if (tipoBusqueda == 2) {
					p = new Paragraph("Este reporte está generado entre las fechas de " + txtFechInicial.getDate()+ " y " + txtFechFinal.getDate());
				}
			}
			
			document.close();
			Desktop.getDesktop().open(new File(file));
			
			
		} catch (Exception e) {
			System.out.println("Error al crear archivo PDF : " + e.getMessage());
		}
		
	}
	
	private void listadoBoletasEnTabla() {
		gListadoBoletas = obtenerListaBoletasPor(tipoBusqueda);
		
		if (gListadoBoletas == null) {
			aviso("No se encontró resultados en la busqueda");
		} else {
			model.setRowCount(0);
			for (BoletaDNICliente bol : gListadoBoletas) {
				
				Object[] datos = {bol.getNumeroBoleta(), bol.getDniCliente(), bol.getFecha(), bol.getSubtotal(), bol.getDescuento(), bol.getTotal()};				
				model.addRow(datos);
			}
		}
		
	}
	
	
	private ArrayList<BoletaDNICliente> obtenerListaBoletasPor(int tipo) {
		switch (tipo) {
		case 0:
			return listadoPorBoleta();
		case 1:
			return listadoPorDNI();
		case 2:
			return listadoPorFechas();
		default:
			return null;
		}
	}
	
	private ArrayList<BoletaDNICliente> listadoPorBoleta() {
		int numBoleta = leerNumBoleta();
		
		if (numBoleta == -1) {
			return null;
		}
		
		return new GestionBoletaDNIClientes().listadoPorBoleta(numBoleta);
	}
	
	private ArrayList<BoletaDNICliente> listadoPorDNI() {
		String dni = leerDNI();
		
		if (dni == null) {
			return null;
		}
		
		return new GestionBoletaDNIClientes().listadoPorDNI(dni);
	}
	
	private ArrayList<BoletaDNICliente> listadoPorFechas() {
		String fech1 = leerFechaInicial();
		
		if (fech1 == null) {
			return null;
		}
		
		String fech2 = leerFechaFinal();
		
		if (fech2 == null) {
			return null;
		}
		
		return new GestionBoletaDNIClientes().listadoPorRangoFechas(fech1, fech2);
	}
	
	private void limpiar() {
		txtNumBoleta.setText("");
		txtDNI.setText("");
		txtFechInicial.setDate(null);
		txtFechFinal.setDate(null);
	}
	
	private int leerNumBoleta() {
		String boleta = txtNumBoleta.getText().trim();
		
		if (boleta.isEmpty()) {
			aviso("El campo NumBoleta está vacío");
			return -1;
		}
		
		if (!boleta.matches("[1-9]+")) {
			aviso("Ingrese un Número válido");
			return -1;
		}
		
		return Integer.parseInt(boleta);
		
	}
	
	private String leerDNI() {
		String dniRuc = txtDNI.getText().trim();

		if (dniRuc.isEmpty()) {
			aviso("El campo DNI-RUC está vacío");
			return null;
		}
		
		if (!dniRuc.matches("[1-9]{8}|[1-9]{11}")) {
			aviso("Ingrese un DNI o RUC válido");
			return null;
		}

		return dniRuc;

	}
	
	private String leerFechaInicial() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			return sdf.format(txtFechInicial.getDate());
		} catch (Exception e) {
			return null;
		}
	}
	
	private String leerFechaFinal() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			return sdf.format(txtFechFinal.getDate());
		} catch (Exception e) {
			return null;
		}
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
	
}
