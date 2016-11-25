
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameStart {			

	public static final int USERNUM = 4;
	public static final int CARDNUM = 13;		//�Ѹ�� ���� ī�� ���
	public UserSet userset = null;
	int[][] user1CardInt, user2CardInt, user3CardInt, user4CardInt;
	
	
	public void setting() {		//���ӽ����� ī��� ������ ������ �������� ī�带 �й�.

//		ī�弯��();
		CardCase cc = new CardCase();
		ArrayList<Card> list = cc.getCards();
		
//		��������();		4��
		userset = new UserSet();
		
//		�������׹�� CardShare(ī�����̽�, ������, ī�����)
		CardShare cs = new CardShare(list, userset, CARDNUM);
		cs.shareToUser();
		
		/* ��Ʈ������ �� ī�带 Int������ �ٲٴ� CardInteger
		 		y  = ���� ī���� �ε��� 0~12
				xy 0  1  2  3  4  5  6  7  8  9  10  11 12 
		x   ����	0  1  2  1  3  1  4  2  3  4  2   1   3  2		������ �����̽�,���̾�,��Ʈ,Ŭ�ι��� 1~4  
		         ����	1  5  8  4  10 12 9  9  8  6  2  14  13 14		���ڴ� 2���� A�� 2~14		
		*/
		CardInteger cardInt = new CardInteger(userset);
		user1CardInt = cardInt.cardInt(1);
		user2CardInt = cardInt.cardInt(2);
		user3CardInt = cardInt.cardInt(3); 
		user4CardInt = cardInt.cardInt(4);
		
		
	}
	public void go() {		// �ݺ��ؼ� ������ �������� ���� �÷��� �ڵ��
		
		//���° ������ �������� �ľ��ϱ����� Count
		int userCount=1;
		
		//�÷��̾� 1�� ����ī�� ���(); userSelect(0~4) => �ε����� �ش��ϴ� ������ ����ī�� ��� (0�̸� ����, 1�̸� ����1�� ī�� ���)
		UserCardShow userCardShow = new UserCardShow(userset);
		userCardShow.userSelect(0);
		System.out.println("\n");
		
		// ī�� ���� �Է�
		Scanner sc = new Scanner(System.in);
		UserCardRank userCR = null;
		int userRankInt = 0;
		
		//��� ȭ���� ������ Result Ŭ����
		Result result = new Result();
		
		// ���� 1~4�� ������ ī�� �ε����� ������ int �迭
		int[] sel1Num = null, sel2Num = null, sel3Num = null, sel4Num = null;
		
		// �ݺ������� ������ ����ȭ��
		while(true){
			userCardShow.userSelect(userCount);
			System.out.println("user "+userCount+" �� ī��� �� ������� ī���� ���ڸ� ,�� ������ �������ּ���.");
			System.out.print("���� : ");
			String sel = sc.next();
			// , ������ ���� ��ũ������
			StringTokenizer st = new StringTokenizer(sel, ",");
			// ������ ��� �ε����� �Է��߳��� �����ϴ� ����
			int tokenCount = st.countTokens();
			// �Է¹��� �ε������� int[i] �迭�� �����Ѵ�.
			int[] selNum = new int[tokenCount];
			for (int j = 0; st.hasMoreTokens(); j++) {
				selNum[j] = Integer.parseInt(st.nextToken());
			}
			
			// ������ �ε����� �ش��ϴ� ī����� ���
			userCardShow.handCardSelect(selNum,userCount);
			System.out.println();
			
			
			// ���° ������ ���������� ���� �ش� ������ ������ ī�� user1~4CardInt �� �ν���Ʈ�� �ϴ� UserCardRank �� ����
			// ���� �ش� ������ ������ �ε����迭���� sel 1~4 Num �迭�� ���� ����. (�ش� ī����� �迭���� �����Ҷ� ���� ����)
			switch (userCount) {					
			case 1:	userCR = new UserCardRank(user1CardInt);	sel1Num = new int[selNum.length];
				for (int i = 0; i < selNum.length; i++) {
					sel1Num[i] = selNum[i];
				}
			break;
			case 2:	userCR = new UserCardRank(user2CardInt);	sel2Num = new int[selNum.length];
				for (int i = 0; i < selNum.length; i++) {
					sel2Num[i] = selNum[i];
				}
			break;
			case 3:	userCR = new UserCardRank(user3CardInt);	sel3Num = new int[selNum.length];
				for (int i = 0; i < selNum.length; i++) {
					sel3Num[i] = selNum[i];
				}
			break;
			case 4:	userCR = new UserCardRank(user4CardInt);	sel4Num = new int[selNum.length];
				for (int i = 0; i < selNum.length; i++) {
					sel4Num[i] = selNum[i];
				}
			break;
			}
			// ������ ī����� ������ �����ִ� userSelect(�������ε�����);
			// �ش��ϴ� ������ Int������ (������������� 8, ���峷�������� 1) �� ���Ϲ޾� userRankInt�� �����Ѵ�.
			userRankInt = userCR.userSelect(selNum);
			
			// Int������ ���� ������ �����ֱ� ���� ResultŬ���� �� printRank �޼���
			result.printRank(userRankInt, userCount);
			System.out.println();
			
			
			// ���� 1~4���� �ѹ����� ��� ���Ҵٸ�
			if(userCount==4) {
				// �ѹ��� ( 1turn ) �� ����� �����ִ� turnResult �޼���
				result.turnResult();
				// �׸��� �̱� ������ ī�带 ���п��� ����� ���� remove(�������� ���е�, �������� ������ �ε�����) �޼���
				result.remove(userset, sel1Num, sel2Num, sel3Num, sel4Num);
				// �ٽ� ī��Ʈ 1���� ����.
				userCount = 1;
			} else userCount++;		//	���� �ѹ����� ���� �ʾҴٸ� ī��Ʈ++;
			
			if(userset.user1.isEmpty()==true) {		//	 ���� 1�� ���а� ����ٸ�
				System.out.println("################");
				System.out.println("user1�� �¸��Ͽ����ϴ�.");
				System.out.println("################");
				break;
			}
			else if (userset.user2.isEmpty()==true) {	//	 ���� 2�� ���а� ����ٸ�
				System.out.println("################");
				System.out.println("user2�� �¸��Ͽ����ϴ�.");
				System.out.println("################");
				break;
			}
			else if (userset.user3.isEmpty()==true) {	//	 ���� 3�� ���а� ����ٸ�
				System.out.println("################");
				System.out.println("user3�� �¸��Ͽ����ϴ�.");
				System.out.println("################");
				break;
			}	
			else if (userset.user4.isEmpty()==true) {	//	 ���� 4�� ���а� ����ٸ�
				System.out.println("################");
				System.out.println("user4�� �¸��Ͽ����ϴ�.");
				System.out.println("################");
				break;
			}
		} // while��
	}
}
