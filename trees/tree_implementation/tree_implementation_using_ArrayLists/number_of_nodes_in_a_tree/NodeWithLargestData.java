import java.util.Scanner;

public class NodeWithLargestData {

    public static TreeNode<Integer> input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the node data");
        TreeNode<Integer> root = new TreeNode<>(scanner.nextInt());
        QueueUsingLinkedList<TreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            try {
                TreeNode<Integer> temp = q.dequeue();
                System.out.println("Enter number of children of " + temp.data + "th node");
                int number = scanner.nextInt();
                for (int i = 0; i < number; i++) {
                    System.out.println("Enter " + (i+1) + "th child of " + temp.data);
                    TreeNode<Integer> child = new TreeNode<>(scanner.nextInt());
                    temp.children.add(child);
                    q.enqueue(child);
                }
            }
            catch (QueueUnderflowError e){
                // Never reach here!!!!!
                return null;
            }
        }

        return root;
    }

    public static void print(TreeNode<Integer> root){
        QueueUsingLinkedList<TreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            QueueUsingLinkedList<TreeNode<Integer>> q1 = new QueueUsingLinkedList<>();
            try {
                while(!q.isEmpty()){
                    TreeNode<Integer> node = q.dequeue();
                    System.out.print(node.data+ " ");
                    for (int i = 0; i < node.children.size(); i++) {
                        q1.enqueue(node.children.get(i));
                    }
                }
                System.out.println();

                q = q1;
            }
            catch (QueueUnderflowError e){
                // Never Reach Here
            }
        }
    }

    public static int largestNodeData(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int max = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int ans = largestNodeData(root.children.get(i));
            if (ans > max){
                max = ans;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Input tree");
        TreeNode<Integer> root = input();
        print(root);
        System.out.println("Maximum node is  :");
        System.out.println(largestNodeData(root));
        System.out.println();
    }

}

//    Input tree
//        Enter the node data
//        1
//        Enter number of children of 1th node
//        3
//        Enter 1th child of 1
//        23
//        Enter 2th child of 1
//        34
//        Enter 3th child of 1
//        23
//        Enter number of children of 23th node
//        1
//        Enter 1th child of 23
//        100
//        Enter number of children of 34th node
//        0
//        Enter number of children of 23th node
//        0
//        Enter number of children of 100th node
//        0
//        1
//        23 34 23
//        100
//        Maximum node is  :
//        100
