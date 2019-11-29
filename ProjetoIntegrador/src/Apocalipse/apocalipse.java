package Apocalipse;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author beatriz.sato
 */
public class apocalipse {
    static void imprimirSituacao(int linha, String[][] bloco){
        for(int i=linha;i<(linha+1);i++){
            for (String item : bloco[i]) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
    
    static int menu(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("                               ");
        System.out.print("           APOCALIPSE          ");
        System.out.print("                               ");
        System.out.println();
        System.out.println("[1] - Jogar");
        System.out.println("[2] - História");
        System.out.println("[3] - Instruções");
        System.out.print("Opção: ");
        return entrada.nextInt();

    }
    
    static int geradorAleatorio(int num){
        Random gerador = new Random();
        int numAleatorio = gerador.nextInt(num);
        return numAleatorio;
    }
    
    static void imprimirMorte(){
        System.out.println();
        Random gerador = new Random();
        int num = gerador.nextInt(3);
        if(num == 0){
            System.out.println("Você infelizmente não conseguiu resistir a "
                + "todos os ferimentos e teve uma morte lenta e \ndolorosa");
        }else if(num == 1){
            System.out.println("Você quase conseguiu resistir ao apocalipse "
                + "zumbi, mas com tantos ferimentos, acabou morrendo");
        }else{
            System.out.println("Você foi infectado no último ataque e morreu. "
                + "Parabéns, você virou um zumbi");
        }
    }
    
    static char entrada(){
        Scanner entrada = new Scanner(System.in);
        char op = entrada.next().charAt(0);
        System.out.println();
        return op;
    }
    
    static void imprimirBreak(){
        System.out.print("                               ");
        System.out.print("*******************************");
        System.out.print("                               ");
        System.out.println();
    }

    static boolean deNovo(){
        Scanner entrada = new Scanner(System.in);
        boolean deNovo = false;
        System.out.println();
        System.out.println("Jogar de novo? ");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        int resposta = entrada.nextInt();
        if(resposta == 2){
            deNovo = true;
            System.out.println("Foi um prazer!");
            System.out.println();
        }
        return deNovo;
    } 
    
    static int proximoBloco(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Deseja continuar? ");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        int num = leitor.nextInt();
        return num;
    }
    
    static void imprimirStatus(int saude, String arma){
        System.out.println("Status atual: ");
        System.out.println("Saúde: "+saude);
        System.out.println("Arma: "+ arma);
    }
    public static void main(String[] args) {
        String arma = "não tem";
        char op;
        int saude = 5, pontos = 0, saudeT, pontosT, num;
        boolean amigo = false, deNovo = false, morreu = false,
                deNovoJogo = true;
        
        //menu
        String historia = "Você é um estudante universitário e está indo para"
                + "um outro país num programa de intercâmbio cultural. "
                + "\nAté o momento da chegada, tudo ocorre como planejado,"
                + " mas as coisas não serão mais as mesmas após o desembarque";
        
        String instrucao = "Você lerá os textos apresentados e escolherá a "
                + "opção que julgue mais adequada.\nAperte enter para "
                + "confirmar sua escolha após cada situação.\nLembre-se de "
                + "que cada decisão tomada terá impacto no decorrer do jogo";
        
        //TEXTOS BLOCOS
        String[] bloco1 = {
/*i0*/      "Após mais de 13 horas no avião até a nova cidade, você chega no"
            + " aeroporto, faz o checkout,\nbusca suas malas, e então tenta"
            + " se informar sobre como ir para o alojamento da sua"
            + "\nuniversidade.",
/*i1*/      "Ao conversar com o funcionário do balcão de informações, "
            + "você fica sabendo que há um\ntransporte provido pela própria"
            + " universidade que leva os alunos até o alojamento,\nentão "
            + "decide esperar por ele.",
/*i2*/      "Depois de andar sem rumo por quase uma hora, você encontra uma"
            + " loja de conveniência e decide\nentrar para procurar alguma"
            + " coisa para comer. "
        };
        
        String[] bloco2 = {"Depois de enfrentar diversos problemas, dentre eles,"
            + " ficar de frente com a morte, enfrentar\na cidade completamente"
            + " destruída, e vários outros perigos, você chega à "
            + "universidade e se\ndepara com o mesmo cenário do restante "
            + "da cidade: tudo destruído, revirado e aparentemente\no "
            + "campus está totalmente abandonado."};
        
        //BLOCO 3
        String[] bloco3 = {
            "Depois de perceber que não há ninguém no campus, você sai em"
            + " busca de artefatos para se\ndefender, então encontra o "
            + "almoxarifado dos materiais de jardinagem do campus da sua"
            + "\nuniversidade, onde você encontra alguns objetos",
            "Com a "+arma+" em mãos, você percorre o campus da universidade"
            + " em busca de outras pessoas,\nmas principalmente, de alimentos"
            + " para sua sobrevivência. Com sorte, você avista um ser\nhumano,"
            + " mas corre o risco dele estar infectado.",
            "Então, você sai em busca de alimentos em algum lugar do campus."
            + " Ao caminhar, você percebe\num grupo de 5 zumbis que se"
            + " aproximam muito rapidamente de seu local.",
            "Após se juntarem, vocês saem pelo campus em busca de alimentos."
            + "\nAo caminharem, vocês percebem um grupo de 5 zumbis que se"
            + " aproximam muito rapidamente\nde onde vocês estão.",
            "Você consegue fugir. Após rodar por horas pelo campus da "
            + "universidade em busca de alimentos,\nvocê finalmente encontra"
            + " uma lanchonete, onde encontra comida o suficiente para"
            + " passar\nalguns dias.",
            
        };
        //BLOCO 34
        
        String[] bloco34 = {
            "Ao encontrar comida na lanchonete, você com sorte também"
            + " encontra um rádio de pilha, que\ndecide levar consigo. Você"
            + " ouve no rádio que há um grupo grande de pessoas reunidas na"
            + "\ncidade, porém não sabe o local exato.",
            "Logo ao sair do campus você avista um grupo de zumbis e sai"
            + " correndo. Você consegue fugir,\ne mesmo após entender o"
            + " perigo você sai em busca do grupo de pessoas que ouviu no"
            + " rádio, porém\nno meio do caminho você é surpreendido por um"
            + " grupo grande de zumbis que te matam."
        };
        //BLOCO 4
        String[] bloco4 = {
            "Você decidiu ficar no campus por ser mais seguro que a cidade."
            + " Agora, a busca é por um\nabrigo, já que o alojamento"
            + " universitário está infestado de zumbis. Após horas andando"
            + " e\navaliando os prédios, uma pessoa aparece em apuros. "
            + "Ao se aproximar dela, nota que ela\nteve um pé amputado. "
            + "Ciente do perigo, você a ajuda, carregando-a pelos ombros."
            + "\nApós um tempo caminhando para um local seguro, percebem que"
            + " atrás de vocês há 3 zumbis",
            "Com sorte e livre dos zumbis, vocês encontram um prédio com as"
            + " portas abertas, então\ndecidem entrar para descansar um pouco."
            + " Ao entrar, percorrem um corredor e se deparam\ncom um "
            + "laboratório de química vandalizado que exala um cheiro forte",
            "Seguindo seu caminho pelo campus, vocês avistam um prédio mais"
            + " afastado e isolado.\nEle parece ser de algum departamento de"
            + " pesquisa médica, pois tem uma imagem de uma\nestrutura de DNA"
            + " na entrada. Por fora parece vazio e silencioso, "
            + "então vocês entram"
        };
        
        //BLOCO 5
        String[] bloco5 = {
            "Agora é preciso checar se realmente não há nenhum "
            + "morto vivo e se todas as portas e janelas \nestão à prova de "
            + "zumbi para não ter surpresas a noite. Ao entrar, você estima 2"
            + " salas de aula \ne 2 laboratórios e decide começar pelo corredor"
            + " à esquerda.",
            //situação 1
            "Depois do banheiro, vem a primeira sala à esquerda. A porta "
            + "está aberta, você entra, \naparentemente vazia. Várias "
            + "carteiras jogadas e por sorte nenhuma janela. ",
            //situação 2
            "Logo em frente à segunda sala, há um laboratório. Sua porta é "
            + "de vai e vem com uma janelinha. \nDo lado de fora não parece "
            + "ter nenhum zumbi, mas já dá para enxergar várias janelas e "
            + "corpos\nem cima de mesas de alumínio.",
            //situação 3
            "Todo o corredor da esquerda já foi, só falta o laboratório em "
            + "frente à escada para encerrar o\ndia",

            "O segundo laboratório tem uma porta com identificador, que abre"
            + " do lado de fora apenas para \nquem tem a senha.\nVocê tenta "
            + "algumas senhas, mas nenhuma delas funciona. \nComo já está "
            + "tarde e o cansaço bateu, você vai para a sala 1 descansar. ",
           //situação 4
            "Com muito esforço, consegue abrir a porta. \nAssim que abre, 3 "
            + "zumbis vem correndo em sua direção. \nEnquanto você tentar "
            + "matar um na sua frente, os outros 2 te atacam pelo outro "
            + "lado.\nVocê sai correndo para fora do laboratório e entra na "
            + "sala 1, onde consegue dar a volta pela\nsala para trancar os "
            + "dois lá dentro e ter um tempo para pensar como matar os dois.",

            "Agora que o laboratório está vazio, dá tempo de procurar algum"
            + " recurso para matá-los.\nPara sua sorte, era nesse lugar que "
            + "os corpos eram dissecados, então encontra vários\nequipamentos"
            + "cirúrgicos que podem ser úteis para sobreviver."
        };
        
        String[] bloco6 = {
            //se maior que cinco (i=0;i<6)
            "Além de bisturis, você acha um celular caído em frente a uma das "
            + "mesas. Ao desbloquear,\naparece o vídeo de uma mulher com cara "
            + "de doente que dá o seguinte recado: “hoje é dia 12 de\nagosto de"
            + " 2021 e faz uma semana que descobrimos um vírus letal que "
            + "transforma as pessoas em\nzumbis.\nJá informamos as autoridades"
            + " e eles vão montar uma brigada no lado leste do campus, no "
            + "\nprédio da engenharia. Vá para lá o mais rápido "
            + "possível para se proteger”.",
/*i=1*/     "Esse vídeo era para ser postado na página do facebook da "
            + "universidade, mas infelizmente o\nupload não chegou a ser "
            + "efetuado.",
/*i=2*/     "Ao olhar para o zumbi morto, você percebe que ela era a doutora"
            + " do vídeo.",       
/*i=3*/     "Você imediatamente pega tudo de útil que tem pelo prédio e sai"
            + " em busca desse lugar, na\nesperança de encontrar proteção e "
            + "comida.",
            //evento aleatório
/*i=4*/     "Ao chegar, vê vários caminhões do exército parados na frente e"
            + " dois soldados armados em\ncima observando o território. Você"
            + " imediatamente acena e grita para eles e pouco tempo\ndepois um"
            + " deles vem te escoltar para dentro do prédio, pouco antes de um"
            + " zumbi tentar\nte atacar. ",
/*i=5*/     "Lá encontra mais alguns sobreviventes, e é informado de que "
            + "amanhã haverá uma expedição para\numa cidade menos infectada. "
            + "Por enquanto, você está salvo."
            + "\nparabéns por sobreviver até aqui, aguarde próximos capítulos",
            
            //se menor que cinco
/*i=6*/     "Você vasculha o espaço mais um pouco e acha um pedaço de ferro"
            + " grande que pode ser usado\npara perfurar a cabeça de um zumbi."
            + "\nJá equipado, se prepara para enfrentá-los. "
            + "\nA sua estratégia vai ser abrir a porta e atacar empurrar o"
            + " primeiro para longe com a barra\nde ferro enquanto usa a "+arma+
            " para matar o outro. ",
            
/*i=7*/     "Com muito esforço e alguns arranhões consegue colocar o plano"
            + " em prática. ",
            //-1 saúde
/*i=8*/     "Agora que o prédio está livre de zumbis, está na hora de "
            + "transformá-lo em um forte. \nPara isso, você joga todos os "
            + "corpos em um lugar só e começa a montar um mapa das redondezas:"
            + "\nonde procurar por comida, onde procurar por armas, e faz um"
            + " planejamento a longo prazo para \nsobreviver ao apocalipse. "
            + "\nSe você continuar assim, com certeza sobreviverá."
        };
        
        //SITUAÇÕES
        String[][] situacaoBloco1 = {
/*sit0*/    {"Cansado de esperar pelo transporte de sua faculdade, você"
            + " decide: ", "a) Sair do aeroporto e ir para o alojamento",
            "b) Sair e explorar a cidade"},
/*sit1*/    {"Ainda no aeroporto, você encontra uma funcionária de sua"
            + " companhia aérea, a quem decide\nperguntar qual é o caminho "
            + "até o alojamento da sua universidade. Ela te explica, e você"
            + "\nsegue em rumo ao alojamento.", "Assustado com a cidade"
            + " completamente destruída, e sem saber o que havia acontecido,"
            + " você\ndecide então:", "a) Seguir o caminho que lhe foi "
            + "indicado", "b) Olhar num mapa um caminho alternativo "},
/*sit2*/   {"Depois que você saiu do aeroporto, vê que a cidade está "
            + "totalmente destruída, carros\ncapotados, sangue pelas ruas.\n"
            + "Ao entrar na rua da faculdade, você se depara com uma mulher "
            + "de cabeça baixa:", "a) Ir até ela para pedir informação", 
            "b) Mudar a rota"},
/*sit3*/    {"Ela vem em sua direção para atacá-lo:", "a) Você arremessa sua"
            + " mala nela e corre em direção ao campus", "b) Foge dela, e"
            + " continua seu trajeto"},
/*sit4*/    {"Ao entrar, escuta um barulho em um dos corredores, então você"
            + " decide:", "a) Sair da loja e desistir de explorar a cidade",
            "b) Ver o que é esse barulho"}
        };
        
        //bloco2
        String[][] situacaoBloco2 = {
            {"Quando você entra na universidade, você percebe que não está"
            + " mais com sua mala.\nEntão decide:", "a) Deixa a mala pra lá,"
            + " ele estava muito pesada e só estava te atrapalhando", 
            "b) Resolve refazer o percurso indo atrás da mala"},
            {"Você decide então voltar seu percurso em busca da sua mala",
            "Após andar por alguns minutos, você já estava consideravelmente"
            + " longe do campus e então\ndecide continuar indo atrás da mala.",
            "Ao se afastar ainda mais da universidade, começa a ter um"
            + " pressentimento ruim, que algo\nruim irá acontecer, mas não"
            + " desiste de encontrar sua mala.", "Depois de caminhar um"
            + " pouco mais você encontrar sua mala numa esquina próxima"
            + " ao local\nem qual sofreu o ataque de um zumbi, então"
            + " você decide:", "a) Procurar algo para comer porque está"
            + " faminto depois de andar do aeroporto até o campus e\ndepois"
            + " ir atrás da mala.", "b) Voltar para o campus."},
            {"Ao chegar no campus e perceber que a universidade aparentemente"
            + " está vazia, você decide:", "a) Procurar a reitoria", 
            "b) Ir até as salas procurar por companhia"},
            {"Após perceber que as salas estão completamente destruídas,"
            + " você decide:", "a) Ir em busca de algum alimento",
            "b) Procurar por alguém na faculdade"}
        };
        
       
        //BLOCO3
        String[][] situacaoBloco3 = {
/*0*/       {"Você escolhe: ", "a) uma enxada", "b) uma tesoura de poda",
            "c) uma pá", "d) uma foice"},
/*1*/       {"Você: ", "a) tenta contato", "b) segue seu caminho sozinho"},
/*1*/       {"Você: ", "a) tenta enfrentá-los", "b) foge"}
        };
        //BLOCO34
        String[][] situacaoBloco34 = {
/*0*/       {"Você: ", "a) Arrisca sair do campus para procurar este grupo"
            + " de pessoas", "b) Fica no campus"}
        };
                
        //BLOCO4
        String[][] situacaoBloco4 = {
 /*0*/      {"Impossibilitados de correr por conta da pessoa ferida, vocês: ",
            "a) abandonam a pessoa para se livrarem dos zumbis", "b) "
            + "pegam ela no colo e correm"},
 /*1*/      {"Vocês: ", "a) vão embora com medo de passarem mal com o cheiro",
            "b) protegem o rosto e entram no laboratório"}
            
        };
        String[][] situacaoBloco5 = {
/*sit0*/    {"A primeira coisa que você faz é checar se tem água, ao "
/*aleat*/   + "entrar no banheiro ", "você é surpreendido\npor um zumbi que te"
            + "ataca e te deixa levemente ferido \nantes de você matá-lo.",
            "logo vê a torneira \naberta com água saindo dela e comemora.", 
            "tenta abrir a \ntorneira mas infelizmente nada sai."},
/*sit1*/    {"Já a segunda sala está com a porta fechada, então você: ", 
            "a) abre e explora","b) faz barricada na porta usando as carteiras"
            + " da primeira sala"},
/*sit2*/    {"Ao entrar, percebe que as janelas não abrem, são apenas para "
            + "deixar a luz entrar. \nDando uma batidinha no vidro, percebe "
            + "que ele é temperado. Então você: ", "a) joga todos os corpos"
            + " em um canto e coloca as mesas de metal em frente a janela "
            + "porque toda\nsegurança ainda é pouca", "b) confia no vidro "
            + "temperado"},
/*sit3*/    {"Depois de uma noite mal dormida, se prepara para abrir o "
            + "laboratório fechado.\nJá deixa a sua "+arma+" preparada para "
            + "caso haja algum zumbi. Tenta mais uma combinação de \nsenha "
            + "antes de ir para a força bruta, mas sem sucesso. ", "O que você "
            + "faz agora?", "a) destrói a caixa de colocar a senha e a maçaneta"
            + " ", "b) desmonta a caixa de colocar a senha e corta todos os "
            + "fios"}
        };
        
               

        
        
        //TEXTOS EXTRA BLOCO E SITUAÇÃO
        
        //texto de alternativa bloco 3, situação 1
        String textoBloco3A = "Como ele não estava infectado, vocês se juntam";
        String textoBloco3B = "A pessoa estava infectada, portanto você a"
                + " matou com ";
        String morteSit2Amigo = "Vocês não deram conta de matar todos os"
                + " zumbis. Eles te atacaram e vocês morreram.";
        String morteSit2 = "Você não deu conta de matar todos os zumbis"
                + " rapidamente, então eles te atacaram e você morreu.";

        //texto de alternativa bloco 5, situação 1
        String textoSituacao2 = "Ao abrir, é pego de surpresa por um zumbi, que"
            + " tenta te atacar mas você consegue rapidamente \nacertar ele na "
            + "cabeça com a "+arma+", apesar de sair com um pequeno ferimento."
            + "\nEssa sala tem uma janela, que você cobre com as carteiras.\n"
            + "Depois de proteger as janelas, você acha no canto da sala um kit"
            + " de primeiros socorros para \ncuidar do ferimento, mas nada "
            + "além disso. \nPor precaução, acha melhor deixar a porta "
            + "fechada e fazer uma barricada para impedir a \npassagem por "
            + "ela também.";
        
        //texto de morte do bloco 6
        String morteEspecial = "No caminho, uma horda de zumbis te pega de "
                + "surpresa e te devora. Infelizmente você"
                + " nunca chega\nà brigada";
        
        //textos de morte do bloco1
        String[] textoMorte1 = {"Pouco tempo após iniciar a rota alternativa,"
            + " você percebe que há alguém te seguindo,\naperta o passo, mas"
            + " a pessoa se aproxima. Ao olhar para ela você imediatamente"
            + " percebe que\nela é um zumbi, e se dá conta do que está"
            + " acontecendo na cidade. Logo então o zumbi te ataca\ne"
            + " voce morre.", "A mala não a detém e ela te ataca.", 
            "Ao entrar no corredor de onde veio o barulho, você se depara com"
            + " um zumbi e ele te ataca "};
        
        String[] textoMorte2 = {"Você encontra uma lanchonete a alguns"
            + " quilômetros do local onde encontrou sua mala,\nentão você"
            + " opta por entrar na loja. Ao adentrar o comércio, você se"
            + " depara com uma horda de\nzumbis e eles o atacam.", "É"
            + " surpreendido ao chegar na sala por um senhor aparentemente"
            + " deformado, sem um dos braços\nque te chama pedindo ajuda, e"
            + " o ataca em seguida"};
        
        
        //menu
        do{
            num = menu();
            if(num == 2){
                System.out.println(historia);
            } else if(num ==3){
                System.out.println(instrucao);
            }
        }while(num != 1);
        
        //MONTAGEM DOS BLOCOS
        do{ //deNovoJogo
            
            //BLOCO1
            saudeT = saude; pontosT = pontos; //checkpoint
            do{
                imprimirBreak();
                deNovo = true; //não repetir o bloco caso não morra
                if(morreu){
                    saude = saudeT;
                    pontos = pontosT;
                    morreu = false;
                }
                for(int i=0;i<bloco1.length;i++){
                    System.out.println(bloco1[i]);
                    System.out.println();
                    if(i==1){
                        imprimirSituacao(0, situacaoBloco1);
                        op = entrada();
                        if(op == 'a'){
                            imprimirSituacao(1, situacaoBloco1);
                            op = entrada();
                            if(op == 'a'){
                                //próximo bloco
                                break;
                            } else{
                                saude = 0;
                                System.out.println(textoMorte1[0]);
                                morreu = true;
                                deNovo = deNovo();
                                break;
                            }
                        } else{ //referente à situacao[0]
                            imprimirSituacao(2, situacaoBloco1);
                            op = entrada();
                            if(op == 'a'){
                                imprimirSituacao(3,situacaoBloco1);
                                op = entrada();
                                if(op == 'a'){
                                    saude = 0;
                                    System.out.println(textoMorte1[1]);
                                    morreu = true;
                                    deNovo = deNovo();
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(i==2){
                        imprimirSituacao(4, situacaoBloco1);
                        op = entrada();
                        if(op == 'b'){
                            saude = 0;
                            System.out.println(textoMorte1[2]);
                            morreu = true;
                            deNovo = deNovo();
                            break;
                        }
                    }
                }
            }while(!deNovo);
      
            //deseja continuar?            
            if(morreu == false){
                num = proximoBloco();
                if(num == 1){ //para rodar o próximo bloco
                    deNovo = false;
                    imprimirStatus(saude, arma);
                } else{
                    imprimirStatus(saude, arma);
                    break;
                }
            }

            //BLOCO2
            saudeT = saude; pontosT = pontos; //checkpoint
            while(!deNovo){
                imprimirBreak();
                deNovo = true;
                if(morreu){
                    saude = saudeT;
                    pontos = pontosT;
                    morreu = false;
                }
                
                for(int i=0;i<bloco2.length;i++){
                    System.out.println(bloco2[i]);
                    System.out.println();
                    imprimirSituacao(0, situacaoBloco2);
                    op = entrada();
                    if(op == 'a'){
                        pontos++;
                    } else{
                        imprimirSituacao(1, situacaoBloco2);
                        op = entrada();
                        if(op == 'a'){
                            saude = 0;
                            System.out.println(textoMorte2[0]);
                            morreu = true;
                            deNovo = deNovo();
                            break;
                        } else{
                            pontos++;
                        }
                    }

                    imprimirSituacao(2, situacaoBloco2);
                    op = entrada();
                    if(op == 'a'){
                        saude = 0;
                        System.out.println(textoMorte2[1]);
                        imprimirMorte();
                        morreu = true;
                        deNovo = deNovo();
                        break;
                    }
                }
                
            }
            

            //deseja continuar?            
            if(morreu == false){
                num = proximoBloco();
                if(num == 1){ //para rodar o próximo bloco
                    deNovo = false;
                    imprimirStatus(saude, arma);
                } else{
                    imprimirStatus(saude, arma);
                    break;
                }
            }
            
            //BLOCO3
            saudeT = saude; pontosT = pontos; //checkpoint
            while(!deNovo){
                imprimirBreak();
                deNovo = true; 
                if(morreu){
                    saude = saudeT;
                    pontos = pontosT;
                    morreu = false;
                }
                
                for(int i=0;i<bloco3.length;i++){
                    System.out.println(bloco3[i]);
                    System.out.println();
                    if(i==0){
                        imprimirSituacao(0,situacaoBloco3);
                        op = entrada();
                        switch (op) {
                            case 'a':
                                    arma = "enxada";
                                    break;
                            case 'b':
                                    arma = "tesoura de poda";
                                    break;
                            case 'c':
                                    arma = "pá";
                                    break;
                            case 'd':
                                    arma = "foice";
                                    break;
                            default:
                                    System.out.println("Arma inválida.");
                        }
                    }
                    if(i==1){
                        imprimirSituacao(1,situacaoBloco3);
                        num = geradorAleatorio(2);
                        if(num ==0){
                            System.out.println(textoBloco3A);
                            amigo = true;
                        } else{
                            System.out.println(textoBloco3B);
                        }
                    }
                    if(i==2){
                        imprimirSituacao(2, situacaoBloco3);
                        op = entrada();
                        if(op == 'a' && amigo){
                            saude = 0;
                            System.out.println(morteSit2Amigo);
                            morreu = true;
                            deNovo = deNovo();
                            break;
                        } else if(op=='a' && !amigo){
                            saude = 0;
                            System.out.println(morteSit2);
                            morreu = true;
                            deNovo = deNovo();
                        }
                    }
                }
            }
            
            //deseja continuar?            
            if(morreu == false){
                num = proximoBloco();
                if(num == 1){ //para rodar o próximo bloco
                    deNovo = false;
                    imprimirStatus(saude, arma);
                } else{
                    imprimirStatus(saude, arma);
                    break;
                }
            }
            //BLOCO34
            saudeT = saude; pontosT = pontos; //checkpoint
            while(!deNovo){
                imprimirBreak();
                deNovo = true;
                if(morreu){
                    saude = saudeT;
                    pontos = pontosT;
                    morreu = false;
                }
                for(int i=0;i<bloco34.length;i++){
                    System.out.println(bloco34[0]);
                    System.out.println();
                    imprimirSituacao(0,situacaoBloco34);
                    op=entrada();
                    if(op == 'a'){
                        System.out.println(bloco34[1]);
                        saude = 0;
                        morreu = true;
                        deNovo = deNovo();
                    } else{
                        break;
                    }
                }
            }
            //deseja continuar?            
            if(morreu == false){
                num = proximoBloco();
                if(num == 1){ //para rodar o próximo bloco
                    deNovo = false;
                    imprimirStatus(saude, arma);
                } else{
                    imprimirStatus(saude, arma);
                    break;
                }
            }
            
            //BLOCO4
            saudeT = saude; pontosT = pontos; //checkpoint
            while(!deNovo){
                imprimirBreak();
                deNovo = true;
                if(morreu){
                    saude = saudeT;
                    pontos = pontosT;
                    morreu = false;
                }
                for(int i=0;i<bloco4.length;i++){
                    System.out.println(bloco4[i]);
                    System.out.println();
                    if(i==0){
                        imprimirSituacao(0,situacaoBloco4);
                        op = entrada();
                        if(op == 'a'){
                            pontos++;
                        }
                    }
                    if(i==1){
                        imprimirSituacao(1, situacaoBloco4);
                        op = entrada();
                        if(op == 'b'){
                            pontos++;
                        }
                    }
                }
            }

            //deseja continuar?            
            if(morreu == false){
                num = proximoBloco();
                if(num == 1){ //para rodar o próximo bloco
                    deNovo = false;
                    imprimirStatus(saude, arma);
                } else{
                    imprimirStatus(saude, arma);
                    break;
                }
            }
            
            
            //BLOCO 5
            saudeT = saude; pontosT = pontos; //checkpoint
            while(!deNovo){ 
                imprimirBreak();
//configuração em caso de morte
                deNovo = true; //não repetir o bloco caso não morra
                if(morreu){
                    saude = saudeT;
                    pontos = pontosT;
                    morreu = false;
                }
                
                for(int i=0;i<bloco5.length;i++){
                    System.out.println(bloco5[i]);
                    System.out.println();
                    if(i==0){
                        System.out.print(situacaoBloco5[0][0]);
                        num = geradorAleatorio(3);
                        switch (num) {
                            case 0:
                                System.out.println(situacaoBloco5[0][1]);
                                saude--;
                                System.out.println("    -1 ponto saúde");
                                break;
                            case 1:
                                System.out.println(situacaoBloco5[0][2]);
                                pontos++;
                                break;
                            default:
                                System.out.println(situacaoBloco5[0][3]);
                                break;
                        }
                        if(saude <= 0){
                            imprimirMorte();
                            morreu = true;
                            deNovo = deNovo();
                            break;
                        }
                    }
                    if(i==1){
                        imprimirSituacao(1,situacaoBloco5); //situacao 2
                        op = entrada();
                        if(op == 'a'){
                            pontos++;
                            System.out.println(textoSituacao2);
                            System.out.println();
                        }
                    }
                    if(i==2){
                        imprimirSituacao(2,situacaoBloco5); //situacao 3
                        op = entrada();
                        if(op == 'a'){
                            pontos++;
                        } 
                    }
                    if(i==4){
                        imprimirSituacao(3,situacaoBloco5); //situação 4
                        op = entrada();
                        if(op == 'b'){
                            pontos++;
                        }
                    }
                    if(i==5){
                        saude -= 2;
                        System.out.println("    -2 pontos de saúde");
                        System.out.println();
                        if(saude <= 0){
                            imprimirMorte();
                            morreu = true;
                            deNovo = deNovo();
                            break;
                         }
                    }
                }
            } //fim bloco 5

            //deseja continuar?            
            if(morreu == false){
                num = proximoBloco();
                if(num == 1){ //para rodar o próximo bloco
                    deNovo = false;
                    imprimirStatus(saude, arma);
                } else{
                    imprimirStatus(saude, arma);
                    break;
                }
            }
            
            //bloco 6 (não repete)
            while(!deNovo){
                imprimirBreak();
    /*fica*/    if(pontos >= 4){
                    for(int i=0;i<6;i++){
                        System.out.println(bloco6[i]);
                        System.out.println();
                        if(i==3){
                            num = geradorAleatorio(2);
                            if(num == 0){
                                System.out.println(morteEspecial);
                                saude = 0;
                                break;
                            }
                        }
                    }
                } else{
    /*vaza*/        for(int i=6;i<bloco6.length;i++){
                        System.out.println(bloco6[i]);
                        System.out.println();
                        if(i==7){
                            saude-=2;
                            System.out.println("    -2 ponto de saúde");
                            System.out.println();
                            if(saude <= 0){
                                imprimirMorte();
                                morreu = true;
                                break;
                            }  
                        }
                    }           
                }
                deNovo = true;
            } //fim bloco 6
        }while(!deNovoJogo);
    }
}
