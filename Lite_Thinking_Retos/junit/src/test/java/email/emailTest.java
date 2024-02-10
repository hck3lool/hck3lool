package email;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
    Ingresar a una plataforma de correo electronico
        1. Enviar un correo electronico
        2. Eliminar un correo
        3. Abrir un correo electronico
    Cerrar la sesion del correo electronico
    */

public class emailTest {
    @BeforeEach
    public void AbrirGmail() {
        System.out.println("******************************************************");
        System.out.println("El usuario coloca sus credenciales y accede a Gmail");
    }

    @Test
    public void enviarCorreoElectronico() {
        System.out.println("El usuario envia un correo electronico");
    }

    @Test
    public void eliminarCorreoElectronico() {
        System.out.println("El usuario elimina un correo electronico");
    }

    @Test
    public void abrirCorreoElectronico() {
        System.out.println("El usuario abre un correo electronico");
    }

    @AfterEach
    public void CerrarGmail() {
        System.out.println("El usuario cierra sesion en Gmail");
        System.out.println("******************************************************");
    }
}
