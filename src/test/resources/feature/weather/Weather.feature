#language: pt
#encoding: UTF-8
#Author: Marcos Paulo
#Date: 26/06/2022
#version: 2.0

@weather
Funcionalidade: Suite comtemplando os cenarios de consulta de clima do endpoint weather


  @smoketest @semToken
  Cenario: Nao deve acessar a API sem token
    Quando realizar uma consulta no endpoint weather sem token de autenticação
    Entao a API deve retornar o status code
      | statusCode |
      | 401        |
    E uma mensagem informando o erro
      | message                                                                           |
      | Invalid API key. Please see http://openweathermap.org/faq#error401 for more info. |

  @smoketest @climaPorNome
  Cenario: Buscar clima por nome da cidade
    Dado queira buscar o clima de uma cidade por nome
      | cityName | state | units  |
      | Sergipe  | BR    | metric |
    Quando inserir o nome e Pais da cidade
    Entao deve ser retornado os dados do clima da cidade definida


  @smoketest @climaPorId
  Cenario: Buscar clima por Id da cidade
    Dado queira buscar o clima de uma cidade por id
      | idCity  | units  |
      | 3447799 | metric |
    Quando inserir o id da cidade
    Entao deve ser retornado os dados do clima da cidade definida

  @smoketest @climaPorCoordenadas
  Cenario: Buscar clima por Coordenadas da cidade
    Dado queira buscar o clima de uma cidade por coordenadas
      | latitude | longitude | units  |
      | -10.5    | 37.5      | metric |
    Quando inserir as coordenadas da cidade
    Entao deve ser retornado os dados do clima da cidade definida

  @smoketest @climaPorZip
  Cenario: Buscar clima por Zip Code da cidade
    Dado queira buscar o clima de uma cidade por zipCode
      | zipCode | units  |
      | 32789   | metric |
    Quando inserir o zipCode da cidade
    Entao deve ser retornado os dados do clima da cidade definida


  @smoketest @climaPorZipInvalido
  Cenario: Buscar clima por Zip code invalido da cidade
    Dado queira buscar o clima de uma cidade por zipCode
      | zipCode | units  |
      | 1436366 | metric |
    Quando inserir um zipCode da cidade invalido
    Entao a API deve retornar o status code
      | statusCode |
      | 404        |
    E a seguinte mensagem
      | message        |
      | city not found |

  @smoketest @climaPorIdInvalido
  Cenario: Buscar clima por id invalido da cidade
    Dado queira buscar o clima de uma cidade por id
      | idCity  | units  |
      | 3417799 | metric |
    Quando inserir o id da cidade invalido
    Entao a API deve retornar o status code
      | statusCode |
      | 404        |
    E a seguinte mensagem
      | message        |
      | city not found |

  @smoketest @climaPorNomeInvalido
  Cenario: Buscar clima por nome invalido da cidade
    Dado queira buscar o clima de uma cidade por nome
      | cityName    | state   | units  |
      | invalidCity | invalid | metric |
    Quando inserir o nome da cidade invalido
    Entao a API deve retornar o status code
      | statusCode |
      | 404        |
    E a seguinte mensagem
      | message        |
      | city not found |

