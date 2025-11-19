package sample;

public class RandSlova {
    static String[] slova;
        public static void setSlova(String[] slova) {
            RandSlova.slova=slova;
        }

        static String randslov(int length){
            String text="";
            for(int i=0;i<length;i++){
                int rand=(int)(Math.random()*(slova.length-1));
                text+=slova[rand];
            }
            return text;
        }
}
