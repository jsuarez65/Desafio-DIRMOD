
package com.mycompany.alfabetotelefono;


public class EncriptadorFactory 
{
    public enum TipoEncriptador {TELEFONO};
    
    public static IEncriptador obtenerEncriptador (TipoEncriptador encriptador)
    {
        switch (encriptador)
        {
            case TELEFONO:
                return new EncriptadorTelefonoImpl();
        }   
        
        
        return null;
        
    }

}
