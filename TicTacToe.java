package Hello;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int masu[][]=new int[3][3];

		for(int y=0; y<3; y++) {
			for(int x=0; x<3; x++) {
				masu[x][y]=0;
			}
		}

		String mark[]= {" ","O","X"};
		Scanner sc=new Scanner(System.in);

		for(int turn=0; turn<9; turn++) {
			int player= turn%2+1;
			System.out.println("Player"+player+"の番です");
			System.out.println("-----------------------");

			int putX, putY;
			do {
				System.out.println("X座標を入力してください");
				putX = sc.nextInt();
				System.out.println("Y座標を入力してください");
				putY = sc.nextInt();
			}while(putX<0 || putY<0 || putX>3 || putY>3 || masu[putX][putY]!=0);
				masu[putX][putY]=player;

				//マス目をかく
				for(int y=0; y<3; y++) {
					String row="|";
					for(int x=0; x<3; x++) {
						row+=mark[masu[x][y]]+"|";
					}
					System.out.println(row);
				}

				//横に並んでいるか
				int tmp= 0;
				for(int x=0; x<3; x++) {
					if(masu[x][putY]==player)tmp++;
				}
				if (tmp==3)win(player);

				//縦に並んでいるか
				tmp= 0;
				for(int y=0; y<3; y++) {
					if(masu[putX][y]==player)tmp++;
				}
				if(tmp==3)win(player);

				// 斜めに並んでいるか
				tmp=0;
				for(int x=0; x<3; x++) {
					if(masu[x][x]==player)tmp++;
				}
				if(tmp==3)win(player);

				//斜めに並んでいるか
				for(int x=0; x<3; x++) {
					if(masu[x][2-x]==player)tmp++;
				}
				if(tmp==3)win(player);
			}
		System.out.println("引き分けです");
}

	private static void win(int player) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("player"+player+"の勝ちです");
		System.exit(0);
	}
}







