package sample;
public class Shifr {
    String [][]map;
    Shifr(String alfavit) {
        String[] alf = alfavit.split("");
        map = new String[alf.length][alf.length];
        for (int u = 0; u < alf.length; u++) {
            map[u]=alf;
           alf=razmen(alf);
           for(int i=0;i<alf.length;i++){
               System.out.print(map[u][i]);
           }
            System.out.println();
        }
    }
    private String[] razmen (String[] men){
        String[] text=new String[men.length];
        text[men.length-1]=men[0];
        for(int i=0;i<men.length-1;i++){
            text[i]=men[i+1];
        }
        return text;
    }
    public String shifra(String[] Text,String[] key){
        key=key(Text.length,key);
        String text="";
        for (int u=0;u< Text.length;u++) {
            int n=search(Text[u]);
            if(n==-1){
                text=text+Text[u];
            }else {
                text = text + map[search(key[u], 0)][n];
            }
        }
        return text;
    }
    public String rashifra(String[] Text,String[] key){
        key=key(Text.length,key);
        String text="";
        for (int u=0;u< Text.length;u++) {
                text = text + poisk(Text[u], search(key[u]));
        }
        return text;
    }

    private int search(String simvol){
        int simv=-1;
        for(int i=0;i< map.length;i++){
            if(simvol.equals(map[0][i])){
                simv=i;
                return simv;
            }
        }
        return simv;
    }
    private int search(String simvol,int mass){
        int simv=-1;
        for(int i=0;i< map.length;i++){
            if(simvol.equals(map[i][mass])){
                simv=i;
                return simv;
            }
        }
        return simv;
    }
    private String[] key(int lengthText,String[] key){
            String[]oldkey=new String[lengthText];
            int count=0;
            for(int i=0;i<lengthText;i++){
                if(count>key.length-1){
                 count=0;
                }
                oldkey[i]=key[count];
                count++;
                System.out.println(oldkey[i]);
            }
            return oldkey;
    }
    private String poisk(String Text,int n){
        String simv=Text;
        for(int i=0;i<map.length;i++){
            if(map[i][n].equals(Text)){
                return map[i][0];
            }
        }
        return simv;
    }
}
