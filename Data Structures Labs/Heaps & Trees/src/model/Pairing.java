package model;

public class Pairing<T> implements Comparable<Pairing<T>> {
	private int pV;
    private T contents;
    
    public Pairing(T pInput,int pPriorityValue){
    	pV = pPriorityValue;
    	contents = pInput;
    }  
    public void setPriorityValue(int pPriorityValue){
    	pV = pPriorityValue;
    }
    public int getPriorityValue(){
    	return pV;
    }
    
    public T getContents(){
    	return contents;
    }
    
	@Override
	public int compareTo(Pairing o) {
		if (pV < o.getPriorityValue()){
			return -1;
		} else if (pV > o.getPriorityValue()) {
			return 1;
		} else {
			return 0;
		}
	}  
    
	public String toString() {
		return "("+ contents.toString()+ ", " + pV + ")";
	}
  }