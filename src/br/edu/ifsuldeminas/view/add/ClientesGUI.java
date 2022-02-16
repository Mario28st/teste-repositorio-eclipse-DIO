package br.edu.ifsuldeminas.view.add;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.edu.ifsuldeminas.controller.ControllerClientes;
import br.edu.ifsuldeminas.modelo.Clientes;

public class ClientesGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldcpf;
	private JTextField textFieldDataDeNascimento;
	private JTextField textFieldRg;
	private JTextField textFieldTelefone;
	private JTextField textFieldSalario;

	/**
	 * Create the frame.
	 */
	public ClientesGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientesGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		setTitle("Cadastrar Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 788, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		
		textFieldcpf = new JTextField();
		textFieldcpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento");
		
		textFieldDataDeNascimento = new JTextField();
		textFieldDataDeNascimento.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("RG");
		
		textFieldRg = new JTextField();
		textFieldRg.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setSize(545, 20);
		textFieldTelefone.setColumns(10);
		
		JButton btnNewButtonIncluir = new JButton("Incluir");
		btnNewButtonIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//recuoerar os dados do JTextField
				
				String nome = textFieldNome.getText();
				//System.out.println(nome);
				String sobrenome = textFieldSobrenome.getText();
				//System.out.println(sobrenome);
				String cpf = textFieldcpf.getText();		
				//System.out.println(cpf);
				String dataNascimento = textFieldDataDeNascimento.getText();
				System.out.println(dataNascimento);
				String rg = textFieldRg.getText();	
				//System.out.println(rg);
				String telefone = textFieldTelefone.getText();	
				//System.out.println(telefone);
				String salario = textFieldSalario.getText();
				//System.out.println(salario);
				
	             
				double salarioCliente = 0;
				try {
					salarioCliente = Double.parseDouble(salario);
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Salário Inválido");
				}
				
				DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			     
		        LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, dataFormatada);

		        System.out.println(dataNascimentoFormatada.format(dataFormatada));
				
				// Criar objeto Clientes
				
				Clientes novoCliente = new Clientes (nome, sobrenome, cpf, dataNascimentoFormatada, rg, telefone, salarioCliente);
				System.out.println(novoCliente.toString());
								
				// Adicionr na lista
				
				//boolean resposta = ControllerClientes.getInstance().Add(novoCliente);
				boolean resposta = ControllerClientes.getInstance().Add(novoCliente);
				System.out.println(ControllerClientes.getInstance().ListAll());
				

				if(resposta == true) {
				   JOptionPane.showMessageDialog(null,  novoCliente.toString() + "\nincluído com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,  novoCliente.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
				/* Limpar o JTexfield */
				textFieldNome.setText("");
				textFieldSobrenome.setText("");
				textFieldcpf.setText("");
				textFieldDataDeNascimento.setText("");
				textFieldRg.setText("");
				textFieldTelefone.setText("");
				textFieldSalario.setText("");
				
			}
		});
		btnNewButtonIncluir.setIcon(new ImageIcon(ClientesGUI.class.getResource("/img/add.png")));
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButtonCancelar.setIcon(new ImageIcon(ClientesGUI.class.getResource("/img/DeleteRed.png")));
		
		JLabel lblNewLabel_6 = new JLabel("CADASTRAMENTO DE CLIENTES");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(116)
					.addComponent(btnNewButtonIncluir, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(btnNewButtonCancelar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
						.addComponent(textFieldTelefone, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldcpf, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(193)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDataDeNascimento, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(2)
											.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldRg, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textFieldSobrenome, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))))
					.addGap(69))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldSobrenome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldcpf, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldDataDeNascimento, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldRg, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButtonIncluir, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButtonCancelar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnNewButtonIncluir, btnNewButtonCancelar});
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {textFieldNome, textFieldSobrenome, textFieldcpf, textFieldDataDeNascimento, textFieldRg, textFieldTelefone});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewButtonIncluir, btnNewButtonCancelar});
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Sal\u00E1rio");
		lblNewLabel_7.setBounds(51, 11, 92, 14);
		panel.add(lblNewLabel_7);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setBounds(51, 36, 211, 43);
		panel.add(textFieldSalario);
		textFieldSalario.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
}
