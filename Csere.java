public class Csere {

    public String str="";
    public int counter=0;

    public boolean bennevan=false;

    public int idx=0;
    void fun(int[] data, int db){
        //init
        int[][] res=new int[3][4];
        for(int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                res[i][j]=0;
            }
        }

        for(int d=0; d<db; d++){
            for(int i=0; i<3; i++){
                //System.out.println("data: "+data[d] +"num: "+ i+ " mi van benne: " + res[i][1]+ " miota: "+ res[i][2]+ " hivatkozott: "+ res[i][3]);
            }
            //System.out.println("data: "+data[d]);
            for(int i=0; i<3; i++){//benne van
                if(res[i][1]==data[d]){
                    str+='-';
                    bennevan=true;
                    res[i][3]=1;
                    break;
                }
            }

            boolean fut=true;
            if(!bennevan){
                while(fut){
                    for(int i=(idx%3); i<3; i++){//szabad helyre rakás
                        System.out.println("data: "+data[d] +"num: "+ i+ " mi van benne: " + res[i][1]+ " miota: "+ res[i][2]+ " hivatkozott: "+ res[i][3]);
                        idx=0;
                        if(res[0][2]<4 && res[1][2]<4 && res[2][2]<4 && res[0][2]>0 && res[1][2]>0 && res[2][2]>0) {
                            str+='*';
                            counter++;
                            fut=false;
                            idx=i;
                            break;
                        }

                        if((res[i][0]==0 || res[i][2]>3) && res[i][3]==0){//belerakás
                            str+=(char)('A'+i);
                            counter++;
                            res[i][0]=1;
                            res[i][2]=0;
                            //res[i][3]=0;
                            res[i][1]=data[d];
                            fut=false;
                            idx=i;
                            break;
                        }
                        //System.out.println(i);
                        res[i][3]=0;
                    }
                }
                fut=true;
            }

            for(int i=0; i<3; i++){//mióta növelése
                if(res[i][1]!=0){
                    res[i][2]++;
                    //System.out.println("melyik: "+i + "miota: "+res[i][2]);
                }
            }

            bennevan=false;
            System.out.println();
        }

        System.out.println(str);
        System.out.println(counter);

    }
}
