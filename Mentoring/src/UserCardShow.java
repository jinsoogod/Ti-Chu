
public class UserCardShow {
//	플레이어 1의 소유카드 출력(); UserCardShow(userset, 0~4) => 인덱스에 해당하는 유저의 소유카드 출력 (0이면 전부)
	UserSet us;
	int index;
	int i=0;
	
	public UserCardShow(UserSet us) {
		this.us = us;
	}
	
	public void userSelect(int index) {
		this.index = index;
		
		switch (index) {
		case 0:				// 0일때 모든유저의 카드를 출력
			System.out.print("user1 의 카드들 : ");
			for (Card c : us.user1) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			
			System.out.println();
			
			System.out.print("user2 의 카드들 : ");
			for (Card c : us.user2) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();

			us.user3.get(0);
			System.out.print("user3 의 카드들 : ");
			for (Card c : us.user3) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();


			us.user4.get(0);
			System.out.print("user4 의 카드들 : ");
			for (Card c : us.user4) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();


			break;

		case 1:
			System.out.print("user1 의 카드들 : ");
			for (Card c : us.user1) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();
			break;

		case 2:
			System.out.print("user2 의 카드들 : ");
			for (Card c : us.user2) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();
			break;

		case 3:
			
			System.out.print("user3 의 카드들 : ");
			for (Card c : us.user3) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();
			break;

		case 4:
			System.out.print("user4 의 카드들 : ");
			for (Card c : us.user4) {
				System.out.print("[" + i + "] ");
				System.out.print(c.getCard());
				System.out.print("   ");
				i++;
			}	i=0;
			System.out.println();
			break;

		default:
			System.out.println("전체출력 : 0 , 유저 1 : 1 , 유저 2 : 2 , 유저 3 : 3 , 유저 4 : 4");
			break;
		}
	}

	public void handCardSelect(int[] selNum,int userCount) {
		
		for (int i = 0; i < selNum.length; i++) {
			int sel = selNum[i];
			switch (userCount) {
			case 1:
				System.out.print(us.user1.get(sel).getCard()+"\t");
				break;
			case 2:
				System.out.print(us.user2.get(sel).getCard()+"\t");
				break;
			case 3:
				System.out.print(us.user3.get(sel).getCard()+"\t");
				break;
			case 4:
				System.out.print(us.user4.get(sel).getCard()+"\t");
				break;
			}
		}
	}
}
