/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiffragedecesar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ChiffragedeCesar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        
    int choix;  
    Scanner sc;
    sc=new Scanner(System.in);
    
    System.out.println("Saisir 1 pour crypter le fichier, 2 pour le décrypter et 0 pour quitter.");
    choix=sc.nextInt();
    
    switch(choix){
        case 1:
            Cryptage();
        case 2:
            Decryptage();
        case 0:
            break;
    }
    }
    
     static void Cryptage() throws Exception{
        String key,fichier1, fichier2, ligne;
        List<String> Lignes;
        Lignes = new ArrayList<String>();
        
        key=Saisie("Saisir la clé de cryptage :");
        fichier1=Saisie("Saisir le chemin du fichier à crypter :");
        fichier2=Saisie("Saisir le chemin du fichier crypté :");
        Collecter(Lignes, fichier1);
        
        //Cryptage ligne par ligne
        for(int i=0; i<Lignes.size(); i++){
            ligne=Lignes.get(i);
            Crypter(ligne, key, fichier2, Lignes,i);
        }
        Ecrire(fichier2, Lignes);
        System.out.println("Voici le fichier crypté :");
        System.out.println(Lignes);
    }
    
    static void Decryptage()throws Exception{
        String key,fichier1, fichier2, ligne;
        List<String> Lignes;
        Lignes = new ArrayList<String>();
        
        key=Saisie("Saisir la clé de décryptage :");
        fichier1=Saisie("Saisir le chemin du fichier à décrypter :");
        fichier2=Saisie("Saisir le chemin du fichier décrypté :");
        Collecter(Lignes, fichier1);
        
         //Cryptage ligne par ligne
        for(int i=0; i<Lignes.size(); i++){
            ligne=Lignes.get(i);
            Decrypter(ligne, key, fichier2, Lignes,i);
        }
        
        Ecrire(fichier2, Lignes);
        System.out.println("Voici le fichier décrypté :");
        
        for(int i=0; i<Lignes.size();i++){
        ligne=Lignes.get(i);
        System.out.println(ligne);
        }
        
    }
    
    static String Saisie(String message){
        Scanner sc;
        String valeur;
        sc=new Scanner(System.in);
        
        System.out.println(message);
        valeur=sc.nextLine();
        return valeur;
    }  
    static void Collecter(List<String>Collection,String fichier)throws Exception{
        BufferedReader source;
        String ligne;
        source=new BufferedReader(new FileReader(fichier));
        ligne=source.readLine();
        while(ligne!=null){
            Collection.add(ligne);
            ligne=source.readLine();
        }
        source.close();
    }    
    
    static void Crypter(String ligne, String key, String fichier2, List<String>Lignes, Integer i)throws Exception{
        int caract2, h=0;
        char caract3;
        String LiCrypte="";// Licrypte : Contient ligne cryptée
        
        
        //Cryptage caractère par caractère d'une ligne
         for(int j=0; j<ligne.length(); j++){
            char caract=ligne.charAt(j);
            int codeASCii=caract;
            
                if (h<key.length()){
                    char caract1=key.charAt(h);
                    int codeASCII=caract1;
                    caract2=caract+caract1;
                    caract3=(char)caract2;
                    LiCrypte+=caract3;
                    
                    
                }else{
                    
                    h=0;
                }
                }
                
             
        Lignes.set(i,LiCrypte);
        
    }
         
    static void Ecrire(String fichier2, List<String>Lignes)throws Exception{
        
        BufferedWriter cible;
        cible=new BufferedWriter(new FileWriter(fichier2));
        for(int i=0; i<Lignes.size(); i++){
            cible.write(Lignes.get(i)+"\n");
        }
        cible.close();
        }
    static void Decrypter(String ligne, String key, String fichier2, List<String>Lignes, Integer i)throws Exception{
         int caract2, h=0;
        char caract3;
        String LiCrypte="";// Licrypte : Contient ligne cryptée
        
        
        //Cryptage caractère par caractère d'une ligne
         for(int j=0; j<ligne.length(); j++){
            char caract=ligne.charAt(j);
            int codeASCii=caract;
            
                if (h<key.length()){
                    char caract1=key.charAt(h);
                    int codeASCII=caract1;
                    caract2=caract-caract1;
                    caract3=(char)caract2;
                    LiCrypte+=caract3;
                    
                    
                }else{
                    
                    h=0;
                }
                }
                
             
        Lignes.set(i,LiCrypte);
    }
}
            
           
            
            
            
        
    
    
                
        
    
       
            
        
    
    
    


                
                
                
                    
         

        
    


