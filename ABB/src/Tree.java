public class Tree {
    Node root = null;

    NodeRepository nr;

    public Tree() {
        this.nr = new NodeRepository();
    }

    public void inserir(int info, Node node) {
        if (node == null) {
            root = new Node(info);
            this.nr.save(root);
            return;
        }
        if (node.info > info) {
            // inserir a esquerda
            if (node.esq == null) {
                node.esq = new Node(info);
                this.nr.save(node.esq);
                return;
            }

            // func. recursive
            inserir(info, node.esq);

        } else {
            // inserir a direita
            if (node.dir == null) {
                node.dir = new Node(info);
                this.nr.save(node.dir);
                return;
            }

            inserir(info, node.dir);

        }

    }

    public boolean isNode(Node n) {
        return n != null;
    }

    // imprimir
    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.dir, false);
            System.out.println(prefix + ("|--> ") + n.info);
            print(prefix + "     ", n.esq, true);
        }

    }

    // leticia criditos
    @Override
    public String toString() {
        // this.in_ordem(root);
        this.print("", this.root, false);
        return "";
    }
}
