describe('Plataforma educativa de LT', ()=>{
  context('Casos de prueba para estudiantes de Litethinking', ()=>{
    before(()=>{
      cy.log('*******************************')
      cy.log('Establecer conexcion con una base de datos')
    })

    beforeEach(()=>{
      cy.log('----------------------------------------')
      cy.log('Abrir plataforma de LT')
    })

    it('Ver video de sesion de Curso', ()=>{
      cy.log('Reproducir video en plataforma')
    });

    it('Realizar comentario en el foro del Curso', ()=>{
      cy.log('Realizar comentario en plataforma')
    });

    it.only('Realizar entrega de Reto Teorico del Curso', ()=>{
      cy.log('Entrega de RETO Teorico')
    })

    afterEach(()=>{
      cy.log('cerrar sesion')
      cy.log('cerrar navegador')
      cy.log('----------------------------------------')
    })

    after(()=>{
      cy.log('Cerrar conexion con la base de datos')
      cy.log('*******************************')
    })
  });
});