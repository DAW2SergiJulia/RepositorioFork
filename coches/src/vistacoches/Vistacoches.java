/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistacoches;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import modelo.Modelo_coches;

/**
 *
 * @author Luis David
 */
public class Vistacoches extends javax.swing.JFrame {

    //ArrayList<Modelo_coches> seleccionCoches = new ArrayList<Modelo_coches>();
    /**
     * Creates new form Vistacoches
     */
    public Vistacoches() {
        initComponents();
        colorjframe();
        jl_fotomuestra.setVisible(false);
        jp_vistafoto.setVisible(false);
    }
    Modelo_coches modelcolorextras = new Modelo_coches();

    //MIS PARÁMETROS
    public void colorjframe(){
        //Color JFrame
        this.getContentPane().setBackground(new Color(234, 242, 248));
        //Color JPanel cliente
        this.jp_infoclient.setBackground(new Color(234, 242, 248));
        //Color JPanel Modelo
        this.jp_modelcoche.setBackground(new Color(234, 242, 248));
        //Color JPanel Color
        this.jp_colorcoche.setBackground(new Color(234, 242, 248));
        //Color JPanel Extras
        this.jp_extrascoche.setBackground(new Color(234, 242, 248));
    }
    //Resetear los datos del formulario
    public void reset_datos() {
        //Reset Información del Cliente
        jt_nomcliente.setText(null);
        jt_telfclient.setText(null);
        //Reset Combo Box del Model del coche
        jcb_modelcoche.setSelectedItem("Selecciona el Modelo");
        //Reset de los Radio buttons del Color del coche
        bg_color.clearSelection();
        //Reset de los Check Box's de los extras del coche
        jcb_extra1.setSelected(false);
        jcb_extra2.setSelected(false);
        jcb_extra3.setSelected(false);
        jcb_extra4.setSelected(false);
        jcb_extra5.setSelected(false);
        jcb_extra6.setSelected(false);
        jcb_extra7.setSelected(false);
        jcb_extra8.setSelected(false);
        jcb_extra9.setSelected(false);
        jcb_extra10.setSelected(false);
        //Reset del Importe Total
        jt_total.setText(null);
        //Reset JPanel y JLabel (Errores en rojo)
        //JPanel Información del cliente
        jp_infoclient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
        jLabel1.setForeground(Color.black);
        jLabel2.setForeground(Color.black);
        //JPanel Modelo del coche
        jp_modelcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo del Coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
        //JPane Color del coche
        jp_colorcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color del coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
        //Reset Visualizar datos seleccionados (JTextArea)
        jta_visualizardatos.setText(null);
        jl_fotomuestra.setVisible(false);
        jp_vistafoto.setVisible(false);
    }

    //Comprobar los campos seleccionados o vacíos
    public void comprobar_datos() {
        //Comprobar si los campos de Nombre y Teléfono están rellenados o vacíos
        if ((jt_nomcliente.getText().isEmpty()) && (jt_telfclient.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "<html>Los campos <b>Información del Cliente</b> no pueden estar vacíos</html>");
            this.jp_infoclient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 0, 0)));
            this.jLabel1.setForeground(Color.red);
            this.jLabel2.setForeground(Color.red);
        } else {
            //Comprobar si los campos de Nombre o Teléfono están rellenos o vacíos
            this.jp_infoclient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
            if (jt_nomcliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "<html>El campo <b>Nombre</b> no puede estar vacío</html>");
                this.jLabel1.setForeground(Color.red);
            } else {
                this.jLabel1.setForeground(Color.black);
            }
        }
        //Campo Teléfono
        try {
            Integer.parseInt(jt_telfclient.getText());
            //Comprueba que el campo no esté vacío
            if (jt_telfclient.getText().isEmpty()) {
                this.jLabel2.setForeground(Color.red);
            } else {
                //Comprueba que el número introducido tiene 9 dígitos
                if (jt_telfclient.getText().length() != 9) {
                    JOptionPane.showMessageDialog(null, "<html>Introduce un n<º de <b>Teléfono</b> válido.</html>");
                } else {
                    //Comprueba que el número introducido es mayor a 0
                    if (Integer.parseInt(jt_telfclient.getText()) <= 0) {
                        JOptionPane.showMessageDialog(null, "<html>Introduce un n<º de <b>Teléfono</b> válido.</html>");
                    } else {
                        this.jLabel2.setForeground(Color.black);
                    }
                }
            }
        } catch (NumberFormatException e) {
            if (jt_telfclient.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "<html>El campo <b>Teléfono</b> no puede estar vacío</html>");
            } else {
                JOptionPane.showMessageDialog(null, "<html>Introduce un n<º de <b>Teléfono</b> válido.</html>");
            }
        }

        //Comprobar si los campos de Nombre y Teléfono están rellenados o vacíos
//        if ((jt_nomcliente.getText().isEmpty()) && (jt_telfclient.getText().isEmpty()) ){
//            JOptionPane.showMessageDialog(null, "<html>Los campos <b>Información del Cliente</b> no pueden estar vacíos</html>");
//            this.jp_infoclient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 0, 0)));
//            this.jLabel1.setForeground(Color.red);
//            this.jLabel2.setForeground(Color.red);
//        } else {
//            this.jp_infoclient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
        //Comprobar si los campos de Nombre o Teléfono están rellenos o vacíos
//            if (jt_nomcliente.getText().isEmpty()){
//                JOptionPane.showMessageDialog(null, "<html>El campo <b>Nombre</b> no puede estar vacío</html>");
//                this.jLabel1.setForeground(Color.red);
//            } else {
//                this.jLabel1.setForeground(Color.black);
//            }
//            if (jt_telfclient.getText().isEmpty()){
//                JOptionPane.showMessageDialog(null, "<html>El campo <b>Teléfono</b> no puede estar vacío</html>");
//                this.jLabel2.setForeground(Color.red);
//            } else {
//                this.jLabel2.setForeground(Color.black);
//            }
//        }
        //Comprobar si el Modelo del coche está seleccionado
        if (jcb_modelcoche.getSelectedItem() == "Selecciona el Modelo") {
            JOptionPane.showMessageDialog(null, "<html>Selecciona <b>un Modelo</b></html>");
            jp_modelcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo del Coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 0, 0)));
        } else {
            jp_modelcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo del Coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
        }
        //Comprobar si hay un Color seleccionado
        if (bg_color.isSelected(null)) {
            JOptionPane.showMessageDialog(null, "<html>Selecciona al menos <b>1 Color del coche</b></html>");
            jp_colorcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color del coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 0, 0)));
        } else {
            jp_colorcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color del coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 0, 0)));
        }
    }

    //Visualizar la información seleccionada en el JTextArea
    public void info_datos() {
        //Visualizar en el JTextArea el nombre del cliente (JTextField)
        String nomcli = jt_nomcliente.getText() + "\n";
        //Visualizar en el JTextArea todo lo anterior + el teléfono del cliente (JTextField)
        String telfcli = jt_telfclient.getText() + "\n\n";
        //Visualizar en el JTextArea todo lo anterior + el modelo del coche (ComboBox)
        String modelCoche = (String) jcb_modelcoche.getSelectedItem() + "\n\n";
        //Visualizar en el JTextArea todo lo anterior + el color del coche (Radio Button's)
        String cocheColor = "";
        if (jrb_blanco.isSelected()) {
            cocheColor += this.jrb_blanco.getText() + "\n\n";
        } else if (jrb_negro.isSelected()) {
            cocheColor += this.jrb_negro.getText() + "\n\n";
        } else if (jrb_rojoem.isSelected()) {
            cocheColor += this.jrb_rojoem.getText() + "\n\n";
        } else if (jrb_rojoru.isSelected()) {
            cocheColor += this.jrb_rojoru.getText() + "\n\n";
        } else if (jrb_gris.isSelected()) {
            cocheColor += this.jrb_gris.getText() + "\n\n";
        } else if (jrb_verde.isSelected()) {
            cocheColor += this.jrb_verde.getText() + "\n\n";
        }
        //Visualizar en el JTextArea todo lo anterior + los extras del coche (Check Box's)
        String cocheExtras = "";
        if (jcb_extra1.isSelected() == true) {
            cocheExtras += "- " + this.jcb_extra1.getText() + "\n";
        }
        if (jcb_extra2.isSelected() == true) {
            cocheExtras += "- " + this.jcb_extra2.getText() + "\n";
        }
        if (jcb_extra3.isSelected() == true) {
            cocheExtras += "- " + this.jcb_extra3.getText() + "\n";
        }
        if (jcb_extra4.isSelected() == true) {
            cocheExtras += "- Portaobjetos interior en techo con pantalla TFT 7\" y conectores RCA\n  (Incompatible con iPod y USB)\n";
        }
        if (jcb_extra5.isSelected() == true) {
            cocheExtras += "- " + this.jcb_extra5.getText() + "\n";
        }
        if (jcb_extra6.isSelected() == true) {
            cocheExtras += "- Asientos calefactados + eyectores calefactados + lavafaros + montante A calefactado\n  (+ retrovisores posicion parking solo en Reference) \n";
        }
        if (jcb_extra7.isSelected() == true) {
            cocheExtras += "- Sistema navegación blanco y negro + MP3 + antena antirrobo.\n  (Elimina la conexión AUX-in) \n";
        }
        if (jcb_extra8.isSelected() == true) {
            cocheExtras += "- SEAT Nediasystem: Sistema de navegación dinámica con pantalla táctil a color de 6,5\",\n  lector de DVD, disco duro de 30GB, conectividad Bluetooth y mandos en el volante.\n  (Incluye DVD con cartografía) \n";
        }
        if (jcb_extra9.isSelected() == true) {
            cocheExtras += "- " + this.jcb_extra9.getText() + "\n";
        }
        if (jcb_extra10.isSelected() == true) {
            cocheExtras += "- " + this.jcb_extra10.getText() + "\n";
        }
        //Visualizar en el JTextArea todo lo anterior + el importe total (JTextField)
        String imptot = "\n" + jt_total.getText();
        //Visualiza en el JTextArea todo lo que hemos escrito/seleccionado anteriormente
        try{
            if (jcb_modelcoche.getSelectedItem() == "Selecciona el Modelo"){
                return;
            } else {
                jta_visualizardatos.setText(nomcli + telfcli + modelCoche + cocheColor + cocheExtras + imptot);
            }
        }catch(Exception e){
            jta_visualizardatos.setText(null);
        }
        
    }

    //Cálculos
    public void calculos() {
        //Al pulsar comprueba los datos seleccionados o si falta algún dato requerido
        comprobar_datos();
        //También se calcula y se visualiza (JTextField - Importe Total) el precio total de los items seleccionados
        //Selección modelo del coche *Campos obligatorios*
        double modeloCoche = 0;
        double colorCoche = 0;
        double extrasCoche = 0;
        double resultot = 0;

        if (jcb_modelcoche.getSelectedItem() == "Altea 1.4 TSI 125CV (92 kw) Arena") {
            modeloCoche = 21452.0;
        } else if (jcb_modelcoche.getSelectedItem() == "Altea 1.9 TDI 105CV (77 kw) Arena") {
            modeloCoche = 22299.0;
        } else if (jcb_modelcoche.getSelectedItem() == "Altea 1.9 TDI 105CV (77 kw) DPF DSG Arena") {
            modeloCoche = 24137.0;
        } else if (jcb_modelcoche.getSelectedItem() == "Altea 2.0 TDI 140CV (103 kw) 6 Vel. Arena") {
            modeloCoche = 24274.0;
        } else if (jcb_modelcoche.getSelectedItem() == "Altea 2.0 TDI 16V 140CV (103 kw) 6 Vel. DSG Arena") {
            modeloCoche = 25741.0;
        } else {
            modeloCoche = 0;
        }
        //Selección del color del coche *Campos obligatorios*
        if (jrb_negro.isSelected() == true) {
            colorCoche = 400.0;
        } else if (this.jrb_rojoem.isSelected() == true) {
            colorCoche = 152.0;
        } else if (this.jrb_rojoru.isSelected() == true) {
            colorCoche = 400.0;
        } else if (this.jrb_gris.isSelected() == true) {
            colorCoche = 400.0;
        } else if (this.jrb_verde.isSelected() == true) {
            colorCoche = 400.0;
        } else {
            colorCoche = 0;
        }
        //Selección de los extras del coche *Campos opcionales*
        if (jcb_extra1.isSelected()) {
            extrasCoche += 276.0;
        }
        if (jcb_extra2.isSelected()) {
            extrasCoche += 100.0;
        }
        if (jcb_extra3.isSelected()) {
            extrasCoche += 100.0;
        }
        if (jcb_extra4.isSelected()) {
            extrasCoche += 369.0;
        }
        if (jcb_extra5.isSelected()) {
            extrasCoche += 98.0;
        }
        if (jcb_extra6.isSelected()) {
            extrasCoche += 581.0;
        }
        if (jcb_extra7.isSelected()) {
            extrasCoche += 1070.0;
        }
        if (jcb_extra8.isSelected()) {
            extrasCoche += 1465.0;
        }
        if (jcb_extra9.isSelected()) {
            extrasCoche += 253.0;
        }
        if (jcb_extra10.isSelected()) {
            extrasCoche += 835.0;
        }
        //Resultado total de la selección de Modelo+Color del coche
        resultot = modelcolorextras.sumModelColor(modeloCoche, colorCoche);
        resultot = modelcolorextras.sumModColExras(resultot, extrasCoche);
        //jt_total.setText(Double.toString(modeloCoche));-
        this.jt_total.setText(String.valueOf(resultot) + " €");
    }

    public void escribir2(JTextArea area) {
        try {
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
           * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda + ".txt");
                // BufferedWriter bw = new BufferedWriter(save); 
                String p = area.getText();

                System.out.println(p);
                String[] lineas = p.split("\n");
                System.out.println("Texto original:\n" + p);
                System.out.println("Texto modificado:\n");
                for (int i = 0; i < lineas.length; i++) {

                    save.write(lineas[i]);
                    save.write(System.getProperty("line.separator"));
                }
                save.write(area.getText());
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Guarda la información en un documento .txt al pulsar el botón Generar
//    public void guardarinfo() {
//        String comando = "cmd /c  break > C:\\Users\\Luis David\\Documents\\DAW 2\\practica01_Java_Coches\\Formulario_Clientes.txt";
//        Process pr;
//        try{
//            pr = Runtime.getRuntime().exec(comando);
//        } catch(Exception ex){
//            System.out.println("Ha ocurrido un error al ejecutar el comando. Error: "+ex);
//        }
//        
//        try {
//            this.jta_visualizardatos.write(new FileWriter("C:\\Users\\Luis David\\Documents\\DAW 2\\practica01_Java_Coches\\Formulario_Clientes.txt"));
//        } catch (Exception ex) {
//            System.out.println("Error");
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_color = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jt_total = new javax.swing.JTextField();
        jb_generar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jp_infoclient = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jt_nomcliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jt_telfclient = new javax.swing.JTextField();
        jp_modelcoche = new javax.swing.JPanel();
        jcb_modelcoche = new javax.swing.JComboBox<>();
        jp_colorcoche = new javax.swing.JPanel();
        jrb_blanco = new javax.swing.JRadioButton();
        jrb_rojoem = new javax.swing.JRadioButton();
        jrb_gris = new javax.swing.JRadioButton();
        jrb_negro = new javax.swing.JRadioButton();
        jrb_rojoru = new javax.swing.JRadioButton();
        jrb_verde = new javax.swing.JRadioButton();
        jp_extrascoche = new javax.swing.JPanel();
        jcb_extra1 = new javax.swing.JCheckBox();
        jcb_extra2 = new javax.swing.JCheckBox();
        jcb_extra3 = new javax.swing.JCheckBox();
        jcb_extra4 = new javax.swing.JCheckBox();
        jcb_extra5 = new javax.swing.JCheckBox();
        jcb_extra6 = new javax.swing.JCheckBox();
        jcb_extra7 = new javax.swing.JCheckBox();
        jcb_extra8 = new javax.swing.JCheckBox();
        jcb_extra9 = new javax.swing.JCheckBox();
        jcb_extra10 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_visualizardatos = new javax.swing.JTextArea();
        jp_vistafoto = new javax.swing.JPanel();
        jl_fotomuestra = new javax.swing.JLabel();
        jmb_menuform = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmi_nuevo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_guardar = new javax.swing.JMenuItem();
        jmi_guardarcomo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmi_salir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Importe Total");

        jt_total.setEditable(false);
        jt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_totalActionPerformed(evt);
            }
        });

        jb_generar.setText("Generar");
        jb_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_generarActionPerformed(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jp_infoclient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N

        jLabel1.setText("Nombre");

        jt_nomcliente.setToolTipText("Escribe el Nombre");
        jt_nomcliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jt_nomcliente.setName(""); // NOI18N
        jt_nomcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_nomclienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Teléfono");

        jt_telfclient.setToolTipText("777888999");
        jt_telfclient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jt_telfclientKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jp_infoclientLayout = new javax.swing.GroupLayout(jp_infoclient);
        jp_infoclient.setLayout(jp_infoclientLayout);
        jp_infoclientLayout.setHorizontalGroup(
            jp_infoclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoclientLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jp_infoclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jp_infoclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jt_nomcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_telfclient, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jp_infoclientLayout.setVerticalGroup(
            jp_infoclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoclientLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jp_infoclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_nomcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jp_infoclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_telfclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20))
        );

        jp_modelcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo del Coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N
        jp_modelcoche.setToolTipText("");

        jcb_modelcoche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el Modelo", "Altea 1.4 TSI 125CV (92 kw) Arena", "Altea 1.9 TDI 105CV (77 kw) Arena", "Altea 1.9 TDI 105CV (77 kw) DPF DSG Arena", "Altea 2.0 TDI 140CV (103 kw) 6 Vel. Arena", "Altea 2.0 TDI 16V 140CV (103 kw) 6 Vel. DSG Arena" }));
        jcb_modelcoche.setToolTipText("");
        jcb_modelcoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_modelcocheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_modelcocheLayout = new javax.swing.GroupLayout(jp_modelcoche);
        jp_modelcoche.setLayout(jp_modelcocheLayout);
        jp_modelcocheLayout.setHorizontalGroup(
            jp_modelcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_modelcocheLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jcb_modelcoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jp_modelcocheLayout.setVerticalGroup(
            jp_modelcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_modelcocheLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jcb_modelcoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jp_colorcoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color del coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N

        bg_color.add(jrb_blanco);
        jrb_blanco.setText("Blanco candy");

        bg_color.add(jrb_rojoem);
        jrb_rojoem.setText("Rojo emoción");

        bg_color.add(jrb_gris);
        jrb_gris.setText("Gris zenith");

        bg_color.add(jrb_negro);
        jrb_negro.setText("Negro mágico");

        bg_color.add(jrb_rojoru);
        jrb_rojoru.setText("Rojo rubí");

        bg_color.add(jrb_verde);
        jrb_verde.setText("Verde natura");

        javax.swing.GroupLayout jp_colorcocheLayout = new javax.swing.GroupLayout(jp_colorcoche);
        jp_colorcoche.setLayout(jp_colorcocheLayout);
        jp_colorcocheLayout.setHorizontalGroup(
            jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_colorcocheLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb_blanco)
                    .addComponent(jrb_rojoem)
                    .addComponent(jrb_gris))
                .addGap(20, 20, 20)
                .addGroup(jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb_verde)
                    .addComponent(jrb_rojoru)
                    .addComponent(jrb_negro))
                .addGap(51, 51, 51))
        );
        jp_colorcocheLayout.setVerticalGroup(
            jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_colorcocheLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_blanco)
                    .addComponent(jrb_negro))
                .addGap(20, 20, 20)
                .addGroup(jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_rojoem)
                    .addComponent(jrb_rojoru))
                .addGap(20, 20, 20)
                .addGroup(jp_colorcocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_gris)
                    .addComponent(jrb_verde))
                .addGap(20, 20, 20))
        );

        jp_extrascoche.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Extras del Coche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N

        jcb_extra1.setText("Instalación teléfono Bluetooth + MP3 + antena antirobo (8 altavoces en total)");
        jcb_extra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_extra1ActionPerformed(evt);
            }
        });

        jcb_extra2.setText("Conexión USB en apoyabrazos (elimina la conexión AUX-in)");

        jcb_extra3.setText("Conexión iPod en apoyabrazos (elimina la conexión AUX-in)");

        jcb_extra4.setText("<html>Portaobjetos interior en techo con pantalla TFT 7\" y conectores RCA<br>(Incompatible con iPod y USB)</html>");

        jcb_extra5.setText("Portaobjetos interior en techo");

        jcb_extra6.setText("<html>Asientos calefactados + eyectores calefactados + lavafaros + montante A calefactado<br>(+ retrovisores posicion parking solo en Reference)</html>");

        jcb_extra7.setText("<html>Sistema navegación blanco y negro + MP3 + antena antirrobo.<br>(Elimina la conexión AUX-in)</html>");

        jcb_extra8.setText("<html>SEAT Nediasystem: Sistema de navegación dinámica con pantalla táctil a color de 6,5\",<br>lector de DVD, disco duro de 30GB, conectividad Bluetooth y mandos en el volante.<br>(Incluye DVD con cartografía)</html>");

        jcb_extra9.setText("Airbags laterales posteriores");

        jcb_extra10.setText("Faros Bixenon + AFS");

        javax.swing.GroupLayout jp_extrascocheLayout = new javax.swing.GroupLayout(jp_extrascoche);
        jp_extrascoche.setLayout(jp_extrascocheLayout);
        jp_extrascocheLayout.setHorizontalGroup(
            jp_extrascocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_extrascocheLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jp_extrascocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_extra10)
                    .addComponent(jcb_extra9)
                    .addComponent(jcb_extra8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_extra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_extra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_extra5)
                    .addComponent(jcb_extra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_extra3)
                    .addComponent(jcb_extra2)
                    .addComponent(jcb_extra1))
                .addGap(20, 20, 20))
        );
        jp_extrascocheLayout.setVerticalGroup(
            jp_extrascocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_extrascocheLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jcb_extra1)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra2)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra3)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra5)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra9)
                .addGap(20, 20, 20)
                .addComponent(jcb_extra10)
                .addGap(20, 20, 20))
        );

        jta_visualizardatos.setEditable(false);
        jta_visualizardatos.setColumns(20);
        jta_visualizardatos.setRows(5);
        jScrollPane1.setViewportView(jta_visualizardatos);

        jl_fotomuestra.setText("Foto");

        javax.swing.GroupLayout jp_vistafotoLayout = new javax.swing.GroupLayout(jp_vistafoto);
        jp_vistafoto.setLayout(jp_vistafotoLayout);
        jp_vistafotoLayout.setHorizontalGroup(
            jp_vistafotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_vistafotoLayout.createSequentialGroup()
                .addComponent(jl_fotomuestra)
                .addContainerGap())
        );
        jp_vistafotoLayout.setVerticalGroup(
            jp_vistafotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_vistafotoLayout.createSequentialGroup()
                .addComponent(jl_fotomuestra)
                .addGap(284, 284, 284))
        );

        jMenu3.setText("File");

        jmi_nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmi_nuevo.setText("Nuevo...");
        jMenu3.add(jmi_nuevo);
        jMenu3.add(jSeparator1);

        jmi_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmi_guardar.setText("Guardar...");
        jMenu3.add(jmi_guardar);

        jmi_guardarcomo.setText("Guardar como...");
        jMenu3.add(jmi_guardarcomo);
        jMenu3.add(jSeparator2);

        jmi_salir.setText("Salir");
        jMenu3.add(jmi_salir);

        jmb_menuform.add(jMenu3);

        jMenu4.setText("Edit");
        jmb_menuform.add(jMenu4);

        setJMenuBar(jmb_menuform);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jp_modelcoche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_infoclient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_colorcoche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(jp_extrascoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20)
                        .addComponent(jt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jp_vistafoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(jb_generar)
                .addGap(50, 50, 50)
                .addComponent(jb_guardar)
                .addGap(100, 100, 100)
                .addComponent(jb_nuevo)
                .addGap(30, 30, 30)
                .addComponent(jb_salir)
                .addGap(450, 450, 450))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jp_vistafoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jp_infoclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jp_modelcoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jp_colorcoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jp_extrascoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_generar)
                    .addComponent(jb_guardar)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_salir))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_nomclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_nomclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_nomclienteActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        // TODO add your handling code here:

        //Resetea los datos de la aplicación
        reset_datos();
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jcb_extra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_extra1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_extra1ActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        // TODO add your handling code here:
        //Cierra la instacia
        dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_totalActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        // TODO add your handling code here:
        //Guarda los datos generados
        //guardarinfo();
        escribir2(jta_visualizardatos);

    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jb_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_generarActionPerformed
        // TODO add your handling code here:
        //Calculos
        calculos();
        //Después, todos los datos seleccionados se visualizan en un JTextArea
        info_datos();

    }//GEN-LAST:event_jb_generarActionPerformed

    private void jcb_modelcocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_modelcocheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_modelcocheActionPerformed

    private void jt_telfclientKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_telfclientKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_telfclientKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vistacoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vistacoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vistacoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vistacoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vistacoches().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_color;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton jb_generar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_salir;
    private javax.swing.JCheckBox jcb_extra1;
    private javax.swing.JCheckBox jcb_extra10;
    private javax.swing.JCheckBox jcb_extra2;
    private javax.swing.JCheckBox jcb_extra3;
    private javax.swing.JCheckBox jcb_extra4;
    private javax.swing.JCheckBox jcb_extra5;
    private javax.swing.JCheckBox jcb_extra6;
    private javax.swing.JCheckBox jcb_extra7;
    private javax.swing.JCheckBox jcb_extra8;
    private javax.swing.JCheckBox jcb_extra9;
    private javax.swing.JComboBox<String> jcb_modelcoche;
    private javax.swing.JLabel jl_fotomuestra;
    private javax.swing.JMenuBar jmb_menuform;
    private javax.swing.JMenuItem jmi_guardar;
    private javax.swing.JMenuItem jmi_guardarcomo;
    private javax.swing.JMenuItem jmi_nuevo;
    private javax.swing.JMenuItem jmi_salir;
    private javax.swing.JPanel jp_colorcoche;
    private javax.swing.JPanel jp_extrascoche;
    private javax.swing.JPanel jp_infoclient;
    private javax.swing.JPanel jp_modelcoche;
    private javax.swing.JPanel jp_vistafoto;
    private javax.swing.JRadioButton jrb_blanco;
    private javax.swing.JRadioButton jrb_gris;
    private javax.swing.JRadioButton jrb_negro;
    private javax.swing.JRadioButton jrb_rojoem;
    private javax.swing.JRadioButton jrb_rojoru;
    private javax.swing.JRadioButton jrb_verde;
    private javax.swing.JTextField jt_nomcliente;
    private javax.swing.JTextField jt_telfclient;
    private javax.swing.JTextField jt_total;
    private javax.swing.JTextArea jta_visualizardatos;
    // End of variables declaration//GEN-END:variables
}
