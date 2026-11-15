
package com.canchapro.vista;
import com.canchapro.modelo.Cliente;
import com.canchapro.modelo.RegistroDeClientes;
import com.canchapro.modelo.ArchivoClientes;
import javax.swing.JOptionPane;
import com.canchapro.modelo.RegistroDeCanchas;
import com.canchapro.modelo.Cancha;
import com.canchapro.modelo.RegistroDeReservaciones;


public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    
            
            private RegistroDeClientes registro = new RegistroDeClientes();
            private ArchivoClientes archivoClientes = new ArchivoClientes();
            private RegistroDeCanchas registroCanchas = new RegistroDeCanchas();
            private RegistroDeReservaciones registroReservaciones = new RegistroDeReservaciones();
            
            private java.awt.CardLayout tarjetas;
    private com.canchapro.modelo.Tienda tienda = new com.canchapro.modelo.Tienda("Tienda CanchaPro");
    private javax.swing.table.DefaultTableModel modeloTienda;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JComboBox<String> comboReservasPago;
    private javax.swing.JLabel totalPago;
    private javax.swing.table.DefaultTableModel modeloReservas;
    private Runnable refrescarTienda;
    private javax.swing.JButton botonTiendaMenu;
    private javax.swing.JPanel pantallaTienda;
    private javax.swing.JCheckBox casillaTienda;
    private com.canchapro.modelo.RegistroDePagos registroPagos=new com.canchapro.modelo.RegistroDePagos();

            
            
            
            
    public VentanaPrincipal() {
        initComponents();
        configurarNavegacion();
       
        
        registroCanchas.cargarCanchas();
        
        archivoClientes.cargarClientes(registro);
        
        registroReservaciones.cargarReservaciones(
        registro,
        registroCanchas
);

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
        
        tienda.cargarProductos();
        tienda.cargarVentas();
        registroPagos.cargar();
        actualizarCombos();
        actualizarTablaReservas();
        actualizarTienda();
        actualizarAccesoTienda();
        mostrarPantalla("reservaciones");
        System.out.println("Clientes recuperados: " + registro.getCantidad());
            registro.listarClientes();
        
    }

    
    /** Navegación única para todas las pantallas. No modificar initComponents(). */
    private void configurarNavegacion() {
        // Se recuperan los paneles creados por el diseñador de NetBeans.
        // Antes estaban distribuidos entre el menú y el JFrame, causando superposiciones.
        if (PanelCanchas.getParent() != null) PanelCanchas.getParent().remove(PanelCanchas);
        if (PanelClientes.getParent() != null) PanelClientes.getParent().remove(PanelClientes);
        if (contenedorPantallas.getParent() != null) contenedorPantallas.getParent().remove(contenedorPantallas);
        if (PanelMenu.getParent() != null) PanelMenu.getParent().remove(PanelMenu);

        tarjetas = (java.awt.CardLayout) contenedorPantallas.getLayout();
        contenedorPantallas.add(PanelClientes, "clientes");
        contenedorPantallas.add(PanelCanchas, "canchas");

        contenedorPantallas.add(crearPagos(), "pagos");
        pantallaTienda = crearTienda();
        contenedorPantallas.add(pantallaTienda, "tienda");
        contenedorPantallas.add(crearHistorial(), "historial");
        contenedorPantallas.add(crearReportes(), "reportes");
        javax.swing.JButton botonReportes=new javax.swing.JButton("Reportes");
        javax.swing.JButton botonDisponible=new javax.swing.JButton("Disponibilidad");
        botonDisponible.addActionListener(e->consultarDisponibilidad());
        javax.swing.JButton botonInicio=new javax.swing.JButton("Inicio");
        botonInicio.addActionListener(e->mostrarInicio());
        botonReportes.addActionListener(e->{actualizarTablaReservas();mostrarPantalla("reportes");});
        javax.swing.JPanel lateral=new javax.swing.JPanel(new java.awt.BorderLayout());
        lateral.add(PanelMenu,java.awt.BorderLayout.CENTER);
        javax.swing.JPanel extras=new javax.swing.JPanel(new java.awt.GridLayout(4,1));
        javax.swing.JButton botonHistorial=new javax.swing.JButton("Historial");
        botonHistorial.addActionListener(e->mostrarHistorial());
        extras.add(botonInicio);extras.add(botonDisponible);extras.add(botonReportes);extras.add(botonHistorial);
        botonTiendaMenu=btnTienda;
        instalarAccesoAdministrador();
        lateral.add(extras,java.awt.BorderLayout.SOUTH);

        PanelMenu.setPreferredSize(new java.awt.Dimension(200, 620));
        contenedorPantallas.setPreferredSize(new java.awt.Dimension(750, 620));
        javax.swing.JPanel raiz = new javax.swing.JPanel(new java.awt.BorderLayout(8, 0));
        raiz.add(lateral, java.awt.BorderLayout.WEST);
        raiz.add(contenedorPantallas, java.awt.BorderLayout.CENTER);
        setContentPane(raiz);
        setPreferredSize(new java.awt.Dimension(1020, 680));
        pack();
        setLocationRelativeTo(null);
    }

    private void mostrarPantalla(String nombre) {
        tarjetas.show(contenedorPantallas, nombre);
        contenedorPantallas.revalidate();
        contenedorPantallas.repaint();
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
        contenedorPantallas = new javax.swing.JPanel();
        PanelReservaciones = new javax.swing.JPanel();
        lblTituloReservaciones = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblCanchaReservacion = new javax.swing.JLabel();
        lblFechaReservacion = new javax.swing.JLabel();
        lblHoraInicio = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        cmbClientesReservacion = new javax.swing.JComboBox<>();
        cmbCanchasReservacion = new javax.swing.JComboBox<>();
        spnDuracion = new javax.swing.JSpinner();
        txtFechaReservacion = new javax.swing.JFormattedTextField();
        txtHoraInicio = new javax.swing.JFormattedTextField();
        btnRegistrarReservacion = new javax.swing.JButton();

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addGroup(PanelCanchasLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelCanchasLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(btnAplicarEstado))
                                .addComponent(cmbEstadoCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCanchasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12)))
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
                .addGap(35, 35, 35)
                .addComponent(PanelCanchas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                            .addComponent(txtFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(120, 120, 120)
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

        contenedorPantallas.setLayout(new java.awt.CardLayout());

        lblTituloReservaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloReservaciones.setText("GESTIÓN DE RESERVACIONES");

        jLabel15.setText("Seleccionar cliente:");

        lblCanchaReservacion.setText("Seleccionar Cancha:");

        lblFechaReservacion.setText("Fecha de reservacion");

        lblHoraInicio.setText("Hora de inicio ");

        lblDuracion.setText("Duracion (horas)");

        cmbClientesReservacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCanchasReservacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            txtFechaReservacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtHoraInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnRegistrarReservacion.setText("Registrar reservación");
        btnRegistrarReservacion.addActionListener(this::btnRegistrarReservacionActionPerformed);

        javax.swing.GroupLayout PanelReservacionesLayout = new javax.swing.GroupLayout(PanelReservaciones);
        PanelReservaciones.setLayout(PanelReservacionesLayout);
        PanelReservacionesLayout.setHorizontalGroup(
            PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReservacionesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTituloReservaciones))
                    .addGroup(PanelReservacionesLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelReservacionesLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(121, 121, 121)
                                .addComponent(lblCanchaReservacion))
                            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelReservacionesLayout.createSequentialGroup()
                                                .addComponent(lblFechaReservacion)
                                                .addGap(99, 99, 99))
                                            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(txtFechaReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(141, 141, 141)))
                                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spnDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblDuracion)))
                                    .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                        .addComponent(cmbClientesReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139)
                                        .addComponent(cmbCanchasReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)))
                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHoraInicio)))
                            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnRegistrarReservacion)))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        PanelReservacionesLayout.setVerticalGroup(
            PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservacionesLayout.createSequentialGroup()
                .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReservacionesLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTituloReservaciones)
                        .addGap(18, 18, 18)
                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblCanchaReservacion)
                            .addComponent(lblHoraInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbCanchasReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbClientesReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaReservacion)
                            .addComponent(lblDuracion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarReservacion)))
                    .addGroup(PanelReservacionesLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(txtFechaReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(365, Short.MAX_VALUE))
        );

        contenedorPantallas.add(PanelReservaciones, "reservaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(770, 770, 770)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(880, 880, 880)
                    .addComponent(contenedorPantallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(331, Short.MAX_VALUE)))
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(303, 303, 303)
                    .addComponent(contenedorPantallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionesActionPerformed
        actualizarCombos();
        actualizarTablaReservas();
        mostrarPantalla("reservaciones");
    }//GEN-LAST:event_btnReservacionesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        jblContenido.setText("GESTION DE CLIENTES");
        mostrarPantalla("clientes");
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        actualizarPagos();
        mostrarPantalla("pagos");
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnCanchasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanchasActionPerformed
        mostrarPantalla("canchas");
    }//GEN-LAST:event_btnCanchasActionPerformed

    private void btnTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiendaActionPerformed
        if (!tienda.isACtiva()) { JOptionPane.showMessageDialog(this,"El módulo Tienda está desactivado. Presioná Ctrl + P para administrarlo."); return; }
        actualizarTienda();
        mostrarPantalla("tienda");
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
    actualizarCombos();

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

            actualizarCombos();
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

    private void btnRegistrarReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarReservacionActionPerformed
         try {
            int ic = cmbClientesReservacion.getSelectedIndex();
            int ia = cmbCanchasReservacion.getSelectedIndex();
            if (ic < 0 || ia < 0) throw new IllegalArgumentException("Selecciona cliente y cancha");
            String fechaTxt = txtFechaReservacion.getText().trim().replace(' ', '0');
            java.time.LocalDate fecha;
            if (fechaTxt.contains("/")) {
                String[] f = fechaTxt.split("/");
                int anio = Integer.parseInt(f[2]);
                if (anio < 100) anio += 2000;
                fecha = java.time.LocalDate.of(anio, Integer.parseInt(f[1]), Integer.parseInt(f[0]));
            } else fecha = java.time.LocalDate.parse(fechaTxt);
            String horaTxt = txtHoraInicio.getText().trim().replace('-', ':');
            java.time.LocalTime hora = java.time.LocalTime.parse(horaTxt);
            int horas = ((Number)spnDuracion.getValue()).intValue();
            if (horas <= 0) throw new IllegalArgumentException("La duración debe ser mayor a cero");
            com.canchapro.modelo.Reservacion r = new com.canchapro.modelo.Reservacion(
                "R" + System.currentTimeMillis(), registro.getCliente(ic), registroCanchas.getCancha(ia),
                fecha, hora, horas, "PENDIENTE");
            String[] extras={"Sin servicio","Balón Q25","Chalecos Q30","Árbitro Q100","Iluminación Q50"};
            String extra=(String)JOptionPane.showInputDialog(this,"Servicio adicional (opcional)","Servicios",JOptionPane.QUESTION_MESSAGE,null,extras,extras[0]);
            if(extra==null)return;
            if(extra.equals(extras[1]))r.agregarServicio("Balón",25);
            if(extra.equals(extras[2]))r.agregarServicio("Chalecos",30);
            if(extra.equals(extras[3]))r.agregarServicio("Árbitro",100);
            if(extra.equals(extras[4]))r.agregarServicio("Iluminación",50);
            if (registroReservaciones.agregarReservaciones(r)) {
                actualizarTablaReservas();
                String anticipo=JOptionPane.showInputDialog(this,"Total Q"+r.CalcularTotal()+". Anticipo inicial (0 si no paga):","0");
                if(anticipo!=null){try{double n=Double.parseDouble(anticipo);if(n>0){if(!registroPagos.agregar(r,n,"EFECTIVO","Anticipo"))JOptionPane.showMessageDialog(this,"Anticipo inválido");else {r.cambiarEstado("CONFIRMADA");registroReservaciones.guardarReservaciones();}}}catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Anticipo no numérico");}}
                JOptionPane.showMessageDialog(this,"Reservación registrada. Total: Q" + r.CalcularTotal());
            } else JOptionPane.showMessageDialog(this,"No se pudo registrar: horario, fecha, cancha o traslape incorrecto");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Revisa los datos: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarReservacionActionPerformed

    private void actualizarCombos() {
        cmbClientesReservacion.removeAllItems();
        for(int i=0;i<registro.getCantidad();i++) {
            Cliente c=registro.getCliente(i);
            cmbClientesReservacion.addItem(c.getCodigo()+" - "+c.getNombre());
        }
        cmbCanchasReservacion.removeAllItems();
        for(int i=0;i<registroCanchas.getCantidad();i++) {
            Cancha c=registroCanchas.getCancha(i);
            cmbCanchasReservacion.addItem(c.getCodigo()+" - "+c.getNombre());
        }
    }
    private void actualizarTablaReservas() {
        if(modeloReservas==null) return;
        modeloReservas.setRowCount(0);
        for(int i=0;i<registroReservaciones.getCantidad();i++) {
            com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
            modeloReservas.addRow(new Object[]{r.getCodigo(),r.getCliente().getNombre(),r.getCancha().getNombre(),r.getFecha(),r.getHora(),r.getHoras(),r.getEstado(),r.CalcularTotal()});
        }
    }
    private javax.swing.JPanel crearPagos() {
        javax.swing.JPanel panel=new javax.swing.JPanel(new java.awt.BorderLayout(5,5));
        javax.swing.JPanel arriba=new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        comboReservasPago=new javax.swing.JComboBox<>();arriba.add(new javax.swing.JLabel("Reserva:"));arriba.add(comboReservasPago);
        totalPago=new javax.swing.JLabel("Saldo Q0");arriba.add(totalPago);
        javax.swing.JButton abonar=new javax.swing.JButton("Registrar pago");arriba.add(abonar);
        javax.swing.JButton estado=new javax.swing.JButton("Cambiar estado / cancelar");arriba.add(estado);
        panel.add(arriba,java.awt.BorderLayout.NORTH);
        modeloReservas=new javax.swing.table.DefaultTableModel(new Object[]{"Código","Cliente","Cancha","Fecha","Hora","Horas","Estado","Total Q"},0){public boolean isCellEditable(int r,int c){return false;}};
        panel.add(new javax.swing.JScrollPane(new javax.swing.JTable(modeloReservas)),java.awt.BorderLayout.CENTER);
        comboReservasPago.addActionListener(e->calcularPago());
        abonar.addActionListener(e->{
            int i=comboReservasPago.getSelectedIndex();if(i<0)return;
            com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
            try{
                String dato=JOptionPane.showInputDialog(this,"Saldo Q"+String.format("%.2f",r.CalcularTotal()-registroPagos.pagado(r.getCodigo()))+". ¿Cuánto abona?");
                if(dato==null)return;double monto=Double.parseDouble(dato);
                String[] metodos={"EFECTIVO","TRANSFERENCIA","TARJETA"};
                String metodo=(String)JOptionPane.showInputDialog(this,"Método","Pago",JOptionPane.QUESTION_MESSAGE,null,metodos,metodos[0]);
                if(metodo==null)return;
                if(!registroPagos.agregar(r,monto,metodo,"Abono"))JOptionPane.showMessageDialog(this,"Pago inválido o mayor al saldo");
                else{if(r.getEstado().equals("PENDIENTE")){r.cambiarEstado("CONFIRMADA");registroReservaciones.guardarReservaciones();}JOptionPane.showMessageDialog(this,"Pago guardado");}
                actualizarPagos();
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Monto no numérico");}
        });
        estado.addActionListener(e->{
            int i=comboReservasPago.getSelectedIndex();if(i<0)return;
            com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
            String[] opciones={"CONFIRMADA","EN_CURSO","FINALIZADA","CANCELADA"};
            String nuevo=(String)JOptionPane.showInputDialog(this,"Estado actual: "+r.getEstado(),"Cambiar estado",JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
            if(nuevo==null)return;
            boolean ok;
            if(nuevo.equals("CANCELADA")){
                String motivo=JOptionPane.showInputDialog(this,"Motivo de cancelación:");
                if(motivo==null)return;
                String operador=JOptionPane.showInputDialog(this,"Nombre del operador:");
                if(operador==null)return;
                ok=r.cancelar(motivo,operador);
            }else{
                if(nuevo.equals("FINALIZADA") && r.CalcularTotal()-registroPagos.pagado(r.getCodigo())>0.001){JOptionPane.showMessageDialog(this,"Debe completar el pago de la cancha antes de finalizar");return;}
                ok=r.cambiarEstado(nuevo);
            }
            if(ok){registroReservaciones.guardarReservaciones();actualizarPagos();actualizarTienda();}
            else JOptionPane.showMessageDialog(this,"Cambio de estado no permitido");
        });
        return panel;
    }
    private void actualizarPagos() {
        if(comboReservasPago==null)return;
        comboReservasPago.removeAllItems();
        for(int i=0;i<registroReservaciones.getCantidad();i++) {
            com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
            comboReservasPago.addItem(r.getCodigo()+" - "+r.getCliente().getNombre());
        }
        actualizarTablaReservas(); calcularPago();
    }
    private void calcularPago(){
        int i=comboReservasPago.getSelectedIndex();
        if(i>=0){com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
            totalPago.setText("Total Q"+String.format("%.2f",r.CalcularTotal())+" | Pagado Q"+String.format("%.2f",registroPagos.pagado(r.getCodigo()))+" | Saldo Q"+String.format("%.2f",r.CalcularTotal()-registroPagos.pagado(r.getCodigo()))+" | Tienda pendiente Q"+String.format("%.2f",tienda.totalPendiente(r.getCodigo())));
        } else totalPago.setText("Total: Q0");
    }
    private javax.swing.JPanel crearTienda() {
        javax.swing.JPanel panel=new javax.swing.JPanel(new java.awt.BorderLayout(5,5));
        javax.swing.JPanel arriba=new javax.swing.JPanel(new java.awt.GridLayout(0,2,5,5));
        arriba.add(new javax.swing.JLabel("Módulo Tienda (administrado con Ctrl + P)"));
        arriba.add(new javax.swing.JLabel("Inventario (máximo 20 productos)"));
        javax.swing.JTextField codigo=new javax.swing.JTextField();
        javax.swing.JTextField nombre=new javax.swing.JTextField();
        javax.swing.JTextField precio=new javax.swing.JTextField();
        javax.swing.JTextField stock=new javax.swing.JTextField();
        javax.swing.JTextField categoria=new javax.swing.JTextField();
        javax.swing.JTextField minimo=new javax.swing.JTextField();
        arriba.add(new javax.swing.JLabel("Código"));arriba.add(codigo);
        arriba.add(new javax.swing.JLabel("Nombre"));arriba.add(nombre);
        arriba.add(new javax.swing.JLabel("Precio Q"));arriba.add(precio);
        arriba.add(new javax.swing.JLabel("Stock"));arriba.add(stock);
        arriba.add(new javax.swing.JLabel("Categoría"));arriba.add(categoria);
        arriba.add(new javax.swing.JLabel("Stock mínimo"));arriba.add(minimo);
        javax.swing.JButton agregar=new javax.swing.JButton("Agregar producto");arriba.add(agregar);
        javax.swing.JButton listar=new javax.swing.JButton("Ver inventario");arriba.add(listar);
        panel.add(arriba,java.awt.BorderLayout.NORTH);
        javax.swing.JTextArea salida=new javax.swing.JTextArea();salida.setEditable(false);
        panel.add(new javax.swing.JScrollPane(salida),java.awt.BorderLayout.CENTER);
        javax.swing.JPanel abajo=new javax.swing.JPanel(new java.awt.GridLayout(0,2,5,5));
        comboProductos=new javax.swing.JComboBox<>();
        javax.swing.JSpinner cantidad=new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1,1,999,1));
        javax.swing.JComboBox<String> destino=new javax.swing.JComboBox<>();
        abajo.add(new javax.swing.JLabel("Producto"));abajo.add(comboProductos);
        abajo.add(new javax.swing.JLabel("Cantidad"));abajo.add(cantidad);
        abajo.add(new javax.swing.JLabel("Venta: directa o cargar a reservación"));abajo.add(destino);
        javax.swing.JButton vender=new javax.swing.JButton("Realizar venta (carrito)");abajo.add(vender);
        javax.swing.JButton refrescar=new javax.swing.JButton("Actualizar reservas");abajo.add(refrescar);
        panel.add(abajo,java.awt.BorderLayout.SOUTH);
        Runnable actualizar=()->{
            comboProductos.removeAllItems();
            StringBuilder sb=new StringBuilder("PRODUCTOS EN TIENDA\n");
            for(int i=0;i<tienda.getCantidadProductos();i++){
                com.canchapro.modelo.Productos pr=tienda.getProducto(i);
                comboProductos.addItem(pr.getCodigo()+" - "+pr.getNombre());
                sb.append(pr.getCodigo()).append(" | ").append(pr.getNombre()).append(" | Q").append(pr.getPrecio()).append(" | stock: ").append(pr.getStock());
                if(pr.necesitaReposicion())sb.append("  REPOSICIÓN");
                sb.append("\n");
            }
            salida.setText(sb.toString());
            destino.removeAllItems();destino.addItem("Venta directa");
            for(int i=0;i<registroReservaciones.getCantidad();i++){
                com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
                if(!r.getEstado().equalsIgnoreCase("CANCELADA")&&!r.getEstado().equalsIgnoreCase("FINALIZADA"))destino.addItem(r.getCodigo()+" - "+r.getCliente().getNombre());
            }

        };
        agregar.addActionListener(e->{
            try {
                if(codigo.getText().trim().isEmpty()||nombre.getText().trim().isEmpty())throw new IllegalArgumentException("Completa código y nombre");
                double p=Double.parseDouble(precio.getText().trim());int st=Integer.parseInt(stock.getText().trim());int mn=Integer.parseInt(minimo.getText().trim());
                if(p<=0||st<0||mn<0)throw new IllegalArgumentException("Precio y existencias inválidos");
                if(!tienda.agregarProducto(new com.canchapro.modelo.Productos(nombre.getText().trim(),codigo.getText().trim(),p,st,categoria.getText().trim(),mn)))throw new IllegalArgumentException("Código repetido o inventario lleno");
                actualizar.run();JOptionPane.showMessageDialog(this,"Producto agregado");
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());}
        });
        listar.addActionListener(e->actualizar.run());refrescar.addActionListener(e->actualizar.run());
        vender.addActionListener(e->{
            if(!tienda.isACtiva()){JOptionPane.showMessageDialog(this,"Primero activa la tienda");return;}
            java.util.LinkedHashMap<String,Integer> carrito=new java.util.LinkedHashMap<>();
            while(true){
                String[] nombres=new String[tienda.getCantidadProductos()];
                for(int j=0;j<nombres.length;j++){com.canchapro.modelo.Productos pr=tienda.getProducto(j);nombres[j]=pr.getCodigo()+" - "+pr.getNombre()+" (stock "+pr.getStock()+")";}
                if(nombres.length==0){JOptionPane.showMessageDialog(this,"No hay productos");return;}
                String elegido=(String)JOptionPane.showInputDialog(this,"Selecciona un producto para la venta. Cancelar para terminar","Venta",JOptionPane.QUESTION_MESSAGE,null,nombres,nombres[0]);
                if(elegido==null)break;
                String cod=elegido.split(" - ")[0];
                try{String n=JOptionPane.showInputDialog(this,"Cantidad de "+cod+":","1");if(n==null)break;int cant=Integer.parseInt(n);
                    if(cant<=0)throw new NumberFormatException();carrito.merge(cod,cant,Integer::sum);
                }catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Cantidad incorrecta");}
                if(JOptionPane.showConfirmDialog(this,"¿Agregar otro producto?","Carrito",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)break;
            }
            if(carrito.isEmpty())return;
            String reserva=null;
            if(destino.getSelectedIndex()>0)reserva=destino.getSelectedItem().toString().split(" - ")[0];
            String[] metodos={"EFECTIVO","TRANSFERENCIA","TARJETA"};
            String metodo=(String)JOptionPane.showInputDialog(this,"Método de pago (para venta directa)","Venta",JOptionPane.QUESTION_MESSAGE,null,metodos,metodos[0]);
            if(metodo==null)return;
            double total=0;for(java.util.Map.Entry<String,Integer> item:carrito.entrySet())total+=tienda.buscarProducto(item.getKey()).getPrecio()*item.getValue();
            if(JOptionPane.showConfirmDialog(this,"Total Q"+String.format("%.2f",total)+". ¿Confirmar venta?","Confirmar",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;
            if(tienda.realizarVentaMultiple(carrito,reserva,metodo)){
                JOptionPane.showMessageDialog(this,"Venta registrada Q"+String.format("%.2f",total));actualizar.run();
            }else JOptionPane.showMessageDialog(this,"No se pudo registrar la venta. Revisá que la tienda y el producto estén activos y que exista stock suficiente. No se descontó inventario.");
        });
        refrescarTienda = actualizar;
        javax.swing.SwingUtilities.invokeLater(actualizar);
        return panel;
    }
    // Atajo de administración: funciona en cualquier pantalla del programa.
    private void instalarAccesoAdministrador() {
        javax.swing.KeyStroke tecla = javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK);
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(tecla, "administrarTienda");
        getRootPane().getActionMap().put("administrarTienda", new javax.swing.AbstractAction() {
            @Override public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirAdministradorTienda();
            }
        });
    }

    private void abrirAdministradorTienda() {
        javax.swing.JPasswordField campo = new javax.swing.JPasswordField(18);
        int respuesta = JOptionPane.showConfirmDialog(this, campo,
                "Administración de módulos - Ingresá el PIN", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (respuesta != JOptionPane.OK_OPTION) return;
        char[] ingresado = campo.getPassword();
        char[] esperado = "3090-25-11138".toCharArray();
        boolean correcto = java.util.Arrays.equals(ingresado, esperado);
        java.util.Arrays.fill(ingresado, ' ');
        java.util.Arrays.fill(esperado, ' ');
        if (!correcto) {
            JOptionPane.showMessageDialog(this, "PIN incorrecto. No se hicieron cambios.");
            return;
        }
        String[] opciones = tienda.isACtiva()
                ? new String[]{"Desactivar módulo Tienda", "Cancelar"}
                : new String[]{"Agregar / activar módulo Tienda", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this,
                "Panel de administración\nEstado actual: " +
                (tienda.isACtiva() ? "Tienda activada" : "Tienda desactivada") +
                "\nLos datos se conservarán al desactivar el módulo.",
                "Administrar módulos", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        if (eleccion != 0) return;
        if (tienda.isACtiva()) {
            tienda.cancelarTienda();
            mostrarPantalla("reservaciones");
        } else {
            tienda.activarTienda();
        }
        tienda.guardarProductos();
        actualizarAccesoTienda();
        actualizarTienda();
        JOptionPane.showMessageDialog(this, tienda.isACtiva()
                ? "Módulo Tienda activado correctamente."
                : "Módulo Tienda desactivado. Productos y ventas conservados.");
    }

    private void actualizarAccesoTienda() {
        if (botonTiendaMenu != null) {
            botonTiendaMenu.setVisible(tienda.isACtiva());
            botonTiendaMenu.getParent().revalidate();
            botonTiendaMenu.getParent().repaint();
        }
    }

    private javax.swing.JTextArea textoHistorial;
    private javax.swing.JPanel crearHistorial() {
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        javax.swing.JPanel arriba = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        arriba.add(new javax.swing.JLabel("Historial de clientes y reservaciones"));
        javax.swing.JButton refrescar = new javax.swing.JButton("Actualizar historial");
        refrescar.addActionListener(e -> mostrarHistorial());
        arriba.add(refrescar);
        panel.add(arriba, java.awt.BorderLayout.NORTH);
        textoHistorial = new javax.swing.JTextArea();
        textoHistorial.setEditable(false);
        textoHistorial.setFont(new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.PLAIN, 12));
        panel.add(new javax.swing.JScrollPane(textoHistorial), java.awt.BorderLayout.CENTER);
        return panel;
    }

    private void mostrarHistorial() {
        StringBuilder datos = new StringBuilder("CLIENTES REGISTRADOS: ").append(registro.getCantidad()).append("\n\n");
        for (int i = 0; i < registro.getCantidad(); i++) {
            Cliente c = registro.getCliente(i);
            datos.append("Código: ").append(c.getCodigo())
                    .append(" | Nombre: ").append(c.getNombre())
                    .append(" | Teléfono: ").append(c.getTelefono())
                    .append(" | Correo: ").append(c.getCorreo())
                    .append(" | Registro: ").append(c.getFecha()).append("\n");
        }
        datos.append("\nRESERVACIONES REGISTRADAS: ").append(registroReservaciones.getCantidad()).append("\n\n");
        for (int i = 0; i < registroReservaciones.getCantidad(); i++) {
            com.canchapro.modelo.Reservacion r = registroReservaciones.getReservacion(i);
            double pagado = registroPagos.pagado(r.getCodigo());
            datos.append("Reserva: ").append(r.getCodigo())
                    .append(" | Cliente: ").append(r.getCliente().getNombre())
                    .append(" | Cancha: ").append(r.getCancha().getNombre())
                    .append("\nFecha: ").append(r.getFecha())
                    .append(" | Hora: ").append(r.getHora())
                    .append(" | Duración: ").append(r.getHoras()).append(" horas")
                    .append(" | Estado: ").append(r.getEstado())
                    .append("\nTotal Q").append(String.format("%.2f", r.CalcularTotal()))
                    .append(" | Pagado Q").append(String.format("%.2f", pagado))
                    .append(" | Saldo Q").append(String.format("%.2f", Math.max(0, r.CalcularTotal()-pagado)))
                    .append("\n------------------------------------------------------------\n");
        }
        textoHistorial.setText(datos.toString());
        textoHistorial.setCaretPosition(0);
        mostrarPantalla("historial");
    }

    private void mostrarInicio(){
        int hoy=0,curso=0,pendientes=0;double ingresos=0;
        for(int i=0;i<registroReservaciones.getCantidad();i++){
            com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
            if(r.getFecha().equals(java.time.LocalDate.now()))hoy++;
            if(r.getEstado().equals("EN_CURSO"))curso++;
            if(r.getEstado().equals("PENDIENTE"))pendientes++;
        }
        for(com.canchapro.modelo.Pago pago:registroPagos.getPagos()){
            if(pago.getFecha().startsWith(java.time.LocalDate.now().toString()))ingresos+=pago.getMonto();
        }
        JOptionPane.showMessageDialog(this,"CANCHA PRO - INICIO\nReservas de hoy: "+hoy+"\nEn curso: "+curso+"\nPendientes: "+pendientes+"\nIngresos de hoy: Q"+String.format("%.2f",ingresos));
    }
    private void consultarDisponibilidad(){
        try{
            String fechaTxt=JOptionPane.showInputDialog(this,"Fecha AAAA-MM-DD:",java.time.LocalDate.now().plusDays(1));if(fechaTxt==null)return;
            java.time.LocalDate fecha=java.time.LocalDate.parse(fechaTxt);
            String horaTxt=JOptionPane.showInputDialog(this,"Hora HH:MM:","18:00");if(horaTxt==null)return;
            java.time.LocalTime hora=java.time.LocalTime.parse(horaTxt);
            String duracion=JOptionPane.showInputDialog(this,"Duración en horas:","1");if(duracion==null)return;
            int horas=Integer.parseInt(duracion);if(horas<=0)throw new IllegalArgumentException();
            String tipo=JOptionPane.showInputDialog(this,"Tipo de cancha (vacío = todas):","");if(tipo==null)return;
            StringBuilder sb=new StringBuilder("CANCHAS DISPONIBLES\n");int libres=0;
            for(int i=0;i<registroCanchas.getCantidad();i++){
                Cancha cancha=registroCanchas.getCancha(i);
                if(!cancha.getEstado().equalsIgnoreCase("Disponible")||!cancha.getTipo().toLowerCase().contains(tipo.toLowerCase()))continue;
                if(hora.isBefore(cancha.getHoraApertura())||hora.plusHours(horas).isAfter(cancha.getHoraCierre()))continue;
                boolean ocupado=false;
                for(int j=0;j<registroReservaciones.getCantidad();j++){
                    com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(j);
                    if(r.getCancha().getCodigo().equalsIgnoreCase(cancha.getCodigo())&&r.getFecha().equals(fecha)&&!r.getEstado().equals("CANCELADA")&&hora.isBefore(r.calcularHoraFinal())&&hora.plusHours(horas).isAfter(r.getHora()))ocupado=true;
                }
                if(!ocupado){sb.append(cancha.getCodigo()).append(" - ").append(cancha.getNombre()).append(" (").append(cancha.getTipo()).append(")\n");libres++;}
            }
            if(libres==0)sb.append("No hay canchas disponibles");
            JOptionPane.showMessageDialog(this,sb.toString());
        }catch(Exception ex){JOptionPane.showMessageDialog(this,"Fecha, hora o duración inválida");}
    }
    private javax.swing.JPanel crearReportes(){
        javax.swing.JPanel panel=new javax.swing.JPanel(new java.awt.BorderLayout(5,5));
        javax.swing.JTextArea texto=new javax.swing.JTextArea();texto.setEditable(false);
        panel.add(new javax.swing.JScrollPane(texto),java.awt.BorderLayout.CENTER);
        javax.swing.JPanel arriba=new javax.swing.JPanel(new java.awt.FlowLayout());
        javax.swing.JTextField mes=new javax.swing.JTextField(java.time.LocalDate.now().toString().substring(0,7),7);
        arriba.add(new javax.swing.JLabel("Mes (AAAA-MM):"));arriba.add(mes);
        javax.swing.JButton generar=new javax.swing.JButton("Generar reportes");arriba.add(generar);
        panel.add(arriba,java.awt.BorderLayout.NORTH);
        generar.addActionListener(e->{
            try{
                java.time.YearMonth periodo=java.time.YearMonth.parse(mes.getText().trim());
                StringBuilder sb=new StringBuilder("REPORTES CANCHA PRO - "+periodo+"\n\n");
                java.util.Map<String,Integer> porCancha=new java.util.LinkedHashMap<>(),porHora=new java.util.TreeMap<>(),porCliente=new java.util.LinkedHashMap<>(),porFecha=new java.util.TreeMap<>();
                int reservas=0,canceladas=0;double cobrado=0,pendiente=0;
                sb.append("RESERVAS POR FECHA Y CANCHA\n");
                for(int i=0;i<registroReservaciones.getCantidad();i++){
                    com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
                    if(!java.time.YearMonth.from(r.getFecha()).equals(periodo))continue;
                    reservas++;
                    sb.append(r.getFecha()).append("  ").append(r.getCodigo()).append("  ").append(r.getCancha().getNombre()).append("  ").append(r.getEstado()).append("\n");
                    porFecha.merge(r.getFecha().toString(),1,Integer::sum);
                    if(r.getEstado().equals("CANCELADA")){canceladas++;continue;}
                    porCancha.merge(r.getCancha().getNombre(),1,Integer::sum);
                    porHora.merge(r.getHora().toString(),1,Integer::sum);
                    porCliente.merge(r.getCliente().getNombre(),1,Integer::sum);
                    cobrado+=registroPagos.pagado(r.getCodigo());
                    pendiente+=Math.max(0,r.CalcularTotal()-registroPagos.pagado(r.getCodigo()));
                }
                sb.append("\nRESUMEN: ").append(reservas).append(" reservas, ").append(canceladas).append(" canceladas\n");
                sb.append("INGRESOS COBRADOS Q").append(String.format("%.2f",cobrado)).append("\n");
                sb.append("PAGOS PENDIENTES Q").append(String.format("%.2f",pendiente)).append("\n");
                sb.append("RESERVAS POR FECHA: ").append(porFecha).append("\n");
                sb.append("RESERVAS POR CANCHA: ").append(porCancha).append("\n");
                sb.append("CANCHA MÁS UTILIZADA: ").append(mayor(porCancha)).append("\n");
                sb.append("HORARIOS DE MAYOR DEMANDA: ").append(porHora).append(" | Mayor: ").append(mayor(porHora)).append("\n");
                sb.append("CLIENTES CON MÁS RESERVAS: ").append(porCliente).append(" | Mayor: ").append(mayor(porCliente)).append("\n");
                sb.append("\nCANCELACIONES\n");
                for(int i=0;i<registroReservaciones.getCantidad();i++){
                    com.canchapro.modelo.Reservacion r=registroReservaciones.getReservacion(i);
                    if(r.getEstado().equals("CANCELADA")&&java.time.YearMonth.from(r.getFecha()).equals(periodo))sb.append(r.getCodigo()).append(" - ").append(r.getMotivoCancelacion()).append(" - ").append(r.getOperadorCancelacion()).append("\n");
                }
                sb.append("\nTIENDA\n").append(tienda.reporteVentas(periodo.toString()));
                texto.setText(sb.toString());texto.setCaretPosition(0);
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Mes inválido. Usa AAAA-MM");}
        });
        return panel;
    }
    private String mayor(java.util.Map<String,Integer> mapa){
        String nombre="Ninguno";int max=0;
        for(java.util.Map.Entry<String,Integer> e:mapa.entrySet())if(e.getValue()>max){max=e.getValue();nombre=e.getKey()+" ("+max+")";}
        return nombre;
    }
    private void actualizarTienda(){
        if(comboProductos==null)return;
        if(refrescarTienda!=null) refrescarTienda.run();
    }

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
    private javax.swing.JPanel PanelReservaciones;
    private javax.swing.JButton btnAgregarCancha;
    private javax.swing.JButton btnAplicarEstado;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCanchas;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnRegistrarReservacion;
    private javax.swing.JButton btnReservaciones;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTienda;
    private javax.swing.JComboBox<String> cmbCanchasReservacion;
    private javax.swing.JComboBox<String> cmbClientesReservacion;
    private javax.swing.JComboBox<String> cmbEstadoCancha;
    private javax.swing.JComboBox<String> cmbTipoCancha;
    private javax.swing.JPanel contenedorPantallas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel lblCanchaReservacion;
    private javax.swing.JLabel lblCodigoEncontrado;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblEstadoBusqueda;
    private javax.swing.JLabel lblFechaReservacion;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblNombreEncontrado;
    private javax.swing.JLabel lblTituloReservaciones;
    private javax.swing.JSpinner spnDuracion;
    private javax.swing.JTable tblCanchas;
    private javax.swing.JTextField txtBuscarTelefono;
    private javax.swing.JTextField txtCapacidadCancha;
    private javax.swing.JLabel txtCodigoCancha;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtFechaCliente;
    private javax.swing.JFormattedTextField txtFechaReservacion;
    private javax.swing.JTextField txtHoraApertura;
    private javax.swing.JTextField txtHoraCierre;
    private javax.swing.JFormattedTextField txtHoraInicio;
    private javax.swing.JTextField txtIngresarCodigoCancha;
    private javax.swing.JTextField txtIngresarNombreCancha;
    private javax.swing.JTextField txtIngresarPrecioCancha;
    private javax.swing.JLabel txtNombreCancha;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JLabel txtPrecioCancha;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
