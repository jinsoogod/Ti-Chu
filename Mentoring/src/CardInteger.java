

import java.util.ArrayList;

public class CardInteger {			// 스트링으로 되어있는 유저의 손패 배열을 족보 비교를 위해 int형으로 바꾸는 클래스
	public UserSet us = null;	
	
	public CardInteger(UserSet us) {
		this.us = us;
	}
	
	public int[][] cardInt (int index) {
		int[][] userCardInt = new int[2][13];
		int grim = 0;
		int num = 0;

		switch (index) {
		case 1:
			for (int i = 0 ; i < 13 ; i++ )	 {	
				switch	(us.user1.get(i).getCard().charAt(0)) {
				case '♠':
					grim = 1;
					break;
				case '◇':
					grim = 2;
					break;
				case '♡':
					grim = 3;	
					break;
				case '♣':
					grim = 4;
					break;
				}
				userCardInt[0][i] = grim;

				switch	(us.user1.get(i).getCard().charAt(1)) {
				case '2':
					num = 2;
					break;
				case '3':
					num = 3;
					break;
				case '4':
					num = 4;
					break;
				case '5':
					num = 5;
					break;
				case '6':
					num = 6;
					break;
				case '7':
					num = 7;
					break;
				case '8':
					num = 8;
					break;
				case '9':
					num = 9;
					break;
				case 'T':
					num = 10;
					break;
				case 'J':
					num = 11;
					break;
				case 'Q':
					num = 12;
					break;
				case 'K':
					num = 13;
					break;
				case 'A':
					num = 14;
					break;
				}
				userCardInt[1][i] = num;
			} // for
			break;

		case 2:
			for (int i = 0 ; i < 13 ; i++ )	 {	
				switch	(us.user2.get(i).getCard().charAt(0)) {
				case '♠':
					grim = 1;
					break;
				case '◇':
					grim = 2;
					break;
				case '♡':
					grim = 3;	
					break;
				case '♣':
					grim = 4;
					break;
				}
				userCardInt[0][i] = grim;

				switch	(us.user2.get(i).getCard().charAt(1)) {
				case '2':
					num = 2;
					break;
				case '3':
					num = 3;
					break;
				case '4':
					num = 4;
					break;
				case '5':
					num = 5;
					break;
				case '6':
					num = 6;
					break;
				case '7':
					num = 7;
					break;
				case '8':
					num = 8;
					break;
				case '9':
					num = 9;
					break;
				case 'T':
					num = 10;
					break;
				case 'J':
					num = 11;
					break;
				case 'Q':
					num = 12;
					break;
				case 'K':
					num = 13;
					break;
				case 'A':
					num = 14;
					break;
				}
				userCardInt[1][i] = num;
			} // for
			break;

		case 3:
			for (int i = 0 ; i < 13 ; i++ )	 {	
				switch	(us.user3.get(i).getCard().charAt(0)) {
				case '♠':
					grim = 1;
					break;
				case '◇':
					grim = 2;
					break;
				case '♡':
					grim = 3;	
					break;
				case '♣':
					grim = 4;
					break;
				}
				userCardInt[0][i] = grim;

				switch	(us.user3.get(i).getCard().charAt(1)) {
				case '2':
					num = 2;
					break;
				case '3':
					num = 3;
					break;
				case '4':
					num = 4;
					break;
				case '5':
					num = 5;
					break;
				case '6':
					num = 6;
					break;
				case '7':
					num = 7;
					break;
				case '8':
					num = 8;
					break;
				case '9':
					num = 9;
					break;
				case 'T':
					num = 10;
					break;
				case 'J':
					num = 11;
					break;
				case 'Q':
					num = 12;
					break;
				case 'K':
					num = 13;
					break;
				case 'A':
					num = 14;
					break;
				}
				userCardInt[1][i] = num;
			} // for
			break;

		case 4:
			for (int i = 0 ; i < 13 ; i++ )	 {	
				switch	(us.user4.get(i).getCard().charAt(0)) {
				case '♠':
					grim = 1;
					break;
				case '◇':
					grim = 2;
					break;
				case '♡':
					grim = 3;	
					break;
				case '♣':
					grim = 4;
					break;
				}
				userCardInt[0][i] = grim;

				switch	(us.user4.get(i).getCard().charAt(1)) {
				case '2':
					num = 2;
					break;
				case '3':
					num = 3;
					break;
				case '4':
					num = 4;
					break;
				case '5':
					num = 5;
					break;
				case '6':
					num = 6;
					break;
				case '7':
					num = 7;
					break;
				case '8':
					num = 8;
					break;
				case '9':
					num = 9;
					break;
				case 'T':
					num = 10;
					break;
				case 'J':
					num = 11;
					break;
				case 'Q':
					num = 12;
					break;
				case 'K':
					num = 13;
					break;
				case 'A':
					num = 14;
					break;
				}
				userCardInt[1][i] = num;
			} // for

			break;

		default:
			System.out.println("참여한 유저만 입력해주세요 ! (숫자 1~4)");
			break;
		}
		
		
		return userCardInt;
	}
}
