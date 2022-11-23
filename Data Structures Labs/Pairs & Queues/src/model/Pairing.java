package model;

public class Pairing<T> {
    private int pV;
    private T input;
    
    public Pairing(T pInput, int pPV){
    	pV = pPV;
      input = pInput;
    }  
    public int getPriorityValue(){
    	return pV;
    }
    
    public T getInput(){
    	return input;
    }  
    
  }