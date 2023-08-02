import java.util.*;
public final class Armazém extends Obstaculos {
    Scanner scanner = new Scanner(System.in);

    public Armazém(boolean completo, Luca luca, Pr0t0 robo) {
        super(completo, luca, robo);
    }

    @Override
    public void desafio() {
        completo = true;
        System.out.println("Após entrar na convenção Luca corre pelos corredores tentando se afastar de guardas e do público, achando um local sem muito movimento, ele começa a reparar Pr0t0 com engrenagens tiradas de caixas espalhadas pelo local, quando termina, começa a olhar em volta por alguma direção. Depois de um tempo finalmente encontra um mapa do local, rapidamente achando a sua localização atual dentro de um armazém. Achando o palco principal e traçando um caminho, Luca percebe que está bem perto de uma entrada por debaixo do palanque usada como ligação para o armazém.   \n\n");
        System.out.println("Por um tempo ele avança desimpedido, contudo quanto mais perto chegava, maior ficava não apenas o barulho da arquibancada como também o movimento pelo armazém.");
        System.out.println("Luca para perto da porta de uma sala, ele tem que atrvesa-la para chegar a seu destino, do outro lado barulho de risadas e conversa do que provavelmente são guardas");
        do {
            System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            System.out.println("Antes de invadir, você tem tempo de criar invenções mais complexas para lhe auxiliar, elas usam 100 engrenagens mas são bem potentes.");
            System.out.println("1) Uma granada de engrenagens vai atordoa-los lhe dando o primeiro movimento"); //Se conseguir ganhar a batalha no primeiro turno com uma rolagem critica do Pr0t0 dá pra entrar antes que o portão feche
            System.out.println("2) Uma máquina feita com o objetivo de dar defeito, a fumaceira que vai sair dela será uma mistura de distração e cobertura que vão lhe dar uma boa chance de ignorar o confronto inteiro."); //Ver como exatamente farei sobre o combate, algo como dano toda rodada até resolver o problema?
            System.out.println("3) Eles não valhem as suas engrenagens, mande o Pr0t0 pra cima e mostre quem que manda!"); //Escolha de gastar peças para ajuda-lo, ganhará a manivela
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            switch (action) {
                case 1:
                    if(luca.engrenagens >= 100) {
                        luca.poderEspecial(-100);
                        System.out.println("Você joga a granada que gera um som ensurdecedor, logo após Pr0t0 invade a sala onde os oponentes ainda se encontram aotrdoados ");
                        combate(10, -70, -130, -150, -1, 1);
                    } else {
                        System.out.println("Você começa a pegar as peças mas vê que não tem o bastante, você terá que invadir sem esse suporte.");
                        combate(10, -70, -130, -150, 0, 1);
                    }
                    break;
                case 2:
                    if(luca.engrenagens >= 100) {
                        luca.poderEspecial(-100);
                        System.out.println("A máquina começa a funcionar gerando um cheiro de queimado e exalando fumaça negra para todos os lados.");
                        int n = rand.nextInt(4);
                        switch (n) {
                            case 1:
                            case 2:
                            case 3:
                                System.out.println("Os guardas correm desesperados tentando achar a fonte do problema, a fumaça é capaz de cobrir até mesmo a grande figura de Pr0t0 e vocês passam desapercebidos.");
                                break;
                            case 4:
                                System.out.println("A distração é boa o bastante para que os soldados não percebessem as suas presenças até o ponto que um terminou batendo o dedão do pé na perna de Pr0t0 e logo o combate começa.");
                                combate(10, -70, -130, -150, 0, 1);
                                break;
                        }
                    } else {
                        System.out.println("Você começa a pegar as peças mas vê que não tem o bastante, você terá que invadir sem esse suporte.");
                        combate(10, -70, -130, -150, 0, 1);
                    }
                    break;
                case 3:
                    combate(10, -70, -130, -150, 0, 1);
                    break;
                default:
                    System.out.printf("Entrada inválida\n");
                    completo = false;
                    break;
            }
        } while (completo == false);

        System.out.println("Você mais uma vez ouve uma comoção a frente, dessa vez parecem diversas pessoas andando de um lado para o outro como se em patrulha, mais uma vez, como proseguir?");
        do {
            System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            System.out.println("Antes de invadir, você tem tempo de criar invenções mais complexas para lhe auxiliar, elas usam 100 engrenagens mas são bem potentes.");
            System.out.println("1) Uma granada de engrenagens vai atordoa-los lhe dando o primeiro movimento"); //Se conseguir ganhar a batalha no primeiro turno com uma rolagem critica do Pr0t0 dá pra entrar antes que o portão feche
            System.out.println("2) Uma máquina feita com o objetivo de dar defeito, a fumaceira que vai sair dela será uma mistura de distração e cobertura que vão lhe dar uma boa chance de ignorar o confronto inteiro."); //Ver como exatamente farei sobre o combate, algo como dano toda rodada até resolver o problema?
            System.out.println("3) Eles não valhem as suas engrenagens, mande o Pr0t0 pra cima e mostre quem que manda!"); //Escolha de gastar peças para ajuda-lo, ganhará a manivela
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            switch (action) {
                case 1:
                case 2:
                    if(luca.engrenagens >= 100) {
                        luca.poderEspecial(-100);
                        System.out.println("Sua invenção é concluida, você a coloca em uso e entra na sala com Pr0t0 se deparando com...");
                        System.out.println("...diversos carregadores organizando as coisas no armazém, no caos eles tentam se reorganizar e escapar da sala em desespero. ");
                    } else {
                        System.out.println("Você começa a pegar as peças mas vê que não tem o bastante, você terá que invadir sem esse suporte, ao entrar os barulhos param quando Pr0t0 é prontamente fitado por diversos carregadores atônitos que logo abrem passagem para o gigante mecãnico.");
                    }
                    break;
                case 3:
                    System.out.println("Você ordena Pr0t0 a entrar com o pé na porta abrindo caminho a força, e logo se depara com um grupo de diversos carregadores atônitos que logo abrem passagem para o gigante mecãnico.");
                    break;
                default:
                    System.out.printf("Entrada inválida\n");
                    completo = false;
                    break;
            }
        } while (completo == false);
        System.out.println("Da próxima vez talvez seja melhor olhar quem estava na sala antes de sair invadindo que nem maluco.\n\n");

        System.out.println("Luca avança desimpedido por um tempo, chegando cada vez mais perto de seu objetivo, contudo em uma sala perto do final do caminho ele vê algo que o deixa em um dilema, um robô de carga está levando caixotes para uma plataforma, desmontar esse robô poderia render diversas engrenagens e uma bobina, contudo nesta sala, desativado no canto ,tem um robô de combate, eles são extremamente poderosos e tem uma chance de explodir caso sejam derrotados para que levem seus inimigos com eles.");
        do {
            System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            System.out.println("Você deve escolher com sabedoria se vai:");
            System.out.println("1) Atacar o robô de carga antes que ele saia para que possa desmonta-lo e pegar suas peças.");
            System.out.println("2) Atacar o robô de combate ainda descançando ganhando uma vantagem no combate.");
            System.out.println("3) Tentar passar despercebido pelo robô, contanto que ele esteja em repouso, deve ter como passar pelos seus scanners sem ativa-lo.");
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            switch (action) {
                case 1:
                    System.out.println("Você ataca o robô de carga o desarmando em um ataque, o robô de combate começa a levantar, você poderá pegar sua presa após derrota-lo.");
                    combate(20, -70, -100, -150, 0, 5);//Não pode derrotar usando fuga para pegar o robo de carga
                    //combate(20, 0, 0, 0, 0, 5);
                    break;
                case 2:
                    System.out.println("Você avança direto no robo para pegar a iniciativa ao invés de contar com sorte.");
                    combate(20, -70, -100, -150, -1, 4);
                    break;
                case 3:
                    int n = rand.nextInt(4);
                    switch (n) {
                        case 1:
                        case 2:
                            System.out.println("Vocês são capazes de passar pela sala, o robô carregador sai pela plataforma ficando fora de seu alcance, mesmo assim talvez essa tenha sido a melhor escolha.");
                            break;
                        case 3:
                        case 4:
                            System.out.println("Você tenta passar escondido mas Pr0t0 termina encostando em uma caixa, o pequeno movimento é detectado e o robô se ativa na hora, pronto para o combate.");
                            combate(20, -70, -100, -150, 0, 4);
                            break;
                    }
                    break;
                default:
                    System.out.printf("Entrada inválida\n");
                    completo = false;
                    break;
            }
        } while (completo == false);
    }

    @Override
    public void combate(int vida, int danoLeve, int danoNormal, int danoCritico, int turno, int id) {
        boolean armadilha = false;
        if(id == 1) {System.out.println("Os guardas aqui são claramente de elite comparado com os da entrada.");}
        do {
            if(id == 1 && turno >= 0) {System.out.println("Os soldados se posicionam em volta de Pr0t0 prontos para o combate!");} else {
                System.out.println("O robo de combate se prosta de pé, ativado ");
            }
            if(id > 3 && turno < 0) {System.out.println("Mas antes que ele consiga agir, com a vantagem de iniciativa, Pr0t0 e Luca começam na dianteira ");}
            System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            luca.agir(); //Se o id do inimigo for maior que 4 a granada de bobina funciona nele, simplifica bastante assim.
            int dano = robo.agir();
            if (luca.traquinagem == 2) {
                vida = 0;
            }
            vida = vida - dano;
            if(vida > 0 && turno >= 0) {
                System.out.println("Os inimigos agem!");
                int n = rand.nextInt(10);
                if (luca.getTraquinagem() == 1) {
                    System.out.println("Entre pedradas e gritaria de Luca, os inimigos tem mais dificuldade em atacar Pr0t0.");
                    n = n - 1;
                }
                if (armadilha == true) {
                    System.out.println("A invenção reduz o dano dos ataques vindouros");
                    robo.setProteção(1);
                }
                switch (n) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        System.out.println("Um ataque é acertado em Pr0t0.");
                        interageComPersonagem(robo, danoNormal);
                        break;
                    case 9:
                    case 10:
                        System.out.println("Um ataque se finca nas engrenagens de Pr0t0!");
                        interageComPersonagem(robo, danoCritico);
                        break;
                    default:
                        System.out.println("Os ataques apenas raspam em Pr0t0 causando algum dano, mas nada tão considerável");
                        interageComPersonagem(robo, danoLeve);
                        break;
                }
            }
            if (luca.getTraquinagem() == 3) {
                int engrenagens = robo.getEngrenagens() + 100;
                robo.setEngrenagens(engrenagens);
                System.out.println("Luca terminou os reparos.");
                //A nova vida aparece no inicio do turno
            }
            if (luca.getTraquinagem() == 4) {
                System.out.println("Luca joga a armadilha, os inimigos se vêem com o ataque debilitado.");
                armadilha = true;
            }
            if (luca.getTraquinagem() == 5) {
                System.out.println("Luca Joga a granada de bobina...");
                if (id > 3) {
                    System.out.println("...fritando os circuitos do alvo.");
                    vida = vida - 20;
                    armadilha = true;
                } else {
                    System.out.println("...Sem efeito algum.");
                }
            }
            turno++;
        } while (vida > 0);
        if(id > 3 && luca.getTraquinagem() != 2) {
            System.out.println("Um barulho de tic tac começa, o robo vai explodir, não há nada que Luca possa fazer, apenas Pr0t0 tem tempo de agir para se defender.");
            robo.agir();
            int n = rand.nextInt(4);
            switch (n) {
                case 1:
                case 2:
                case 3:
                    System.out.println("O tictatear para seguido da explosão");
                    interageComPersonagem(robo, -300);
                    break;
                case 4:
                    System.out.println("O tictatear para seguido de silêncio, a bomba não explodiu! Que sorte.");
                    break;
            }
            robo.setProteção(0);
        }
        if (id == 5) {
            if(!(luca.getTraquinagem() == 2)) {
                System.out.println("Você derrota a maquina e consegue pegar sua recompença.");
                interageComPersonagem(luca, 700);
                System.out.println("Você ganhou uma bobina.");
                luca.adicionarItem(3);
            } else {
                System.out.println("Você escapa do robô de combate, contudo não pode pegar as peças do robô de carga.");
            }
        } //Não precisa de mensagem pra falar que fugiram pois a própria fuga já fala disso!
        System.out.println("E finalmente, chega a seu destino.");
    }
}
