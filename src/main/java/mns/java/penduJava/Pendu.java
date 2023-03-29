package mns.java.penduJava;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import java.lang.Math;
import javafx.scene.text.Font;
//import javafx.scene.shape.Circle;
 
public class Pendu extends Application{
    String[] mots = {"MAIN" , "PAPIER", "NOM", "METEORE", "TROU" , "CISEAUX", "PIERRE", "MOUSTACHE"}; 
    String bouchetrou = "                                                       ";
    char[] solution,lemot;
    Button A,B,C,D,E,F,G,H,I,J,K,L,M,O,P,Q,R,S,T,U,V,W,X,Y,Z;
    int essais = 6; 
    int fin;
        
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception{
        solution= mots[(int)(Math.random() * mots.length)].toCharArray(); //choisir un mot au hasard dans la liste
        lemot = bouchetrou.toCharArray();
        fin = solution.length;
        int i;
        for(i =0; i < fin; i++)
            lemot[i] = '_';
             
        System.out.println(solution);
         
        stage.setWidth(800);            //la fenêtre
        stage.setHeight(800);
        stage.setTitle("Le pendu");
         
        Group layout = new Group();
        Scene scene = new Scene(layout);
         
        Text titre = new Text(30,120,"Le pendu");  // un titre
        titre.setFont(new Font(70));
        titre.setFill(Color.BLACK);
        layout.getChildren().add(titre);
         
   
         
        String trans = new String(lemot);   // le mot à deviner
        Text adev = new Text(90,420,trans);
        adev.setFont(new Font(70));
        adev.setFill(Color.BLACK);
         
        trans = Integer.toString(essais);   // les essais restants
        Text vie = new Text(60,300,"Essai(s) restant(s): "+trans);
        vie.setFont(new Font(40));
        vie.setFill(Color.BLACK);
         
        trans = Integer.toString(fin);   // combien il reste de lettre à deviner
        Text n = new Text(60,550,"Nombre de lettre(s) restante(s): "+trans);
        n.setFont(new Font(40));
        n.setFill(Color.BLACK);
 
           
                 
        A = new Button("A");
        A.setLayoutX(70);
        A.setLayoutY(650);
        layout.getChildren().add(A);
        A.setOnAction( (actionEvent)-> {
                int d = 0;
                for(int j =0; j< solution.length; j++)
                    if(solution[j] == 'A'){
                        fin--;
                        d++;
                        lemot[j] = 'A';
                    }
                if(d <= 0)
                    essais--;
                 
                if(essais <= 0){
                    Text over = new Text(45,400,"DOMMAGE . . .");
                    over.setFont(new Font(100));
                    over.setFill(Color.RED);
                    layout.getChildren().add(over);
                    return;
                }
                 
/*                String transi = new String(lemot);   // le mot à deviner
                Text adev = new Text(60,420,transi);
                adev.setFont(new Font(70));
                adev.setFill(Color.BLACK);
                 
                transi = Integer.toString(essais);   // les essais restants
                Text vie = new Text(60,300,"Essai(s) restant(s): "+transi);
                vie.setFont(new Font(40));
                vie.setFill(Color.BLACK);
                 
                transi = Integer.toString(fin);   // combien il reste de lettre à deviner
                Text n = new Text(60,550,"Nombre de lettre(s) restante(s): "+transi);
                n.setFont(new Font(40));
                n.setFill(Color.BLACK);
                 
                
                 
                vie.setText(" ");
                n.setText(" ");
 */                
                System.out.println(lemot);
                System.out.println(essais);
                 
                layout.getChildren().add(adev);
                layout.getChildren().add(n);
                layout.getChildren().add(vie);
 
                });
                 
         
        stage.setScene(scene);
        stage.show();
    }  
}