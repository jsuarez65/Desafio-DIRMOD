
package com.mycompany.alfabetotelefono;

import java.util.Arrays;
import java.util.List;

public class EncriptadorTelefonoImpl implements IEncriptador
{
    private final List<String> alfabeto = Arrays.asList (" ", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ");
    
    
    @Override
    public String encriptar(String dato) 
    {
        int idx1stPos, idx2ndPos;
        String[] datoXCaracter, letrasXNro;
        
        String datoEncriptado = "";
        
        if (dato.toUpperCase().chars().filter(c -> (c < 'A' || c > 'Z') && c != ' ').count() == 0)
        {
            datoXCaracter = dato.split("");

            for (String letraBuscada : datoXCaracter)
            {   
                idx1stPos = 0;

                while (alfabeto.get(idx1stPos).contains(letraBuscada.toUpperCase()) != true)
                    idx1stPos++;

                idx2ndPos = 1;
                letrasXNro = alfabeto.get(idx1stPos).split("");

                for (String letra : letrasXNro)
                {
                    if (!letra.equals(letraBuscada.toUpperCase()))
                        idx2ndPos++;
                    else
                        break;
                }
                
                if (datoEncriptado.length() > 0)
                    datoEncriptado += (Character.toString(datoEncriptado.charAt(datoEncriptado.length()-1)).equals(Integer.toString(idx1stPos)) 
                            ? " " : "") + Integer.toString(idx1stPos).repeat(idx2ndPos);
                else
                    datoEncriptado = Integer.toString(idx1stPos).repeat(idx2ndPos);
            }
        }
        
        return datoEncriptado;
    }


    @Override
    public String desencriptar(String datoEncriptado) 
    {
        String dato = "";
        int ubicacionNro = 0;

        String[] datoEncriptadoXCarac = datoEncriptado.split("");
        
        String nroBuscadoAnt = datoEncriptadoXCarac[0];
        
        for (String nroBuscado : datoEncriptadoXCarac)
        {          
            if (nroBuscado.equals(nroBuscadoAnt))
                ubicacionNro++;
            else
            {           
                dato += alfabeto.get(Integer.parseInt(nroBuscadoAnt)).split("")[ubicacionNro-1];
                if (!nroBuscado.equals(" "))
                {
                    nroBuscadoAnt = nroBuscado;
                    ubicacionNro = 1;
                }
                else
                    ubicacionNro = 0;
                
            }
        }

        dato += alfabeto.get(Integer.parseInt(nroBuscadoAnt)).split("")[ubicacionNro-1];
        
        return dato;
    }
}

    

