package sample;

public class CryptoGraph {
    private static String InputText;
    private static String[][] alfavit;

    public static void alphavit(String text){
        text+="21453689?70!@#$%^&*()_+-.[]:, ";
        String[]tex=text.split("");
        alfavit=new String[tex.length][1];
        for(int i=0;i< tex.length;i++){
            String timeTex=tex[i];
            alfavit[i][0]=timeTex;
        }
    }
    public static String shifrovka(String text,int falshL,int falshR){
        String[]tex=text.split("");
        String out="";
        String Left="-";
        String Right="";
        for(int i=0;i<falshL;i++){
            int r=(int)(Math.random()*(alfavit.length-1));
            Left=Left+alfavit[(int)(Math.random()*(alfavit.length-1))][0].split("")[0];
        }
        for(int i=0;i<falshR;i++){
            int r=(int)(Math.random()*(alfavit.length-1));
            Right=Right+alfavit[alfavit.length-1-(int)(Math.random()*(alfavit.length-1))][0].split("")[0];
        }
        for (int u=0;u<tex.length;u++) {
            boolean simv=false;
            for (int i =0; i < alfavit.length; i++) {
//большие буквы
                if (tex[u].equals(alfavit[i][0].split("")[0])){
                    out=out+alfavit[alfavit.length-1-i][0].split("")[0];
                    simv=true;
                }

            }
            if(simv==false){
                out=out+tex[u];
            }
        }
        return Left+out+Right;
    }
    public static String rashifrovka(String text,int falshL,int falshR){
        String[] tex=text.split("");
        String out="";
        for(int i=falshL+1;i< tex.length-falshR;i++){
           out=out+tex[i];
        }
        tex=out.split("");
        out="";
        for (int u=0;u<tex.length;u++) {
            boolean simv=false;
            for (int i =0; i < alfavit.length; i++) {
//большие буквы
                if (tex[u].equals(alfavit[alfavit.length-1-i][0].split("")[0])){
                    out=out+alfavit[i][0].split("")[0];
                    simv=true;
                }

            }
            if(simv==false){
                out=out+tex[u];
            }
        }

        return out;
    }

    }

