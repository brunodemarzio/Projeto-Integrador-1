/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apocalipse;

/**
 *
 * @author Junio 2.0
 */
public class rascunho {
    static void imprimirSit(int linha, String[][] bloco){
        for(int i=linha;i<(linha+1);i++){
            for (String item : bloco[i]) {
                System.out.println(item);
            }
        }
    }
    public static void main(String[] args) {
        String[][] sit = {
            {"Já a segunda sala está com a porta fechada, então você: ", 
            "a) abre e explora", "b)  faz barricada na porta usando as carteiras"
                + " da primeira sala"},
            {"Ao entrar, percebe que as janelas não abrem, são apenas para "
                + "deixar a luz entrar. Dando uma batidinha no vidro, percebe "
                + "que ele é temperado. Então você: ", "a) joga todos os corpos"
                + " em um canto e coloca as mesas de metal em frente a janela "
                + "porque toda segurança ainda é pouca", "b) confia no vidro "
                + "temperado"}
        };
        
       imprimirSit(1, sit);
    }
}
