package com.algaworks.algafood.api;

import com.algaworks.algafood.domain.model.*;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroRestauranteIT {


    int quantidadeRestaurantesCadastrados;
    public String jsonRestauranteCorreto = ResourceUtils.getContentFromResource("/json/correto/restaurante-new-york-barbacue.json");
    public String jsonRestauranteSemCozinha = ResourceUtils.getContentFromResource("/json/incorreto/restaurante-new-york-barbacue-sem-cozinha.json");
    public String jsonRestauranteSemTaxaFrete = ResourceUtils.getContentFromResource("/json/incorreto/restaurante-new-york-barbacue-sem-taxa-frete.json");


    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Before
    public void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/restaurantes";
        databaseCleaner.clearTables();
        prepararDados();
    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarRestaurantes(){

        given()
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornarStatus2Restaurantes_QuandoConsultarRestaurantes(){

        given()
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .body("", hasSize(quantidadeRestaurantesCadastrados));

    }

    @Test
    public void deveRetornarStatus201_QuandoCadastrarRestaurante(){

        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(jsonRestauranteCorreto)
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.CREATED.value());

    }

    @Test
    public void deveRetornarStatus400_QuandoCadastrarRestauranteSemCozinha(){

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonRestauranteSemCozinha)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }


    @Test
    public void deveRetornarStatus400_QuandoCadastrarRestauranteSemTaxaFrete(){

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonRestauranteSemTaxaFrete)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }

    private void prepararDados(){

        Cozinha cozinhaTailandesa = new Cozinha();
        cozinhaTailandesa.setNome("Tailandesa");
        cozinhaTailandesa= cozinhaRepository.save(cozinhaTailandesa);

        Estado estado = new Estado();
        estado.setNome("Paraíba");
        estado = estadoRepository.save(estado);

        Cidade cidade = new Cidade();
        cidade.setNome("Campina Grande");
        cidade.setEstado(estado);
        cidade = cidadeRepository.save(cidade);


        Endereco enderecoTai = new Endereco();
        enderecoTai.setBairro("Bodocongó");
        enderecoTai.setCep("58428757");
        enderecoTai.setCidade(cidade);
        enderecoTai.setComplemento("Proximo ao bodoc");
        enderecoTai.setLogradouro("Rua Pedro feitosa neves");
        enderecoTai.setNumero("465");

        Restaurante restauranteTai = new Restaurante();
        restauranteTai.setCozinha(cozinhaTailandesa);
        restauranteTai.setNome("Tailandesa Delivery");
        restauranteTai.setEndereco(enderecoTai);
        restauranteTai.setTaxaFrete(BigDecimal.valueOf(10));
        restauranteRepository.save(restauranteTai);

        Cozinha cozinhaAmericana = new Cozinha();
        cozinhaAmericana.setNome("Americana");
        cozinhaAmericana = cozinhaRepository.save(cozinhaAmericana);

        Endereco enderecoBurgerTop = new Endereco();
        enderecoTai.setBairro("Prata");
        enderecoTai.setCep("58428757");
        enderecoTai.setCidade(cidade);
        enderecoTai.setComplemento("Proximo ao bodoc");
        enderecoTai.setLogradouro("Rua Pedro feitosa neves");
        enderecoTai.setNumero("465");

        Restaurante restauranteBurger = new Restaurante();
        restauranteBurger.setCozinha(cozinhaAmericana);
        restauranteBurger.setNome("Burger Delivery");
        restauranteBurger.setEndereco(enderecoBurgerTop);
        restauranteBurger.setTaxaFrete(BigDecimal.valueOf(10));
        restauranteBurger = restauranteRepository.save(restauranteBurger);

        quantidadeRestaurantesCadastrados = (int) restauranteRepository.count();


    }

}
