package aqui;

import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dan
 */
public class Baloto
{
     Gana Ganadores[];
     String BalotoId;
     int[] NumerosGanadores;

    public Baloto(Gana[] Ganadores, String BalotoId, int[] NumerosGanadores) {
        this.Ganadores = Ganadores;
        this.BalotoId = BalotoId;
        this.NumerosGanadores = NumerosGanadores;
    }
    

    public static class Gana
    {
            public double SorteoId;
            public double[]  Numeros;
        
    }

    
}
/*
{
  "Baloto":
        {
            "BalotoId":5,
            "NumerosGanadores":[2,45,34,23,7,5,13],
            "Ganadores":[
                            {
                               "SorteoId":23,
                            "Numeros":[2,45,13]

                            },
                            {
                              "SorteoId": 24,
                              "Numeros": [ 34,23,5]
                            }
                        ]

        }
}

*/