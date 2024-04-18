package Vista;

import ModeloController.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class View {

    Menu menu = new Menu();
    //frame
    JFrame frame;
    //Misc
    JButton volver;
    JButton volver2;
    JButton volver3;
    //login-register
    JPanel inicio;
    JButton login;
    JButton registrarse;
    //LoginScreen
    JPanel loginScreen;
    JTextField userTxT;
    JTextField passTxT;
    JButton acceptLog;
    //mainScreen
    JPanel mainScreen;
    JButton infoBtn;
    JButton comprarBtn;
    JButton verComprasBTN;
    JButton cerrarSesion;
    //infOScreen
    JPanel infoScreen;
    JButton aceptarInfo;
    JTextField nombreInfoTxt;
    JTextField apellidosInfoTxt;
    JTextField telefonoInfoTxt;
    JTextField direccionInfoTxt;
    //buyScreen
    JPanel buyScreen;
    JLabel tipoLbl;
    JLabel marcaLbl;
    JLabel anoLbl;
    JLabel modeloLbl;
    JLabel precioLbl;
    JButton compraBtn;
    JButton antComprar;
    JButton sigComprar;
    //historyScreen
    JPanel historyScreen;
    
    JPanel compras;
    JLabel estadoLbl;
    JLabel userInfoLbl;
    JLabel vehiInfoLbl;
    JButton SigC;
    JButton antC;

    public View() {
        //frame settings
        frame = new JFrame("FideMotorApp");

        //misc
        volver = new JButton("Volver");
        volver2 = new JButton("Volver");
        volver3 = new JButton("Volver");
        //login-register
        inicio = new JPanel();

        login = new JButton("LOGIN");
        registrarse = new JButton("REGISTRARSE");

        //login screen
        loginScreen = new JPanel();

        userTxT = new JTextField();
        passTxT = new JTextField();
        acceptLog = new JButton("Aceptar");

        //mainScreen
        mainScreen = new JPanel();
        infoBtn = new JButton("Mis datos");
        comprarBtn = new JButton("Comprar");
        verComprasBTN = new JButton("Ver Compras");
        cerrarSesion = new JButton("Cerrar Sesion");

        //infOScreen
        infoScreen = new JPanel();

        aceptarInfo = new JButton("Aceptar");
        nombreInfoTxt = new JTextField();
        apellidosInfoTxt = new JTextField();
        telefonoInfoTxt = new JTextField();
        direccionInfoTxt = new JTextField();

        //buyScreen
        buyScreen = new JPanel();

        tipoLbl = new JLabel("tipo");
        marcaLbl = new JLabel("marca");
        anoLbl = new JLabel("año");
        modeloLbl = new JLabel("modelo");
        precioLbl = new JLabel("precio");
        compraBtn = new JButton("Comprar");
        antComprar = new JButton("anterior");
        sigComprar = new JButton("Siguiente");

        //historyScreen
        historyScreen = new JPanel();

    }

    public void start() {

        //frame settings
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);

        //misc
        volver.setBounds(0, 20, 200, 100);
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(infoScreen);
                frame.add(mainScreen);
                frame.setVisible(true);
            }
        });
        volver2.setBounds(0, 20, 200, 100);
        volver2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(buyScreen);
                frame.add(mainScreen);
                frame.setVisible(true);
            }
        });
        volver3.setBounds(0, 20, 200, 100);
        volver3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(historyScreen);
                frame.add(mainScreen);
                frame.setVisible(true);
            }
        });
        //login-register
        inicio.setLayout(null);

        login.setBounds(450, 250, 100, 50);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(inicio);
                frame.add(loginScreen);
                frame.setVisible(true);
            }
        });
        registrarse.setBounds(450, 350, 100, 50);

        inicio.add(login);
        inicio.add(registrarse);

        //loginScreen
        loginScreen.setLayout(null);

        userTxT.setBounds(350, 200, 300, 30);
        passTxT.setBounds(350, 300, 300, 30);
        acceptLog.setBounds(350, 400, 300, 30);
        acceptLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.initUserLogin(userTxT.getText()+"#"+passTxT.getText());
                frame.setVisible(false);
                frame.remove(loginScreen);
                frame.add(mainScreen);
                frame.setVisible(true);
            }
        });

        loginScreen.add(userTxT);
        loginScreen.add(passTxT);
        loginScreen.add(acceptLog);

        //mainScreen
        mainScreen.setLayout(null);

        infoBtn.setBounds(100, 200, 200, 100);
        infoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(mainScreen);
                frame.add(infoScreen);
                frame.setVisible(true);
            }
        });
        comprarBtn.setBounds(250, 450, 200, 100);
        
        
        comprarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.actualizarInventario();
                frame.setVisible(false);
                frame.remove(mainScreen);
                frame.add(buyScreen);
                frame.setVisible(true);
            }
        });
        verComprasBTN.setBounds(400, 200, 200, 100);
        verComprasBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.actualizarCompras();
                frame.setVisible(false);
                frame.remove(mainScreen);
                frame.add(historyScreen);
                frame.setVisible(true);
            }
        });
        cerrarSesion.setBounds(550, 450, 200, 100);
        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(mainScreen);
                frame.add(inicio);
                frame.setVisible(true);
            }
        });
        cerrarSesion.setBackground(Color.red);

        mainScreen.add(infoBtn);
        mainScreen.add(comprarBtn);
        mainScreen.add(verComprasBTN);
        mainScreen.add(cerrarSesion);

        //infOScreen
        infoScreen.setLayout(null);

        aceptarInfo.setBounds(450, 450, 200, 100);
        nombreInfoTxt.setBounds(400, 100, 200, 30);
        apellidosInfoTxt.setBounds(400, 150, 200, 30);
        telefonoInfoTxt.setBounds(400, 200, 200, 30);
        direccionInfoTxt.setBounds(400, 250, 200, 30);

        infoScreen.add(volver);
        infoScreen.add(aceptarInfo);
        infoScreen.add(nombreInfoTxt);
        infoScreen.add(apellidosInfoTxt);
        infoScreen.add(telefonoInfoTxt);
        infoScreen.add(direccionInfoTxt);

        //buyScreen
        buyScreen.setLayout(null);

        tipoLbl.setBounds(300, 100, 300, 30);
        marcaLbl.setBounds(300, 150, 300, 30);
        anoLbl.setBounds(300, 200, 300, 30);
        modeloLbl.setBounds(300, 250, 300, 30);
        precioLbl.setBounds(300, 300, 300, 30);
        compraBtn.setBounds(300, 350, 100, 50);
        compraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.comprarVehiculo();
                actVehi();
            }
        });
        antComprar.setBounds(0, 350, 100, 50);
        antComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.cambiarCurrentInv(true);
                actVehi();
                
            }
        });
        sigComprar.setBounds(500, 350, 100, 50);
        sigComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.cambiarCurrentInv(false);
                actCom();
            }
        });

        buyScreen.add(volver2);
        buyScreen.add(tipoLbl);
        buyScreen.add(marcaLbl);
        buyScreen.add(anoLbl);
        buyScreen.add(modeloLbl);
        buyScreen.add(precioLbl);
        buyScreen.add(compraBtn);
        buyScreen.add(antComprar);
        buyScreen.add(sigComprar);

        //historyScreen
        historyScreen.setLayout(null);
        
        
        
        estadoLbl = new JLabel("Estado");
        userInfoLbl = new JLabel("Usuario");
        vehiInfoLbl = new JLabel("Vehiculo");
        SigC = new JButton("Siguiente");
        SigC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.cambiarCurrentCom(false);
                actCom();
            }
        });
        antC = new JButton("Anterior");
        antC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.cambiarCurrentCom(true);
                actCom();
            }
        });

        estadoLbl.setBounds(400, 300, 300, 50);
        userInfoLbl.setBounds(400, 250, 300, 50);
        vehiInfoLbl.setBounds(400, 200, 300, 50);
        SigC.setBounds(700, 250, 200, 100);
        antC.setBounds(100, 250, 200, 100);

        historyScreen.add(estadoLbl);
        historyScreen.add(vehiInfoLbl);
        historyScreen.add(userInfoLbl);
        historyScreen.add(SigC);
        historyScreen.add(antC);
        
        
        

        historyScreen.add(volver3);

        //add to frame
        frame.add(inicio);
        frame.setVisible(true);

    }

    public void actInfo() {

    }
    
    public void actVehi(){
        tipoLbl.setText(menu.getCurrent().getTipo());
        marcaLbl.setText(menu.getCurrent().getMarca());
        anoLbl.setText(menu.getCurrent().getAno());
        modeloLbl.setText(menu.getCurrent().getModelo());
    }
    
    public void actCom(){
        userInfoLbl.setText(menu.getUserInfoC());
        vehiInfoLbl.setText(menu.getVehicleInfoC());
        estadoLbl.setText(menu.getEstado());
    }

}
