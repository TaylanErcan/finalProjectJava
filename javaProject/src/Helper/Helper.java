package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
	
	public static void optionPaneChangeYesNoButtonText() {
		UIManager.put("OptionPane.cancelButtonText", "Ýptal");
		UIManager.put("OptionPane.noButtonText", "Hayýr");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
	}
	
	
	public static void showMessage(String str) {
		String msg;
		optionPaneChangeYesNoButtonText();
		switch(str) {
		case "fill":
			msg= "Lütfen tüm alanlarý doldurunuz.";
			break;
		case "success":
			msg="Ýþlem baþarýlý";
			break;
		default:
			msg=str;
					
		}
		
		JOptionPane.showMessageDialog(null,msg,"Hata",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean confirm(String str) {
		String message;
		optionPaneChangeYesNoButtonText();
		switch(str){
		case "sure":
			message="Bu iþlemi gerçekten yapmak istiyor musunuz?";
			break;
		default:
			message=str;
			break;
		}
		
		int result= JOptionPane.showConfirmDialog(null, message, "Dikkat!",JOptionPane.YES_NO_OPTION);	
		if(result==0) { // yes
			return true;
		}else { // no
			return false;
		}
	}
	
	
}
