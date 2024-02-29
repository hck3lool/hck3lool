// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

import Ajv from "ajv";

Cypress.Commands.add('validateSchema', (responseBody, schema) => {
    const ajv = new Ajv({ allErrors: true });
    const valid = ajv.validate(schema, responseBody);
    expect(valid, JSON.stringify(ajv.errors)).to.equal(true);
});

Cypress.Commands.add('requestSend', (method, url, body, expectedStatusCode, schema) =>{
    cy.request({ method: method, url: url, body:body}).then( (response) =>{
        cy.validateSchema(response.body, schema)
        expect(response.status).to.equal(expectedStatusCode)
    })
});

Cypress.Commands.add('requestBad', (url, expectedStatusCode) =>{
    cy.request({url: url, failOnStatusCode: false}).its('status').should('equal', expectedStatusCode)
});