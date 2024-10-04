import javax.swing.*;
import java.awt.*;

public class ArvoreMorseGUI extends JPanel {
    private ArvoreMorse arvoreMorse;

    public ArvoreMorseGUI(ArvoreMorse arvoreMorse) {
        this.arvoreMorse = arvoreMorse;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharArvore(g, arvoreMorse.getRaiz(), getWidth() / 2, 50, getWidth() / 4, 60);
    }

    private void desenharArvore(Graphics g, No nodo, int x, int y, int offset, int nivelAltura) {
        if (nodo == null) return;

        // Desenha o círculo e a letra/número dentro
        g.setColor(Color.LIGHT_GRAY);  // Cor do círculo
        g.fillOval(x - 20, y - 20, 40, 40);  // Círculo com raio 40px
        g.setColor(Color.BLACK);
        g.drawOval(x - 20, y - 20, 40, 40);  // Desenho da borda do círculo

        // Desenha o valor dentro do círculo
        g.drawString(nodo.valor, x - 5, y + 5);  // Centraliza o texto dentro do círculo

        // Desenho das linhas retas para os filhos (|-|)
        if (nodo.esquerda != null) {
            g.drawLine(x, y, x - offset, y + nivelAltura);  // Linha reta para a esquerda
            desenharArvore(g, nodo.esquerda, x - offset, y + nivelAltura, offset / 2, nivelAltura);  // Recursão para o filho esquerdo
        }
        if (nodo.direita != null) {
            g.drawLine(x, y, x + offset, y + nivelAltura);  // Linha reta para a direita
            desenharArvore(g, nodo.direita, x + offset, y + nivelAltura, offset / 2, nivelAltura);  // Recursão para o filho direito
        }
    }
}
