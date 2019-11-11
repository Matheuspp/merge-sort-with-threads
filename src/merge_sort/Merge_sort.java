/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge_sort;
import java.util.*;

/**
 *
 * @author Matheus VR
 */
public class Merge_sort {
 
	
	static  int  vetor[]={100,20,15,30,5,75,40,10,25,111,1,43,89,0,2,3,21,53,46,101,112,134,156};

 
	public static void main(String args[])
	{
		long startTime = System.currentTimeMillis();
		System.out.println("=================ANTES==================");
		printVetor(vetor,0,vetor.length-1);
		System.out.println("========================================");
                mergeSort(0,vetor.length-1);
		System.out.println("=================DEPOIS=================");
 
		
		
		printVetor(vetor,0,vetor.length-1);
                System.out.println("========================================");
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("tempo de execução: " + (float)elapsedTime/1000 + " secondos");
 
	}
        
        public static void printVetor(int arr[],int start,int end)
	{
		for (int i = start; i <=end; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
 
 
	private static void merge(int start, int mid, int end) {
		
		int[] tempArray=new int[vetor.length];
		int tempArrayIndex=start;
 
		//printArray(vetor,start,end);
 
		int startIndex=start;
		int midIndex=mid+1;
 
		// Interando sob listas pequenas
		while(startIndex<=mid && midIndex<=end)
		{
			if(vetor[startIndex]< vetor[midIndex])
			{
				tempArray[tempArrayIndex++]=vetor[startIndex++];
			}
			else
			{
				tempArray[tempArrayIndex++]=vetor[midIndex++];
			}
		}
 
		// Copy remaining elements
		while(startIndex<=mid)
		{
			tempArray[tempArrayIndex++]=vetor[startIndex++];
		}
		while(midIndex<=end)
		{
			tempArray[tempArrayIndex++]=vetor[midIndex++];
		}
 
		// Copy tempArray to actual array after sorting 
		for (int i = start; i <=end; i++) {
			vetor[i]=tempArray[i];
		}
 
	
		
	}
        
        
        // Recursão :)
	public static void mergeSort(int start,int end)
	{
		int mid=(start+end)/2;
		if(start<end)
		{
                    
                    Thread p_metade = new Thread(){
                        public void run(){
                            // metade esquerda
			    mergeSort(start,mid);
                        }
                    };
                    
                    Thread s_metade = new Thread(){
                        public void run(){
                            // metade direita
                            mergeSort(mid+1,end);
                        }
                    };
                    
                    p_metade.start();
                    s_metade.start();
			
                    try {
                        p_metade.join();
                        s_metade.join(); 
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
			
			
			// direita e esquerda
                    merge(start,mid,end);
		}
 
	}
 
}