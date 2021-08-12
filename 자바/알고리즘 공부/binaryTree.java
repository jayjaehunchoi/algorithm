
Class Tree{
  Class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
      this.data = data;
    }
  }
  Node root;
  public void makeTree(int[] a){
    root = makeTreeR();
  }
  public Node makeTreeR(int[] a, int start, int end){
    if(start > end) return null;
    int mid = (start + end)/2;
    Node node = new Node(a[mid]);
    node.left = makeTreeR(a, start, mid-1);
    node.right = makeTreeR(a, mid+1, end);
    return node;
  }
  int count = 0;
  public int searchTree(Node n , int finder){
    if( n.data < finder){
      count++;
      searchTree(n.right, finder);
      
    }
    else if ( n.data > finder ){
      count++;
      searchTree(n.left, finder);
    }
 
      return count;
    
  }
  
public class Main {

	public static void main(String[] args){
		int[] a = new int[10];
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = i;
		}
		Tree t = new Tree();
		t.makeTree(a);
		System.out.println(t.searchTree(t.root,2));
		//답 : 2

	}
}

    
    
  


