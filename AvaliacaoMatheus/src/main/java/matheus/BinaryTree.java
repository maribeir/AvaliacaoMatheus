package main.java.matheus;

/**
 * Classe de �rvore Bin�ria.
 * 
 * @author Matheus
 * @version 1.0.0
 */
public class BinaryTree {
	
	int valor;
	BinaryTree left;
	BinaryTree right;
	
	public int calcularValorSubsequente(BinaryTree tree) {
		int retorno = 0;
		
		if (tree != null)
			retorno += calcularValorSubsequente(tree.left) + calcularValorSubsequente(tree.right);
		
		return retorno;
	}

}
