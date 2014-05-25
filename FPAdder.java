import java.text.DecimalFormat;
public class FPAdder
{
    public static void main(String args[])
    {
        int numArgs = args.length;
        if(numArgs < 2){
            System.out.println("Please enter at least two arguments");
        }
        else{
            double sum = 0.0;
            for(int i=0;i<numArgs;i++){
                sum += Double.valueOf(args[i]);
            }
            DecimalFormat myformat = new DecimalFormat("###,###.##");
            String output =   myformat.format(sum);
            System.out.println("Sum is :" + output);
        }
    }
}
