package IsBiggerSmarter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
**Solved**
http://uva.onlinejudge.org/external/101/10131.html
Question 1: Is Bigger Smarter?
*/

public class Elephant implements Comparable<Elephant>{
    
    int weight;
    int iq;
    int index;
    
    Elephant(int weight, int iq, int index){
        this.weight = weight;
        this.iq = iq;
        this.index = index;
    }
    
    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        File eFile = new File("ElephantsList.txt");
        ArrayList<Elephant> eList = new ArrayList<Elephant>();
        try{
            FileReader fr = new FileReader(eFile);
            BufferedReader br = new BufferedReader(fr);
            String temp;
            int counter = 0;
            while((temp = br.readLine()) != null){
                StringTokenizer stok = new StringTokenizer(temp);
                int weight = Integer.parseInt(stok.nextToken());
                int iq = Integer.parseInt(stok.nextToken());
                Elephant e = new Elephant(weight, iq, counter);
                eList.add(e);
                counter++;
            }
        }
        catch(IOException e){
            System.out.println("Wrong file name");
        }
        Collections.sort(eList);
        
        int[] lds = new int[eList.size()];
        int[] prev = new int[eList.size()];
        for (int i = 0; i < eList.size(); i++) {
            int maxLds = -1;
            for (int j = 0; j < i; j++) {
                if (eList.get(j).weight < eList.get(i).weight && eList.get(j).iq > eList.get(i).iq && lds[j] > maxLds){
                    lds[i] = lds[j] + 1;
                    prev[i] = j;
                }
            }
        }
        for (int i = 0; i < eList.size(); i++) {
            System.out.println(eList.get(i).weight + " " + eList.get(i).iq);
        }
        
        for (int i = 0; i < lds.length; i++) {
            System.out.print(lds[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i < lds.length; i++) {
            System.out.print(prev[i] + " ");
        }
        System.out.println();
        
        int maxLds = 0;
        int maxLdsIndex = -1;
        for (int i = 0; i < lds.length; i++) {
            if (lds[i] > maxLds){
                maxLds = lds[i];
                maxLdsIndex = i;
            }
        }
        System.out.println(maxLds + "\n");
            
        Elephant[] eSolution = new Elephant[maxLds+1];
        int i = maxLdsIndex;
        int j = maxLds;
        do {
            eSolution[j] = eList.get(i);
            i = prev[i];
            j--;
        } while (i > 0);
        
        for (int k = 0; k < eSolution.length; k++) {
            System.out.println(eSolution[k].weight + " " + eSolution[k].iq);
        }
        
        System.out.println();
        System.out.println("Final Solution:");
        System.out.println(eSolution.length);
        for (int k = 0; k < eSolution.length; k++) {
            System.out.println(eSolution[k].index + 1);// shift indexes so they start at 1
        }
        long endTime = System.nanoTime();
    }
    
    public int compareTo(Elephant o){
        if (this.weight >= o.weight )
            return 1;
        else
            return -1;
    }

}
