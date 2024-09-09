import fileworks.DataExport;
import fileworks.DataImport;

public class Main {
    public static void main(String[] args) {
        DataImport de = new DataImport("inputs.txt");
        DataExport da = new DataExport("result.txt");
        String line;
        String[] params;
        int A;
        int B;
        while (de.hasNext()){
            line = de.readLine();
            System.out.println(line);
            params = line.split(",");
            //8,5,A
            A = Integer.parseInt(params[0]);
            B = Integer.parseInt(params[1]);
            switch (params[2]){
                case "A":{
                    da.writeLine(String.valueOf(A+B));
                }break;
                case "S":{
                    da.writeLine(String.valueOf(A-B));
                }break;
                case "M":{
                    da.writeLine(String.valueOf(A*B));
                }break;
                case "D":{
                    da.writeLine(String.valueOf(A/B));
                }break;
            }

        }
        de.finishImport();
        da.finishExport();

    }
}