
public class UserCardRank {
	int[][] userCardInt = null;							// ������ int�� ī��迭�� ���� �Լ�
	String rankResult = null; 
	int userRankResult = 0;	
	boolean[][] userCardBool = new boolean[4][13];		// ���� Ȯ���� ����  boolean[][] 2���� �迭.
	int[] numMatch = new int[13];						//	�� ���ϱ� ���� �迭 
	int[] rankNum = new int[4];							// index 0,1,2,3 (user1,2,3,4) �� 8 ���� ������ ������ ���� �迭 (����)
	String[] userRankStr = new String[4];
	int[] selNum;										//	������ �Է��� ī�� ��ȣ
	int userNum;
	
	public UserCardRank(int[][] userCardInt) {
		this.userCardInt = userCardInt;
	}
	
	// ������ ī����� ������ �����ִ� userSelect(�������ε�����);
	public int userSelect(int[] selNum) {
		this.selNum = selNum;
		
		userRankResult = rankMatch();
		return userRankResult;
	}
	
	public int rankMatch() {
		int grim = 0, num = 0;
		int pairCount = 0, tripleCount = 0, fourCount = 0;		// �������� ���,Ʈ����,��ī�带 ã������ ����
		int straightCount = 0,straightFlushCount = 0;			// ��Ʈ����Ʈ, ��Ʈ����Ʈ�÷����� ã������ ����
		int sel = 0;											// ������ �Է��� �ε����� �ϳ��� ������ ����
		for (int i = 0; i < selNum.length; i++) {
			sel = selNum[i];
			grim = userCardInt[0][sel];
			num = userCardInt[1][sel];
			userCardBool[grim-1][num-2] = true;
		}
		
		/* ���� ������ ���� boolean 2���� �迭
		 * 52���� ĭ�� ������ ������ �п� �ش��ϴ� ���� true ������ �ٲ۴�.
		 * 
				  		y = ī�� 2~A �� 0 ~ 12 �� �ش��Ѵ�.
				 	xy	0	1	2	3	4	5	6	7	8	9	10	11	12
		x	�����̵� 	0 	0	1	0	0	0	1	1	0	1	0	0	0	0
			���̾� 	1	0	0	1	0	1	0	1	0	0	0	0	0	1
			��Ʈ		2	0	0	0	0	0	0	0	0	0	1	0	1	0
			Ŭ�ι� 	3	0	0	0	1	0	0	1	0	0	0	0	0	1
		 				��-- numMatch[0] = 0		��-- numMatch[6] = 3		��-- numMatch[12] = 2
		
				numMatch[i] �迭�� i�� �ش��ϴ� ������ ī�带 �����̳� ������ �ִ����� �Ǻ��Ѵ�.
		 */
		for (int i = 0; i < 13; i++) {
			if(userCardBool[0][i] == true) ++numMatch[i];
			if(userCardBool[1][i] == true) ++numMatch[i];
			if(userCardBool[2][i] == true) ++numMatch[i];
			if(userCardBool[3][i] == true) ++numMatch[i];
			if(numMatch[i] == 2) {
				++pairCount;		// 2���� ������������ ��� ī��Ʈ++
			}else if (numMatch[i] == 3) {
				++tripleCount;		//	3���� ������ ������ Ʈ���� ī��Ʈ ++
			}else if (numMatch[i] == 4) {
				++fourCount;		// 	4���� ������ ������ ��ī�� ī��Ʈ ++
			} 
		}
			// numMatch[i] �� numMatch[i+1] �� ���ؼ� �Ѵ� 1�̻��̸� ( �ش� ī�带 �����̻� ������ ������) count++ ��Ű��, 
			// ��� �ϳ��� 0 �̸� ( ���ӵ� ī�带 ������ ���� ������ ) count = 0���� �Ͽ� �ٽ� ó������ count�� ����.
			// ���� count �� 4�̻��̸� ( ���ӵ� ���ڰ� 5�� �̻��̸�) ��Ʈ����Ʈ ī��Ʈ�� count�� �ȴ� (���ӵȼ����� ī�尡 ��������)
		int count = 0;
		for (int i = 0; i < 11; i++) {
			
			if (numMatch[i]>=1 && numMatch[i+1]>=1) {
				++count;
			}
			else count = 0;		
			if(count >= 4) {
				straightCount = count + 1;
			}
		}
		
		// ��Ʈ����Ʈ�÷����� 6�� �̻����� ã�� ����� �������� ����
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				if(userCardBool[i][j]
					&& userCardBool[i][j+1]
					&& userCardBool[i][j+2]
					&& userCardBool[i][j+3]
					&& userCardBool[i][j+4]) {
					++straightFlushCount;
				}
			}
		}
		
		
		// ������������ ���� ����
		
		int cardRankInt=0;	// ������ int������ ��� ���� ����
		
		if(straightFlushCount >= 1){	// ��Ʈ����Ʈ�÷���ī��Ʈ�� 1�̻��̸� ��Ʈ����Ʈ �÷���
			cardRankInt=8;
		}else if (fourCount >= 1){		// ��ī�� ī��Ʈ�� 1�̻��̸� ��ī��
			cardRankInt=7;
		}else if(straightCount >= 1) {		//	��Ʈ����Ʈī��Ʈ�� 1�̻��̸�  ��Ʈ����Ʈ
			cardRankInt=6;
		}else if (pairCount >= 1 && tripleCount >= 1) {	// ���ī��Ʈ�� 1�̻��̰� Ʈ���� ī��Ʈ�� 1�̻��̸� Ǯ�Ͽ콺
			cardRankInt=5;
		}else if (tripleCount >= 1) {	// tripleCount�� 1�̻��̸� Ʈ����
			cardRankInt=4;
		}else if (pairCount >= 2) {		//	pairCount�� 2�̻��̸� ���ӵ� ���
			cardRankInt=3;
		}else if (pairCount == 1) {		// pairCount�� 1�̸� �� ���
			cardRankInt=2;
		}else {
			cardRankInt=1;			// 	�ƹ��͵� ������ �̱�
		}
			// �ϳ��� �ش���� ������ (������ ������ �̱�)
		
		return cardRankInt;	
	}
}
