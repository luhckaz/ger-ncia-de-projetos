
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;


public class IniciarConsulta extends javax.swing.JInternalFrame {

    private IRede rede;
    private Consulta atual;
    private String medico;

    public IniciarConsulta(IRede rede,String medico) {
        this.rede = rede;
        this.medico = medico;
        initComponents();
    }
    
    public IniciarConsulta(IRede rede,String medico,Consulta c) {
        this.rede = rede;
        this.medico = medico;
        this.atual = c;
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_iniciarConsulta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_nome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto_descricao = new javax.swing.JTextArea();
        botao_salvar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Iniciar Consulta");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Nome do Paciente:");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESCRIÇÃO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        texto_descricao.setColumns(20);
        texto_descricao.setLineWrap(true);
        texto_descricao.setRows(5);
        jScrollPane2.setViewportView(texto_descricao);

        botao_salvar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        botao_salvar.setText("Salvar");
        botao_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(botao_salvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_salvar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_iniciarConsultaLayout = new javax.swing.GroupLayout(panel_iniciarConsulta);
        panel_iniciarConsulta.setLayout(panel_iniciarConsultaLayout);
        panel_iniciarConsultaLayout.setHorizontalGroup(
            panel_iniciarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_iniciarConsultaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(panel_iniciarConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_iniciarConsultaLayout.setVerticalGroup(
            panel_iniciarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_iniciarConsultaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel_iniciarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_iniciarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_iniciarConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Iterator<Consulta> it = rede.buscarConsulta(this.text_nome.getText(),medico);
            List<String> datas = new ArrayList<>();
            while(it.hasNext())
                datas.add(it.next().getInicio());
            Object[] d = new String[datas.size()];
            for(int i = 0;i < datas.size();i++)
                d[i] = datas.get(i);
            Object escolha = JOptionPane.showInputDialog(null,
                                "Escolha a data",
                                "Escolha a data",
                                JOptionPane.PLAIN_MESSAGE,
                                null,d,"Escolha a data");
            it = rede.buscarConsulta(this.text_nome.getText(),medico);
            while(it.hasNext()){
                Consulta aux = it.next();
                if(aux.getInicio().equals((String) escolha))
                    atual = aux;
            }
            this.texto_descricao.setText(rede.getDescricao(atual));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botao_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_salvarActionPerformed
        if(atual != null){
            String texto = this.texto_descricao.getText();
            rede.addDescricao(atual, texto);
            JOptionPane.showMessageDialog(null, "Inserido descrição" );
        }else{
            JOptionPane.showMessageDialog(null, "Erro de cadastro" );
        }
    }//GEN-LAST:event_botao_salvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_salvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_iniciarConsulta;
    private javax.swing.JTextField text_nome;
    private javax.swing.JTextArea texto_descricao;
    // End of variables declaration//GEN-END:variables
}
