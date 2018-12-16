
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Principal_Funcionario extends javax.swing.JFrame {
    
    RmiClient rmi;
    Consulta atual;

    public Principal_Funcionario() throws RemoteException {
        initComponents();
        rmi = new RmiClient();
        atual = rmi.getConsultaAtual();
        Iterator<Consulta> itConsulta = rmi.getConsultaHoje();
         DefaultTableModel model = (DefaultTableModel) this.tabela_consultasFuncionário.getModel();
         while(itConsulta.hasNext()){
             Consulta c = itConsulta.next();
             String[] linha = {c.getInicio().substring(0,11),c.getPaciente().getNome(),c.getProfissional().getNome(),c.getInicio().substring(11, 16)};
             model.addRow(linha);
         }
         
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    att();
                } catch (RemoteException ex) {
                    Logger.getLogger(Principal_Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 1000, 10000);
    }

    private void att() throws RemoteException{
        Iterator<Consulta> itConsulta = rmi.getConsultaHoje();
         DefaultTableModel model = (DefaultTableModel) this.tabela_consultasFuncionário.getModel();
         for(;model.getRowCount() != 0;)
            model.removeRow(0);
         while(itConsulta.hasNext()){
             Consulta c = itConsulta.next();
             String[] linha = {c.getInicio().substring(0,11),c.getPaciente().getNome(),c.getProfissional().getNome(),c.getInicio().substring(11, 16)};
             model.addRow(linha);
         }
        if(atual != null){
        String antiga = atual.getCodigo();
        try {
            String teste = rmi.getConsultaAtual().getCodigo();
            if(!antiga.equals(teste)){
                atual = rmi.getConsultaAtual();
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Atenção Iniciar nova consulta: Cliente "+atual.getPaciente().getNome()+" com o Médico "+atual.getProfissional().getNome() );
        }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_calendario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_consultasFuncionário = new javax.swing.JTable();
        separador = new javax.swing.JSeparator();
        desktop_funcionario = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_paciente = new javax.swing.JMenu();
        menu_cadastrarPaciente = new javax.swing.JMenuItem();
        menu_editarPaciente = new javax.swing.JMenuItem();
        menu_consulta = new javax.swing.JMenu();
        menu_agendarPaciente = new javax.swing.JMenuItem();
        menu_editarConsulta = new javax.swing.JMenuItem();
        menu_sobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_calendario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        tabela_consultasFuncionário.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabela_consultasFuncionário.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Paciente", "Médico(a)", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_consultasFuncionário.setMaximumSize(new java.awt.Dimension(450, 300));
        tabela_consultasFuncionário.setMinimumSize(new java.awt.Dimension(450, 300));
        tabela_consultasFuncionário.setName("consultas_calendario"); // NOI18N
        jScrollPane1.setViewportView(tabela_consultasFuncionário);

        javax.swing.GroupLayout panel_calendarioLayout = new javax.swing.GroupLayout(panel_calendario);
        panel_calendario.setLayout(panel_calendarioLayout);
        panel_calendarioLayout.setHorizontalGroup(
            panel_calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        panel_calendarioLayout.setVerticalGroup(
            panel_calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_calendarioLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        separador.setForeground(new java.awt.Color(255, 255, 255));
        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

        desktop_funcionario.setBackground(new java.awt.Color(0, 204, 204));
        desktop_funcionario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        desktop_funcionario.setName("FUNCIONÁRIO");

        javax.swing.GroupLayout desktop_funcionarioLayout = new javax.swing.GroupLayout(desktop_funcionario);
        desktop_funcionario.setLayout(desktop_funcionarioLayout);
        desktop_funcionarioLayout.setHorizontalGroup(
            desktop_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        desktop_funcionarioLayout.setVerticalGroup(
            desktop_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menu_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        menu_paciente.setText("Paciente");

        menu_cadastrarPaciente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menu_cadastrarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_add.png"))); // NOI18N
        menu_cadastrarPaciente.setText("Cadastrar");
        menu_cadastrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cadastrarPacienteActionPerformed(evt);
            }
        });
        menu_paciente.add(menu_cadastrarPaciente);

        menu_editarPaciente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menu_editarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_edit.png"))); // NOI18N
        menu_editarPaciente.setText("Editar/Pesquisar");
        menu_editarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_editarPacienteActionPerformed(evt);
            }
        });
        menu_paciente.add(menu_editarPaciente);

        jMenuBar1.add(menu_paciente);

        menu_consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/group.png"))); // NOI18N
        menu_consulta.setText("Consultas");

        menu_agendarPaciente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menu_agendarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/group_add.png"))); // NOI18N
        menu_agendarPaciente.setText("Agendar Paciente");
        menu_agendarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_agendarPacienteActionPerformed(evt);
            }
        });
        menu_consulta.add(menu_agendarPaciente);

        menu_editarConsulta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menu_editarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_edit.png"))); // NOI18N
        menu_editarConsulta.setText("Alterar Consulta");
        menu_editarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_editarConsultaActionPerformed(evt);
            }
        });
        menu_consulta.add(menu_editarConsulta);

        jMenuBar1.add(menu_consulta);

        menu_sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/information.png"))); // NOI18N
        menu_sobre.setText("Sobre");
        menu_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sobreActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu_sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop_funcionario))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_funcionario)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador))
            .addComponent(panel_calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* --------- SETANDO J INTERNAL FRAME --------- */
    private void menu_editarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_editarPacienteActionPerformed
        EditarPaciente telaEditarPaciente = new EditarPaciente(rmi);
        desktop_funcionario.add(telaEditarPaciente);
        telaEditarPaciente.setVisible(true);
    }//GEN-LAST:event_menu_editarPacienteActionPerformed

    private void menu_cadastrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cadastrarPacienteActionPerformed
    
        CadastrarPaciente telaCadastrarPaciente = new CadastrarPaciente(rmi);
        desktop_funcionario.add(telaCadastrarPaciente);
        telaCadastrarPaciente.setVisible(true);
        
    }//GEN-LAST:event_menu_cadastrarPacienteActionPerformed
    private void menu_agendarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_agendarPacienteActionPerformed
        AgendarPaciente telaAgendarPaciente = new AgendarPaciente(rmi);
        desktop_funcionario.add(telaAgendarPaciente);
        telaAgendarPaciente.setVisible(true);
    }//GEN-LAST:event_menu_agendarPacienteActionPerformed

    private void menu_editarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_editarConsultaActionPerformed
        AlterarConsulta telaAlterarConsulta = new AlterarConsulta(rmi);
        desktop_funcionario.add(telaAlterarConsulta);
        telaAlterarConsulta.setVisible(true);
    }//GEN-LAST:event_menu_editarConsultaActionPerformed

    private void menu_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sobreActionPerformed
        Sobre telaSobre = new Sobre();
        desktop_funcionario.add(telaSobre);
        telaSobre.setVisible(true);
    }//GEN-LAST:event_menu_sobreActionPerformed
    /* --------- FIM DO SETANDO J INTERNAL FRAME --------- */
    
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
            java.util.logging.Logger.getLogger(Principal_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal_Funcionario().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Principal_Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop_funcionario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menu_agendarPaciente;
    private javax.swing.JMenuItem menu_cadastrarPaciente;
    private javax.swing.JMenu menu_consulta;
    private javax.swing.JMenuItem menu_editarConsulta;
    private javax.swing.JMenuItem menu_editarPaciente;
    private javax.swing.JMenu menu_paciente;
    private javax.swing.JMenu menu_sobre;
    private javax.swing.JPanel panel_calendario;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tabela_consultasFuncionário;
    // End of variables declaration//GEN-END:variables
}
