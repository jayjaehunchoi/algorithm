public class Multiples {
	
	int limitNum;
	public Multiples(int num) {
		this.limitNum = num;
	}
	
	int result = 0;
	public int mulnum() {
		for (int i = 0; i < limitNum; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				result += i;
			}
		}
		return result;		
	}

	public static void main(String[] args) {
		// 10보다 작은 3, 5배수의 합
    Multiples multi = new Multiples(10);
		System.out.println(multi.mulnum());
		// 1000보다 작은 3, 5배수의 합
		Multiples multiThousand = new Multiples(1000);
		System.out.println(multiThousand.mulnum());
	}
}
