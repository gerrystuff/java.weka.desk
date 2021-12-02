import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Generador {

    FileWriter arfFile ;
    BufferedWriter writer;
    ArrayList<DataModel> datas;

    Generador(String fileName){
        init(fileName);

    }

    void init(String fileName){
        try {
            arfFile = new FileWriter("C:\\Users\\lgapa\\Desktop\\" + fileName,false);
            writer = new BufferedWriter(arfFile);


            String header = "@relation covid.symbolic\n";
            writer.write(header);
            writer.write("\n");

            String attributes = "" +
                    "@attribute temporada {invierno, verano}\n" +
                    "@attribute temperatura {hot, mild, cool}\n" +
                    "@attribute oxigenacion {low, normal}\n" +
                    "@attribute dificultad_respirar {true, false}\n" +
                    "@attribute contagiado {yes, no}\n";

            writer.write(attributes);
            writer.write("\n");

            writer.write("@data\n");


        datas = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            datas.add(new DataModel());

            DataModel temp = datas.get(i);
            int randomCase = getRandomOpt(1,2);
            generateData(randomCase,temp);

        }

            Set<DataModel> set = new HashSet<>(datas);
        datas.clear();
        datas.addAll(set);

            for (int i = 0; i < datas.size() ; i++) {
                DataModel temp = datas.get(i);
                writer.write(
                        temp.getTemporada() + "," +
                            temp.getTemperatura() + "," +
                            temp.getOxigenacion() + "," +
                            temp.isDificultad_respirar() + "," +
                            temp.isContagiado() + "\n"
            );
            }



            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    void generateData(int randomNum, DataModel data){

            switch (randomNum){
                case 1:{
                    data.setTemporada("invierno");
                    generateData(getRandomOpt(3,5),data);
                    break;
                }

                case 2:{
                    data.setTemporada("verano");
                    generateData(getRandomOpt(3,5),data);
                    break;

                }

                case 3:{
                    data.setTemperatura("hot");
                    generateData(getRandomOpt(6,7),data);
                    break;

                }
                case 4:{
                    data.setTemperatura("mild");
                    generateData(getRandomOpt(6,7),data);
                    break;

                }

                case 5:{
                    data.setTemperatura("cool");
                    generateData(getRandomOpt(6,7),data);
                    break;

                }

                case 6:{
                    data.setOxigenacion("low");
                    generateData(getRandomOpt(8,9),data);
                    break;

                }

                case 7:{
                    data.setOxigenacion("normal");
                    generateData(getRandomOpt(8,9),data);
                    break;

                }

                case 8:{
                    data.setDificultad_respirar(true);
                    generateData(getRandomOpt(10,11),data);
                    break;

                }

                case 9:{
                    data.setDificultad_respirar(false);
                    generateData(getRandomOpt(10,11),data);
                    break;

                }

                case 10:{
                    data.setContagiado(true);
                    break;

                }

                case 11:{
                    data.setContagiado(false);
                    break;

                }
            }

    }

    int getRandomOpt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}


