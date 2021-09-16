import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Node{
	
	int start;
	int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class NodeSort implements Comparator<Node>{
	int ret = 0;
	// 끝나는 시간 기준으로 오름차순 정렬 > 만약 끝나는 시간이 같으면 시작시간 오름차순 정렬 
  @Override
	public int compare(Node arg0, Node arg1) {
		if(arg0.end < arg1.end) {
			ret = -1;
		}
		if(arg0.end == arg1.end) {
			if(arg0.start > arg1.start) {
				ret = 1;
			}else if(arg0.start == arg1.start) {
				ret = 0;
			}else if(arg0.start < arg1.start) {
				ret = -1;
			}
		}
		if(arg0.end > arg1.end) {
			ret = 1;
		}
		return ret;
	}
	
}
class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Node[] room = new Node[n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			room[i] = new Node(str,end);
		}
		
		Arrays.sort(room, new NodeSort());
		int cnt = 0;
		int end = 0;
		for(int i = 0 ; i < n ; i++) {
			if(room[i].start >= end) {
				end = room[i].end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
