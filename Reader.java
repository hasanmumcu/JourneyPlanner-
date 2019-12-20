
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class Reader {
    private final String DELIMETER = ";" ;
    
    
    
    public Reader(){
  
    }
    
    public <S> S readFile(String fileName, String className) {
        
        S list = (S) new ArrayList<>();
        File file = new File(fileName);
        
        try{
            Class<?> cls = Class.forName(className);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            br.readLine();
            while((line = br.readLine()) != null ){
                String[] columns = line.split(this.DELIMETER);
                if(columns.length == 3){
                    Constructor<?> ctor = cls.getConstructor(String.class, String.class, String.class);
                    Object object = ctor.newInstance(new Object[] { columns[0], columns[1], columns[2]});
                    ((ArrayList)list).add(object);
                }
                else if(columns.length == 4){
                    Constructor<?> ctor = cls.getConstructor(String.class, String.class, String.class, String.class);
                    Object object = ctor.newInstance(new Object[] { columns[0], columns[1], columns[2], columns[3]});
                    ((ArrayList)list).add(object);
                }
                else if(columns.length == 5){
                    Constructor<?> ctor = cls.getConstructor(String.class, String.class, String.class, String.class, String.class);
                    Object object = ctor.newInstance(new Object[] { columns[0], columns[1], columns[2], columns[3], columns[4]});
                    ((ArrayList)list).add(object);
                }
                else if(columns.length == 6){
                    Constructor<?> ctor = cls.getConstructor(String.class, String.class, String.class, String.class, String.class, String.class);
                    Object object = ctor.newInstance(new Object[] {  columns[0], columns[1], columns[2], columns[3], columns[4], columns[5] });
                    ((ArrayList)list).add(object);
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(InstantiationException ex){
            System.out.println(ex.getMessage());
        }
        catch(NoSuchMethodException ex){
            System.out.println(ex.getMessage());
        }
        catch(IllegalAccessException ex){
            System.out.println(ex.getMessage());
        }
        catch(InvocationTargetException ex){
            System.out.println(ex.getMessage());
        }
        return list;
    } 
   
    
    
    
}
