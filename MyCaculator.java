package MyCaculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyCaculator extends JFrame {
    private int add=1,sub=2,mul=3,div=4;
    private int op=0;
    boolean ifOp;
    private String output="0";
    private Button[] jba=new Button[]{new Button("7"),new Button("8"),
    new Button("9"),new Button("+"),
    new Button("4"),new Button("5"),
    new Button("6"),new Button("-"),
    new Button("1"),new Button("2"),
    new Button("3"),new Button("*"),
    new Button("0"),new Button("."),
    new Button("="),new Button("/")};
    private JPanel jpt=new JPanel();
    private JPanel jpb=new JPanel();
    private JTextField jtf=new JTextField("");
    private MyCaculator(){
        jpt.setLayout(new BorderLayout());
        jpt.add(jtf);
        this.add(jpt,BorderLayout.NORTH);
        jpb.setLayout(new GridLayout(4,4));
        for(int i=0;i<jba.length;i++){
            jpb.add(jba[i]);
            if(i==3||i==7||i==11||i==15||i==14)
            jba[i].addActionListener(new setOperate_Act());
        else
        jba[i].addActionListener(new setLabel_Act());
        }
        this.add(jpb,BorderLayout.CENTER);
        this.setSize(250, 200);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void operate(String x){
        double x1=Double.valueOf(x);
        double y=Double.valueOf(output);
        switch(op){
        case 0:output=x;break;
        case 1:output=String.valueOf(y+x1);break;
        case 2:output =String.valueOf(y-x1);break;
        case 3:output =String.valueOf(y*x1);break;
        case 4:
        if(x1!=0) output=String.valueOf(y/x1);
        else output="²»ÄÜÎª0";
        break;
        }

    }
    public String add(String x){
        operate(x);
        op=add;
        return output;
    }
    public String subtract(String x){
        operate(x);
        op=sub;
        return output;
    }
    public String multiply(String x){
        operate(x);
        op=mul;
        return output;
    }
    public String divide(String x){
        operate(x);
        op=div;
        return output;
    }
    public String Equals(String x){
        operate(x);
        op=0;
        return output;
    }
    public void opClean(){
        op=0;
        output ="0";
    }
    class setOperate_Act implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==jba[3]){
                jtf.setText(add(jtf.getText()));
                ifOp=true;
            }
            else if(e.getSource()==jba[7]){
                jtf.setText(subtract(jtf.getText()));
                ifOp=true;
            }
            else if(e.getSource()==jba[11]){
                jtf.setText(multiply(jtf.getText()));
                ifOp=true;
            }
            else if(e.getSource()==jba[15]){
                jtf.setText(divide(jtf.getText()));
                ifOp=true;
            }
            else if(e.getSource()==jba[14]){
                jtf.setText(Equals(jtf.getText()));
                ifOp=true;
            }
        }
    }
    class setLabel_Act implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Button tempb=(Button)e.getSource();
            if(ifOp){
                jtf.setText(tempb.getLabel());
                ifOp=false;
            }else {
                jtf.setText(jtf.getText()+tempb.getLabel());
            }
        }
    }
    public static void main(String[] args) {
        new MyCaculator();
    }
}  