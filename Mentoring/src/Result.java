
import java.util.Arrays;

public class Result {			// 	게임 도중 유저들의 족보와 결과를 보여주기 위한 클래스
	int userRankInt;
	String[] userRankStr = new String[4];		// Int형으로 받은 족보들을 String형으로 저장하기위한 배열
	int userCount;
	int[] cardRank = new int[4];				// 족보들의 순위를 비교하기위한 int형 배열 (cardRank[0] 은 유저1의 족보랭크)
	boolean[] isTop = new boolean[4];			// 어느 유저가 Top 인지를 판별하기위한 boolean 배열
	
	// Int형으로 받은 족보를 보여주기 위한 Result클래스 의 printRank 메서드
	public void printRank(int userRankInt, int userCount) {
		this.userRankInt = userRankInt;
		cardRank[userCount-1] = this.userRankInt;		// 해당 유저의 cardRank[] 에 Int형으로 받은 족보를 넣는다 (유저들의 순위 비교를 위해)
		switch (userRankInt) {
		case 8:	userRankStr[userCount-1] = "스트레이트 플러쉬";	break;
		case 7:	userRankStr[userCount-1] = "포 카드";			break;
		case 6:	userRankStr[userCount-1] = "스트레이트";			break;
		case 5:	userRankStr[userCount-1] = "풀 하우스";			break;
		case 4:	userRankStr[userCount-1] = "트리플";			break;
		case 3:	userRankStr[userCount-1] = "연속된 페어";		break;
		case 2:	userRankStr[userCount-1] = "원 페어";			break;
		case 1:	userRankStr[userCount-1] = "싱글";				break;
		}	//	 해당 유저의 족보를 String 배열에 저장한다.
		
		//선택한 카드들의 족보를 출력
		System.out.printf("user%d의 족보 : %s \n", userCount,userRankStr[userCount-1]);
	}

	// 한바퀴 ( 1turn ) 의 결과를 보여주는 turnResult 메서드
	public void turnResult() {
		int top = 0;
		for (int i = 0; i < isTop.length; i++) {	// trunResult 가 사용될때마다 isTop 을 false로 초기화
			isTop[i] = false;
		}
		System.out.println();
		
		System.out.println("### 이번 턴의 결과  ###");
		for (int i = 0; i < cardRank.length; i++) {		// 각 유저들의 족보 상태를 전부 출력
			System.out.printf("user%d의 족보 : %s \n", i+1 , userRankStr[i]);
			if (cardRank[i] >= top) {	//가장 높은 족보를 top이라는 변수에 저장
				top = cardRank[i];	
			}
		}
		for (int i = 0; i < 4; i++) {	// user 1~4까지 확인해서
			if(cardRank[i] == top)		// top 의 족보를 가지고 있는 유저는
				isTop[i] = true;		// 그 유저에 해당하는 isTop 의 값을 true로 
		}
		
		System.out.print("가장 높은 족보를 낸 유저는  ");
		for (int i = 0; i < isTop.length; i++) {
			if (isTop[i] == true) {
				System.out.printf("user%d ", i+1);
			}
		}
		System.out.println("입니다. 해당 유저가 낸 카드는 손패에서 제거됩니다.");
		System.out.println();
		
	}

	// 이긴 유저의 카드를 손패에서 지우기 위한 remove(유저들의 손패들, 유저들이 선택한 인덱스들) 메서드
	public void remove(UserSet userset, int[] sel1Num, int[] sel2Num, int[] sel3Num, int[] sel4Num ) {
		// 예를들어 2,12를 입력받게되면, 처음에 2번째 카드를 지우게 되면 인덱스가 0~11까지밖에 없어서 12번째 카드가 지워지지 않게된다.
		// -> 큰거부터 지우려 했는데 유저가 입력한 숫자가 막 섞여있으면 의미가없어진다
		// -> 입력받은 숫자배열들을 정렬해야한다.
		int temp=0;		//	 배열들을 정렬할때 사용할 임시 변수
		
		for (int k = 0; k < isTop.length; k++) {		// 유저 1~4까지 확인한다.
			if (isTop[k] == true) {						// 가장높은 족보를 가진 유저가 있으면
				switch (k) {					// 각 유저들에 따라 그 유저가 선택한 카드 인덱스가 다르기 때문에 switch 문으로 구분
				case 0:									//	user1 이면
					for (int i = 0; i < sel1Num.length; i++) {			// 선택한 sel1Num 배열을 내림차순으로 정리하기위한 반복문
						for (int j = i; j < sel1Num.length; j++) {
							if(sel1Num[i] < sel1Num[j]) {
								temp = sel1Num[i];
								sel1Num[i] = sel1Num[j];
								sel1Num[j] = temp;
							}
						}
					}
					for (int i = 0; i < sel1Num.length; i++) {		//	sel1Num 의 길이만큼 반복되는 remove 
						userset.user1.remove(sel1Num[i]);		//	높은 카드 순서대로 삭제된다.
					}
					System.out.println();
					break;
				case 1:										// user 2이면 
					for (int i = 0; i < sel2Num.length; i++) {					// 이하 반복
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
