
package com.mycompany.alfabetotelefono;

public class DesafioDirMOD 
{
    public static void main(String[] args) 
    {
        IEncriptador encriptador = EncriptadorFactory.obtenerEncriptador(EncriptadorFactory.TipoEncriptador.TELEFONO);
        
        String datoEncriptado = encriptador.encriptar("Desafio DIRMod");
        
        System.out.println ("El dato encriptado es: " + datoEncriptado);
        System.out.println(encriptador.desencriptar("3 3377772333444666034447776 6663"));
        
        datoEncriptado = encriptador.encriptar("Hello World");
        
        System.out.println ("El dato encriptado es: " + datoEncriptado);
        System.out.println(encriptador.desencriptar("4433555 555666096667775553"));

    }

    
}
