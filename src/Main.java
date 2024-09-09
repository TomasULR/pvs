import fileworks.DataImport;

public class Main {
    public static void main(String[] args) {
        DataImport de = new DataImport("inputs.txt");
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
                    System.out.println(A+B);
                }break;
                case "S":{
                    System.out.println(A-B);
                }break;
                case "M":{
                    System.out.println(A*B);
                }break;
                case "D":{
                    System.out.println(A/B);
                }break;
            }

        }
        de.finishImport();
    }
}