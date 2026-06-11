package br.com.desafio.tabelafipe.principal;

import br.com.desafio.tabelafipe.model.Dados;
import br.com.desafio.tabelafipe.model.Modelos;
import br.com.desafio.tabelafipe.model.Veiculo;
import br.com.desafio.tabelafipe.service.ConsomeApi;
import br.com.desafio.tabelafipe.service.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsomeApi consomeApi = new ConsomeApi();
    private ConverterDados conversor = new ConverterDados();

    public void exibirMenu() {
        String menu = """
                      ***** OPÇÕES *******
                      
                      - Carros
                      - Motos
                      - Caminhões
                      
                      ********************
                      
                      Digite uma opção para consultar: 
                      """;
        System.out.println(menu);
        String tipoVeiculo = leitor.nextLine();
        String endereco = "";

        if (tipoVeiculo.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (tipoVeiculo.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else if (tipoVeiculo.toLowerCase().contains("cami")) {
            endereco = URL_BASE + "caminhoes/marcas";
        } else {
            System.out.println("Opção inválida!");
        }

        String json = consomeApi.obterDados(endereco);
        List<Dados> marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite o código da marca para visualizar os modelos: ");
        String codigoMarca = leitor.nextLine();
        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consomeApi.obterDados(endereco);
        Modelos listaModelos = conversor.converterDados(json, Modelos.class);
        listaModelos.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do modelo do veículo: ");
        String modeloVeiculo = leitor.nextLine();
        List<Dados> modelosFiltrados = listaModelos.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(modeloVeiculo.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite o código do modelo que deseja ver os preços: ");
        String codigoModelo = leitor.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consomeApi.obterDados(endereco);
        List<Dados> listaAnos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < listaAnos.size(); i++) {
            String enderecoFiltrado = endereco + "/" + listaAnos.get(i).codigo();
            json = consomeApi.obterDados(enderecoFiltrado);
            Veiculo veiculo = conversor.converterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);

    }
}
