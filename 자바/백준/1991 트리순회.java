import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	String myNum;
	Node left;
	Node right;
	
	public Node(String myNum) {
		this.myNum = myNum;
	}
}

class Main{
	static Node root;
  
	public static void createNode(String myNum, String lft, String rgt) {
		
		if(root == null) { // 노드가 첫번째일 때
			root = new Node(myNum);
			if(!lft.equals(".")) {
				root.left = new Node(lft);
			}
			if(!rgt.equals(".")) {
				root.right = new Node(rgt);
			}
			
		}else {
			searchNode(root, myNum, lft, rgt); //노드가 있을 때
		}
		
	}
	
	public static void searchNode(Node node, String myNum, String lft, String rgt) {
		
		if(node == null) { //더이상 탐색할 노드가 없을 때 탈출
			return;
		}else {
			if(node.myNum.equals(myNum)) { // 루트 노드부터 쭉 탐색하다가, 탐색한 (자식)노드의 이름이 새로 입력한 노드명과 같으면 왼쪽값 , 오른쪽 값
				if(!lft.equals(".")) {
					node.left = new Node(lft);
				}
				if(!rgt.equals(".")) {
					node.right = new Node(rgt);
				}
			}else {
				searchNode(node.left, myNum,lft,rgt); // 왼쪽노드 오른쪽노드 저장
				searchNode(node.right, myNum,lft,rgt);
			}
			
		}
		
	}
	public static void front(Node node) { //전위 루트 > 왼쪽 > 오른쪽 
		if(node == null)return;
		System.out.print(node.myNum);
		if(node.left != null)front(node.left);
		if(node.right != null)front(node.right);
	}
	
	public static void mid(Node node) { // 중위 왼쪽 > 루트 > 오른쪽
		if(node == null)return;
		if(node.left != null)mid(node.left);
		System.out.print(node.myNum);
		if(node.right != null)mid(node.right);
	}
	
	public static void backward(Node node) { //후위 왼쪽 > 오른쪽 > 루트
		if(node == null)return;
		
		if(node.left != null)backward(node.left);
		if(node.right != null)backward(node.right);
		System.out.print(node.myNum);
	}
	
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int i = 0 ; i < n ; i++) {
    		st= new StringTokenizer(br.readLine()," ");
    		
    		String myNum = st.nextToken();
    		String lft = st.nextToken();
    		String rgt = st.nextToken();
    		
    		createNode(myNum, lft, rgt);
    	}
    	front(root);
    	System.out.println();
    	mid(root);
    	System.out.println();
    	backward(root);
    	
    	
    }
    
}
