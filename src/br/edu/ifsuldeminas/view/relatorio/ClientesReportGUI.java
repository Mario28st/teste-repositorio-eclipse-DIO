package br.edu.ifsuldeminas.view.relatorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsuldeminas.controller.ControllerClientes;
import br.edu.ifsuldeminas.modelo.*;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;

public class ClientesReportGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ClientesReportGUI() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientesReportGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		setTitle("Relatório Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1033, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);
		
		JButton btnExecutarRel = new JButton("Executar Relatório");
		btnExecutarRel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExecutarRel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Clientes> listClientes = ControllerClientes.getInstance().ListAll();
				
				// código para preencher a JTable
				
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				table.setModel(modelo);
				
				int numeroLinhas = modelo.getRowCount();
				
				for(int i=0; i<numeroLinhas;i++)
					modelo.removeRow(0);
				
				Object[] elementos = new Object[8];
				
				for (Clientes cliente : listClientes) {
					elementos [0] = cliente.getId();
					elementos [1] = cliente.getNome();
					elementos [2] = cliente.getSobrenome();
					elementos [3] = cliente.getCpf();
					elementos [4] = cliente.getData_nascimento();
					elementos [5] = cliente.getRg();
					elementos [6] = cliente.getTelefone();
					elementos [7] = cliente.getSalario();
					
					modelo.addRow(elementos);
				}
			}
		});
		btnExecutarRel.setIcon(new ImageIcon(ClientesReportGUI.class.getResource("/img/book.png")));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(ClientesReportGUI.class.getResource("/img/DeleteRed.png")));
		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(
			gl_panelSul.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSul.createSequentialGroup()
					.addContainerGap(265, Short.MAX_VALUE)
					.addComponent(btnExecutarRel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addGap(138)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(211))
		);
		gl_panelSul.setVerticalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup()
					.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExecutarRel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelSul.setLayout(gl_panelSul);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("RELATÓRIO DE CLIENTES");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addGap(411)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(356, Short.MAX_VALUE))
		);
		gl_panelNorte.setVerticalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelNorte.setLayout(gl_panelNorte);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"id", "Nome", "Sobrenome", "CPF", "Data de Nascimento", "RG", "Telefone", "Salario"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, LocalDate.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(186);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(152);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(147);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(189);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(137);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(137);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(137);
		
		
		
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
	            table.getTableHeader().getDefaultRenderer();
		
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		
		scrollPane.setViewportView(table);
	}
}
