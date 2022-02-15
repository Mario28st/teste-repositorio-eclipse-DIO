package br.edu.ifsuldeminas.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import br.edu.ifsuldeminas.view.add.ClientesGUI;
import br.edu.ifsuldeminas.view.update.ClientesUpdateGUI;
import br.edu.ifsuldeminas.view.update.FilterUpdateClientes;
import br.edu.ifsuldeminas.view.delete.*;
import br.edu.ifsuldeminas.view.report.*;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Toolkit;

public class MainGUI {

	private JFrame frmSistemaDeClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmSistemaDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeClientes = new JFrame();
		frmSistemaDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/imagens/Group2_Buyers_Dark.png")));
		frmSistemaDeClientes.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmSistemaDeClientes.setTitle("Sistema de Clientes");
		frmSistemaDeClientes.setBounds(100, 100, 1093, 661);
		frmSistemaDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeClientes.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frmSistemaDeClientes.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/imagens/logo_if_resize.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainGUI.class.getResource("/imagens/Captura de tela2.png")));
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap(412, Short.MAX_VALUE)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeClientes.setJMenuBar(menuBar);
		
		JMenu mnMenuCadastro = new JMenu("Cadastro");
		mnMenuCadastro.setIcon(new ImageIcon(MainGUI.class.getResource("/imagens/add-folder16x16.png")));
		mnMenuCadastro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnMenuCadastro);
		
		JMenu mnMenuClientes = new JMenu("Clientes");
		mnMenuCadastro.add(mnMenuClientes);
		
		JMenuItem mntmMenuItemIncluir = new JMenuItem("Incluir");
		mntmMenuItemIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientesGUI novaGui = new ClientesGUI();
				novaGui.setLocationRelativeTo(null);
				novaGui.setVisible(true);
								
			}
		});
		mnMenuClientes.add(mntmMenuItemIncluir);
		
		JMenuItem mntmMenuItemAlterar = new JMenuItem("Alterar");
		mntmMenuItemAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FilterUpdateClientes filterUpdateClientes = new FilterUpdateClientes();
				filterUpdateClientes.setLocationRelativeTo(null);
				filterUpdateClientes.setVisible(true);
				
				//ClientesUpdateGUI novaUpdateGui = new ClientesUpdateGUI();
				//novaUpdateGui.setLocationRelativeTo(null);
				//novaUpdateGui.setVisible(true);
			}
		});
		mnMenuClientes.add(mntmMenuItemAlterar);
		
		JMenuItem mntmMenuItemExcluir = new JMenuItem("Excluir");
		mntmMenuItemExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FilterDeleteClientes filterDeleteClientes = new FilterDeleteClientes();
				filterDeleteClientes.setLocationRelativeTo(null);
				filterDeleteClientes.setVisible(true);
				
				//ClientesDeleteGUI novaDeleteGui = new ClientesDeleteGUI();
				//novaDeleteGui.setLocationRelativeTo(null);
				//novaDeleteGui.setVisible(true);
				
			}
		});
		mnMenuClientes.add(mntmMenuItemExcluir);
		
		JMenu mnMenuRelatorio = new JMenu("Relat\u00F3rio");
		mnMenuRelatorio.setIcon(new ImageIcon(MainGUI.class.getResource("/imagens/2175886_accounting_finance_business_checklist_payment_icon (1).png")));
		mnMenuRelatorio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnMenuRelatorio);
		
		JMenu mnNewMenuRelClientes = new JMenu("Clientes");
		mnMenuRelatorio.add(mnNewMenuRelClientes);
		
		JMenuItem mntmNewMenuItemGeraRel = new JMenuItem("Gerar Relat\u00F3rio");
		mntmNewMenuItemGeraRel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientesReportGUI novaReportGui = new ClientesReportGUI();
				novaReportGui.setLocationRelativeTo(null);
				novaReportGui.setVisible(true);
				
			}
		});
		mnNewMenuRelClientes.add(mntmNewMenuItemGeraRel);
		
		JMenuItem mntmNewMenuItemSair = new JMenuItem("");
		mntmNewMenuItemSair.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mntmNewMenuItemSair.setIcon(new ImageIcon(MainGUI.class.getResource("/imagens/Gnome-Application-Exit-32.png")));
		menuBar.add(mntmNewMenuItemSair);
	}
}
