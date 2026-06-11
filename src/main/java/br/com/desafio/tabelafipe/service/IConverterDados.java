package br.com.desafio.tabelafipe.service;

import java.util.List;

public interface IConverterDados {
    <T> T converterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
