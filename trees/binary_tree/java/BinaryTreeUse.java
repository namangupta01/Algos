import java.util.Scanner;

public class BinaryTreeUse {


    public static BinaryTreeNode<Integer> input(Scanner s){
        System.out.println("Enter the node : ");
        int data = s.nextInt();
        if (data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = input(s);
        root.right = input(s);
        return root;
    }

    public static void printRecursively(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        String s = root.data + "";
        if (root.left!=null){
            s = s + ": L" + root.left.data;
        }
        if (root.right!=null){
            s = s + ": R" + root.right.data;
        }
        System.out.println(s);
        printRecursively(root.left);
        printRecursively(root.right);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        if (data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            try {
                BinaryTreeNode<Integer> node = q.dequeue();
                System.out.println("Enter left child of " + node.data);
                data = s.nextInt();
                if (data != -1){
                    BinaryTreeNode<Integer> left = new BinaryTreeNode<>(data);
                    node.left = left;
                    q.enqueue(left);
                }
                System.out.println("Enter right child of " + node.data);
                data = s.nextInt();
                if (data != -1){
                    BinaryTreeNode<Integer> right = new BinaryTreeNode<>(data);
                    node.right = right;
                    q.enqueue(right);
                }

            }
            catch (QueueUnderFlowError e){
                // Will never reach here
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            QueueUsingLinkedList<BinaryTreeNode<Integer>> q1 = new QueueUsingLinkedList();
            while (!q.isEmpty()){
                try {
                    BinaryTreeNode<Integer> node = q.dequeue();
                    System.out.print(node.data + " ");
                    if (node.left!=null){
                        q1.enqueue(node.left);
                    }
                    if (node.right!=null){
                        q1.enqueue(node.right);
                    }
                }
                catch (QueueUnderFlowError e){
                    // Never reach here
                }
            }
            System.out.println();
            q = q1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printRecursively(root);
        System.out.println();
        printLevelWise(root);
    }
}
