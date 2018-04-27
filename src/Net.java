public class Net{
	public Node[][]net=new Node[5][];
	
	public Net(){
		net[0]=new Node[226];
		for(int i=0;i<226;i++)net[0][i]=new Node();
		net[0][225].setVal(1);
		
		net[1]=new Node[50];
		for(int i=0;i<50;i++)net[1][i]=new Node(225);
		
		net[2]=new Node[50];
		for(int i=0;i<50;i++)net[2][i]=new Node(50);
		
		net[3]=new Node[50];
		for(int i=0;i<50;i++)net[3][i]=new Node(50);
		
		net[4]=new Node[3];
		for(int i=0;i<3;i++)net[4][i]=new Node(50);
	}
}