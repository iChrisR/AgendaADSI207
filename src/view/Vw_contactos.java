/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Ctr_Contactos;
import java.util.ArrayList;
import model.Mdl_Contactos;

/**
 *
 * @author dragnell
 */
public class Vw_contactos extends javax.swing.JDialog {

    ArrayList<Mdl_Contactos> listacont = new ArrayList();

    public Vw_contactos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
    }

    void guardarContacto() {
        Ctr_Contactos ctc = new Ctr_Contactos();
        Mdl_Contactos contac = new Mdl_Contactos();
        contac.setNombres(txt_nombre.getText());
        contac.setApellidos(txt_apellido.getText());
        contac.setTipo_contacto(cbx_tipoContacto.getSelectedItem().toString());
        contac.setEmail(txt_email.getText());
        contac.setAlias(txt_email.getText());
        contac.setAlias(txt_alias.getText());
        contac.setConEstado("1");
        contac.setEstado("1");
        contac.setFecha_importante(txt_fechaImportante.getText());
        contac.setTipo_fecha(txt_fechaImportante.getText());
        contac.setGrupo(txt_grupo.getText());
        contac.setRelacion(txt_relacion.getText());
        contac.setSitio_web(txt_sitioWeb.getText());
        if (rb_privado.isSelected())
        {
            contac.setVisibilidad("1");
        } else
        {
            contac.setVisibilidad("2");
        }
        ctc.ingresarContacto(contac);
        limpiarTabla();
        cargarTabla();
    }

    void limpiarTabla() {
        for (int p = 0; p < 100; p++)
        {
            tbl_contactos.setValueAt("", p, 0);
            tbl_contactos.setValueAt("", p, 1);
            tbl_contactos.setValueAt("", p, 2);
            tbl_contactos.setValueAt("", p, 3);
            tbl_contactos.setValueAt("", p, 4);
        }
    }

    void cargarTabla() {
        Ctr_Contactos ctc = new Ctr_Contactos();
        listacont = ctc.consultarContactos();
        for (int i = 0; i < listacont.size(); i++)
        {
            tbl_contactos.setValueAt(listacont.get(i).getIdcontacto(), i, 0);
            tbl_contactos.setValueAt(listacont.get(i).getNombres(), i, 1);
            tbl_contactos.setValueAt(listacont.get(i).getApellidos(), i, 2);
            tbl_contactos.setValueAt(listacont.get(i).getTipo_contacto(), i, 3);
            tbl_contactos.setValueAt(listacont.get(i).getAlias(), i, 4);
            tbl_contactos.setValueAt(listacont.get(i).getEmail(), i, 5);
        }
    }

    void mostrarContactos() {
        for (int i = 0; i < listacont.size(); i++)
        {
            if (tbl_contactos.getSelectedRow() == i)
            {
                txt_nombre.setText(listacont.get(i).getNombres());
                txt_apellido.setText(listacont.get(i).getApellidos());
                cbx_tipoContacto.setSelectedItem(listacont.get(i).getTipo_contacto());
                txt_alias.setText(listacont.get(i).getAlias());
                txt_email.setText(listacont.get(i).getEmail());
                txt_fechaImportante.setText(listacont.get(i).getFecha_importante());
                txt_grupo.setText(listacont.get(i).getGrupo());
                txt_relacion.setText(listacont.get(i).getRelacion());
                txt_sitioWeb.setText(listacont.get(i).getSitio_web());
                txt_tipoFecha.setText(listacont.get(i).getTipo_fecha());
                if (listacont.get(i).getVisibilidad().equals("1"))
                {
                    rb_publico.setSelected(false);
                    rb_privado.setSelected(true);

                } else
                {
                    rb_privado.setSelected(false);
                    rb_publico.setSelected(true);
                }
            }
        }
    }

    void limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        cbx_tipoContacto.setSelectedIndex(0);
        txt_alias.setText("");
        txt_email.setText("");
        txt_fechaImportante.setText("");
        txt_grupo.setText("");
        txt_relacion.setText("");
        txt_sitioWeb.setText("");
        txt_tipoFecha.setText("");
        rb_privado.setSelected(false);
        rb_publico.setSelected(false);
    }

    void modificarContacto() {
        Mdl_Contactos contac = new Mdl_Contactos();
        Ctr_Contactos ctc = new Ctr_Contactos();
        contac.setNombres(txt_nombre.getText());
        contac.setApellidos(txt_apellido.getText());
        contac.setTipo_contacto(cbx_tipoContacto.getSelectedItem().toString());
        contac.setEmail(txt_email.getText());
        contac.setAlias(txt_email.getText());
        contac.setAlias(txt_alias.getText());
        contac.setConEstado("1");
        contac.setEstado("1");
        contac.setFecha_importante(txt_fechaImportante.getText());
        contac.setTipo_fecha(txt_fechaImportante.getText());
        contac.setGrupo(txt_grupo.getText());
        contac.setRelacion(txt_relacion.getText());
        contac.setSitio_web(txt_sitioWeb.getText());
        if (rb_privado.isSelected())
        {
            contac.setVisibilidad("1");
        }else{
            contac.setVisibilidad("2");
        }
        ctc.actualizarContacto(contac, tbl_contactos.getSelectedRow()+1);
        limpiarTabla();
        cargarTabla();
        limpiar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_body = new javax.swing.JPanel();
        pnl_labels2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnl_labels1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl_textFiles1 = new javax.swing.JPanel();
        cbx_tipoContacto = new javax.swing.JComboBox<>();
        txt_alias = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_fechaImportante = new javax.swing.JTextField();
        pnl_textFiels2 = new javax.swing.JPanel();
        rb_publico = new javax.swing.JRadioButton();
        rb_privado = new javax.swing.JRadioButton();
        txt_tipoFecha = new javax.swing.JTextField();
        txt_grupo = new javax.swing.JTextField();
        txt_sitioWeb = new javax.swing.JTextField();
        txt_relacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_contactos = new javax.swing.JTable();
        pnl_botones = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo Fecha: ");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Grupo: ");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Relación: ");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Sitio Web: ");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Visibilidad: ");

        javax.swing.GroupLayout pnl_labels2Layout = new javax.swing.GroupLayout(pnl_labels2);
        pnl_labels2.setLayout(pnl_labels2Layout);
        pnl_labels2Layout.setHorizontalGroup(
            pnl_labels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_labels2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_labels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnl_labels2Layout.setVerticalGroup(
            pnl_labels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_labels2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Nombre");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Apellido");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tipo Contacto: ");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Email: ");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Alias: ");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha Importante: ");

        javax.swing.GroupLayout pnl_labels1Layout = new javax.swing.GroupLayout(pnl_labels1);
        pnl_labels1.setLayout(pnl_labels1Layout);
        pnl_labels1Layout.setHorizontalGroup(
            pnl_labels1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_labels1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_labels1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_labels1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnl_labels1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        pnl_labels1Layout.setVerticalGroup(
            pnl_labels1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_labels1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cbx_tipoContacto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contacto", "Familiar", "Amigo", "Empresarial", " " }));

        javax.swing.GroupLayout pnl_textFiles1Layout = new javax.swing.GroupLayout(pnl_textFiles1);
        pnl_textFiles1.setLayout(pnl_textFiles1Layout);
        pnl_textFiles1Layout.setHorizontalGroup(
            pnl_textFiles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textFiles1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_textFiles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_tipoContacto, 0, 223, Short.MAX_VALUE)
                    .addComponent(txt_fechaImportante)
                    .addComponent(txt_alias)
                    .addComponent(txt_email)
                    .addComponent(txt_nombre)
                    .addComponent(txt_apellido))
                .addContainerGap())
        );
        pnl_textFiles1Layout.setVerticalGroup(
            pnl_textFiles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textFiles1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx_tipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_alias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_fechaImportante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rb_publico.setText("publico");

        rb_privado.setText("Privado");

        javax.swing.GroupLayout pnl_textFiels2Layout = new javax.swing.GroupLayout(pnl_textFiels2);
        pnl_textFiels2.setLayout(pnl_textFiels2Layout);
        pnl_textFiels2Layout.setHorizontalGroup(
            pnl_textFiels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textFiels2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_textFiels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_textFiels2Layout.createSequentialGroup()
                        .addComponent(rb_publico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(rb_privado))
                    .addComponent(txt_grupo)
                    .addComponent(txt_sitioWeb)
                    .addComponent(txt_relacion)
                    .addComponent(txt_tipoFecha)))
        );
        pnl_textFiels2Layout.setVerticalGroup(
            pnl_textFiels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textFiels2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_tipoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_relacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_sitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_textFiels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_publico)
                    .addComponent(rb_privado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_contactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Nombre", "Apellido", "Tipo Contacto", "Alias", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_contactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_contactosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_contactos);

        btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_bodyLayout = new javax.swing.GroupLayout(pnl_body);
        pnl_body.setLayout(pnl_bodyLayout);
        pnl_bodyLayout.setHorizontalGroup(
            pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bodyLayout.createSequentialGroup()
                .addGroup(pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_bodyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_bodyLayout.createSequentialGroup()
                                .addComponent(pnl_labels1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl_textFiles1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl_labels2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl_textFiels2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(pnl_bodyLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_bodyLayout.setVerticalGroup(
            pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_textFiles1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_textFiels2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_labels2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_labels1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        guardarContacto();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        modificarContacto();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tbl_contactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_contactosMouseClicked
        mostrarContactos();
    }//GEN-LAST:event_tbl_contactosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Vw_contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Vw_contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Vw_contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Vw_contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vw_contactos dialog = new Vw_contactos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cbx_tipoContacto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_body;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_labels1;
    private javax.swing.JPanel pnl_labels2;
    private javax.swing.JPanel pnl_textFiels2;
    private javax.swing.JPanel pnl_textFiles1;
    private javax.swing.JRadioButton rb_privado;
    private javax.swing.JRadioButton rb_publico;
    private javax.swing.JTable tbl_contactos;
    private javax.swing.JTextField txt_alias;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fechaImportante;
    private javax.swing.JTextField txt_grupo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_relacion;
    private javax.swing.JTextField txt_sitioWeb;
    private javax.swing.JTextField txt_tipoFecha;
    // End of variables declaration//GEN-END:variables
}
