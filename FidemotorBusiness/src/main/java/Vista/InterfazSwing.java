/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import com.mycompany.fidemotorbusiness.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Venta PC
 */
public class InterfazSwing {

    Menu menu;
    JFrame frame;

    JPanel inicio;
    JButton addV;
    JButton inv;
    JButton com;

    JPanel agregarV;
    JTextField txtMarca;
    JLabel marca;
    JTextField modelo;
    JLabel modeloLabel;
    JTextField año;
    JLabel añoLabel;
    JTextField precio;
    JLabel precioLabel;
    JTextField tipo;
    JLabel tipoLabel;
    JButton anadir;
    JButton volverV;

    JPanel inventario;
    JButton aceptarEditar;
    JButton remover;
    JButton volverInv;
    JButton SigInv;
    JButton antInv;
    JTextField editarMarca;
    JTextField editarModelo;
    JTextField editarAño;
    JTextField editarPrecio;

    JPanel compras;
    JLabel estadoLbl;
    JLabel userInfoLbl;
    JLabel vehiInfoLbl;
    JButton enviado;
    JButton recibido;
    JButton Procesado;
    JButton ListoEntrega;
    JButton volverC;
    JButton SigC;
    JButton antC;

    public InterfazSwing() {
        menu = new Menu();
        frame = new JFrame("FideMotorBusiness");
        frame.setSize(1000, 600);
        frame.setResizable(false);

        inicio = new JPanel();
        addV = new JButton("Agregar vehiculo");
        addV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(inicio);
                frame.add(agregarV);
                frame.setVisible(true);
            }
        });
        inv = new JButton("Inventario");
        inv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(inicio);
                menu.actualizarInventario();
                actInv();
                frame.add(inventario);
                frame.setVisible(true);
            }
        });
        com = new JButton("Compras");
        com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(inicio);
                menu.actualizarInventario();
                menu.actualizarCompras();
                menu.actualizarUsers();
                actCom();
                frame.add(compras);
                frame.setVisible(true);
            }
        });

        addV.setBounds(100, 450, 200, 100);
        inv.setBounds(400, 450, 200, 100);
        com.setBounds(700, 450, 200, 100);

        inicio.setLayout(null);
        inicio.add(addV);
        inicio.add(inv);
        inicio.add(com);

        agregarV = new JPanel();
        anadir = new JButton("Aceptar");
        volverV = new JButton("Volver");
        txtMarca = new JTextField();
        marca = new JLabel("Marca:");
        modelo = new JTextField();
        modeloLabel = new JLabel("Modelo:");
        año = new JTextField();
        añoLabel = new JLabel("Año:");
        precio = new JTextField();
        precioLabel = new JLabel("Precio:");
        tipo = new JTextField();
        tipoLabel = new JLabel("1.Automovil 2.Motocicleta 3.Camion");

        anadir.setBounds(400, 450, 200, 100);
        anadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.anadirVehiculo(tipo.getText()+"#"+txtMarca.getText()+"#"+año.getText()+"#"+modelo.getText()+"#"+precio.getText());
            }
        });
        volverV.setBounds(50, 50, 200, 100);
        volverV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(agregarV);

                frame.add(inicio);
                frame.setVisible(true);
            }
        });
        marca.setBounds(300, 100, 50, 50);
        txtMarca.setBounds(300, 150, 200, 30);
        modeloLabel.setBounds(300, 180, 50, 50);
        modelo.setBounds(300, 230, 200, 30);
        añoLabel.setBounds(300, 260, 50, 50);
        año.setBounds(300, 310, 200, 30);
        precioLabel.setBounds(300, 340, 50, 50);
        precio.setBounds(300, 390, 200, 30);
        tipoLabel.setBounds(550, 100, 300, 50);
        tipo.setBounds(550, 150, 200, 30);

        agregarV.setLayout(null);
        agregarV.add(anadir);
        agregarV.add(volverV);
        agregarV.add(marca);
        agregarV.add(txtMarca);
        agregarV.add(modeloLabel);
        agregarV.add(modelo);
        agregarV.add(año);
        agregarV.add(añoLabel);
        agregarV.add(precioLabel);
        agregarV.add(precio);
        agregarV.add(tipo);
        agregarV.add(tipoLabel);

        inventario = new JPanel();
        volverInv = new JButton("Volver");
        volverInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(inventario);

                frame.add(inicio);
                frame.setVisible(true);
            }
        });
        aceptarEditar = new JButton("Editar");
        remover = new JButton("Eliminar");
        SigInv = new JButton("Siguiente");
        antInv = new JButton("Anterior");
        editarMarca = new JTextField();
        editarModelo = new JTextField();
        editarAño = new JTextField();
        editarPrecio = new JTextField();

        volverInv.setBounds(50, 50, 200, 100);
        aceptarEditar.setBounds(400, 450, 200, 100);
        aceptarEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.editarVehiculo(editarMarca.getText()+"#"+editarAño.getText()+"#"+editarModelo.getText()+"#"+editarPrecio.getText());
                menu.actualizarInventario();
                actInv();
            }
        });
        remover.setBounds(400, 350, 200, 100);
        remover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.eliminarVehiculo();
                menu.actualizarInventario();
                actInv();
            }
        });
        antInv.setBounds(200, 450, 200, 100);
        antInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.cambiarCurrentInv(true);
                actInv();
            }
        });
        SigInv.setBounds(600, 450, 200, 100);
        SigInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.cambiarCurrentInv(false);
                actInv();
            }
        });
        editarMarca.setBounds(400, 50, 200, 30);
        editarModelo.setBounds(400, 100, 200, 30);
        editarAño.setBounds(400, 150, 200, 30);
        editarPrecio.setBounds(400, 200, 200, 30);

        inventario.setLayout(null);
        inventario.add(aceptarEditar);
        inventario.add(remover);
        inventario.add(volverInv);
        inventario.add(SigInv);
        inventario.add(antInv);
        inventario.add(editarMarca);
        inventario.add(editarModelo);
        inventario.add(editarAño);
        inventario.add(editarPrecio);

        compras = new JPanel();
        compras.setLayout(null);
        estadoLbl = new JLabel("Estado");
        userInfoLbl = new JLabel("Usuario");
        vehiInfoLbl = new JLabel("Vehiculo");
        enviado = new JButton("Enviado");
        recibido = new JButton("Aceptado");
        Procesado = new JButton("Procesado");
        ListoEntrega = new JButton("Listo para entrega");
        volverC = new JButton("Volver");
        volverC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.remove(compras);

                frame.add(inicio);
                frame.setVisible(true);
            }
        });
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

        enviado.setBounds(100, 450, 200, 100);
        enviado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menu.editarCompra("1")){
                    menu.actualizarCompras();
                    actCom();
                }
                
            }
        });
        recibido.setBounds(300, 450, 200, 100);
        recibido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menu.editarCompra("2")){
                    menu.actualizarCompras();
                    actCom();
                }
                
            }
        });
        Procesado.setBounds(500, 450, 200, 100);
        Procesado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(menu.editarCompra("3")){
                    menu.actualizarCompras();
                    actCom();
               }
                
            }
        });
        ListoEntrega.setBounds(700, 450, 200, 100);
        ListoEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menu.editarCompra("4")){
                    menu.actualizarCompras();
                    actCom();
                }
                
            }
        });
        estadoLbl.setBounds(400, 300, 300, 50);
        userInfoLbl.setBounds(400, 250, 300, 50);
        vehiInfoLbl.setBounds(400, 200, 300, 50);
        volverC.setBounds(50, 50, 200, 100);
        SigC.setBounds(700, 250, 200, 100);
        antC.setBounds(100, 250, 200, 100);

        compras.add(estadoLbl);
        compras.add(vehiInfoLbl);
        compras.add(enviado);
        compras.add(recibido);
        compras.add(Procesado);
        compras.add(ListoEntrega);
        compras.add(userInfoLbl);
        compras.add(volverC);
        compras.add(SigC);
        compras.add(antC);

        frame.add(inicio);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }
    
    public void actInv(){
        editarMarca.setText(menu.getCurrent().getMarca());
        editarAño.setText(menu.getCurrent().getAno());
        editarModelo.setText(menu.getCurrent().getModelo());
        editarPrecio.setText(menu.getCurrent().getPrecio());
    }
    
    public void actCom(){
        userInfoLbl.setText(menu.getUserInfoC());
        vehiInfoLbl.setText(menu.getVehicleInfoC());
        estadoLbl.setText(menu.getEstado());
    }
    
}
