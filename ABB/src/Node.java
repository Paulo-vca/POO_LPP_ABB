public class Node {

    int info;
    Node esq;
    Node dir;

    public Node(int info) {
        this.info = info;
        this.dir = null;
        this.esq = null;
    }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getEsq() {
        return this.esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return this.dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }

}
