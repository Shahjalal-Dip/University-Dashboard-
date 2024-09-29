package repositories;
import java.lang.*;
import java.io.*;
public class FileIO {
    public void createFile(String file){
        try{
            File f = new File(file);
            if(f.createNewFile()){
                System.out.println("Successfully created");
            }else{
                System.out.println("Failed Creation");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String[] readFile(String file){
        String []data = new String[100];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String saveLine = "";
            int i=0;
            while((saveLine = br.readLine()) != null) {
               data[i]=saveLine;
               i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
     return data;
    }

    public void writeFile(String file,String data[]){
        try{
            FileWriter fw = new FileWriter(file);
            for(int i=0;i<data.length;i++)
            {
                if(data[i]!=null)
                {
                    fw.write(data[i]);
                }
            }
                fw.flush();
                fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
