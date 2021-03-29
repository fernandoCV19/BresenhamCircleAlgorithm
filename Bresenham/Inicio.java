import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Inicio
{
    private JTextField coorXValor;
    private JTextField coorYValor;
    private JTextField radioValor;

    public static void main(){
        Inicio aux = new Inicio();
    }
    
    private Inicio(){
        menuInicio();
    }

    private void menuInicio(){
        JFrame ventana = new JFrame("Valores");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.WHITE);
        ventana.setSize(580, 360);
        ventana.setVisible(true);

        iniciarVentana(ventana);
    }

    private void iniciarVentana(JFrame ventana){
        JPanel fondo = new JPanel();
        fondo.setLayout(null);
        ventana.getContentPane().add(fondo);

        Font fuente = new Font("arial", 1, 15);
        JLabel coorX = new JLabel("Ingrese coordenada en X");
        coorX.setBounds(20, 10, 300, 40);
        coorX.setFont(fuente);
        fondo.add(coorX);

        coorXValor = new JTextField();
        coorXValor.setBounds(20, 60, 300, 40);
        fondo.add(coorXValor);

        JLabel coorY = new JLabel("Ingrese coordenada en Y");
        coorY.setBounds(20, 110, 300, 40);
        coorY.setFont(fuente);
        fondo.add(coorY);

        coorYValor = new JTextField();
        coorYValor.setBounds(20, 160, 300, 40);
        fondo.add(coorYValor);

        JLabel radio = new JLabel("Ingrese radio");
        radio.setBounds(20, 210, 300, 40);
        radio.setFont(fuente);
        fondo.add(radio);

        radioValor = new JTextField();
        radioValor.setBounds(20, 260, 300, 40);
        fondo.add(radioValor);

        JButton pintar = new JButton("Pintar");
        pintar.setBounds(350, 130, 200, 100);
        pintar.setFont(fuente);
        ActionListener accion = new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    boolean sePudo = true;

                    String x = "";
                    for(int i = 0; i < coorXValor.getText().length(); i++){
                        char aux = coorXValor.getText().charAt(i);
                        if(Character.isDigit(aux)){
                            x+=aux;   
                        }else{
                            sePudo = false;
                            break;
                        }
                    }

                    if(sePudo){
                        String y = "";
                        for(int i = 0; i < coorYValor.getText().length(); i++){
                            char aux = coorYValor.getText().charAt(i);
                            if(Character.isDigit(aux)){
                                y+=aux;   
                            }else{
                                sePudo = false;
                                break;
                            }
                        }

                        if(sePudo){
                            String radio = "";
                            for(int i = 0; i < radioValor.getText().length(); i++){
                                char aux = radioValor.getText().charAt(i);
                                if(Character.isDigit(aux)){
                                    radio+=aux;   
                                }else{
                                    sePudo = false;
                                    break;
                                }
                            }

                            if(sePudo){
                                pintarCirculo(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(radio));
                            }
                        }
                    }
                }
            };
        pintar.addActionListener(accion);
        fondo.add(pintar);

        fondo.repaint();
    }

    private void pintarCirculo(int x, int y, int r){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Algoritmo");
        ventana.setBackground(Color.WHITE);
        ventana.setSize(1000,800);

        Bresenham panel = new Bresenham(x, y, r);
        ventana.setVisible(true);

        ventana.add(panel);

        ventana.setVisible(true);
    }
}
