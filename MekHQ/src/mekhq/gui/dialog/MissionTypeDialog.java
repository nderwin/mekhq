/*
 * MissionTypeDialog.java
 *
 * Created on Jan 6, 2010, 10:46:02 PM
 */

package mekhq.gui.dialog;

import java.awt.Frame;
import java.util.ResourceBundle;

import megamek.common.util.EncodeControl;
import mekhq.campaign.Campaign;
import mekhq.gui.CampaignGUI;

/**
 *
 * @author natit
 */
public class MissionTypeDialog extends javax.swing.JDialog {

	private Campaign campaign;
	private CampaignGUI hqview;
	private Frame frame;
	
	private static final long serialVersionUID = 8376874926997734492L;
	/** Creates new form */
    public MissionTypeDialog(java.awt.Frame parent, boolean modal, Campaign c, CampaignGUI view) {
        super(parent, modal);
        frame = parent;
        this.campaign = c;
        this.hqview = view;
        initComponents();      
        this.setLocationRelativeTo(parent);
    }

    private void initComponents() {

        ResourceBundle resourceMap = ResourceBundle.getBundle("mekhq.resources.MissionTypeDialog", new EncodeControl()); //$NON-NLS-1$

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setTitle(resourceMap.getString("Form.title"));
        
        getContentPane().setLayout(new java.awt.GridLayout(2,1));
      
        btnMission = new javax.swing.JButton(resourceMap.getString("btnMission.text"));
        btnMission.setToolTipText(resourceMap.getString("btnMission.tooltip"));
        btnMission.setName("btnMission"); // NOI18N
        btnMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMission();
            }
        });
        getContentPane().add(btnMission);
        
        btnContract = new javax.swing.JButton(resourceMap.getString("btnContract.text"));
        btnContract.setToolTipText(resourceMap.getString("btnContract.tooltip"));
        btnContract.setName("btnContract"); // NOI18N
        btnContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newContract();
            }
        });
        getContentPane().add(btnContract);

        setSize(250, 150);
    }
    
    private void newMission() {
    	CustomizeMissionDialog cmd = new CustomizeMissionDialog(frame, true, null, campaign);
    	new CustomizeMissionDialog(frame, true, null, campaign);
		cmd.setVisible(true);
		this.setVisible(false);
		if(cmd.getMissionId() != -1) {
			hqview.selectedMission = cmd.getMissionId();
		}
		hqview.refreshMissions();
    }
    
    private void newContract() {
    	NewContractDialog ncd = campaign.getCampaignOptions().getUseAtB()?
    			new NewAtBContractDialog(frame, true, campaign):
    			new NewContractDialog(frame, true, campaign);
		ncd.setVisible(true);
		this.setVisible(false);
		if(ncd.getContractId() != -1) {
			hqview.selectedMission = ncd.getContractId();
		}
		hqview.refreshMissions();
		hqview.refreshFinancialTransactions();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMission;
    private javax.swing.JButton btnContract;
    // End of variables declaration//GEN-END:variables

}
