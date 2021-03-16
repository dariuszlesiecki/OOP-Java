import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Lab12 {
    public static void main(String[] args){
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String file,file1,file2;
        try {
            System.out.println("Podaj nazwe pliku");
            file1 = inp.readLine();
            System.out.println("Podaj nazwe pliku");
            file2 = inp.readLine();

            BufferedReader reader1;
            BufferedReader reader2;

            reader1= Files.newBufferedReader(Paths.get(file1).toAbsolutePath(), StandardCharsets.UTF_8);
            reader2= Files.newBufferedReader(Paths.get(file2).toAbsolutePath(), StandardCharsets.UTF_8);
            String line1;
            String line2;
            double x1=0;double y1=0; double x2=0; double y2=0; double y3=0;

            File tmp;
            while(true) {
                System.out.println("Podaj nazwe do ktorego zapiszemy");
                file = inp.readLine();
                tmp = new File(file);
                if (tmp.exists()) {
                    System.out.println("Czy chcesz nadpisac plik? (tak/nie)");
                    //file = inp.readLine();
                    if (inp.readLine().equals("tak")) {
                        break;
                    }
                }
                else{
                    break;
                }
            }
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(tmp.getAbsolutePath()),StandardCharsets.UTF_8, StandardOpenOption.CREATE);

            while(true){
                if((line1 = reader1.readLine()) != null){
                    x1=Double.parseDouble(line1.split(" ")[0]);
                    y1=Double.parseDouble(line1.split(" ")[1]);
                }
                else{

                    break;
                }
                if((line2 = reader2.readLine()) != null){
                    x2=Double.parseDouble(line2.split(" ")[0]);
                    y2=Double.parseDouble(line2.split(" ")[1]);
                }
                else{

                    break;
                }
                if(x1==x2){
                    y3=y1+y2;
                    writer.write(Double.toString(x1)+" "+Double.toString(y3)+"\n");
                }
            }
        }
        catch (NoSuchFileException e){
            System.out.println("Otwarcie pliku nie powiodło się");
        }
        catch (Exception e){
            System.out.println("error");
        }

    }
}
