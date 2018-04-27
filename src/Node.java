import java.util.Random;

public class Node{
	private double val=0;
	private double[]weights=new double[0];
	private int pls=0;
	
	public Node(){}
	
	public Node(int prevNodes){
		this.weights=new double[prevNodes];
		pls=prevNodes;
		Random rand=new Random();
		
		for(int i=0;i<prevNodes;i++)weights[i]=rand.nextDouble()*(rand.nextInt(2)-0.5d)*2;
	}
	
	public Node(double[] weights){
		this.weights=weights;
		pls=weights.length;
	}
	
	public void setVal(double val){this.val=val;}
	
	public void updateVal(Node[]nodes){
		val=0;
		
		for(int i=0;i<pls;i++)val+=nodes[i].getVal()*weights[i];
		
		val=Math.tanh(val);
	}
	
	public double[]getWeights(){return weights;}
	public double getVal(){return val;}
	
	public int getCol(){return(int)((val+1)*127.5d);}
}