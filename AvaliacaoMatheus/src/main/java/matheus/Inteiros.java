/**
 * 
 */
package main.java.matheus;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Aplicação que cria um número inteiro com base em outros 2 números informados.
 * 
 * @author Matheus
 * @version 1.0.0
 */
public class Inteiros extends JFrame {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel valorA;
	private JFormattedTextField textA;
	
	private JLabel valorB;
	private JFormattedTextField textB;
	
	private JTextField textResultado;
	 
	public Inteiros(){
	    this.create();
	} 
	 
	private void create(){
		JPanel campos = new JPanel();
		JPanel botao = new JPanel();
		JPanel resultado = new JPanel();
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		numberFormat.setGroupingUsed(false);

		valorA = new JLabel("Valor A:");
		textA = new JFormattedTextField(numberFormat);
		textA.setColumns(20);
		
		valorB = new JLabel("Valor B:");
		textB = new JFormattedTextField(numberFormat);
		textB.setColumns(20);
		
		textResultado = new JTextField(20);
		textResultado.setEditable(false);
		
		JButton botaoGerarC = new JButton("Gerar Valor C");
		Action action = new Action();
		botaoGerarC.addActionListener(action);
		
		campos.add(valorA);
		campos.add(textA);
		campos.add(valorB);
		campos.add(textB);
		botao.add(botaoGerarC);
		resultado.add(textResultado);
		
		this.setTitle("Inteiros");
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);

	    this.getContentPane().add(campos, BorderLayout.NORTH);
	    this.getContentPane().add(botao);
	    this.getContentPane().add(resultado, BorderLayout.SOUTH);
	}
	
	private class Action implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String[] campoA = textA.getText().split("");
			String[] campoB = textB.getText().split("");
			int qtde = 0;
			String texto = "";
			
			// verifica menor quantidade de caracteres
			if (campoA.length > campoB.length)
			    qtde = campoB.length;
			else
				qtde = campoA.length;

			// processa os campos A e B
			for (int i = 0; i < qtde; i++)
				texto += campoA[i] + campoB[i];

			// preenche o resto do texto de resultado com o restante da string com mais caracteres
			if (campoA.length > campoB.length)			    
				 for (int x = campoB.length; x < campoA.length; x++)
					 texto += campoA[x];
			else if (campoB.length > campoA.length)			    
			     for (int x = campoA.length; x < campoB.length; x++)
				     texto += campoB[x];

			// caso resultado seja maior que 1.000.000, retorna -1
			if (Integer.parseInt(texto) > 1000000)
				texto = "-1";
			
			textResultado.setText(texto);
		}
	}

}
