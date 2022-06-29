package com.br.currentweather.steps;

import com.br.currentweather.support.api.WeatherApi;
import com.br.currentweather.support.domain.City;
import com.br.currentweather.utils.RestActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

import java.util.List;


@Log4j2
public class WeatherSteps {

    private Response response;
    private City city;
    private final WeatherApi weatherApi;
    private final RestActions restActions;

    public WeatherSteps() {
        weatherApi = new WeatherApi();
        restActions = new RestActions();
    }

    @Quando("realizar uma consulta no endpoint weather sem token de autenticação")
    public void realizarUmaConsultaNoEndpointWeatherSemTokenDeAutenticação() {
        log.info("Quando realizar uma consulta no endpoint weather sem token de autenticação");
        response = weatherApi.getWeatherWithoutAuth();
        log.info(restActions.getRequestLog());
    }

    @Entao("a API deve retornar o status code")
    public void aAPIDeveRetornarOStatusCode(DataTable dataTable) {
        List<String> data = dataTable.asList();
        Assert.assertEquals(Integer.parseInt(data.get(1)), response.getStatusCode());
        log.info("Entao a API deve retornar o status code:" + data.get(1));
        log.info(restActions.getResponseLog());
    }

    @E("uma mensagem informando o erro")
    public void umaMensagemInformandoOErro(DataTable dataTable) {
        List<String> data = dataTable.asList();
        Assert.assertEquals(data.get(1), response.body().jsonPath().get("message"));
        log.info("E uma mensagem informando o erro: " + data.get(1));
    }

    @Dado("queira buscar o clima de uma cidade por nome")
    public void queiraBuscarOClimaDeUmaCidadePorNome(DataTable dataTable) {
        log.info("Dado queira buscar o clima de uma cidade por nome");
        List<String> data = dataTable.asList();
        city = City.builder()
                .cityName(data.get(3))
                .countryCode(data.get(4))
                .units(data.get(5))
                .build();

        log.info("City name entered:: " + city.getCityName() + "," + "country: " + city.getCountryCode() + ".");
    }

    @Quando("inserir o nome da cidade invalido")
    @Quando("inserir o nome e Pais da cidade")
    public void inserirONomeEPaisDaCidade() {
        log.info("Quando inserir o nome e Pais da cidade");
        response = weatherApi.getWeatherByName(city);
        log.info(restActions.getRequestLog());
    }

    @Entao("deve ser retornado os dados do clima da cidade definida")
    public void deveSerRetornadoOsDadosDoClimaDaCidadeDefinida() {
        log.info("Entao deve ser retornado os dados do clima da cidade definida");
        log.info(restActions.getResponseLog());
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Dado("queira buscar o clima de uma cidade por id")
    public void queiraBuscarOClimaDeUmaCidadePorId(DataTable dataTable) {
        log.info("Dado queira buscar o clima de uma cidade por id");
        List<String> data = dataTable.asList();
        city = City.builder()
                .id(data.get(2))
                .units(data.get(3))
                .build();
        log.info("City id entered: " + city.getId() + ".");

    }

    @Quando("inserir o id da cidade invalido")
    @Quando("inserir o id da cidade")
    public void inserirOIdDaCidade() {
        log.info("Quando inserir o id da cidade");
        response = weatherApi.getWeatherById(city);
        log.info(restActions.getRequestLog());
    }

    @E("a seguinte mensagem")
    public void aSeguinteMensagem(DataTable dataTable) {

        List<String> data = dataTable.asList();
        Assert.assertEquals(data.get(1), response.body().jsonPath().get("message"));
        log.info("E a seguinte mensagem: " + data.get(1));
    }

    @Dado("queira buscar o clima de uma cidade por coordenadas")
    public void queiraBuscarOClimaDeUmaCidadePorCoordenadas(DataTable dataTable) {
        log.info("Dado queira buscar o clima de uma cidade por coordenadas");
        List<String> data = dataTable.asList();
        city = City.builder()
                .latitude(data.get(3))
                .longitude(data.get(4))
                .units(data.get(5))
                .build();
        log.info("City coordinates entered: " + "Latitude-> " + city.getLatitude() + " Longititude: " + city.getLongitude() + ".");

    }

    @Quando("inserir as coordenadas da cidade")
    public void inserirAsCoordenadasDaCidade() {
        log.info("Quando inserir as coordenadas da cidade");
        response = weatherApi.getWeatherByCordinates(city);
        log.info(restActions.getRequestLog());
    }

    @Dado("queira buscar o clima de uma cidade por zipCode")
    public void queiraBuscarOClimaDeUmaCidadePorZipCode(DataTable dataTable) {
        log.info("Dado queira buscar o clima de uma cidade por zipCode");
        List<String> data = dataTable.asList();
        city = City.builder()
                .zipCode(data.get(2))
                .units(data.get(3))
                .build();
        log.info("City zipCode entered:: " + city.getZipCode() + ".");

    }

    @Quando("inserir um zipCode da cidade invalido")
    @Quando("inserir o zipCode da cidade")
    public void inserirOZipCodeDaCidade() {
        log.info("Quando inserir o zipCode da cidade");
        response = weatherApi.getWeatherByZipCode(city);
        log.info(restActions.getRequestLog());
    }

}
