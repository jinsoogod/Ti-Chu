
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameStart {			

	public static final int USERNUM = 4;
	public static final int CARDNUM = 13;		//한명당 가질 카드 장수
	public UserSet userset = null;
	int[][] user1CardInt, user2CardInt, user3CardInt, user4CardInt;
	
	
	public void setting() {		//게임시작전 카드와 유저를 세팅후 유저에게 카드를 분배.

//		카드섞기();
		CardCase cc = new CardCase();
		ArrayList<Card> list = cc.getCards();
		
//		유저세팅();		4명
		userset = new UserSet();
		
//		유저한테배분 CardShare(카드케이스, 유저들, 카드장수)
		CardShare cs = new CardShare(list, userset, CARDNUM);
		cs.shareToUser();
		
		/* 스트링으로 된 카드를 Int형으로 바꾸는 CardInteger
		 		y  = 손패 카드의 인덱스 0~12
				xy 0  1  2  3  4  5  6  7  8  9  10  11 12 
		x   문양	0  1  2  1  3  1  4  2  3  4  2   1   3  2		문양은 스페이스,다이아,하트,클로버가 1~4  
		         숫자	1  5  8  4  10 12 9  9  8  6  2  14  13 14		숫자는 2부터 A가 2~14		
		*/
		CardInteger cardInt = new CardInteger(userset);
		user1CardInt = cardInt.cardInt(1);
		user2CardInt = cardInt.cardInt(2);
		user3CardInt = cardInt.cardInt(3); 
		user4CardInt = cardInt.cardInt(4);
		
		
	}
	public void go() {		// 반복해서 실행할 실질적인 게임 플레이 코드들
		
		//몇번째 유저의 차례인지 파악하기위한 Count
		int userCount=1;
		
		//플레이어 1의 소유카드 출력(); userSelect(0~4) => 인덱스에 해당하는 유저의 소유카드 출력 (0이면 전부, 1이면 유저1의 카드 출력)
		UserCardShow userCardShow = new UserCardShow(userset);
		userCardShow.userSelect(0);
		System.out.println("\n");
		
		// 카드 숫자 입력
		Scanner sc = new Scanner(System.in);
		UserCardRank userCR = null;
		int userRankInt = 0;
		
		//결과 화면을 보여줄 Result 클래스
		Result result = new Result();
		
		// 유저 1~4가 선택한 카드 인덱스를 저장할 int 배열
		int[] sel1Num = null, sel2Num = null, sel3Num = null, sel4Num = null;
		
		// 반복적으로 실행할 게임화면
		while(true){
			userCardShow.userSelect(userCount);
			System.out.println("user "+userCount+" 의 카드들 중 내고싶은 카드의 숫자를 ,로 구분해 선택해주세요.");
			System.out.print("선택 : ");
			String sel = sc.next();
			// , 구분을 위한 토크나이저
			StringTokenizer st = new StringTokenizer(sel, ",");
			// 유저가 몇개의 인덱스를 입력했나를 저장하는 변수
			int tokenCount = st.countTokens();
			// 입력받은 인덱스들을 int[i] 배열에 저장한다.
			int[] selNum = new int[tokenCount];
			for (int j = 0; st.hasMoreTokens(); j++) {
				selNum[j] = Integer.parseInt(st.nextToken());
			}
			
			// 선택한 인덱스에 해당하는 카드들을 출력
			userCardShow.handCardSelect(selNum,userCount);
			System.out.println();
			
			
			// 몇번째 유저의 차례인지에 따라 해당 유저가 선택한 카드 user1~4CardInt 를 인스턴트로 하는 UserCardRank 를 생성
			// 그후 해당 유저가 선택한 인덱스배열들을 sel 1~4 Num 배열에 각자 저장. (해당 카드들을 배열에서 제거할때 쓰기 위해)
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
			// 선택한 카드들의 족보를 보여주는 userSelect(선택한인덱스들);
			// 해당하는 족보를 Int형으로 (가장높은족보는 8, 가장낮은족보는 1) 로 리턴받아 userRankInt에 저장한다.
			userRankInt = userCR.userSelect(selNum);
			
			// Int형으로 받은 족보를 보여주기 위한 Result클래스 의 printRank 메서드
			result.printRank(userRankInt, userCount);
			System.out.println();
			
			
			// 유저 1~4까지 한바퀴를 모두 돌았다면
			if(userCount==4) {
				// 한바퀴 ( 1turn ) 의 결과를 보여주는 turnResult 메서드
				result.turnResult();
				// 그리고 이긴 유저의 카드를 손패에서 지우기 위한 remove(유저들의 손패들, 유저들이 선택한 인덱스들) 메서드
				result.remove(userset, sel1Num, sel2Num, sel3Num, sel4Num);
				// 다시 카운트 1부터 시작.
				userCount = 1;
			} else userCount++;		//	아직 한바퀴를 돌지 않았다면 카운트++;
			
			if(userset.user1.isEmpty()==true) {		//	 유저 1의 손패가 비었다면
				System.out.println("################");
				System.out.println("user1가 승리하였습니다.");
				System.out.println("################");
				break;
			}
			else if (userset.user2.isEmpty()==true) {	//	 유저 2의 손패가 비었다면
				System.out.println("################");
				System.out.println("user2가 승리하였습니다.");
				System.out.println("################");
				break;
			}
			else if (userset.user3.isEmpty()==true) {	//	 유저 3의 손패가 비었다면
				System.out.println("################");
				System.out.println("user3가 승리하였습니다.");
				System.out.println("################");
				break;
			}	
			else if (userset.user4.isEmpty()==true) {	//	 유저 4의 손패가 비었다면
				System.out.println("################");
				System.out.println("user4가 승리하였습니다.");
				System.out.println("################");
				break;
			}
		} // while문
	}
}
