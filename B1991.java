public class B1991 {
    static String result="";
    static class Node{
        String value;
        Node left;
        Node right;
        public Node(String value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static void insertChild(Node curNode, String leftChild, String rightChild){
        if(!leftChild.equals("."))
            curNode.left = new Node(leftChild);
        if(!rightChild.equals("."))
            curNode.right = new Node(rightChild);
    }
    static void SearchNode(Node node, String value, String left, String right){
        if(node == null) return;
        if(node.value.equals(value)){
            insertChild(node, left, right);
        }
        else{
            SearchNode(node.left, value, left, right);
            SearchNode(node.right, value, left, right);
        }
    }
    static void preOrder(Node node){
        if(node != null){
            result+=node.value;
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }
    static void inOrder(Node node){
        if(node != null){
            if(node.left != null) inOrder(node.left);
            result+=node.value;
            if(node.right != null) inOrder(node.right);
        }
    }
    static void postOrder(Node node){
        if(node != null){
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            result+=node.value;
        }
    }
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int n = Integer.parseInt(br.readLine());
       Node rootNode = null;
       //노드 생성
       for(int i=0; i< n; i++){
            String[] str = br.readLine().split(" ");
            if(rootNode == null){
                rootNode = new Node(str[0]);
                insertChild(rootNode, str[1], str[2]);
            }
            else{
                SearchNode(rootNode, str[0], str[1], str[2]);
            }
       }
       //전위 순회
       preOrder(rootNode);
       bw.write(result+"\n");
       result="";
       //중위 순회
       inOrder(rootNode);
       bw.write(result+"\n");
       result="";
       //후위 순회
       postOrder(rootNode);
       bw.write(result);
       bw.flush();
       bw.close();
    }
}
