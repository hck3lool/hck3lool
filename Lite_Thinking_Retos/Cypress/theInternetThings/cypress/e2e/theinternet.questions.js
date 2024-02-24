import {
    toastMessage,
    labeltitle,
    buttonLogIn,
    buttonLogOut
} from './theinternet.ui'

export const userIsInSecureArea = () => {
    cy.get(toastMessage).should('contains.text', 'You logged into a secure area!')
    cy.get(labeltitle).should('contains.text', 'Secure Area')
    cy.get(buttonLogOut).should('contains.text', 'Logout')
}

export const userNoLogin = () => {
    cy.get(toastMessage).should('contains.text', 'Your username is invalid!')
    cy.get(labeltitle).should('contains.text', 'Login Page')
    cy.get(buttonLogIn).should('contains.text', 'Login')
}