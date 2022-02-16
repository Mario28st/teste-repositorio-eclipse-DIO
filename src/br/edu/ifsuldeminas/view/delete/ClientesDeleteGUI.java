package br.edu.ifsuldeminas.view.delete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifsuldeminas.controller.ControllerClientes;
import br.edu.ifsuldeminas.modelo.Clientes;
import br.edu.ifsuldeminas.view.ClientesMessage;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ClientesDeleteGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldcpf;
	private JTextField textFieldDataDeNascimento;
	private JTextField textFieldRg;
	private JTextField textFieldTelefone;
	private JTextField textFieldSalario;

	private ClientesMessage clientesMessage = null;
	private JTextField textFieldId;

	/**
	 * Create the frame.
	 */
	public ClientesDeleteGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientesDeleteGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		setTitle("Excluir Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome");
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setColumns(10);
		
		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setEditable(false);
		textFieldSobrenome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		
		textFieldcpf = new JTextField();
		textFieldcpf.setEditable(false);
		textFieldcpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento");
		
		textFieldDataDeNascimento = new JTextField();
		textFieldDataDeNascimento.setEditable(false);
		textFieldDataDeNascimento.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("RG");
		
		textFieldRg = new JTextField();
		textFieldRg.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setEditable(false);
		textFieldTelefone.setSize(545, 20);
		textFieldTelefone.setColumns(10);
		
		JButton btnExcluir = new JButton("Deletar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* recuperar os dados do JTextField */
				int id = Integer.parseInt(textFieldId.getText());
				String nome = textFieldNome.getText();
				String sobrenome = textFieldSobrenome.getText();
				String cpf = textFieldcpf.getText();
				String dataNascimento = textFieldDataDeNascimento.getText();
				String rg = textFieldRg.getText();
				String telefone = textFieldTelefone.getText();
				String salario = textFieldSalario.getText();
				
		
				double salarioDouble = 0;
				try {
					salarioDouble = Double.parseDouble(salario);
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Salário inválido");
					return;
				}
				
				DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, dataFormatada);
				
			    int input = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do funcionário: " + nome + " " + sobrenome  , "Atenção !", JOptionPane.YES_NO_OPTION);
			    
				 if(input == JOptionPane.NO_OPTION) {
				    	return;
				 }
				 
				Clientes novoCliente = new Clientes(id,nome, sobrenome, cpf, dataNascimentoFormatada, rg, telefone, salarioDouble);
				
				/* enviar para o controlador alterar os dados no banco */
				boolean resposta = ControllerClientes.getInstance().Delete(novoCliente);

				if(resposta == true) {
				   JOptionPane.showMessageDialog(null,  novoCliente.toString() + "\nalterado com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,  novoCliente.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
					dispose();	
				
			}
		});
		btnExcluir.setIcon(new ImageIcon(ClientesDeleteGUI.class.getResource("/img/Gnome-Process-Stop-32.png")));
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButtonCancelar.setIcon(new ImageIcon(ClientesDeleteGUI.class.getResource("/img/DeleteRed.png")));
		
		JLabel lblNewLabel_6 = new JLabel("Exclusão de Clientes");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel = new JPanel();
		
		JLabel labelId = new JLabel("ID");
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(116)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(btnNewButtonCancelar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
						.addComponent(textFieldTelefone, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldcpf, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldDataDeNascimento, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldRg, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelId, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldSobrenome, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))
					.addGap(69))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(labelId)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(textFieldSobrenome, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(textFieldId, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldcpf, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDataDeNascimento, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldRg, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButtonCancelar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnExcluir, btnNewButtonCancelar});
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {textFieldNome, textFieldSobrenome, textFieldcpf, textFieldDataDeNascimento, textFieldRg, textFieldTelefone});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnExcluir, btnNewButtonCancelar});
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Salário");
		lblNewLabel_7.setBounds(0, 11, 92, 14);
		panel.add(lblNewLabel_7);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setEditable(false);
		textFieldSalario.setBounds(10, 36, 211, 43);
		panel.add(textFieldSalario);
		textFieldSalario.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void addClientesMessage(ClientesMessage clientesMessage) {
		this.clientesMessage = clientesMessage;
	}
	
	public void updateGUI() {
		Clientes cliente = (Clientes) clientesMessage.receiveClientes();
		textFieldId.setText(String.valueOf(cliente.getId()));
		textFieldNome.setText(cliente.getNome());
		textFieldSobrenome.setText(cliente.getSobrenome());
		textFieldcpf.setText(cliente.getCpf());
		textFieldDataDeNascimento.setText(String.valueOf(cliente.getData_nascimento()));
		textFieldRg.setText(cliente.getRg());
		textFieldTelefone.setText(cliente.getTelefone());
		textFieldSalario.setText(String.valueOf(cliente.getSalario()));
		
	}
}
