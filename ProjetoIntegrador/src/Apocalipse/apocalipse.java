/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apocalipse;

/**
 *
 * @author beatriz.sato
 */
public class apocalipse {
    static void imprimirSit(int linha, String[][] bloco){
        for(int i=linha;i<(linha+1);i++){
            for (String item : bloco[i]) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] bloco5 = {"\nAgora é preciso checar se realmente não há nenhum "
                + "morto vivo e se todas as portas e janelas estão à prova de "
                + "zumbi para não ter surpresas a noite.\nAo entrar, percebe que"
                + " há dois andares, o térreo e o subsolo. No térreo, você "
                + "estima 2 salas de aula e 2 laboratórios, e como zumbis tem "
                + "dificuldade\npara subir escada, você começa a checar o andar "
                + "de cima para não ser pego de surpresa. ", "Depois do banheiro, "
                + "vem a primeira sala à esquerda. A porta está aberta, você "
                + "entra, aparentemente vazia. Várias carteiras jogadas e por "
                + "sorte\nnenhuma janela. "};
                
 String[][] sitBloco5 = {
/*sit2*/            {"Já a segunda sala está com a porta fechada, então você: ", 
            "a) abre e explora", "b)  faz barricada na porta usando as carteiras"
                + " da primeira sala"},
/*sit3*/            {"Ao entrar, percebe que as janelas não abrem, são apenas para "
                + "deixar a luz entrar. Dando uma batidinha no vidro, percebe "
                + "que ele é temperado. \nEntão você: ", "a) joga todos os corpos"
                + " em um canto e coloca as mesas de metal em frente a janela "
                + "porque toda segurança ainda é pouca", "b) confia no vidro "
                + "temperado"}
        };
        
        
       //imprimir a o bloco 1
        for(int i=0;i<bloco5.length;i++){
            System.out.println(bloco5[i]);
            if(i==1){
                imprimirSit(1,sitBloco5);
            }
        }
    }
}
