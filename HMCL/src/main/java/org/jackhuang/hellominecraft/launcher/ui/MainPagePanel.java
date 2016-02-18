/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hellominecraft.launcher.ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jackhuang.hellominecraft.util.C;
import org.jackhuang.hellominecraft.launcher.core.auth.IAuthenticator;
import org.jackhuang.hellominecraft.launcher.setting.Profile;
import org.jackhuang.hellominecraft.util.MessageBox;
import org.jackhuang.hellominecraft.util.StrUtils;
import org.jackhuang.hellominecraft.launcher.core.version.MinecraftVersion;
import org.jackhuang.hellominecraft.launcher.setting.Settings;
import org.jackhuang.hellominecraft.launcher.core.mod.ModpackManager;
import org.jackhuang.hellominecraft.launcher.core.service.IMinecraftService;
import org.jackhuang.hellominecraft.launcher.ui.modpack.ModpackWizard;
import org.jackhuang.hellominecraft.util.ui.GraphicsUtils;
import org.jackhuang.hellominecraft.util.Event;
import org.jackhuang.hellominecraft.lookandfeel.comp.ConstomButton;
import org.jackhuang.hellominecraft.util.func.Consumer;
import org.jackhuang.hellominecraft.util.system.FileUtils;
import org.jackhuang.hellominecraft.util.tasks.TaskWindow;
import org.jackhuang.hellominecraft.util.ui.SwingUtils;
import org.jackhuang.hellominecraft.util.ui.wizard.api.WizardDisplayer;

/**
 *
 * @author huangyuhui
 */
public class MainPagePanel extends AnimatedPanel {

    /**
     * Creates new form MainPagePanel
     */
    public MainPagePanel() {
        initComponents();

        pnlButtons = new javax.swing.JPanel();
        pnlButtons.setLayout(null);

        int w = 150, h = 50;
        btnRun = new ConstomButton();
        btnRun.setBounds(0, 0, w, h);
        Font font = btnRun.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), 15);
        pnlButtons.add(btnRun);

        btnRun.setText(C.i18n("ui.button.run"));
        btnRun.setFont(newFont);
        btnRun.addActionListener(e -> MainFrame.INSTANCE.daemon.runGame(Settings.getLastProfile()));

        this.add(pnlButtons);
        pnlButtons.setBounds(0, 0, w, h);

        this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.pnlButtons.setLocation(DEFAULT_WIDTH - pnlButtons.getWidth() - 25, DEFAULT_HEIGHT - pnlButtons.getHeight() - 25);
        pnlMore.setBounds(0, 0, pnlMore.getWidth(), DEFAULT_HEIGHT);
        pnlMore.setBackground(GraphicsUtils.getWebColorWithAlpha("FFFFFF7F"));
        pnlMore.setOpaque(true);

        Settings.getInstance().authChangedEvent.register(onAuthChanged);
        Settings.profileLoadingEvent.register(onLoadingProfiles);
        Settings.profileChangedEvent.register(onSelectedProfilesChanged);

        MainFrame.INSTANCE.daemon.customizedSuccessEvent = this::prepareAuths;

        prepareAuths();

        animationEnabled = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMore = new javax.swing.JPanel();
        txtPlayerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboLoginMode = new javax.swing.JComboBox();
        lblUserName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboProfiles = new javax.swing.JComboBox();
        lblVersion = new javax.swing.JLabel();
        cboVersions = new javax.swing.JComboBox();
        pnlPassword = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnImportModpack = new javax.swing.JButton();
        btnExportModpack = new javax.swing.JButton();

        setLayout(null);

        pnlMore.setBackground(new java.awt.Color(204, 204, 204));
        pnlMore.setOpaque(false);

        txtPlayerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlayerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlayerNameFocusLost(evt);
            }
        });
        txtPlayerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlayerNameKeyPressed(evt);
            }
        });

        jLabel7.setText(C.i18n("login.type")); // NOI18N

        cboLoginMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoginModeItemStateChanged(evt);
            }
        });

        lblUserName.setText(C.i18n("login.username")); // NOI18N

        jLabel10.setText(C.i18n("ui.label.profile")); // NOI18N

        cboProfiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProfilesItemStateChanged(evt);
            }
        });

        lblVersion.setText(C.i18n("ui.label.version")); // NOI18N
        lblVersion.setToolTipText(C.i18n("ui.label.version")); // NOI18N

        cboVersions.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVersionsItemStateChanged(evt);
            }
        });

        pnlPassword.setLayout(new java.awt.CardLayout());

        jLabel9.setText(C.i18n("ui.label.password")); // NOI18N

        txtPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPasswordCaretUpdate(evt);
            }
        });
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlPassword.add(jPanel1, "card2");

        btnLogout.setText(C.i18n("ui.button.logout")); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlPassword.add(jPanel3, "card3");

        btnImportModpack.setText(C.i18n("modpack.install.task")); // NOI18N
        btnImportModpack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportModpackActionPerformed(evt);
            }
        });

        btnExportModpack.setText(C.i18n("modpack.save.task")); // NOI18N
        btnExportModpack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportModpackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMoreLayout = new javax.swing.GroupLayout(pnlMore);
        pnlMore.setLayout(pnlMoreLayout);
        pnlMoreLayout.setHorizontalGroup(
            pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMoreLayout.createSequentialGroup()
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVersion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboProfiles, 0, 128, Short.MAX_VALUE)
                            .addComponent(cboVersions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlMoreLayout.createSequentialGroup()
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoginMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlayerName)))
                    .addComponent(btnExportModpack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImportModpack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMoreLayout.setVerticalGroup(
            pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVersions, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVersion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboLoginMode, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(btnImportModpack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportModpack)
                .addContainerGap())
        );

        add(pnlMore);
        pnlMore.setBounds(0, 0, 190, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlayerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlayerNameFocusGained
        MainFrame.INSTANCE.closeMessage();
    }//GEN-LAST:event_txtPlayerNameFocusGained

    private void txtPlayerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlayerNameFocusLost
        IAuthenticator l = Settings.getInstance().getAuthenticator();
        l.setUserName(txtPlayerName.getText());
    }//GEN-LAST:event_txtPlayerNameFocusLost

    private void cboLoginModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoginModeItemStateChanged
        if (evt.getStateChange() != ItemEvent.SELECTED)
            return;
        if (preparingAuth)
            return;
        Settings.getInstance().setLoginType(cboLoginMode.getSelectedIndex());
    }//GEN-LAST:event_cboLoginModeItemStateChanged

    private void cboProfilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProfilesItemStateChanged
        if (!isLoading && cboProfiles.getSelectedIndex() != -1 && !StrUtils.isBlank((String) cboProfiles.getSelectedItem()))
            Settings.getInstance().setLast((String) cboProfiles.getSelectedItem());
    }//GEN-LAST:event_cboProfilesItemStateChanged

    private void cboVersionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVersionsItemStateChanged
        if (isLoading || evt.getStateChange() != ItemEvent.SELECTED || cboVersions.getSelectedIndex() < 0 || StrUtils.isBlank((String) cboVersions.getSelectedItem()))
            return;
        String mcv = (String) cboVersions.getSelectedItem();
        Settings.getLastProfile().setSelectedMinecraftVersion(mcv);
    }//GEN-LAST:event_cboVersionsItemStateChanged

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        MainFrame.INSTANCE.closeMessage();
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        MainFrame.INSTANCE.daemon.runGame(Settings.getLastProfile());
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        if (preparingAuth)
            return;

        IAuthenticator l = Settings.getInstance().getAuthenticator();
        CardLayout cl = (CardLayout) pnlPassword.getLayout();
        if (l.isLoggedIn())
            l.logOut();
        cl.first(pnlPassword);
        pnlPassword.repaint();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtPlayerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayerNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            IAuthenticator l = Settings.getInstance().getAuthenticator();
            l.setUserName(txtPlayerName.getText());
            if (!l.hasPassword())
                MainFrame.INSTANCE.daemon.runGame(Settings.getLastProfile());
            else if (!l.isLoggedIn())
                txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtPlayerNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            MainFrame.INSTANCE.daemon.runGame(Settings.getLastProfile());
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnImportModpackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportModpackActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle(C.i18n("modpack.choose"));
        fc.setMultiSelectionEnabled(false);
        fc.setFileFilter(new FileNameExtensionFilter(C.i18n("modpack"), "zip"));
        fc.showOpenDialog(this);
        if (fc.getSelectedFile() == null)
            return;
        String suggestedModpackId = JOptionPane.showInputDialog("Please enter your favourite game name", FileUtils.getBaseName(fc.getSelectedFile().getName()));
        TaskWindow.factory().append(ModpackManager.install(fc.getSelectedFile(), Settings.getLastProfile().service(), suggestedModpackId)).create();
        Settings.getLastProfile().service().version().refreshVersions();
    }//GEN-LAST:event_btnImportModpackActionPerformed

    private void btnExportModpackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportModpackActionPerformed
        if (Settings.getLastProfile().service().version().getVersionCount() <= 0)
            return;
        WizardDisplayer.showWizard(new ModpackWizard(Settings.getLastProfile()).createWizard());
    }//GEN-LAST:event_btnExportModpackActionPerformed

    private void txtPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPasswordCaretUpdate
        Settings.getInstance().getAuthenticator().setPassword(txtPassword.getText());
    }//GEN-LAST:event_txtPasswordCaretUpdate

    // <editor-fold defaultstate="collapsed" desc="Loads">
    private void prepareAuths() {
        preparingAuth = true;
        cboLoginMode.removeAllItems();
        for (IAuthenticator str : IAuthenticator.LOGINS)
            cboLoginMode.addItem(str.getName());
        preparingAuth = false;
        int loginType = Settings.getInstance().getLoginType();
        if (0 <= loginType && loginType < cboLoginMode.getItemCount()) {
            cboLoginMode.setSelectedIndex(loginType);
            Settings.getInstance().setLoginType(loginType);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Private Variables">
    boolean preparingAuth = true;
    private boolean isLoading = false;
    private final javax.swing.JPanel pnlButtons;
    private final ConstomButton btnRun;
    private static final int DEFAULT_WIDTH = 800, DEFAULT_HEIGHT = 480;
    //</editor-fold>

    @Override
    public void onCreated() {
        super.onCreated();
        Settings.onProfileLoading();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportModpack;
    private javax.swing.JButton btnImportModpack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox cboLoginMode;
    private javax.swing.JComboBox cboProfiles;
    private javax.swing.JComboBox cboVersions;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel pnlMore;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables

    final Event<IAuthenticator> onAuthChanged = (sender, l) -> {
        if (l.hasPassword()) {
            pnlPassword.setVisible(true);
            lblUserName.setText(C.i18n("login.account"));
        } else {
            pnlPassword.setVisible(false);
            lblUserName.setText(C.i18n("login.username"));
        }

        CardLayout cl = (CardLayout) pnlPassword.getLayout();
        if (l.isLoggedIn())
            cl.last(pnlPassword);
        else
            cl.first(pnlPassword);
        String username = l.getUserName();
        if (username == null)
            username = "";
        txtPlayerName.setText(username);

        return true;
    };

    final Runnable onLoadingProfiles = this::loadProfiles;

    private void loadProfiles() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Profile s : Settings.getProfilesFiltered())
            model.addElement(s.getName());
        cboProfiles.setModel(model);
    }

    final Consumer<IMinecraftService> onRefreshedVersions = t -> {
        if (Settings.getLastProfile().service() == t)
            loadVersions();
    };

    boolean showedNoVersion = false;

    void loadVersions() {
        isLoading = true;
        cboVersions.removeAllItems();
        String selVersion = Settings.getLastProfile().getSelectedVersion();
        if (Settings.getLastProfile().service().version().getVersions().isEmpty()) {
            if (!showedNoVersion)
                SwingUtilities.invokeLater(() -> {
                    if (MessageBox.Show(C.i18n("mainwindow.no_version"), MessageBox.YES_NO_OPTION) == MessageBox.YES_OPTION)
                        MainFrame.INSTANCE.invokeAction("showGameDownloads");
                    showedNoVersion = true;
                });
        } else {
            for (MinecraftVersion mcVersion : Settings.getLastProfile().service().version().getVersions()) {
                if (mcVersion.hidden)
                    continue;
                cboVersions.addItem(mcVersion.id);
            }
            versionChanged.accept(selVersion);
        }
        isLoading = false;
    }

    final Consumer<Boolean> launchingStateChanged = t -> SwingUtils.setEnabled(MainFrame.INSTANCE.getRootPane(), !t);

    final Consumer<String> versionChanged = this::versionChanged;

    void versionChanged(String selectedVersion) {
        isLoading = true;
        ((DefaultComboBoxModel) cboVersions.getModel()).setSelectedItem(selectedVersion);
        cboVersions.setToolTipText(selectedVersion);
        isLoading = false;
    }

    final Consumer<Profile> onSelectedProfilesChanged = t -> {
        t.service().version().onRefreshedVersions.register(onRefreshedVersions);
        t.selectedVersionChangedEvent.register(versionChanged);
        t.launcher().launchingStateChanged.register(launchingStateChanged);

        ((DefaultComboBoxModel) cboProfiles.getModel()).setSelectedItem(t.getName());
    };
}
