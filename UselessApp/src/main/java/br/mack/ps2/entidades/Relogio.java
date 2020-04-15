package br.mack.ps2.entidades;
public class Relogio {
    private String nome;
    private int hora;

    public Relogio(){}

    public Relogio(String nome, int hora){
        this.nome = nome;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Relogio{" +
                "nome='" + nome + '\'' +
                ", hora=" + hora +
                '}';
    }
}
