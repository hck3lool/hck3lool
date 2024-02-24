import { login } from './theinternet.task'
import  { userIsInSecureArea, userNoLogin } from './theinternet.questions';

describe('The internet authentication en la pagina The Internet', () => {

  beforeEach(()=>{
    cy.visit('https://the-internet.herokuapp.com/login')
  });

  it('Autenticacion exitosa', () => {
    login('tomsmith', 'SuperSecretPassword!')
    userIsInSecureArea()
  })

  it('Autenticacion no exitosa', () => {
    login('david', 'LiteThinking')
    userNoLogin()
  })
})