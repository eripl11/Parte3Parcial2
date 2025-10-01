import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FestivalDanza extends JFrame implements ActionListener {

    private JPanel panelSuperior;
    private JPanel panelCentral;
    private JPanel panelInferior;
    private JLabel etiqueta;

    private JButton botonDia1, botonDia2, botonDia3;

    private CardLayout cardLayout;

    public FestivalDanza() {
        setTitle("Festival de Danza");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        botonDia1 = new JButton("Día 1");
        botonDia2 = new JButton("Día 2");
        botonDia3 = new JButton("Día 3");

        botonDia1.setFont(new Font("Arial", Font.PLAIN, 14));
        botonDia2.setFont(new Font("Arial", Font.PLAIN, 14));
        botonDia3.setFont(new Font("Arial", Font.PLAIN, 14));

        botonDia1.addActionListener(this);
        botonDia2.addActionListener(this);
        botonDia3.addActionListener(this);

        panelSuperior.add(botonDia1);
        panelSuperior.add(botonDia2);
        panelSuperior.add(botonDia3);

        etiqueta = new JLabel("Pulsa sobre los botones para ver información del festival");
        etiqueta.setFont(new Font("Arial", Font.ITALIC, 14));
        panelSuperior.add(etiqueta);

        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);

        JPanel panel0 = new JPanel(new GridLayout(2, 1, 5, 5));
        panel0.setBackground(new Color(220, 235, 250)); // azul clarito
        JLabel infoGeneral = new JLabel("Festival de Danza - Lugar: Teatro Nacional - Fechas: 15, 16 y 17 de Octubre", JLabel.CENTER);
        infoGeneral.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel mensaje = new JLabel("Pulsa los botones para ver información del festival", JLabel.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 16));

        panel0.add(infoGeneral);
        panel0.add(mensaje);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(255, 220, 220));
        panel1.add(new JLabel("Día 1 - 15 de Octubre: Ballet clásico a las 18:00 hrs"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(220, 255, 220));
        panel2.add(new JLabel("Día 2 - 16 de Octubre: Danza contemporánea a las 19:00 hrs"));

        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(255, 255, 200));
        panel3.add(new JLabel("Día 3 - 17 de Octubre: Danzas folclóricas a las 20:00 hrs"));

        for (Component c : new Component[]{panel1.getComponent(0), panel2.getComponent(0), panel3.getComponent(0)}) {
            ((JLabel) c).setFont(new Font("Arial", Font.PLAIN, 15));
        }

        panelCentral.add(panel0, "0");
        panelCentral.add(panel1, "1");
        panelCentral.add(panel2, "2");
        panelCentral.add(panel3, "3");

        // PANEL INFERIOR
        panelInferior = new JPanel();
        JLabel pie = new JLabel("Información del Festival de Danza");
        pie.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInferior.add(pie);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        cardLayout.show(panelCentral, "0");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonDia1) {
            cardLayout.show(panelCentral, "1");
            etiqueta.setText("Día 1 - Horario: 18:00 hrs");
            botonDia1.setEnabled(false);
            botonDia2.setEnabled(true);
            botonDia3.setEnabled(true);
        } else if (e.getSource() == botonDia2) {
            cardLayout.show(panelCentral, "2");
            etiqueta.setText("Día 2 - Horario: 19:00 hrs");
            botonDia1.setEnabled(true);
            botonDia2.setEnabled(false);
            botonDia3.setEnabled(true);
        } else if (e.getSource() == botonDia3) {
            cardLayout.show(panelCentral, "3");
            etiqueta.setText("Día 3 - Horario: 20:00 hrs");
            botonDia1.setEnabled(true);
            botonDia2.setEnabled(true);
            botonDia3.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        FestivalDanza ventana = new FestivalDanza();
        ventana.setVisible(true);
    }
}





