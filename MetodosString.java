/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodosstring;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class MetodosString {
    static Scanner entrada=new Scanner(System.in);
    static int largopalabra,vocales,consonantes;
    static String auxstring,palabra,invertido;
    static boolean existechar, existesubstring;
    static char caracter;
    static char arregloporcaracter[];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean conf=true;
        while(conf!=false)
        {
            menu();
            
            conf=repetir();
        }
        
        
    }
    
    
    public static void menu()
    {
        String aux;
         palabra=leerString("texto para analizar");
         largopalabra=largocadena(palabra);
         vocales=contarVocales(palabra);
         invertido=invertirString(palabra);
         aux=leerString("caracter para buscar, de haber mas de 1 como respuesta, se considerará solo el primero.");
         caracter=aux.charAt(0);
         existechar=existeChar(palabra,caracter);
         auxstring=leerString("frase para buscar dentro del texto.");
         existesubstring=existesubString(palabra,aux);
         arregloporcaracter=crearArrayChar(palabra);
           imprimirResultados(palabra);
        
       
    }
    
    public static String leerString(String dato)
    {
        String texto;
        System.out.println("Ingrese su "+ dato);
        texto=entrada.nextLine();
        return texto;
    }
    public static int largocadena(String str)
    {
        
        int largo=str.length(); 
       
        return largo;
    }
    public static int contarVocales(String str)
    {
        int nro=0;
        for (int i = 0; i < str.length(); i++) 
        {
            if(str.charAt(i)==('a')||str.charAt(i)==('e')||str.charAt(i)==('i')||str.charAt(i)==('o')||str.charAt(i)==('u'))
            {
                nro=nro+1;
            }
            
        }
        
        
        return nro;
    }
    public static String invertirString(String str)
    { 
        /*
        Cortar letra por letra empezando desde el final (el for empieza en el tope y se mantiene hasta llegar a 0   
        */
        String rts="";
        for (int i = str.length()-1; i >= 0; i--) 
        {
            rts=rts+str.charAt(i);
            
            
        }
        
    
        
        return rts;
    }
    public static boolean existeChar(String str,char ch)
    {
        for (int i = 0; i < str.length(); i++) 
        {
            if(str.charAt(i)==ch)
            {
                return true;
            }
            else
            {
                
            }
            
        }
        return false;
        
        
        
    }
   public static boolean existesubString(String str, String substr)
   {
       int contador=0;
       if (substr.length()>str.length())
               {
                   return false;
               }
       for (int i = 0; i < str.length(); i++) 
       {
           if (str.charAt(i)==substr.charAt(0))
           {
               for (int j = 0; j < substr.length(); j++) 
               {
                   if (str.charAt(i+j)==substr.charAt(j))
                           {
                               contador=contador+1;
                           }
                   
               }
               if (contador==substr.length())
               {
                   return true;
               }
               else
               {
                   contador=0;
                   
               }
           }
           
       }
       
      return false;
   }
   public static char[] crearArrayChar(String str)
   {
       char matrizaux[]=new char[str.length()];
       for (int i = 0; i < str.length(); i++) 
       {
           matrizaux[i]=str.charAt(i);
           
       }
       
       
       return matrizaux;
   }
   public static void imprimirResultados(String str)
   {
       System.out.println("el texto ingresado fue: "+palabra);
       System.out.println("El largo del texto es "+largopalabra);
       System.out.println("La cantidad de vocales en el texto es de "+vocales+" vocales.");
       System.out.println("El texto invertido: "+invertido);
       System.out.println("Buscando el caracter "+caracter+" la respuesta es "+existechar);
       System.out.println("Buscando la frase"+auxstring+" la respuesta es "+existesubstring);
       for (int i = 0; i < palabra.length(); i++) 
       {
           System.out.println(arregloporcaracter[i]);           
       }
   }
   public static boolean repetir()
   { 
       String auxiliar="asdf";
       do 
       {
           System.out.println("Si desea ingresar otro texto, escriba si, de no ser así, escriba no.");
           auxiliar=entrada.next();
           if (!auxiliar.equals("si")&&!auxiliar.equals("no"))
           {
               System.out.println("Intente nuevamente, respuesta no valida.");
           }
           
       }
       while (!auxiliar.equals("si")&&!auxiliar.equals("no"));
       if (auxiliar.equals("si"))
       {
           return true;
       }
       else
       {
           return false;
       }
       
       
   }
}
