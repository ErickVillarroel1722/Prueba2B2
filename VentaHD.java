import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VentaHD {
    private JPanel Caja;
    private JPanel caja1;
    private JLabel Registro;
    private JTextField codtxt;
    private JTextField cedutxt;
    private JTextField nombretxt;
    private JTextField fechatxt;
    private JComboBox signoCB;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton actualizarboton;
    private JButton borrarboton;
    private JButton ingresarboton;
    private JButton cleanboton;
    static final String DB_URL="jdbc:mysql://localhost/registro";
    static final String USER="root";
    static final String PASS="12345";
    static final String QUERY_SELECT = "SELECT * from registro where id = 1";

    //Funcionalidad Botones//
    public VentaHD() {
        cleanboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Limpiar cajas//
                codtxt.setText(null);
                cedutxt.setText(null);
                nombretxt.setText(null);
                fechatxt.setText("");
                //Limpiar listas//
                signoCB.setSelectedIndex(0);
            }
        });
        actualizarboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement stnt = conn.createStatement();
                    ResultSet rs = stnt.executeQuery(QUERY_SELECT);

                    // Close the resources properly
                    rs.close();
                    stnt.close();
                    conn.close();
                } catch (SQLException a) {
                    throw new RuntimeException(a);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentaHD");
        frame.setContentPane(new VentaHD().Caja);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stnt = conn.createStatement();
            ResultSet rs = stnt.executeQuery(QUERY_SELECT);

            // Close the resources properly
            rs.close();
            stnt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    }

