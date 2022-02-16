package br.edu.ifsuldeminas.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.edu.ifsuldeminas.view.add.ClientesGUI;
import br.edu.ifsuldeminas.view.update.ClientesUpdateGUI;
import br.edu.ifsuldeminas.view.update.FilterUpdateClientes;
import br.edu.ifsuldeminas.view.delete.*;
import br.edu.ifsuldeminas.view.relatorio.*;

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
	private JLabel lblDadosAluno;

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
				JOptionPane.showMessageDialog(null,  "Disciplina de Programação Orientada a Objetos II \n Aluna: Eliane Rodrigues de Paiva \n Avaliação final da disciplica" , "Curso Técnico de Desenvolvimento de Sistemas", JOptionPane.INFORMATION_MESSAGE);
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
		frmSistemaDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		frmSistemaDeClientes.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmSistemaDeClientes.setTitle("Sistema de Clientes");
		frmSistemaDeClientes.setBounds(100, 100, 1256, 653);
		frmSistemaDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeClientes.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frmSistemaDeClientes.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MainGUI.class.getResource("/img/logo_if_resize.png")));
		
		lblDadosAluno = new JLabel("");
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addComponent(lblDadosAluno, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addGap(430)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(440)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelCentral.createSequentialGroup()
							.addGap(45)
							.addComponent(lblDadosAluno, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
		);
		panelCentral.setLayout(gl_panelCentral);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeClientes.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setFont(new Font("Monospaced", Font.BOLD, 13));
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmSair.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Exit_Plain_Blue.png")));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mntmSair.setFont(new Font("Courier New", Font.PLAIN, 13));
		mnArquivo.add(mntmSair);
		
		JMenu mnMenuCadastro = new JMenu("Cadastro");
		mnMenuCadastro.setIcon(new ImageIcon(MainGUI.class.getResource("/img/add-folder16x16.png")));
		mnMenuCadastro.setFont(new Font("Monospaced", Font.BOLD, 13));
		menuBar.add(mnMenuCadastro);
		
		JMenu mnMenuClientes = new JMenu("Clientes");
		mnMenuClientes.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnMenuCadastro.add(mnMenuClientes);
		
		JMenuItem mntmMenuItemIncluir = new JMenuItem("Incluir");
		mntmMenuItemIncluir.setFont(new Font("Courier New", Font.PLAIN, 12));
		mntmMenuItemIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientesGUI novaGui = new ClientesGUI();
				novaGui.setLocationRelativeTo(null);
				novaGui.setVisible(true);
								
			}
		});
		mnMenuClientes.add(mntmMenuItemIncluir);
		
		JMenuItem mntmMenuItemAlterar = new JMenuItem("Alterar");
		mntmMenuItemAlterar.setFont(new Font("Courier New", Font.PLAIN, 12));
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
		mntmMenuItemExcluir.setFont(new Font("Courier New", Font.PLAIN, 12));
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
		mnMenuRelatorio.setIcon(new ImageIcon(MainGUI.class.getResource("/img/edit_form_icon.png")));
		mnMenuRelatorio.setFont(new Font("Monospaced", Font.BOLD, 13));
		menuBar.add(mnMenuRelatorio);
		
		JMenu mnNewMenuRelClientes = new JMenu("Clientes");
		mnNewMenuRelClientes.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnMenuRelatorio.add(mnNewMenuRelClientes);
		
		JMenuItem mntmNewMenuItemGeraRel = new JMenuItem("Gerar Relat\u00F3rio");
		mntmNewMenuItemGeraRel.setFont(new Font("Courier New", Font.PLAIN, 12));
		mntmNewMenuItemGeraRel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientesReportGUI novaReportGui = new ClientesReportGUI();
				novaReportGui.setLocationRelativeTo(null);
				novaReportGui.setVisible(true);
				
			}
		});
		mnNewMenuRelClientes.add(mntmNewMenuItemGeraRel);
	}
	public JLabel getLblNewLabel_1() {
		return lblDadosAluno;
	}
}
