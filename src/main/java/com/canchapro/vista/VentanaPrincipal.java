
package com.canchapro.vista;
import com.canchapro.modelo.Cliente;
import com.canchapro.modelo.RegistroDeClientes;
import com.canchapro.modelo.ArchivoClientes;
import javax.swing.JOptionPane;
import com.canchapro.modelo.RegistroDeCanchas;
import com.canchapro.modelo.Cancha;


public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    
            
            private RegistroDeClientes registro = new RegistroDeClientes();
            private ArchivoClientes archivoClientes = new ArchivoClientes();
            private RegistroDeCanchas registroCanchas = new RegistroDeCanchas();
            
    public VentanaPrincipal() {
        initComponents();
        
        registroCanchas.cargarCanchas();

        javax.swing.table.DefaultTableModel modelo =
        (javax.swing.table.DefaultTableModel) tblCanchas.getModel();

        modelo.setRowCount(0);

        for (int i = 0; i < registroCanchas.getCantidad(); i++) {

        Cancha cancha = registroCanchas.getCancha(i);

        modelo.addRow(new Object[]{
        false,
        cancha.getCodigo(),
        cancha.getNombre(),
        cancha.getPrecio(),
        cancha.getEstado()
    });
}
        
        PanelClientes.setVisible(true);
        PanelCanchas.setVisible(false);
        
        archivoClientes.cargarClientes(registro);
            System.out.println("Clientes recuperados: " + registro.getCantidad());
            registro.listarClientes();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new javax.swing.JPanel();
        btnReservaciones = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnCanchas = new javax.swing.JButton();
        btnTienda = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        PanelCanchas = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoCancha = new javax.swing.JLabel();
        txtNombreCancha = new javax.swing.JLabel();
        txtPrecioCancha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCanchas = new javax.swing.JTable();
        btnAgregarCancha = new javax.swing.JButton();
        txtIngresarCodigoCancha = new javax.swing.JTextField();
        txtIngresarNombreCancha = new javax.swing.JTextField();
        txtIngresarPrecioCancha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbTipoCancha = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCapacidadCancha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHoraApertura = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHoraCierre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmbEstadoCancha = new javax.swing.JComboBox<>();
        btnAplicarEstado = new javax.swing.JButton();
        PanelClientes = new javax.swing.JPanel();
        jblContenido = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaCliente = new javax.swing.JTextField();
        btnGuardarCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        lblEstadoBusqueda = new javax.swing.JLabel();
        lblNombreEncontrado = new javax.swing.JLabel();
        lblCodigoEncontrado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CanchaPro - Sistema de Reservaciones");
        setName("ventanaPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(750, 500));

        btnReservaciones.setText("Reservaciones");
        btnReservaciones.addActionListener(this::btnReservacionesActionPerformed);

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(this::btnClientesActionPerformed);

        btnPagos.setText("Pagos");
        btnPagos.addActionListener(this::btnPagosActionPerformed);

        btnCanchas.setText("Canchas");
        btnCanchas.addActionListener(this::btnCanchasActionPerformed);

        btnTienda.setText("Tienda");
        btnTienda.addActionListener(this::btnTiendaActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("GESTIÓN DE CANCHAS");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCodigoCancha.setText("Código de cancha");

        txtNombreCancha.setText("Nombre de cancha");

        txtPrecioCancha.setText("Precio por hora");

        tblCanchas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seleccionar", "Codigo", "Nombre de cancha", "Precio por hora", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCanchas);

        btnAgregarCancha.setText("Agregar Canchas");
        btnAgregarCancha.addActionListener(this::btnAgregarCanchaActionPerformed);

        jLabel10.setText("Tipo de cancha");

        cmbTipoCancha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Futbol 5", "Futbol 7", "Futbol 11" }));
        cmbTipoCancha.addActionListener(this::cmbTipoCanchaActionPerformed);

        jLabel11.setText("Capacidad");

        txtCapacidadCancha.addActionListener(this::txtCapacidadCanchaActionPerformed);

        jLabel12.setText("Hora de apertura");

        jLabel13.setText("Hora de cierre");

        jLabel14.setText("Cambiar Estado de Cancha");

        cmbEstadoCancha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Mnatenimiento", "Inactiva" }));
        cmbEstadoCancha.addActionListener(this::cmbEstadoCanchaActionPerformed);

        btnAplicarEstado.setText("Aplicar Estado");
        btnAplicarEstado.addActionListener(this::btnAplicarEstadoActionPerformed);

        javax.swing.GroupLayout PanelCanchasLayout = new javax.swing.GroupLayout(PanelCanchas);
        PanelCanchas.setLayout(PanelCanchasLayout);
        PanelCanchasLayout.setHorizontalGroup(
            PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCanchasLayout.createSequentialGroup()
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCanchasLayout.createSequentialGroup()
                        .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelCanchasLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIngresarCodigoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCanchasLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCapacidadCancha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)))
                        .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIngresarNombreCancha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(77, 77, 77)
                        .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtPrecioCancha)
                            .addComponent(txtIngresarPrecioCancha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarCancha)))
                    .addGroup(PanelCanchasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(PanelCanchasLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigoCancha)
                            .addComponent(cmbTipoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCanchasLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(txtNombreCancha))
                            .addGroup(PanelCanchasLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(txtHoraApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelCanchasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelCanchasLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(cmbEstadoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel14)
                                .addComponent(btnAplicarEstado)))))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        PanelCanchasLayout.setVerticalGroup(
            PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCanchasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoCancha)
                    .addComponent(txtNombreCancha)
                    .addComponent(txtPrecioCancha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIngresarCodigoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresarNombreCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresarPrecioCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapacidadCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCancha))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEstadoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAplicarEstado)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCanchas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(PanelCanchas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnReservaciones)
                        .addGap(27, 27, 27)
                        .addComponent(btnClientes)
                        .addGap(29, 29, 29)
                        .addComponent(btnPagos)
                        .addGap(28, 28, 28)
                        .addComponent(btnCanchas)
                        .addGap(26, 26, 26)
                        .addComponent(btnTienda)
                        .addGap(27, 27, 27)
                        .addComponent(btnSalir))
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelCanchas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(498, Short.MAX_VALUE))
        );

        jblContenido.setText("Bienvenido a Cancha Pro");

        txtNombreCliente.addActionListener(this::txtNombreClienteActionPerformed);

        jLabel2.setText("Nombre completo");

        jLabel3.setText("Codigo del cliente");

        txtCodigoCliente.addActionListener(this::txtCodigoClienteActionPerformed);

        jLabel4.setText("Telefono");

        jLabel5.setText("Correo Electronico");

        jLabel6.setText("Fecha");

        txtFechaCliente.addActionListener(this::txtFechaClienteActionPerformed);

        btnGuardarCliente.setText("Guardar Cliente");
        btnGuardarCliente.addActionListener(this::btnGuardarClienteActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Buscar Cliente Registrado");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtBuscarTelefono.addActionListener(this::txtBuscarTelefonoActionPerformed);

        jLabel8.setText("Numero de telefono ");

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(this::btnBuscarClienteActionPerformed);

        lblEstadoBusqueda.setText("Cliente encontrado");

        lblNombreEncontrado.setText("Nombre:");

        lblCodigoEncontrado.setText("Codigo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreEncontrado)
                                    .addComponent(lblEstadoBusqueda)
                                    .addComponent(lblCodigoEncontrado))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(btnBuscarCliente)
                                .addGap(144, 144, 144))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstadoBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreEncontrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigoEncontrado)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarCliente)
                .addGap(125, 125, 125))
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jblContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelClientesLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGroup(PanelClientesLayout.createSequentialGroup()
                            .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelClientesLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(jLabel2))
                                .addGroup(PanelClientesLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelClientesLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(txtFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(134, 134, 134)))
                            .addGap(6, 6, 6)
                            .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelClientesLayout.createSequentialGroup()
                                    .addGap(185, 185, 185)
                                    .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelClientesLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3)))
                                .addComponent(txtCorreoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CANCHA PRO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(770, 770, 770)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionesActionPerformed
        jblContenido.setText("GESTION DE RESERVACIONES");

    }//GEN-LAST:event_btnReservacionesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        jblContenido.setText("GESTION DE CLIENTES");
        PanelCanchas.setVisible(false);
        PanelClientes.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        jblContenido.setText("GESTION DE PAGOS");
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnCanchasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanchasActionPerformed
        jblContenido.setText("GESTION DE CANCHAS");
        PanelClientes.setVisible(false);
        PanelCanchas.setVisible(true);
    }//GEN-LAST:event_btnCanchasActionPerformed

    private void btnTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiendaActionPerformed
        jblContenido.setText("GESTION DE TIENDA");
    }//GEN-LAST:event_btnTiendaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    private void txtFechaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        
        
        String nombre = txtNombreCliente.getText();
        String codigo = txtCodigoCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String correo = txtCorreoCliente.getText();
        String fecha = txtFechaCliente.getText();
        
        Cliente nuevoCliente = new Cliente (nombre, codigo, telefono, correo, fecha);
        boolean guardado = registro.agregarCliente(nuevoCliente);
        registro.listarClientes();
        
        
        if (guardado) {
    archivoClientes.guardarCliente(nuevoCliente);

    JOptionPane.showMessageDialog(
        this,
        "Cliente registrado correctamente"
    );
    

        }else {
        JOptionPane.showMessageDialog(
            this,
            "ERROR: Ya existe un cliente con ese codigo",
            "Código duplicado",
            JOptionPane.ERROR_MESSAGE
    );
}
        
       
        
       
        
        
        
        
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void txtBuscarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarTelefonoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        String telefono = txtBuscarTelefono.getText().trim();
        Cliente encontrado = registro.buscarPorTelefono(telefono);
        if (encontrado != null) {
            lblEstadoBusqueda.setText("Cliente encontrado");
            lblNombreEncontrado.setText("Nombre: " + encontrado.getNombre());
            lblCodigoEncontrado.setText("Código: " + encontrado.getCodigo());
}
        else {
            lblEstadoBusqueda.setText("Cliente no encontrado");
            lblNombreEncontrado.setText("Nombre: ");
            lblCodigoEncontrado.setText("Código: ");
}
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarCanchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCanchaActionPerformed
          try {
    String codigo = txtIngresarCodigoCancha.getText().trim();
    String nombre = txtIngresarNombreCancha.getText().trim();
    String textoPrecio = txtIngresarPrecioCancha.getText().trim();
    String textoCapacidad = txtCapacidadCancha.getText().trim();

    String tipo = cmbTipoCancha.getSelectedItem().toString();

    if (codigo.isEmpty() || nombre.isEmpty()
            || textoPrecio.isEmpty() || textoCapacidad.isEmpty()
            || txtHoraApertura.getText().trim().isEmpty()
            || txtHoraCierre.getText().trim().isEmpty()) {

        javax.swing.JOptionPane.showMessageDialog(this,
                "Completa todos los campos");
                return;
    }

                int precio = Integer.parseInt(textoPrecio);
                int capacidad = Integer.parseInt(textoCapacidad);

                java.time.LocalTime apertura =
                java.time.LocalTime.parse(txtHoraApertura.getText().trim());

                java.time.LocalTime cierre =
                java.time.LocalTime.parse(txtHoraCierre.getText().trim());

            if (precio <= 0 || capacidad <= 0 || !cierre.isAfter(apertura)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                "Verifica el precio, capacidad y horario");
                return;
    }

            Cancha nueva = new Cancha(
            codigo, nombre, tipo, precio,
            "Disponible", capacidad, apertura, cierre
    );

            if (registroCanchas.agregarCancha(nueva)) {

                javax.swing.table.DefaultTableModel modelo =
                (javax.swing.table.DefaultTableModel) tblCanchas.getModel();

            modelo.addRow(new Object[]{
                 false,
                nueva.getCodigo(),
                nueva.getNombre(),
                nueva.getPrecio(),
                nueva.getEstado()
        });

            javax.swing.JOptionPane.showMessageDialog(this,
                "Cancha agregada correctamente");
    }   else {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No se pudo registrar. Verifica que el código no esté repetido.");
    }

}       catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "El precio y la capacidad deben ser números enteros");

}       catch (java.time.format.DateTimeParseException e) {
         javax.swing.JOptionPane.showMessageDialog(this,
            "Las horas deben tener formato HH:mm. Ejemplo: 08:00");
}
    }//GEN-LAST:event_btnAgregarCanchaActionPerformed

    private void cmbTipoCanchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCanchaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoCanchaActionPerformed

    private void txtCapacidadCanchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadCanchaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadCanchaActionPerformed

    private void cmbEstadoCanchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoCanchaActionPerformed
    }//GEN-LAST:event_cmbEstadoCanchaActionPerformed

    private void btnAplicarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarEstadoActionPerformed
    javax.swing.table.DefaultTableModel modelo =
    (javax.swing.table.DefaultTableModel) tblCanchas.getModel();

int seleccionadas = 0;
int filaSeleccionada = -1;

    for (int i = 0; i < modelo.getRowCount(); i++) {
        if (Boolean.TRUE.equals(modelo.getValueAt(i, 0))) {
            seleccionadas++;
            filaSeleccionada = i;
    }
}

    if (seleccionadas != 1) {
    javax.swing.JOptionPane.showMessageDialog(this,
        "Debes seleccionar solamente una cancha");
    return;
}

    String codigo = modelo.getValueAt(filaSeleccionada, 1).toString();

    String estado = cmbEstadoCancha.getSelectedItem().toString();

        if (registroCanchas.cambiarEstado(codigo, estado)) {

            modelo.setValueAt(estado, filaSeleccionada, 4);
            modelo.setValueAt(false, filaSeleccionada, 0);

            javax.swing.JOptionPane.showMessageDialog(this,
            "Estado de cancha actualizado correctamente");

}       else {

    javax.swing.JOptionPane.showMessageDialog(this,
            "No se pudo actualizar el estado de la cancha");
}
    }//GEN-LAST:event_btnAplicarEstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay wbtnReservacionesdefault look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCanchas;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton btnAgregarCancha;
    private javax.swing.JButton btnAplicarEstado;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCanchas;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnReservaciones;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTienda;
    private javax.swing.JComboBox<String> cmbEstadoCancha;
    private javax.swing.JComboBox<String> cmbTipoCancha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jblContenido;
    private javax.swing.JLabel lblCodigoEncontrado;
    private javax.swing.JLabel lblEstadoBusqueda;
    private javax.swing.JLabel lblNombreEncontrado;
    private javax.swing.JTable tblCanchas;
    private javax.swing.JTextField txtBuscarTelefono;
    private javax.swing.JTextField txtCapacidadCancha;
    private javax.swing.JLabel txtCodigoCancha;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtFechaCliente;
    private javax.swing.JTextField txtHoraApertura;
    private javax.swing.JTextField txtHoraCierre;
    private javax.swing.JTextField txtIngresarCodigoCancha;
    private javax.swing.JTextField txtIngresarNombreCancha;
    private javax.swing.JTextField txtIngresarPrecioCancha;
    private javax.swing.JLabel txtNombreCancha;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JLabel txtPrecioCancha;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
