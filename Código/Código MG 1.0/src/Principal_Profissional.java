
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import static javafx.application.Platform.exit;
import javax.swing.table.DefaultTableModel;



public class Principal_Profissional extends javax.swing.JFrame {
    private IRede rede;
    private String nome;

    public Principal_Profissional(String nome) {
        initComponents();
        rede = new AdapterRede();
        this.nome = nome;
        Iterator<Consulta> it = rede.consulta(nome);
        DefaultTableModel model = (DefaultTableModel) this.tabela_consultasProfissional.getModel();
        while(it.hasNext()){
            Consulta c = it.next();
            String[] valor = {c.getInicio().substring(0, 11),c.getPaciente().getNome(),c.getInicio().substring(11, 16)};
            model.addRow(valor);
        }
        
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                att();
            }
        }, 1000, 10000);
    }
    
    private void att(){

        Iterator<Consulta> it = rede.consulta(nome);
        if(this.ordem_data.isSelected())
            it = new SortData().sort(it);
        if(this.ordem_nome.isSelected())
            it = new SortNome().sort(it);
        DefaultTableModel model = (DefaultTableModel) this.tabela_consultasProfissional.getModel();
        for(;model.getRowCount() != 0;)
            model.removeRow(0);
        while(it.hasNext()){
            Consulta c = it.next();
            String[] valor = {c.getInicio().substring(0, 11),c.getPaciente().getNome(),c.getInicio().substring(11, 16)};
            model.addRow(valor);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop_profissional = new javax.swing.JDesktopPane();
        panel_calendario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_consultasProfissional = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_exibir = new javax.swing.JMenu();
        ordem_data = new javax.swing.JCheckBoxMenuItem();
        ordem_nome = new javax.swing.JCheckBoxMenuItem();
        menu_consulta = new javax.swing.JMenu();
        menu_iniciarConsulta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop_profissional.setBackground(new java.awt.Color(0, 204, 204));
        desktop_profissional.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        javax.swing.GroupLayout desktop_profissionalLayout = new javax.swing.GroupLayout(desktop_profissional);
        desktop_profissional.setLayout(desktop_profissionalLayout);
        desktop_profissionalLayout.setHorizontalGroup(
            desktop_profissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        desktop_profissionalLayout.setVerticalGroup(
            desktop_profissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_calendario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        panel_calendario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        panel_calendario.setName("consultas"); // NOI18N

        tabela_consultasProfissional.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabela_consultasProfissional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Paciente", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_consultasProfissional.setMaximumSize(new java.awt.Dimension(450, 300));
        tabela_consultasProfissional.setMinimumSize(new java.awt.Dimension(450, 300));
        tabela_consultasProfissional.setName("consultas_calendario"); // NOI18N
        tabela_consultasProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_consultasProfissionalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_consultasProfissional);

        javax.swing.GroupLayout panel_calendarioLayout = new javax.swing.GroupLayout(panel_calendario);
        panel_calendario.setLayout(panel_calendarioLayout);
        panel_calendarioLayout.setHorizontalGroup(
            panel_calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        panel_calendarioLayout.setVerticalGroup(
            panel_calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_calendarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jMenuBar1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        menu_exibir.setText("Exibir");
        menu_exibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exibirActionPerformed(evt);
            }
        });

        ordem_data.setText("Ordem por Data");
        ordem_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordem_dataActionPerformed(evt);
            }
        });
        menu_exibir.add(ordem_data);

        ordem_nome.setText("Ordem por Nome");
        ordem_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordem_nomeActionPerformed(evt);
            }
        });
        menu_exibir.add(ordem_nome);

        jMenuBar1.add(menu_exibir);

        menu_consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/group.png"))); // NOI18N
        menu_consulta.setText("Consulta");
        menu_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_consultaActionPerformed(evt);
            }
        });

        menu_iniciarConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menu_iniciarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/group_add.png"))); // NOI18N
        menu_iniciarConsulta.setText("Iniciar Consulta");
        menu_iniciarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_iniciarConsultaActionPerformed(evt);
            }
        });
        menu_consulta.add(menu_iniciarConsulta);

        jMenuBar1.add(menu_consulta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel_calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop_profissional))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_profissional)
            .addComponent(panel_calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* --------- SETANDO J INTERNAL FRAME --------- */
    private void menu_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_consultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_consultaActionPerformed

    private void menu_iniciarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_iniciarConsultaActionPerformed
        IniciarConsulta telaIniciarConsulta = new IniciarConsulta(rede,nome);
        desktop_profissional.add(telaIniciarConsulta);
        telaIniciarConsulta.setVisible(true);
    }//GEN-LAST:event_menu_iniciarConsultaActionPerformed

    private void tabela_consultasProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_consultasProfissionalMouseClicked
        //Seleção na grid
        
    }//GEN-LAST:event_tabela_consultasProfissionalMouseClicked

    private void menu_exibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exibirActionPerformed
        this.setVisible(false);
        exit();
    }//GEN-LAST:event_menu_exibirActionPerformed

    private void ordem_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordem_nomeActionPerformed
        att();
    }//GEN-LAST:event_ordem_nomeActionPerformed

    private void ordem_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordem_dataActionPerformed
        att();
    }//GEN-LAST:event_ordem_dataActionPerformed

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
            java.util.logging.Logger.getLogger(Principal_Profissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_Profissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_Profissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_Profissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal_Profissional("Lucas").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop_profissional;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenu menu_consulta;
    private javax.swing.JMenu menu_exibir;
    private javax.swing.JMenuItem menu_iniciarConsulta;
    private javax.swing.JCheckBoxMenuItem ordem_data;
    private javax.swing.JCheckBoxMenuItem ordem_nome;
    private javax.swing.JPanel panel_calendario;
    private javax.swing.JTable tabela_consultasProfissional;
    // End of variables declaration//GEN-END:variables
}
