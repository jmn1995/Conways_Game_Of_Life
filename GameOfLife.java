
package gameoflife;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class GameOfLife extends JFrame {
 int x,y;
 int[][] A = new int[130][130];
 int[][] XV = new int[130][130];
 int[][] YV = new int[130][130];
    public GameOfLife(){
     setTitle("Conway's Game of Life");
     setSize(1000,1000);
     setVisible(true);
     setResizable(false);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     x=30;
     y=30;
    }
    public void paint(Graphics g){
     //int px=0,py=0;
     setBackground(Color.black);
     g.setColor(Color.white);
     g.drawString("Conway's Game of life",750,120);
     g.setColor(Color.white);
     
     for(int i=0;i<130;i++){ 
      x=30;
      for(int j=0;j<130;j++){
       run();
          
       g.drawRect(x, y, 5, 5);
       A[i][j]=0;
       XV[i][j]=x;
       YV[i][j]=y;
          if((x^y)%7==0){
           //outstanding performance in 1,3,5,7
           g.fillRect(x, y, 5, 5);
           A[i][j] = 1;
           XV[i][j]=x;
           YV[i][j]=y;
          }
          
          x+=5;
      }
      y+=5;
     }
     
     //g.clearRect(px, py, 15, 15);
     //g.setColor(Color.black);
     //g.drawRect(px, py, 15, 15);
     run();
     run();
     run();
     int lifeCell;
     int T=0;
     while(T<20){
      for(int i=0;i<130;i++){
          run();
          run();
          for(int j=0;j<130;j++){
           lifeCell=0;
           int life = A[i][j];
           if(j-1>=0){
            if(A[i][j-1]==1) lifeCell++; 
           }
           if(j+1<130){
            if(A[i][j+1]==1) lifeCell++;
           }
           if(i-1>=0){
            if(A[i-1][j]==1) lifeCell++;
           }
           if(i+1<130){
            if(A[i+1][j]==1) lifeCell++;
           }
           if(lifeCell==3){
            if(life==0) {
             g.setColor(Color.black);
             g.fillRect(XV[i][j],YV[i][j],5,5);
             A[i][j]=1;
            }
           }
           if(lifeCell==0||lifeCell==1){
            if(life==1) {
             g.clearRect(XV[i][j],YV[i][j],5,5);
             g.setColor(Color.blue);
             g.drawRect(XV[i][j],YV[i][j],5,5);
             A[i][j]=0;
            }
           }
           if(lifeCell==4){
            if(life==1) {
             g.clearRect(XV[i][j],YV[i][j],5,5);
             g.setColor(Color.blue);
             g.drawRect(XV[i][j],YV[i][j],5,5);
             A[i][j]=0;
            }
           }
          }
         }
      
      T++;
     }
     int servivor=0;
     for(int i=0;i<130;i++){
      for(int j=0;j<130;j++){
       if(A[i][j]==1) servivor++;
      }
     }
     g.drawString("Living Cells = "+servivor,750,100);
    }
    
    public void run(){
  try{
   
   Thread.sleep(5);
  }catch(Exception e){
   System.out.println("ERROR!!");
  }
 }
 
    public void lifeGame(Graphics g){
     
    }
      
     
     
     
     
     
    
 public static void main(String[] args) {
  GameOfLife pg = new GameOfLife();
  Thread t1 = new Thread();
  t1.start();
        
 }

}
