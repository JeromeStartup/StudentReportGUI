import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

class app extends Frame{
	Label lblTotal,lblAverage;
	Panel pnlMarks,pnlResult;
	Button calculate;
	String[] arrSubjects= {"Maths","Science","English","Tamil"};
	int marksPanLocRefX=50,marksPanLocRefY=50;
	int arrMarks[]=new int[arrSubjects.length];
	
	int arrID=0;
	HashMap<Integer, Integer> mapMarks=new HashMap<Integer, Integer>();
	
	private void marksPanelGenerate() {
		for(int i=0;i<arrSubjects.length;i++) {
			Label lblSubject= new Label(arrSubjects[i]);
			lblSubject.setBounds(this.marksPanLocRefX, this.marksPanLocRefY, 100, 50);
			TextField txtMarks= new TextField("");
			txtMarks.setBounds(this.marksPanLocRefX+200, marksPanLocRefY, 100, 50);
			this.pnlMarks.add(txtMarks);
			this.pnlMarks.add(lblSubject);
			this.marksPanLocRefY+=75;
			this.arrID=i;
			txtMarks.addTextListener(new TextListener() {
				
				@Override
				public void textValueChanged(TextEvent e) {
					String str=((TextField)(e.getSource())).getText();
					mapMarks.put(e.getSource().hashCode(), Integer.parseInt(str.equals("") ? "0":str));
				}
			});
			
			txtMarks.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					arrMarks[arrID]= Integer.parseInt(((TextField)(e.getSource())).getText());
//					mapMarks.put(e.getSource().hashCode(), Integer.parseInt(((TextField)(e.getSource())).getText()));
//					System.out.println(e.getSource().hashCode());
				}
			});
			
		}
	}
	
	private void calculate() {
		int totalMarks=0,average;
//		System.out.println(mapMarks);
		
		for(Integer hashcode:mapMarks.keySet()) {
			totalMarks+=mapMarks.get(hashcode);
		}
		lblTotal.setText(String.valueOf(totalMarks));
		average=totalMarks/arrSubjects.length;
		lblAverage.setText(String.valueOf(average));
		
	}
	
	
	
	private void displayResultPanel() {
		pnlResult=new Panel();
		pnlResult.setBounds(650, 0, 500, 600);
		pnlResult.setBackground(Color.white);
		pnlResult.setLayout(null);
		add(pnlResult);
		
		lblTotal=new Label("Total");
		lblTotal.setBounds(50, 50, 100, 50);
		lblTotal.setBackground(Color.yellow);
		pnlResult.add(lblTotal);
		
		lblAverage=new Label("Average");
		lblAverage.setBounds(200, 50, 100, 50);
		lblAverage.setBackground(Color.yellow);
		pnlResult.add(lblAverage);
		
		calculate=new Button("Calculate");
		calculate.setBounds(125, 150, 100, 50);
		pnlResult.add(calculate);
		calculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
				
			}
		});
		
	}
	
	private void displayMarksPanel() {
		pnlMarks=new Panel();
		pnlMarks.setBounds(0, 0, 650, 600);
		pnlMarks.setBackground(Color.gray);
		pnlMarks.setLayout(null);
		add(pnlMarks);
		
		this.marksPanelGenerate();
		
	}
	
	public app(){
		super("Student Report");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		this.displayResultPanel();
		this.displayMarksPanel();
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.exit(0);		
			}
		});
		
	}
}

public class Report {

	public static void main(String[] args) {
		app form =new app();

	}

}
