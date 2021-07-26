public class GuGu {
 
	int num;  // 흔히 아는 구구단의 좌측 값을 설정해줄 정수형 변수 하나 선정
	
	public GuGu(int num) { // 생성자, 생성자에 정수를 입력함으로써 곱해지는 값을 선언
		this.num = num;
	}
	public int dan(int seq) { // 추후 GuGu 의 인스턴스값에 .dan을 해주면서 결과값 반환
		return num * seq;
	}
	
	public int[] all() {  // 구구단이니 9개의 배열에 각 계산값이 저장됨, 그런데 왜 GuGu의 인스턴스를 프린트하면 얘랑 tostring값이 바로 나오는지 모르겠음..
		int [] result = new int [9];
		for(int i = 0; i<9 ; i++) {
			result[i] = this.dan(i+1);
		}
		return result;
	}
	public String toString() {  // 배열 값을 buffer에 저장해서 string으로 바꿔주는 과정
		StringBuffer sb = new StringBuffer();
		int [] result = all(); // int [] result 의 값은 result 를 반환하게 된다. if i = 1 result[i] = num* 1
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
			if (i!= result.length-1) { // 컴마로 구분해주기 위해
				sb.append(",");
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		GuGu guGu = new GuGu(2);
		System.out.println(guGu.dan(3));
		System.out.println(guGu);
		for(int i=2; i<10; i++) {
            System.out.println(new GuGu(i));
        }
	}
}
