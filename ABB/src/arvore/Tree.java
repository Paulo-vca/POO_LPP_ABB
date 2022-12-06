package lp.arvore;

public class Tree {

    Node root = null;

    public void inserir(int info, Node node) {
        if (node == null) {
            root = new Node(info);
            // System.out.println("Criando arvore...!\nroot = " + root.info);
            return;
        }
        if (node.info > info) {
            // inserir a esquerda
            if (node.esq == null) {
                node.esq = new Node(info);
                return;
            }
 
            // func. recursive
            inserir(info, node.esq);

        } else {
            // inserir a direita
            if (node.dir == null) {
                node.dir = new Node(info);
                return;
            }

            inserir(info, node.dir);

        }

    }

    public void remover(Node node, Node previousNode, int info) {
        if (node.info == info) {
            if (node.esq != null) {
                node.esq.dir = node.dir;
                previousNode.dir = node.esq;
            } else {
                if (node.dir != null) {
                    previousNode = node.esq;

                    previousNode.dir = node.dir;
                    previousNode.esq = null;
                }

            }
        } else {
            if (node.esq != null) {
                remover(node.esq, node, info);
            } else {
                if (node.dir != null) {
                    remover(node.dir, node, info);
                } else {
                    System.out.println("Nó não encontrado");
                }
            }
        }

    }

    public boolean isNode(Node n) {
        return n != null;
    }

    public boolean procurar(Node node, int valor, boolean found) {
        boolean retorno = found;
        // procurar pelo elemento na arvore
        // quando achar, imprimir se tem filhos e quais são seus filhos
        if (node == null) {
            System.out.println("Árvore Vazia!");
            return false;
        }

        if (valor == node.info) {
            System.out.println("Elemento econtrado!");
            int qto = 0, fEsq = 0, fDir = 0;
            if (node.esq != null) {
                qto++;
                fEsq = node.esq.info;
            }
            if (node.dir != null) {
                qto++;
                fDir = node.dir.info;
            }
            System.out.printf("O elemento " +
                    node.info + " tem " +
                    qto + " filhos\n");

            if (fEsq != 0)
                System.out.println("Filho a esquerda: " + fEsq);
            if (fDir != 0)
                System.out.println("Filho a direita: " + fDir);

            return true;
        }

        if (node.esq != null)
            retorno = procurar(node.esq, valor, retorno);

        if (node.dir != null)
            retorno = procurar(node.dir, valor, retorno);

        return retorno;

    }

    public void pre_ordem(Node node) {
        if (node == null) {
            System.out.println("Árvore Vazia");
            return;
        }

        System.out.println(node.info);
        if (node.esq != null)
            pre_ordem(node.esq);

        if (node.dir != null)
            pre_ordem(node.dir);

        // System.out.println(node.info);
        // if(isNode(node.esq))
        // pre_ordem(node.esq);

        // if(isNode(node.dir))
        // pre_ordem(node.dir);

    }

    public void in_ordem(Node node) {
        if (node == null) {
            System.out.println("Árvore Vazia");
            return;
        }
        if (node.esq != null)
            pre_ordem(node.esq);

        System.out.println(node.info);

        if (node.dir != null)
            pre_ordem(node.dir);

    }

    public void pos_ordem(Node node) {
        if (node == null) {
            System.out.println("Árvore Vazia");
            return;
        }
        if (node.esq != null)
            pre_ordem(node.esq);

        if (node.dir != null)
            pre_ordem(node.dir);

        System.out.println(node.info);

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
