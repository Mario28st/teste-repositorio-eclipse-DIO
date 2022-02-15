package br.edu.ifsuldeminas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

import br.edu.ifsuldeminas.cadastro.Clientes;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.ListSelectionModel;

public class SearchClientesGUI extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private SearchMessageListener mySearchListener;



	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public SearchClientesGUI() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("relat\u00F3rio de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);
		
		JButton btnSelecionarIdentifier = new JButton("Selecionar ID");
		btnSelecionarIdentifier.setEnabled(false);
		btnSelecionarIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				int id = Integer.parseInt(value);
				mySearchListener.sendIdentifier(id);
				dispose();
			}
		});
		btnSelecionarIdentifier.setIcon(new ImageIcon(SearchClientesGUI.class.getResource("/imagens/add.png")));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(SearchClientesGUI.class.getResource("/imagens/DeleteRed.png")));
		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup()
					.addGap(170)
					.addComponent(btnSelecionarIdentifier, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
					.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		gl_panelSul.setVerticalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSul.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelecionarIdentifier, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelSul.linkSize(SwingConstants.VERTICAL, new Component[] {btnSelecionarIdentifier, btnFechar});
		gl_panelSul.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnSelecionarIdentifier, btnFechar});
		panelSul.setLayout(gl_panelSul);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Pesquisa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(
			gl_panelNorte.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addContainerGap(391, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(385))
		);
		gl_panelNorte.setVerticalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panelNorte.setLayout(gl_panelNorte);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSelecionarIdentifier.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Sobrenome", "CPF", "data de nascimento", "RG", "Telefone", "Salário"
			}
		));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(186);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(147);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(189);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(137);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(137);
				
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
	            table.getTableHeader().getDefaultRenderer();
		
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		scrollPane.setViewportView(table);
	}
	
	public void addSearchListener(SearchMessageListener mySearchMessgeListener) {
		this.mySearchListener = mySearchMessgeListener;
	}
	
		
	public void updateTable() {
		
	/* recupero a lista de Clientes */
		List<Clientes> listClientes = mySearchListener.receiveList();
		
		/* CÃ³digo para popular a JTable */
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		table.setModel(modelo);
		
		int numeroLinhas = modelo.getRowCount();
		
		for(int i=0; i<numeroLinhas;i++)
			modelo.removeRow(0);
		
		Object[] elementos = new Object[8];
		
		for (Clientes identiClientes: listClientes) {
			
		
				elementos[0] = identiClientes.getId();
				elementos[1] = identiClientes.getNome();
				elementos[2] = identiClientes.getSobrenome();
				elementos[3] = identiClientes.getCpf();
				elementos[4] = identiClientes.getData_nascimento();
				elementos[5] = identiClientes.getRg();
				elementos[6] = identiClientes.getTelefone();
				elementos[7] = identiClientes.getSalario();
		
				modelo.addRow(elementos);
		}
		}
	}
