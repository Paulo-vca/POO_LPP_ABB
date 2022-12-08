import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // ConnectionFactory.createConnection();
        Tree appTree = new Tree();
        Scanner in = new Scanner(System.in);
        int x;
        appTree.inserir(10, appTree.root);
        appTree.inserir(11, appTree.root);
        appTree.inserir(16, appTree.root);
        appTree.inserir(18, appTree.root);
        appTree.inserir(5, appTree.root);
        appTree.inserir(1, appTree.root);

        System.out.print("\nDigite um numero: ");
        x = in.nextInt();
        appTree.inserir(x, appTree.root);

        System.out.println(appTree);

    }
}
