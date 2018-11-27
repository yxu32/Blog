package util;

public class SqlString {
	public String decode(String str) {
		String afterDecode = str.replaceAll("\\\\", "\\\\\\\\");
		afterDecode = afterDecode.replaceAll("'", "\\\\'");
		afterDecode = afterDecode.replaceAll("%", "\\\\%");
		afterDecode = afterDecode.replaceAll("_", "\\\\_");
		return afterDecode;
	}
}
