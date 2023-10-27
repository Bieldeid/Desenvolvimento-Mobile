package com.example.listadecompras;

public class Produto {
    private String nomeProduto;
    private String tipoProduto;
    private float quantidade;
    private double precoUnitario;

    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto(){
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto){
        this.tipoProduto = tipoProduto;
    }

    public double getPrecoUnitario(){
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }

    public float getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(float quantidade){
        this.quantidade = quantidade;
    }

    public String toString(){
        return("Nome: " + getNomeProduto() +
                "\n Preço: " + getPrecoUnitario() +
                "\n Quantidade: " + getQuantidade());
    }
}
