import java.util.*;

//1)take in input
//2)create generation of random strings using allowed character set
//3)go through each string, and compare amount of correctly placed characters vs
//  actual string as percentage
//4)take two highest percentage strings as parents
//5)generate new generation using parents genes (make sure first children are exact copies of parents)
//6)For each generated child, give mutation chance and possibility of mutation
//   * if random roll is less than mutChance, cause random mutation, changing one random letter to 
//     random letter from accepted letter pool
//7)print highest percentage child from gene pool
//8)repeat

//make it so that the model only guesses against a percentage given back to it for fitness
//possible edge cases: inputting of odd numbers
//Later: add functionality for more parents

public class EvolutionaryModel {
    final String validChars = "abcdefghifklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!?-,'.; ";

    public void evolutionaryModel(String m, int genSize, double mutChance){
        String[] genePool = new String[genSize];
        String parent1 = "";
        double p1m = 0;
        String parent2 = "";
        double p2m = 0;
        StringBuilder b = new StringBuilder(m.length());
        Random r = new Random();

        //Generate first generation
        for(int i = 0; i < genePool.length; i++){
            b.setLength(0);
            for(int j = 0; j < m.length(); j++){
                b.append(validChars.charAt(r.nextInt(validChars.length())));
            }
            genePool[i] = b.toString();
        }

        while (p1m < 100.00){
            //choose parents
            for(int i = 0; i < genePool.length; i++){
                int cc = 0;
                for(int j = 0; j < genePool[i].length(); j++){
                    if(m.charAt(j) == genePool[i].charAt(j)){
                        cc++;
                    }
                }
                double closeness = ((double) cc / m.length()) * 100;
                if (closeness > p1m){
                    parent1 = genePool[i];
                    p1m = closeness;
                }
                else if(closeness > p2m){
                    parent2 = genePool[i];
                    p2m = closeness;
                }
            }

            //generate new generation
            if(genePool.length > 6){
                genePool[0] = parent1;
                genePool[1] = parent2;
                genePool[2] = mutate(parent1);
                genePool[3] = mutate(parent2);
                for(int i = 4; i < genePool.length/2; i++){
                    int splice = r.nextInt(m.length());
                    genePool[i] = parent1.substring(0, splice) + parent2.substring(splice, parent2.length());
                    double mc = r.nextDouble(mutChance);
                    genePool[i] = mc < mutChance ? mutate(genePool[i]) : genePool[i];
                }
                for(int i = genePool.length/2; i < genePool.length; i++){
                    int splice = r.nextInt(m.length());
                    genePool[i] = parent2.substring(0, splice) + parent1.substring(splice, parent1.length());
                    double mc = r.nextDouble(mutChance);
                    genePool[i] = mc < mutChance ? mutate(genePool[i]) : genePool[i];
                }
            }
            else{
                throw new IllegalArgumentException();
            }
            System.out.println(parent1 + ":" + p1m);
        }
    }
    private String mutate(String m){
        StringBuilder coder = new StringBuilder(m.length());
        Random r = new Random();
        String[] map = m.split("");
        map[r.nextInt(map.length)] = String.valueOf(validChars.charAt(r.nextInt(validChars.length())));
        for(int i = 0; i < map.length; i++){
            coder.append(map[i]);
        }
        return coder.toString();
    }    
}
