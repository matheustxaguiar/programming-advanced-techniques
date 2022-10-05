/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus Aguiar
 */
public class No<T> {
    private T valor;
    private No<T> esquerda;
    private No<T> direita;
    
    public No(T novoValor){
        this.valor = novoValor;
        this.esquerda = null;
        this.direita = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda (No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita (No<T> direita) {
        this.direita = direita;
    }  
    
//    public int fatorBalanceamento(){;
//       return nivel(this.raiz.getDireita()) - super.nivel(this.raiz.getEsquerda());
//   }
    
}
