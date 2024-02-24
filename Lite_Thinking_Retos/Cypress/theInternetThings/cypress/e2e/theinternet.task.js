import {
    inputUsername,
    inputPassword,
    buttonLogIn
} from './theinternet.ui'

export const login = (username, password)=>{
    cy.get(inputUsername).type(username)
    cy.get(inputPassword).type(password)
    cy.get(buttonLogIn).contains('Login').click()
}