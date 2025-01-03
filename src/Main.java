import java.util.Scanner;
import java.util.ArrayList;

import model.*;
import enums.*;
import service.VeiculoService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VeiculoService vs = new VeiculoService();
        ArrayList<Parada> paradas = new ArrayList<>();
        ArrayList<Rota> rotas = new ArrayList<>();
        ArrayList<Onibus> onibusLista = new ArrayList<>();
        ArrayList<Trem> tremLista = new ArrayList<>();

        // parada
        System.out.print("Quantas paradas deseja adicionar?: ");
        int quantidadeParadas = sc.nextInt();
        sc.nextLine();
        System.out.println("\n");

        for (int i = 0; i < quantidadeParadas; i++) {
            System.out.println("Digite os dados da parada " + (i + 1) + ":");
            int id;

            while (true) {
                System.out.print("ID: ");
                id = sc.nextInt();
                sc.nextLine();

                boolean idExistente = false;
                for (Parada p : paradas) {
                    if (p.getId() == id) {
                        idExistente = true;
                        break;
                    }
                }

                if (idExistente) {
                    System.out.println("Erro: Já existe uma parada com esse ID. Digite um novo ID.");
                } else {
                    break;
                }
            }

            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Localização: ");
            String localizacao = sc.nextLine();

            Parada parada = new Parada(id, nome, localizacao);
            paradas.add(parada);
            vs.cadastrarParada(parada);
        }


        // rota
        System.out.print("Digite o ID da rota: ");
        int idRota = sc.nextInt();
        sc.nextLine();

        while (true) {
            boolean idExistente = false;
            for (Rota r : vs.lerRota()) {
                if (r.getId() == idRota) {
                    idExistente = true;
                    break;
                }
            }

            if (idExistente) {
                System.out.println("Já existe uma rota com esse ID. Digite um novo ID.");
                System.out.print("Digite o ID da rota: ");
                idRota = sc.nextInt();
                sc.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Digite o nome da rota: ");
        String nomeRota = sc.nextLine();

        Rota rota = new Rota(idRota, nomeRota, paradas);
        vs.cadastrarRota(rota);


        // onibus
        System.out.println("Digite os dados do ônibus:");
        System.out.print("ID: ");
        int idOnibus = sc.nextInt();
        sc.nextLine();

        while (true) {
            boolean idExistente = false;
            for (Onibus o : onibusLista) {
                if (o.getId() == idOnibus) {
                    idExistente = true;
                    break;
                }
            }

            if (idExistente) {
                System.out.println("Erro: Já existe um ônibus com esse ID. Digite um novo ID.");
                System.out.print("ID: ");
                idOnibus = sc.nextInt();
                sc.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Modelo: ");
        String modeloOnibus = sc.nextLine();

        Onibus onibus = new Onibus(idOnibus, modeloOnibus, TipoVeiculo.ONIBUS, Status.PARADO, rota);
        onibusLista.add(onibus);


        // trem
        System.out.println("Digite os dados do trem:");
        System.out.print("ID: ");
        int idTrem = sc.nextInt();
        sc.nextLine();

        while (true) {
            boolean idExistente = false;
            for (Trem t : tremLista) {
                if (t.getId() == idTrem) {
                    idExistente = true;
                    break;
                }
            }

            if (idExistente) {
                System.out.println("Erro: Já existe um trem com esse ID. Digite um novo ID.");
                System.out.print("ID: ");
                idTrem = sc.nextInt();
                sc.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Modelo: ");
        String modeloTrem = sc.nextLine();

        Trem trem = new Trem(idTrem, modeloTrem, TipoVeiculo.TREM, Status.PARADO, rota);
        tremLista.add(trem);

        System.out.println("\nInformações dos veículos criados:");
        System.out.println(onibus.getDescricao());
        System.out.println(trem.getDescricao());

        System.out.println("\nOperando os veículos:");
        onibus.iniciarOperacao();
        trem.iniciarOperacao();

        // atualizar ou deletar paradas
        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Listar paradas");
            System.out.println("2. Atualizar uma parada");
            System.out.println("3. Deletar uma parada");
            System.out.println("4. Criar uma nova parada");
            System.out.println("5. Listar rotas");
            System.out.println("6. Atualizar uma rota");
            System.out.println("7. Deletar uma rota");
            System.out.println("8. Criar uma nova rota");
            System.out.println("9. Sair");
            int escolha = sc.nextInt();
            System.out.println("\n");

            switch (escolha) {
                case 1:
                    System.out.println("Paradas cadastradas:");
                    for (Parada parada : vs.lerParada()) {
                        System.out.println(parada);
                    }
                    break;
                case 2:
                    System.out.print("Digite o ID da parada a ser atualizada: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Nova localização: ");
                    String novaLocalizacao = sc.nextLine();

                    Parada paradaAtualizada = new Parada(idAtualizar, novoNome, novaLocalizacao);
                    vs.atualizarParada(idAtualizar, paradaAtualizada);
                    break;
                case 3:
                    System.out.print("Digite o ID da parada a ser deletada: ");
                    int idDeletar = sc.nextInt();
                    sc.nextLine();
                    vs.deletarParada(idDeletar);
                    break;
                case 4:
                    System.out.println("Criando uma nova parada:");
                    System.out.print("ID: ");
                    int idNovaParada = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeNovaParada = sc.nextLine();
                    System.out.print("Localização: ");
                    String localizacaoNovaParada = sc.nextLine();

                    Parada novaParada = new Parada(idNovaParada, nomeNovaParada, localizacaoNovaParada);
                    paradas.add(novaParada);
                    vs.cadastrarParada(novaParada);
                    break;
                case 5:
                    System.out.println("Rotas cadastradas:");
                    for (Rota r : vs.lerRota()) {
                        System.out.println(r);
                    }
                    break;
                case 6:
                    System.out.print("Digite o ID da rota a ser atualizada: ");
                    int idRotaAtualizar = sc.nextInt();
                    sc.nextLine();

                    Rota rotaEncontrada = null;
                    for (Rota r : vs.lerRota()) {
                        if (r.getId() == idRotaAtualizar) {
                            rotaEncontrada = r;
                            break;
                        }
                    }

                    if (rotaEncontrada != null) {
                        System.out.print("Digite o novo nome da rota: ");
                        String novoNomeRota = sc.nextLine();

                        ArrayList<Parada> novasParadas = new ArrayList<>();
                        System.out.println("Selecione as paradas para incluir na rota (atual: " + rotaEncontrada.getParadas().size() + " paradas):");
                        for (Parada parada : vs.lerParada()) {
                            System.out.println(parada.getId() + ": " + parada.getNome() + " (" + parada.getLocalizacao() + ")");
                        }

                        while (true) {
                            System.out.print("Digite o ID da parada para incluir (ou -1 para encerrar): ");
                            int idParada = sc.nextInt();
                            sc.nextLine();
                            if (idParada == -1) {
                                break;
                            }

                            Parada paradaEncontrada = null;
                            for (Parada parada : vs.lerParada()) {
                                if (parada.getId() == idParada) {
                                    paradaEncontrada = parada;
                                    break;
                                }
                            }

                            if (paradaEncontrada != null) {
                                novasParadas.add(paradaEncontrada);
                                System.out.println("Parada adicionada à rota.");
                            } else {
                                System.out.println("Parada não encontrada. Tente novamente.");
                            }
                        }

                        rotaEncontrada.setNome(novoNomeRota);
                        rotaEncontrada.setParadas(novasParadas);
                        vs.atualizarRota(idRotaAtualizar, rotaEncontrada);
                        System.out.println("Rota atualizada com sucesso!");
                    } else {
                        System.out.println("Não foi encontrada uma rota com esse ID.");
                    }
                    break;
                case 7:
                    System.out.print("Digite o ID da rota a ser deletada: ");
                    int idRotaDeletar = sc.nextInt();
                    sc.nextLine();
                    vs.deletarRota(idRotaDeletar);
                    break;
                case 8:
                    System.out.print("Digite o ID da nova rota: ");
                    int idNovaRota = sc.nextInt();
                    sc.nextLine();

                    while (true) {
                        boolean idExistente = false;
                        for (Rota r : vs.lerRota()) {
                            if (r.getId() == idNovaRota) {
                                idExistente = true;
                                break;
                            }
                        }

                        if (idExistente) {
                            System.out.println("Já existe uma rota com esse ID. Digite um novo ID.");
                            System.out.print("Digite o ID da nova rota: ");
                            idNovaRota = sc.nextInt();
                            sc.nextLine();
                        } else {
                            break;
                        }
                    }

                    System.out.print("Digite o nome da nova rota: ");
                    String nomeNovaRota = sc.nextLine();

                    ArrayList<Parada> paradasSelecionadas = new ArrayList<>();
                    System.out.println("Selecione as paradas que deseja incluir na rota:");
                    for (Parada parada : vs.lerParada()) {
                        System.out.println(parada.getId() + ": " + parada.getNome() + " (" + parada.getLocalizacao() + ")");
                    }

                    while (true) {
                        System.out.print("Digite o ID da parada para incluir (ou -1 para encerrar): ");
                        int idParada = sc.nextInt();
                        sc.nextLine();
                        if (idParada == -1) {
                            break;
                        }

                        Parada paradaEncontrada = null;
                        for (Parada parada : vs.lerParada()) {
                            if (parada.getId() == idParada) {
                                paradaEncontrada = parada;
                                break;
                            }
                        }

                        if (paradaEncontrada != null) {
                            paradasSelecionadas.add(paradaEncontrada);
                            System.out.println("Parada adicionada à rota.");
                        } else {
                            System.out.println("Parada não encontrada. Tente novamente.");
                        }
                    }

                    Rota novaRota = new Rota(idNovaRota, nomeNovaRota, paradasSelecionadas);
                    vs.cadastrarRota(novaRota);
                    System.out.println("Nova rota criada com sucesso!");
                    break;
                case 9:
                    System.out.println("Encerrando.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}