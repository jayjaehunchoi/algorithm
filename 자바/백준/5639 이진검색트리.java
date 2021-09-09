import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int myNum;
	Node left;
	Node right;
	
	public Node(int myNum) {
		this.myNum = myNum;
	}

	
}

class Main{
	static Node root;
	
  //최초 노드일때, 노드 생성, 아닐때 , 노드 탐색 시작
	public static void createNode(int n) {
		
		if(root == null) {
			root = new Node(n);
		}else {
			searchNode(root, n);
		}
		
	}
	
  // 노드 레프트 라이트 채워가는 과정
	public static void searchNode(Node node, int n) {
		
		if(node == null) {
			return;
		}
		else {
			if(node.myNum > n) {
				
				if(node.left == null) {
					node.left = new Node(n);
					
				}else if(node.left != null) {
					searchNode(node.left, n);
				}
			}
			else if(node.myNum < n) {
				if(node.right == null) {
					node.right = new Node(n);
				
				}else if(node.right != null) {
					searchNode(node.right, n);
				}
			}
		}
		
	}
	
  // 후위순회
	public static void postFind(Node node) {
		
		if(node==null)return;
		if(node.left != null)postFind(node.left);
		if(node.right != null)postFind(node.right);
		System.out.println(node.myNum);
		
	}
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String n;
      //입력값이 더이상 없으면 while문 종료
    	while((n=br.readLine()) != null)  {
    		createNode(Integer.parseInt(n));
    	}
    	postFind(root);
    	
    }
    
}
