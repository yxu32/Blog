package util;

public class SearchInput {
	public String[] split(String str){
		String[] search = str.split(" ");
		String[] result = new String[2];
		if(search.length>=2) {
			result[0]=search[0];
			result[1]=search[1];
		}else {
			result[0]=search[0];
			result[1]=null;
		}
		return result;
	}
}
