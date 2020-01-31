package aqui;


import aqui.Baloto.Gana;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dan
 */
public class Conversion 
{
    public static void main(String args[])
    {
        String s="{\"Baloto\":{\"BalotoId\":5,\"NumerosGanadores\":[2,45,34,23,7,5,13],\"Ganadores\":[{\"SorteoId\":23,\"Numeros\":[2,45,13]},{\"SorteoId\": 24,\"Numeros\": [ 34,23,5]}]}}";
        Baloto bal=jsonToClass(s);
        System.out.println(bal.BalotoId);
        for (int i=0;i<bal.NumerosGanadores.length;i++)
        {
            System.out.print(bal.NumerosGanadores[i]+"--");
        }
        System.out.println();
        for (int i=0;i<bal.Ganadores.length;i++)
        {
            System.out.println("SORTEO:"+bal.Ganadores[i].SorteoId);
            System.out.println("Numeros : ");
            for (int j = 0; j <bal.Ganadores[i].Numeros.length; j++) 
            {
                System.out.print(bal.Ganadores[i].Numeros[j]+" ");
            }
            System.out.println();
        }
        
        String js=objectToJson(bal);
        System.out.println(js);
 
    }
    
    public static Baloto jsonToClass(String js)//WHEN NO OBJECT IS DEFINED
    {
        
        Gson g=new Gson();
        Map<String,Object> a=(Map<String,Object>) g.fromJson(js,Map.class).get("Baloto");
        String b=a.get("BalotoId").toString();
        //System.out.println(b);
        String c=a.get("NumerosGanadores").toString();
        int len=c.length();
        String[] newc=c.substring(1,len-1).split(",");
        int[] newcc=new int[newc.length];
        for (int i=0;i<newc.length; i++) 
        {
            newcc[i]=(int)Double.parseDouble(newc[i]);
            //System.out.print(newcc[i]+"  ");
        }
        ArrayList d =(ArrayList)a.get("Ganadores");  
        Gana[] ganadores=new Gana[d.size()];
        for (int i = 0; i < d.size(); i++)
        {
            String ganador=d.get(i).toString();
            Gana gan=g.fromJson(ganador,Gana.class);
            ganadores[i]=gan;
            
        }
       
        return new Baloto(ganadores,b, newcc);
    }
    public static String objectToJson(Baloto o)
    {
        Gson g=new Gson();
        return g.toJson(o);
    }
    
}



