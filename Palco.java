import java.util.*;
public final class Palco extends Obstaculos {
    Scanner scanner = new Scanner(System.in);

    public Palco(boolean completo, Luca luca, Pr0t0 robo) {
        super(completo, luca, robo);
    }

    @Override
    public void desafio() {
        System.out.println("Você consegue ouvir o barulho dai de baixo, as arquibancadas estão lotadas, esse é o público que você queria, quando Luca termina os reparos e revisões finais de Pr0t0, o evento principal logo se iniciaria, ele continua avançando na direção correta, e, quando chega logo abaixo do palco, ele encontra um homem de meia idade, e seu robô. \n");
        System.out.println("O locutor do evento começa a falar:");
        System.out.println("- Senhoras e senhoras, tenho o prazer de apresentar para vocês um dos maiores inventores de nosso tempo, Lockwood que veio aqui hoje para apresentar...");
        System.out.println("- Ei, pera, cadê ele? \n\n");
        System.out.println("Debaixo do palco, os 2 inventores discutem.");
        System.out.println("- Suma garoto, tudo que você está fazendo é criar confusão, eu me recuso a deixar um pestinha como você subir no palco com uma atitude dessas.");
        System.out.println("- E quem disse que preciso de sua permissão? Retorna Luca irritado.");
        System.out.println("- Que assim seja então, vamos resolver isso de uma vez.");
        combate(40, -80, -120, -150, 0, 6);
        //combate(40, 0, 0, 0, 0, 6);
        System.out.println("A batalha continua por um tempo, nada parecia tirar os 2 do confronto até que as sirenes começaram a tocar. O confronto deles em baixo do palco começa a causar danos na estrutura da construção.");
        System.out.println("Ambos inventores param seu combate e saem em buscade tentar reverter o problema, as arquiancadas estão desabando com as pessoas ainda tentando evacuar, a plataforma cada vez mais instável, nesse momento Luca mandam seu robô segurar a estrutura para dar mais tempo ao resgate.");
        System.out.println("Ao invés de aproveitar a oportunidade para mandar os guardas tirarem Luca do palco, Lockwood manda os guardas e seu robô lhe ajudarem, a evacuação é tensa, mas com ambos behemoths de metal sustentando a plataforma e os guardas evacuando a multidão, o jornal do dia seguinte conta de um inventor mirim com muito potencial que ajudou o renomado Lockwood a impedir um acidente no evento. Contudo Luca não estava feliz com o resultado, suas ações que causaram o acidente e, muito mais do que fama, como um inventor seu objetivo deveria ser resolver problemas, não ocasiona-los. Mesmo assim, com a lição aprendida deveria redobrar os esforços para a Convenção do ano que vem, dessa vez, faria as coisas de forma legítima. ");
    }


    @Override
    public void combate(int vida, int danoLeve, int danoNormal, int danoCritico, int turno, int id) {
        boolean armadilha = false;
        System.out.println("De trás de Lockwood, um robô de um modelo que o Luca nunca viu antes aparece, o robô parece resistente e ágil, com mecanismos que ele desconhecia, sem duvida uma invenção nova.");
        do {
            System.out.println("A nova invenção de Lockwood se coloca na frente de seu objetivo final.");
            if(turno % 3 == 0 && turno != 0) {System.out.println("O robô de Lockwood assume uma posição estranha e começa a fazer faiscas como se carregando um ataque");}
            System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            luca.agir();
            int dano = robo.agir();
            if (luca.traquinagem == 2) {
                System.out.println("Contudo ele se recusa a fugir agora, é pra isso que ele veio afinal de contas.");
            }
            vida = vida - dano;
            if(vida > 0 && turno >= 0) {
                System.out.println("Os inimigos agem!");
                if(turno % 3 == 0 && turno != 0) {
                    System.out.println("O robô solta um ataque extremamente potente, contudo é evidente que ele mesmo se danifica para fazer isso.");
                    interageComPersonagem(robo, -600);
                    vida = vida - 10;
                } else {
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
        //Aqui vai ter a finalização do jogo
    }
}

