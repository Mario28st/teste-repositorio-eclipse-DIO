package br.edu.ifsuldeminas.view.update;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import br.edu.ifsuldeminas.controller.ControllerClientes;
import br.edu.ifsuldeminas.modelo.Clientes;
import br.edu.ifsuldeminas.view.ClientesMessage;
import br.edu.ifsuldeminas.view.SearchClientesGUI;
import br.edu.ifsuldeminas.view.SearchMessageListener;

public class FilterUpdateClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JButton btnPesquisa;
	private JButton btnOK;
	private JButton btnCancelar;

	/* minhas variaveis */
	private Clientes cliente = null;
	private List<Clientes> listClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterUpdateClientes frame = new FilterUpdateClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FilterUpdateClientes() {
		setResizable(false);
		setTitle("Filtro para alteração");
		setBounds(100, 100, 450, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecione  o Id para altera\u00E7\u00E3o");
		lblNewLabel.setBounds(10, 11, 406, 14);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 44, 413, 148);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Id para alterar");
		lblNewLabel_2.setBounds(25, 85, 164, 14);
		panel.add(lblNewLabel_2);

		textFieldId = new JTextField();
		textFieldId.addCaretListener(new CaretListener() { 
			public void caretUpdate(CaretEvent e) {
				if(textFieldId.getText().length() > 0) {
					btnOK.setEnabled(true);
				} else {
					btnOK.setEnabled(false);
				}
			}
		});
		textFieldId.setEnabled(false);
		textFieldId.setBounds(25, 108, 224, 27);
		panel.add(textFieldId);
		textFieldId.setColumns(10);

		btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				listClientes =  ControllerClientes.getInstance().ListAll();

				/* cria o interface de procura e registro o listener para enviar a lista */

				MySearchMessage mySearchMessage = new MySearchMessage();
				SearchClientesGUI search = new SearchClientesGUI();
				search.addSearchListener(mySearchMessage);
				search.updateTable();
				search.setLocationRelativeTo(null);
				search.setVisible(true);

			}

		});
		btnPesquisa.setEnabled(true);
		btnPesquisa.setBounds(259, 108, 126, 27);
		panel.add(btnPesquisa);

		btnOK = new JButton("Prosseguir");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textFieldId.getText());

					/* Procurar no banco se o Id informado existe */
					Clientes resposta = (Clientes) ControllerClientes.getInstance().getClientes(id);

					if(resposta == null) {
						JOptionPane.showMessageDialog(null, "Id n�o localizado","Problema",JOptionPane.WARNING_MESSAGE);
						return;
					}

					cliente = resposta; //depois

					dispose();

					ClientesUpdateGUI gui = new ClientesUpdateGUI();

					MyClientesMessage my = new MyClientesMessage();

					gui.addClientesMessage(my);
					gui.updateGUI();

					gui.setLocationRelativeTo(null);
					gui.setVisible(true);


				
			}
		});
		btnOK.setEnabled(false);
		btnOK.setBounds(167, 203, 127, 34);
		contentPane.add(btnOK);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(315, 203, 108, 34);
		contentPane.add(btnCancelar);
	}

	private class MyClientesMessage implements ClientesMessage {

		@Override
		public Clientes receiveClientes() {
			return cliente;
		}

	}


	private class MySearchMessage implements SearchMessageListener {

		@Override
		public List<Clientes> receiveList() {
			return listClientes;
		}

		@Override
		public void sendIdentifier(int id) {
			String identifier = String.valueOf(id);
			textFieldId.setText(identifier);			
		}

	}


}


