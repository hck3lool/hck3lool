const usersListSchema =
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "number"
    },
    "name": {
      "type": "string"
    },
    "username": {
      "type": "string"
    },
    "email": {
      "type": "string"
    },
    "address": {
      "type": "object",
      "properties": {
        "street": {
          "type": "string"
        },
        "suite": {
          "type": "string"
        },
        "city": {
          "type": "string"
        },
        "zipcode": {
          "type": "string"
        },
        "geo": {
          "type": "object",
          "properties": {
            "lat": {
              "type": "string"
            },
            "lng": {
              "type": "string"
            }
          },
          "required": ["lat", "lng"]
        }
      },
      "required": ["street", "suite", "city", "zipcode", "geo"]
    },
    "phone": {
      "type": "string"
    },
    "website": {
      "type": "string"
    },
    "company": {
      "type": "object",
      "properties": {
        "name": {
          "type": "string"
        },
        "catchPhrase": {
          "type": "string"
        },
        "bs": {
          "type": "string"
        }
      },
      "required": ["name", "catchPhrase", "bs"]
    }
  },
  "required": ["id", "name", "username", "email", "address", "phone", "website", "company"]
}

const postsListSchema =
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "userId": {
      "type": "number"
    },
    "id": {
      "type": "number"
    },
    "title": {
      "type": "string"
    },
    "body": {
      "type": "string"
    }
  },
  "required": ["userId", "id", "title", "body"]
}

const commentsListSchema =
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "postId": {
      "type": "number"
    },
    "id": {
      "type": "number"
    },
    "name": {
      "type": "string"
    },
    "email": {
      "type": "string"
    },
    "body": {
      "type": "string"
    }
  },
  "required": ["postId", "id", "name", "email", "body"]
}

const albumsListSchema =
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "userId": {
      "type": "number"
    },
    "id": {
      "type": "number"
    },
    "title": {
      "type": "string"
    }
  },
  "required": ["userId", "id", "title"]
}

const photosListSchema =
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "albumId": {
      "type": "number"
    },
    "id": {
      "type": "number"
    },
    "title": {
      "type": "string"
    },
    "url": {
      "type": "string"
    },
    "thumbnailUrl": {
      "type": "string"
    }
  },
  "required": ["albumId", "id", "title", "url", "thumbnailUrl"]
}

const todosListSchema =
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "userId": {
      "type": "number"
    },
    "id": {
      "type": "number"
    },
    "title": {
      "type": "string"
    },
    "completed": {
      "type": "boolean"
    }
  },
  "required": ["userId", "id", "title", "completed"]
}

describe('Pruebas para RESTAPI - jsonPlaceHolder', () => {

  beforeEach(() => {
    cy.log("----------------------------------------")
  })

  it('Obtener el primer usuario de la lista', () => {
    const url = 'https://jsonplaceholder.typicode.com/users/1'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, usersListSchema)
  })

  it('Verificar status de un usuario inexistente', () => {
    const url = 'https://jsonplaceholder.typicode.com/users/0'
    const expectedStatusCode = 404
    cy.requestBad(url, expectedStatusCode)
  })

  it('Obtener el primer post de la lista', () => {
    const url = 'https://jsonplaceholder.typicode.com/posts/1'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, postsListSchema)
  })

  it('Obtener el primer comentario de la lista', () => {
    const url = 'https://jsonplaceholder.typicode.com/comments/1'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, commentsListSchema)
  })

  it('Obtener el primer album de la lista', () => {
    const url = 'https://jsonplaceholder.typicode.com/albums/1'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, albumsListSchema)
  })

  it('Obtener la primera foto de la lista', () => {
    const url = 'https://jsonplaceholder.typicode.com/photos/1'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, photosListSchema)
  })

  it('Obtener el primer todos de la lista', () => {
    const url = 'https://jsonplaceholder.typicode.com/todos/1'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, todosListSchema)
  })

  afterEach(() => {
    cy.log("----------------------------------------")
  })
})