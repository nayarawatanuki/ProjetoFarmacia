package br.edu.ifsp.bra.farmacia;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.modelo.Cliente;
import br.edu.ifsp.bra.modelo.Dinheiro;
import br.edu.ifsp.bra.modelo.Pagamento.TipoPagamento;
import br.edu.ifsp.bra.modelo.Pedido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FrmCaixa2 {

	JFrame frame;
	JPanel panel;
	JLabel lblTextVlrCaixa;
	JLabel lblVlrCaixa;
	JButton btnExibirVlrCaixa;
	JLabel lblTextTotalCompra;
	JLabel lblTotalCompra;
	JButton btnPagamento;	
	JButton btnNovoPedido;
	JLabel lblCliente;
	JLabel lblTextCliente;
	
	
	private JButton btnDefinirCliente;
	private JLabel lblRecebido;
	private JTextField txtVlrPago;
	
	public FrmCaixa2()
	{
		frame = new JFrame();
		frame.setSize(455, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTextVlrCaixa = new JLabel("");
		lblTextVlrCaixa.setBounds(255, 223, 121, 14);
		panel.add(lblTextVlrCaixa);
		
		lblVlrCaixa = new JLabel("");
		lblVlrCaixa.setBounds(386, 223, 48, 14);
		panel.add(lblVlrCaixa);
		
		btnExibirVlrCaixa = new JButton("Exibir valor em caixa");
		btnExibirVlrCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblTextVlrCaixa.getText().equals(""))
				{
					lblVlrCaixa.setText("0.00");
					lblTextVlrCaixa.setText("Valor em Caixa");
				}
				else
				{
					lblVlrCaixa.setText("");
					lblTextVlrCaixa.setText("");
				}
			}
		});
		btnExibirVlrCaixa.setBounds(255, 238, 179, 23);
		panel.add(btnExibirVlrCaixa);
		
		lblTextTotalCompra = new JLabel("Total");
		lblTextTotalCompra.setBounds(10, 9, 60, 14);
		panel.add(lblTextTotalCompra);
		
		lblTotalCompra = new JLabel("0.00");
		lblTotalCompra.setBounds(123, 9, 60, 14);
		panel.add(lblTotalCompra);
		
		btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Pedido.getPedidoAtual() != null)
				{
					int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opcao", "Pagamento", 0, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Dinheiro", "Cartao"}, "Dinheiro");
					if(escolha == 0)
					{
						Dinheiro pagDinheiro = new Dinheiro(Cliente.getClienteAtual().getId(), Pedido.getPedidoAtual().getId(), Pedido.getPedidoAtual().getTotal(), TipoPagamento.DINHEIRO, Double.parseDouble(txtVlrPago.getText()));
						CaixaFacade facade = new CaixaFacade();
						facade.realizaPagamento(pagDinheiro);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Não existe pedido para ser pago");
				}
			}
		});
		btnPagamento.setBounds(123, 238, 112, 23);
		panel.add(btnPagamento);
		
		btnNovoPedido = new JButton("Novo Pedido");
		btnNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmVendas vendas = new FrmVendas();
				frame.dispose();
			}
		});
		btnNovoPedido.setBounds(0, 238, 112, 23);
		panel.add(btnNovoPedido);
		
		btnDefinirCliente = new JButton("Definir Cliente");
		btnDefinirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes cliente = new Clientes();
				frame.dispose();
				
			}
		});
		btnDefinirCliente.setBounds(0, 214, 112, 23);
		panel.add(btnDefinirCliente);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(240, 9, 48, 14);
		panel.add(lblCliente);
		if(Cliente.getClienteAtual() == null)
		{
			lblTextCliente = new JLabel("Nulo");
		}
		else
		{
			lblTextCliente = new JLabel(Cliente.getClienteAtual().getNome());
		}
		lblTextCliente.setBounds(316, 9, 48, 14);
		panel.add(lblTextCliente);
		
		lblRecebido = new JLabel("Recebido");
		lblRecebido.setBounds(10, 34, 48, 14);
		panel.add(lblRecebido);
		
		txtVlrPago = new JTextField();
		txtVlrPago.setBounds(87, 34, 96, 20);
		panel.add(txtVlrPago);
		txtVlrPago.setColumns(10);
		
		frame.setVisible(true);
		
	}
}
