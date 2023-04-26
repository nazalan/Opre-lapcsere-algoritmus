import java.util.LinkedList;
import java.util.Queue;

public class Csere {

    public String str="";
    public int counter=0;

    public boolean bennevan=false;

    public int idx=0;
    void fun(int[] data, int db){

        //init
        LinkedList<Lap> lapok =new LinkedList<>();
        lapok.add(new Lap(0, 0, 0, 0, 0));
        lapok.add(new Lap(1, 0, 0, 0, 0));
        lapok.add(new Lap(2, 0, 0, 0, 0));

        for(int d=0; d<db; d++){
            for(int i=0; i<3; i++){
                //System.out.println("data: "+data[d] +"num: "+ lapok.get(i).id+ " mi van benne: " + lapok.get(i).mivanbenne+ " miota: "+ lapok.get(i).miota+ " hivatkozott: "+ lapok.get(i).hivtakozott+ " fagyasztott: "+lapok.get(i).fagyasztott);
            }
            //System.out.println("data: "+data[d]);

            if(!lapok.isEmpty()){
                for(int i=0; i<3; i++){//benne van
                    if(lapok.get(i).mivanbenne==data[d]){
                        str+='-';
                        bennevan=true;
                        lapok.get(i).hivtakozott=1;
                        break;
                    }
                }
            }

            if(!bennevan){
                    while(true) {
                        //nincs hely
                        if (lapok.get(0).fagyasztott ==1 && lapok.get(1).fagyasztott ==1 && lapok.get(2).fagyasztott ==1) {
                            str += '*';
                            counter++;
                            break;
                        }
                        if (lapok.get(idx).fagyasztott == 1) {
                            //lapok.add(lapok.remove(idx));
                            idx++;
                        }
                        if (lapok.get(idx).hivtakozott == 1) {
                            lapok.get(idx).hivtakozott = 0;
                            lapok.add(lapok.remove(idx));
                        }

                        if ((lapok.get(idx).mivanbenne == 0 || lapok.get(idx).fagyasztott == 0)) {//belerakás

                            if (lapok.get(idx).hivtakozott == 0) {
                                str += (char) ('A' + lapok.get(idx).id);
                                counter++;
                                lapok.get(idx).miota = 0;
                                lapok.get(idx).hivtakozott = 0;
                                lapok.get(idx).mivanbenne = data[d];
                                lapok.get(idx).fagyasztott = 1;
                                lapok.get(idx).miota = 4;
                                lapok.add(lapok.remove(idx));
                                break;
                            }
                        }
                    }
                idx=0;

            }


            for(int i=0; i<3; i++){//mióta növelése
                if(lapok.get(i).fagyasztott==1){
                    lapok.get(i).miota--;
                    if( lapok.get(i).miota==0){
                        lapok.get(i).fagyasztott=0;
                    }
                    //System.out.println("melyik: "+i + "miota: "+res[i][2]);
                }
            }

            bennevan=false;
            //System.out.println();
        }

        System.out.println(str);
        System.out.println(counter);

    }
}
