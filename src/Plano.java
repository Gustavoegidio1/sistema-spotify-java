import java.util.ArrayList;

public class Plano {
    private static int proximoId = 1;

    private int id;
    private String nome;
    private double valor;
    private ArrayList<Ouvinte> ouvintes;

    public Plano(String nome, double valor) {
        this.id = proximoId++;
        this.nome = nome;
        this.valor = valor;
        ouvintes = new ArrayList<>();
    }

    public void adicionarOuvinteLista(Ouvinte ouvinte) {
        ouvintes.add(ouvinte);
    }

    public int getId() {
        return id;
    }
}
