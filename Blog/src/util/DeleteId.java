package util;

public class DeleteId {
	public String delete(String[] list, String id) {
		String newString = "";
		int i = list.length-1;
		for(String str: list) {
			if(str!=id && i!=0) {
				newString = newString + str + ",";
				i-=1;
			}else if(str!=id && i==0) {
				newString = newString +str;
			}else {
				
			}
		}
		return newString;
	}
}
