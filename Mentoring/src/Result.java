
import java.util.Arrays;

public class Result {			// 	���� ���� �������� ������ ����� �����ֱ� ���� Ŭ����
	int userRankInt;
	String[] userRankStr = new String[4];		// Int������ ���� �������� String������ �����ϱ����� �迭
	int userCount;
	int[] cardRank = new int[4];				// �������� ������ ���ϱ����� int�� �迭 (cardRank[0] �� ����1�� ������ũ)
	boolean[] isTop = new boolean[4];			// ��� ������ Top ������ �Ǻ��ϱ����� boolean �迭
	
	// Int������ ���� ������ �����ֱ� ���� ResultŬ���� �� printRank �޼���
	public void printRank(int userRankInt, int userCount) {
		this.userRankInt = userRankInt;
		cardRank[userCount-1] = this.userRankInt;		// �ش� ������ cardRank[] �� Int������ ���� ������ �ִ´� (�������� ���� �񱳸� ����)
		switch (userRankInt) {
		case 8:	userRankStr[userCount-1] = "��Ʈ����Ʈ �÷���";	break;
		case 7:	userRankStr[userCount-1] = "�� ī��";			break;
		case 6:	userRankStr[userCount-1] = "��Ʈ����Ʈ";			break;
		case 5:	userRankStr[userCount-1] = "Ǯ �Ͽ콺";			break;
		case 4:	userRankStr[userCount-1] = "Ʈ����";			break;
		case 3:	userRankStr[userCount-1] = "���ӵ� ���";		break;
		case 2:	userRankStr[userCount-1] = "�� ���";			break;
		case 1:	userRankStr[userCount-1] = "�̱�";				break;
		}	//	 �ش� ������ ������ String �迭�� �����Ѵ�.
		
		//������ ī����� ������ ���
		System.out.printf("user%d�� ���� : %s \n", userCount,userRankStr[userCount-1]);
	}

	// �ѹ��� ( 1turn ) �� ����� �����ִ� turnResult �޼���
	public void turnResult() {
		int top = 0;
		for (int i = 0; i < isTop.length; i++) {	// trunResult �� ���ɶ����� isTop �� false�� �ʱ�ȭ
			isTop[i] = false;
		}
		System.out.println();
		
		System.out.println("### �̹� ���� ���  ###");
		for (int i = 0; i < cardRank.length; i++) {		// �� �������� ���� ���¸� ���� ���
			System.out.printf("user%d�� ���� : %s \n", i+1 , userRankStr[i]);
			if (cardRank[i] >= top) {	//���� ���� ������ top�̶�� ������ ����
				top = cardRank[i];	
			}
		}
		for (int i = 0; i < 4; i++) {	// user 1~4���� Ȯ���ؼ�
			if(cardRank[i] == top)		// top �� ������ ������ �ִ� ������
				isTop[i] = true;		// �� ������ �ش��ϴ� isTop �� ���� true�� 
		}
		
		System.out.print("���� ���� ������ �� ������  ");
		for (int i = 0; i < isTop.length; i++) {
			if (isTop[i] == true) {
				System.out.printf("user%d ", i+1);
			}
		}
		System.out.println("�Դϴ�. �ش� ������ �� ī��� ���п��� ���ŵ˴ϴ�.");
		System.out.println();
		
	}

	// �̱� ������ ī�带 ���п��� ����� ���� remove(�������� ���е�, �������� ������ �ε�����) �޼���
	public void remove(UserSet userset, int[] sel1Num, int[] sel2Num, int[] sel3Num, int[] sel4Num ) {
		// ������� 2,12�� �Է¹ްԵǸ�, ó���� 2��° ī�带 ����� �Ǹ� �ε����� 0~11�����ۿ� ��� 12��° ī�尡 �������� �ʰԵȴ�.
		// -> ū�ź��� ����� �ߴµ� ������ �Է��� ���ڰ� �� ���������� �ǹ̰���������
		// -> �Է¹��� ���ڹ迭���� �����ؾ��Ѵ�.
		int temp=0;		//	 �迭���� �����Ҷ� ����� �ӽ� ����
		
		for (int k = 0; k < isTop.length; k++) {		// ���� 1~4���� Ȯ���Ѵ�.
			if (isTop[k] == true) {						// ������� ������ ���� ������ ������
				switch (k) {					// �� �����鿡 ���� �� ������ ������ ī�� �ε����� �ٸ��� ������ switch ������ ����
				case 0:									//	user1 �̸�
					for (int i = 0; i < sel1Num.length; i++) {			// ������ sel1Num �迭�� ������������ �����ϱ����� �ݺ���
						for (int j = i; j < sel1Num.length; j++) {
							if(sel1Num[i] < sel1Num[j]) {
								temp = sel1Num[i];
								sel1Num[i] = sel1Num[j];
								sel1Num[j] = temp;
							}
						}
					}
					for (int i = 0; i < sel1Num.length; i++) {		//	sel1Num �� ���̸�ŭ �ݺ��Ǵ� remove 
						userset.user1.remove(sel1Num[i]);		//	���� ī�� ������� �����ȴ�.
					}
					System.out.println();
					break;
				case 1:										// user 2�̸� 
					for (int i = 0; i < sel2Num.length; i++) {					// ���� �ݺ�
						for (int j = i; j < sel2Num.length; j++) {
							if(sel2Num[i] < sel2Num[j]) {
								temp = sel2Num[i];
								sel2Num[i] = sel2Num[j];
								sel2Num[j] = temp;
							}
						}
					}
					for (int i = 0; i < sel2Num.length; i++) {
						userset.user2.remove(sel2Num[i]);
					}
					System.out.println();
					break;
				case 2:
					for (int i = 0; i < sel3Num.length; i++) {
						for (int j = i; j < sel3Num.length; j++) {
							if(sel3Num[i] < sel3Num[j]) {
								temp = sel3Num[i];
								sel3Num[i] = sel3Num[j];
								sel3Num[j] = temp;
							}
						}
					}
					for (int i = 0; i < sel3Num.length; i++) {
						userset.user3.remove(sel3Num[i]);
					}
					System.out.println();
					break;
				case 3:
					for (int i = 0; i < sel4Num.length; i++) {
						for (int j = i; j < sel4Num.length; j++) {
							if(sel4Num[i] < sel4Num[j]) {
								temp = sel4Num[i];
								sel4Num[i] = sel4Num[j];
								sel4Num[j] = temp;
							}
						}
					}
					for (int i = 0; i < sel4Num.length; i++) {
						userset.user4.remove(sel4Num[i]);
					}
					System.out.println();
					break;

				}
			}
		}
	}
	
}
