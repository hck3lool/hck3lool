const schemaPokemonList = {
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "count": {
      "type": "integer"
    },
    "next": {
      "type": "string"
    },
    "previous": {
      "anyOf": [
        {
          "type": "string"
        },
        {
          "type": "null"
        }
      ]
    },
    "results": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "name": {
            "type": "string"
          },
          "url": {
            "type": "string"
          }
        },
        "required": ["name", "url"]
      }
    }
  },
  "required": ["count", "next", "previous", "results"]
};

describe('Pruebas para RESTAPI - POKEAPI', () => {
  it('Obtener los primero pokemones de la serie', () => {

    cy.log("----------------------------------")
    const url = 'https://pokeapi.co/api/v2/pokemon?limit=10&offset=0'
    const methodRest = 'GET'

    cy.log(url)
    cy.log(methodRest)

    cy.requestSend(methodRest, url, null, 200, schemaPokemonList)
  })
})