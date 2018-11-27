package test;

import service.RelationService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RelationService rsv =new RelationService();
		int[] list = rsv.getFollows(9);
		for(int i : list) {
			System.out.print(i);
			System.out.println("1");
		}
	}

}
