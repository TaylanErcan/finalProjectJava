package Helper;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMessage(String str) {
		String msg;
		switch(str) {
		case "fill":
			msg= "L�tfen t�m alanlar� doldurunuz.";
			break;
		case "success":
			msg="��lem ba�ar�l�";
			break;
		default:
			msg=str;
					
		}
		
		JOptionPane.showMessageDialog(null,msg,"Hata",JOptionPane.INFORMATION_MESSAGE);
	}
}
