package pertemuan9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        binaryTree pertemuan9 = new binaryTree();
        int n = input.nextInt();
        for (int i = 0; i<n; i++){
            pertemuan9.insertBinaryBiasa(input.nextInt());
        }
        pertemuan9.printPreOrder();
        pertemuan9.printInOrder();
        pertemuan9.printPostOrder();
        pertemuan9.printlevelorder();

    }

}

class node {
    node kanan;
    node kiri;
    int nilai;

    public node(int nilai){
        this.nilai = nilai;
        kanan = null;
        kiri = null;
    }
}

class binaryTree {
    node root;

    public binaryTree(){
        root = null;
    }

    public binaryTree(int nilai){
        root = new node(nilai);
    }

    public void insertBinaryBiasa(int nilai){
        node baru = new node(nilai);
        if(root == null){
            root = baru;
        } else {
            Queue<node> urutan = new LinkedList<>();
            urutan.add(root);
            while (true) {
                node sekarang = urutan.poll();
                if (sekarang.kiri == null){
                    sekarang.kiri = baru;
                    break;
                } else if (sekarang.kanan == null){
                    sekarang.kanan = baru;
                    break;
                } else {
                    urutan.add(sekarang.kiri);
                    urutan.add(sekarang.kanan);
                }
            }
        }
    }

    public void insert(int nilai){
        if (root != null){
            cari(root, new node(nilai));
        } else {
            root = new node(nilai);
        }
    }

    public node cari (node node, node newnode){
        if (node == null){
            node = newnode;
            return node;
        }
        if (newnode.nilai < node.nilai){
            node.kiri = cari(node.kiri, newnode);
        } else if (newnode.nilai > node.nilai){
            node.kanan = cari(node.kanan, newnode);
        }
        return node;
    }

    public void preorder(node tmp){
        if(tmp != null){
            System.out.print(tmp.nilai + ", ");
            preorder(tmp.kiri);
            preorder(tmp.kanan);
        }
    }

    public void inorder(node tmp){
        if(tmp != null){
            inorder(tmp.kiri);
            System.out.print(tmp.nilai + ", ");
            inorder(tmp.kanan);
        }
    }

    public void postorder(node tmp){
        if(tmp != null){
            postorder(tmp.kiri);
            postorder(tmp.kanan);
            System.out.print(tmp.nilai + ", ");
        }
    }

    public void printPreOrder(){
        System.out.print("Preorder   : ");
        preorder(root);
        System.out.println();
    }

    public void printInOrder(){
        System.out.print("Inorder    : ");
        inorder(root);
        System.out.println();
    }

    public void printPostOrder(){
        System.out.print("postorder  : ");
        postorder(root);
        System.out.println();
    }

    public void printlevelorder(){
        Queue<node> urutan = new LinkedList<>();
        if (root != null){
            System.out.print("levelorder : ");
            urutan.add(root);
            while(urutan != null){
                node sekarang = urutan.poll();
                if (sekarang == null) break;
                System.out.print(sekarang.nilai + ", ");
                if(sekarang.kiri != null) urutan.add(sekarang.kiri);
                if(sekarang.kanan != null) urutan.add(sekarang.kanan);
            }
        }
    }
}
